package org.icc.personservice.person;

import org.icc.personservice.contact.ContactMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {ContactMapper.class})
public interface PersonMapper {

    PersonResponse toResponse(Person person);

    Person toPerson(PersonDto personDto);

    void updatePerson(PersonDto personDto, @MappingTarget Person person);

}
