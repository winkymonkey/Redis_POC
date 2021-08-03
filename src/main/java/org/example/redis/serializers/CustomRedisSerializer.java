package org.example.redis.serializers;

import java.nio.charset.Charset;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.Assert;

import com.google.gson.Gson;


public class CustomRedisSerializer implements RedisSerializer<Object> {

	private final Charset charset;

	private final String target = "\"";

	private final String replacement = "";

	public CustomRedisSerializer() {
		this(Charset.forName("UTF8"));
	}

	public CustomRedisSerializer(Charset charset) {
		Assert.notNull(charset, "Charset must not be null!");
		this.charset = charset;
	}

	@Override
	public String deserialize(byte[] bytes) {
		return (bytes == null ? null : new String(bytes, charset));
	}

	@Override
	public byte[] serialize(Object object) {
		String string = new Gson().toJson(object);
		if (string == null) {
			return null;
		}
		string = string.replace(target, replacement);
		return string.getBytes(charset);
	}
	
}