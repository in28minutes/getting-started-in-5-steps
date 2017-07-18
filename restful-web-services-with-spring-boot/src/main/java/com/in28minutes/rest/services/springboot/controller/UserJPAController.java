package com.in28minutes.rest.services.springboot.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.services.springboot.bean.Post;
import com.in28minutes.rest.services.springboot.bean.User;
import com.in28minutes.rest.services.springboot.service.PostRepository;
import com.in28minutes.rest.services.springboot.service.UserRepository;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserJPAController {

	@Autowired
	private UserRepository userService;

	@Autowired
	private PostRepository postService;

	@ApiOperation(value = "Retrieve all users", notes = "A list of all users.", response = User.class, responseContainer = "List", produces = "application/json")
	@GetMapping("/jpa/users")
	public Page<User> retrieveAllUsers(Pageable pageRequest) {
		return userService.findAll(pageRequest);
	}

	@ApiOperation(value = "Retrieve all users", notes = "A list of all users.", response = User.class, responseContainer = "List", produces = "application/json")
	@GetMapping("/jpa/users-with-hateoas")
	public HttpEntity<PagedResources<User>> retrieveAllUsersWithHateoas(Pageable pageRequest,
			PagedResourcesAssembler assembler) {
		Page<User> users = userService.findAll(pageRequest);
		return new ResponseEntity<>(assembler.toResource(users), HttpStatus.OK);
	}

	@GetMapping(path = "/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id, Pageable pageRequest) {
		Optional<User> user = userService.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		Resource<User> userResource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers(pageRequest));
		userResource.add(linkTo.withRel("all-users"));
		return userResource;
	}

	@PostMapping("/jpa/users")
	ResponseEntity<?> add(@Valid @RequestBody User userToSave) {
		User user = userService.save(userToSave);
		if (user == null) {
			return ResponseEntity.noContent().build();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllPosts(@PathVariable int id) {
		Optional<User> user = userService.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		return user.get().getPosts();
	}

	@PostMapping("/jpa/users/{id}/posts")
	ResponseEntity<?> addPost(@PathVariable int id, @RequestBody Post postToSave) {

		Optional<User> user = userService.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}

		postToSave.setUser(user.get());

		postService.save(postToSave);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(postToSave.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}