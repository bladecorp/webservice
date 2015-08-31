package com.proyecto.tesisws.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.proyecto.tesisws.modelos.Llaves;
import com.proyecto.tesisws.modelos.Marcas;
import com.proyecto.tesisws.modelos.Modelos;
import com.proyecto.tesisws.modelos.Tipostatus;
import com.proyecto.tesisws.modelos.Tipovehiculo;

@XmlType(name="VehiculoDTO")
@XmlAccessorType(XmlAccessType.FIELD)
public class VehiculoDTO{

	private Integer id;
	private Marcas marca;
	private Modelos modelo;
	private String placas;
	private String telefono;
	private Tipovehiculo tipo;
	private Tipostatus status;
	private List<Llaves> llaves;
	
	public VehiculoDTO(){
		marca = new Marcas();
		modelo = new Modelos();
		tipo = new Tipovehiculo();
		status = new Tipostatus();
		llaves = new ArrayList<Llaves>();
		llaves.add(new Llaves());
		llaves.add(new Llaves());
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Marcas getMarca() {
		return marca;
	}
	public void setMarca(Marcas marca) {
		this.marca = marca;
	}
	public Modelos getModelo() {
		return modelo;
	}
	public void setModelo(Modelos modelo) {
		this.modelo = modelo;
	}
	public String getPlacas() {
		return placas;
	}
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Tipovehiculo getTipo() {
		return tipo;
	}
	public void setTipo(Tipovehiculo tipo) {
		this.tipo = tipo;
	}
	public Tipostatus getStatus() {
		return status;
	}
	public void setStatus(Tipostatus status) {
		this.status = status;
	}
	public List<Llaves> getLlaves() {
		return llaves;
	}
	public void setLlaves(List<Llaves> llaves) {
		this.llaves = llaves;
	}
	
	
	
}
