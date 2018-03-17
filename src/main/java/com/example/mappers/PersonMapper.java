package com.example.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.example.dto.PersonDTO;
import com.example.model.Person;

/**
 * Simple map to entity/DTO {@link Person}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 02/03/2018 00:00:44
 */
@Mapper(componentModel = "spring", uses = { ContactMapper.class })
public interface PersonMapper {

	/**
	 * convert person enity to {@link PersonDTO}
	 * 
	 * @param person entity
	 * @return dto
	 */
	@Mappings({ @Mapping(target = "user", source = "userChange") })
	PersonDTO toDTO(Person person);

	/**
	 * convert person dto {@link Person}
	 * 
	 * @param person entity
	 * @return dto
	 */
	@InheritInverseConfiguration
	@Mapping(target = "contact", ignore = true)
	Person toPerson(PersonDTO person);

	/**
	 * convert list person enity to list {@link PersonDTO}
	 * 
	 * @param person entities
	 * @return dtos
	 */
	List<PersonDTO> entitiesToDTOs(List<Person> people);

}