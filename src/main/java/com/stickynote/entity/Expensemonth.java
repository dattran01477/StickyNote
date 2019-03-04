package com.stickynote.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the expensemonth database table.
 * 
 */
@Entity
public class Expensemonth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private double moneyavailable;

	private int month;

	private int year;

	//bi-directional many-to-one association to Expenseday
	@OneToMany(mappedBy="expensemonth")
	private List<Expenseday> expensedays;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="iduser")
	private User user;

	public Expensemonth() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMoneyavailable() {
		return this.moneyavailable;
	}

	public void setMoneyavailable(double moneyavailable) {
		this.moneyavailable = moneyavailable;
	}

	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Expenseday> getExpensedays() {
		return this.expensedays;
	}

	public void setExpensedays(List<Expenseday> expensedays) {
		this.expensedays = expensedays;
	}

	public Expenseday addExpenseday(Expenseday expenseday) {
		getExpensedays().add(expenseday);
		expenseday.setExpensemonth(this);

		return expenseday;
	}

	public Expenseday removeExpenseday(Expenseday expenseday) {
		getExpensedays().remove(expenseday);
		expenseday.setExpensemonth(null);

		return expenseday;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}