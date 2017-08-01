package com.aptiwithabapi.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.aptiwithabapi.models.ErrorMessage;

@Provider
public class DataUpdateFailedExceptionMapper implements ExceptionMapper<DataUpdateFailedException> {

	@Override
	public Response toResponse(DataUpdateFailedException exception) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 409, "https://ashishbagdane.github.io/");
		return Response.status(Status.CONFLICT)
						.entity(errorMessage)
						.build();
	}

}
