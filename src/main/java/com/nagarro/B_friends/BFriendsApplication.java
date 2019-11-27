package com.nagarro.B_friends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author prabhatkumar
 * Bootstrap spring application
 * performs
 * 1. Auto configuration
 * 2. Start Application Context.
 * 3. Perform class path scan
 * 4. Start tomcat server. 
 * https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-endpoints
 */

@SpringBootApplication
public class BFriendsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BFriendsApplication.class, args);
	}

}
