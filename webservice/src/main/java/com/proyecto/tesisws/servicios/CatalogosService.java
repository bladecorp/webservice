package com.proyecto.tesisws.servicios;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tesisws.dao.MarcasMapper;
import com.proyecto.tesisws.dao.ModelosMapper;
import com.proyecto.tesisws.dao.SensoresMapper;
import com.proyecto.tesisws.dao.TipollaveMapper;
import com.proyecto.tesisws.dao.TipomensajeMapper;
import com.proyecto.tesisws.dao.TipostatusMapper;
import com.proyecto.tesisws.dao.TipovehiculoMapper;
import com.proyecto.tesisws.modelos.Marcas;
import com.proyecto.tesisws.modelos.Modelos;
import com.proyecto.tesisws.modelos.ModelosExample;
import com.proyecto.tesisws.modelos.Sensores;
import com.proyecto.tesisws.modelos.SensoresExample;
import com.proyecto.tesisws.modelos.Tipollave;
import com.proyecto.tesisws.modelos.Tipomensaje;
import com.proyecto.tesisws.modelos.Tipostatus;
import com.proyecto.tesisws.modelos.Tipovehiculo;


@Service("catalogosService")
public class CatalogosService {
	
	Logger logger = Logger.getLogger(CatalogosService.class);
	
	@Autowired
	private MarcasMapper marcasMapper; 
	@Autowired
	private ModelosMapper modelosMapper;
	@Autowired
	private TipovehiculoMapper tipovehiculoMapper;
	@Autowired
	private TipostatusMapper tipostatusMapper;
	@Autowired
	private TipollaveMapper tipollaveMapper;
	@Autowired
	private TipomensajeMapper tipomensajeMapper;
	@Autowired
	private SensoresMapper sensoresMapper;
	
	public List<Marcas> obtenerMarcas(){
		logger.info("Entró a CATALOGO SERVICE -> obtenerMarcas");
		return marcasMapper.selectByExample(null);
	}
	
	public Marcas obtenerMarcaPorId(Integer idMarca){
		Marcas marca = marcasMapper.selectByPrimaryKey(idMarca);
		if(marca == null){
			marca = new Marcas();
		}
		return marca;
	}
	
	public List<Modelos> obtenerModelosPorIdMarca(Integer idMarca){
		List<Modelos> modelos = new ArrayList<Modelos>();
		if(idMarca != null){
			ModelosExample exMod = new ModelosExample();
			exMod.createCriteria().andIdMarcaEqualTo(idMarca);
			return modelosMapper.selectByExample(exMod);
		}else{
			return modelos;
		}
	}
	
	public Modelos obtenerModeloPorId(Integer idModelo){
		Modelos modelo = modelosMapper.selectByPrimaryKey(idModelo);
		if(modelo == null){
			modelo = new Modelos();
		}
		return modelo;
	}
	
	public List<Tipovehiculo> obtenerTiposDeVehiculo(){
		return tipovehiculoMapper.selectByExample(null);
	}
	
	public List<Tipostatus> obtenerTiposDeStatus(){
		return tipostatusMapper.selectByExample(null);
	}
	
	public List<Tipollave> obtenerTiposDeLLaves(){
		return tipollaveMapper.selectByExample(null);
	}
	
	public List<Tipomensaje> obtenerTiposDeMensaje(){
		return tipomensajeMapper.selectByExample(null);
	}
	
	public List<Sensores> obtenerSensores(){
		return sensoresMapper.selectByExample(null);
	}
	
	public Sensores obtenerSensorPorId(Integer idSensor){
		return sensoresMapper.selectByPrimaryKey(idSensor);
	}
	
}
