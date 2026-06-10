package com.adso.notificaciones.service;

import com.adso.notificaciones.factory.NotificacionFactory;
import com.adso.notificaciones.interfaces.Notificaciones;

public class NotificacionService {
    
    public String generarReporte(String tipo) {
        Notificaciones notificacion = NotificacionFactory.generarNotificaciones(tipo);
        return notificacion.enviar();
    }
}
