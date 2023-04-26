package Interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;





public class VentanaJuego extends JFrame
{
		private PanelControl panelControl;
	    private PanelDificultad panelDificultad;
	    private PanelJugadasJugador panelJugadas;
	    
	    private boolean[][] matriz;

		public VentanaJuego() {
			

			
			
			setSize( 900,650 );
            setResizable( false );
	        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
	        setTitle( "LightsOut" );
	        setLayout( new BorderLayout( ) );
	               
	        panelControl= new PanelControl(this);
	        add(panelControl, BorderLayout.EAST);
	        
	        panelDificultad = new PanelDificultad(this );
	        add(panelDificultad, BorderLayout.NORTH);
	        
	        panelJugadas = new PanelJugadasJugador(this);
	        add(panelJugadas, BorderLayout.SOUTH);
	        
	    
	
	
		}
		
		
		public static void main (String[ ] args)
		    {
		        VentanaJuego ventana= new VentanaJuego();
		        ventana.setLocationRelativeTo( null );
		        ventana.setVisible( true );
		    }
		
		
		    
		public void dispose()
		    {
		        JOptionPane.showMessageDialog( this, "Programa Cerrado" );
		        
		        
		        System.exit( 0 );
		    }
		
		
		public void jugar( int i, int j )
	    {
	        matriz[i][j]=true;
	    }

		public boolean[][] darTableroJuego( )
		{
		    return matriz;
		}
		
}
