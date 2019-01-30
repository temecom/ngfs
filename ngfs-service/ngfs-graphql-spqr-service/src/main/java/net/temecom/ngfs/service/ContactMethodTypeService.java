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
import net.temecom.ngfs.model.ContactMethodType;
import net.temecom.ngfs.repository.ContactMethodTypeRepository;

/**
 * The enumeration of contact method types eg: Mobile, Email etc. 
 * Used for selection of contact methods in UI 
 * @author temecom
 *
 */
@Component
@GraphQLApi
@Service
public class ContactMethodTypeService extends EntityService<ContactMethodType> {
	
	@Autowired
	private ContactMethodTypeRepository contactMethodTypeRepository;
	
	@PostConstruct
	public void initialize() { 
		this.repository = contactMethodTypeRepository; 
	}

	@GraphQLQuery(name = "contactMethodTypes")
	public Iterable<ContactMethodType> getContactMethodTypes() {
		return super.getEntities(); 
	}

	@GraphQLMutation(name = "createContactMethodType", description = "Update a contactMethodType by ID")
	public ContactMethodType createContactMethodType( @GraphQLArgument(name="contactMethodType") ContactMethodType entity) {
		return super.createEntity(entity );
	}

	@GraphQLMutation(name = "updateContactMethodType")
	public ContactMethodType updateContactMethodType(@GraphQLInputField @GraphQLArgument(name="contactMethodType")   ContactMethodType contactMethodType) {
		return super.updateEntity(contactMethodType); 
	}

}
