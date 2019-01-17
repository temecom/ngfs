package net.temecom.ngfs.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import io.crnk.jpa.JpaEntityRepositoryBase;
import net.temecom.ngfs.model.EmailAddress;
@Component
public class EmailAddressRepository extends  JpaEntityRepositoryBase<EmailAddress, UUID> {

    public EmailAddressRepository() {
        super(EmailAddress.class);
    }
}