package epicode.DataAccessObject;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import epicode.JpaUtil;
import epicode.classes.Libro;
import epicode.classes.Rivista;

public class RivistaDAO {
	private static final Logger log = LoggerFactory.getLogger(RivistaDAO.class);
	private static final EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	
	public void save(Rivista oggetto) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try 
		{
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(oggetto);
			transaction.commit();
		} 
		catch (Exception ex) 
		{
			em.getTransaction().rollback();
			log.error("Error saving object: " + oggetto.getClass().getSimpleName(), ex);
			throw ex;
		} 
		finally 
		{
			em.close();
		}

	}


	public Rivista getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try 
		{
			return em.find(Rivista.class, id);

		} 
		finally 
		{
			em.close();
		}

	}
	
	public void getByAnnoPubblicazione(int anno) {
	    try {
	        javax.persistence.TypedQuery<Rivista> query = em.createQuery(
	            "SELECT l FROM Rivista l WHERE l.annoPubblicazione = :anno", Rivista.class);
	        query.setParameter("anno", Integer.valueOf(anno));
	        List<Rivista> lista = query.getResultList();
	        System.out.println(lista);
	       
	    } finally {
	        em.close();
	    }
	}
	
	public void getByTitolo(String titolo) {
	    EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    try {
	    	 javax.persistence.TypedQuery<Rivista> query = em.createQuery(
	            "SELECT l FROM Rivista l WHERE l.titolo LIKE  :titolo", Rivista.class);
	        query.setParameter("titolo", "%" + titolo + "%");
	        System.out.println(query.getResultList());
	       
	    } finally {
	        em.close();
	    }
	}

	public void delete(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			Rivista l = em.find(Rivista.class, id);
			em.remove(l);
			em.getTransaction().commit();
		} 
		catch (Exception ex) {
			Rivista l = em.find(Rivista.class, id);
			em.getTransaction().rollback();
			log.error("Error deleting object: " + l.getClass().getSimpleName(), ex);
			throw ex;

		} 
		finally {
			em.close();
		}

	}
}