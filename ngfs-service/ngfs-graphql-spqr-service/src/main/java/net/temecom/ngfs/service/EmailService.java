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
import net.temecom.ngfs.model.EmailAddress;
import net.temecom.ngfs.repository.EmailAddressRepository;

@Component
@GraphQLApi
@Service
public class EmailService extends EntityService<EmailAddress> {
	
	@Autowired
	private EmailAddressRepository emailAddressRepository;
	
	@PostConstruct
	public void initialize() { 
		this.repository = emailAddressRepository; 
	}

	@GraphQLQuery(name = "emailAddresses")
	public Iterable<EmailAddress> getEmailAddresses() {
		return super.getEntities(); 
	}

	@GraphQLMutation(name = "createEmailAddress", description = "Update a emailAddress by ID")
	public EmailAddress createEmailAddress( @GraphQLArgument(name="emailAddress") EmailAddress entity) {
		return super.createEntity(entity );
	}

	@GraphQLMutation(name = "updateEmailAddress")
	public EmailAddress updateEmailAddress(@GraphQLInputField @GraphQLArgument(name="emailAddress")   EmailAddress emailAddress) {
		return super.updateEntity(emailAddress); 
	}

	@GraphQLSubscription(name = "emailAddressChanged")
	public Publisher<EmailAddress> emailAddressChanged(@GraphQLInputField @GraphQLArgument(name="id") UUID id) {
		return super.entityChanged(id); 
	}

}
