package es.Studium.Mentiroso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

import Musica.Sonido2;
import es.Studium.Vistas.VistaCrearJugador;
import es.Studium.Vistas.VistaCrearPartida;
import es.Studium.Vistas.VistaJugando;
import es.Studium.Vistas.VistaMejoresJ;
import es.Studium.Vistas.VistaMenuPrincipal;

public class Controlador implements ActionListener, WindowListener, MouseListener
{
	VistaMenuPrincipal vistaMenu;
	VistaCrearJugador vistaCrearJ;
	VistaCrearPartida vistaCrearP;
	VistaJugando vistaJugando;
	VistaMejoresJ vistaMejoresJ;
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

	public Controlador(VistaMejoresJ objvista, VistaMenuPrincipal objvistaM, VistaCrearJugador objvistaJ, VistaCrearPartida objvistaP, VistaJugando objvistaJug, Modelo objmodelo)
	{
		this.vistaMejoresJ = objvista;
		this.vistaMenu = objvistaM;
		this.vistaCrearJ = objvistaJ;
		this.vistaCrearP = objvistaP;
		this.vistaJugando = objvistaJug;

		this.modelo = objmodelo;
		this.vistaMejoresJ.addWindowListener(this);
		this.vistaMenu.addWindowListener(this);
		this.vistaMejoresJ.addWindowListener(this);
		this.vistaJugando.addWindowListener(this);
		this.vistaJugando.addMouseListener(this);
		
		//ELEMENTOS VISTA JUGADOR
		objvistaJ.addWindowListener(this);
		objvistaJ.ventanaCrearJugador.addWindowListener(this);
		objvistaJ.dialogoMensajeJugadorCreado.addWindowListener(this);
		objvistaJ.crearJugador.addActionListener(this);
		objvistaJ.cerrarJugador.addActionListener(this);
		
		//ELEMENTOS VISTA PARTIDA
		objvistaP.addWindowListener(this);
		objvistaP.ventanaCrearPartida.addWindowListener(this);
		objvistaP.dialogoMensajePartidaCreada.addWindowListener(this);
		objvistaP.buttonIniciarPartida.addActionListener(this);
		objvistaP.cerrarPartida.addActionListener(this);

		//ELEMENTOS VISTA MENU
		objvistaM.ventanaMenu.addWindowListener(this);
		objvistaM.buttonCrearPartida.addActionListener(this);
		objvistaM.buttonMenuCrearJugador.addActionListener(this);
		objvistaM.buttoncomoSeJuega.addActionListener(this);
		objvistaM.buttonMejoresJugadores.addActionListener(this);
		objvistaM.buttonSalirMenu.addActionListener(this);
		
		//ELEMENTOS VISTA JUGANDO
		objvistaJug.ventanaJuego.addWindowListener(this);
		objvistaJug.ventanaJuego.addMouseListener(this);
			
		//ELEMENTOS VISTA GENERAL
		objvista.ventanaMejoresJugadores.addWindowListener(this);
		objvista.cerrar.addActionListener(this);
		objvista.addWindowListener(this);
		objvista.setLocationRelativeTo(null);		
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) 
	{
		//CREAR PARTIDA
		if(vistaMenu.buttonCrearPartida.equals(evento.getSource()))
		{
			this.vistaCrearP.setVisible(true);
			new VistaCrearPartida();

		}
		//INICIO DE LA PARTIDA
		if(vistaCrearP.buttonIniciarPartida.equals(evento.getSource()))
		{
			this.vistaJugando.setVisible(true);
			new VistaJugando();
		}
		
		//CREAR JUGADOR
		else if(vistaMenu.buttonMenuCrearJugador.equals(evento.getSource()))
		{
			this.vistaCrearJ.setVisible(true);
			new VistaCrearJugador();
			
		}
		
		//COMO SE JUEGA
		else if(vistaMenu.buttoncomoSeJuega.equals(evento.getSource()))
		{
			this.modelo.ayuda();
		}
		
		//CONSULTA MEJORES JUGADORES
		else if(vistaMenu.buttonMejoresJugadores.equals(evento.getSource()))
		{
			vistaMejoresJ.ventanaMejoresJugadores.setVisible(true);
			//CONECTAMOS A LA BASE DE DATOS
			conexion = this.modelo.conectar();
			//REALIZAR LA CONSULTA E INSERTAR INFORMACIÓN
			informacion = this.modelo.mejoresJugadores(conexion);
			//RELLENAMOS EL TEXTAREA
			this.vistaMejoresJ.listadoJugadores.append(informacion);
			//CERRAMOS CONEXION
			this.modelo.cerrar(conexion);
		}

		//BOTONES QUE CIERRAN VENTANAS
		if(vistaMenu.buttonSalirMenu.equals(evento.getSource()))
		{
			System.exit(0);
		}

		else if(vistaCrearJ.cerrarJugador.equals(evento.getSource()))
		{
			this.vistaCrearJ.setVisible(false);

		}

		else if(vistaCrearP.cerrarPartida.equals(evento.getSource()))
		{
			this.vistaCrearP.setVisible(false);

		}

		else if(vistaMejoresJ.cerrar.equals(evento.getSource()))
		{
			this.vistaMejoresJ.ventanaMejoresJugadores.setVisible(false);
		}

	}

	public void windowClosing(WindowEvent evento) 
	{		
		this.vistaMenu.equals(evento.getSource());
		{
			System.exit(0);
		}
		
		this.vistaJugando.ventanaJuego.equals(evento.getSource());
		{
			System.exit(0);
		}
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
