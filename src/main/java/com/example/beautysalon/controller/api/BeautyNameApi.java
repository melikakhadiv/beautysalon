package com.example.beautysalon.controller.api;

import com.example.beautysalon.model.service.BeautyNameService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/service")
public class BeautyNameApi {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@QueryParam("id") Integer id){
        try{
        return Response
                .ok()
                .entity(BeautyNameService.getService().findById(id))
                .build();
    }catch (Exception e){
            return Response
                    .status(500)
                    .entity("error")
                    .build();
        }
        }
}
