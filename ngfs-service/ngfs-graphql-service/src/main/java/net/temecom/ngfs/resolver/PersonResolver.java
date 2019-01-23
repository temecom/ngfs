package net.temecom.ngfs.resolver;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import net.temecom.ngfs.model.Person;
import net.temecom.ngfs.repository.PersonRepository;

@Component
public class PersonResolver implements GraphQLResolver<Person> {
	
    private PersonRepository repository;
  

    public Optional<Person> getPerson(Person person) {
        return repository.findById(person.getId());
    }
    
    

}
