package com.stickynote.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the expense database table.
 * 
 */
@Entity
public class Expense implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String detail;

	@Column(name="name_expense")
	private String nameExpense;

	//bi-directional many-to-many association to Expenseday
	@ManyToMany(mappedBy="expenses")
	private List<Expenseday> expensedays;

	//bi-directional many-to-one association to Typeofexpense
	@ManyToOne
	@JoinColumn(name="id_typeofexpense")
	private Typeofexpense typeofexpense;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="iduser")
	private User user;

	public Expense() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getNameExpense() {
		return this.nameExpense;
	}

	public void setNameExpense(String nameExpense) {
		this.nameExpense = nameExpense;
	}

	public List<Expenseday> getExpensedays() {
		return this.expensedays;
	}

	public void setExpensedays(List<Expenseday> expensedays) {
		this.expensedays = expensedays;
	}

	public Typeofexpense getTypeofexpense() {
		return this.typeofexpense;
	}

	public void setTypeofexpense(Typeofexpense typeofexpense) {
		this.typeofexpense = typeofexpense;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}