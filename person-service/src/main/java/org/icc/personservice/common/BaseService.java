package org.icc.personservice.common;

import lombok.RequiredArgsConstructor;
import org.icc.personservice.person.PersonService;
import org.icc.personservice.titre.TitleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("person-service")
public abstract class BaseService {
    protected final PersonService personService;
    protected final TitleService titleService;

}
