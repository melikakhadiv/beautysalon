package com.example.beautysalon.controller.api;

import com.example.beautysalon.model.entity.User;
import com.example.beautysalon.model.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findById(@PathParam("id") long id) {
        try {
            System.out.println(id);
            User user = UserService.getService().findById(id);
            return Response.ok().entity(user).build();
        }catch (NotFoundException e){
            return Response.noContent().build();
        }catch (Exception e){
            return Response
                    .status(700)
                    .entity("error")
                    .build();
        }
    }
}
