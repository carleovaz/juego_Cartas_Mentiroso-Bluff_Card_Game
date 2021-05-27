package es.Studium.Mentiroso; 

import Musica.Sonido;
import es.Studium.Vistas.VistaCrearJugador;
import es.Studium.Vistas.VistaCrearPartida;
import es.Studium.Vistas.VistaJugando;
import es.Studium.Vistas.VistaMejoresJ;
import es.Studium.Vistas.VistaMenuPrincipal;

public class El_Mentiroso
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
