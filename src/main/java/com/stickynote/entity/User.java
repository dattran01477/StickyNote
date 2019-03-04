package com.stickynote.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity(name="User")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte active;

	@Temporal(TemporalType.TIMESTAMP)
	private Date embarkdate;

	private String password;

	private String username;

	//bi-directional many-to-one association to Expense
	@OneToMany(mappedBy="user")
	private List<Expense> expenses;

	//bi-directional many-to-one association to Expensemonth
	@OneToMany(mappedBy="user")
	private List<Expensemonth> expensemonths;

	//bi-directional one-to-one association to Infouser
	@OneToOne(mappedBy="user")
	private Infouser infouser;

	//bi-directional many-to-one association to Noteuser
	@OneToMany(mappedBy="user")
	private List<Noteuser> noteusers;

	//bi-directional many-to-one association to Targetuser
	@OneToMany(mappedBy="user")
	private List<Targetuser> targetusers;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="idrole")
	private Role role;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Date getEmbarkdate() {
		return this.embarkdate;
	}

	public void setEmbarkdate(Date embarkdate) {
		this.embarkdate = embarkdate;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public Expense addExpens(Expense expens) {
		getExpenses().add(expens);
		expens.setUser(this);

		return expens;
	}

	public Expense removeExpens(Expense expens) {
		getExpenses().remove(expens);
		expens.setUser(null);

		return expens;
	}

	public List<Expensemonth> getExpensemonths() {
		return this.expensemonths;
	}

	public void setExpensemonths(List<Expensemonth> expensemonths) {
		this.expensemonths = expensemonths;
	}

	public Expensemonth addExpensemonth(Expensemonth expensemonth) {
		getExpensemonths().add(expensemonth);
		expensemonth.setUser(this);

		return expensemonth;
	}

	public Expensemonth removeExpensemonth(Expensemonth expensemonth) {
		getExpensemonths().remove(expensemonth);
		expensemonth.setUser(null);

		return expensemonth;
	}

	public Infouser getInfouser() {
		return this.infouser;
	}

	public void setInfouser(Infouser infouser) {
		this.infouser = infouser;
	}

	public List<Noteuser> getNoteusers() {
		return this.noteusers;
	}

	public void setNoteusers(List<Noteuser> noteusers) {
		this.noteusers = noteusers;
	}

	public Noteuser addNoteuser(Noteuser noteuser) {
		getNoteusers().add(noteuser);
		noteuser.setUser(this);

		return noteuser;
	}

	public Noteuser removeNoteuser(Noteuser noteuser) {
		getNoteusers().remove(noteuser);
		noteuser.setUser(null);

		return noteuser;
	}

	public List<Targetuser> getTargetusers() {
		return this.targetusers;
	}

	public void setTargetusers(List<Targetuser> targetusers) {
		this.targetusers = targetusers;
	}

	public Targetuser addTargetuser(Targetuser targetuser) {
		getTargetusers().add(targetuser);
		targetuser.setUser(this);

		return targetuser;
	}

	public Targetuser removeTargetuser(Targetuser targetuser) {
		getTargetusers().remove(targetuser);
		targetuser.setUser(null);

		return targetuser;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}