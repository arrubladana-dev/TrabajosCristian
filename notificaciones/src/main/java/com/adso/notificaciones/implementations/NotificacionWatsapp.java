package com.adso.notificaciones.implementations;

import com.adso.notificaciones.interfaces.Notificaciones;

public class NotificacionWatsapp implements Notificaciones {

    @Override
    public String enviar() {
        return "Se envio una notificacion de whatsaap";
    }
    
}
