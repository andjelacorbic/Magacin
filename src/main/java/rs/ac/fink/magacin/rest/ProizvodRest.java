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
import rs.ac.fink.magacin.data.Proizvod;
import rs.ac.fink.magacin.exception.MagacinException;
import rs.ac.fink.magacin.service.ProizvodService;

@Path("proizvod")
public class ProizvodRest {

    private final ProizvodService proizvodService = ProizvodService.getInstance();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Proizvod getProizvodById(@PathParam("id") int id) throws MagacinException {
        return proizvodService.findProizvod(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProizvod(Proizvod proizvod) throws MagacinException {
        proizvodService.addNewProizvod(proizvod);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProizvod(Proizvod proizvod) throws MagacinException {
        proizvodService.updateProizvod(proizvod);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProizvod(@PathParam("id") int id) throws MagacinException {
        proizvodService.deleteProizvod(id);
        return Response.ok().build();
    }
}
