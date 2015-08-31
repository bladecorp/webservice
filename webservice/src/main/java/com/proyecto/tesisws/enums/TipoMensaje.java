package com.proyecto.tesisws.enums;

public enum TipoMensaje {

	ALARMA(1),
	GENERAL(2);
	
	private int id;

	private TipoMensaje(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
