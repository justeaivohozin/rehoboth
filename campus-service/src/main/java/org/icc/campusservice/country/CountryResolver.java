package org.icc.campusservice.country;

import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountryResolver {

    private final CountryRepository countryRepository;

    @ObjectFactory
    public Country resolve(Long countryId, @TargetType Class<Country> country) {
        return countryId != null
                ? countryRepository.findById(countryId).orElseThrow(EntityExistsException::new)
                : null;
    }
}
