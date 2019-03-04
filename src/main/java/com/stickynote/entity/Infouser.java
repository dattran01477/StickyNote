package com.stickynote.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the infouser database table.
 * 
 */
@Entity
public class Infouser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int iduser;

	private String address;

	private int age;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	private String numberphone;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="iduser")
	private User user;

	public Infouser() {
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getNumberphone() {
		return this.numberphone;
	}

	public void setNumberphone(String numberphone) {
		this.numberphone = numberphone;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}