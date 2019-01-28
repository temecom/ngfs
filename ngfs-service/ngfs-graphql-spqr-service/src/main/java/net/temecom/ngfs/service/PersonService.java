package net.temecom.ngfs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLInputField;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import net.temecom.ngfs.model.Person;
import net.temecom.ngfs.proxy.PersonInputProxy;
import net.temecom.ngfs.repository.PersonRepository;

@Component
@GraphQLApi
@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository; 
	
	@GraphQLQuery(name = "people")
	public Iterable<Person> getPeople() {
		return personRepository.findAll(); 
	}
	
	@GraphQLMutation(name="createPerson", description="Update a person by ID")
	public Person createPerson(@GraphQLInputField @GraphQLArgument(name="person")  Person person) {
		return personRepository.save(person );
	}
	
	@GraphQLMutation(name="updatePerson")
	public Person updatePerson(@GraphQLInputField(name="person")  Person person) {
		return personRepository.save(person );
	}
}
