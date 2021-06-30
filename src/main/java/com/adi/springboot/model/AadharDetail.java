package com.adi.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AadharDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String uid;
	
	/*
	 * @OneToOne(mappedBy = "adharDetail") //@JoinColumn(name="ct_id") private
	 * Citizen citizen;
	 */
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	/*
	 * public Citizen getCitizen() { return citizen; }
	 * 
	 * public void setCitizen(Citizen citizen) { this.citizen = citizen; }
	 */
	
	
}
