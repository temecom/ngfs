package net.temecom.ngfs.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import io.crnk.jpa.JpaEntityRepositoryBase;
import net.temecom.ngfs.model.ContactMethod;
@Component
public class ContactMethodRepository extends  JpaEntityRepositoryBase<ContactMethod, UUID> {

    public ContactMethodRepository() {
        super(ContactMethod.class);
    }
}