package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.Rating;
import java.util.List;

@Repository
public interface RatingRepo extends JpaRepository<Rating, Long> {

    @Query("SELECT r FROM Rating r WHERE r.user.id = :userId")
    List<Rating> findByUserId(@Param("userId") Long userId);
    
    @Query("SELECT r FROM Rating r WHERE r.product.productId = :productId")
    List<Rating> findByProductId(@Param("productId") Integer productId);
    
    @Query("SELECT r FROM Rating r WHERE r.rating = :rating")
    List<Rating> findByRating(@Param("rating") Integer rating);
    
    @Query("SELECT AVG(r.rating) FROM Rating r WHERE r.product.productId = :productId")
    Double findAverageRatingByProductId(@Param("productId") Integer productId);
}
