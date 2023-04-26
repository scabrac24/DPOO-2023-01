package Interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelJuegoJava2D extends JPanel implements MouseListener {
	
	private int ladoTablero;
	private VentanaJuego principal;
	private int tamano;

	public PanelJuegoJava2D(VentanaJuego ventanaJuego) 
	{
		principal = ventanaJuego;
		addMouseListener(this);
		add(new JLabel("                                                                                           "));
		

	}
	
	public void setTamano(int tam){
		
		tamano=tam;
	}



	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;

		int ancho = getWidth() / tamano;
		int alto = getHeight() / tamano;
	
		
		for (int i = 0; i < tamano; i++) 
		{
			for (int j = 0; j < tamano; j++) 
			{
				Rectangle2D.Double rect = new Rectangle2D.Double(i*ancho,j*alto,ancho,alto);
				g2d.setColor(Color.GRAY);
				g2d.fill(rect);
				g2d.setColor(Color.WHITE);
				g2d.draw(rect);
				g2d.drawImage(null, i, j, principal);
			}

		}

	}

	public void mousePressed(MouseEvent e) {
		int click_x = e.getX();
		int click_y = e.getY();
		int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
		//cantidades[casilla[0]][casilla[1]]++;
		principal.jugar(casilla[1], casilla[0]);
		//this.ultima_fila = casilla[0];
		//this.ultima_columna = casilla[1];
		repaint();
	}

	private int[] convertirCoordenadasACasilla(int x, int y) {
		
		int altoPanelTablero = getHeight();
		int anchoPanelTablero = getWidth();
		int altoCasilla = altoPanelTablero / ladoTablero;
		int anchoCasilla = anchoPanelTablero / ladoTablero;
		int fila = (int) (y / altoCasilla);
		int columna = (int) (x / anchoCasilla);

		return new int[] { fila, columna };
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
