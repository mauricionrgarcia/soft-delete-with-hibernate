package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.ListUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Email;

/**
 * Repository {@link Email}
 * 
 * @author <a href="mailto:mauricionrgarcia@gmailcom">Mauricio Garcia</a>
 * @version
 * @sinse 11/03/2018 23:12:51
 */
@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
	/**
	 * @param code: code identifier
	 * @return {@link Optional} {@link Email}
	 */
	Optional<Email> findByCode(Long code);

	@Override
	default void deleteInBatch(Iterable<Email> arg0) {

		final List<List<Email>> partitions = ListUtils.partition((List<Email>) arg0, 999);
		for (List<Email> partition : partitions) {
			deleteEmails(partition);
		}
	}

	@Modifying(clearAutomatically = true)
	@Query("update Email email set email.active = 'N' where email in (?1)")
	void deleteEmails(List<Email> emails);

}
