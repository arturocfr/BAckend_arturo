package epicode.classes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity

public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	protected String nome;
	protected String cognome;
	protected Date dataDiNascita;
	protected Long numeroDiTessera;
	
	@OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
	private List<Prestito> prestiti = new ArrayList<Prestito>();

	public Utente() {
		super();
	}

	public Utente(String nome, String cognome, Date dataDiNascita, Long numeroDiTessera) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.numeroDiTessera = numeroDiTessera;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Long getNumeroDiTessera() {
		return numeroDiTessera;
	}

	public void setNumeroDiTessera(Long numeroDiTessera) {
		this.numeroDiTessera = numeroDiTessera;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita
				+ ", numeroDiTessera=" + numeroDiTessera + "]";
	}
	
	
	
}