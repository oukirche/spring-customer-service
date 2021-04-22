package org.mql.spring.customerservice;


import org.mql.spring.customerservice.dao.CustomerRepository;
import org.mql.spring.customerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableEurekaClient
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
		return args -> {
			restConfiguration.exposeIdsFor(Customer.class);
			customerRepository.save(new Customer(null,"abdessamade","abde@gmail.com"));
			customerRepository.save(new Customer(null,"aziz","aziz@gmail.com"));
			customerRepository.save(new Customer(null,"said","said@gmail.com"));
			customerRepository.findAll().forEach(System.out::println);
		};
	}

}
