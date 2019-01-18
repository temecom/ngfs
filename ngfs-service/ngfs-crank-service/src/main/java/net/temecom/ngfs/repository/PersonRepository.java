package net.temecom.ngfs.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import io.crnk.jpa.JpaEntityRepositoryBase;
import net.temecom.ngfs.model.Person;
@Component
public class PersonRepository extends  JpaEntityRepositoryBase<Person, UUID> {

    public PersonRepository() {
        super(Person.class);
    }
}