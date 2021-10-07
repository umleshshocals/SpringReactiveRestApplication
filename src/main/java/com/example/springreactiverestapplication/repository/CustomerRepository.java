package com.example.springreactiverestapplication.repository;

import com.example.springreactiverestapplication.entity.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveCrudRepository<Customer,Integer> {


}
