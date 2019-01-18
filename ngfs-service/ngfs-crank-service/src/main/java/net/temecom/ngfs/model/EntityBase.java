package net.temecom.ngfs.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.crnk.core.resource.annotations.JsonApiId;

@Entity
public class EntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected UUID id;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
}
