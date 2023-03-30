package com.movie.page.example.moviepage.controllers;

import com.movie.page.example.moviepage.dto.CustomerDTO;
import com.movie.page.example.moviepage.dto.CustomerMovieDTO;
import com.movie.page.example.moviepage.entities.Customer;
import com.movie.page.example.moviepage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/new")
    public ResponseEntity<Customer> addNewCustomer(CustomerDTO customerDTO){
        return new ResponseEntity<>(customerService.createNewCustomer(customerDTO),HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/byId")
    public ResponseEntity<Optional<Customer>> getCustomer(@RequestParam Long customerId){
        return new ResponseEntity<>(customerService.getUserById(customerId),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<>(customerService.updateCustomer(customerDTO),HttpStatus.OK);
    }

    @PutMapping("/addMovie")
    public ResponseEntity<Customer> addMovie(@RequestParam Long customerId,@RequestBody CustomerMovieDTO customerMovieDTO){
        return new ResponseEntity<>(customerService.addMovie(customerId,customerMovieDTO),HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam Long customerId){
        String status = customerService.deleteCustomer(customerId);
        return ResponseEntity.ok(status);
    }
}
