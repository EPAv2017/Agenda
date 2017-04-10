package com.agile.model;

import java.util.ArrayList;
import java.util.List;

public class Cautare {

	public static List<Integer> cautareDupaNume(List<Abonat> lista, String firstName) {
		List<Integer> indexesToRemove = new ArrayList<Integer>();
		for(int i = 0 ; i < lista.size(); i++ ) {
			if(!lista.get(i).getNume().contains(firstName)) {
				indexesToRemove.add(i);
			}
		}
		return indexesToRemove;
	}

	public static List<Integer> cautareDupaPrenume(List<Abonat> lista, String lastName) {
		List<Integer> indexesToRemove = new ArrayList<Integer>();
		for(int i = 0 ; i < lista.size(); i++ ) {
			if(!lista.get(i).getPrenume().contains(lastName)) {
				indexesToRemove.add(i);
			}
		}
		return indexesToRemove;
	}

	public static List<Integer> cautareDupaCNP(List<Abonat> lista, String CNP) {
		List<Integer> indexesToRemove = new ArrayList<Integer>();
		for(int i = 0 ; i < lista.size(); i++ ) {
			if(!lista.get(i).getCNP().contains(CNP)) {
				indexesToRemove.add(i);
			}
		}
		return indexesToRemove;
	}

	public static List<Integer> cautareDupaNrTelefon(List<Abonat> lista, String NrTelefon) {
		List<Integer> indexesToRemove = new ArrayList<Integer>();
		for(int i = 0 ; i < lista.size(); i++ ) {
			if(!lista.get(i).getNrTelefon().getNumar().contains(NrTelefon)) {
				indexesToRemove.add(i);
			}
		}
		return indexesToRemove;
	}

	public static List<Integer> numereComune(List<Integer> lista1, List<Integer> lista2) {
		List<Integer> lista3 = new ArrayList<Integer>();
		for(int i = 0; i < lista1.size(); i ++) {
			if(lista2.contains(lista1.get(i))) {
				lista3.add(lista1.get(i));
			}
		}
		return lista3;
	}

	public static List<Integer> cautareCompleta(List<Abonat> lista, String nume, String prenume, String CNP, String NrTelefon) {
		List<Integer> indecsi = new ArrayList<Integer>();
		List<Integer> indecsiNume = cautareDupaNume(lista, nume);
		List<Integer> indecsiPrenume = cautareDupaPrenume(lista, prenume);
		List<Integer> indecsiCNP = cautareDupaCNP(lista, CNP);
		List<Integer> indecsiNrTelefon = cautareDupaNrTelefon(lista, NrTelefon);
		if(nume.isEmpty()) {
			if(prenume.isEmpty()) {
				if(CNP.isEmpty()) {
					if(NrTelefon.isEmpty()) {
						return indecsi;
					} else {
						return indecsiNrTelefon;
					}
				} else {
					if(NrTelefon.isEmpty()) {
						return indecsiCNP;
					} else {
						return numereComune(indecsiCNP,indecsiNrTelefon);
					}
				}
			} else {
				if(CNP.isEmpty()) {
					if(NrTelefon.isEmpty()) {
						return indecsiPrenume;
					} else {
						return numereComune(indecsiPrenume,indecsiNrTelefon);
					}
				} else {
					if(NrTelefon.isEmpty()) {
						return numereComune(indecsiPrenume,indecsiCNP);
					} else {
						return numereComune(indecsiPrenume,numereComune(indecsiCNP,indecsiNrTelefon));
					}
				}
			}
		} else {
			if(prenume.isEmpty()) {
				if(CNP.isEmpty()) {
					if(NrTelefon.isEmpty()) {
						return indecsiNume;
					} else {
						return numereComune(indecsiNume,indecsiNrTelefon);
					}
				} else {
					if(NrTelefon.isEmpty()) {
						return numereComune(indecsiNume,indecsiCNP);
					} else {
						return numereComune(indecsiNume,numereComune(indecsiCNP,indecsiNrTelefon));
					}
				}
			} else {
				if(CNP.isEmpty()) {
					if(NrTelefon.isEmpty()) {
						return numereComune(indecsiNume,indecsiPrenume);
					} else {
						return numereComune(indecsiNume,numereComune(indecsiPrenume,indecsiNrTelefon));
					}
				} else {
					if(NrTelefon.isEmpty()) {
						return numereComune(indecsiNume,numereComune(indecsiPrenume,indecsiCNP));
					} else {
						return numereComune(indecsiNume,numereComune(indecsiPrenume,numereComune(indecsiCNP,indecsiNrTelefon)));
					}
				}
			}
		}
	}

}
