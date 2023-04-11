package com.movie.page.example.moviepage.controllers;

import com.movie.page.example.moviepage.dto.HallDTO;
import com.movie.page.example.moviepage.entities.Hall;
import com.movie.page.example.moviepage.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hall")
public class HallController {

    @Autowired
    HallService hallService;

    @PostMapping("/add")
    public ResponseEntity<Hall> addNewHall(HallDTO hallDTO) {
        return new ResponseEntity<>(hallService.createNewHall(hallDTO), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hall>> getAllHall() {
        return new ResponseEntity<>(hallService.getAllHalls(), HttpStatus.OK);
    }

    @GetMapping("/byId")
    public ResponseEntity<Optional<Hall>> getHallsById(@RequestParam Long hallId) {
        return new ResponseEntity<>(hallService.getHallById(hallId), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Hall> updateHall(@RequestBody HallDTO hallDTO) {
        return new ResponseEntity<>(hallService.updateHall(hallDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteHall(@RequestParam Long hallId) {
        String status = hallService.deleteHall(hallId);
        return ResponseEntity.ok(status);
    }

}
