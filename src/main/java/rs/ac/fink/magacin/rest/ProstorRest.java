/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.fink.magacin.rest;

/**
 *
 * @author andje
 */
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import rs.ac.fink.magacin.data.Prostor;
import rs.ac.fink.magacin.exception.MagacinException;
import rs.ac.fink.magacin.service.ProstorService;

@Path("prostor")
public class ProstorRest {

    private final ProstorService prostorService = ProstorService.getInstance();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Prostor getProstorById(@PathParam("id") int id) throws MagacinException {
        return prostorService.findProstor(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProstor(Prostor prostor) throws MagacinException {
        prostorService.addNewProstor(prostor);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProstor(Prostor prostor) throws MagacinException {
        prostorService.updateProstor(prostor);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProstor(@PathParam("id") int id) throws MagacinException {
        prostorService.deleteProstor(id);
        return Response.ok().build();
    }
}

