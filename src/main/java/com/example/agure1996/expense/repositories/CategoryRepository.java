package com.example.agure1996.expense.repositories;

import com.example.agure1996.expense.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
