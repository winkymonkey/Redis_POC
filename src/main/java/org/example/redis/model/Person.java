package org.example.redis.model;

import java.io.Serializable;


public class Person implements Serializable {
	
	private static final long serialVersionUID = -743245024628112055L;
	
	public String firstName;
	public String lastName;
	public Address address;
	
	public Person(String firstName, String lastName, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	public static class Address {
		public String city;
		public String state;
		
		public Address(String city, String state) {
			this.city = city;
			this.state = state;
		}
	}
	
}
