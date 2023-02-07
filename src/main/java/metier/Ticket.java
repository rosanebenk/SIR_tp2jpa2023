package metier;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Ticket {

    private Long id;
    private String title;
    private String description;
    private Date dateEmission;
    private Date datePriseenCharge;
    private Date dateCloture;
    private SupportMember support;
    private User user;
    private String tag ;


    public Ticket() {
    }

    public Ticket(String name, User user) {
        this.title = name;
        this.user = user;
    }

    public Ticket(String name) {
        this.title = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ticket [id=" + id + ", name=" + title + ", user="
                + user.getName() + "]";
    }
    //@OneToMany(mappedBy = "tag", cascade = CascadeType.PERSIST)
    public String getTags() {
        return tag;
    }

    public void setTags(String tag) {this.tag = tag;}

    @ManyToOne
    public SupportMember getMember() {return support;}

    public void setMember(SupportMember support) {this.support = support;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateEmission() {
        return dateEmission;
    }

    public void setDateEmission(Date dateEmission) {
        this.dateEmission = dateEmission;
    }

    public Date getDatePriseenCharge() {
        return datePriseenCharge;
    }

    public void setDatePriseenCharge(Date datePriseenCharge) {
        this.datePriseenCharge = datePriseenCharge;
    }

    public Date getDateCloture() {
        return dateCloture;
    }

    public void setDateCloture(Date dateCloture) {
        this.dateCloture = dateCloture;
    }

}

