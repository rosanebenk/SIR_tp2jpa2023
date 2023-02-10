package dao;

import metier.Fiche;
import metier.Personne;

import java.util.List;

public class FicheDAO extends GenericDaoJpaImpl<Fiche, Long>{
    public List<Fiche> getFicheByTitle(String title){

        return this.entityManager.createQuery("select f from Fiche as f where f.title = :title")
                .setParameter("title", title).getResultList();
    }
    public List<Fiche> getAllFiches(){

        return this.entityManager.createQuery("select f from Fiche as f", Fiche.class)
                .getResultList();
    }

}