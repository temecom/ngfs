package net.temecom.ngfs.inputs;

import org.springframework.stereotype.Component;

import graphql.schema.GraphQLInputType;
import net.temecom.ngfs.model.Person;

@Component
public class CreatePersonInput implements GraphQLInputType {

	private String givenName; 
	private String surName; 
	
	@Override
	public String getName() {
		
		return "CreatePersonInput";
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

}
