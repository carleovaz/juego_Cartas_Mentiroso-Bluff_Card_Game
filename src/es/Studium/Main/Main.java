package es.Studium.Main; 

import es.Studium.Controlador.Controlador;
import es.Studium.Modelo.Modelo;
import es.Studium.Musica.Sonido;
import es.Studium.Vistas.VistaCrearJugador;
import es.Studium.Vistas.VistaCrearPartida;
import es.Studium.Vistas.VistaJugando;
import es.Studium.Vistas.VistaMejoresJ;
import es.Studium.Vistas.VistaMenuPrincipal;

public class Main
{

	public static void main (String[]args)
	{
		Modelo modelo = new Modelo();
		VistaMejoresJ vistaMejoresJ = new VistaMejoresJ();
		VistaMenuPrincipal vistaMenu = new VistaMenuPrincipal();
		VistaCrearJugador vistaCrearJ = new VistaCrearJugador();
		VistaCrearPartida vistaCrearP = new VistaCrearPartida();
		VistaJugando vistaJugando = new VistaJugando();
		new Controlador (vistaMejoresJ, vistaMenu,vistaCrearJ,vistaCrearP, vistaJugando, modelo); 
		Sonido sonido = new Sonido();
	}
	


}
