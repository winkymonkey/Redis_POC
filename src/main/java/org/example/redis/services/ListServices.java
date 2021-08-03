package org.example.redis.services;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;


@Service
public class ListServices {
	
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
	 * Push one value (at head)
	 * LPUSH list1 z
	 * 
	 * Push multiple values (at head)
	 * LPUSH list2 y x
	 */
	public void lpush() {
		//
	}
	
	/**
	 * Push one value (at tail)
	 * RPUSH list1 a
	 * 
	 * Push multiple values (at tail)
	 * RPUSH list1 b d
	 */
	public void rpush() {
		//
	}
	
	/**
	 * Insert before a value
	 * LINSERT list1 BEFORE d c
	 * 
	 * Insert after a value
	 * LINSERT list1 AFTER d p
	 */
	public void linsert() {
		//
	}
	
	/**
	 * Insert at specific index
	 * LSET list1 7 e
	 */
	public void lset() {
		//
	}
	
	
	
	
	/**
	 * Get values
	 * LRANGE list1 0 3
	 */
	public void lrange() {
		//
	}
	
	/**
	 * Get value by index
	 * LINDEX list1 2
	 */
	public void lindex() {
		//
	}
	
	
	
	
	/**
	 * Number of elements
	 * LLEN list1
	 */
	public void llen() {
		//
	}
	
	
	
	
	/**
	 * Remove element from head
	 * LPOP list1
	 */
	public void lpop() {
		//
	}
	
	/**
	 * Remove element from tail
	 * RPOP list1
	 */
	public void rpop() {
		//
	}
	
	/**
	 * Remove 2 “a” from head
	 * LREM list1 2 a
	 * 
	 * Remove 3 “z” from tail
	 * LREM list1 -3 z
	 */
	public void lrem() {
		//
	}
	
	
	
	
	/**
	 * Trim a list
	 * LTRIM list1 1 -2
	 */
	public void ltrim() {
		
	}
	
}
