package com.revature.beans;

public class Sport {

	private int sport_id;
	private String name;
	
	public Sport() {
		
	}
	
	public Sport(String name) {
		this.name = name;
	}

	public int getSport_id() {
		return sport_id;
	}

	public void setSport_id(int sport_id) {
		this.sport_id = sport_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
