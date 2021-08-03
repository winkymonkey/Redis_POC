package org.example.redis.config;

import java.time.Duration;

import org.example.redis.serializers.CustomRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
public class RedisConfig {
	
	private static final String host = "localhost";
	private static final Integer port = 6379;
	private static final String password = "";
	private static final Long readTimeout = 5000L;
	private static final Long connectTimeout = 5000L;
	

	@Bean
	public RedisTemplate<String, String> redisTemplate() {
		RedisTemplate<String, String> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setKeySerializer(keySerializer());
		template.setHashKeySerializer(keySerializer());
		template.setValueSerializer(valueSerializerCustom());
		template.setHashValueSerializer(valueSerializerCustom());
		template.afterPropertiesSet();
		return template;
	}
	
	private RedisSerializer<String> keySerializer() {
		return new StringRedisSerializer();
	}

	private RedisSerializer<Object> valueSerializer() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		jackson2JsonRedisSerializer.setObjectMapper(mapper);
		return jackson2JsonRedisSerializer;
	}
	//--OR--
	private RedisSerializer<Object> valueSerializerCustom() {
		return new CustomRedisSerializer();
	}
	
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setHostName(host);
		redisStandaloneConfiguration.setPort(port);
		redisStandaloneConfiguration.setPassword(RedisPassword.of(password));

		JedisClientConfiguration clientConfiguration = JedisClientConfiguration.builder()
															.readTimeout(Duration.ofMillis(readTimeout))
															.connectTimeout(Duration.ofMillis(connectTimeout))
															.usePooling()
															.build();
		return new JedisConnectionFactory(redisStandaloneConfiguration, clientConfiguration);
	}
		
}
