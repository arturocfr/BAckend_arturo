package epicode.MainProject;

import java.sql.Date;
import java.sql.SQLException;

import epicode.DataAccessObject.LibroDAO;
import epicode.DataAccessObject.PrestitoDAO;
import epicode.DataAccessObject.RivistaDAO;
import epicode.DataAccessObject.UtenteDAO;
import epicode.Enum.Genere;
import epicode.Enum.Periodicità;
import epicode.classes.Libro;
import epicode.classes.Prestito;
import epicode.classes.Rivista;
import epicode.classes.Utente;

public class MainProject {

	public static void main(String[] args) throws SQLException {
		LibroDAO LibroDAO = new LibroDAO();
		RivistaDAO RivistaDAO = new RivistaDAO();
		UtenteDAO UtenteDAO = new UtenteDAO();
		PrestitoDAO PrestitoDAO = new PrestitoDAO();
		Libro l1 = new Libro("Il piccolo Principe", 1943,90,"Antoine de Saint-Exupéry", Genere.ROMANZO);

		Rivista r1 = new Rivista("Vogue", 1892,150, Periodicità.MENSILE );

		Date dataDiNascita = new Date(90, 6, 16);
		Utente u1 = new Utente("Mario","Rossi", dataDiNascita, 123l);

		Date dataInizioPrestito = new Date(99, 5, 6);
		Prestito p1 = new Prestito(u1,l1, dataInizioPrestito);

	}

}