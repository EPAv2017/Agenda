package testare;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.agile.model.Abonat;
import com.agile.model.CarteDeTelefon;
import com.agile.model.Verificare;;

public class VerificareTest {

	static CarteDeTelefon carteDeTelefon = new CarteDeTelefon();

	@SuppressWarnings("resource")
	private static void citesteCarteDeTelefon() throws ClassNotFoundException, IOException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		fis = new FileInputStream("D:\\carteDeTelefon.ser");
		if(fis != null) {
			ois = new ObjectInputStream(fis);
			carteDeTelefon = (CarteDeTelefon) ois.readObject();
		}
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		citesteCarteDeTelefon();
	}

	@Test
	public void testNume() throws IOException, ClassNotFoundException {
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		assertEquals(1, Verificare.codEroare("", "", "", "", true, lista));
	}

	@Test
	public void testPrenume() throws IOException, ClassNotFoundException {
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		assertEquals(2, Verificare.codEroare("Nume", "", "", "", true, lista));
	}

	@Test
	public void testCNP() throws IOException, ClassNotFoundException {
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		assertEquals(3, Verificare.codEroare("Nume", "Prenume", "", "", true, lista));
	}

	@Test
	public void testCNP_Litere() throws IOException, ClassNotFoundException {
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		assertEquals(3, Verificare.codEroare("Nume", "Prenume", "AAAAAAAAAAAAA", "", true, lista));
	}

	@Test
	public void testCNP_Numere() throws IOException, ClassNotFoundException {
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		assertEquals(3, Verificare.codEroare("Nume", "Prenume", "123456789012", "", true, lista));
	}

	@Test
	public void testNrTelefon_Litere() throws IOException, ClassNotFoundException {
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		assertEquals(4, Verificare.codEroare("Nume", "Prenume", "1234567890123", "a", true, lista));
	}

	@Test
	public void testNrTelefon_Numere() throws IOException, ClassNotFoundException {
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		assertEquals(5, Verificare.codEroare("Nume", "Prenume", "1234567890123", "1", true, lista));
	}

	@Test
	public void testNrTelefonCNPValid() throws IOException, ClassNotFoundException {
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		assertEquals(6, Verificare.codEroare("Nume", "Prenume", "1234567890123", "1233333333", true, lista));
	}

	@Test
	public void testAbonatNou() throws IOException, ClassNotFoundException {
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		assertEquals(0, Verificare.codEroare("Nume", "Prenume", "1234567890124", "1233333333", true, lista));
	}

	// Nume != "";
	// Prenume != "";
	// CNP - 13 cifre - caractere ( care nu sunt litere ), neutilizat;
	// Telefon Fix - caractere care nu sunt litere;
	// Telefon Mobil - 10 caractere care nu sunt litere;

	@Test
	public void testCaractere() throws IOException, ClassNotFoundException {
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		assertEquals(0, Verificare.codEroare(";'[]", "[]';,", ".............", "..........", true, lista));
	}

}
