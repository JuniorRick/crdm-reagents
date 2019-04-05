package crdm.deposit.reagents.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import crdm.deposit.reagents.entity.Producer;


@ManagedBean(name="producerService")
public class ProducerService {

    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaReagents");
    protected EntityManager em = emf.createEntityManager();
	
	
	public List<Producer> all() {
		return em.createQuery("SELECT p FROM Producer p", Producer.class)
				.getResultList();
	}
}
