package net.temecom.ngfs.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Person extends EntityBase{

	private String givenName; 
	private String surnam;
	@OneToMany
	private List<ContactMethod> contactMethods; 
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
	public List<ContactMethod> getContactMethods() {
		return contactMethods;
	}
	public void setContactMethods(List<ContactMethod> contactMethods) {
		this.contactMethods = contactMethods;
	}
	
}
