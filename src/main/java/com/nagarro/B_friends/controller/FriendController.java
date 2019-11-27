package com.nagarro.B_friends.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.B_friends.model.Friend;
import com.nagarro.B_friends.service.FriendService;
import com.nagarro.B_friends.util.ErrorMessage;
import com.nagarro.B_friends.util.FieldErrorMessage;

/**
 * 
 * @author prabhatkumar
 * Friend controller is responsible for receiving http request and send response in 
 * json format.
 * @RestController= @Controller + @ResponseBody
 *
 */
@RestController
public class FriendController {
	//https://www.mkyong.com/spring-boot/spring-boot-slf4j-logging-example/
	private static final Logger logger = LoggerFactory.getLogger(FriendController.class);
	@Autowired
	FriendService friendService;
	
	@GetMapping("/friend")
	Iterable<Friend> read(){
		logger.debug("*********Log Tested.****************");
		return friendService.findAll();
	}
	
	@PostMapping("/friend")
	Friend create(@Valid @RequestBody Friend friend) throws ValidationException {
		if((friend.getFirstName()!=null)&&(friend.getLastName()!=null)&&(friend.getId()>=0)&&(friend.getAge()>-1)) {
			return friendService.save(friend);
		}
		
		throw new ValidationException("Bad Request");
	}
	/*@PostMapping("/friend")
	Friend create(@Valid @RequestBody Friend friend) {
			return friendService.save(friend);
	}
	
	
	 * @ExceptionHandler(MethodArgumentNotValidException.class){
	 * exceptionHandler(MethodArgumentNotValidException e){ List<FieldError>
	 * fieldErrors=(List<FieldError>) e.getBindingResult().getFieldError();
	 * fieldErrors.stream().map(fieldError - > new FieldErrorMessage(fieldError.,
	 * message)); } }
	 */
	
	/*@PutMapping("/friend")
	Friend update(@RequestBody Friend friend) {
		return friendService.save(friend);
	}*/
	@PutMapping("/friend")
	public ResponseEntity<Friend> update(@RequestBody Friend friend) {
		if(friendService.findById(friend.getId()).isPresent()) {
			return new ResponseEntity<Friend>(friendService.save(friend), HttpStatus.OK);
		}
		return new ResponseEntity<Friend>(friend, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/friend/{id}")
	void delete(@PathVariable Integer id) {
		friendService.deleteById(id);
	}
	
	
	//Search Function
	@GetMapping("/friend/{id}")
	Optional<Friend> findFriend(@PathVariable Integer id){
		return friendService.findById(id);
	}
	
	@GetMapping("/friend/search")
	Iterable<Friend> findByQuery(@RequestParam(value="fname", required=false) String firstName, @RequestParam(value="lname", required=false) String lastName){
		if((firstName!=null)&&(lastName!=null)) {
			return friendService.findByFirstNameAndLastName(firstName, lastName);
		}else if(firstName!=null) {
			return friendService.findByFirstName(firstName);
		}else if(lastName!=null) {
			return friendService.findByLastName(lastName);
		}
		return friendService.findAll();
	}
}
