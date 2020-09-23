package com.example.movieinfoservice.resources;

import com.example.movieinfoservice.repository.MovieRepository;
import com.example.movieinfoservice.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") int movieId) {
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        return movieOptional.get();
    }

}
