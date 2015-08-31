package com.proyecto.tesisws.servicios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.tesisws.dao.HistoricomensajesMapper;
import com.proyecto.tesisws.enums.MensajeGeneral;
import com.proyecto.tesisws.enums.StatusInvitacion;
import com.proyecto.tesisws.enums.TipoMensaje;
import com.proyecto.tesisws.enums.TipoStatus;
import com.proyecto.tesisws.modelos.Destinatarios;
import com.proyecto.tesisws.modelos.Historicomensajes;
import com.proyecto.tesisws.modelos.HistoricomensajesExample;
import com.proyecto.tesisws.modelos.Sensores;
import com.proyecto.tesisws.modelos.Telefonos;
import com.proyecto.tesisws.modelos.Usuarios;
import com.proyecto.tesisws.modelos.Vehiculos;
import com.proyecto.tesisws.modelos.VehiculosExample;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Message;

@Service
public class MensajesService{
	
	Logger logger = Logger.getLogger(MensajesService.class);
	
	private static final String ACCOUNT_SID = "ACc93e5431cabf958106572678c9707986";
	private static final String AUTH_TOKEN = "edd54bfda188243e0f20eb0a9ca86e55";
	private static final String TEL_SALIDA = "+525549998734";
	private static final String PREFIJO = "+52";
	
	@Autowired
	private HistoricomensajesMapper historicomensajesMapper;
	@Autowired
	private TelefonosService telefonosService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private VehiculoService vehiculoService;
	@Autowired
	private DestinatarioService destinatarioService;
	@Autowired
	private CatalogosService catalogosService;
	
	public List<Historicomensajes> historicoMensajesPorIdVehiculoYfecha(Integer idVehiculo, Integer mes, Integer anio)
															throws Exception{
		List<Historicomensajes> histMen = new ArrayList<Historicomensajes>();
		if(idVehiculo!=null && mes != null && mes >= 1 && mes <= 12 && anio !=null){
			HistoricomensajesExample exHistMen = new HistoricomensajesExample();
			Calendar cal = Calendar.getInstance(); 
			cal.set(Calendar.YEAR, anio);
			cal.set(Calendar.MONTH, mes-1);
			cal.set(Calendar.DAY_OF_MONTH, 1);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 1);
		//	cal.set(anio, cal.get(Calendar.MONTH), 1);
			String fechaIni = cal.getTime().toString();
			
			Calendar cal2 = Calendar.getInstance();
			cal2.set(Calendar.YEAR,anio);
			cal2.set(Calendar.MONTH, mes-1);
			cal2.set(Calendar.DAY_OF_MONTH, cal2.getActualMaximum(Calendar.DAY_OF_MONTH));
			cal2.set(Calendar.HOUR_OF_DAY, 23);
			cal2.set(Calendar.MINUTE, 59);
			cal2.set(Calendar.SECOND, 59);
			String fechaFin = cal2.getTime().toString();
			
			Date fechaMinima = cal.getTime();
			Date fechaMaxima = cal2.getTime();
			exHistMen.createCriteria().andFechaBetween(fechaMinima, fechaMaxima).andIdVehiculoEqualTo(idVehiculo);
			histMen = historicomensajesMapper.selectByExample(exHistMen);
			for(Historicomensajes hist : histMen){
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				String fechaS = formatoFecha.format(hist.getFecha());
				hist.setFecha(formatoFecha.parse(fechaS));
			}
		}
		
