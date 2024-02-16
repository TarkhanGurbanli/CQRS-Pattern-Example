package com.example.cqrspatternexample.repository;

import com.example.cqrspatternexample.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
