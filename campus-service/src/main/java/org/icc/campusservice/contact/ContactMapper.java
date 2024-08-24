package org.icc.campusservice.contact;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact toContact(ContactDto contactDto);

    @Mapping(target = "campusName", source = "contact.campus.campusName")
    ContactResponse toResponse(Contact contact);
}
