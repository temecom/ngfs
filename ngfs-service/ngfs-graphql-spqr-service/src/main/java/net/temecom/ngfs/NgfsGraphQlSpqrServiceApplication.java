package net.temecom.ngfs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import net.temecom.ngfs.service.PersonService;

@ComponentScan ({
	"net.temecom.ngfs.resolver", 
	"net.temecom.ngfs.subscription", 
	"net.temecom.ngfs.input", 
	"net.temecom.ngfs.output", 
	"net.temecom.ngfs.service", 
	"net.temecom.ngfs.model"})
@SpringBootApplication
public class NgfsGraphQlSpqrServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(NgfsGraphQlSpqrServiceApplication.class, args);
	}
}
