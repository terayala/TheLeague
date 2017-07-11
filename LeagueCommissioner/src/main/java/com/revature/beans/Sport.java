package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "SPORTS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
@Component
public class Sport {

	@Id
	@Column(name = "SPORT_ID")
	@SequenceGenerator(name = "SPORTID_SEQ", sequenceName = "SPORTID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPORTID_SEQ")
	private int sport_id;
	
	@Column(name = "SPORT")
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

	@Override
	public String toString() {
		return "Sport [sport_id=" + sport_id + ", name=" + name + "]";
	}
}
