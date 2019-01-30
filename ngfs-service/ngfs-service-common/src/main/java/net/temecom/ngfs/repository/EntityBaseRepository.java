package net.temecom.ngfs.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.temecom.ngfs.model.EntityBase;
@Repository
public interface EntityBaseRepository <T extends EntityBase> extends  PagingAndSortingRepository<T, UUID> {

}