package com.proyecto.tesisws.enums;

public enum StatusInvitacion {
	
	ENVIADA(1),
	NO_ENVIADA(2),
	ACEPTADA(3),
	RECHAZADA(4);
	
	private int id;

	private StatusInvitacion(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	

}
