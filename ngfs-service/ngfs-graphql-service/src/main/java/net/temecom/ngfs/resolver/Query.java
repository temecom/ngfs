package net.temecom.ngfs.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import net.temecom.ngfs.model.Person;
import net.temecom.ngfs.repository.PersonRepository;
@Component
public class Query  implements GraphQLQueryResolver {
		@Autowired
		private PersonRepository personRepository;

	    public List<Person> peopleWithSurnam(String surnam) {
	        return personRepository.findPersonBySurnam(surnam);
	    }

}
