package org.example.redis.model;

import java.io.Serializable;


@SuppressWarnings("unused")
public class Person implements Serializable {
	
	private static final long serialVersionUID = -743245024628112055L;
	
	private String firstName;
	private String lastName;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
}
