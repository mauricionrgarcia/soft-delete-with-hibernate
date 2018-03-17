package com.example;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.Contact;
import com.example.model.Email;
import com.example.repository.ContactRepository;
import com.example.repository.EmailRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SoftDeleteHibernateApplicationTests {

	@Autowired
	private transient EmailRepository emailRepository;

	@Autowired
	private transient ContactRepository contatoRepository;

	@Before
	public void save() {
		Contact contact = new Contact();
		contact.setActive("Y");
		Email email = new Email();
		email.setContact(contact);
		email.setEmail("email1@email.com");
		Email email2 = new Email();
		email2.setContact(contact);
		email2.setEmail("email2@email.com");
		List<Email> emails = java.util.Arrays.asList(email, email2);
		contact.setEmails(emails);

		contatoRepository.save(contact);
	}

	@Test
	public void delete() {

		List<Contact> emails = contatoRepository.findAll();

		emails.forEach(e -> {
			System.out.println("Delete: " + e);
			contatoRepository.delete(e);
		});
	}

	@Test
	@org.springframework.transaction.annotation.Transactional
	public void deteleInBatche() {

		List<Email> emails = new ArrayList<>();
		for (int i = 0; i < 1002; i++) {
			Email email = new Email();
			email.setEmail(i + "@email.com");
			emails.add(email);
		}

		emails = emailRepository.saveAll(emails);
		emailRepository.deleteInBatch(emails);
	}

}
