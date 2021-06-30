package com.adi.springboot.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Citizen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="u_id")
	AadharDetail adharDetail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AadharDetail getAdharDetail() {
		return adharDetail;
	}

	public void setAdharDetail(AadharDetail adharDetail) {
		this.adharDetail = adharDetail;
	}

	@Override
	public String toString() {
		return "Citizen [id=" + id + ", name=" + name + ", adharDetail=" + adharDetail + "]";
	}
	
	
	
	
}
