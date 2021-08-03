package org.example.redis.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Resource;

import org.example.redis.model.Person;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;


@Service
public class HashServices {
	
	@Resource(name = "redisTemplate")
	private ValueOperations<String, Object> valueOps;
	
	@Resource(name = "redisTemplate")
	private ListOperations<String, Object> listOps;
	
	@Resource(name = "redisTemplate")
	private HashOperations<String, String, Object> hashOps;
	
	@Resource(name = "redisTemplate")
	private SetOperations<String, Object> setOps;
	
	@Resource(name = "redisTemplate")
	private ZSetOperations<String, Object> sortedSetOps;
	
	
	public void hmset() {
		List<String> list = Stream.of("alpha", "beta", "gamma").collect(Collectors.toList());
		
		Person person = new Person("Abhishek", "Pal");
		
		hashOps.put("hash1", "k1", "v1");
		hashOps.put("hash1", "k2", "v2");
		hashOps.put("hash1", "k3", list.toString());
		hashOps.put("hash1", "k4", String.valueOf(true));
		hashOps.put("hash1", "k5", person);
		
		hashOps.put("hash2", "k1", "v1");
	}
	
	public void hmget() {
		System.out.println(hashOps.get("hash1", "k1"));
	}
	
	public void hgetall() {
		System.out.println(hashOps.entries("hash1"));
	}
	
	public void hkeys() {
		System.out.println(hashOps.keys("hash1"));
	}
	
	public void hvals() {
		System.out.println(hashOps.values("hash1"));
	}
	
	public void hexists() {
		System.out.println(hashOps.hasKey("hash1", "k1"));
		System.out.println(hashOps.hasKey("hash1", "k100"));
	}
	
	public void hlen() {
		System.out.println(hashOps.size("hash1"));
	}
	
}
