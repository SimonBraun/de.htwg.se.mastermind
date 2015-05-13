package de.htwg.se.mastermind.persistence.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "grid")
public class PersistentGrid implements Serializable {

	private static final long serialVersionUID = 1538704903825440126L;

	@Id
	@Column(name = "id")
	private String gridId;

	private String name;
	private int blocksPerEdge;
	private int numberSetCells;	
	
	public PersistentGrid() {
	}

	public String getId() {
		return gridId;
	}

	public void setId(String id) {
		this.gridId = id;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if(name != null) { this.name = name;}
	}
	
	public int getBlocksPerEdge() {
		return blocksPerEdge;
	}

	public void setBlocksPerEdge(int blocksPerEdge) {
		this.blocksPerEdge = blocksPerEdge;
	}
	
	public int getNumberSetCells() {
		return numberSetCells;
	}

	public void setNumberSetCells(int numberSetCells) {
		this.numberSetCells = numberSetCells;
	}
}
