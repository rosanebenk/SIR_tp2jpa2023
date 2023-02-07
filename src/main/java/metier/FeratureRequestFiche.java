package metier;

import javax.persistence.*;

@Entity
@DiscriminatorValue("FeratureRequest")
public class FeratureRequestFiche extends Fiche{
    public FeratureRequestFiche() {
    }

    public FeratureRequestFiche(String name, User user) {
        super(name,user);
    }

    public FeratureRequestFiche(String name) {
        super(name);
    }

}
