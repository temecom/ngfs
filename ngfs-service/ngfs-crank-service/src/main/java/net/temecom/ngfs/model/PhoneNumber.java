package net.temecom.ngfs.model;

import javax.persistence.Entity;

@Entity
public class PhoneNumber extends ContactMethod {

	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	} 
}
