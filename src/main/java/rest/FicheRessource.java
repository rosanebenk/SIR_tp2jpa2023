package rest;

import dao.FicheDAO;
import dao.PersonneDAO;
import io.swagger.v3.oas.annotations.Parameter;
import metier.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/fiche")
@Produces({"application/json", "application/xml"})
public class FicheRessource {

    @GET
    @Path("/{ficheId}")
    public Fiche getFicheById(@PathParam("ficheId") Long ficheId) {
        FicheDAO ficheDAO = new FicheDAO();
        Fiche fiche = ficheDAO.getFicheByID(ficheId);
        String type = fiche instanceof BugFiche ? "Bug" : "Feature";
        // return pet
        if (type == "Bug") {
            return new BugFiche();
        } else {
            return new FeatureRequestFiche();
        }

    }

    @POST
    @Consumes("application/json")
    public Response addFiche(
            @Parameter(description = "Personne object that needs to be added to the list", required = true) Personne personne) {
        // add pet

        return Response.ok().entity("SUCCESS").build();
    }

}
