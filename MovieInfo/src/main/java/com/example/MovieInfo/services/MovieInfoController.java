package com.example.MovieInfo.services;

import com.example.MovieInfo.movie.MovieInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movieInfo")
public class MovieInfoController {

    @GetMapping("{movieId}")
    public MovieInfo getMovieInfo(@PathVariable String movieId){
        return new MovieInfo(12111,"Movie Name111","movie desc111");
    }
}
