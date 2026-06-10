package com.adso.notificaciones.factory;

import com.adso.notificaciones.implementations.NotificacionCorreo;
import com.adso.notificaciones.implementations.NotificacionSMS;
import com.adso.notificaciones.implementations.NotificacionWatsapp;
import com.adso.notificaciones.interfaces.Notificaciones;

public class NotificacionFactory {
    
    public static Notificaciones generarNotificaciones(String tipo){
        
        if (tipo.equalsIgnoreCase("WHATSAPP")) {
            return new NotificacionWatsapp();
        }if (tipo.equalsIgnoreCase("SMS")) {
            return new NotificacionSMS();
        }if (tipo.equalsIgnoreCase("CORREO")) {
            return new NotificacionCorreo();
        }

        throw new IllegalArgumentException("Tipo de notificacion no validoa");

    }
}
