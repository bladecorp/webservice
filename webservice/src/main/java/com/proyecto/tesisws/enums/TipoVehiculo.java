package com.proyecto.tesisws.enums;

public enum TipoVehiculo {

	AUTOMOVIL(1),
	CAMIONETA(2);
	
	private int id;

	private TipoVehiculo(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
