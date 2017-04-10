package testare;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.agile.model.Abonat;
import com.agile.model.CarteDeTelefon;
import com.agile.model.NrMobil;
import com.agile.model.Sortare;

public class SortareTest {

	private CarteDeTelefon creazaCarteaDeTelefonOrdonata() {
		CarteDeTelefon carteDeTelefon = new CarteDeTelefon();
		Abonat abonat1 = new Abonat("nume1", "prenume1", "1", new NrMobil("1"));
		Abonat abonat2 = new Abonat("nume2", "prenume2", "2", new NrMobil("2"));
		Abonat abonat3 = new Abonat("nume3", "prenume3", "3", new NrMobil("3"));
		carteDeTelefon.adaugaAbonat(abonat1);
		carteDeTelefon.adaugaAbonat(abonat2);
		carteDeTelefon.adaugaAbonat(abonat3);
		return carteDeTelefon;
	}

	// Sunt deja ordonate;
	private CarteDeTelefon creazaCarteaDeTelefonNeordonata() {
		CarteDeTelefon carteDeTelefon = new CarteDeTelefon();
		Abonat abonat1 = new Abonat("nume1", "prenume1", "1", new NrMobil("1"));
		Abonat abonat2 = new Abonat("nume3", "prenume3", "3", new NrMobil("3"));
		Abonat abonat3 = new Abonat("nume2", "prenume2", "2", new NrMobil("2"));
		carteDeTelefon.adaugaAbonat(abonat1);
		carteDeTelefon.adaugaAbonat(abonat2);
		carteDeTelefon.adaugaAbonat(abonat3);
		return carteDeTelefon;
	}

