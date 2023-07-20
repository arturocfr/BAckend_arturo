package epicode.classes;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import epicode.Enum.Genere;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Libro extends ElementoLetterario {

	private String autore;
	
	@Enumerated(EnumType.STRING)
	private Genere genere;
	
	public Libro() {
		super();
	}
	public Libro(String titolo, Integer annoPubblicazione, Integer numeroPagine, String autore, Genere genere) {
		super( titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}


	

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + ", isbn=" + isbn + ", titolo=" + titolo
				+ ", annoPubblicazione=" + annoPubblicazione + ", numeroPagine=" + numeroPagine + "]";
	}

	
	
}