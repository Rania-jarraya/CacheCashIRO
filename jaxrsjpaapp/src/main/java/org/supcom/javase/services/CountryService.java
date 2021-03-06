package org.supcom.javase.services;

import org.supcom.javase.managers.CountryManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/countries")
public class CountryService {
    @Inject
    private CountryManager manager;

    @GET
    @Path("/{code}")
    public Response getById(@PathParam("code")String code){
        return Response.ok().entity(manager.findById(code)).build();
    }

    @PUT
    @Consumes("application/xml")
    public void update(Country country){
        manager.editCountry(country);
        //return Response.ok().entity(country).build();
    }
}
