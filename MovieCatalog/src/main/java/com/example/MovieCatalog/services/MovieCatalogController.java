package com.example.MovieCatalog.services;

import com.example.MovieCatalog.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/movieCatalog/")
public class MovieCatalogController {

    @GetMapping("{userId}")
    public List<Item> getMovieCatalogItems(@PathVariable String userId) {
        return List.of(
                new Item("Interstellar", "Sci-Fi", 10)
        );
    }

}
