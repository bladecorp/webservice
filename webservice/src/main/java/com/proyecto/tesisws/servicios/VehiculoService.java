package com.proyecto.tesisws.servicios;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.tesisws.dao.DestinatariosMapper;
import com.proyecto.tesisws.dao.LlavesMapper;
import com.proyecto.tesisws.dao.MarcasMapper;
import com.proyecto.tesisws.dao.ModelosMapper;
import com.proyecto.tesisws.dao.TipostatusMapper;
import com.proyecto.tesisws.dao.TipovehiculoMapper;
import com.proyecto.tesisws.dao.VehiculosMapper;
import com.proyecto.tesisws.dto.VehiculoDTO;
import com.proyecto.tesisws.enums.MensajeGeneral;
import com.proyecto.tesisws.enums.TipoLlave;
import com.proyecto.tesisws.enums.TipoMensaje;
import com.proyecto.tesisws.enums.TipoStatus;
import com.proyecto.tesisws.modelos.DestinatariosExample;
import com.proyecto.tesisws.modelos.Llaves;
import com.proyecto.tesisws.modelos.LlavesExample;
import com.proyecto.tesisws.modelos.Vehiculos;
import com.proyecto.tesisws.modelos.VehiculosExample;
import com.twilio.sdk.TwilioRestException;

@Service
public class VehiculoService {
	
	Logger logger = Logger.getLogger(VehiculoService.class);
	
