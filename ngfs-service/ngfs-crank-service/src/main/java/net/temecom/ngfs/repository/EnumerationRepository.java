package net.temecom.ngfs.repository;

import java.util.UUID;

import org.springframework.stereotype.Component;

import io.crnk.jpa.JpaEntityRepositoryBase;
import net.temecom.ngfs.model.Enumeration;
@Component
public class EnumerationRepository extends  JpaEntityRepositoryBase<Enumeration, UUID> {

    public EnumerationRepository() {
        super(Enumeration.class);
    }
}