	@Test
	public void testSortareDupaNume() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonOrdonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		String S1 = lista.toString();
		String S2 = Sortare.SortareDupaNume(lista, true).toString();
		assertEquals(S1, S2);
	}

	@Test
	public void testSortareDupaPrenume() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonOrdonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		String S1 = lista.toString();
		String S2 = Sortare.SortareDupaPrenume(lista, true).toString();
		assertEquals(S1, S2);
	}

	@Test
	public void testSortareDupaCNP() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonOrdonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		String S1 = lista.toString();
		String S2 = Sortare.SortareDupaCNP(lista, true).toString();
		assertEquals(S1, S2);
	}

	@Test
	public void testSortareDupaNrTelefon() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonOrdonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		assertEquals(lista.toString(), Sortare.SortareDupaNrTelefon(lista, true).toString());
	}

	// Sunt ordonate descrescator;
	@Test
	public void testSortareDescDupaNume() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonOrdonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		Collections.reverse(lista);
		String S1 = lista.toString();
		String S2 = Sortare.SortareDupaNume(lista, false).toString();
		assertEquals(S1, S2);
	}

	@Test
	public void testSortareDescDupaPreume() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonOrdonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		Collections.reverse(lista);
		String S1 = lista.toString();
		String S2 = Sortare.SortareDupaPrenume(lista, false).toString();
		assertEquals(S1, S2);
	}

	@Test
	public void testSortareDescDupaCNP() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonOrdonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		Collections.reverse(lista);
		String S1 = lista.toString();
		String S2 = Sortare.SortareDupaCNP(lista, false).toString();
		assertEquals(S1, S2);
	}

	@Test
	public void testSortareDescDupaNrTelefon() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonOrdonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		Collections.reverse(lista);
		String S1 = lista.toString();
		String S2 = Sortare.SortareDupaNrTelefon(lista, false).toString();
		assertEquals(S1, S2);
	}

	// Nu sunt ordonate;
	@Test
	public void testSortareDupaNumeN() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonNeordonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		String S1 = creazaCarteaDeTelefonOrdonata().getListaAbonati().toString();
		String S2 = Sortare.SortareDupaNume(lista, true).toString();
		assertEquals(S1, S2);
	}

	@Test
	public void testSortareDupaPrenumeN() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonNeordonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		String S1 = creazaCarteaDeTelefonOrdonata().getListaAbonati().toString();
		String S2 = Sortare.SortareDupaPrenume(lista, true).toString();
		assertEquals(S1, S2);
	}

	@Test
	public void testSortareDupaCNPN() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonNeordonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		String S1 = creazaCarteaDeTelefonOrdonata().getListaAbonati().toString();
		String S2 = Sortare.SortareDupaCNP(lista, true).toString();
		assertEquals(S1, S2);
	}

	@Test
	public void testSortareDupaNrTelefonN() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonNeordonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		String S1 = creazaCarteaDeTelefonOrdonata().getListaAbonati().toString();
		String S2 = Sortare.SortareDupaNrTelefon(lista, true).toString();
		assertEquals(S1, S2);
	}

	@Test
	public void testSortareDescDupaNumeN() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonNeordonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Abonat> listaT = creazaCarteaDeTelefonOrdonata().getListaAbonati();
		Collections.reverse(listaT);
		String S1 = listaT.toString();
		String S2 = Sortare.SortareDupaNume(lista, false).toString();
		assertEquals(S1, S2);
	}

	@Test
	public void testSortareDescDupaPreumeN() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonNeordonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Abonat> listaT = creazaCarteaDeTelefonOrdonata().getListaAbonati();
		Collections.reverse(listaT);
		String S1 = listaT.toString();
		String S2 = Sortare.SortareDupaPrenume(lista, false).toString();
		assertEquals(S1, S2);
	}

	@Test
	public void testSortareDescDupaCNPN() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonNeordonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Abonat> listaT = creazaCarteaDeTelefonOrdonata().getListaAbonati();
		Collections.reverse(listaT);
		String S1 = listaT.toString();
		String S2 = Sortare.SortareDupaCNP(lista, false).toString();
		assertEquals(S1, S2);
	}

	@Test
	public void testSortareDescDupaNrTelefonN() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonNeordonata();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		List<Abonat> listaT = creazaCarteaDeTelefonOrdonata().getListaAbonati();
		Collections.reverse(listaT);
		String S1 = listaT.toString();
		String S2 = Sortare.SortareDupaNrTelefon(lista, false).toString();
		assertEquals(S1, S2);
	}

	private CarteDeTelefon creazaCarteaDeTelefonAcelasiNume() {
		CarteDeTelefon carteDeTelefon = new CarteDeTelefon();
		Abonat abonat1 = new Abonat("nume", "prenume1", "1", new NrMobil("1"));
		Abonat abonat2 = new Abonat("nume", "prenume2", "2", new NrMobil("2"));
		carteDeTelefon.adaugaAbonat(abonat1);
		carteDeTelefon.adaugaAbonat(abonat2);
		return carteDeTelefon;
	}

	// Ne da acelasi lucru;
	@Test
	public void testNumeAsemanatorT() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonAcelasiNume();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		String S1 = lista.toString();
		String S2 = Sortare.SortareDupaNume(lista, true).toString();
		assertEquals(S1, S2);
	}

	@Test
	public void testNumeAsemanatorF() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonAcelasiNume();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		String S1 = lista.toString();
		String S2 = Sortare.SortareDupaNume(lista, false).toString();
		assertEquals(S1, S2);
	}

	private CarteDeTelefon creazaCarteaDeTelefonAcelasiPrenume() {
		CarteDeTelefon carteDeTelefon = new CarteDeTelefon();
		Abonat abonat1 = new Abonat("nume1", "prenume", "1", new NrMobil("1"));
		Abonat abonat2 = new Abonat("nume2", "prenume", "2", new NrMobil("2"));
		carteDeTelefon.adaugaAbonat(abonat1);
		carteDeTelefon.adaugaAbonat(abonat2);
		return carteDeTelefon;
	}

	// Ne da acelasi lucru;
	@Test
	public void testPrenumeAsemanatorT() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonAcelasiPrenume();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		String S1 = lista.toString();
		String S2 = Sortare.SortareDupaPrenume(lista, true).toString();
		assertEquals(S1, S2);
	}

	@Test
	public void testPreumeAsemanatorF() {
		CarteDeTelefon carteDeTelefon = creazaCarteaDeTelefonAcelasiPrenume();
		List<Abonat> lista = carteDeTelefon.getListaAbonati();
		String S1 = lista.toString();
		String S2 = Sortare.SortareDupaPrenume(lista, false).toString();
		assertEquals(S1, S2);
	}

}
