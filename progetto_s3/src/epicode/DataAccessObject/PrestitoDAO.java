package epicode.DataAccessObject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import epicode.JpaUtil;
import epicode.classes.ElementoLetterario;
import epicode.classes.Prestito;




public class PrestitoDAO {
	private static final Logger log = LoggerFactory.getLogger(RivistaDAO.class);

	public void save(Prestito oggetto) {
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
	
	public static Prestito getById(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try 
		{
			return em.find(Prestito.class, id);
		} 
		finally 
		{
			em.close();
		}
	}
	
	public void getPrestitiInCorso() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
				
		try {
			javax.persistence.Query query = em.createQuery("SELECT p FROM Prestito p WHERE p.restituzioneEffettiva IS NULL");
			List<Prestito> lista = query.getResultList();
			System.out.println(query.getResultList());
	         
	    } finally {
	        em.close();
	    }
	}
	
	public static void getPrestitiScaduti() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		List<Prestito> lista  = new ArrayList<Prestito>();
		
		try {
			javax.persistence.Query query =  em.createQuery("SELECT p FROM Prestito p WHERE p.restituzionePrestito IS NULL AND p.restituzioneEffettiva IS NULL");
			lista = query.getResultList();
			System.out.println(query.getResultList());
		}
		 finally {
			em.close();
		}
		
	}

	    public List<ElementoLetterario> getItemsInPrestitoByNumeroTessera(Long numeroTessera) {
	        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	        try {
	            javax.persistence.TypedQuery<ElementoLetterario> query = em.createQuery(
	                "SELECT p.elementoLetterario FROM Prestito p WHERE p.utente.numeroDiTessera = :numeroTessera", ElementoLetterario.class);
	            query.setParameter("numeroTessera", numeroTessera);
	            return query.getResultList();
	        } finally {
	            em.close();
	        }
	    }
	}