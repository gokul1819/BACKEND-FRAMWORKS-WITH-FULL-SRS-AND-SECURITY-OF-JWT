package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.Feedback;
import java.util.List;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Long> {
    
    @Query("SELECT f FROM Feedback f WHERE f.user.id = :userId")
    List<Feedback> findByUserId(@Param("userId") Long userId);
    
    @Query("SELECT f FROM Feedback f WHERE f.product.productId = :productId")
    List<Feedback> findByProductId(@Param("productId") Integer productId);
    
    @Query("SELECT f FROM Feedback f WHERE f.content LIKE %:content%")
    List<Feedback> findByContentContaining(@Param("content") String content);
}
