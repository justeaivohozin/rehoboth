package org.icc.campusservice.town;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TownResolver {

    private final TownRepository townRepository;

    @ObjectFactory
    public Town resolve(Long id, @TargetType Class<Town> town) {
        return id != null
                ? townRepository.findById(id).orElseThrow(EntityExistsException::new)
                : null;
    }
}
