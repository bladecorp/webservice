package com.proyecto.tesisws.servicios;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.tesisws.modelos.Historicomensajes;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/myservlet-servlet.xml"})//Agregar <testResource> en pom.xml
//@TransactionConfiguration
//@Transactional
public class MensajesServiceTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private MensajesService mensajesService;
	@Autowired
	private DestinatarioService destinatarioService;

	@Rollback(false)
	@Test
	public void testEnviarInvitacion() throws Exception {
		int idDest = 49;
		int statusInv = 1;
		
		destinatarioService.actualizarStatusInvitacionPorIdDestinatario(idDest, statusInv);
	}

	@Test
	public void testProcesarMensaje() {
//		String mensaje = "1;2"; //Alarma
//		String mensaje = "2;1;1;3"; //Informativo
//		String mensaje = "2;2;9"; //Suspender Servicio
		String mensaje = "2;3;18;5535663625"; // Invitación
//		String mensaje = "2;4;19"; // Revisar Sensores
		
//		String telRemitente = "+525535663625"; //el remitente es un vehículo
		String telRemitente = "+525523096363"; //el remitente es un cliente
		
		mensajesService.procesarMensaje(telRemitente, mensaje);
	}
	
	@Test
	public void testHistorico(){
		int mes = 8;
		int anio = 2015;
		int idVehiculo = 25;
		List<Historicomensajes> h = new ArrayList<Historicomensajes>();
		try {
			h = mensajesService.historicoMensajesPorIdVehiculoYfecha(idVehiculo, mes, anio);
		} catch (Exception e) {
			
		}
	}


}
