package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Contact;

/**
 * Repository {@link Contact}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmailcom">Mauricio Garcia</a>
 * @version
 * @sinse 11/03/2018 23:30:10
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	/**
	 * @param code: code identifier
	 * @return {@link Optional} {@link Contact}
	 */
	Optional<Contact> findByCode(Long code);
}
