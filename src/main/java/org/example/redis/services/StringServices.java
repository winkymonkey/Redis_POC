package org.example.redis.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;


@Service
public class StringServices {
	
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
	 * Set a single string
	 * SET place "India"
	 */
	public void set() {
		valueOps.set("place", "India");
	}
	
	/**
	 * Set multiple strings
	 */
	public void mset() {
		Map<String, String> map = new HashMap<>();
		map.put("fname", "tom");
		map.put("lname", "cruise");
		valueOps.multiSet(map);
	}
	
	
	
	
	/**
	 * Get a single string
	 * GET place
	 */
	public void get() {
		System.out.println( valueOps.get("place") );
	}
	
	/**
	 * Get multiple strings
	 * MGET fname place
	 */
	public void mget() {
		System.out.println( valueOps.multiGet(Arrays.asList("fname", "place")) );
	}
	
	/**
	 * Get substring of a string
	 * GETRANGE place 0 3
	 */
	public void getrange() {
		System.out.println( valueOps.get("place", 0, 3) );
		System.out.println( valueOps.get("place", 0, -1) );
		System.out.println( valueOps.get("place", -3, -1) );
	}
	
	
	
	/**
	 * Get length of a string
	 * STRLEN place
	 */
	public void strlen() {
		System.out.println( valueOps.size("place") );
	}
	
	
	
	/**
	 * Update string (append)
	 * APPEND fname "my"
	 */
	public void append() {
		valueOps.append("fname", "my");
	}
	
	/**
	 * Update string (any)
	 * SETRANGE fname 3 "Cruise"
	 */
	public void setrange() {
		valueOps.set("fname", "Cruise", 3);
	}
	
}
	