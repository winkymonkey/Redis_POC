package org.example.redis.config;

import org.example.redis.resources.MyJerseyResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;


@Component
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
        register(MyJerseyResource.class);
    }
	
}
