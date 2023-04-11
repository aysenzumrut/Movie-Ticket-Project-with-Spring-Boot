package com.movie.page.example.moviepage.service;

import com.movie.page.example.moviepage.dto.CustomerDTO;
import com.movie.page.example.moviepage.dto.CustomerMovieDTO;
import com.movie.page.example.moviepage.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer createNewCustomer(CustomerDTO customerDTO);

    List<Customer> getAllCustomers();

    Optional<Customer> getUserById(Long customerId);

    Customer updateCustomer(CustomerDTO customerDTO);

    Customer addMovie(Long customerId, CustomerMovieDTO customerMovieDTO);

    String deleteCustomer(Long customerId);
}
