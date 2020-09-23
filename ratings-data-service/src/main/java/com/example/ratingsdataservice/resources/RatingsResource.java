package com.example.ratingsdataservice.resources;

import com.example.ratingsdataservice.model.Rating;
import com.example.ratingsdataservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @Autowired
    private RatingRepository ratingRepository;

    @RequestMapping("/movies/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") int movieId) {
        Optional<Rating> optionalRating = ratingRepository.findById(movieId);
        return optionalRating.get();
    }

}
