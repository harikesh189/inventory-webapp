package com.fab.inventory.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Customer extends AbstractBaseDomain {

	private static final long serialVersionUID = 17325483L;

	@Column(name = "first_name")
	String firstName;

	@Column(name = "middle_name")
	String middleName;

	@Column(name = "last_name")
	String lastName;

	@Column(name = "mobile_number")
	String mobileNumber;

	@Column(name = "email_id")
	String emailId;

	@Column(name = "adhar_number")
	String adharNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}
}
