package com.nagarro.B_friends.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FriendServiceAspect {
	@Before(value = "execution(* com.nagarro.B_friends.service.FriendService.*(..)) and args(firstName,lastName)")
	public void beforeAdvice(JoinPoint joinPoint, String firstName, String lastName) {
		System.out.println("Before method:" + joinPoint.getSignature());

		System.out.println("find Friend with name - " + firstName + " and id - " + lastName);
	}

	@After(value = "execution(* com.nagarro.B_friends.service.FriendService.*(..)) and args(firstName,lastName)")
	public void afterAdvice(JoinPoint joinPoint, String firstName, String lastName) {
		System.out.println("After method:" + joinPoint.getSignature());

		System.out.println("Successfully created Friend with name - " + firstName + " and id - " + lastName);
	}
}
