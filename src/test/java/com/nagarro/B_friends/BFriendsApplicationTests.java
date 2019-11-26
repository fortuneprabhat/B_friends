package com.nagarro.B_friends;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.nagarro.B_friends.controller.FriendController;

@SpringBootTest
class BFriendsApplicationTests {

	@Autowired
	FriendController friendController;
	@Test
	void contextLoads() {
		Assert.notNull(friendController, "no value present.");
	}

}
