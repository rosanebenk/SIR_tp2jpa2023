package servlet;
import dao.EntityManagerHelper;
import dao.FicheDAO;
import dao.PersonneDAO;
import metier.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ficheinfo",
        urlPatterns={"/FicheInfo"})
public class FicheInfo extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        out.println("<HTML>\n<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Type: "
                + request.getParameter("type") + "\n" +
                " <LI>User: "
                + request.getParameter("user") + "\n" +
                " <LI>Title: "
                + request.getParameter("title") + "\n" +
                " <LI>Description: "
                + request.getParameter("description") + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");


        FicheDAO ficheDAO = new FicheDAO();
        Fiche fiche;
        String type = request.getParameter("type");
        if(type == "bug"){
            fiche = new BugFiche(request.getParameter("title"));
        }else{
            fiche = new FeatureRequestFiche(request.getParameter("title"));
        }

        fiche.setDescription(request.getParameter("description"));

        PersonneDAO personneDAO = new PersonneDAO();
        Personne user = personneDAO.getPersonneByID(Long.parseLong(request.getParameter("user")));

        fiche.setUser((User) user);

        EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        ficheDAO.save(fiche);
        tx.commit();
        manager.close();

    }
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        // TODO voir td2
        FicheDAO ficheDaO = new FicheDAO();
        List<Fiche> resultList = ficheDaO.getAllFiches();
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        out.println("<HTML>\n<BODY>\n");

        out.println("<H1>Affichage des Fiches</H1>");
        out.println(" <table> \n " +
                " <thead> \n" +
                " <tr> \n" +
                "    <th>Type</th> \n" +
                "    <th>ID</th> \n" +
                "    <th>Date d'Emission</th> \n" +
                "    <th>Date de Prise En Charge</th> \n" +
                "    <th>Date de Cloture</th> \n" +
                "    <th>Tag</th> \n" +
                "    <th>Titre</th> \n" +
                "    <th>Description</th> \n" +
                " </tr> \n" +
                " </thead> \n" +
                "<tbody> \n");
        for (Fiche fiche : resultList) {

            String type = fiche instanceof BugFiche ? "Bug" : "Feature Request";
            out.println("<tr> \n" +
                    "<td>" +  type +"</td> \n"+
                    "<td>" +  fiche.getId() +"</td> \n"+
                    "<td>" +  fiche.getDateEmission() +"</td> \n"+
                    "<td>" +  fiche.getDatePriseenCharge() +"</td> \n"+
                    "<td>" +  fiche.getDateCloture() +"</td> \n"+
                    "<td>" +  fiche.getTags() +"</td> \n"+
                    "<td>" +  fiche.getTitle() +"</td> \n"+
                    "<td>" +  fiche.getDescription() +"</td> \n"+
                    "</tr> \n");
        }
        out.println("</tbody>\n </table> \n</BODY>\n</HTML>");

    }
}
