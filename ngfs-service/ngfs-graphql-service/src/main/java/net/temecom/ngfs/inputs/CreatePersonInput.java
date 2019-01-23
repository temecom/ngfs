package net.temecom.ngfs.inputs;

import graphql.schema.GraphQLInputType;
import net.temecom.ngfs.model.Person;


public class CreatePersonInput implements GraphQLInputType {

	private Person person; 
	@Override
	public String getName() {
		
		return "Person";
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}

	

}
