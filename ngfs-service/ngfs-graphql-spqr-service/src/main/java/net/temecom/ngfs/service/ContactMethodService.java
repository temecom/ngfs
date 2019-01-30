package net.temecom.ngfs.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLInputField;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import net.temecom.ngfs.model.ContactMethod;
import net.temecom.ngfs.repository.ContactMethodRepository;

/**
 * The enumeration of contact method types eg: Mobile, Email etc. 
 * Used for selection of contact methods in UI 
 * @author temecom
 *
 */
@Component
@GraphQLApi
@Service
public class ContactMethodService extends EntityService<ContactMethod> {
	
	@Autowired
	private ContactMethodRepository contactMethodRepository;
	
	@PostConstruct
	public void initialize() { 
		this.repository = contactMethodRepository; 
	}

	@GraphQLQuery(name = "contactMethods")
	public Iterable<ContactMethod> getContactMethods() {
		return super.getEntities(); 
	}

	@GraphQLMutation(name = "createContactMethod", description = "Update a contactMethod by ID")
	public ContactMethod createContactMethod( @GraphQLArgument(name="contactMethod") ContactMethod entity) {
		return super.createEntity(entity );
	}

	@GraphQLMutation(name = "updateContactMethod")
	public ContactMethod updateContactMethod(@GraphQLInputField @GraphQLArgument(name="contactMethod")   ContactMethod contactMethod) {
		return super.updateEntity(contactMethod); 
	}

}
