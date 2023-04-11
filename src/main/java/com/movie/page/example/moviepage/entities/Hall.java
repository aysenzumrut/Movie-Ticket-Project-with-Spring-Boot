package com.movie.page.example.moviepage.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(schema = "movie", name = "Halls")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hall_seq")
    @SequenceGenerator(allocationSize = 1, name = "hall_seq", sequenceName = "hall_seq")
    private Long hallId;
    private Long numberOfSeat;

    @OneToOne(mappedBy = "hall")
    @JsonIgnore
    private Movie movie;

    public Hall(Movie movie) {
        this.movie = movie;
    }

    public Hall(Long numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }
}
