package com.adi.springboot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "person",fetch = FetchType.EAGER)
	List<MobileNo> mobileNo;

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

	public List<MobileNo> getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(List<MobileNo> mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + "]";
	}
	
	
	
}
