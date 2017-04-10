package com.agile.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class NrTelefon implements Serializable {

	private String numar;

	public String getNumar() {
		return numar;
	}

	@Override
	public String toString() {
		return numar;
	}

	public void setNumar(String numar) {
		this.numar = numar;
	}

	public NrTelefon(String numar) {
		super();
		this.numar = numar;
	}
	
	
	
}
