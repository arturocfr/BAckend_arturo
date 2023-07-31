package main.java.com.epicode.gestione_prenotazioni.services;;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import main.java.com.epicode.gestione_prenotazione.classes.Postation;
import main.java.com.epicode.gestione_prenotazione.classes.Prenotazione;
import main.java.com.epicode.gestione_prenotazione.classes.PrenotazioneRepository;
import main.java.com.epicode.gestione_prenotazione.classes.Utente;

import lombok.Data;

@Service
public class ServicesPrenotazione {
	 private PrenotazioneRepository prenotazioneRepository;
	 public ServicesPrenotazione(PrenotazioneRepository prenotazioneRepository) {
	        this.prenotazioneRepository = prenotazioneRepository;
	    }
	 public void effettuaPrenotazione(Postation postazione, Utente utente, LocalDate data) {
	        // Verifica se la postazione è libera per il giorno specificato
	        if (postazioneLibera(postazione, data)) {
	            Prenotazione prenotazione = new Prenotazione();
	            prenotazione.setPostation(postazione);
	            prenotazione.setUtente(utente);
	            prenotazione.setData(data);
	            prenotazioneRepository.save(prenotazione);
	        } else {
	            throw new IllegalStateException("La postazione non è disponibile per la data specificata.");
	        }
	    }
	 public boolean postazioneLibera(Postation postazione, LocalDate data) {
	        // Recupera tutte le prenotazioni per la postazione specificata
	        List<Prenotazione> prenotazioniPostazione = PrenotazioneRepository.findByPostazione(postazione);

	       
	        for (Prenotazione prenotazione : prenotazioniPostazione) {
	            if (prenotazione.getData().equals(data)) {
	                return false;
	            }
	        }

	        return true; 
	    }

}