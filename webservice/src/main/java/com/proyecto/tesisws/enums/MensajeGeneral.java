package com.proyecto.tesisws.enums;

public enum MensajeGeneral {

	INFORMATIVO(1), //Solo lo envía el vehículo
	SUSPENDER_SERVICIO(2),
	INVITACION(3), 
	REVISAR_SENSORES(4);
	
	private int id;

	private MensajeGeneral(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	
	
}
