package metier;

import javax.persistence.*;
import java.sql.Date;
@Entity
@DiscriminatorValue("Bug")
public class BugFiche extends Fiche {
    public BugFiche() {
    }

    public BugFiche(String name, User user) {
        super(name,user);
    }

    public BugFiche(String name) {
        super(name);
    }


}
