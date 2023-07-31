package main.java.com.epicode.gestione_prenotazioni.classes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Postation {
	@Id
	@Column(unique = true, nullable = false)
    private String codice;
    private String description;
    
    @Enumerated(EnumType.STRING)
    private type type;
    
    @Column(name = "occupanti")
    private int occupanti;
    
    @ManyToOne
    @JoinColumn(name = "edificio_id", nullable = false)
    private Edificio edificio;
    
    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;
}