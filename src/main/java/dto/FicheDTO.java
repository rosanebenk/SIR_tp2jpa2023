package dto;

import javax.validation.constraints.NotNull;
import metier.SupportMember;
import metier.User;

import java.sql.Date;

public class FicheDTO {
    //	{ "id" : "1", "title": "first ticket", "description" : "blabla", "dateEmission" : "01/01/2023", "datePriseenCharge" : "01/01/2023" , "dateCloture" : "01/01/2023", "support" : "Yves", "user" : "Mickael", "tag" : "NEW"}
    @NotNull(message = "Name may not be null")
    Long id;

    String title;
    String description;
    Date dateEmission;
    Date datePriseenCharge;
    Date dateCloture;
    SupportMember support;
    User user;
    String tag ;

    public Long getId() {
        return id;
    }
    public void setId(String email) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
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

    public SupportMember getSupport() {
        return support;
    }

    public void setSupport(SupportMember support) {
        this.support = support;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }



}
