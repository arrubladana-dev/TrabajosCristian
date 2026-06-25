package com.adso.mediador.mediado;

import org.springframework.stereotype.Component;

import com.adso.mediador.entity.Comprador;
import com.adso.mediador.entity.Transportador;
import com.adso.mediador.entity.Vendedor;

@Component
public class MediadorPedidos {
    
    private final Comprador comprador = new Comprador();
    private final Vendedor vendedor = new Vendedor();
    private final Transportador transportador = new Transportador();

    public String enviarMensaje(String remitente, String mensaje) {

        switch (remitente.toLowerCase()) {

            case "comprador":
                return vendedor.recibirMensaje(mensaje);

            case "vendedor":
                return transportador.recibirMensaje(mensaje);

            case "transportador":
                return comprador.recibirMensaje(mensaje);

            default:
                return "Rol no reconocido";
        }
    }
}
