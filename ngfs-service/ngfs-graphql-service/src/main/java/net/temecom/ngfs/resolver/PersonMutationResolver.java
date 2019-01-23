package net.temecom.ngfs.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import org.springframework.stereotype.Component;

import net.temecom.ngfs.inputs.PersonInput;
import net.temecom.ngfs.model.Person;
import net.temecom.ngfs.repository.PersonRepository;

@Component
public class PersonMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private PersonRepository personRepository;
	
	public Person createPerson(PersonInput personInput) {
		Person person = new Person();
		return  savePerson(personInput, person);
	}
	
	public Person updatePerson(PersonInput personInput) {
		
		Person person = personRepository.findById(personInput.getId()).get(); 
		return  savePerson(personInput, person);

	}

	private Person savePerson(PersonInput personInput, Person person) {
		person.setGivenName(personInput.getGivenName());
		person.setSurName(personInput.getSurName());
		return personRepository.save(person);
		
	}
}
