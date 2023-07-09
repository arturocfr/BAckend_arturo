package Classes;
import com.epicode.enums.Periodicità;


public class Rivista extends ElementoLetterario{
	private Periodicità periodicita;

	public Rivista(String isbn, String titolo, Integer annoPubblicazione, Integer numeroPagine, Periodicità periodicita) {
		super(isbn, titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	public Periodicità getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicità periodicita) {
		this.periodicita = periodicita;
	}

	public static String toStringFile(Rivista a) {
		return "Rivista: " + a.titolo + ": [Periodicità=" + a.periodicita + "]";
	}

	public static Rivista fromStringFile(String stringFile) {
		String[] split = stringFile.split(",");
		Periodicità periodicita = Periodicità.valueOf(split[5]);
		
		return new Rivista(split[1], split[2], Integer.valueOf(split[3]), Integer.valueOf(split[4]), periodicita);
	}
}


