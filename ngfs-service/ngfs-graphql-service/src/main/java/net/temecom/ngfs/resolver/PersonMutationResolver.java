package net.temecom.ngfs.resolver;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import io.reactivex.Emitter;
import io.reactivex.ObservableEmitter;

import org.springframework.stereotype.Component;

import net.temecom.ngfs.input.PersonInput;
import net.temecom.ngfs.model.Person;
import net.temecom.ngfs.output.PersonOutput;
import net.temecom.ngfs.repository.PersonRepository;

@Component
public class PersonMutationResolver implements GraphQLMutationResolver {

	private Logger logger = LoggerFactory.getLogger(PersonMutationResolver.class); 
	@Autowired
	private PersonRepository personRepository;

	private List<Emitter<PersonOutput>> emitters = new ArrayList<>();
	public void addEmitter(ObservableEmitter<PersonOutput> emitter) {
		emitters.add(emitter);
	}

	public Person createPerson(PersonInput personInput) {
		Person newPerson = new Person();
		newPerson = savePerson(personInput, newPerson);
		PersonOutput personOutput = new PersonOutput(); 
		//TODO: update output
		 try {
			 emitters.forEach(emitter -> {
				 emitter.onNext(personOutput);
			 });
         } catch (RuntimeException e) {
             logger.error("Cannot send Person Update", e);
         }
		return  newPerson;
	}
	
	public Person updatePerson(PersonInput person) {
		
		Person existingPerson = personRepository.findById(person.getId()).get(); 
		return  savePerson(person, existingPerson);

	}

	private Person savePerson(PersonInput personInput, Person person) {
		person.setGivenName(personInput.getGivenName());
		person.setSurName(personInput.getSurName());
		return personRepository.save(person);
		
	}
}
