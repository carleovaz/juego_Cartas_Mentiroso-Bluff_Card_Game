package es.Studium.Mentiroso;

public class El_Mentiroso
{

	public static void main (String[]args)
	{
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		new Controlador(vista, modelo); 

	}

}
