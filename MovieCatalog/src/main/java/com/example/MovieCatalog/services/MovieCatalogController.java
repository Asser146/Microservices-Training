package com.example.MovieCatalog.services;

import com.example.MovieCatalog.models.Movie;
import com.example.MovieCatalog.models.MovieCatalogItem;
import com.example.MovieCatalog.models.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/movieCatalog/")
public class MovieCatalogController {

    @GetMapping("{userId}")
    public List<MovieCatalogItem> getMovieCatalogItems(@PathVariable String userId) {
        // Sample ratings for the user
        List<Rating> tempRatingList = Arrays.asList(
                new Rating(1234, 5),
                new Rating(1235, 8)
        );

        RestTemplate restTemplate = new RestTemplate();

        // Transform rating list into movie catalog items
        return tempRatingList.stream().map(rating -> {
            // Get movie info from movie info service
            Movie movieInfo = restTemplate.getForObject(
                    "http://localhost:8082/api/movieInfo/" + rating.getMovieId(),
                    Movie.class
            );
            Rating rate= restTemplate.getForObject("http://localhost:8083/api/ratings/"+rating.getMovieId(), Rating.class);

            // Use rating from ratingList directly instead of calling rating service again
            return new MovieCatalogItem(
                    movieInfo.getName(),
                    movieInfo.getDescription(),
                    rate.getMovieRating()
            );
        }).toList();

    }

}
