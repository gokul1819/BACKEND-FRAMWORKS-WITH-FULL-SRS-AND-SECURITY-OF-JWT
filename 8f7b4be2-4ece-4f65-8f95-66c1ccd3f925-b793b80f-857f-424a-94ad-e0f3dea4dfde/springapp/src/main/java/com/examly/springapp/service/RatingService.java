package com.examly.springapp.service;

import com.examly.springapp.model.Rating;
import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);
    List<Rating> getAllRatings();
    Rating getRatingById(Long id);
}
