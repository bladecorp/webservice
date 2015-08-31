package com.proyecto.tesisws.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tesisws.dao.TelefonosMapper;
import com.proyecto.tesisws.modelos.Telefonos;
import com.proyecto.tesisws.modelos.TelefonosExample;

@Service
public class TelefonosService {

	@Autowired
	private TelefonosMapper telefonosMapper;
	
	public List<Telefonos> obtenerTelefonosPorIdUsuario(Integer idUsuario){
		List<Telefonos> telefonos = new ArrayList<Telefonos>();
		if(idUsuario != null){
			TelefonosExample exTel = new TelefonosExample();
			exTel.createCriteria().andIdUsuarioEqualTo(idUsuario);
			telefonos = telefonosMapper.selectByExample(exTel);
		}
		return telefonos;
	}
	
	public Telefonos obtenerTelefonoPorId(Integer idTelefono){
		if(idTelefono != null){
			Telefonos telefono = telefonosMapper.selectByPrimaryKey(idTelefono);
			if(telefono == null){
				telefono = new Telefonos();
			}
			return telefono;
		}
		return new Telefonos();
	}
	
	public List<Telefonos> buscarTelefonoPorTelefono(String telefono){
		List<Telefonos> telefonos = new ArrayList<Telefonos>();
		if(telefono != null){
			TelefonosExample exTel = new TelefonosExample();
			exTel.createCriteria().andTelefonoEqualTo(telefono);
			telefonos = telefonosMapper.selectByExample(exTel);
		}
		return telefonos;
	}
	
	
}
