package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import controlador.Coordinador;
import modelo.dto.ClienteDTO;

public class VentanaConsultarUsuario extends JFrame implements ActionListener {

    private JPanel contentPane;
    private Coordinador miCoordinador;

    private JTextArea areaUsuarios;
    private JTextField txtDocumento;
    private JButton btnConsultar, btnVolver, btnListar;

    public VentanaConsultarUsuario() {
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10,10,10,10));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {

        //  TÍTULO
        JLabel titulo = new JLabel("CONSULTA DE USUARIOS");
        titulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(80, 10, 300, 30);
        contentPane.add(titulo);

        //  ÁREA DE LISTA
        areaUsuarios = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaUsuarios);
        scroll.setBounds(30, 50, 370, 150);
        contentPane.add(scroll);

        // BOTÓN LISTAR TODOS
        btnListar = new JButton("Listar Usuarios");
        btnListar.setBounds(130, 210, 180, 30);
        btnListar.addActionListener(this);
        contentPane.add(btnListar);

        //  DOCUMENTO
        JLabel lblDocumento = new JLabel("Documento:");
        lblDocumento.setBounds(30, 260, 100, 25);
        contentPane.add(lblDocumento);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(120, 260, 150, 25);
        contentPane.add(txtDocumento);

        //  BOTÓN CONSULTAR
        btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(280, 260, 120, 25);
        btnConsultar.addActionListener(this);
        contentPane.add(btnConsultar);

        //  BOTÓN VOLVER
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(150, 310, 120, 30);
        btnVolver.addActionListener(this);
        contentPane.add(btnVolver);
    }

    // GETTER
    public String getDocumento() {
        return txtDocumento.getText();
    }

    // SET para mostrar lista
   

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnListar) {
            miCoordinador.consultarlistaUsuarios();
            System.out.println("se imprimio exitosamnete");
            
            mostrarUsuarios();
            

        } else if (e.getSource() == btnConsultar) {
           ClienteDTO clienteEncpontrado = miCoordinador.consultarUsuario(txtDocumento.getText());
           
            System.out.println(clienteEncpontrado);	
            if (clienteEncpontrado != null) {
                areaUsuarios.setText(clienteEncpontrado.toString());
            } else {
                areaUsuarios.setText("Usuario no encontrado.");
            }

        } else if (e.getSource() == btnVolver) {
            miCoordinador.mostrarVentanaUsuarios();
            this.setVisible(false);
        }
    }
    
    // metodo para la lista 
    public void mostrarUsuarios() {
        
        
        ArrayList<ClienteDTO> listaUsuarios=miCoordinador.consultarlistaUsuarios();
		
		String mensaje="INFORMACIÓN GENERAL\n\n";
		
		if (!listaUsuarios.isEmpty()) {
			
			for (ClienteDTO p : listaUsuarios) {
				mensaje+="Documento: "+p.getDocumento()+"\n";
				mensaje+="Nombre: "+p.getNombreUsuario()+"\n";
				mensaje+="Apellido: "+p.getApellidoUsuario()+"\n";
				mensaje+="Edad: "+p.getEdad()+"\n";
				mensaje+="Telefono: "+p.getTelefono()+"\n";
				mensaje+="Tipo: "+p.getTipo()+"\n";
			}
			
			areaUsuarios.setText(mensaje);
		}
		else {
			System.out.println("Está vacia");
			areaUsuarios.setText("No existen personas registradas");

		}
    }
    
    
    public void limpiarCampos() {
    	//txtEliminar.setText("");
	}
}