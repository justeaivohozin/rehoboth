package org.icc.personservice.titre;

import lombok.RequiredArgsConstructor;
import org.icc.personservice.common.PageResponse;
import org.icc.personservice.common.exception.custom.ResourceNotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TitleServiceImpl implements TitleService {

    private final TitleRepository titleRepository;

    private final TitleMapper titleMapper;

    @Override
    public TitleResponse addNewTitle(TitleDto titleDto) {
        return titleMapper.toResponse(
                titleRepository.save(titleMapper.toTitle(titleDto))
        );
    }

    @Override
    public PageResponse getTitles(String titleName, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        List<Title> titles = titleRepository.findByTitleNameContains(titleName, pageable);
        return PageResponse
                .builder()
                .elements(titles.stream().map(titleMapper::toResponse).toList())
                .elementCount(titleRepository.countByTitleNameContains(titleName))
                .build();
    }

    @Override
    public TitleResponse getTitle(Long id) {
        return titleRepository.findById(id).map(titleMapper::toResponse).orElseThrow(() -> new ResourceNotFoundException(
                "Le titre que vous essayez de récupérer n'existe pas."
        ));

    }

    @Override
    public TitleResponse updateTitle(Long id, TitleDto titleDto) {
        return titleRepository.findById(id).map(title -> {
            titleMapper.updateTitle(titleDto, title);
            title = titleRepository.save(title);
            return titleMapper.toResponse(title);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Le titre que vous souhaitez mettre à jour n'existe pas"
        ));
    }

    @Override
    public void deleteTitle(Long id) {
        Title title = titleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Le titre que vous essayez de supprimer n'existe pas."
        ));
        titleRepository.delete(title);
    }
}
