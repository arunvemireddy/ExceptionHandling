package com.example.PracticeExceptions.Service;

import org.springframework.stereotype.Service;

import com.example.PracticeExceptions.Model.User;

@Service
public interface UserService {

	public String saveUser(User user);

}
