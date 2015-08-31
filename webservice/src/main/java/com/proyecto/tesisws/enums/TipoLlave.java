package com.proyecto.tesisws.enums;

public enum TipoLlave {

	VEHICULO(1),
	INVITACION(2);
	
	private int id;

	private TipoLlave(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
}
