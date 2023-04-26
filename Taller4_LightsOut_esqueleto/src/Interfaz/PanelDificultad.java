package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDificultad extends JPanel implements ActionListener {
	
	
	private JComboBox<String> comboTamano;
	private PanelJuegoJava2D panel2D;
	private JLabel etiquetaTamano;
	private JLabel etiquetaDificultad;
	private JCheckBox checkBoxFacil;
	private JCheckBox checkBoxMedio;
	private JCheckBox checkBoxDificil;
	
	
	public PanelDificultad(VentanaJuego ventanaJuego) {
		
		setSize(500,500);
		setLayout(new FlowLayout());
		
		panel2D = new PanelJuegoJava2D(ventanaJuego);
		etiquetaTamano = new JLabel("Tamaño: ");
		etiquetaDificultad = new JLabel("Dificultad: ");
		
		
		checkBoxFacil = new JCheckBox("Facil");
		checkBoxFacil.addActionListener(this);
		
		checkBoxMedio = new JCheckBox("Medio");
		checkBoxMedio.addActionListener(this);
		
		checkBoxDificil = new JCheckBox("Dificl");
		checkBoxDificil.addActionListener(this);
		
		
		comboTamano = new JComboBox<String>();
		comboTamano.addActionListener(this);
		
		comboTamano.addItem("3x3");
		comboTamano.addItem("5x5");
		comboTamano.addItem("7x7");
		
		
		add(etiquetaTamano);
		add(comboTamano);
		add(etiquetaDificultad);
		add(checkBoxFacil);
		add(checkBoxMedio);
		add(checkBoxDificil);
		
		
		ventanaJuego.add(panel2D, BorderLayout.CENTER);
		
		
		
	}

	
	public void actionPerformed(ActionEvent e) {
		String seleccionados = (String)comboTamano.getSelectedItem();
		String tam = seleccionados.substring(0,1);
		panel2D.setTamano(Integer.parseInt(tam));
		panel2D.repaint();
		
	}

}
