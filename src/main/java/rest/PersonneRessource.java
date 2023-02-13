package rest;

import dao.PersonneDAO;
import metier.Personne;
import metier.SupportMember;
import metier.User;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Parameter;

@Path("/personne")
@Produces({"application/json", "application/xml"})
public class PersonneRessource {

    @GET
    @Path("/{personneId}")
    public Personne getPersonneById(@PathParam("personneId") Long personneId) {
        PersonneDAO personneDAO = new PersonneDAO();
        Personne personne = personneDAO.getPersonneByID(personneId);
        String type = personne instanceof User ? "User" : "SupportMember";
        // return pet
        if(type == "User"){
            User user = new User();
            user.setId_member(personne.getId_member());
            user.setName(personne.getName());
            return user;
        } else{
            SupportMember support = new SupportMember();
            support.setId_member(personne.getId_member());
            support.setName(personne.getName());
            return support;
        }

    }

    @POST
    @Consumes("application/json")
    public Response addPersonne(
            @Parameter(description = "Personne object that needs to be added to the list", required = true) Personne personne) {
        // add pet

        return Response.ok().entity("SUCCESS").build();
    }
}