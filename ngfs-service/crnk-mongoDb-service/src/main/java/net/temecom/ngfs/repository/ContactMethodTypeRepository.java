package net.temecom.ngfs.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import io.crnk.jpa.JpaEntityRepositoryBase;
import net.temecom.ngfs.model.ContactMethodType;
@Component
public class ContactMethodTypeRepository extends  JpaEntityRepositoryBase<ContactMethodType, UUID> {

    public ContactMethodTypeRepository() {
        super(ContactMethodType.class);
    }
}