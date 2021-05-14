package es.Studium.Mentiroso;

import Musica.Sonido;
import es.Studium.Vistas.VistaMenuPrincipal;

public class El_Mentiroso
{

	public static void main (String[]args)
	{
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		VistaMenuPrincipal vistaMenu = new VistaMenuPrincipal();
		new Controlador (vista, vistaMenu, modelo); 
		Sonido sonido = new Sonido();

	}

}
