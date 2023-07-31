package main.java.com.epicode.gestione_prenotazioni.classes;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "postazione_id", nullable = false)
    private Postation postation;
    
    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;
    
    @Column(nullable = false)
    private LocalDate data;
}