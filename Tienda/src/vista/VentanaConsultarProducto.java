package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import controlador.Coordinador;
import modelo.dto.ProductosDTO;

public class VentanaConsultarProducto extends JFrame implements ActionListener {

    private JPanel contentPane;
    private Coordinador miCoordinador;

    private JTextArea areaUsuarios;
    private JTextField txtCodigo;
    private JButton btnConsultar, btnVolver, btnListar;

    public VentanaConsultarProducto() {
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
        JLabel titulo = new JLabel("CONSULTA DE PRODUCTOS");
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
        btnListar = new JButton("Listar Productos");
        btnListar.setBounds(130, 210, 180, 30);
        btnListar.addActionListener(this);
        contentPane.add(btnListar);

        //  DOCUMENTO
        JLabel lblCodigo = new JLabel("Codigo:");
        lblCodigo.setBounds(30, 260, 100, 25);
        contentPane.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(120, 260, 150, 25);
        contentPane.add(txtCodigo);

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
           ProductosDTO ProductoEncpontrado = miCoordinador.consultarProducto(txtCodigo.getText());
           
            System.out.println(ProductoEncpontrado);	
            if (ProductoEncpontrado != null) {
                areaUsuarios.setText(ProductoEncpontrado.toString());
            } else {
                areaUsuarios.setText("Usuario no encontrado.");
            }

        } else if (e.getSource() == btnVolver) {
            miCoordinador.mostrarVentanaProductos();
            this.setVisible(false);
        }
    }
    
    // metodo para la lista 
    public void mostrarUsuarios() {
    	
        
        
       ArrayList<ProductosDTO> listaProductos=miCoordinador.consultarlistaProductos();
		
		String mensaje="INFORMACIÓN GENERAL\n\n";
		
		if (!listaProductos.isEmpty()) {
			
			for (ProductosDTO p : listaProductos) {
				mensaje+="Codigo: "+p.getCodigo()+"\n";
				mensaje+="Nombre: "+p.getNombreProducto()+"\n";
				mensaje+="Precio: "+p.getPrecio()+"\n";
				mensaje+="Cantidad: "+p.getCantidad()+"\n";
			}
		
			areaUsuarios.setText(mensaje);
		}
		else {
			System.out.println("Está vacia");
			areaUsuarios.setText("No existen productos registradas");

		}
    }
    
    
    public void limpiarCampos() {
    	//txtEliminar.setText("");
	}
}