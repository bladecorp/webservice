package com.proyecto.tesisws.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.tesisws.dto.VehiculoDTO;
import com.proyecto.tesisws.interfaces.WSInterface;
import com.proyecto.tesisws.modelos.Destinatarios;
import com.proyecto.tesisws.modelos.Historicomensajes;
import com.proyecto.tesisws.modelos.Llaves;
import com.proyecto.tesisws.modelos.Marcas;
import com.proyecto.tesisws.modelos.Modelos;
import com.proyecto.tesisws.modelos.Telefonos;
import com.proyecto.tesisws.modelos.Tipollave;
import com.proyecto.tesisws.modelos.Tipomensaje;
import com.proyecto.tesisws.modelos.Tipostatus;
import com.proyecto.tesisws.modelos.Tipovehiculo;
import com.proyecto.tesisws.modelos.Usuarios;
import com.proyecto.tesisws.modelos.Vehiculos;


public class WebServiceImpl implements WSInterface {

	Logger logger = Logger.getLogger(WebServiceImpl.class);
	
	@Resource(name="wsContext")
	private WebServiceContext contexto;
	
	@Autowired
	private CatalogosService catalogosService;
	@Autowired
	private DestinatarioService destinatarioService;
	@Autowired
	private TelefonosService telefonosService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private VehiculoService vehiculoService;
	@Autowired
	private MensajesService mensajesService;
	
	/****************************INICIO SECCIÓN CATÁLOGOS *************/
	
	@Override
	public List<Marcas> obtenerMarcas() {
		logger.debug("Entró a WEB SERVICE IMPL -> obtenerMarcas");
		return catalogosService.obtenerMarcas();
	}

	@Override
	public Marcas obtenerMarcaPorId(Integer idMarca) {
		return catalogosService.obtenerMarcaPorId(idMarca);
	}

	@Override
	public List<Modelos> obtenerModelosPorIdMarca(Integer idMarca) {
		return catalogosService.obtenerModelosPorIdMarca(idMarca);
	}

	@Override
	public Modelos obtenerModeloPorId(Integer idModelo) {
		return catalogosService.obtenerModeloPorId(idModelo);
	}

	@Override
	public List<Tipovehiculo> obtenerTiposDeVehiculo() {
		return catalogosService.obtenerTiposDeVehiculo();
	}

	@Override
	public List<Tipostatus> obtenerTiposDeStatus() {
		return catalogosService.obtenerTiposDeStatus();
	}

	@Override
	public List<Tipollave> obtenerTiposDeLLaves() {
		return catalogosService.obtenerTiposDeLLaves();
	}

	@Override
	public List<Tipomensaje> obtenerTiposDeMensaje() {
		return catalogosService.obtenerTiposDeMensaje();
	}
	
	/************************* FIN SECCIÓN CATÁLOGOS **********************/
	
	/************************* INICIO SECCIÓN DESTINATARIOS **********************/

	@Override
	public List<Destinatarios> obtenerDestinatariosPorIdVehiculo(
			Integer idVehiculo) {
		return destinatarioService.obtenerDestinatariosPorIdVehiculo(idVehiculo);
	}

	@Override
	public int insertarDestinatario(Destinatarios destinatario){
		return destinatarioService.insertarDestinatario(destinatario);
	}
	
