package es.Studium.Mentiroso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

import es.Studium.Vistas.VistaCrearJugador;
import es.Studium.Vistas.VistaMenu;

public class Controlador implements ActionListener, WindowListener, MouseListener
{
	VistaMenu vistaMenu;
	VistaCrearJugador vistaCrearJ;
	Vista vista;
	Modelo modelo;
	Connection conexion = null;
	String informacion ="";
	

	int mazoJugador1[] = new int[24];
	int mazoJugador2[] = new int[24];
	int cartaActualJugador1 = 0;
	int cartaActualJugador2 = 0;
	int puntosJugador1 = 0;
	int puntosJugador2 = 0;
	int turno = 0; // 0 turno jugador 1, 1 turno jugador 2
	int uno, dos;

	public Controlador(Vista objvista, VistaMenu objvistaM,  Modelo objmodelo)
	{
		this.vista = objvista;
		this.vistaMenu = objvistaM;

		this.modelo = objmodelo;
		this.vista.addWindowListener(this);
		this.vistaMenu.addWindowListener(this);
		this.vista.addMouseListener(this);
		
		vistaMenu.ventanaMenu.addWindowListener(this);
		vistaMenu.buttonCrearPartida.addActionListener(this);
		vistaMenu.buttonCrearJugador.addActionListener(this);
		vistaMenu.buttoncomoSeJuega.addActionListener(this);
		vistaMenu.buttonMejoresJugadores.addActionListener(this);
		vistaMenu.buttonSalirMenu.addActionListener(this);
		
		objvista.ventanaCrearJugador.addWindowListener(this);
		objvista.ventanaCrearPartida.addWindowListener(this);
		objvista.ventanaComoSeJuega.addWindowListener(this);
		objvista.ventanaMejoresJugadores.addWindowListener(this);
		objvista.ventanaJuego.addWindowListener(this);

		objvista.crearJugador.addActionListener(this);
		objvista.buttonIniciarPartida.addActionListener(this);
		objvista.cerrarJugador.addActionListener(this);
		objvista.cerrarPartida.addActionListener(this);
		objvista.cerrar.addActionListener(this);
		objvista.cerrarAyuda.addActionListener(this);

		objvista.addWindowListener(this);
		objvista.setLocationRelativeTo(null);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) 
	{
		if(vistaMenu.buttonCrearPartida.equals(evento.getSource()))
		{
			vista.ventanaCrearPartida.setVisible(true);

		}
		
		if(vista.buttonIniciarPartida.equals(evento.getSource()))
		{
			vista.ventanaJuego.setVisible(true);
		}

		else if(vistaMenu.buttoncomoSeJuega.equals(evento.getSource()))
		{
			vista.ventanaComoSeJuega.setVisible(true);
		}


		else if(vista.buttonIniciarPartida.equals(evento.getSource()))
		{
			
		}

		else if(vistaMenu.buttonCrearJugador.equals(evento.getSource()))
		{
			new VistaCrearJugador();
			
		}
		
		//CREACIÓN DE JUGADOR
		else if(vista.crearJugador.equals(evento.getSource()))
		{

		}
		
		//CONSULTA MEJORES JUGADORES
		else if(vistaMenu.buttonMejoresJugadores.equals(evento.getSource()))
		{
			vista.ventanaMejoresJugadores.setVisible(true);
			//CONECTAMOS A LA BASE DE DATOS
			conexion = this.modelo.conectar();
			//REALIZAR LA CONSULTA E INSERTAR INFORMACIÓN
			informacion = this.modelo.mejoresJugadores(conexion);
			//RELLENAMOS EL TEXTAREA
			this.vista.listadoJugadores.append(informacion);
			//CERRAMOS CONEXION
			this.modelo.cerrar(conexion);
		}


		//BOTONES QUE CIERRAN VENTANAS
		if(vistaMenu.buttonSalirMenu.equals(evento.getSource()))
		{
			System.exit(0);
		}

		else if(vista.cerrarJugador.equals(evento.getSource()))
		{
			vista.ventanaCrearJugador.setVisible(false);

		}

		else if(vista.cerrarPartida.equals(evento.getSource()))
		{
			vista.ventanaCrearPartida.setVisible(false);

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
		vista.dialogoMensajeJugadorCreado.setVisible(false);
		vista.dialogoMensajePartidaCreada.setVisible(false);
		vistaMenu.ventanaMenu.setVisible(false);
		vista.ventanaCrearPartida.setVisible(false);
		vista.ventanaCrearJugador.setVisible(false);
		vista.ventanaMejoresJugadores.setVisible(false);
		vista.ventanaComoSeJuega.setVisible(false);
		vista.ventanaJuego.setVisible(false);
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
