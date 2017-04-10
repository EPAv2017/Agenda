package testare;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.agile.model.Abonat;
import com.agile.model.CarteDeTelefon;
import com.agile.model.Cautare;
import com.agile.model.NrMobil;

public class CautareTest {

	private CarteDeTelefon creazaCarteaDeTelefonUnAbonat() {
		CarteDeTelefon carteDeTelefon = new CarteDeTelefon();
		Abonat abonat = new Abonat("nume", "prenume", "0", new NrMobil("0"));
		carteDeTelefon.adaugaAbonat(abonat);
		return carteDeTelefon;
	}

	// Cautare cuvant vid;
	@Test
	public void testCautareDupaNumeVid() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonUnAbonat();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Integer> ListaPozitii = new ArrayList<Integer>();
		String numeCautat = "";
		String S1 = ListaPozitii.toString();
		String S2 = Cautare.cautareDupaNume(lista, numeCautat).toString();
		assertEquals(S1, S2);
	}

	// Cautare nume care se gaseste;
	@Test
	public void testCautareDupaNume() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonUnAbonat();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Integer> ListaPozitii = new ArrayList<Integer>();
		String numeCautat = "nume";
		String S1 = ListaPozitii.toString();
		String S2 = Cautare.cautareDupaNume(lista, numeCautat).toString();
		assertEquals(S1, S2);
	}

	// Cautare nume care nu se gaseste;
	@Test
	public void testCautareDupaNumeAltCuvant() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonUnAbonat();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Integer> ListaPozitii = new ArrayList<Integer>();
		ListaPozitii.add(0);
		String numeCautat = "telefon";
		String S1 = ListaPozitii.toString();
		String S2 = Cautare.cautareDupaNume(lista, numeCautat).toString();
		assertEquals(S1, S2);
	}

	// Cautare prenume care se gaseste;
	@Test
	public void testCautareDupaPrenume() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonUnAbonat();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Integer> ListaPozitii = new ArrayList<Integer>();
		String numeCautat = "nume";
		String S1 = ListaPozitii.toString();
		String S2 = Cautare.cautareDupaPrenume(lista, numeCautat).toString();
		assertEquals(S1, S2);
	}

	// Cautare CNP care se nu gaseste;
	@Test
	public void testCautareDupaCNP() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonUnAbonat();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Integer> ListaPozitii = new ArrayList<Integer>();
		ListaPozitii.add(0);
		String numeCautat = "010";
		String S1 = ListaPozitii.toString();
		String S2 = Cautare.cautareDupaCNP(lista, numeCautat).toString();
		assertEquals(S1, S2);
	}

	// Cautare NrTelefon care se nu gaseste;
	@Test
	public void testCautareDupaNrTelefon() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonUnAbonat();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Integer> ListaPozitii = new ArrayList<Integer>();
		ListaPozitii.add(0);
		String numeCautat = "010";
		String S1 = ListaPozitii.toString();
		String S2 = Cautare.cautareDupaNrTelefon(lista, numeCautat).toString();
		assertEquals(S1, S2);
	}

	private CarteDeTelefon creazaCarteaDeTelefonDoiAbonati() {
		CarteDeTelefon carteDeTelefon = new CarteDeTelefon();
		Abonat abonat1 = new Abonat("nume", "prenume", "0", new NrMobil("0"));
		Abonat abonat2 = new Abonat("Nume1", "Prenume1", "1", new NrMobil("1"));
		carteDeTelefon.adaugaAbonat(abonat1);
		carteDeTelefon.adaugaAbonat(abonat2);
		return carteDeTelefon;
	}

	// Cautare dupa Nume Si prenume care se nu gaseste;
	@Test
	public void testCautareDupaNumeSiPrenume() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonDoiAbonati();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Integer> ListaPozitii = new ArrayList<Integer>();
		String numeCautat = "Nume";
		String prenumeCautat = "prenu";
		String CNPCautat = "";
		String NrTelefonCautat = "";
		String S1 = ListaPozitii.toString();
		String S2 = Cautare.cautareCompleta(lista, numeCautat, prenumeCautat, CNPCautat, NrTelefonCautat).toString();
		assertEquals(S1, S2);
	}

	// Cautare dupa Nume Si prenume care se nu gaseste;
	@Test
	public void testCautareDupaNumeSiPrenumeDuplicate() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonDoiAbonati();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Integer> ListaPozitii = new ArrayList<Integer>();
		ListaPozitii.add(0);
		String numeCautat = "Nume";
		String prenumeCautat = "sprenu";
		String CNPCautat = "";
		String NrTelefonCautat = "";
		String S1 = ListaPozitii.toString();
		String S2 = Cautare.cautareCompleta(lista, numeCautat, prenumeCautat, CNPCautat, NrTelefonCautat).toString();
		assertEquals(S1, S2);
	}

	// Numere Comune;
	@Test
	public void testNumereComune() {
		List<Integer> lista1 = new ArrayList<Integer>();
		List<Integer> lista2 = new ArrayList<Integer>();
		lista1.add(0);
		lista1.add(1);
		lista1.add(2);
		lista2.add(2);
		lista2.add(3);
		List<Integer> lista3 = new ArrayList<Integer>();
		lista3.add(2);
		String S1 = lista3.toString();
		String S2 = Cautare.numereComune(lista1, lista2).toString();
		assertEquals(S1, S2);
	}

	// Numere Comune;
	@Test
	public void testCautareCompleta() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonDoiAbonati();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Integer> ListaPozitii = new ArrayList<Integer>();
		ListaPozitii.add(0);
		String numeCautat = "Nume";
		String prenumeCautat = "Prenu";
		String CNPCautat = "";
		String NrTelefonCautat = "";
		String S1 = ListaPozitii.toString();
		String S2 = Cautare.cautareCompleta(lista, numeCautat, prenumeCautat, CNPCautat, NrTelefonCautat).toString();
		assertEquals(S1, S2);
	}

	// Numere Comune;
	@Test
	public void testCautareCompleta1() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonDoiAbonati();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Integer> ListaPozitii = new ArrayList<Integer>();
		String numeCautat = "Nume";
		String prenumeCautat = "Prenu";
		String CNPCautat = "0";
		String NrTelefonCautat = "";
		String S1 = ListaPozitii.toString();
		String S2 = Cautare.cautareCompleta(lista, numeCautat, prenumeCautat, CNPCautat, NrTelefonCautat).toString();
		assertEquals(S1, S2);
	}

	// Numere Comune;
	@Test
	public void testCautareCompleta2() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonDoiAbonati();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Integer> ListaPozitii = new ArrayList<Integer>();
		String numeCautat = "Nume";
		String prenumeCautat = "Prenu";
		String CNPCautat = "0";
		String NrTelefonCautat = "2323";
		String S1 = ListaPozitii.toString();
		String S2 = Cautare.cautareCompleta(lista, numeCautat, prenumeCautat, CNPCautat, NrTelefonCautat).toString();
		assertEquals(S1, S2);
	}

	// Numere Comune;
	@Test
	public void testCautareCompleta3() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonDoiAbonati();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Integer> ListaPozitii = new ArrayList<Integer>();
		ListaPozitii.add(0);
		String numeCautat = "Nume@";
		String prenumeCautat = "Prenu";
		String CNPCautat = "10";
		String NrTelefonCautat = "2323";
		String S1 = ListaPozitii.toString();
		String S2 = Cautare.cautareCompleta(lista, numeCautat, prenumeCautat, CNPCautat, NrTelefonCautat).toString();
		assertEquals(S1, S2);
	}

	// Numere Comune;
	@Test
	public void testCautareCompleta4() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonDoiAbonati();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Integer> ListaPozitii = new ArrayList<Integer>();
		ListaPozitii.add(0);
		ListaPozitii.add(1);
		String numeCautat = "Nume@";
		String prenumeCautat = "Prenu2";
		String CNPCautat = "10";
		String NrTelefonCautat = "2323";
		String S1 = ListaPozitii.toString();
		String S2 = Cautare.cautareCompleta(lista, numeCautat, prenumeCautat, CNPCautat, NrTelefonCautat).toString();
		assertEquals(S1, S2);
	}

}
