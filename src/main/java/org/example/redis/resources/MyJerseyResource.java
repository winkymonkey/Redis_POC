package org.example.redis.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.example.redis.services.HashServices;
import org.springframework.beans.factory.annotation.Autowired;


@Path("/v1/main")
@Produces(MediaType.APPLICATION_JSON)
public class MyJerseyResource {
	
	@Autowired
	private HashServices hashServices;
	
	
	private enum HCOMMANDS {
		HSET, HMSET, 
		HGET, HMGET, HGETALL, HKEYS, HVALS, HEXISTS, 
		HLEN,
		HINCRBY
	}
	
	
	@GET
	@Path("/hashOperations/{operation}")
	public Response hmset(@PathParam(value="operation") String operation) {
		Response response;
		try {
			if (operation == null) {
				System.out.println("--------------------");
				throw new Exception();
			}
			
			else if (HCOMMANDS.HSET.name().equals(operation)) {
				System.out.println("--------------------");
				hashServices.hset();
				response = Response.status(Status.OK).entity("HSET DONE").build();
			}
			
			else if (HCOMMANDS.HMSET.name().equals(operation)) {
				System.out.println("--------------------");
				hashServices.hmset();
				response = Response.status(Status.OK).entity("HMSET DONE").build();
			}
			
			else if (HCOMMANDS.HGET.name().equals(operation)) {
				System.out.println("--------------------");
				hashServices.hget();
				response = Response.status(Status.OK).entity("HGET DONE").build();
			}
			
			else if (HCOMMANDS.HMGET.name().equals(operation)) {
				System.out.println("--------------------");
				hashServices.hmget();
				response = Response.status(Status.OK).entity("HMGET DONE").build();
			}
			
			else if (HCOMMANDS.HGETALL.name().equals(operation)) {
				System.out.println("--------------------");
				hashServices.hgetall();
				response = Response.status(Status.OK).entity("HGETALL DONE").build();
			}
			
			else if (HCOMMANDS.HKEYS.name().equals(operation)) {
				System.out.println("--------------------");
				hashServices.hkeys();
				response = Response.status(Status.OK).entity("HKEYS DONE").build();
			}
			
			else if (HCOMMANDS.HVALS.name().equals(operation)) {
				System.out.println("--------------------");
				hashServices.hvals();
				response = Response.status(Status.OK).entity("HVALS DONE").build();
			}
			
			else if (HCOMMANDS.HEXISTS.name().equals(operation)) {
				System.out.println("--------------------");
				hashServices.hexists();
				response = Response.status(Status.OK).entity("HEXISTS DONE").build();
			}
			
			else if (HCOMMANDS.HLEN.name().equals(operation)) {
				System.out.println("--------------------");
				hashServices.hlen();
				response = Response.status(Status.OK).entity("HLEN DONE").build();
			}
			
			else if (HCOMMANDS.HINCRBY.name().equals(operation)) {
				System.out.println("--------------------");
				hashServices.hincrby();
				response = Response.status(Status.OK).entity("HINCRBY DONE").build();
			}
			
			else {
				throw new Exception();
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
			response = Response.status(Status.OK).entity("SORRY").build();
		}
		return response;
	}

}
