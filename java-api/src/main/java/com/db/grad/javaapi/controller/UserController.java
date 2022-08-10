package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.BookRepository;
import com.db.grad.javaapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000","https://pets-webapp-dot-db-grads-173c-group-22.nw.r.appspot.com")


public class UserController {
	 	@Autowired
	    private BookRepository bookRepository;

	    @Autowired
	    private UserRepository userRepository;

	    @GetMapping("/users")
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    @GetMapping("/user/{id}")
	    public ResponseEntity< User > getUserById(@PathVariable(value = "id") Long id)
	            throws ResourceNotFoundException {
	        User user = userRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
	        return ResponseEntity.ok().body(user);
	    }

	    @PostMapping("/user")
	    public User createUser(@Valid @RequestBody User user) {
	        return userRepository.saveAndFlush(user);
	    }

	    @PutMapping("/user/{id}")
	    public ResponseEntity < User > updateUser(@PathVariable(value = "id") Long id,
	                                             @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
	        User getUser = userRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));


	        getUser.setName(userDetails.getName());
	        getUser.setEmail(userDetails.getEmail());
	        getUser.setRole(userDetails.getRole());

	        final User updatedUser = userRepository.save(getUser);
	        return ResponseEntity.ok(updatedUser);
	    }

	    @DeleteMapping("/user/{id}")
	    public Map< String, Boolean > deleteUser(@PathVariable(value = "id") Long id)
	            throws Exception {
	        User user = userRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));

	        userRepository.delete(user);
	        Map < String, Boolean > response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}