	@Override
	public boolean actualizarDestinatario(Destinatarios destinatario){
		try {
			return destinatarioService.actualizarDestinatario(destinatario);
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean eliminarDestinatario(Integer idDestinatario){
		try {
			return destinatarioService.eliminarDestinatario(idDestinatario);
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean eliminarDestinatariosPorIdVehiculo(Integer idVehiculo){
		try {
			if(idVehiculo != null){
				vehiculoService.eliminarDestinatariosPorIdVehiculo(idVehiculo);
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean actualizarStatusInvitacionPorIdDestinatario(Integer idDestinatario, Integer statusInvitacion){
		try {
			if(idDestinatario != null && statusInvitacion != null){
				return destinatarioService.actualizarStatusInvitacionPorIdDestinatario(idDestinatario, statusInvitacion);
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean enviarInvitacion(Integer idVehiculo, Integer idDestinatario){
		return destinatarioService.enviarInvitacion(idVehiculo, idDestinatario);
	}
	
	@Override
	public Vehiculos aceptarOrechazarInvitacion(Integer idVehiculo,
						Integer idDestinatario, Integer statusInvitacion) {
		try {
			return destinatarioService.aceptarOrechazarInvitacion(idDestinatario, idVehiculo, statusInvitacion);
		} catch (Exception e) {
			return new Vehiculos();
		}
	}
	/************************* FIN SECCIÓN DESTINATARIOS **********************/
	
	/************************* INICIO SECCIÓN TELÉFONOS **********************/

	@Override
	public List<Telefonos> obtenerTelefonosPorIdUsuario(Integer idUsuario) {
		return telefonosService.obtenerTelefonosPorIdUsuario(idUsuario);
	}

	@Override
	public Telefonos obtenerTelefonoPorId(Integer idTelefono) {
		return telefonosService.obtenerTelefonoPorId(idTelefono);
	}

	@Override
	public List<Telefonos> buscarTelefonoPorTelefono(String telefono) {
		return telefonosService.buscarTelefonoPorTelefono(telefono);
	}
	
	/************************* FIN SECCIÓN TELÉFONOS **********************/
	
	/************************* INICIO SECCIÓN USUARIO **********************/

	@Override
	public int registrarUsuario(Usuarios usuario, String telefonoRegistro) {
		try {
			return usuarioService.registrarUsuario(usuario, telefonoRegistro);
		} catch (Exception e) {
			return -1;
		}
		
	}

	@Override
	public Usuarios obtenerUsuarioPorId(Integer idUsuario) {
		return usuarioService.obtenerUsuarioPorId(idUsuario);
	}

	@Override
	public Usuarios obtenerUsuario(String usuario) {
		return usuarioService.obtenerUsuario(usuario);
	}

	@Override
	public boolean actualizarUsuario(Usuarios usuario, List<Telefonos> telefonos){
		try {
			return usuarioService.actualizarUsuario(usuario, telefonos);
		} catch (Exception e) {
			return false;
		}
	}
	
	/************************* FIN SECCIÓN USUARIO **********************/
	
	/************************* INICIO SECCIÓN VEHÍCULO **********************/

	@Override
	public List<VehiculoDTO> obtenerVehiculosPorIdUsuario(Integer idUsuario){
		return vehiculoService.obtenerVehiculosPorIdUsuario(idUsuario);
	}

	@Override
	public int insertarVehiculo(VehiculoDTO vehiculoDTO, Integer idUsuario){
		try {
			return vehiculoService.insertarVehiculo(vehiculoDTO, idUsuario);
		} catch (Exception e) {
			return -1;
		}
		
	}

	@Override
	public boolean actualizarVehiculo(VehiculoDTO vehiculoDTO, Integer idUsuario){
		try {
			return vehiculoService.actualizarVehiculo(vehiculoDTO, idUsuario);
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean eliminarVehiculoPorId(Integer idVehiculo){
		try {
			return vehiculoService.eliminarVehiculoPorId(idVehiculo);
		} catch (Exception e) {
			return false;
		}
		
	}
	
	@Override
	public boolean eliminarVehiculosPorIdUsuario(Integer idUsuario){
		try {
			return vehiculoService.eliminarVehiculosPorIdUsuario(idUsuario);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Llaves> obtenerLlaverPorIdVehiculo(Integer idVehiculo) {
		return vehiculoService.obtenerLlaverPorIdVehiculo(idVehiculo);
	}

	@Override
	public boolean actualizarStatusVehiculo(Integer idVehiculo, Integer tipoStatus){
		try {
			return vehiculoService.actualizarStatusVehiculo(idVehiculo, tipoStatus);
		} catch (Exception e) {
			return false;
		}
		
	}
	
	@Override
	public boolean enviarMensajeSuspensionServicio(Integer idVehiculo){
		return vehiculoService.enviarMensajeSuspensionServicio(idVehiculo);
	}
	
	@Override
	public boolean enviarMensajeRevisionSensores(Integer idVehiculo){
		return vehiculoService.enviarMensajeRevisionSensores(idVehiculo);
	}
	
	/************************* FIN SECCIÓN VEHÍCULO **********************/
	
	/************************* FIN SECCIÓN HISTORICO-MENSAJES **********************/
	
	@Override
	public List<Historicomensajes> obtenerHistoricoPorFecha(Integer idVehiculo, Integer mes, Integer anio){
		try {
			return mensajesService.historicoMensajesPorIdVehiculoYfecha(idVehiculo, mes, anio);
		} catch (Exception e) {
			return new ArrayList<Historicomensajes>();
		}
	}
	
	/************************* FIN SECCIÓN HISTORICO-MENSAJES **********************/
	
}
