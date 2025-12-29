package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.Category;
import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    
    @Query("SELECT c FROM Category c WHERE c.categoryName = :categoryName")
    Category findByCategoryName(@Param("categoryName") String categoryName);
    
    @Query("SELECT c FROM Category c WHERE c.categoryName LIKE %:name%")
    List<Category> findByCategoryNameContaining(@Param("name") String name);
}
