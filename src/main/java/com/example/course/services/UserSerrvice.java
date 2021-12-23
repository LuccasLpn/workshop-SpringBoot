package com.example.course.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entities.User;
import com.example.course.repositories.UserRepository;
import com.example.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserSerrvice {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional <User> obj = userRepository.findById(id);
		return obj.orElseThrow( () -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public void delete(Long id) {
		userRepository.getById(id);
	}
	
	public User update(Long id,  User obj) {
		@SuppressWarnings("deprecation")
		User entity = userRepository.getOne(id);
		updatedata(entity, obj);
		return userRepository.save(entity);
	}

	private void updatedata(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}

}
