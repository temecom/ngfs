package net.temecom.ngfs.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import org.springframework.stereotype.Component;

import net.temecom.ngfs.inputs.CreatePersonInput;
import net.temecom.ngfs.model.Person;
import net.temecom.ngfs.repository.PersonRepository;

@Component
public class PersonMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private PersonRepository personRepository;
	
	public Person createPerson(CreatePersonInput personInput) {
		Person person = personInput.getPerson(); 
		Person newPerson = personRepository.save(person);
		return newPerson; 
	}
}
