package net.temecom.ngfs.resolver;

import java.util.UUID;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;

import net.temecom.ngfs.model.Person;

import org.springframework.stereotype.Component;

@Component
public class PersonSubscriptionResolver implements GraphQLSubscriptionResolver {

	
	
	public Person personAdded(UUID id) {
		Person person = null; 
		return person;
	}
}
