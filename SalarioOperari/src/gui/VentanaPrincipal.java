package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.ModeloDatos;
import clases.Procesos;
import entidades.Operario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textSueldo;
	private JTextField textAñosAntiguo;
	private JLabel lblNuevoSueldo;
	private JLabel lblMostaraSueldo;
	private JTextField textCedula;
	private JButton btnCalcular;
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private JLabel lblSueldo;
	private JLabel lblAosAntiguedad;
	private JLabel lblCedula;
	private JButton btnLimpiar;
	private JButton btnEmpleados;
	
	Operario miOperario;
	Procesos miProceso;
	ModeloDatos miModeloDatos;
	private JButton btnEliminar;
	private JButton btnConsultar;


	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		miProceso = new Procesos();
		miModeloDatos = new ModeloDatos();
		
		iniciarComponentes();
		 
		
		

	}


	private void iniciarComponentes() {
		// TODO Auto-generated method stub
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(32, 59, 46, 14);
		contentPane.add(lblNombre);
		
		lblTitulo = new JLabel("Sueldo Operarios");
		lblTitulo.setBounds(124, 11, 193, 26);
		lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
		contentPane.add(lblTitulo);
		
		textNombre = new JTextField();
		textNombre.setBounds(99, 56, 268, 20);
		textNombre.setColumns(10);
		
		lblSueldo = new JLabel("Sueldo");
		lblSueldo.setBounds(32, 97, 46, 14);
		
		textSueldo = new JTextField();
		textSueldo.setText("");
		textSueldo.setBounds(99, 94, 92, 20);
		
		lblAosAntiguedad = new JLabel("Años antiguedad");
		lblAosAntiguedad.setBounds(201, 97, 89, 14);
		
		textAñosAntiguo = new JTextField();
		textAñosAntiguo.setText("");
		textAñosAntiguo.setBounds(307, 94, 60, 20);
		
		lblNuevoSueldo = new JLabel("Nuevo sueldo:");
		lblNuevoSueldo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNuevoSueldo.setBounds(31, 159, 78, 14);
		
		lblMostaraSueldo = new JLabel("Wiii");
		lblMostaraSueldo.setBounds(123, 145, 256, 46);
		
		btnCalcular = new JButton("Guardar");
		btnCalcular.setBounds(120, 195, 78, 23);
		btnCalcular.addActionListener(this);
		
		lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(32, 131, 46, 14);
		
		textCedula = new JTextField();
		textCedula.setColumns(10);
		textCedula.setBounds(99, 128, 268, 20);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(32, 195, 78, 23);
		btnLimpiar.addActionListener(this);
		
		btnEmpleados = new JButton("Empleados");
		btnEmpleados.setBounds(208, 195, 83, 23);
		btnEmpleados.addActionListener(this);
			
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(307, 195, 78, 23);
		btnEliminar.addActionListener(this);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(178, 229, 78, 23);
		btnConsultar.addActionListener(this);
		
		contentPane.add(textNombre);
		contentPane.add(lblSueldo);
		contentPane.add(textSueldo);
		contentPane.add(lblAosAntiguedad);
		contentPane.add(textAñosAntiguo);
		contentPane.add(lblNuevoSueldo);
		contentPane.add(lblMostaraSueldo);
		contentPane.add(btnCalcular);
		contentPane.add(lblCedula);
		contentPane.add(textCedula);
		contentPane.add(btnLimpiar);		
		contentPane.add(btnEmpleados);		
		contentPane.add(btnEliminar);		
		contentPane.add(btnConsultar);
		
		
		
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==btnCalcular) {
			calcular();
		} else if (e.getSource()==btnLimpiar) {
			limpiar();
		}else if (e.getSource()==btnEmpleados) {
			empleados();
		}else if (e.getSource()==btnEliminar) {
			eliminar();
		}else if (e.getSource()==btnConsultar) {
			consultar();
		}
	}


	private void consultar() {
		// TODO Auto-generated method stub
		String documento= (JOptionPane.showInputDialog("ingre se el nombre del operario actualizar"));
		Operario operarioEncon= miModeloDatos.consultarOperario(Integer.parseInt(documento));
		
		if(operarioEncon!=null) {
			textNombre.setText(operarioEncon.getNombre());
			textCedula.setText(operarioEncon.getId()+"");
			textSueldo.setText(operarioEncon.getId()+"");
			textAñosAntiguo.setText(operarioEncon.getAñosAntiguedad()+"");
			
		}else {
			JOptionPane.showMessageDialog(null, "No se encuenttra el operario", "Advertencia,", JOptionPane.WARNING_MESSAGE);
		}
	}


	private void eliminar() {
		// TODO Auto-generated method stub
		String documento= (JOptionPane.showInputDialog("ingre se el nombre del operario"));
		JOptionPane.showMessageDialog(null,miModeloDatos.eliminarOperario(Integer.parseInt(documento)));
		;
	}


	private void empleados() {
		// TODO Auto-generated method stub
		String listaConsultada= miModeloDatos.imprimirOperario();
		
		abrirEmergente(listaConsultada);
	}
	
	private void abrirEmergente(String listaEst) {
	    VentanaEmple ventana = new VentanaEmple(this, listaEst);
	    ventana.setVisible(true);
	    
	}


	private void limpiar() {
		// TODO Auto-generated method stub
		System.out.println("Presiona Limpiar");
		textNombre.setText("");
		textCedula.setText("");
		textCedula.setText("");
		textSueldo.setText("");
		textAñosAntiguo.setText("");
		
	}


	private void calcular() {
		// TODO Auto-generated method stub
		String suel=textSueldo.getText();
		String antig=textAñosAntiguo.getText();
		
		System.out.println("Presiona Calcular");
		
		miOperario=new Operario();
		
		boolean validaSuel = validaCampo(suel,textSueldo);
		boolean validaAño = validaCampo(antig, textAñosAntiguo);
		
		if(validaSuel&&validaAño) {
			miOperario.setId(Integer.parseInt(textCedula.getText())); 
			miOperario.setNombre(textNombre.getText()); 
			//miOperario.setSalario(Double.parseDouble(textSueldo.getText())); 
			miOperario.setAñosAntiguedad(Integer.parseInt(textAñosAntiguo.getText())); 
			
			double salario = miProceso.aumentoSalario(Double.parseDouble(suel),Integer.parseInt(antig));
			
			miOperario.setSalario(salario); 
			reiniciarColores();
			lblMostaraSueldo.setText(salario+"");
			miModeloDatos.registrarOperario(miOperario);
			System.out.println(salario);
			
		}else {
			lblMostaraSueldo.setText("Valide los campos");
			lblMostaraSueldo.setForeground(Color.red);
		}
		
		
		
		
		
		System.out.println("wiii");
		
	}
	private boolean validaCampo(String n,  JTextField campos) {
		boolean valida;
		
		if(miProceso.esDouble(n)) {
			valida=true;
			campos.setBackground(Color.white);
			
		}else {
			System.out.println("Presente mensaje error  "+n);
			campos.setBackground(Color.red);
			valida=false;
		}
		return valida;
	}
	
	private void reiniciarColores() {
		textSueldo.setBackground(Color.white);
		textAñosAntiguo.setBackground(Color.white);
		lblMostaraSueldo.setForeground(Color.white);
	}
	
	
}
