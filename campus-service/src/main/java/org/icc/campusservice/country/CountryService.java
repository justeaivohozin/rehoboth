package org.icc.campusservice.country;

import org.icc.campusservice.common.PageResponse;

/**
 * Manage all operations for Countries
 */
public interface CountryService {
    /**
     * Get all countries matching required condition
     * Should pass predicate and page
     *
     * @param name      country name
     * @param continent country continent
     * @param page      page requested
     * @param size      number of elements requested within the page
     * @return a list of country
     */

    PageResponse getCountries(String name, String continent, int page, int size);

    /**
     * Get a country with the provided id
     *
     * @param id country technical identifier
     * @return Optional country
     */
    CountryResponse getCountryById(Long id);

    /**
     * Get a country with the provided name
     *
     * @param name country provided name
     * @return an Optional<Country>
     */
    CountryResponse getCountryByName(String name);

    /**
     * Save country
     *
     * @param country country
     * @return country
     */
    CountryResponse saveCountry(CountryDto country);

    /**
     * Delete country
     *
     * @param country country
     */
    void deleteCountry(Country country);

    /**
     * Update country with the provided Identifier
     *
     * @param id         country to update identifier
     * @param countryDto country To update information
     * @return country response
     */
    CountryResponse updateCountry(Long id, CountryDto countryDto);
}
