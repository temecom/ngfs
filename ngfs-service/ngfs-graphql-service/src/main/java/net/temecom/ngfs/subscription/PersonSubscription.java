package net.temecom.ngfs.subscription;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import net.temecom.ngfs.input.PersonInput;
import net.temecom.ngfs.model.Person;
import net.temecom.ngfs.output.PersonOutput;
import net.temecom.ngfs.resolver.PersonMutationResolver;
import net.temecom.ngfs.resolver.PersonResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Subscriptions for a person
 * @author Christopher.Smith2
 *
 */
@Component
public class PersonSubscription {

	private static final Logger LOG = LoggerFactory.getLogger(PersonSubscription.class);

	@Autowired
    private Flowable<PersonOutput> publisher;
	
	@Autowired
	private PersonMutationResolver personMutationResolver; 
	
	/**
	 * Configure the publisher using defaults
	 * @return the created publisher
	 */
	@Bean
	public  Flowable<PersonOutput> publisher() {
		Observable<PersonOutput> stockPriceUpdateObservable = Observable.create(emitter -> {

			personMutationResolver.addEmitter(emitter); 

	    });

	    ConnectableObservable<PersonOutput> connectableObservable = stockPriceUpdateObservable.share().publish();
	    connectableObservable.connect();

	    publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
	    return publisher;
	}
	
}
