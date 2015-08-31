package com.proyecto.tesisws.servicios;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tesisws.dao.DestinatariosMapper;
import com.proyecto.tesisws.enums.MensajeGeneral;
import com.proyecto.tesisws.enums.StatusInvitacion;
import com.proyecto.tesisws.enums.TipoMensaje;
import com.proyecto.tesisws.modelos.Destinatarios;
import com.proyecto.tesisws.modelos.DestinatariosExample;
import com.proyecto.tesisws.modelos.Vehiculos;
import com.twilio.sdk.TwilioRestException;

@Service
public class DestinatarioService {
	
	Logger logger = Logger.getLogger(DestinatarioService.class);
	
	@Autowired
	private DestinatariosMapper destinatariosMapper;
	@Autowired
	private MensajesService mensajesService;
	@Autowired
	private VehiculoService vehiculoService;
	
	public List<Destinatarios> obtenerDestinatariosPorIdVehiculo(Integer idVehiculo){
		List<Destinatarios> destinatarios = new ArrayList<Destinatarios>();
		if(idVehiculo != null){
			DestinatariosExample exDest = new DestinatariosExample();
			exDest.createCriteria().andIdVehiculoEqualTo(idVehiculo);
			destinatarios = destinatariosMapper.selectByExample(exDest);
		}
		return destinatarios;
	}
	
	public Destinatarios obtenerDestinatarioPorId(Integer idDestinatario){
		if(idDestinatario != null){
			return destinatariosMapper.selectByPrimaryKey(idDestinatario);
		}
		return null;
	}
	
	public int insertarDestinatario(Destinatarios destinatario){
		try{
			if(destinatario != null){
				if(!buscarDuplicidad(destinatario)){
					destinatariosMapper.insert(destinatario);
					return destinatario.getId();
				}
			}
			return -1;
		}catch(Exception ex){
			return -1;
		}
	}
	
	private boolean buscarDuplicidad(Destinatarios destinatario){
		DestinatariosExample exDest = new DestinatariosExample();
		exDest.createCriteria().andTelefonoEqualTo(destinatario.getTelefono()).andIdVehiculoEqualTo(destinatario.getIdVehiculo());
		List<Destinatarios> destinatarios = destinatariosMapper.selectByExample(exDest);
		if(destinatarios.size() > 0){
			return true;
		}
		return false;
	}

	public boolean actualizarDestinatario(Destinatarios destinatario)throws Exception {
		if(destinatario!=null && destinatario.getId()!=null && destinatario.getIdVehiculo()!=null){
			int exito = destinatariosMapper.updateByPrimaryKeySelective(destinatario);
			return exito > 0?true:false;
		}
		return false;
	}
	
	public boolean eliminarDestinatario(Integer idDestinatario)throws Exception{
		if(idDestinatario != null){
			int exito = destinatariosMapper.deleteByPrimaryKey(idDestinatario);
			return exito > 0?true:false;
		}
		return false;
	}
	
	public boolean actualizarStatusInvitacionPorIdDestinatario(Integer idDestinatario, Integer statusInvitacion)throws Exception{
		if(idDestinatario != null && statusInvitacion != null){
			Destinatarios dest = new Destinatarios();
			dest.setId(idDestinatario);
			dest.setStatusInvitacion(statusInvitacion);
			int exito = destinatariosMapper.updateByPrimaryKeySelective(dest);
			logger.debug("Resultado de la actualización del status Invitación: "+exito);
			return exito==1?true:false;
		}
		return false;
	}
	
	public Vehiculos aceptarOrechazarInvitacion(Integer idDestinatario, Integer idVehiculo, Integer statusInvitacion)throws Exception{
		Vehiculos vehiculo = new Vehiculos(); 
		if(idDestinatario != null && idVehiculo != null && statusInvitacion != null){
			if(statusInvitacion == StatusInvitacion.ACEPTADA.getId()){
				vehiculo = vehiculoService.obtenerVehiculoPorId(idVehiculo);
			}
			actualizarStatusInvitacionPorIdDestinatario(idDestinatario, statusInvitacion);
		}
		return vehiculo;
	}
	
	public boolean enviarInvitacion(Integer idVehiculo, Integer idDestinatario){
		if(idVehiculo != null && idDestinatario != null){
			Vehiculos vehiculo = vehiculoService.obtenerVehiculoPorId(idVehiculo);
			Destinatarios dest = destinatariosMapper.selectByPrimaryKey(idDestinatario);
			if(vehiculo != null && dest != null){
				String mensajeSMS = TipoMensaje.GENERAL.getId()+";"+MensajeGeneral.INVITACION.getId()+";"+
						vehiculo.getIdModelo()+";"+vehiculo.getId()+";"+idDestinatario;
				String mensaje = "Se solicita enviar una invitación a: "+dest.getTelefono();
				
				try {
					mensajesService.guardarMensaje(TipoMensaje.GENERAL.getId(),MensajeGeneral.INVITACION.getId(), idVehiculo, mensaje);
				} catch (Exception e) {
					return false;
				}
				
				List<String> telefonos = new ArrayList<String>();
				telefonos.add(dest.getTelefono());
				try {
					mensajesService.enviarMensaje(telefonos, mensajeSMS);
					return actualizarStatusInvitacionPorIdDestinatario(idDestinatario, StatusInvitacion.ENVIADA.getId());	
				} catch (Exception e) {
					logger.debug("Error al enviar el mensaje: "+e.getMessage());
					return false;
				}
			}
		}
		return false;
	}

}// fin service
