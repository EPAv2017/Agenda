package com.agile.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Abonat implements Comparable<Abonat>, Serializable {

	private String nume;
	private String prenume;
	private String CNP;
	private NrTelefon nrTelefon;

	public Abonat(String nume, String prenume, String cNP, NrTelefon nrTelefon) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.CNP = cNP;
		this.nrTelefon = nrTelefon;
	}
	
	public String getNume() {
		return nume;
	}
	
	public void setNume(String nume) {
		this.nume = nume;
	}
	
	public String getPrenume() {
		return prenume;
	}
	
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	
	public String getCNP() {
		return CNP;
	}
	
	public void setCNP(String cNP) {
		CNP = cNP;
	}
	
	public NrTelefon getNrTelefon() {
		return nrTelefon;
	}

	public void setNrTelefon(NrTelefon nrTelefon) {
		this.nrTelefon = nrTelefon;
	}

	@Override
	public int compareTo(Abonat o) {
		if(this.nume.compareTo(o.nume) > 0) {
			return 1;
		} else if (this.nume.compareTo(o.nume) < 0) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return  nume + " - " + prenume + " - " + CNP + " - " + nrTelefon;
	}
}
