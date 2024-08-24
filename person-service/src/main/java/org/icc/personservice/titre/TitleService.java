package org.icc.personservice.titre;

import org.icc.personservice.common.PageResponse;

/**
 * Titles Services
 * Handle Title Management
 */
public interface TitleService {

    TitleResponse addNewTitle(TitleDto titleDto);

    PageResponse getTitles(String titleName, int page, int size);

    TitleResponse getTitle(Long id);

    TitleResponse updateTitle(Long id, TitleDto titleDto);

    void deleteTitle(Long id);
}
