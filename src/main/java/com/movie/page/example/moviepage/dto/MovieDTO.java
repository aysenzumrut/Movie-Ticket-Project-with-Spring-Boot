package com.movie.page.example.moviepage.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private Long movieId;
    private String name;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Europe/Istanbul")
    private Date date;
    private Long hallId;

    private Long numberOfSeat;
//    private Time time;
}
