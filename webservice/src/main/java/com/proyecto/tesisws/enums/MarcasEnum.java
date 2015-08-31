package com.proyecto.tesisws.enums;

public enum MarcasEnum {

	ACURA(1),
	AUDI(2),
	BMW(3),
	CADILLAC(4),
	CHEVROLET(5),
	CHRYSLER(6),
	DODGE(7),
	FIAT(8),
	FORD(9),
	GMC(10),
	HONDA(11),
	JEEP(12),
	KIA(13),
	MAZDA(14),
	MERCEDESBENZ(15),
	NISSAN(16),
	PEUGEOT(17),
	RENAULT(18),
	SEAT(19),
	TOYOTA(20),
	VOLKSWAGEN(21),
	VOLVO(22);
	
	private int id;

	private MarcasEnum(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
