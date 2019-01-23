package net.temecom.ngfs.inputs;

import java.util.UUID;

import org.springframework.stereotype.Component;

import graphql.schema.GraphQLInputType;
import net.temecom.ngfs.model.Person;

@Component
public class PersonInput implements GraphQLInputType {

	private UUID id; 
	private String givenName; 
	private String surName; 
	
	@Override
	public String getName() {
		
		return "PersonInput";
	}

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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
