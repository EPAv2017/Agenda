package com.agile.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sortare {

	public static List<Abonat> SortareDupaNume(List<Abonat> lista, boolean firstClick) {
		if(firstClick) {
			//ascendent sorting by name in class
			Collections.sort(lista);
		} else {
			Collections.sort(lista, new Comparator<Abonat>() {
				@Override
				public int compare(Abonat o1, Abonat o2) {
					if(o1.getNume().compareTo(o2.getNume()) > 0) {
						return -1;
					} else if (o1.getNume().compareTo(o2.getNume()) < 0) {
						return 1;
					}
					return 0;
				}
			});
		}
		return lista;
	}

	public static List<Abonat> SortareDupaPrenume(List<Abonat> lista, final boolean firstClick) {
		Collections.sort(lista, new Comparator<Abonat>() {
			@Override
			public int compare(Abonat o1, Abonat o2) {
				if(o1.getPrenume().compareTo(o2.getPrenume()) > 0 && firstClick) {
					return 1;
				} else if (o1.getPrenume().compareTo(o2.getPrenume()) < 0 && firstClick) {
					return -1;
				} else if(o1.getPrenume().compareTo(o2.getPrenume()) > 0 && !firstClick) {
					return -1;
				} else if (o1.getPrenume().compareTo(o2.getPrenume()) < 0 && !firstClick) {
					return 1;
				}
				return 0;
			}
		});
		return lista;
	}

	public static List<Abonat> SortareDupaCNP(List<Abonat> lista, final boolean firstClick) {
		Collections.sort(lista, new Comparator<Abonat>() {
			@Override
			public int compare(Abonat o1, Abonat o2) {
				if(o1.getCNP().compareTo(o2.getCNP()) > 0 && firstClick) {
					return 1;
				} else if (o1.getCNP().compareTo(o2.getCNP()) < 0 && firstClick) {
					return -1;
				}  else if (o1.getCNP().compareTo(o2.getCNP()) > 0 && !firstClick) {
					return -1;
				}  else if (o1.getCNP().compareTo(o2.getCNP()) < 0 && !firstClick) {
					return 1;
				}
				return 0;
			}
		});
		return lista;
	}

	public static List<Abonat> SortareDupaNrTelefon(List<Abonat> lista, final boolean firstClick) {
		Collections.sort(lista, new Comparator<Abonat>() {
			@Override
			public int compare(Abonat o1, Abonat o2) {
				if(o1.getNrTelefon().getNumar().compareTo(o2.getNrTelefon().getNumar()) > 0 && firstClick) {
					return 1;
				} else if (o1.getNrTelefon().getNumar().compareTo(o2.getNrTelefon().getNumar()) < 0 && firstClick) {
					return -1;
				}  else if (o1.getNrTelefon().getNumar().compareTo(o2.getNrTelefon().getNumar()) > 0 && !firstClick) {
					return -1;
				}  else if (o1.getNrTelefon().getNumar().compareTo(o2.getNrTelefon().getNumar()) < 0 && !firstClick) {
					return 1;
				}
				return 0;
			}
		});
		return lista;
	}

}
