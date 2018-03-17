package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity to define the specific type of {@link Address}<br>
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 02/03/2018 23:53:50
 */
@Entity
@Table(name = "TB_TYPE_ADDRESS")
public class TypeAddress implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7818867141894929767L;

	/**
	 * identifier
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_TYPE")
	private Long code;

	/**
	 * street
	 */
	@Column(name = "TX_NAME")
	private String typeName;

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
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TypeAddress [code=" + code + ", typeName=" + typeName + "]";
	}

}