		return histMen;
	}
	
	public void eliminarHistoricoPorVehiculo(Integer idVehiculo)throws Exception{
		HistoricomensajesExample exHist = new HistoricomensajesExample();
		exHist.createCriteria().andIdVehiculoEqualTo(idVehiculo);
		historicomensajesMapper.deleteByExample(exHist);
	}

	public String mostrarMensaje(String telefono) {
		List<Telefonos> telefonos = telefonosService.buscarTelefonoPorTelefono(convertirTelefono(telefono));
		
		if(telefonos.size() > 0){
			Usuarios usuario = usuarioService.obtenerUsuarioPorId(telefonos.get(0).getIdUsuario());
			return "El teléfono pertenece a: "+usuario.getNombre()+" "+usuario.getaPaterno();
		}
		return "No se encontró Usuario";
	}
	
	private String convertirTelefono(String tel){
		logger.debug("Teléfono recibido: "+tel);
		String telefono = "";
		char []t = tel.toCharArray();
		int i = 0;
		for(char numero : t){
			if(i>=3){
				telefono = telefono.concat(String.valueOf(numero));
			}
			i++;
		}
		logger.debug("Teléfono devuelto: "+telefono);
		return telefono;
	}

	public void procesarMensaje(String telRemitente, String mensajeRecibido) {
		String telefono = convertirTelefono(telRemitente);
		String[] mensajeDepurado = mensajeRecibido.split(";");
		if(mensajeDepurado.length >= 2){ // si el mensaje contiene al menos 2 codigos
			int tipoMensaje = Integer.parseInt(mensajeDepurado[0]);
			if(tipoMensaje == TipoMensaje.ALARMA.getId()){
				procesarMensajeDeAlarma(telefono, mensajeDepurado, mensajeRecibido);
			}else if(tipoMensaje == TipoMensaje.GENERAL.getId()){
				procesarMensajeGeneral(telefono, mensajeDepurado, mensajeRecibido);
			}
			
		}
	}
	
	private void procesarMensajeDeAlarma(String telefono, String[] mensaje, String mensajeCrudo){
		
		int idSensor = Integer.parseInt(mensaje[1]);
		Vehiculos vehiculo = vehiculoService.obtenerVehiculoPorTelefono(telefono);
		
		if(vehiculo != null){
			List<Telefonos> telefonos = telefonosService.obtenerTelefonosPorIdUsuario(vehiculo.getIdUsuario());
			Sensores sensor = catalogosService.obtenerSensorPorId(idSensor);
			List<String> listaTelefonosEnvio = new ArrayList<String>();
			List<Destinatarios> destinatarios = destinatarioService.obtenerDestinatariosPorIdVehiculo(vehiculo.getId());
			listaTelefonosEnvio = armarListaTelefonos(telefonos, destinatarios);
			String mensajeBase = "Se detectó actividad en el sensor de "+sensor.getSensor();
			String mensajeSMS = mensajeCrudo+";"+vehiculo.getId();
			
			try {
				guardarMensaje(TipoMensaje.ALARMA.getId(),0, vehiculo.getId(), mensajeBase);
				if(vehiculo.getIdTipoStatus() == TipoStatus.ACTIVADO.getId()){
					enviarMensaje(listaTelefonosEnvio, mensajeSMS);
				}
			} catch (Exception e) {
				try {
					enviarMensaje(listaTelefonosEnvio, mensajeSMS);
				} catch (TwilioRestException ex) {
						logger.error("Error al enviar los mensajes SMS: "+ex.getMessage());
				}
			}
			
		}else{//fin if principal
			logger.error("No se encontró ningún vehículo con teléfono: "+telefono);
		}
	}// fin método
	
	private void procesarMensajeGeneral(String telefono, String[] mensajeDepurado, String mensajeCrudo){
		int tipoGeneral = Integer.parseInt(mensajeDepurado[1]);
		int sensoresAfectados = Integer.parseInt(mensajeDepurado[2]);
		int idVehiculo = Integer.parseInt(mensajeDepurado[2]);
		int tipoSubMensaje = 0;
		Vehiculos vehiculo;
		String mensajeBase = "";
		List<String> listaTelefonos = new ArrayList<String>();
		
		if(tipoGeneral == MensajeGeneral.INFORMATIVO.getId()){
			vehiculo = vehiculoService.obtenerVehiculoPorTelefono(telefono);
		}else{
			vehiculo = vehiculoService.obtenerVehiculoPorId(idVehiculo);
		}
		if(vehiculo!=null){
			if(tipoGeneral == MensajeGeneral.INFORMATIVO.getId()){
				
				List<Telefonos> telefonos = telefonosService.obtenerTelefonosPorIdUsuario(vehiculo.getIdUsuario());
				String mensajeAux = "Los siguientes sensores presentaron anomalías: ";
				for(Sensores sensor : obtenerSensoresDeMensaje(mensajeDepurado)){
					mensajeAux = mensajeAux+sensor.getSensor()+", ";
				}
				mensajeBase = sensoresAfectados==0?"El vehículo reporta que ningún sensor presenta anomalías":mensajeAux;
				listaTelefonos = armarListaTelefonos(telefonos, null);
				tipoSubMensaje = MensajeGeneral.INFORMATIVO.getId();
				
			}else if(tipoGeneral == MensajeGeneral.SUSPENDER_SERVICIO.getId()){
				
				mensajeBase = "Se envía solicitud para suspender el servicio";
				listaTelefonos.add(vehiculo.getTelefono());
				tipoSubMensaje = MensajeGeneral.SUSPENDER_SERVICIO.getId();
				
			}else if(tipoGeneral == MensajeGeneral.INVITACION.getId()){
				int idDestinatario = Integer.parseInt(mensajeDepurado[3]);
				Destinatarios dest = destinatarioService.obtenerDestinatarioPorId(idDestinatario);
				mensajeBase = "Se solicita enviar una invitación a: "+dest.getTelefono();
				mensajeCrudo = mensajeDepurado[0]+";"+mensajeDepurado[1]+";"+vehiculo.getIdModelo()+";"
																	+vehiculo.getId()+";"+dest.getId();
				listaTelefonos.add(dest.getTelefono());
				tipoSubMensaje = MensajeGeneral.INVITACION.getId();
				
			}else if(tipoGeneral == MensajeGeneral.REVISAR_SENSORES.getId()){
				
				mensajeBase = "Se solicitó una revisión a los sensores del vehículo";
				listaTelefonos.add(vehiculo.getTelefono());
				tipoSubMensaje = MensajeGeneral.REVISAR_SENSORES.getId();
				
			}
			
			try {
				guardarMensaje(TipoMensaje.GENERAL.getId(),tipoSubMensaje, vehiculo.getId(), mensajeBase);
				if(tipoGeneral != MensajeGeneral.INFORMATIVO.getId())
					enviarMensaje(listaTelefonos, mensajeCrudo);
			} catch (Exception e) {
				try {
					logger.debug("Error al guardar el mensaje en base de datos: "+e.getMessage());
					if(tipoGeneral != MensajeGeneral.INFORMATIVO.getId())
						enviarMensaje(listaTelefonos, mensajeCrudo);
				} catch (TwilioRestException e1) {
					logger.debug("Error al enviar los mensajes por Twilio: "+e1.getMessage());
				}
			}
		}else{
			logger.error("No se encontró el vehículo con id: "+idVehiculo);
		}
		
		
	}
	
	public void guardarMensaje(Integer tipoMensaje, Integer idSubMsg, Integer idVehiculo, String mensaje)throws Exception{
		Historicomensajes hist = new Historicomensajes();
		hist.setId(0);
		hist.setIdTipoMensaje(tipoMensaje);
		hist.setIdSubMensaje(idSubMsg);
		hist.setIdVehiculo(idVehiculo);
		hist.setFecha(new Date());
		hist.setMensaje(mensaje);
		historicomensajesMapper.insert(hist);
	}
	
	public void enviarMensaje(List<String> telefonos, String mensaje) throws TwilioRestException{
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		
        Account account = client.getAccount();
        MessageFactory messageFactory = account.getMessageFactory();
        for(String telefono : telefonos){
        	List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("To", PREFIJO+telefono)); // Destinatario.
            params.add(new BasicNameValuePair("From", TEL_SALIDA)); // Remitente.
            params.add(new BasicNameValuePair("Body", mensaje));// Mensaje
            logger.debug("Mensaje Enviado a: "+telefono+", Mensaje: "+mensaje);
            Message sms = messageFactory.create(params); 
        }
	}
	
	private List<String> armarListaTelefonos(List<Telefonos> telefonos, List<Destinatarios> destinatarios){
		List<String> listaTelefonosParaEnvio = new ArrayList<String>();
		if(telefonos != null){
			for(Telefonos tel : telefonos){
				listaTelefonosParaEnvio.add(tel.getTelefono());
			}
		}
		if(destinatarios != null){
			for(Destinatarios dest : destinatarios){
				if(dest.getStatusInvitacion() == StatusInvitacion.ACEPTADA.getId()){//Solo se envía a los dest que hayan aceptado invitación
					listaTelefonosParaEnvio.add(dest.getTelefono());
				}
			}
		}
		return listaTelefonosParaEnvio;
	}
	
	private List<Sensores> obtenerSensoresDeMensaje(String[] mensaje){
		int i = 0;
		List<Sensores> sensores = new ArrayList<Sensores>();
		for(String idSensorS : mensaje){
			if(i > 2){
				int idSensor = Integer.parseInt(idSensorS);
				sensores.add(catalogosService.obtenerSensorPorId(idSensor));
			}
			i++;
		}
		return sensores;
	}
	
	/**************** FIN TRANSACCIONES SMS *******************/
	
	
	
	
}
