package org.icc.campusservice.region;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegionResolver {

    private final RegionRepository regionRepository;

    @ObjectFactory
    public Region resolve(Long regionId, @TargetType Class<Region> region) {
        return regionId != null
                ? regionRepository.findById(regionId).orElseThrow(EntityExistsException::new)
                : null;
    }
}
