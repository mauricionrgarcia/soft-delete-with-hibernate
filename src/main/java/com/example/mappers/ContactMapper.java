package com.example.mappers;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.dto.ContactDTO;
import com.example.model.Contact;

/**
 * Simple map to entity/DTO {@link Contact}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 11/03/2018 20:23:05
 */
@Mapper(componentModel = "spring", uses = { EmailMapper.class, PhoneMapper.class, PersonMapper.class })
public interface ContactMapper {

	/**
	 * convert Contact enity to {@link ContactDTO} ignore Address
	 * 
	 * @param Contact entity
	 * @return dto
	 */
	@Mappings({ @Mapping(target = "person", ignore = true) })
	ContactDTO toDTO(Contact Contact);

	/**
	 * convert list Contact entity to list {@link ContactDTO}
	 * 
	 * @param Contact entities
	 * @return dtos
	 */
	@IterableMapping(qualifiedByName = "toDto")
	List<ContactDTO> entitiesToDTOs(List<Contact> contact);

}