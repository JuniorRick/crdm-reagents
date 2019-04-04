package crdm.deposit.blanks;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import crdm.deposit.blanks.entity.Producer;

/**
 * Unit test for simple App.
 */
public class AppTest {
   
	protected static EntityManagerFactory emf;

    protected EntityManager em;

    @BeforeClass
    public static void createEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("JpaReagents");
    }

    @AfterClass
    public static void closeEntityManagerFactory() {
        emf.close();
    }

    @Before
    public void beginTransaction() {
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    @After
    public void rollbackTransaction() {   
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }

        if (em.isOpen()) {
            em.close();
        }
    }
    
	@Test
	public void checkConnection() {
		
		Producer producer = em.find(Producer.class, 22);
		assertEquals("BioGnost", producer.getName());
	}
	
}
