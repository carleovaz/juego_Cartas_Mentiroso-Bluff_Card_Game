package es.Studium.Mentiroso;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

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
	Frame ventanaCrear = new Frame ("¡El Mentiroso!: Crear Partida");
	Label labelNombrePartida = new Label ("Nombre de la Partida");
	TextField textoNombre = new TextField (25);
	Button crearPartida = new Button ("Crear"); //AL CREAR PARTIDA, INICIAMOS EL JUEGO Y SE GUARDA EL NOMBRE
	Button cancelar = new Button ("Cancelar"); //CIERRA LA PANTALLA DE CREAR
	Button comoseJuega = new Button ("¿Como se juega?"); //ABRE LA VENTANA DE COMO SE JUEGA
	
	//VENTANA MEJORES JUGADORES
	Frame ventanaMejoresJugadores = new Frame("Consulta");
	Label labelMejores = new Label ("¡Mejores Mentirosos!");
	TextArea listadoJugadores = new TextArea(5, 30);
	Button cerrar = new Button("cerrar"); //CIERRA LA VENTANA DE MEJORES JUGADORES
	
	//VENTANA COMO SE JUEGA
	Frame ventanaComoSeJuega = new Frame("Consulta");
	Label labelAyuda1 = new Label ("info de ayuda 1");//TITULO DE LA AYUDA 1
	TextArea ayuda1 = new TextArea(10, 60);//PONER IMAGEN AL LADO 
	Label labelAyuda2 = new Label ("info de ayuda 2");//TITULO DE LA AYUDA 2
	TextArea ayuda2 = new TextArea(10, 60);//PONER IMAGEN AL LADO
	Label labelAyuda3 = new Label ("info de ayuda 3");//TITULO DE LA AYUDA 3
	TextArea ayuda3 = new TextArea(10, 60);//PONER IMAGEN AL LADO
	

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
		
		ventanaCrear.setLayout(new FlowLayout());
		ventanaCrear.add(labelNombrePartida);
		ventanaCrear.add(textoNombre);
		ventanaCrear.add(crearPartida);
		ventanaCrear.add(cancelar);
		ventanaCrear.add(comoseJuega);
		ventanaCrear.setSize(300,200);
		ventanaCrear.setLocationRelativeTo(null);
		ventanaCrear.setResizable(false);
		
		ventanaMejoresJugadores.setLayout(new FlowLayout());
		ventanaMejoresJugadores.add(labelMejores);
		ventanaMejoresJugadores.add(listadoJugadores);
		ventanaMejoresJugadores.add(cerrar);
		ventanaMejoresJugadores.setSize(300,220);
		ventanaMejoresJugadores.setLocationRelativeTo(null);
		ventanaMejoresJugadores.setResizable(false);
		
		ventanaComoSeJuega.setLayout(new FlowLayout());
		ventanaComoSeJuega.add(ayuda1);
		ventanaComoSeJuega.add(labelAyuda1);
		ventanaComoSeJuega.add(ayuda2);
		ventanaComoSeJuega.add(labelAyuda2);
		ventanaComoSeJuega.add(ayuda3);
		ventanaComoSeJuega.add(labelAyuda3);
		ventanaComoSeJuega.setSize(950,600);
		ventanaComoSeJuega.setLocationRelativeTo(null);
		ventanaComoSeJuega.setResizable(false);
			
	}
	
}
