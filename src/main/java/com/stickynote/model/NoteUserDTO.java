package com.stickynote.model;

import java.util.Date;

import com.stickynote.entity.User;

public class NoteUserDTO {

	private int id;

	private byte isnoice;

	private int idUser;

	private Date finishdate;

	private Date createdate;
	
	private String note;
	
	private User user;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getIsnoice() {
		return isnoice;
	}

	public void setIsnoice(byte isnoice) {
		this.isnoice = isnoice;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Date getFinishdate() {
		return finishdate;
	}

	public void setFinishdate(Date finishdate) {
		this.finishdate = finishdate;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
