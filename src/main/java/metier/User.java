package metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class User {

    private Long id_user;

    private String name;

    private List<Ticket> ticket = new ArrayList<Ticket>();

    public User() {
        super();
    }

    public User(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
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
    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> tickets) {
        this.ticket = tickets;
    }
}
