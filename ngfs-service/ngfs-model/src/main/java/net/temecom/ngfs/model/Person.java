package net.temecom.ngfs.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Person extends EntityBase{

	private String givenName; 
	private String surName;
	@OneToMany
	private List<ContactMethod> contactMethods; 
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public List<ContactMethod> getContactMethods() {
		return contactMethods;
	}
	public void setContactMethods(List<ContactMethod> contactMethods) {
		this.contactMethods = contactMethods;
	}
	
}
