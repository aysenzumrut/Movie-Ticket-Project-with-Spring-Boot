package com.movie.page.example.moviepage.repositories;

import com.movie.page.example.moviepage.entities.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall, Long> {
}