package de.htwg.se.mastermind.persistence.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "mastermind_grid")
public class PersistentGrid implements Serializable {

	private static final long serialVersionUID = 1538704903825440126L;

	@Id
	private String id;

	private String name;
	private int actualRow;
	private int rowsAmount;
	private int columnsAmount;
	private String date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getActualRow() {
		return this.actualRow;
	}

	public void setActualRow(int actualRow) {
		this.actualRow = actualRow;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getRowsAmount() {
		return this.rowsAmount;
	}

	public void setRowsAmount(int rowsAmount) {
		this.rowsAmount = rowsAmount;
	}

	public int getColumnsAmount() {
		return this.columnsAmount;
	}

	public void setColumnsAmount (int columnsAmount) {
		this.columnsAmount = columnsAmount;
	}
}
