package org.icc.campusservice.campus;

import lombok.RequiredArgsConstructor;
import org.icc.campusservice.common.PageResponse;
import org.icc.campusservice.common.clients.PersonRestClient;
import org.icc.campusservice.common.exception.custom.ResourceNotFoundException;
import org.icc.campusservice.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class CampusServiceImpl implements CampusService {

    private final CampusRepository campusRepository;
    private final CampusMapper campusMapper;
    private final PersonRestClient personRestClient;
    private Logger LOG = LoggerFactory.getLogger(CampusServiceImpl.class);

    @Override
    public PageResponse getAllCampus(String campusName, String townName, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        LOG.info("Get all campus matching the provided parameters campus name = {}, town name = {}", campusName, townName);
        List<Campus> campusList = campusRepository.findByCampusNameContainsAndTown_TownNameContains(campusName, townName, pageable);
        campusList.forEach(campus -> campus.setCampusResponsible(personRestClient.findPersonById(campus.getCampusResponsibleId())));
        List<CampusResponse> campusResponseList = campusList.stream().map(campusMapper::toResponse).toList();
        return PageResponse.builder()
                .elements(campusResponseList)
                .elementCount(campusRepository.countByCampusNameContainsOrTown_TownNameContains(campusName, townName))
                .build();
    }

    @Override
    public CampusResponse getCampusById(Long id) {
        LOG.info("Get campus matching the provided identifier  = {}", id);
        Campus campus = campusRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Le campus que vous demander, n'existe pas."
        ));
        Person person = personRestClient.findPersonById(campus.getCampusResponsibleId());
        campus.setCampusResponsible(person);
        return campusMapper.toResponse(campus);
    }

    @Override
    public CampusResponse addCampus(CampusDto campusDto) {
        LOG.info("Save campus with name = {}", campusDto.getCampusName());
        Campus campus = campusMapper.toEntity(campusDto);
        campus = campusRepository.save(campus);
        return campusMapper.toResponse(campus);
    }

    private Person getPersonById(Long id) {
        if (id == null) {
            return null;
        }
        return personRestClient.findPersonById(id);
    }

    @Override
    public CampusResponse updateCampus(Long id, CampusDto campusDto) {
        LOG.info("Update campus matching the provided identifier  = {}", id);
        return campusRepository.findById(id).map(campus -> {
            campusMapper.updateCampus(campusDto, campus);
            campus = campusRepository.save(campus);
            Person person = personRestClient.findPersonById(campus.getCampusResponsibleId());
            campus.setCampusResponsible(person);
            return campusMapper.toResponse(campus);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "La campus que vous essayez de modifier n'existe pas"
        ));
    }

    @Override
    public void deleteCampus(Long id) {
        LOG.info("Delete campus matching the provided identifier  = {}", id);
        Campus campus = campusRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nous n'avons pas trouvé le campus que vous souhaitez supprimé"));
        campusRepository.delete(campus);
    }

    @Override
    public CampusResponse addResponsibleToCampus(Long id, Person person) {
        Campus campus = campusRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nous n'avons pas trouvé le campus que vous souhaitez supprimé"));
        Person personFromService = getPersonById(person.getPersonId());
        if (!campus.getCampusId().equals(person.getPersonCampusId())) {
            throw new ResourceNotFoundException("Vous ne pourrez pas ajouter ce responsable. Il n'est pas de ce campus. Changez le campus d ela personne qu vous désirez ajouter ou ajouter une autre personne.");
        }
        campus.setCampusResponsibleId(person.getPersonId());
        campus = campusRepository.save(campus);
        campus.setCampusResponsible(personFromService);
        return campusMapper.toResponse(campus);
    }

    @Override
    public List<CampusResponse> getCampusWithName(String name) {
        return campusRepository.findByCampusNameContains(name).stream()
                .map(campusMapper::toResponse).toList();
    }

}
