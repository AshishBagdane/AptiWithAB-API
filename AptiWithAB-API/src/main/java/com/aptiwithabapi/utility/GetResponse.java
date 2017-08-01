package com.aptiwithabapi.utility;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class GetResponse {

	public static Response forFound(Object entity) {
		return Response.status(Status.FOUND)
						.entity(entity)
						.build();
	}
	
	public static Response forCreated(Object entity) {
		return Response.status(Status.CREATED)
						.entity(entity)
						.build();
	}
	
	public static Response forOk(Object entity) {
		return Response.status(Status.OK)
						.entity(entity)
						.build();
	}
}
