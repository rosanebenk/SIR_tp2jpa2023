package jpa;

import metier.SupportMember;
import metier.Ticket;
import metier.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createTickets();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listTickets();

		manager.close();
		System.out.println(".. done");
	}

	private void createTickets() {
		int numOfEmployees = manager.createQuery("Select t From Ticket t", Ticket.class).getResultList().size();
		if (numOfEmployees == 0) {
			User user1 = new User("java");
			User user2 = new User("kotlin");
			SupportMember support1 = new SupportMember("Hugo");
			SupportMember support2 = new SupportMember("Rémi");
			manager.persist(user1);
			manager.persist(user2);
			manager.persist(support1);
			manager.persist(support2);
			Ticket ticket = new Ticket("Jakab Gipsz",user1);
			ticket.setMember(support1);
			manager.persist(ticket);
			manager.persist(new Ticket("Captain Nemo",user1));
			manager.persist(new Ticket("Jack Sparrow",user2));

		}
	}

	private void listTickets() {
		List<Ticket> resultList = manager.createQuery("Select t From Ticket t", Ticket.class).getResultList();
		System.out.println("num of Ticket:" + resultList.size());
		for (Ticket next : resultList) {
			System.out.println("next Ticket: " + next);
		}
	}
	//TODO : Question 5. Portez votre application et gérer au minimum une relation d’héritage, les requêtes, une requête nommée.
}


