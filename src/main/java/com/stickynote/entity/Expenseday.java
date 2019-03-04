package com.stickynote.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the expenseday database table.
 * 
 */
@Entity
public class Expenseday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private double moneyspent;

	//bi-directional many-to-many association to Expense
	@ManyToMany
	@JoinTable(
		name="detailexpenseday"
		, joinColumns={
			@JoinColumn(name="id_ExpenseDay")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_Expense")
			}
		)
	private List<Expense> expenses;

	//bi-directional many-to-one association to Expensemonth
	@ManyToOne
	@JoinColumn(name="id_expensemonth")
	private Expensemonth expensemonth;

	public Expenseday() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getMoneyspent() {
		return this.moneyspent;
	}

	public void setMoneyspent(double moneyspent) {
		this.moneyspent = moneyspent;
	}

	public List<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public Expensemonth getExpensemonth() {
		return this.expensemonth;
	}

	public void setExpensemonth(Expensemonth expensemonth) {
		this.expensemonth = expensemonth;
	}

}