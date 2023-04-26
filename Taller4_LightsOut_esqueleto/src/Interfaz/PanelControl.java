package Interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelControl extends JPanel implements ActionListener{

	public PanelControl(VentanaJuego ventanaJuego) {
		
		setLayout( new GridLayout( 9,1 ) );
		setBorder( new TitledBorder( "Opciones" ) );
		add(new JLabel());
        JButton button1 = new JButton("NUEVO");
        button1.addActionListener(this);
        button1.setActionCommand( "NUEVO" );
        
        add(button1);
        add(new JLabel());

        JButton button2 = new JButton("REINICIAR");
        button2.addActionListener(this);
        button2.setActionCommand( "REINICIAR" );
       
        add(button2);
        add(new JLabel());

        JButton button3 = new JButton("TOP-10");
        button3.addActionListener(this);
        button3.setActionCommand( "TOP-10" );
       
        add(button3);
        add(new JLabel());

        JButton button4 = new JButton("CAMBIAR JUGADOR");
        button4.addActionListener(this);
        button4.setActionCommand( "CAMBIAR JUGADOR" );
        
        add(button4);
        add(new JLabel());
		
	}

	 public void actionPerformed( ActionEvent e )
	    {
	        String comando = e.getActionCommand( );
	        if(comando.equals( "NUEVO" ))
	        {
	            
	        }
	        else if(comando.equals( "REINICIAR" ))
	        {
	            
	        }
	        else if(comando.equals( "TOP-10" ))
	        {
	           
	        }
	        else if(comando.equals( "CAMBIAR JUGADOR" ))
	        {
	            
	        }

	    }
	 
}
