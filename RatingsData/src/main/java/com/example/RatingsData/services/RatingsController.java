package com.example.RatingsData.services;


import com.example.RatingsData.ratings.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ratings/")
public class RatingsController {
    @GetMapping("{movieId}")
    public Rating getMovieRating(@PathVariable  int movieId){
        return new Rating(movieId,10000);
    }
}
