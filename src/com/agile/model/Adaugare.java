package com.agile.model;

public class Adaugare {

	public static CarteDeTelefon AdaugaAbonatNou(CarteDeTelefon carteDeTelefon, String nume, String prenume, String CNP, String NrTelefon ) {
		carteDeTelefon.adaugaAbonat(new Abonat(nume, prenume, CNP, new NrMobil(NrTelefon)));
		return carteDeTelefon;
	}
	
}
