package net.temecom.ngfs.repository;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.temecom.ngfs.model.Enumeration;
@Repository
public interface EnumerationRepository extends  PagingAndSortingRepository<Enumeration, UUID> {

}