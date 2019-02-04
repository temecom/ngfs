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
	
	private static final String ENTITY_NAME = "person";
	private static final String ENTITY_NAME_CAMEL = "Person";
	private static final String ENTITY_PLURAL = "people";
	
	private static final String ID_PROPERTY_NAME = ENTITY_NAME+"Id";
	private static final String CREATE_ENTITY_NAME = "create" +  ENTITY_NAME_CAMEL; 
	private static final String UPDATE_ENTITY_NAME = "update" +  ENTITY_NAME_CAMEL; 
	private static final String SUBSCRIPTION_NAME = ENTITY_NAME +  "Changed"; 

	@Autowired
	private PersonRepository personRepository;

	@PostConstruct
	public void initialize() {
		this.repository = personRepository;
	}

	@GraphQLQuery(name = ENTITY_PLURAL)
	public Iterable<Person> getEntities() {
		return super.getEntities();
	}

	@GraphQLQuery(name = ENTITY_NAME)
	public Person getEntity(@GraphQLArgument(name=ID_PROPERTY_NAME) UUID id) {
		return super.getEntity(id);
	}

	@GraphQLMutation(name = CREATE_ENTITY_NAME, description = "Update "+ ENTITY_NAME + " by ID")
	public Person createEntity( @GraphQLArgument(name=ENTITY_NAME) Person entity) {
		return super.createEntity(entity );
	}

	@GraphQLMutation(name = UPDATE_ENTITY_NAME)
	public Person updateEntity(@GraphQLInputField @GraphQLArgument(name=ENTITY_NAME)   Person entity) {
		return super.updateEntity(entity);
	}

	@GraphQLSubscription(name = SUBSCRIPTION_NAME)
	public Publisher<Person> entityChanged(@GraphQLInputField @GraphQLArgument(name="id") UUID id) {
		return super.entityChanged(id);
	}

}
