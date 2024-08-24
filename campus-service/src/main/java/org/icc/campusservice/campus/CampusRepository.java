package org.icc.campusservice.campus;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampusRepository extends JpaRepository<Campus, Long> {

    List<Campus> findByCampusNameContainsAndTown_TownNameContains(String campusName, String townName, Pageable page);

    Long countByCampusNameAndTown_TownName(String campusName, String townName);

    Long countByCampusNameContainsOrTown_TownNameContains(String campusName, String townName);

    List<Campus> findByCampusNameContains(String campusName);

}
