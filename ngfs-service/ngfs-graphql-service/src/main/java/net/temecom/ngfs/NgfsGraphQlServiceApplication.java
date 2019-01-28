package net.temecom.ngfs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import net.temecom.ngfs.output.PersonOutput;
import net.temecom.ngfs.resolver.PersonMutationResolver;

@ComponentScan ("net.temecom.ngfs.resolver, net.temecom.ngfs.subscription, net.temecom.ngfs.input, net.temecom.ngfs.output")
@SpringBootApplication
public class NgfsGraphQlServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NgfsGraphQlServiceApplication.class, args);
	}

	@Autowired
	public PersonMutationResolver personMutationResolver;
	
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

	    return connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
	   
	}

}

