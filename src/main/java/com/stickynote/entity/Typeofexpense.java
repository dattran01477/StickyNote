package com.stickynote.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typeofexpense database table.
 * 
 */
@Entity
public class Typeofexpense implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to Expense
	@OneToMany(mappedBy="typeofexpense")
	private List<Expense> expenses;

	public Typeofexpense() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Expense> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public Expense addExpens(Expense expens) {
		getExpenses().add(expens);
		expens.setTypeofexpense(this);

		return expens;
	}

	public Expense removeExpens(Expense expens) {
		getExpenses().remove(expens);
		expens.setTypeofexpense(null);

		return expens;
	}

}