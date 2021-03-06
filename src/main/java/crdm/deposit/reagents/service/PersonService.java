package crdm.deposit.reagents.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import crdm.deposit.reagents.entity.Person;


@ManagedBean(name="personService")
public class PersonService {

    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaReagents");
    protected EntityManager em = emf.createEntityManager();
	
	public List<Person> all() {
		return em.createQuery("SELECT p FROM Person p", Person.class)
				.getResultList();
	}

	public Person find(Integer id) {
		return em.find(Person.class, id);
	}
	
	public void update(Person person) {
		em.getTransaction().begin();
		em.merge(person);
		em.getTransaction().commit();
	}
	
	public void delete(Person person) {
		em.getTransaction().begin();
		em.remove(person);		
		em.getTransaction().commit();
		
	}
}
