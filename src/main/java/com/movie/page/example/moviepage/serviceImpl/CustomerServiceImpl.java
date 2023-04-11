package com.movie.page.example.moviepage.serviceImpl;

import com.movie.page.example.moviepage.dto.CustomerDTO;
import com.movie.page.example.moviepage.dto.CustomerMovieDTO;
import com.movie.page.example.moviepage.entities.Customer;
import com.movie.page.example.moviepage.entities.Movie;
import com.movie.page.example.moviepage.repositories.CustomerRepository;
import com.movie.page.example.moviepage.repositories.MovieRepository;
import com.movie.page.example.moviepage.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private MovieRepository movieRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               MovieRepository movieRepository) {
        this.customerRepository = customerRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public Customer createNewCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setCreatedAt(new Date());
        Optional<Movie> movie = movieRepository.findById(customerDTO.getMovieId());
        customer.setMovie(movie.get());
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getUserById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public Customer updateCustomer(CustomerDTO customerDTO) {
        Optional<Customer> customer = customerRepository.findById(customerDTO.getCustomerId());
        Customer changedCustomer;
        if (customer.isPresent()) {
            changedCustomer = customer.get();
            changedCustomer.setName(customerDTO.getName());
            changedCustomer.setEmail(customerDTO.getEmail());
            changedCustomer.setUpdatedAt(new Date());
            return customerRepository.save(changedCustomer);
        }
        return null;
    }

    @Override
    public Customer addMovie(Long customerId, CustomerMovieDTO customerMovieDTO) {
        Optional<Customer> customer1 = customerRepository.findById(customerId);
        Customer newCustomer;
        Optional<Movie> movie1 = movieRepository.findById(customerMovieDTO.getMovieId());
        if (customer1.isPresent() && movie1.isPresent()) {
            newCustomer = customer1.get();
            newCustomer.setMovie(movie1.get());
            newCustomer.setUpdatedAt(new Date());
            return customerRepository.save(newCustomer);
        }
        return null;
    }

    @Override
    public String deleteCustomer(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            customerRepository.deleteById(customerId);
            return "Kullanıcı Silme İşlemi Başarılı...";
        }
        return "Böyle Bir Kullanıcı Bulunamadı!";
    }
}
