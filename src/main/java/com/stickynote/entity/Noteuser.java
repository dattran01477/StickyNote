package com.stickynote.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the noteuser database table.
 * 
 */
@Entity
@NamedQuery(name="Noteuser.findAll", query="SELECT n FROM Noteuser n")
public class Noteuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date finishdate;

	private byte isnoice;

	@Temporal(TemporalType.TIMESTAMP)
	private Date noicedate;

	private String note;

	private String title;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="iduser")
	private User user;

	public Noteuser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getFinishdate() {
		return this.finishdate;
	}

	public void setFinishdate(Date finishdate) {
		this.finishdate = finishdate;
	}

	public byte getIsnoice() {
		return this.isnoice;
	}

	public void setIsnoice(byte isnoice) {
		this.isnoice = isnoice;
	}

	public Date getNoicedate() {
		return this.noicedate;
	}

	public void setNoicedate(Date noicedate) {
		this.noicedate = noicedate;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}