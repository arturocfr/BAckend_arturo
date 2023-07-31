package main.java.com.epicode.gestione_prenotazioni.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Edificio {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
     private String name;
     private String address;
     private String city;

}