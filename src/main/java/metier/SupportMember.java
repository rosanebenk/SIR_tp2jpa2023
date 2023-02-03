package metier;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SupportMember {
    private Long id_member;

    private String name;

    private List<Ticket> ticket = new ArrayList<Ticket>();

    public SupportMember() {}

    public SupportMember(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId_member() {
        return id_member;
    }

    public void setId_member(Long id) {
        this.id_member = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "supportmember", cascade = CascadeType.PERSIST)
    public List<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(List<Ticket> tickets) {
        this.ticket = tickets;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id_member + ", name=" + name+ "]";
    }
}
