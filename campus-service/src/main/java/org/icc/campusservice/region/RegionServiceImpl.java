package org.icc.campusservice.region;

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
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;
    private Logger LOG = LoggerFactory.getLogger(RegionServiceImpl.class);

    @Override
    public PageResponse getAllRegions(String regionName, int page, int size) {
        Pageable pageRequest = PageRequest.of(page - 1, size);
        List<Region> regions = regionRepository.findByRegionNameContains(regionName, pageRequest);
        List<RegionResponse> regionResponses = regions.stream().map(regionMapper::toResponse).collect(Collectors.toList());
        Long countResponse = regionRepository.countByRegionNameContains(regionName);
        return PageResponse.builder()
                .elements(regionResponses)
                .elementCount(countResponse)
                .build();
    }

    @Override
    public RegionResponse getRegionById(Long id) {
        return regionRepository.findById(id)
                .map((regionMapper::toResponse))
                .orElseThrow(() -> new ResourceNotFoundException("Bous n'avons pas trouvé la région que vous demandez."));
    }

    @Override
    public RegionResponse updateRegion(Long id, RegionDto regionDto) {
        return regionRepository.findById(id).map(region -> {
            regionMapper.updateRegion(regionDto, region);
            Region updatedRegion = regionRepository.save(region);
            return regionMapper.toResponse(updatedRegion);
        }).orElseThrow(() -> new ResourceNotFoundException("Vous essayez de mettre à jour une région id = " + id + "qui n'existe pas."));
    }

    @Override
    public RegionResponse saveRegion(RegionDto regionDto) {
        Region region = regionMapper.toRegion(regionDto);
        region = regionRepository.save(region);
        return regionMapper.toResponse(region);
    }

    @Override
    public void deleteRegion(Long id) {
        Region region = regionRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vous essayez de supprimer une région qui n'existe pas"));
        regionRepository.delete(region);
    }
}
