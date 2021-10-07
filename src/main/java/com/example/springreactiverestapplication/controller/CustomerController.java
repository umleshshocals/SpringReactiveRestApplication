package com.example.springreactiverestapplication.controller;


import com.example.springreactiverestapplication.entity.Customer;
import com.example.springreactiverestapplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    //reactive spring uses project reactor as its dependencies, it is built on top of project reactor
    //project reactor proves two construct mono and flux

    @Autowired
    CustomerRepository customerRep;

    @GetMapping
    public Flux<Customer> getCustomers()
    {
        return  customerRep.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> getCustomer(@PathVariable Integer id)
    {
        return  customerRep.findById(id);
    }


    @PostMapping
    public Mono<Customer> createCustomer(@RequestBody Customer customer){
        return customerRep.save(customer);

    }
    @PutMapping("/{id}")
    public  Mono<Customer> updateCustomer(@RequestBody Customer customer,@PathVariable Integer id)
    {
        return customerRep.findById(id).map((c)->{
            c.setName(customer.getName());
            c.setName(customer.getAddress());
            return c;
        }).flatMap(c-> customerRep.save(c));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCustomer(@PathVariable Integer id)
    {
           return customerRep.deleteById(id);
    }
}
