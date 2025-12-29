package com.examly.springapp.service;

import com.examly.springapp.model.Feedback;
import java.util.List;

public interface FeedbackService {
    Feedback createFeedback(Feedback feedback);
    List<Feedback> getAllFeedbacks();
    Feedback getFeedbackById(Long id);
    Feedback updateFeedback(Long id, Feedback feedback);
}