package epicode.DataAccessObject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import epicode.JpaUtil;
import epicode.classes.Libro;

import jakarta.persistence.TypedQuery;



public class LibroDAO extends JpaUtil{
	private static final Logger log = LoggerFactory.getLogger(LibroDAO.class);
	private static final EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

	public void save(Libro oggetto) {
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


	public Libro getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try 
		{
			return em.find(Libro.class, id);

		} 
		finally 
		{
			em.close();
		}

	}
	
	public void getByAnnoPubblicazione(int anno) {
	    try {
	        javax.persistence.TypedQuery<Libro> query = em.createQuery(
	            "SELECT l FROM Libro l WHERE l.annoPubblicazione = :anno", Libro.class);
	        query.setParameter("anno", Integer.valueOf(anno));
	        List<Libro> lista = query.getResultList();
	        System.out.println(lista);
	       
	    } finally {
	        em.close();
	    }
	}
	
	public void getByAutore(String autore) {
	    EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    try {
	    	 javax.persistence.TypedQuery<Libro> query = em.createQuery(
	            "SELECT l FROM Libro l WHERE l.autore = :autore", Libro.class);
	        query.setParameter("autore", "%" + autore + "%");
	        System.out.println(query.getResultList());
	       
	    } finally {
	        em.close();
	    }
	}
	
	public void getByTitolo(String titolo) {
	    EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    try {
	    	 javax.persistence.TypedQuery<Libro> query = em.createQuery(
	            "SELECT l FROM Libro l WHERE l.titolo LIKE  :titolo", Libro.class);
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
			Libro l = em.find(Libro.class, id);
			em.remove(l);
			em.getTransaction().commit();
		} 
		catch (Exception ex) {
			Libro l = em.find(Libro.class, id);
			em.getTransaction().rollback();
			log.error("Error deleting object: " + l.getClass().getSimpleName(), ex);
			throw ex;

		} 
		finally {
			em.close();
		}

	}

}