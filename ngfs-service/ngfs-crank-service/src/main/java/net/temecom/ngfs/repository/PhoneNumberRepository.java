package net.temecom.ngfs.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import io.crnk.jpa.JpaEntityRepositoryBase;
import net.temecom.ngfs.model.PhoneNumber;
@Component
public class PhoneNumberRepository extends  JpaEntityRepositoryBase<PhoneNumber, UUID> {

    public PhoneNumberRepository() {
        super(PhoneNumber.class);
    }
}