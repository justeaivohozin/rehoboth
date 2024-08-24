package org.icc.campusservice.town;

import lombok.RequiredArgsConstructor;
import org.icc.campusservice.common.PageResponse;
import org.icc.campusservice.common.exception.custom.ResourceNotFoundException;
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
public class TownServiceImpl implements TownService {

    private static final Logger log = LoggerFactory.getLogger(TownServiceImpl.class);
    private final TownRepository townRepository;
    private final TownMapper townMapper;
    private Logger LOG = LoggerFactory.getLogger(TownServiceImpl.class);

    @Override
    public PageResponse getTowns(String townName, String countryName, int page, int size) {
        Pageable paging = PageRequest.of(page - 1, size);
        List<Town> towns = townRepository.findByTownNameContainsAndCountry_CountryNameContains(townName, countryName, paging);
        List<TownResponse> townResponses = towns.stream().map(townMapper::toResponse).toList();

        Long townCount = townRepository.countByTownNameContainsAndCountry_CountryNameContains(townName, countryName);
        return PageResponse.builder()
                .elements(townResponses)
                .elementCount(townCount)
                .build();
    }

    @Override
    public TownResponse getTownByName(String townName) {
        Town town = townRepository.findByTownName(townName).orElseThrow(() -> new ResourceNotFoundException("Requested Town with town name =" + townName + " not found."));
        return townMapper.toResponse(town);
    }

    @Override
    public TownResponse getByTownById(Long id) {
        Town town = townRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Requested Town with id = " + id + " not found."));
        return townMapper.toResponse(town);
    }

    @Override
    public TownResponse saveTown(TownDto townDto) {
        Town town = townMapper.toTown(townDto);
        town = townRepository.save(town);
        return townMapper.toResponse(town);
    }

    @Override
    public void deleteTown(Long id) {
        Town town = townRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vous essayer de supprimer une ville qui n'existe pas."));
        townRepository.delete(town);
    }

    @Override
    public TownResponse updateTown(Long id, TownDto townDto) {
        return townRepository.findById(id).map(town -> {
            townMapper.updateTown(townDto, town);
            Town townMapped = townRepository.save(town);
            return townMapper.toResponse(townMapped);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Vous essayer de mettre à jour une ville id = " + id + " qui n'existe pas.")
        );

    }


}
