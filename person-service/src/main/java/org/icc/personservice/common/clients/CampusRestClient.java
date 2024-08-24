package org.icc.personservice.common.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.icc.personservice.model.Campus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "CAMPUS-SERVICE")
public interface CampusRestClient {

    @GetMapping("/campuses/campus/{id}")
    @CircuitBreaker(name = "campusService", fallbackMethod = "getDefaultCampus")
    Campus findByCampusId(@PathVariable(name = "id") Long id);

    @GetMapping("campuses/campus/with-name")
    @CircuitBreaker(name = "campusService", fallbackMethod = "getAllCampus")
    List<Campus> findByCampusName(@RequestParam(name = "campusName") String name);

    default Campus getDefaultCampus(Long id, Exception exception) {
        Campus campus = new Campus();
        campus.setCampusId(id);
        campus.setCampusName("Not Found");
        return campus;
    }

    default List<Campus> getAllCampus(Exception exception) {
        return List.of();
    }

}
