package net.temecom.ngfs.model;

import javax.persistence.Entity;

@Entity
public class Person extends EntityBase{


	private String givenName; 
	private String surnam;
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getSurnam() {
		return surnam;
	}
	public void setSurnam(String surnam) {
		this.surnam = surnam;
	}
	
}
