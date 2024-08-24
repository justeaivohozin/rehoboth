package org.icc.campusservice.country;

import lombok.RequiredArgsConstructor;
import org.icc.campusservice.common.PageResponse;
import org.icc.campusservice.common.exception.custom.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private static final Logger LOG = LoggerFactory.getLogger(CountryServiceImpl.class);

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;


    @Override
    public PageResponse getCountries(String name, String continent, int page, int size) {
        LOG.info("Get list of countries with provided filter name = {}, continent = {}", name, continent);
        Pageable paging = PageRequest.of(page - 1, size);
        List<Country> countries;
        Long elementCount;
        if (continent == null || continent.isEmpty()) {
            countries = countryRepository.findByCountryNameContains(name, paging);
            elementCount = countryRepository.countByCountryNameContains(name);
        } else {
            Continent continentEnum = Continent.valueOf(continent);
            countries = countryRepository.findByCountryNameContainsOrContinent(name, continentEnum, paging);
            elementCount = countryRepository.countByCountryNameContainsAndContinent(name, continentEnum);
        }

        return PageResponse.builder()
                .elements(countryMapper.toResponse(countries))
                .elementCount(elementCount).build();
    }

    @Override
    public CountryResponse getCountryById(Long id) {
        LOG.info("Get a country with provided identifier = {}", id);
        Optional<Country> country = countryRepository.findById(id);
        if (country.isPresent()) {
            return countryMapper.toResponse(country.get());
        } else {
            LOG.info("There is no country with the provided identifier = {}", id);
            throw new ResourceNotFoundException("Le pays avec l'idendifiant id = " + id + " n'existe pas");
        }

    }

    @Override
    public CountryResponse getCountryByName(String name) {
        LOG.info("Get a country with provided name = {}", name);
        Optional<Country> country = countryRepository.findByCountryName(name);
        if (country.isPresent()) {
            return countryMapper.toResponse(country.get());
        } else {
            LOG.info("There is no country with the provided name = {}", name);
            throw new ResourceNotFoundException("Le pays avec le nom = " + name + " n'existe pas");
        }
    }

    @Override
    public CountryResponse saveCountry(CountryDto countryDto) {
        LOG.info("Save a new country = {}", countryDto);
        Country country = countryMapper.toEntity(countryDto);
        country = countryRepository.save(country);
        return countryMapper.toResponse(country);
    }

    @Override
    public void deleteCountry(Country country) {
        countryRepository.delete(country);
    }

    @Override
    public CountryResponse updateCountry(Long id, CountryDto countryDto) {
        return countryRepository.findById(id).map(country -> {
            countryMapper.updateCountry(countryDto, country);
            country.setUpdatedAt(LocalDateTime.now());
            country.setUpdatedBy("Jaivohozin");
            Country savedCountry = countryRepository.save(country);
            return countryMapper.toResponse(savedCountry);
        }).orElseThrow(
                () -> new ResourceNotFoundException("Nous ne retrouvons pas le pays que vous essayez de modifier.")
        );
    }
}
