package com.movie.page.example.moviepage.service;

import com.movie.page.example.moviepage.dto.MovieDTO;
import com.movie.page.example.moviepage.entities.Hall;
import com.movie.page.example.moviepage.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    Movie createNewMovie(MovieDTO movieDTO);

    List<Movie> getAllMovies();
    Optional<Movie> getById(Long movieId);
    Movie updateMovie(MovieDTO movieDTO);
    String deleteMovie(Long movieId);
}
