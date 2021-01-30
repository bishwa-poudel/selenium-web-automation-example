package com.bishwa.project.intranetfunction.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 10:28
 */
@Path("/")
public class CheckInOutRestService {
    @GET
    @Path("checkin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkIn() {
        return Response.status(Response.Status.OK).entity("Check in successful").build();
    }

    @GET
    @Path("checkout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkOut() {
        return Response.status(Response.Status.OK).entity("Check out successful").build();
    }
}
