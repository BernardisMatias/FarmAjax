package com.accenture.model;

import javax.persistence.*;


@Entity
@Table(name="egg")
public class Egg {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@JoinColumn(name="colour")
	private String colour;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="chickenId")
	private Chicken chickenId;
	

	public Chicken getChickenId() {
		return chickenId;
	}

	public void setChickenId(Chicken chickenId) {
		this.chickenId = chickenId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	
}
