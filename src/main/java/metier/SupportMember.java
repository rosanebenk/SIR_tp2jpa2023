package metier;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("SupportMember")

public class SupportMember extends Personne{
    private List<Fiche> tickets = new ArrayList<Fiche>();
    public SupportMember() {super();}

    public SupportMember(String name) {
        super(name);
    }

    @OneToMany(targetEntity = Fiche.class, mappedBy = "support")
    public List<Fiche> getTicket() {
        return tickets;
    }

    public void setTicket(List<Fiche> tickets) {
        this.tickets = tickets;
    }

}
