package org.icc.personservice.titre;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {

    List<Title> findByTitleNameContains(String titleName, Pageable pageable);

    Long countByTitleNameContains(String titleName);
}
