package epicode.classes;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.epicode.Enum.Periodicita;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Rivista extends ElementoLetterario {
	
	@Enumerated(EnumType.STRING)

private Periodicita periodicita;

public Rivista() {
		super();
	}

public Rivista(String titolo, Integer annoPubblicazione, Integer numeroPagine, Periodicita periodicita) {
	super(titolo, annoPubblicazione, numeroPagine);
	this.periodicita = periodicita;
}

public Periodicita getPeriodicita() {
	return periodicita;
}

public void setPeriodicita(Periodicita periodicita) {
	this.periodicita = periodicita;
}

@Override
public String toString() {
	return "Rivista [periodicita=" + periodicita + ", isbn=" + isbn + ", titolo=" + titolo + ", annoPubblicazione="
			+ annoPubblicazione + ", numeroPagine=" + numeroPagine + "]";
}


}