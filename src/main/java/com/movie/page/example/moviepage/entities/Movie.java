package com.movie.page.example.moviepage.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movie.page.example.moviepage.dto.MovieDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(schema = "movie", name = "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
    @SequenceGenerator(allocationSize = 1, name = "movie_seq", sequenceName = "movie_seq")
    private Long movieId;
    private String name;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Europe/Istanbul")
    private Date date;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<Customer> customers;

    @OneToOne
    @JoinColumn(name = "hallId")
    private Hall hall;

    public Movie(MovieDTO movieDTO, Hall hall, Customer customer) {
        this.movieId = movieDTO.getMovieId();
        this.name = movieDTO.getName();
        this.hall = hall;
        this.customers = (List<Customer>) customer;
    }


}
