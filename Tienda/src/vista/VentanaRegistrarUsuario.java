package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import controlador.Coordinador;
import modelo.dto.ClienteDTO;

public class VentanaRegistrarUsuario extends JFrame implements ActionListener {

    private JPanel contentPane;
    private Coordinador miCoordinador;

    private JTextField txtNombre, txtDocumento;
    private JButton btnAgregar, btnVolver;
    private JLabel lblNewLabel,lblResultado;
    private JTextField textApellido;
    private JTextField textTelefono;
    private JTextField textEdad;
    private JTextField textTipo;
    private JButton btnActualizar;
    

    public VentanaRegistrarUsuario() {
        setBounds(100, 100, 433, 316);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        contentPane.setLayout(null);
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(26, 47, 55, 25);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(89, 47, 250, 25);
        contentPane.add(txtNombre);

        JLabel lblDocumento = new JLabel("Documento:");
        lblDocumento.setBounds(23, 120, 100, 25);
        contentPane.add(lblDocumento);

        txtDocumento = new JTextField();
        txtDocumento.setBounds(89, 120, 97, 25);
        contentPane.add(txtDocumento);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(89, 192, 120, 30);
        btnAgregar.addActionListener(this);
        contentPane.add(btnAgregar);
        
        lblNewLabel = new JLabel("Registrar o Actualizar Usuario");
        lblNewLabel.setBounds(104, 11, 213, 25);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(lblNewLabel);
        
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(21, 84, 100, 25);
        contentPane.add(lblApellido);
        
        textApellido = new JTextField();
        textApellido.setBounds(90, 85, 251, 25);
        contentPane.add(textApellido);
        
        JLabel lblTelefono = new JLabel("Telefono:");
        lblTelefono.setBounds(196, 120, 60, 25);
        contentPane.add(lblTelefono);
        
        textTelefono = new JTextField();
        textTelefono.setBounds(244, 121, 97, 25);
        contentPane.add(textTelefono);
        
        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(23, 156, 100, 25);
        contentPane.add(lblEdad);
        
        textEdad = new JTextField();
        textEdad.setBounds(94, 156, 113, 25);
        textEdad.setText("0");
        contentPane.add(textEdad);
        
        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(217, 157, 100, 25);
        contentPane.add(lblTipo);
        
        textTipo = new JTextField();
        textTipo.setBounds(253, 157, 86, 25);
        contentPane.add(textTipo);
        
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(227, 192, 120, 30);
        btnVolver.addActionListener(this);
        contentPane.add(btnVolver);
        
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(89, 233, 120, 30);
        btnActualizar.addActionListener(this);
        contentPane.add(btnActualizar);
        
        lblResultado = new JLabel("New label");
        lblResultado.setBounds(244, 241, 113, 14);
        contentPane.add(lblResultado);
    }

//    public String getNombre() { return txtNombre.getText(); }
//    public String getCorreo() { return txtDocumento.getText(); }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregar) {
        	ClienteDTO miCliente = new ClienteDTO();
        	miCliente.setDocumento(txtDocumento.getText());
        	miCliente.setNombreUsuario(txtNombre.getText());
        	miCliente.setApellidoUsuario(textApellido.getText());
        	miCliente.setEdad(Integer.parseInt(textEdad.getText()));
        	miCliente.setTelefono(textTelefono.getText());
        	miCliente.setTipo(textTipo.getText());
        	
        	
            String resul = miCoordinador.registrarUsuario(miCliente);
            
            
            if (resul.equals("ok")) {
				
            	lblResultado.setText("Se ha agrego correctamente");
				System.out.println("Se ha eliminado correctamente");
			}else {
				lblResultado.setText("No se pudo agregar");
				System.out.println("No se pudo eliminar");
			}
        }else if (e.getSource() == btnVolver) {
            miCoordinador.mostrarVentanaUsuarios();
            this.setVisible(false);
        }else if (e.getSource() == btnActualizar) {
        	ClienteDTO miCliente = new ClienteDTO();
        	miCliente.setDocumento(txtDocumento.getText());
        	miCliente.setNombreUsuario(txtNombre.getText());
        	miCliente.setApellidoUsuario(textApellido.getText());
        	miCliente.setEdad(Integer.parseInt(textEdad.getText()));
        	miCliente.setTelefono(textTelefono.getText());
        	miCliente.setTipo(textTipo.getText());
            String resul = miCoordinador.actualizarUsuarios(miCliente);
            
            if (resul.equals("ok")) {
				
            	lblResultado.setText("Se ha actualizado correctamente");
				System.out.println("Se ha eliminado correctamente");
			}else {
				lblResultado.setText("No se pudo actualizar");
				System.out.println("No se pudo eliminar");
			}
            
            lblResultado.setText(resul);
            limpiarCampos();
        }
        limpiarCampos();
    }
    
    public void limpiarCampos() {
		txtDocumento.setText("");
		txtNombre.setText("");
		textApellido.setText("");
		textEdad.setText("");
		textTelefono.setText("");
		textTipo.setText("");
		
	}
}
