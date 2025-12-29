package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Feedback;
import com.examly.springapp.repository.FeedbackRepo;
import com.examly.springapp.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    
    @Autowired
    private FeedbackRepo feedbackRepo;
    
    @Override
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepo.save(feedback);
    }
    
    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepo.findAll();
    }
    
    @Override
    public Feedback getFeedbackById(Long id) {
        return feedbackRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Feedback not found with id: " + id));
    }
    
    @Override
    public Feedback updateFeedback(Long id, Feedback feedback) {
        Feedback existingFeedback = feedbackRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Feedback not found with id: " + id));
        
        existingFeedback.setContent(feedback.getContent());
        existingFeedback.setUser(feedback.getUser());
        existingFeedback.setProduct(feedback.getProduct());
        return feedbackRepo.save(existingFeedback);
    }
}
