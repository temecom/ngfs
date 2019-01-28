package net.temecom.ngfs.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;

import net.temecom.ngfs.input.PersonInput;
import net.temecom.ngfs.output.PersonOutput;
import net.temecom.ngfs.subscription.PersonSubscription;

@Component
public class PersonSubscriptionResolver implements GraphQLSubscriptionResolver {

	@Autowired
	private PersonSubscription subscription; 
	public PersonOutput personAdded(PersonInput person) {
		return new PersonOutput();  
	}
	
	
}
