package org.icc.personservice.contact;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact toContact(ContactDto contactDto);

    ContactResponse toResponse(Contact contact);
}
