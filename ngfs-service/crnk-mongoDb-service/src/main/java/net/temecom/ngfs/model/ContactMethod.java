package net.temecom.ngfs.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ContactMethod extends EntityBase {


	private String name; 
	@ManyToOne
	private ContactMethodType type;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ContactMethodType getType() {
		return type;
	}
	public void setType(ContactMethodType type) {
		this.type = type;
	} 
}
