package es.Studium.Mentiroso;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;

public class Vista  extends Frame
{
	private static final long serialVersionUID = 1L;
	
	//VENTANA INICIAL DEL JUEGO
	Frame ventanaPrincipal = new Frame ("¡El Mentiroso!");
	Label labelBienvenido = new Label ("Bienvenido al Mentiroso");
	Button buttonCrear = new Button ("Crear Partida");//PASA A VENTANA DE CREAR PARTIDA
	Button buttonMejores = new Button ("Mejores jugadores");//SIMILAR A CONSULTA DE PROGRAMA DE GESTIÓN
	Button buttonSalir = new Button ("Salir");//CIERRA EL PROGRAMA
	
	//VENTANA CREAR PARTIDA
	Frame ventanCrear = new Frame ("¡El Mentiroso!: Crear Partida");
	Label labelNombrePartida = new Label ("Nombre de la Partida");
	Button crearPartida = new Button ("Crear"); //AL CREAR PARTIDA, INICIAMOS EL JUEGO Y SE GUARDA EL NOMBRE
	Button cancelar = new Button ("Cancelar"); //CIERRA LA PANTALLA DE CREAR
	Button comoseJuega = new Button ("¿Como se juega?"); //ABRE LA VENTANA DE COMO SE JUEGA
	
	//VENTANA MEJORES JUGADORES
	Frame ventanaMejoresJugadores = new Frame("Consulta");
	Label labelMejores = new Label ("¡Mejores Mentirosos!");
	TextArea listadoJugadores = new TextArea(5, 30);
	Button volver = new Button("Volver"); //CIERRA LA VENTANA DE MEJORES JUGADORES
	
	//VENTANA COMO SE JUEGA
	Frame ventanaComoSeJuega = new Frame("Consulta");
	TextArea ayuda1 = new TextArea(5, 30);//PONER IMAGEN AL LADO
	TextArea ayuda2 = new TextArea(5, 30);//PONER IMAGEN AL LADO
	TextArea ayuda3 = new TextArea(5, 30);//PONER IMAGEN AL LADO
	

	public Vista()
	{
		ventanaPrincipal.setLayout(new FlowLayout());
		ventanaPrincipal.add(labelBienvenido);
		ventanaPrincipal.add(buttonCrear);
		ventanaPrincipal.add(buttonMejores);
		ventanaPrincipal.add(buttonSalir);
		ventanaPrincipal.setSize(180,210);
		ventanaPrincipal.setVisible(true);
		ventanaPrincipal.setResizable(false);
		ventanaPrincipal.setLocationRelativeTo(null);
		
	}
	
//	public static void main (String[]args)
//	{
//		new Vista();
//	}
}
