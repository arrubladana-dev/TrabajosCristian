package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import controlador.Coordinador;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private JPanel contentPane;
    private Coordinador miCoordinador;

    private JButton btnUsuarios;
    private JButton btnProductos;
    private JButton btnCompras;

    public VentanaPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        JLabel titulo = new JLabel("BIENVENIDO A LA TIENDA");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(50, 20, 350, 30);
        contentPane.add(titulo);

        btnUsuarios = new JButton("Gestión de Usuarios");
        btnUsuarios.setBounds(100, 80, 250, 30);
        btnUsuarios.addActionListener(this);
        contentPane.add(btnUsuarios);

        btnProductos = new JButton("Gestión de Productos");
        btnProductos.setBounds(100, 120, 250, 30);
        btnProductos.addActionListener(this);
        contentPane.add(btnProductos);

        btnCompras = new JButton("Gestión de Compras");
        btnCompras.setBounds(100, 160, 250, 30);
        btnCompras.addActionListener(this);
        contentPane.add(btnCompras);
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnUsuarios) {
            miCoordinador.mostrarVentanaUsuarios();
        } else if (e.getSource() == btnProductos) {
            miCoordinador.mostrarVentanaProductos();
        } else if (e.getSource() == btnCompras) {
            miCoordinador.mostrarVentanaCompras();
        }
    }
}
