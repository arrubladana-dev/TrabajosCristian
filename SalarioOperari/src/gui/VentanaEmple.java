package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaEmple extends JDialog implements ActionListener {

    private JButton btnCerrar;
    private JTextArea texArea;
	private JScrollPane scroll;

    public VentanaEmple(JFrame parent, String lista) {
        super(parent, "Ventana Emergente", true); 

        setSize(400,300);
        setLocationRelativeTo(parent);
        setLayout(null);


        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(90,100,100,30);
        btnCerrar.addActionListener(this);
        
        
        
        setSize(500,400);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        texArea = new JTextArea();
        texArea.setEditable(false);
        texArea.setText(lista);

        scroll = new JScrollPane(texArea);

        getContentPane().add(scroll);
    }
    
    

    public void actionPerformed1(ActionEvent e) {
        dispose(); // Cierra la ventana
    }



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
