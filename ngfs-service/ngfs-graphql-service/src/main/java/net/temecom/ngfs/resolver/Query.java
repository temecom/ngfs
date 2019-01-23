package net.temecom.ngfs.resolver;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import net.temecom.ngfs.model.Person;
import net.temecom.ngfs.repository.PersonRepository;
@Component
public class Query  implements GraphQLQueryResolver {
		@Autowired
		private PersonRepository personRepository;

	    public List<Person> peopleWithSurName(String surName) {
	        return personRepository.findPersonBySurName(surName);
	    }
	    
	    public Iterable<Person> getPeople() {
	    	return personRepository.findAll();
	    }
	    
	    public Person person(UUID id) {
	    	return personRepository.findById(id).get();
	    }
}
