package epicode.DataAccessObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import epicode.JpaUtil;
import epicode.classes.Prestito;
import epicode.classes.Utente;

public class UtenteDAO {
	private static final Logger log = LoggerFactory.getLogger(UtenteDAO.class);
	public void save(Utente a) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(a);
		t.commit();
		log.info("Utente salvato!");
	}

	public Utente getById(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try 
		{
			System.out.println(em.find(Utente.class, id));
			return em.find(Utente.class, id);
		} 
		finally 
		{
			em.close();
		}
	}
}