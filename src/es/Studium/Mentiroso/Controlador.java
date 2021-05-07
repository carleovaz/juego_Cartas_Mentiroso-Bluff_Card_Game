package es.Studium.Mentiroso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements ActionListener, WindowListener
{
	Vista vista;
	Modelo modelo;

	public Controlador(Vista objvista, Modelo objmodelo)
	{
		this.vista = objvista;
		this.modelo = objmodelo;

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

		objvista.addWindowListener(this);
		objvista.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent evento) 
	{

		if(vista.buttonCrear.equals(evento.getSource()))
		{
			vista.ventanaCrear.setVisible(true);
		}

		else if(vista.buttonMejores.equals(evento.getSource()))
		{
			vista.ventanaMejoresJugadores.setVisible(true);
		}

		else if(vista.comoseJuega.equals(evento.getSource()))
		{
			vista.ventanaComoSeJuega.setVisible(true);
		}
		
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

	}


	public void windowClosing(WindowEvent arg0) 
	{
		vista.ventanaPrincipal.setVisible(false);
		vista.ventanaCrear.setVisible(false);
		vista.ventanaMejoresJugadores.setVisible(false);
		vista.ventanaComoSeJuega.setVisible(false);

	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}



	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}


}
