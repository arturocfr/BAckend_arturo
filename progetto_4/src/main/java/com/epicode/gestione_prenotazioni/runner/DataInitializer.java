package main.java.com.epicode.gestione_prenotazioni.runner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import main.java.com.epicode.gestione_prenotazione.classes.Edificio;
import main.java.com.epicode.gestione_prenotazione.classes.EdificioRepository;
import main.java.com.epicode.gestione_prenotazione.classes.Postation;
import main.java.com.epicode.gestione_prenotazione.classes.Prenotazione;
import main.java.com.epicode.gestione_prenotazione.classes.PrenotazioneRepository;
import main.java.com.epicode.gestione_prenotazione.classes.Utente;
import main.java.com.epicode.gestione_prenotazione.classes.UtenteRepository;
import main.java.com.epicode.gestione_prenotazione.classes.type;

@Component
public class DataInitializer implements CommandLineRunner {
	    private final UtenteRepository utenteRepository;
	    private final EdificioRepository edificioRepository;
	    private final PrenotazioneRepository prenotazioneRepository;
	    
	    List<Postation> postazioni = new ArrayList<>();
	    
	    public DataInitializer(UtenteRepository utenteRepository, EdificioRepository edificioRepository,
	                           PrenotazioneRepository prenotazioneRepository) {
	        this.utenteRepository = utenteRepository;
	        this.edificioRepository = edificioRepository;
	        this.prenotazioneRepository = prenotazioneRepository;
	    }
		
		  @Override
		    public void run(String... args) {
		        // Istanza degli utenti
		        Utente utente1 = new Utente();
		        utente1.setUsername("utente1");
		        utente1.setFullName("Mario Rossi");
		        utente1.setEmail("mario@example.com");

		        Utente utente2 = new Utente();
		        utente2.setUsername("utente2");
		        utente2.setFullName("Luigi Verdi");
		        utente2.setEmail("luigi@example.com");

		        // Istanza dell'edificio
		        Edificio edificio = new Edificio();
		        edificio.setName("Edificio A");
		        edificio.setAddress("Via delle Stelle, 123");
		        edificio.setCity("Città Metropolitana");
		        
		        Postation postazione1 = new Postation();
		        postazione1.setCodice("POST-001");
		        postazione1.setDescription("Postazione 1");
		        postazione1.setType(type.PRIVATO);
		        postazione1.setOccupanti(6);
		        postazione1.setEdificio(edificio); // Assumi che "edificio" sia stato istanziato precedentemente
		        postazioni.add(postazione1);

		        Postation postazione2 = new Postation();
		        postazione2.setCodice("POST-002");
		        postazione2.setDescription("Postazione 2");
		        postazione2.setType(type.OPENSPACE);
		        postazione2.setOccupanti(200);
		        postazione2.setEdificio(edificio); // Assumi che "edificio" sia stato istanziato precedentemente
		        postazioni.add(postazione2);

		        Postation postazione3 = new Postation();
		        postazione3.setCodice("POST-003");
		        postazione3.setDescription("Postazione 3");
		        postazione3.setType(type.SALARIUNIONI);
		        postazione3.setOccupanti(25);
		        postazione3.setEdificio(edificio); // Assumi che "edificio" sia stato istanziato precedentemente
		        postazioni.add(postazione3);
		        
		       

		        // Istanza delle prenotazioni
		        LocalDate dataPrenotazione1 = LocalDate.of(2023, 7, 31);
		        LocalDate dataPrenotazione2 = LocalDate.of(2023, 8, 1);

		        Prenotazione prenotazione1 = new Prenotazione();
		        prenotazione1.setPostation(postazione1); // Assumi che postazione1 sia stata istanziata precedentemente
		        prenotazione1.setUtente(utente1);
		        prenotazione1.setData(dataPrenotazione1);

		        Prenotazione prenotazione2 = new Prenotazione();
		        prenotazione2.setPostation(postazione2); // Assumi che postazione2 sia stata istanziata precedentemente
		        prenotazione2.setUtente(utente2);
		        prenotazione2.setData(dataPrenotazione2);

		        // Salva gli utenti, l'edificio e le prenotazioni nel database
		        utenteRepository.save(utente1);
		        utenteRepository.save(utente2);

		        edificioRepository.save(edificio);

		        prenotazioneRepository.save(prenotazione1);
		        prenotazioneRepository.save(prenotazione2);
		    }
}