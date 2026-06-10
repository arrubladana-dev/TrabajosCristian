package com.adso.notificaciones.implementations;

import com.adso.notificaciones.interfaces.Notificaciones;

public class NotificacionCorreo implements Notificaciones {

    @Override
    public String enviar() {
        return "se envia una noti por correo";
    }
    
}
