package com.nagarro.B_friends;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nagarro.B_friends.model.Friend;


public class SystemTest {
	/*
	 * @Test public void createReadDelete() { RestTemplate restTemplate = new
	 * RestTemplate(); String url = "http://localhost:8081/friend";
	 * 
	 * Friend friend = new Friend("Prabhat","Kumar"); ResponseEntity<Friend> entity
	 * = restTemplate.postForEntity(url, friend, Friend.class);
	 * 
	 * Friend[] friends = restTemplate.getForObject(url, Friend[].class);
	 * Assertions.assertThat(friends).extracting(Friend::getFirstName).containsOnly(
	 * "Prabhat");
	 * 
	 * restTemplate.delete(url+"/"+entity.getBody().getId());
	 * Assertions.assertThat(restTemplate.getForObject(url,
	 * Friend[].class)).isEmpty(); }
	 */
}
