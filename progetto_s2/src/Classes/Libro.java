package Classes;
import com.epicode.enums.Genere;
import com.epicode.enums.Periodicità;


public class Libro extends ElementoLetterario {

	private String autore;
	private Genere genere;
	
	public Libro(String isbn, String titolo, Integer annoPubblicazione, Integer numeroPagine, String autore, Genere genere) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);
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


	public static String toStringFile(Libro a) {
		return Libro.class.getSimpleName()  // Serve per identificare il tipo di elemento
				+ "@" + a.isbn
				+ "@" + a.titolo
				+ "@" + a.annoPubblicazione
				+ "@" + a.numeroPagine
				+ "@" + a.autore
				+ "@" + a.genere;
		}
	
	public static Libro fromStringFile(String stringFile) {
		String[] split = stringFile.split("@");
		Genere genere = Genere.valueOf(split[6]);
		
		return new Libro(split[1], split[2], Integer.valueOf(split[3]), Integer.valueOf(split[4]), split[5], genere);
	}
	

}