package com.example.PracticeExceptions.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PracticeExceptions.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}