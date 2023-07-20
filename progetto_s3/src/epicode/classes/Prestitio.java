package epicode.classes;

import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
public class Prestito {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Utente utente;
    @OneToOne(fetch = FetchType.EAGER)
    private ElementoLetterario elementoLetterario;
   
    private Date inizioPrestito;
    private Date restituzionePrestito;
    private Date restituzioneEffettiva;
    
    
	public Prestito() {
		super();
	}


	public Prestito(Utente utente, ElementoLetterario elementoLetterario, Date inizioPrestito,
			Date restituzionePrestito, Date restituzioneEffettiva) {
		super();
		this.utente = utente;
		this.elementoLetterario = elementoLetterario;
		this.inizioPrestito = inizioPrestito;
		this.restituzionePrestito = restituzionePrestito;
		this.restituzioneEffettiva = restituzioneEffettiva;
	}


	public Prestito( Utente utente, ElementoLetterario elementoLetterario, Date inizioPrestito) {
		super();
	
		this.utente = utente;
		this.elementoLetterario = elementoLetterario;
		this.inizioPrestito = inizioPrestito;
	}


	public Prestito(Utente utente, ElementoLetterario elementoLetterario, Date inizioPrestito,
			Date restituzioneEffettiva) {
		super();

		this.utente = utente;
		this.elementoLetterario = elementoLetterario;
		this.inizioPrestito = inizioPrestito;
		this.restituzioneEffettiva = restituzioneEffettiva;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	public ElementoLetterario getElementoLetterario() {
		return elementoLetterario;
	}


	public void setElementoLetterario(ElementoLetterario elementoLetterario) {
		this.elementoLetterario = elementoLetterario;
	}


	public Date getInizioPrestito() {
		return inizioPrestito;
	}


	public void setInizioPrestito(Date inizioPrestito) {
		this.inizioPrestito = inizioPrestito;
	}


	public Date getRestituzionePrestito() {
		return restituzionePrestito;
	}


	public void setRestituzionePrestito(Date restituzionePrestito) {
		this.restituzionePrestito = restituzionePrestito;
	}


	public Date getRestituzioneEffettiva() {
		return restituzioneEffettiva;
	}


	public void setRestituzioneEffettiva(Date restituzioneEffettiva) {
		this.restituzioneEffettiva = restituzioneEffettiva;
	}


	@Override
	public String toString() {
		return "Prestito [id=" + id + ", utente=" + utente + ", elementoLetterario=" + elementoLetterario
				+ ", inizioPrestito=" + inizioPrestito + ", restituzionePrestito=" + restituzionePrestito
				+ ", restituzioneEffettiva=" + restituzioneEffettiva + "]";
	}

   
	
}