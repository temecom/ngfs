package net.temecom.ngfs.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.temecom.ngfs.model.Person;
@Repository
public interface PersonRepository extends  EntityBaseRepository<Person> {

	List<Person> findPersonBySurName(String surName);

 
}