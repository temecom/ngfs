package net.temecom.ngfs.service;

import java.util.UUID;
import java.util.Optional;
import org.reactivestreams.Publisher;

import io.leangen.graphql.spqr.spring.util.ConcurrentMultiRegistry;
import net.temecom.ngfs.model.EntityBase;
import net.temecom.ngfs.repository.EntityBaseRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

/**
 * Base Service for entities
 * Override subclass for each entity type and override the methods with the appropriate GraphQL annotations
 * @author temecom
 *
 * @param <T> the Entity Type eg: Person
 */
public class  EntityService<T extends EntityBase> {

	private final ConcurrentMultiRegistry<String, FluxSink<T>> subscribers = new ConcurrentMultiRegistry<>();

	protected EntityBaseRepository<T> repository;

	public Iterable<T> getEntities() {
		return repository.findAll();
	}

	public T createEntity( T entity) {
		return repository.save(entity );
	}

	public T updateEntity(  T person) {
		subscribers.get(person.getId().toString()).forEach(subscriber ->
			subscriber.next(person));
		return repository.save(person );
	}

	/**
	* Return the entity identified by id
	*/
	public T getEntity( UUID id) {
		Optional<T> optional= repository.findById(id);
		return optional.isPresent()?optional.get():null;
	}

	/**
	 * Provide a subscription schema
	 * @param id
	 * @return the Publisher for the entity
	 */
	public Publisher<T> entityChanged(UUID id) {
		 String idString = id.toString();
		 return Flux.create(subscriber ->
		 	subscribers.add(idString, subscriber.onDispose(() ->
		 	subscribers.remove(idString, subscriber))),
		 	FluxSink.OverflowStrategy.LATEST);
	}



}
