package com.movie.page.example.moviepage.service;

import com.movie.page.example.moviepage.dto.MovieDTO;
import com.movie.page.example.moviepage.entities.Movie;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MovieService {
    Movie createNewMovie(MovieDTO movieDTO);

    //List<Movie> getAllMovies();

    Page<Movie> getAllMovies(int pageNumber, int pageSize);

    Optional<Movie> getById(Long movieId);

    Movie updateMovie(MovieDTO movieDTO);

    String deleteMovie(Long movieId);
}
