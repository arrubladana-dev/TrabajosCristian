package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clases.ModeloDtos;
import clases.Procesos;
import entidades.Estudiante;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ventana_Procesos extends JFrame implements ActionListener{

	
	private JLabel etiTitulo;
	private JLabel etiNombre;
	private JLabel etiMateria;
	private JLabel etiDocumento;
	private JLabel etiN1, etiN2, etiN3;
	private JLabel etiResultado;
	private JLabel etiRes;
	
	private JTextField txtNombre;
	private JTextField txtMateria;
	private JTextField txtDocumento;
	private JTextField txtN1,txtN2,txtN3;
	
	private JButton btnCalcular;
	private JButton btnLimpiar;
	private JButton btnConsultar;
	private JButton btnLista;
	
    private JTextArea texArea;
	private JScrollPane scroll;
	private JButton btnActualizarEst;
	private JButton btnEliminar;
	
	
	
	Estudiante miEst;
	Procesos miProceso;
	ModeloDtos miModeloDatos;
	
	
	public Ventana_Procesos() {
		miProceso=new Procesos();
		miModeloDatos = new ModeloDtos();
		
		setTitle("Ventana Promedio");
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		getContentPane().setLayout(null);
		
		etiTitulo=new JLabel();
		etiTitulo.setText("CALCULO DEL PROMEDIO");
		etiTitulo.setBounds(244, 0, 350, 90);
		etiTitulo.setFont(new Font("SansSerif", Font.PLAIN, 25));
		
		etiNombre=new JLabel();
		etiNombre.setText("Nombre: ");
		etiNombre.setBounds(50, 70, 120, 90);
		
		txtNombre=new JTextField();
		txtNombre.setText("");
		txtNombre.setBounds(130, 95, 520, 40);
		
		etiMateria=new JLabel();
		etiMateria.setText("Materia: ");
		etiMateria.setBounds(50, 120, 120, 90);
		
		txtMateria=new JTextField();
		txtMateria.setText("");
		txtMateria.setBounds(130, 155, 220, 40);
		
		etiDocumento=new JLabel();
		etiDocumento.setText("Documento: ");
		etiDocumento.setBounds(380, 130, 120, 90);
		
		txtDocumento=new JTextField();
		txtDocumento.setText("");
		txtDocumento.setBounds(480, 155, 170, 40);
	
		
		etiN1=new JLabel();
		etiN1.setText("Nota1: ");
		etiN1.setBounds(50, 190, 120, 90);
		
		txtN1=new JTextField();
		txtN1.setText("");
		txtN1.setBounds(40, 250, 100, 40);
		
		etiN2=new JLabel();
		etiN2.setText("Nota2: ");
		etiN2.setBounds(180, 190, 120, 90);
		
		txtN2=new JTextField();
		txtN2.setText("");
		txtN2.setBounds(170, 250, 100, 40);
		
		etiN3=new JLabel();
		etiN3.setText("Nota3: ");
		etiN3.setBounds(300, 190, 120, 90);
		
		txtN3=new JTextField();
		txtN3.setText("");
		txtN3.setBounds(290, 250, 100, 40);
		
		etiResultado=new JLabel();
		etiResultado.setText("Resultado: ");
		etiResultado.setBounds(20, 314, 150, 46);
		etiResultado.setFont(new Font("SansSerif", Font.PLAIN, 20));
		
		
		etiRes=new JLabel();
		etiRes.setText(" ");
		etiRes.setBounds(130, 301, 596, 56);
		etiRes.setFont(new Font("SansSerif", Font.PLAIN, 20));

		
		btnCalcular=new JButton();
		btnCalcular.setText("Calcular");
		btnCalcular.setBounds(55,368,90,40);
		btnCalcular.addActionListener(this);
		
		btnLimpiar=new JButton();
		btnLimpiar.setText("Limpiar");
		btnLimpiar.setBounds(155,368,90,40);
		btnLimpiar.addActionListener(this);
		
		btnConsultar = new JButton();
		btnConsultar.setText("Consultar");
		btnConsultar.setBounds(259, 368, 90, 40);
		btnConsultar.addActionListener(this);
		
		btnLista = new JButton();
		btnLista.setText("Lista");
		btnLista.setBounds(359, 368, 90, 40);
		btnLista.addActionListener(this);
		
		
		
		scroll = new JScrollPane();
		scroll.setBounds(60, 419, 654, 119);
		
		texArea = new JTextArea();
		scroll.setViewportView(texArea);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(455, 368, 106, 40);
		btnEliminar.addActionListener(this);
		
		btnActualizarEst = new JButton("Actualizar estudiante");
		btnActualizarEst.setBounds(567, 368, 134, 40);
		btnActualizarEst.addActionListener(this);
		
		
		getContentPane().add(etiTitulo);
		getContentPane().add(etiNombre);
		getContentPane().add(txtNombre);
		getContentPane().add(etiMateria);
		getContentPane().add(etiDocumento);
		getContentPane().add(txtMateria);
		getContentPane().add(txtDocumento);
		getContentPane().add(etiN1);
		getContentPane().add(txtN1);
		getContentPane().add(etiN2);
		getContentPane().add(txtN2);
		getContentPane().add(etiN3);
		getContentPane().add(txtN3);
		getContentPane().add(etiResultado);
		getContentPane().add(etiRes);
		getContentPane().add(btnCalcular);
		getContentPane().add(btnLimpiar);
		getContentPane().add(btnConsultar);
		getContentPane().add(btnLista);
		getContentPane().add(scroll);
		getContentPane().add(btnEliminar);
		getContentPane().add(btnActualizarEst);
		
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnCalcular) {
			calcular();
		}
		else if(e.getSource()==btnLimpiar) {
			limpiar();
		}else if(e.getSource()==btnConsultar) {
			consultar();
		}else if (e.getSource()==btnLista) {
			lista();
		}else if(e.getSource()==btnEliminar) {
			eliminar();
		}else if(e.getSource()==btnActualizarEst) {
			ActualizarEstudiante();
		}
	}

	private void ActualizarEstudiante() {
		// TODO Auto-generated method stub
		
		miEst = new Estudiante();

		miEst.setDocumento(Integer.parseInt(txtDocumento.getText()));
		miEst.setNombre(txtNombre.getText());
		miEst.setMateria(txtMateria.getText());
		miEst.setNota1(Double.parseDouble(txtN1.getText()));
		miEst.setNota2(Double.parseDouble(txtN2.getText()));
		miEst.setNota3(Double.parseDouble(txtN3.getText()));

	    double prom = miProceso.calcularPromedio(miEst.getNota1(), miEst.getNota2(), miEst.getNota3());

	    miEst.setPromedio(prom);

	    String resultado = miModeloDatos.actualizarEstudiante(miEst);

	    JOptionPane.showMessageDialog(null, resultado);
				
		
		
	}

	private void eliminar() {
		// TODO Auto-generated method stub
		String documento= (JOptionPane.showInputDialog("ingre se el nombre del estudiante"));
		JOptionPane.showMessageDialog(null,miModeloDatos.eliminarEstudiante(Integer.parseInt(documento)));
		;
	}

	private void lista() {
		// TODO Auto-generated method stub
		String listaConsultada= miModeloDatos.imprimirListaEstudiantes();
		texArea.setText(listaConsultada);
		abrirEmergente(listaConsultada);
	}

	private void consultar() {
		// TODO Auto-generated method stub
		String documento= (JOptionPane.showInputDialog("ingre se el nombre del estudian actualizar"));
		Estudiante estudianteEncontrado= miModeloDatos.consultaEstudiante(Integer.parseInt(documento));
		
		if(estudianteEncontrado!=null) {
			txtNombre.setText(estudianteEncontrado.getNombre());
			txtMateria.setText(estudianteEncontrado.getMateria());
			txtDocumento.setText(estudianteEncontrado.getDocumento()+"");
			txtN1.setText(estudianteEncontrado.getNota1()+"");
			txtN2.setText(estudianteEncontrado.getNota2()+"");
			txtN3.setText(estudianteEncontrado.getNota3()+"");
			texArea.setText("El promedio del estudiante es: "+estudianteEncontrado.getPromedio());
		}else {
			JOptionPane.showMessageDialog(null, "No se encuenttra el estudiante", "Advertencia,", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void calcular() {
		
		String n1=txtN1.getText();
		String n2=txtN2.getText();
		String n3=txtN3.getText();
		
		System.out.println("Presiona Calcular");
		
		miEst=new Estudiante();
		miEst.setDocumento(Integer.parseInt(txtDocumento.getText())); //// aqui hay que hacer algo
		miEst.setNombre(txtNombre.getText());
		miEst.setMateria(txtMateria.getText());
		
		///if(miProceso.validarNota(n1,n2,n3)) {
		
		boolean validaN1=validaCampo(n1, txtN1);
		boolean validaN2=validaCampo(n2, txtN2);
		boolean validaN3=validaCampo(n3, txtN3);

		if (validaN1==true && validaN2==true && validaN3==true) {
			
			miEst.setNota1(Double.parseDouble(txtN1.getText()));
			miEst.setNota2(Double.parseDouble(txtN2.getText()));
			miEst.setNota3(Double.parseDouble(txtN3.getText()));
			
			//etiRes.setText(miEst.getNombre());
			reiniciarColores();
			
			
			double prom=miProceso.calcularPromedio(miEst.getNota1(), miEst.getNota2(), miEst.getNota3());
			
			
			 miModeloDatos.registrarEstudiante(miEst);
			 if(prom<3.5) {
				 etiRes.setText("Hola "+miEst.getNombre()+", su promedio es: "+prom+" y perdio");
				 etiRes.setForeground(Color.red);
				 miEst.setPromedio(prom);
			 }else {
				 etiRes.setText("Hola "+miEst.getNombre()+", su promedio es: "+prom+" y gano");
				 etiRes.setForeground(Color.blue);
				 miEst.setPromedio(prom);
			 }
			
			
		}else {
			etiRes.setText("Valide los campos");
			etiRes.setForeground(Color.red);
		}

		
		
		System.out.println(miEst);
		System.out.println("Nombre: "+miEst.getNombre());
	
		
	}

	private boolean validaCampo(String n, JTextField txtNota) {
		boolean valida;
		
		if(miProceso.validarNota(n)) {
			valida=true;
			txtNota.setBackground(Color.white);
		}else {
			System.out.println("Presente mensaje error para nota "+n);
			txtNota.setBackground(Color.red);
			valida=false;
		}
		return valida;
	}

	private void reiniciarColores() {
		txtN1.setBackground(Color.white);
		txtN2.setBackground(Color.white);
		txtN3.setBackground(Color.white);
	}

	private void limpiar() {
		System.out.println("Presiona Limpiar");
		txtNombre.setText("");
		txtMateria.setText("");
		txtDocumento.setText("");
		txtN1.setText("");
		txtN2.setText("");
		txtN3.setText("");
		etiRes.setText("");
	}
	
	/// ventana 
	private void abrirEmergente(String listaEst) {
	    VentanaEmergente ventana = new VentanaEmergente(this, listaEst);
	    ventana.setVisible(true);
	    
	}
	
}