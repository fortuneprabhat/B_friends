package com.nagarro.B_friends.service;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.B_friends.model.Friend;

/**
 * 
 * @author prabhatkumar
 * Performs crud operations on friend table. 
 */
public interface FriendService extends CrudRepository<Friend, Integer>{
	Iterable<Friend> findByFirstNameAndLastName(String firstName, String lastName);
	Iterable<Friend> findByFirstName(String firstName);
	Iterable<Friend> findByLastName(String lastName);
}
