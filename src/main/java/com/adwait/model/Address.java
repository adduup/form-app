package com.adwait.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address", catalog = "user_db")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Integer id;
	private String addressOne;
	private String city;
	private String state;
	private String zipCode;
	private String addressTwo;
	@Column(name = "user_id")
	private Integer studentId;

	public Address() {

	}

	public Address(String addressOne, String city, String state, String zipCode, String addressTwo) {
		this.addressOne = addressOne;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.addressTwo = addressTwo;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddressOne() {
		return addressOne;
	}

	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddressTwo() {
		return addressTwo;
	}

	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressOne=" + addressOne + ", city=" + city + ", state=" + state + ", zipCode="
				+ zipCode + ", addressTwo=" + addressTwo + "]";
	}

}
