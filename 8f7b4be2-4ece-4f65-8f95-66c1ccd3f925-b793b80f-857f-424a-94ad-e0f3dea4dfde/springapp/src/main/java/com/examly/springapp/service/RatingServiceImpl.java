package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Rating;
import com.examly.springapp.repository.RatingRepo;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    
    @Autowired
    private RatingRepo ratingRepo;
    
    @Override
    public Rating createRating(Rating rating) {
        return ratingRepo.save(rating);
    }
    
    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }
    
    @Override
    public Rating getRatingById(Long id) {
        return ratingRepo.findById(id).orElse(null);
    }
}
