package net.temecom.ngfs.service;

import java.util.UUID;

import javax.annotation.PostConstruct;

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
import net.temecom.ngfs.model.Person;
import net.temecom.ngfs.repository.PersonRepository;

@Component
@GraphQLApi
@Service
public class PersonService extends EntityService<Person> {

	@Autowired
	private PersonRepository personRepository;

	@PostConstruct
	public void initialize() {
		this.repository = personRepository;
	}

	@GraphQLQuery(name = "people")
	public Iterable<Person> getPeople() {
		return super.getEntities();
	}

	@GraphQLQuery(name = "person")
	public Person getPerson(@GraphQLArgument(name="personId") UUID id) {
		return super.getEntity(id);
	}

	@GraphQLMutation(name = "createPerson", description = "Update a person by ID")
	public Person createPerson( @GraphQLArgument(name="person") Person entity) {
		return super.createEntity(entity );
	}

	@GraphQLMutation(name = "updatePerson")
	public Person updatePerson(@GraphQLInputField @GraphQLArgument(name="person")   Person person) {
		return super.updateEntity(person);
	}

	@GraphQLSubscription(name = "personChanged")
	public Publisher<Person> personChanged(@GraphQLInputField @GraphQLArgument(name="id") UUID id) {
		return super.entityChanged(id);
	}

}
