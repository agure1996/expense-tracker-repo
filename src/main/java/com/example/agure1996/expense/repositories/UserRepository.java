package com.example.agure1996.expense.repositories;

import com.example.agure1996.expense.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
