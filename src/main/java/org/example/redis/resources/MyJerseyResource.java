package org.example.redis.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.example.redis.services.HashServices;
import org.example.redis.services.StringServices;
import org.springframework.beans.factory.annotation.Autowired;


@Path("/v1/main")
@Produces(MediaType.APPLICATION_JSON)
public class MyJerseyResource {
	
	@Autowired
	private StringServices stringServices;
	
	@Autowired
	private HashServices hashServices;
	
	
	
	
	private enum SCOMMANDS {
		SET, MSET,    GET, MGET, GETRANGE,    STRLEN,    APPEND, SETRANGE
	}
	
	private enum HCOMMANDS {
		HSET, HMSET,    HGET, HMGET, HGETALL,    HKEYS, HVALS, HEXISTS,    HLEN,    HINCRBY
	}
	
	
	
	
	@GET
	@Path("/stringOperations/{operation}")
	public Response stringOperations(@PathParam(value="operation") String operation) {
		Response response;
		try {
			if (operation == null) {
				System.out.println("--------------------");
				throw new Exception();
			}
			
			else if (SCOMMANDS.SET.name().equals(operation)) {
				System.out.println("--------------------");
				stringServices.set();
				response = Response.status(Status.OK).entity("SET DONE").build();
			}
			
			else if (SCOMMANDS.MSET.name().equals(operation)) {
				System.out.println("--------------------");
				stringServices.mset();
				response = Response.status(Status.OK).entity("MSET DONE").build();
			}
			
			else if (SCOMMANDS.GET.name().equals(operation)) {
				System.out.println("--------------------");
				stringServices.get();
				response = Response.status(Status.OK).entity("GET DONE").build();
			}
			
			else if (SCOMMANDS.MGET.name().equals(operation)) {
				System.out.println("--------------------");
				stringServices.mget();
				response = Response.status(Status.OK).entity("MGET DONE").build();
			}
			
			else if (SCOMMANDS.GETRANGE.name().equals(operation)) {
				System.out.println("--------------------");
				stringServices.getrange();
				response = Response.status(Status.OK).entity("GETRANGE DONE").build();
			}
			
			else if (SCOMMANDS.STRLEN.name().equals(operation)) {
				System.out.println("--------------------");
				stringServices.strlen();
				response = Response.status(Status.OK).entity("STRLEN DONE").build();
			}
			
			else if (SCOMMANDS.APPEND.name().equals(operation)) {
				System.out.println("--------------------");
				stringServices.append();
				response = Response.status(Status.OK).entity("APPEND DONE").build();
			}
			
			else if (SCOMMANDS.SETRANGE.name().equals(operation)) {
				System.out.println("--------------------");
				stringServices.setrange();
				response = Response.status(Status.OK).entity("SETRANGE DONE").build();
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
	
	
	
	
	@GET
	@Path("/hashOperations/{operation}")
	public Response hashOperations(@PathParam(value="operation") String operation) {
		Response response;
		try {
			if (operation == null) {
				System.out.println("--------------------");
				throw new Exception();
			}
			
			else if (HCOMMANDS.HSET.name().equals(operation)) {
				System.out.println("--------------------");
				hashServices.hset_withDefaultSerializer();
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
