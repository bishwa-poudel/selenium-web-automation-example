package com.bishwa.project.lis.restful;

import com.bishwa.project.lis.service.CheckInOutService;

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
@Path("/action")
public class CheckInOutRestService {
    @GET
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login() {
        new CheckInOutService().doLogin();
        return Response.status(Response.Status.OK).entity("Check in successful").build();
    }

    @GET
    @Path("checkin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkIn() {
        new CheckInOutService().doCheckIn();
        return Response.status(Response.Status.OK).entity("Check in successful").build();
    }

    @GET
    @Path("checkout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkOut() {
        new CheckInOutService().doCheckOut();
        return Response.status(Response.Status.OK).entity("Check out successful").build();
    }
}
