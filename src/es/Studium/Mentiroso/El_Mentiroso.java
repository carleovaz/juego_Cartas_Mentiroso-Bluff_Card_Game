package es.Studium.Mentiroso;

import es.Studium.Vistas.VistaMenu;

public class El_Mentiroso
{

	public static void main (String[]args)
	{
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		VistaMenu vistaMenu = new VistaMenu();
		new Controlador (vista, vistaMenu, modelo); 
		Sonido sonido = new Sonido();

	}

}
