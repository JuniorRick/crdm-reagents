package crdm.deposit.reagents.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import crdm.deposit.reagents.entity.Reagent;

@ManagedBean(name="reagentService")
public class ReagentService {
	
	 protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaReagents");
	    protected EntityManager em = emf.createEntityManager();
		
		
		public List<Reagent> all() {
			return em.createQuery("SELECT r FROM Reagent r", Reagent.class)
					.getResultList();
		}
		
		public void update(Reagent reagent) {
			em.getTransaction().begin();
			em.merge(reagent);
			em.getTransaction().commit();
		}
		
		public void delete(Reagent reagent) {
			em.getTransaction().begin();
			em.remove(reagent);		
			em.getTransaction().commit();
			
		}
		
}
