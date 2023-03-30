package com.movie.page.example.moviepage.serviceImpl;

import com.movie.page.example.moviepage.dto.MovieDTO;
import com.movie.page.example.moviepage.entities.Hall;
import com.movie.page.example.moviepage.entities.Movie;
import com.movie.page.example.moviepage.repositories.HallRepository;
import com.movie.page.example.moviepage.repositories.MovieRepository;
import com.movie.page.example.moviepage.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    private HallRepository hallRepository;

    @Override
    public Movie createNewMovie(MovieDTO movieDTO) {
        Movie movie=new Movie();
        movie.setName(movieDTO.getName());
        String pattern = "yyyy/MM/dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.of ( "Europe/Istanbul" )));
        String date = simpleDateFormat.format(movieDTO.getDate());
        System.out.println(date);
        movie.setDate(movieDTO.getDate());
        Optional<Hall> hall= hallRepository.findById(movieDTO.getHallId());
        movie.setHall(hall.orElseGet(() -> hallRepository.save(new Hall(movieDTO.getNumberOfSeat()))));
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getById(Long movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public Movie updateMovie(MovieDTO movieDTO) {
        Optional<Movie> movieControl=movieRepository.findById(movieDTO.getMovieId());
        Movie changedMovie;
        if (movieControl.isPresent()){
            changedMovie=movieControl.get();
            changedMovie.setName(movieDTO.getName());
            return movieRepository.save(changedMovie);
        }
        return null;
    }

    @Override
    public String deleteMovie(Long movieId) {
        Optional<Movie> movie=movieRepository.findById(movieId);
        if (movie.isPresent()){
            movieRepository.deleteById(movieId);
            return "Film Listeden Çıkarılmıştır...";
        }
        return "Böyle Bir Film Bulunamadı!";
    }
}
