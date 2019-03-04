package com.stickynote.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the targetuser database table.
 * 
 */
@Entity
public class Targetuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="est_completion_date")
	private Date estCompletionDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date finishdate;

	private byte finnish;

	private String target;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="iduser")
	private User user;

	public Targetuser() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEstCompletionDate() {
		return this.estCompletionDate;
	}

	public void setEstCompletionDate(Date estCompletionDate) {
		this.estCompletionDate = estCompletionDate;
	}

	public Date getFinishdate() {
		return this.finishdate;
	}

	public void setFinishdate(Date finishdate) {
		this.finishdate = finishdate;
	}

	public byte getFinnish() {
		return this.finnish;
	}

	public void setFinnish(byte finnish) {
		this.finnish = finnish;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}