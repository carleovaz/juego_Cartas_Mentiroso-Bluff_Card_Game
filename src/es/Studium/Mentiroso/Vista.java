package es.Studium.Mentiroso;

//ESTRUCTURA DE LA CLASE VISTA
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;

public class Vista  extends Frame
{
	private static final long serialVersionUID = 1L;
	//IMAGENES
	//DECLARAMOS EL OBJETO IMAGEN
	Toolkit herramientas;
	Image tapete, reverso;
	Image imagendeAyuda;
	// A --> ORO
	// B --> ESPADA
	// C --> COPA
	// D --> BASTO
	Image A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12;
	Image B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12;
	Image C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12;
	Image D1, D2, D3, D4, D5, D6, D7, D8, D9, D10, D11, D12;
	int imagenAmostrar1 = 0;
	int imagenAmostrar2 = 0;
	int puntosJugador1 = 0;
	int puntosJugador2 = 0;

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
	Frame ventanaComoSeJuega = new Frame("¿Como se juega?");
	Label labelAyuda1 = new Label ("info de ayuda 1");//TITULO DE LA AYUDA 1
	Label imagenayuda = new Label("iconoAyuda.png");
	TextArea ayuda1 = new TextArea(10, 60);//PONER IMAGEN AL LADO 
	Label labelAyuda2 = new Label ("info de ayuda 2");//TITULO DE LA AYUDA 2
	TextArea ayuda2 = new TextArea(10, 60);//PONER IMAGEN AL LADO
	Label labelAyuda3 = new Label ("info de ayuda 3");//TITULO DE LA AYUDA 3
	TextArea ayuda3 = new TextArea(10, 60);//PONER IMAGEN AL LADO
	Button cerrarAyuda = new Button("Cerrar");

	//DECLARAMOS EL OBJETO TOOLKIT PARA MANIPULAR LAS IMAGENES



	public Vista()
	{
		ventanaPrincipal.setLayout(new FlowLayout());
		ventanaPrincipal.add(labelBienvenido);
		ventanaPrincipal.add(buttonCrear);
		ventanaPrincipal.add(buttonMejores);
		ventanaPrincipal.add(buttonSalir);
		ventanaPrincipal.setSize(180,210);
		ventanaPrincipal.setBackground(Color.yellow);
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
		ventanaCrear.setBackground(Color.yellow);
		ventanaCrear.setLocationRelativeTo(null);
		ventanaCrear.setResizable(false);

		ventanaMejoresJugadores.setLayout(new FlowLayout());
		ventanaMejoresJugadores.add(labelMejores);
		ventanaMejoresJugadores.add(listadoJugadores);
		ventanaMejoresJugadores.add(cerrar);
		ventanaMejoresJugadores.setSize(300,220);
		ventanaMejoresJugadores.setBackground(Color.yellow);
		ventanaMejoresJugadores.setLocationRelativeTo(null);
		ventanaMejoresJugadores.setResizable(false);

		ventanaComoSeJuega.setLayout(new FlowLayout());
		ventanaComoSeJuega.add(ayuda1);
		ventanaComoSeJuega.add(labelAyuda1);
		ventanaComoSeJuega.getToolkit();
		ventanaComoSeJuega.add(ayuda2);
		ventanaComoSeJuega.add(labelAyuda2);
		ventanaComoSeJuega.add(ayuda3);
		ventanaComoSeJuega.add(labelAyuda3);
		ventanaComoSeJuega.add(cerrarAyuda);
		ventanaComoSeJuega.setBackground(Color.lightGray);
		ventanaComoSeJuega.setSize(950,600);
		ventanaComoSeJuega.setLocationRelativeTo(null);
		ventanaComoSeJuega.setResizable(false);



	}
	public void paint(Graphics g) 
	{ 

	} 

}
