package com.example.PracticeExceptions.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PracticeExceptions.Model.User;
import com.example.PracticeExceptions.Repository.UserRepository;
import com.example.PracticeExceptions.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String saveUser(User user) {
		
		user.setName(user.getName());
		
		userRepository.save(user);
		return "Details Saved";
	
	}

}
