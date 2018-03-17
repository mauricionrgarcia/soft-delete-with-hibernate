package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Soft delete with Hibernate.
 * 
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio Garcia</a>
 * @version
 * @sinse 11/03/2018 20:31:15
 */
@SpringBootApplication
public class SoftDeleteHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftDeleteHibernateApplication.class, args);
	}
}
