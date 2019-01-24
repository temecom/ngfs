package net.temecom.ngfs.resolver;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import net.temecom.ngfs.model.Person;
import net.temecom.ngfs.repository.PersonRepository;

@Component
public class Query implements GraphQLQueryResolver {
	@Autowired
	private PersonRepository personRepository;

	public List<Person> peopleWithSurName(String surName) {
		return personRepository.findPersonBySurName(surName);
	}

	/**
	 * Return the list of people
	 * @param orderBy (Optional) the field and direction of the sort
	 * @return a collection of people - empty if none
	 */
	public Iterable<Person> getPeople(OrderBy orderBy) {
		Iterable<Person> people = null;
		if (orderBy != null) {
			Sort.Direction direction = null;
			if (Sort.Direction.ASC.toString().equals(orderBy.getDirection())) {
				direction = Sort.Direction.ASC;
			} else {
				direction = Sort.Direction.DESC;
			}
			people = personRepository.findAll(Sort.by(direction, orderBy.getField()));
		} else {
			people = personRepository.findAll();
		}
		return people;
	}

	public Person person(UUID id) {
		return personRepository.findById(id).get();
	}
}
