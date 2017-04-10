package testare;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.agile.model.Abonat;
import com.agile.model.Adaugare;
import com.agile.model.CarteDeTelefon;
import com.agile.model.NrMobil;
public class AdaugareTest {

	private CarteDeTelefon creazaCarteaDeTelefon() {
		CarteDeTelefon carteDeTelefon = new CarteDeTelefon();
		Abonat abonat1 = new Abonat("nume1", "prenume1", "1", new NrMobil("1"));
		Abonat abonat2 = new Abonat("nume2", "prenume2", "2", new NrMobil("2"));
		Abonat abonat3 = new Abonat("nume3", "prenume3", "3", new NrMobil("3"));
		carteDeTelefon.adaugaAbonat(abonat1);
		carteDeTelefon.adaugaAbonat(abonat2);
		carteDeTelefon.adaugaAbonat(abonat3);
		return carteDeTelefon;
	}

	@Test
	public void testAdaugareContactNou() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefon();
		String nume = "nume4";
		String prenume = "prenume4";
		String CNP = "4";
		String NrTelefon = "4";
		String S1 = "[nume1 - prenume1 - 1 - 1, nume2 - prenume2 - 2 - 2, nume3 - prenume3 - 3 - 3, nume4 - prenume4 - 4 - 4]";
		String S2 = Adaugare.AdaugaAbonatNou(carteDeTelefon, nume, prenume, CNP, NrTelefon).getListaAbonati().toString();
		assertEquals(S1, S2);
	}

}
