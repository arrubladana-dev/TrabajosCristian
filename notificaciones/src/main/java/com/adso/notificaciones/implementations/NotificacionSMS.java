package com.adso.notificaciones.implementations;

import com.adso.notificaciones.interfaces.Notificaciones;

public class NotificacionSMS implements Notificaciones {

    @Override
    public String enviar() {
        return "se envio una notificacion por SMS";
    }
    
}
