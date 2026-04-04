package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import controlador.Coordinador;

public class VentanaUsuarios extends JFrame implements ActionListener {

    private JPanel contentPane;
    private Coordinador miCoordinador;

    private JButton btnRegistrar, btnConsultar, btnEliminar;
    private JTextField txtEliminar;
    private JButton btnVolver;
    private JLabel lblResuldado;

    public VentanaUsuarios() {
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        JLabel titulo = new JLabel("GESTIÓN DE USUARIOS");
        titulo.setBounds(50, 20, 300, 30);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(titulo);

        btnRegistrar = new JButton("Registrar o Actualizar");
        btnRegistrar.setBounds(100, 70, 200, 30);
        btnRegistrar.addActionListener(this);
        contentPane.add(btnRegistrar);

        btnConsultar = new JButton("Consultar Usuarios");
        btnConsultar.setBounds(100, 110, 200, 30);
        btnConsultar.addActionListener(this);
        contentPane.add(btnConsultar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(50, 160, 100, 30);
        btnEliminar.addActionListener(this);
        contentPane.add(btnEliminar);

        txtEliminar = new JTextField();
        txtEliminar.setBounds(160, 160, 150, 30);
        contentPane.add(txtEliminar);
        
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(119, 220, 150, 30);
        btnVolver.addActionListener(this);
        contentPane.add(btnVolver);
        
        lblResuldado = new JLabel("");
        lblResuldado.setBounds(119, 201, 150, 14);
        contentPane.add(lblResuldado);
    }

    public String getUsuarioEliminar() {
        return txtEliminar.getText();
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            miCoordinador.mostrarVentanaRegistrarUsuario();
        } else if (e.getSource() == btnConsultar) {
            //miCoordinador.mostrarListaUsuarios();
        	miCoordinador.mostrarVentanaConsultarUsuarios();
            this.setVisible(false);
        } else if (e.getSource() == btnEliminar) {
        	String restuesta = "";
        	
				restuesta =miCoordinador.eliminarUsuario(txtEliminar.getText());
				
				String documento=txtEliminar.getText();
				String res=miCoordinador.eliminarUsuario(documento);
				
				if (res.equals("ok")) {
					
					lblResuldado.setText("Se ha eliminado correctamente");
					System.out.println("Se ha eliminado correctamente");
				}else {
					lblResuldado.setText("No se pudo eliminar");
					System.out.println("No se pudo eliminar");
				}
//			}
				limpiarCampos();
        }else if (e.getSource() == btnVolver) {
            miCoordinador.verVentanaPrincipal();
            this.setVisible(false);
            
        }
    }
    public void limpiarCampos() {
    	txtEliminar.setText("");
	}
}
