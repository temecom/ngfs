package net.temecom.ngfs.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.temecom.ngfs.model.Person;
@Repository
public interface PersonRepository extends  PagingAndSortingRepository<Person, UUID> {

	List<Person> findPersonBySurName(String surName);

 
}