package org.icc.campusservice.region;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
    List<Region> findByRegionNameContains(String regionName, Pageable pageRequest);

    Long countByRegionNameContains(String regionName);
}
