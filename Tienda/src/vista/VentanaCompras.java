package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.util.ArrayList;

import controlador.Coordinador;
import modelo.dto.ClienteDTO;
import modelo.dto.ProductosDTO;
import modelo.dto.ComprasDTO;

public class VentanaCompras extends JFrame implements ActionListener {

    private JPanel contentPane;
    private Coordinador miCoordinador;

    private JTextField txtDocumentoUsuario;
    private JComboBox<String> comboProductos;
    private JTextField txtCantidad;
    private JTextArea areaCompras;

    private JButton btnValidarUsuario;
    private JButton btnAgregarProducto;
    private JButton btnRegistrarCompra;
    private JButton btnVolver;

    public VentanaCompras() {
        setTitle("Gestión de Compras");
        setBounds(100, 100, 500, 450);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JLabel lblDocumento = new JLabel("Documento Usuario:");
        lblDocumento.setBounds(20, 20, 150, 25);
        contentPane.add(lblDocumento);

        txtDocumentoUsuario = new JTextField();
        txtDocumentoUsuario.setBounds(180, 20, 150, 25);
        contentPane.add(txtDocumentoUsuario);

        btnValidarUsuario = new JButton("Validar");
        btnValidarUsuario.setBounds(340, 20, 100, 25);
        btnValidarUsuario.addActionListener(this);
        contentPane.add(btnValidarUsuario);

        
        JLabel lblProducto = new JLabel("Producto:");
        lblProducto.setBounds(20, 60, 150, 25);
        contentPane.add(lblProducto);

        comboProductos = new JComboBox<>();
        comboProductos.setBounds(180, 60, 200, 25);
        contentPane.add(comboProductos);

        
        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(20, 100, 150, 25);
        contentPane.add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(180, 100, 150, 25);
        contentPane.add(txtCantidad);

        
        btnAgregarProducto = new JButton("Agregar Producto");
        btnAgregarProducto.setBounds(150, 140, 180, 30);
        btnAgregarProducto.addActionListener(this);
        contentPane.add(btnAgregarProducto);

        
        areaCompras = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaCompras);
        scroll.setBounds(20, 180, 440, 120);
        contentPane.add(scroll);

        
        btnRegistrarCompra = new JButton("Finalizar Compra");
        btnRegistrarCompra.setBounds(150, 310, 180, 30);
        btnRegistrarCompra.addActionListener(this);
        contentPane.add(btnRegistrarCompra);

        
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(150, 350, 180, 30);
        btnVolver.addActionListener(this);
        contentPane.add(btnVolver);
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    
    public void cargarProductos(ArrayList<ProductosDTO> lista) {
    	comboProductos.removeAllItems();

        for (ProductosDTO p : lista) {
        	comboProductos.addItem(p);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnValidarUsuario) {

            String documento = txtDocumentoUsuario.getText();

            ClienteDTO cliente = miCoordinador.consultarUsuario(documento);

            if (cliente == null) {
                JOptionPane.showMessageDialog(this, "Usuario no registrado");
            } else {
                JOptionPane.showMessageDialog(this, "Usuario válido");
            }
        }

        if (e.getSource() == btnAgregarProducto) {

            String producto = (String) comboProductos.getSelectedItem();
            ventanaCompras.cargarProductos(miCoordinador.obtenerProductos());
            String cantidad = txtCantidad.getText();

            if (producto == null || cantidad.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete los campos");
                return;
            }

            areaCompras.append("Producto: " + producto + "  Cantidad: " + cantidad + "\n");
        }

        
        if (e.getSource() == btnRegistrarCompra) {

            String documento = txtDocumentoUsuario.getText();

            ClienteDTO cliente = miCoordinador.consultarUsuario(documento);

            if (cliente == null) {
                JOptionPane.showMessageDialog(this, "Usuario no registrado");
                return;
            }

            try {
                String seleccionado = (String) comboProductos.getSelectedItem();

                if (seleccionado == null) {
                    JOptionPane.showMessageDialog(this, "Seleccione un producto");
                    return;
                }

                
                String codigoProducto = seleccionado.split(" - ")[0];

                ProductosDTO producto = miCoordinador.consultarProducto(codigoProducto);

                if (producto == null) {
                    JOptionPane.showMessageDialog(this, "Producto no encontrado");
                    return;
                }

                double precio = producto.getPrecio();
                int cantidad = Integer.parseInt(txtCantidad.getText());

                double total = precio * cantidad;

                
                double descuento = miCoordinador.calcularDescuento(total, cliente.getTipo());
                double totalPagar = miCoordinador.calcularTotalPagar(total, descuento);

                
                ComprasDTO compra = new ComprasDTO();
                compra.setDocumento(cliente.getDocumento());
                compra.setCodigoProducto(codigoProducto);
                compra.setTotal(total);
                compra.setDescuento(descuento);
                compra.setCompraRealizada(totalPagar);

                
                miCoordinador.registrarCompra(compra);

                JOptionPane.showMessageDialog(this,
                        "Compra realizada\nTotal: $" + total +
                        "\nDescuento: $" + descuento +
                        "\nTotal a pagar: $" + totalPagar);

                areaCompras.setText("");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error en datos: " + ex.getMessage());
            }
        }


        if (e.getSource() == btnVolver) {
            miCoordinador.verVentanaPrincipal();
            this.setVisible(false);
        }
    }
}