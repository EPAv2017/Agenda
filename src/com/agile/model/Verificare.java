package com.agile.model;

import java.util.List;
import java.util.regex.Pattern;

public class Verificare {

	public static int codEroare(String Nume, String Prenume, String CNP, String Telefon, boolean isTelefonMobil, List<Abonat> lista) {
		if(Nume.equals("")) {
			return 1;
		}
		if(Prenume.equals("")) {
			return 2;
		}
		if(CNP.length() != 13 || Pattern.matches("[a-zA-Z]+", CNP)) {
			return 3;
		}
		if(Pattern.matches("[a-zA-Z]+", Telefon)) {
			return 4;
		}
		if(isTelefonMobil) {
			if(Telefon.length() != 10) {
				return 5;
			}
		}
		for(int i = 0 ; i < lista.size(); i++ ){ 
			if(lista.get(i).getCNP().equals(CNP)) {
				return 6;
			}
		}
		return 0;
	}

}
