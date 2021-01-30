package com.bishwa.project.home;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Author: Bishwa
 * Date: 30/01/2021
 * Time: 10:42
 */
@Path("/")
public class Welcome {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response home() {
        return Response.ok("Welcome to LIS Intranet Automation v1.0").build();
    }
}
