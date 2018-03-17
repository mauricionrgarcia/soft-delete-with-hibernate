package com.example.mappers;

import org.mapstruct.Mapper;

import com.example.dto.PersonDTO;
import com.example.model.TypeAddress;

/**
 * Simple map to entity/DTO {@link TypeAddress}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 03/03/2018 16:54:49
 * @sinse 03/03/2018 16:40:12
 */
@Mapper(componentModel = "spring")
public interface TypeAddressMapper {

	/**
	 * convert person enity to {@link PersonDTO} ignore Address
	 * 
	 * @param person entity
	 * @return dto
	 */
	String toDTO(TypeAddress type);
}