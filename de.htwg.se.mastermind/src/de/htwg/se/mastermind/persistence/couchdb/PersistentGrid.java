package de.htwg.se.mastermind.persistence.couchdb;

import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.TypeDiscriminator;

import java.util.Date;

public class PersistentGrid extends CouchDbDocument {

    private static final long serialVersionUID = 1538704903825440126L;

    @TypeDiscriminator
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
