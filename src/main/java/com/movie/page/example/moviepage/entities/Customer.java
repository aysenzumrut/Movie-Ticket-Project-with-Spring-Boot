package com.movie.page.example.moviepage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movie.page.example.moviepage.dto.CustomerDTO;
import com.movie.page.example.moviepage.dto.CustomerMovieDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "movie", name = "Customer")
public class Customer extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(allocationSize = 1, name = "customer_seq", sequenceName = "customer_seq")
    private Long customerId;
    @NotNull
    private String name;
    @Email
    @Column(unique = true,nullable = false)
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Customer(CustomerDTO customerDTO){
        this.name=customerDTO.getName();
        this.email=customerDTO.getEmail();
    }

}
