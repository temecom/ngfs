package net.temecom.ngfs.proxy;

import io.leangen.graphql.annotations.types.GraphQLType;
import net.temecom.ngfs.model.Person;

@GraphQLType(name="PersonInput")
public class PersonInputProxy extends Person {

}
