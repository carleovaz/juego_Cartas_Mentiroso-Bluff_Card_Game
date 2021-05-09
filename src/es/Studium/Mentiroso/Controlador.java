package es.Studium.Mentiroso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements ActionListener, WindowListener,MouseListener
{
	Vista vista;
	Modelo modelo;
	int mazoJugador1[] = new int[24];
	int mazoJugador2[] = new int[24];
	int cartaActualJugador1 = 0;
	int cartaActualJugador2 = 0;
	int puntosJugador1 = 0;
	int puntosJugador2 = 0;
	int turno = 0; // 0 turno jugador 1, 1 turno jugador 2
	int uno, dos;

	public Controlador(Vista objvista, Modelo objmodelo)
	{
		this.vista = objvista;
		this.modelo = objmodelo;
		this.vista.addWindowListener(this);
		this.vista.addMouseListener(this);

		objvista.ventanaPrincipal.addWindowListener(this);
		objvista.ventanaCrear.addWindowListener(this);
		objvista.ventanaComoSeJuega.addWindowListener(this);
		objvista.ventanaMejoresJugadores.addWindowListener(this);

		objvista.buttonCrear.addActionListener(this);
		objvista.buttonMejores.addActionListener(this);
		objvista.buttonSalir.addActionListener(this);
		objvista.cancelar.addActionListener(this);
		objvista.comoseJuega.addActionListener(this);
		objvista.cerrar.addActionListener(this);
		objvista.cerrarAyuda.addActionListener(this);

		objvista.addWindowListener(this);
		objvista.setLocationRelativeTo(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) 
	{
		if(vista.buttonCrear.equals(evento.getSource()))
		{
			vista.ventanaCrear.setVisible(true);
			this.modelo.barajar(mazoJugador1, mazoJugador2);

		}

		else if(vista.buttonMejores.equals(evento.getSource()))
		{
			vista.ventanaMejoresJugadores.setVisible(true);	
		}

		else if(vista.comoseJuega.equals(evento.getSource()))
		{
			vista.ventanaComoSeJuega.setVisible(true);
		}

		//BOTONES QUE CIERRAN VENTANAS
		if(vista.buttonSalir.equals(evento.getSource()))
		{
			System.exit(0);
		}

		else if(vista.cancelar.equals(evento.getSource()))
		{
			vista.ventanaCrear.setVisible(false);
		}

		else if(vista.cerrar.equals(evento.getSource()))
		{
			vista.ventanaMejoresJugadores.setVisible(false);
		}
		
		else if(vista.cerrarAyuda.equals(evento.getSource()))
		{
			vista.ventanaComoSeJuega.setVisible(false);
		}

	}

	public void windowClosing(WindowEvent arg0) 
	{
		vista.ventanaPrincipal.setVisible(false);
		vista.ventanaCrear.setVisible(false);
		vista.ventanaMejoresJugadores.setVisible(false);
		vista.ventanaComoSeJuega.setVisible(false);
	}
	

	public void mouseClicked(MouseEvent arg0) {
	
	}
	public void mouseEntered(MouseEvent arg0) {

	}
	public void mouseExited(MouseEvent arg0) {

	}
	public void mousePressed(MouseEvent arg0) {

	}
	public void mouseReleased(MouseEvent arg0) {

	}
	public void windowActivated(WindowEvent arg0) {
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
	}

}
