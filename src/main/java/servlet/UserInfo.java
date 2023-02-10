package servlet;

import dao.EntityManagerHelper;
import dao.PersonneDAO;
import metier.Fiche;
import metier.Personne;
import metier.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "userinfo",
        urlPatterns = {"/UserInfo"})
public class UserInfo extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        out.println("<HTML>\n<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Nom: "
                + request.getParameter("name") + "\n" +
                " <LI>Prenom: "
                + request.getParameter("firstname") + "\n" +
                " <LI>Age: "
                + request.getParameter("age") + "\n" +
                "</UL>\n" +
                "</BODY></HTML>");


        PersonneDAO personneDAO = new PersonneDAO();
        EntityManager manager = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        User user = new User(request.getParameter("name"));
        personneDAO.save(user);
        tx.commit();
        manager.close();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO voir td2
        PersonneDAO personneDAO = new PersonneDAO();
        List<Personne> resultList = personneDAO.getAllPersonne();
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        out.println("<HTML>\n<BODY>\n");

        out.println("<H1>Affichage des Personnes</H1>");
        out.println(" <table> \n " +
                " <thead> \n" +
                " <tr> \n" +
                "    <th>Type</th> \n" +
                "    <th>Id</th> \n" +
                "    <th>Nom</th> \n" +

                " </tr> \n" +
                " </thead> \n" +
                "<tbody> \n");
        for (Personne personne : resultList) {

            String type = personne instanceof User ? "User" : "SupportMember";
            out.println("<tr> \n" +
                    "<td>" + type + "</td> \n" +
                    "<td>" + personne.getId_member() + "</td> \n" +
                    "<td>" + personne.getName() + "</td> \n" +
                    "</tr> \n");
        }
        out.println("</tbody>\n </table> \n</BODY>\n</HTML>");


    }
}
