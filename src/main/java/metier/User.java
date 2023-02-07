package metier;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class User {

    private Long id_user;

    private String name;

    private List<Fiche> tickets = new ArrayList<Fiche>();

    public User() {
        super();
    }

    public User(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id_user;
    }

    public void setId(Long id) {
        this.id_user = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    public List<Fiche> getTicket() {
        return tickets;
    }

    public void setTicket(List<Fiche> tickets) {
        this.tickets = tickets;
    }
    public void submitTicket(String title,String description){
        Fiche ticket = new BugFiche();
        ticket.setTitle(title);
        ticket.setDescription(description);
        ticket.setDateEmission(Date.valueOf(LocalDate.now()));
        ticket.setUser(this);
        ticket.setTags(Tags.NEW.toString());
        tickets.add(ticket);
    }
}
