package org.example.redis.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.example.redis.model.Person;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.stereotype.Service;


@Service
public class HashServices {
	
	@Resource(name = "redisTemplate")
	private ValueOperations<String, Object> valueOps;
	
	@Resource(name = "redisTemplate")
	private HashOperations<String, String, Object> hashOps;
	
	@Resource(name = "redisTemplate")
	private ListOperations<String, Object> listOps;
	
	@Resource(name = "redisTemplate")
	private SetOperations<String, Object> setOps;
	
	@Resource(name = "redisTemplate")
	private ZSetOperations<String, Object> sortedSetOps;
	
	
	
	
	/**
	 * Set a key-value
	 * HSET hash1 hobby football
	 */
	public void hset_withDefaultSerializer() {
		hashOps.put("hash1", "hobby", "football");
		hashOps.put("hash1", "age", String.valueOf(30));
		hashOps.put("hash1", "fruits", Arrays.asList("mango", "apple", "bannana").toString());
		hashOps.put("hash1", "isOpen", String.valueOf(true));
		
		Person person  = new Person("Abhishek", "Pal", new Person.Address("kolkata", "westBengal"));
		Map<String, Object> mappedHash = new Jackson2HashMapper(false).toHash(person);
		hashOps.putAll("hash1", mappedHash);
	}
	
	public void hset_withCustomSerializer() {
		hashOps.put("hash1", "hobby", "football");
		hashOps.put("hash1", "age", String.valueOf(30));
		hashOps.put("hash1", "fruits", Arrays.asList("mango", "apple", "bannana").toString());
		hashOps.put("hash1", "isOpen", String.valueOf(true));
		hashOps.put("hash1", "person", new Person("Abhishek", "Pal", new Person.Address("kolkata", "westBengal")));
	}
	
	/**
	 * Set multiple key-value
	 * HMSET hash2 name tom place london
	 */
	public void hmset() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "tom");
		map.put("place", "london");
		hashOps.putAll("hash2", map);
	}
	
	
	
	
	/**
	 * Get a key-value
	 * HGET hobby
	 */
	public void hget() {
		System.out.println( hashOps.get("hash1", "hobby") );
	}
	
	/**
	 * Get multiple key-value
	 * HMGET hobby fruits isOpen person
	 */
	public void hmget() {
		System.out.println( hashOps.multiGet("hash1", Arrays.asList("hobby", "age", "fruits", "isOpen", "person")) );
	}
	
	/**
	 * Get all keys
	 * HKEYS hash1
	 */
	public void hkeys() {
		System.out.println( hashOps.keys("hash1") );
	}
	
	/**
	 * Get all values
	 * HVALS hash1
	 */
	public void hvals() {
		System.out.println( hashOps.values("hash1") );
	}
	
	/**
	 * Get all keys & values
	 * HGETALL hash1
	 */
	public void hgetall() {
		System.out.println(hashOps.entries("hash1"));
	}
	
	/**
	 * Check if a key exists
	 * HEXISTS hash1 hobby
	 */
	public void hexists() {
		System.out.println(hashOps.hasKey("hash1", "hobby"));
	}
	
	
	
	
	/**
	 * Number of keys
	 * HLEN hash1
	 */
	public void hlen() {
		System.out.println(hashOps.size("hash1"));
	}
	
	
	
	
	/**
	 * Update a value
	 * HINCRBY hash1 age 5
	 */
	public void hincrby() {
		hashOps.increment("hash1", "age", 5);
		hashOps.increment("hash1", "age", -2);
		hashOps.increment("hash1", "age", 0.2);
		hashOps.increment("hash1", "age", -0.5);
	}
	
	
}
