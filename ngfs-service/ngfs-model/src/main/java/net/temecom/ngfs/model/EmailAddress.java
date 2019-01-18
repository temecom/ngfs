package net.temecom.ngfs.model;

import javax.persistence.Entity;

@Entity
public class EmailAddress extends ContactMethod {

	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String number) {
		this.address = number;
	} 
}
