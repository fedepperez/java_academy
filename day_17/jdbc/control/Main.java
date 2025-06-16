package day_17.jdbc.control;

import java.time.LocalDateTime;
import java.util.List;

import day_17.jdbc.model.Persona;
import day_17.jdbc.persistence.DAOException;
import day_17.jdbc.persistence.PersonaDAO;
import day_17.jdbc.persistence.impl.PersonaDAOImpl;

public class Main {
	private static PersonaDAO personaDAO = new PersonaDAOImpl();

	public static void main(String[] args) {
		save();
		// update();
		findById(1);
		// findAll();
		// findByNome("Ylenia");
		// findByCognome("Lombardi");
		// count();
		// findByCF("CF1");
		delete(1);
		// findByAnno("1990");

	}

	private static void save() {
		try {
			System.out.println("=== Save ===");
			Persona persona = new Persona();
			persona.setCF("CF1");
			persona.setNome("Fortunato");
			persona.setCognome("Fortunino");
			persona.setDataNascita(LocalDateTime.of(2000, 1, 1, 0, 0, 1));
			personaDAO.save(persona);
		} catch (DAOException e) {
			System.out.println("Ops...si è verificato un errore!");
		}
	}

	private static Persona findById(int id) {
		Persona persona = null;
		try {
			System.out.println("=== Find By Id ===");
			persona = personaDAO.findById(id);
			System.out.println(persona);
		} catch (DAOException e) {
			System.out.println("Ops...si è verificato un errore!");
		}
		return persona;
	}

	private static void delete(int id) {
		try {
			System.out.println("=== Delete ===");
			personaDAO.delete(id);
			System.out.println("Persona eliminata con successo.");
		} catch (DAOException e) {
			System.out.println("Ops... si è verificato un errore durante l'eliminazione!");
		}
	}

	private static Persona findByCF(String CF) {
		Persona persona = null;
		try {
			System.out.println("=== Find By CF ===");
			persona = personaDAO.findByCF(CF);
			System.out.println(persona);
		} catch (DAOException e) {
			System.out.println("Ops...si è verificato un errore!");
		}
		return persona;
	}

	private static List<Persona> findByNome(String nome) {
		List<Persona> persone = null;
		try {
			System.out.println("=== Find By Nome ===");
			persone = personaDAO.findByNome(nome);
			System.out.println(persone);
		} catch (DAOException e) {
			System.out.println("Ops...si è verificato un errore!");
		}
		return persone;
	}

	private static List<Persona> findByCognome(String cognome) {
		List<Persona> persone = null;
		try {
			System.out.println("=== Find By Cognome ===");
			persone = personaDAO.findByCognome(cognome);
			System.out.println(persone);
		} catch (DAOException e) {
			System.out.println("Ops...si è verificato un errore!");
		}
		return persone;
	}

	private static List<Persona> findAll() {
		List<Persona> persone = null;
		try {
			System.out.println("=== Find All ===");
			persone = personaDAO.findAll();
			System.out.println(persone);
		} catch (DAOException e) {
			System.out.println("Ops...si è verificato un errore!");
		}
		return persone;
	}

	private static long count() {
		long count = 0;
		try {
			System.out.println("=== Count ===");
			count = personaDAO.count();
			System.out.println(count);
		} catch (DAOException e) {
			System.out.println("Ops...si è verificato un errore!");
		}
		return count;
	}

	private static List<Persona> findByAnno(String annoNascita) {
		List<Persona> persone = null;
		try {
			System.out.println("=== Find By Anno Nascita ===");
			persone = personaDAO.findByAnno(annoNascita);
			System.out.println(persone);
		} catch (DAOException e) {
			System.out.println("Ops...si è verificato un errore!");
		}
		return persone;
	}

	private static void update() {

		try {
			System.out.println("=== Update ===");
			Persona persona = personaDAO.findById(34);
			if (persona != null) {
				persona.setCF("New CF1");
				persona.setNome("New Nome 1");
				persona.setCognome(" New Cognome 1");
				persona.setDataNascita(LocalDateTime.of(2000, 03, 05, 06, 05, 00));
				personaDAO.update(persona);
			}
		} catch (DAOException e) {
			System.out.println("Ops...si è verificato un errore!");
		}
	}
}