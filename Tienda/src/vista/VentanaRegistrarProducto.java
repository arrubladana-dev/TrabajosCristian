package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import controlador.Coordinador;
import modelo.dto.ProductosDTO;

import java.awt.Font;

public class VentanaRegistrarProducto extends JFrame implements ActionListener {

    private JPanel contentPane;
    private Coordinador miCoordinador;

    private JTextField txtCodigo, txtNombre, txtPrecio, txtCantidad;
    private JButton btnAgregar, btnVolver, btnActualizar;
    private JLabel lblResultado;

    public VentanaRegistrarProducto() {
        setBounds(100, 100, 400, 360);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Registrar o Actualizar Producto");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitulo.setBounds(90, 11, 250, 28);
        contentPane.add(lblTitulo);

        
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(50, 50, 100, 25);
        contentPane.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 50, 150, 25);
        contentPane.add(txtCodigo);

       
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 90, 100, 25);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 90, 150, 25);
        contentPane.add(txtNombre);

        
        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(50, 130, 100, 25);
        contentPane.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(150, 130, 150, 25);
        contentPane.add(txtPrecio);

        
        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(50, 170, 100, 25);
        contentPane.add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(150, 170, 150, 25);
        contentPane.add(txtCantidad);

        
        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(40, 220, 120, 30);
        btnAgregar.addActionListener(this);
        contentPane.add(btnAgregar);

        
        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBounds(140, 260, 120, 30);
        btnActualizar.addActionListener(this);
        contentPane.add(btnActualizar);

        
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(220, 220, 120, 30);
        btnVolver.addActionListener(this);
        contentPane.add(btnVolver);

        
        lblResultado = new JLabel("");
        lblResultado.setBounds(140, 300, 200, 20);
        contentPane.add(lblResultado);
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btnAgregar) {
            	
            	if (txtCodigo.getText().isEmpty() || txtNombre.getText().isEmpty() ||
                        txtPrecio.getText().isEmpty() || txtCantidad.getText().isEmpty()) {
                    	
                    	lblResultado.setText("Todos los campos son obligatorios");
                        //JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
                        return;
                    }
            	ProductosDTO producto = new ProductosDTO();
                producto.setCodigo(txtCodigo.getText());
                producto.setNombreProducto(txtNombre.getText());
                producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
                producto.setCantidad(Integer.parseInt(txtCantidad.getText()));

                String res = miCoordinador.registrarProducto(producto);

                if (res.equals("ok")) {
                    lblResultado.setText("Producto agregado correctamente");
                } else {
                    lblResultado.setText("Error al agregar");
                }

            } else if (e.getSource() == btnActualizar) {
            	ProductosDTO producto = new ProductosDTO();
                producto.setCodigo(txtCodigo.getText());
                producto.setNombreProducto(txtNombre.getText());
                producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
                producto.setCantidad(Integer.parseInt(txtCantidad.getText()));

                String res = miCoordinador.actualizarProducto(producto);

                if (res.equals("ok")) {
                    lblResultado.setText("Producto actualizado correctamente");
                } else {
                    lblResultado.setText("Error al actualizar");
                }
            }else if  (e.getSource() == btnVolver) {
                miCoordinador.mostrarVentanaProductos();
                this.setVisible(false);
            }
        
        limpiarCampos();
        
    }

    public void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
    }
}