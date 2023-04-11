package com.movie.page.example.moviepage.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerDTO {
    private Long customerId;
    private String name;
    private String email;
    private Long movieId;
}
