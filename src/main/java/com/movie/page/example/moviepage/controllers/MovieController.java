package com.movie.page.example.moviepage.controllers;

import com.movie.page.example.moviepage.dto.MovieDTO;
import com.movie.page.example.moviepage.entities.Hall;
import com.movie.page.example.moviepage.entities.Movie;
import com.movie.page.example.moviepage.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/all") //Tüm Filmleri getir
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(),HttpStatus.OK);
    }

    @GetMapping("/byId")
    public ResponseEntity<Optional<Movie>> getMovieById(@RequestParam Long movieId){
        return new ResponseEntity<>(movieService.getById(movieId),HttpStatus.OK);
    }

    @PostMapping("/newMovie")
    public ResponseEntity<Movie> addNewMovie(MovieDTO movieDTO){
        return new ResponseEntity<>(movieService.createNewMovie(movieDTO),HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Movie> updateMovie(MovieDTO movieDTO){
        return new ResponseEntity<>(movieService.updateMovie(movieDTO),HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMovie(@RequestParam Long movieId){
        String status=movieService.deleteMovie(movieId);
        return ResponseEntity.ok(status);
    }
}
