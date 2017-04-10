package com.agile.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class CarteDeTelefon implements Serializable {

	private List<Abonat> listaAbonati;
	
	public List<Abonat> getListaAbonati() {
		return listaAbonati;
	}

	public CarteDeTelefon() {
		this.listaAbonati = new ArrayList<Abonat>();
	}
	
	public void adaugaAbonat(Abonat abonat) {
		this.listaAbonati.add(abonat);
	}

	public void stergeAbonat(int index) {
		this.listaAbonati.remove(index);
	}
	
	@Override
	public String toString() {
		return "CarteDeTelefon [listaAbonati=" + listaAbonati + "]";
	}
}
