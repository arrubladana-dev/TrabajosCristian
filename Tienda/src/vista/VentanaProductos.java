package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import controlador.Coordinador;

public class VentanaProductos extends JFrame implements ActionListener {

    private JPanel contentPane;
    private Coordinador miCoordinador;

    private JButton btnRegistrar, btnLista, btnEliminar, btnVolver;
    private JTextField txtEliminar;

    public VentanaProductos() {
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {

        JLabel titulo = new JLabel("GESTIÓN DE PRODUCTOS");
        titulo.setBounds(50, 20, 300, 30);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(titulo);

        // 🔹 REGISTRAR
        btnRegistrar = new JButton("Registrar Producto");
        btnRegistrar.setBounds(100, 70, 200, 30);
        btnRegistrar.addActionListener(this);
        contentPane.add(btnRegistrar);

        // 🔹 CONSULTAR
        btnLista = new JButton("Consultar Productos");
        btnLista.setBounds(100, 110, 200, 30);
        btnLista.addActionListener(this);
        contentPane.add(btnLista);

        // 🔹 ELIMINAR
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(50, 160, 100, 30);
        btnEliminar.addActionListener(this);
        contentPane.add(btnEliminar);

        txtEliminar = new JTextField();
        txtEliminar.setBounds(160, 160, 150, 30);
        contentPane.add(txtEliminar);

        // 🔹 VOLVER
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(120, 210, 150, 30);
        btnVolver.addActionListener(this);
        contentPane.add(btnVolver);
    }

    public String getProductoEliminar() {
        return txtEliminar.getText();
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRegistrar) {

            miCoordinador.mostrarVentanaRegistrarProducto();
            this.setVisible(false);
            dispose();

        } else if (e.getSource() == btnLista) {

            miCoordinador.mostrarVentanaConsultarProductos();
            dispose();

        } else if (e.getSource() == btnEliminar) {

            String codigo = txtEliminar.getText();


            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el código del producto");
                return;
            }

            String res = miCoordinador.eliminarProducto(codigo);

            if (res.equals("ok")) {
                JOptionPane.showMessageDialog(this, "Producto eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el producto");
            }

            limpiarCampos();

        } else if (e.getSource() == btnVolver) {

            miCoordinador.verVentanaPrincipal();
            this.setVisible(false);
            dispose();
        }
    }

    public void limpiarCampos() {
        txtEliminar.setText("");
    }
}