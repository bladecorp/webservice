package com.proyecto.tesisws.servlets;



import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.proyecto.tesisws.servicios.MensajesService;

public class ServletMensajes extends AbstractController{
	Logger log = Logger.getLogger(ServletMensajes.class);
	
	@Autowired
	private MensajesService mensajesService;

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		mensajesService.procesarMensaje(request.getParameter("From"), request.getParameter("Body"));
		
//		Enumeration<String> parameterNames = request.getParameterNames();
//		 int i = 0;
//        while (parameterNames.hasMoreElements()) {
//            String paramName = parameterNames.nextElement();
//            log.debug("parametro["+i+"] : "+paramName);
//            i++;
//        }
//        log.debug("");
//        log.debug("");
//        log.debug("");
//        log.debug("ToCountry: "+request.getParameter("ToCountry"));
//        log.debug("ToState: "+request.getParameter("ToState"));
//        log.debug("SmsMessageSid: "+request.getParameter("SmsMessageSid"));
//        log.debug("NumMedia: "+request.getParameter("NumMedia"));
//        log.debug("ToCity: "+request.getParameter("ToCity"));
//        log.debug("FromZip: "+request.getParameter("FromZip")); 
//        log.debug("SmsSid: "+request.getParameter("SmsSid"));
//        log.debug("FromState: "+request.getParameter("FromState"));
//        log.debug("SmsStatus: "+request.getParameter("SmsStatus"));
//        log.debug("FromCity: "+request.getParameter("FromCity")); 
//        log.debug("Body: "+request.getParameter("Body"));
//        log.debug("FromCountry: "+request.getParameter("FromCountry"));
//        log.debug("To: "+request.getParameter("To"));
//        log.debug("ToZip: "+request.getParameter("ToZip"));
//        log.debug("NumSegments: "+request.getParameter("NumSegments"));
//        log.debug("MessageSid: "+request.getParameter("MessageSid"));
//        log.debug("AccountSid: "+request.getParameter("AccountSid"));
//        log.debug("From: "+request.getParameter("From"));
//        log.debug("ApiVersion: "+request.getParameter("ApiVersion"));
//        
//        log.debug("");
//        log.debug("");
//        log.debug("");
//		log.debug("Mensaje de: "+request.getParameter("From"));
//		log.debug("Mensaje desde ServletMensajes");
//		log.debug("Mensaje Obtenido del Servicio: "+mens);
		return null;
	}

	

}
