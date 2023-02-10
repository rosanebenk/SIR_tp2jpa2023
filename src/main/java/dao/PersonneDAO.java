package dao;

import metier.Personne;

import java.util.List;

public class PersonneDAO extends GenericDaoJpaImpl<Personne, Long>{
    public List<Personne> getPersonneByName(String name){

        return this.entityManager.createQuery("select p from Personne as p where p.name = :name")
                .setParameter("name", name).getResultList();
    }
    public List<Personne> getAllPersonne(){

        return this.entityManager.createQuery("select p from Personne as p", Personne.class)
                .getResultList();
    }

}
