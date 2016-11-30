package com.accenture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="chicken")
public class Chicken {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name="chickenName")
	private String chickenName;
	
	@Column(name="eggQty")
	private int eggQty;

	public Chicken(){};
	
	public int getEggQty() {
		return eggQty;
	}

	public void setEggQty(int eggQty) {
		this.eggQty = eggQty;
	}

	public String getChickenName() {
		return chickenName;
	}

	public void setChickenName(String chickenName) {
		this.chickenName = chickenName;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