	@Autowired
	private VehiculosMapper vehiculosMapper;
	@Autowired
	private LlavesMapper llavesMapper;
	@Autowired
	private TipostatusMapper tipostatusMapper;
	@Autowired
	private TipovehiculoMapper tipovehiculoMapper;
	@Autowired
	private ModelosMapper modelosMapper;
	@Autowired
	private MarcasMapper marcasMapper;
	@Autowired
	private DestinatariosMapper destinatariosMapper;
	@Autowired
	private MensajesService mensajesService;
	
	
	public List<VehiculoDTO> obtenerVehiculosPorIdUsuario(Integer idUsuario){
		List<VehiculoDTO> vehiculosDTO = new ArrayList<VehiculoDTO>();
		if(idUsuario != null){
			VehiculosExample exVeh = new VehiculosExample();
			exVeh.createCriteria().andIdUsuarioEqualTo(idUsuario);
			List<Vehiculos> vehiculos = vehiculosMapper.selectByExample(exVeh);
			for(Vehiculos vehiculo : vehiculos){
				VehiculoDTO vehiculoDTO = new VehiculoDTO();
				vehiculoDTO.setId(vehiculo.getId());
				vehiculoDTO.setLlaves(obtenerLlaverPorIdVehiculo(vehiculo.getId()));
				vehiculoDTO.setPlacas(vehiculo.getPlacas());
				vehiculoDTO.setStatus(tipostatusMapper.selectByPrimaryKey(vehiculo.getIdTipoStatus()));
				vehiculoDTO.setTipo(tipovehiculoMapper.selectByPrimaryKey(vehiculo.getIdTipoVehiculo()));
				vehiculoDTO.setTelefono(vehiculo.getTelefono());
				vehiculoDTO.setModelo(modelosMapper.selectByPrimaryKey(vehiculo.getIdModelo()));
				vehiculoDTO.setMarca(marcasMapper.selectByPrimaryKey(vehiculoDTO.getModelo().getIdMarca()));
				vehiculosDTO.add(vehiculoDTO);
			}
		}
		return vehiculosDTO;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public int insertarVehiculo(VehiculoDTO vehiculoDTO, Integer idUsuario)throws Exception{
		if(vehiculoDTO != null && idUsuario != null){
			if(!buscarDuplicidad(vehiculoDTO, false)){
				Vehiculos vehiculo = new Vehiculos();
				vehiculo.setIdModelo(vehiculoDTO.getModelo().getId());
				vehiculo.setIdTipoStatus(TipoStatus.ACTIVADO.getId());
				vehiculo.setIdTipoVehiculo(vehiculoDTO.getTipo().getId());
				vehiculo.setIdUsuario(idUsuario);
				vehiculo.setPlacas(vehiculoDTO.getPlacas());
				vehiculo.setTelefono(vehiculoDTO.getTelefono());
				vehiculosMapper.insert(vehiculo);
				vehiculoDTO.getLlaves().get(0).setIdTipoLlave(TipoLlave.VEHICULO.getId());
				vehiculoDTO.getLlaves().get(0).setIdVehiculo(vehiculo.getId());
				llavesMapper.insert(vehiculoDTO.getLlaves().get(0));
				vehiculoDTO.getLlaves().get(1).setIdTipoLlave(TipoLlave.INVITACION.getId());
				vehiculoDTO.getLlaves().get(1).setIdVehiculo(vehiculo.getId());
				llavesMapper.insert(vehiculoDTO.getLlaves().get(1));
				return vehiculo.getId();
			}
		}
		return -1;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean actualizarVehiculo(VehiculoDTO vehiculoDTO, Integer idUsuario)throws Exception{
		if(vehiculoDTO != null && idUsuario != null){
			if(!buscarDuplicidad(vehiculoDTO, true)){
				Vehiculos vehiculo = new Vehiculos();
				vehiculo.setId(vehiculoDTO.getId());
				vehiculo.setIdModelo(vehiculoDTO.getModelo().getId());
				vehiculo.setIdTipoStatus(vehiculoDTO.getStatus().getId());
				vehiculo.setIdTipoVehiculo(vehiculoDTO.getTipo().getId());
				vehiculo.setIdUsuario(idUsuario);
				vehiculo.setPlacas(vehiculoDTO.getPlacas());
				vehiculo.setTelefono(vehiculoDTO.getTelefono());
				int exito = vehiculosMapper.updateByPrimaryKeySelective(vehiculo);
				if(exito > 0){
					for(Llaves llave : vehiculoDTO.getLlaves()){
						exito = llavesMapper.updateByPrimaryKey(llave);
						if(exito == 0){
							return false;
						}
					}
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean buscarDuplicidad(VehiculoDTO vehiculo, boolean esEditar){
		if(vehiculo != null){
			VehiculosExample exVeh = new VehiculosExample();
			exVeh.createCriteria().andPlacasEqualTo(vehiculo.getPlacas());
		//	exVeh.or().andTelefonoEqualTo(vehiculo.getTelefono());
			List<Vehiculos> vehiculos = vehiculosMapper.selectByExample(exVeh);
			if(vehiculos.size() > 0){
				if(!esEditar){
					return true;
				}else if(vehiculos.get(0).getId() != vehiculo.getId()){
					return true;
				}
			}else{
				List<String> llavesString = new ArrayList<String>();
				for(Llaves llave : vehiculo.getLlaves()){
					llavesString.add(llave.getCodigo());
				}
				LlavesExample exLlaves = new LlavesExample();
				exLlaves.createCriteria().andCodigoIn(llavesString);
				List<Llaves> llavesDuplicadas = llavesMapper.selectByExample(exLlaves);
				if(llavesDuplicadas.size() > 0){
					if(!esEditar){
						return true;
					}else if(llavesDuplicadas.get(0).getIdVehiculo() != vehiculo.getId()){
						return true;
					}
				}
			}
		}
		return false;
	}

	@Transactional(rollbackFor=Exception.class)
	public boolean eliminarVehiculoPorId(Integer idVehiculo)throws Exception{
		logger.debug("Entró a WEBSERVICE Eliminar Vehiculo Por Id ");
		if(idVehiculo != null){
			eliminarDestinatariosPorIdVehiculo(idVehiculo);
			eliminarLlavesPorIdVehiculo(idVehiculo);
			mensajesService.eliminarHistoricoPorVehiculo(idVehiculo);
			int exito = vehiculosMapper.deleteByPrimaryKey(idVehiculo);
			if(exito == 1)return true;
		}
		return false;
	}
	
	@Transactional(rollbackFor=Exception.class)
	public boolean eliminarVehiculosPorIdUsuario(Integer idUsuario)throws Exception{
		if(idUsuario != null){
			VehiculosExample exVeh = new VehiculosExample();
			exVeh.createCriteria().andIdUsuarioEqualTo(idUsuario);
			List<Vehiculos> vehiculos = vehiculosMapper.selectByExample(exVeh);
			for(Vehiculos vehiculo : vehiculos){
				DestinatariosExample exDest = new DestinatariosExample();
				exDest.createCriteria().andIdVehiculoEqualTo(vehiculo.getId());
				destinatariosMapper.deleteByExample(exDest);
				LlavesExample exLlaves = new LlavesExample();
				exLlaves.createCriteria().andIdVehiculoEqualTo(vehiculo.getId());
				llavesMapper.deleteByExample(exLlaves);
				mensajesService.eliminarHistoricoPorVehiculo(vehiculo.getId());
			}
			exVeh = new VehiculosExample();
			exVeh.createCriteria().andIdUsuarioEqualTo(idUsuario);
			vehiculosMapper.deleteByExample(exVeh);
			return true;
		}
		return false;
	}
	
	public List<Llaves> obtenerLlaverPorIdVehiculo(Integer idVehiculo){
		List<Llaves> llaves = new ArrayList<Llaves>();
		if(idVehiculo != null){
			LlavesExample exLlaves = new LlavesExample();
			exLlaves.createCriteria().andIdVehiculoEqualTo(idVehiculo);
			exLlaves.setOrderByClause("idTipoLlave ASC");
			llaves = llavesMapper.selectByExample(exLlaves);
		}
		return llaves;
	}

	@Transactional(rollbackFor=Exception.class)
	public boolean actualizarStatusVehiculo(Integer idVehiculo, Integer tipoStatus)throws Exception {
		if(idVehiculo != null && tipoStatus != null){
			Vehiculos vehiculo = new Vehiculos();
			vehiculo.setId(idVehiculo);
			vehiculo.setIdTipoStatus(tipoStatus);
			int exito = vehiculosMapper.updateByPrimaryKeySelective(vehiculo);
			if(exito > 0){
				return true;
			}
		}
		return false;
	}
	
	public void eliminarDestinatariosPorIdVehiculo(Integer idVehiculo)throws Exception{
		DestinatariosExample exDest = new DestinatariosExample();
		exDest.createCriteria().andIdVehiculoEqualTo(idVehiculo);
		destinatariosMapper.deleteByExample(exDest);
	}
	
	private void eliminarLlavesPorIdVehiculo(Integer idVehiculo)throws Exception{
		LlavesExample exLlaves = new LlavesExample();
		exLlaves.createCriteria().andIdVehiculoEqualTo(idVehiculo);
		llavesMapper.deleteByExample(exLlaves);
	}
	
	public Vehiculos obtenerVehiculoPorTelefono(String telefono){
		VehiculosExample exVeh = new VehiculosExample();
		exVeh.createCriteria().andTelefonoEqualTo(telefono);
		List<Vehiculos> vehiculos = vehiculosMapper.selectByExample(exVeh);
		if(vehiculos.size() > 0){
			return vehiculos.get(0);
		}
		return null;
	}
	
	public Vehiculos obtenerVehiculoPorId(Integer idVehiculo){
		return vehiculosMapper.selectByPrimaryKey(idVehiculo);
	}
	
	public boolean enviarMensajeSuspensionServicio(Integer idVehiculo){
		Vehiculos vehiculo = vehiculosMapper.selectByPrimaryKey(idVehiculo);
		if(vehiculo != null){
			String mensaje = "Se solicitó la suspensión del servicio";
			try {
				mensajesService.guardarMensaje(TipoMensaje.GENERAL.getId(),MensajeGeneral.SUSPENDER_SERVICIO.getId(), idVehiculo, mensaje);
			} catch (Exception e) {
				return false;
			}
			String mensajeSMS = TipoMensaje.GENERAL.getId()+";"+MensajeGeneral.SUSPENDER_SERVICIO.getId()+";"+idVehiculo;
			List<String> telefonos = new ArrayList<String>();
			telefonos.add(vehiculo.getTelefono());
			try {
				mensajesService.enviarMensaje(telefonos, mensajeSMS);
				return true;
			} catch (TwilioRestException e) {
				return false;
			}
			
		}
		return false;
	}
	
	public boolean enviarMensajeRevisionSensores(Integer idVehiculo){
		Vehiculos vehiculo = vehiculosMapper.selectByPrimaryKey(idVehiculo);
		if(vehiculo != null){
			String mensaje = "Se solicitó la revisión de sensores";
			try {
				mensajesService.guardarMensaje(TipoMensaje.GENERAL.getId(),MensajeGeneral.REVISAR_SENSORES.getId(), idVehiculo, mensaje);
			} catch (Exception e) {
				return false;
			}
			String mensajeSMS = TipoMensaje.GENERAL.getId()+";"+MensajeGeneral.REVISAR_SENSORES.getId()+";"+idVehiculo;
			List<String> telefonos = new ArrayList<String>();
			telefonos.add(vehiculo.getTelefono());
			try {
				mensajesService.enviarMensaje(telefonos, mensajeSMS);
				return true;
			} catch (TwilioRestException e) {
				return false;
			}
			
		}
		return false;
	}
	
	
	
}
