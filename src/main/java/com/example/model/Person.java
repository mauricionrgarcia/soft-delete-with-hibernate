package com.example.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * Entity to mapping TB_PEOPLE<br>
 * Extract the auth to abstract entity
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 19/02/2018 22:05:29
 */
@Entity
@Table(name = "TB_PEOPLE")
public class Person implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5076342277118584038L;

	@Id
	@Column(name = "PK_PERSON")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;

	@OneToOne(mappedBy = "person")
	private Contact contact;

	@Size(max = 50, min = 4)
	@Column(name = "TX_NAME", length = 50, nullable = false)
	private String name;

	@Column(name = "DT_BIRTH")
	private LocalDate dtBirth;

	@Column(name = "ID_GENRE")
	@Enumerated(EnumType.STRING)
	@NotNull
	private GenreEnum genre;

	@Column(name = "ID_ACTIVE")
	private String active;

	@Column(name = "DT_LAST_CHANGE")
	@LastModifiedDate
	private LocalDateTime dtLastChange;

	@Column(name = "ID_USER")
	@LastModifiedBy
	private Long userChange;

	/**
	 * @param code
	 */
	public Person(Long code) {
		super();
		this.code = code;
	}

	/**
	 * no args
	 */
	public Person() {
		super();
	}

	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Long code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dtBirth
	 */
	public LocalDate getDtBirth() {
		return dtBirth;
	}

	/**
	 * @param dtBirth the dtBirth to set
	 */
	public void setDtBirth(LocalDate dtBirth) {
		this.dtBirth = dtBirth;
	}

	/**
	 * @return the genre
	 */
	public GenreEnum getGenre() {
		return genre;
	}

	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(GenreEnum genre) {
		this.genre = genre;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/**
	 * @return the dtLastChange
	 */
	public LocalDateTime getDtLastChange() {
		return dtLastChange;
	}

	/**
	 * @param dtLastChange the dtLastChange to set
	 */
	public void setDtLastChange(LocalDateTime dtLastChange) {
		this.dtLastChange = dtLastChange;
	}

	/**
	 * @return the userChange
	 */
	public Long getUserChange() {
		return userChange;
	}

	/**
	 * @param userChange the userChange to set
	 */
	public void setUserChange(Long userChange) {
		this.userChange = userChange;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

}
