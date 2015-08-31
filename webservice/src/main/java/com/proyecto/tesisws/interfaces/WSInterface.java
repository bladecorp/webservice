package com.proyecto.tesisws.interfaces;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.proyecto.tesisws.dto.VehiculoDTO;
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

@WebService(name="WSInterface") 
public interface WSInterface {

/****************************INICIO SECCIÓN CATÁLOGOS *************/
	
	@WebResult(name="listaMarcas")
	List<Marcas> obtenerMarcas();
	
	@WebResult(name="marca")
	Marcas obtenerMarcaPorId(@WebParam(name="idMarca") Integer idMarca);
	
	@WebResult(name="listaModelos")
	List<Modelos> obtenerModelosPorIdMarca(@WebParam(name="idMarca") Integer idMarca);
	
	@WebResult(name="modelo")
	Modelos obtenerModeloPorId(@WebParam(name="idModelo") Integer idModelo);
	
	@WebResult(name="listaTipoVehiculo")
	List<Tipovehiculo> obtenerTiposDeVehiculo();
	
	@WebResult(name="listaTipoStatus")
	List<Tipostatus> obtenerTiposDeStatus();
	
	@WebResult(name="listaTipoLLave")
	List<Tipollave> obtenerTiposDeLLaves();
	
	@WebResult(name="listaTipoMensaje")
	List<Tipomensaje> obtenerTiposDeMensaje();
	
	/************************* FIN SECCIÓN CATÁLOGOS **********************/
	
	/************************* INICIO SECCIÓN DESTINATARIOS **********************/
	@WebResult(name="listaDestinatarios")
	List<Destinatarios> obtenerDestinatariosPorIdVehiculo(@WebParam(name="idVehiculo") Integer idVehiculo);
	
	@WebResult(name="idDestinatario")
	int insertarDestinatario(@WebParam(name="destinatario") Destinatarios destinatario);
	
	@WebResult(name="exito")
	boolean actualizarDestinatario(@WebParam(name="destinatario") Destinatarios destinatario);
	
	@WebResult(name="exito")
	boolean eliminarDestinatario(@WebParam(name="idDestinatario") Integer idDestinatario);
	
	@WebResult(name="exito")
	boolean eliminarDestinatariosPorIdVehiculo(@WebParam(name="idVehiculo") Integer idVehiculo);
	
	@WebResult(name="exito")
	boolean actualizarStatusInvitacionPorIdDestinatario(@WebParam(name="idDestinatario")Integer idDestinatario, @WebParam(name="statusInvitacion")Integer statusInvitacion);
	
	@WebResult(name="exito")
	boolean enviarInvitacion(@WebParam(name="idVehiculo")Integer idVehiculo, @WebParam(name="idDestinatario")Integer idDestinatario);
	
	@WebResult(name="vehiculo")
	Vehiculos aceptarOrechazarInvitacion(@WebParam(name="idVehiculo") Integer idVehiculo, @WebParam(name="idDestinatario") Integer idDestinatario, 
																@WebParam(name="statusInvitacion") Integer statusInvitacion);
	/************************* FIN SECCIÓN DESTINATARIOS **********************/
	
	/************************* INICIO SECCIÓN TELÉFONOS **********************/
	@WebResult(name="listaTelefono")
	List<Telefonos> obtenerTelefonosPorIdUsuario(@WebParam(name="idUsuario") Integer idUsuario);
	
	@WebResult(name="Telefono")
	Telefonos obtenerTelefonoPorId(@WebParam(name="idTelefono") Integer idTelefono);
	
	@WebResult(name="listaTelefono")
	List<Telefonos> buscarTelefonoPorTelefono(@WebParam(name="telefono") String telefono);
	
	/************************* FIN SECCIÓN TELÉFONOS **********************/
	
	/************************* INICIO SECCIÓN USUARIO **********************/
	@WebResult(name="idUsuario")
	int registrarUsuario(@WebParam(name="usuario") Usuarios usuario, @WebParam(name="telefono") String telefonoRegistro);
	
	@WebResult(name="usuario")
	Usuarios obtenerUsuarioPorId(@WebParam(name="idUsuario") Integer idUsuario);
	
	@WebResult(name="Usuario")
	Usuarios obtenerUsuario(@WebParam(name="usuario") String usuario);
	
	@WebResult(name="exito")
	boolean actualizarUsuario(@WebParam(name="usuario")Usuarios usuario, @WebParam(name="listaTelefonos") List<Telefonos> telefonos);
	
	/************************* FIN SECCIÓN USUARIO **********************/
	
	/************************* INICIO SECCIÓN VEHÍCULO **********************/
	@WebResult(name="listaVehiculoDTO")
	List<VehiculoDTO> obtenerVehiculosPorIdUsuario(@WebParam(name="idUsuario") Integer idUsuario);
	
	@WebResult(name="idVehiculo")
	int insertarVehiculo(@WebParam(name="vehiculoDTO") VehiculoDTO vehiculoDTO, @WebParam(name="idUsuario")Integer idUsuario);
	
	@WebResult(name="exito")
	boolean actualizarVehiculo(@WebParam(name="vehiculoDTO") VehiculoDTO vehiculoDTO, @WebParam(name="idUsuario")Integer idUsuario);
	
	@WebResult(name="exito")
	boolean eliminarVehiculoPorId(@WebParam(name="idVehiculo") Integer idVehiculo);
	
	@WebResult(name="exito")
	boolean eliminarVehiculosPorIdUsuario(@WebParam(name="idUsuario") Integer idUsuario);
	
	@WebResult(name="listaLlaves")
	List<Llaves> obtenerLlaverPorIdVehiculo(@WebParam(name="idVehiculo") Integer idVehiculo);

	@WebResult(name="exito")
	boolean actualizarStatusVehiculo(@WebParam(name="idVehiculo") Integer idVehiculo, @WebParam(name="tipoStatus") Integer tipoStatus);
	
	@WebResult(name="exito")
	boolean enviarMensajeSuspensionServicio(@WebParam(name="idVehiculo") Integer idVehiculo);
	
	@WebResult(name="exito")
	boolean enviarMensajeRevisionSensores(@WebParam(name="idVehiculo") Integer idVehiculo);
	
	
	
	/************************* FIN SECCIÓN VEHÍCULO **********************/
	
	/************************* INICIO SECCIÓN HISTORICO-MENSAJES **********************/
	@WebResult(name="mensajes")
	List<Historicomensajes> obtenerHistoricoPorFecha(@WebParam(name="idVehiculo") Integer idVehiculo, 
			@WebParam(name="mes") Integer mes, @WebParam(name="anio") Integer anio);
	
	/************************* FIN SECCIÓN HISTORICO-MENSAJES **********************/
	
	
}
