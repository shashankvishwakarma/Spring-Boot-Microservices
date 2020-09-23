package com.example.moviecatalogservice.resources;

import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public CatalogItem getCatalog(@PathVariable("movieId") int movieId) {
        Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + movieId, Movie.class);
        Rating rating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/movies/" + movieId, Rating.class);
        return new CatalogItem(movie.getTitle(), movie.getOverview(), rating.getRating());
    }
}
