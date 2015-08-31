package com.proyecto.tesisws.enums;

public enum TipoStatus {

	ACTIVADO(1),
	DESACTIVADO(2);
	
	private int id;

	private TipoStatus(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
