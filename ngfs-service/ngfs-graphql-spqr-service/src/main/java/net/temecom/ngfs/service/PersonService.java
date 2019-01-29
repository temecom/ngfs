package net.temecom.ngfs.service;

import java.util.UUID;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLInputField;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.annotations.GraphQLSubscription;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import io.leangen.graphql.spqr.spring.util.ConcurrentMultiRegistry;
import net.temecom.ngfs.model.Person;
import net.temecom.ngfs.repository.PersonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Component
@GraphQLApi
@Service
public class PersonService {
	
	private final ConcurrentMultiRegistry<String, FluxSink<Person>> subscribers = new ConcurrentMultiRegistry<>();

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
	public Person updatePerson(@GraphQLInputField @GraphQLArgument(name="person")   Person person) {
		subscribers.get(person.getId().toString()).forEach(subscriber -> subscriber.next(person));
		return personRepository.save(person );
	}
	
	@GraphQLSubscription(name="personChanged")
	public Publisher<Person>  personChanged(@GraphQLInputField @GraphQLArgument(name="id") UUID id) {
		 String idString = id.toString();  
		 return Flux.create(subscriber -> subscribers.add(idString, subscriber.onDispose(() -> subscribers.remove(idString, subscriber))), FluxSink.OverflowStrategy.LATEST);
	}
	
}
