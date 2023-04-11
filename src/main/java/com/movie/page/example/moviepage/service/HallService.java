package com.movie.page.example.moviepage.service;

import com.movie.page.example.moviepage.dto.HallDTO;
import com.movie.page.example.moviepage.entities.Hall;

import java.util.List;
import java.util.Optional;

public interface HallService {
    Hall createNewHall(HallDTO hallDTO);

    List<Hall> getAllHalls();

    Optional<Hall> getHallById(Long hallId);

    Hall updateHall(HallDTO hallDTO);

    String deleteHall(Long hallId);

}
