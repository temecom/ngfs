package net.temecom.ngfs.output;

import graphql.schema.GraphQLOutputType;
import net.temecom.ngfs.model.Person;

public class PersonOutput extends Person implements GraphQLOutputType {

	@Override
	public String getName() {
		return "PersonOutput";
	}

}
