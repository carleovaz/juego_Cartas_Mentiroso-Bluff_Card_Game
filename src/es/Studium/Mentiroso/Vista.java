package es.Studium.Mentiroso;

//ESTRUCTURA DE LA CLASE VISTA
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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
	Label labelBienvenido = new Label ("¡BIENVENIDO AL MENTIROSO!");
	Button buttonCrearJugador = new Button ("Crear Mentiroso");
	Button buttonCrearPartida = new Button ("Crear Partida");
	Button buttonMejores = new Button ("Mejores jugadores");//SIMILAR A CONSULTA DE PROGRAMA DE GESTIÓN
	Button buttonComoSeJuega = new Button ("¿Como se juega?");
	Button buttonSalir = new Button ("Salir");

	//VENTANA CREAR MENTIROSO
	Frame ventanaCrearJugador = new Frame ("¡El Mentiroso!: Crear Jugador");
	Label labelcodigojugador = new Label ("Codigo jugador");
	TextField textocodigoJugador = new TextField (30);
	Label labelNombreJugador = new Label ("Nombre del Mentiroso");
	TextField textoNombreJugador = new TextField (30);
	Dialog dialogoMensajeJugadorCreado = new Dialog(ventanaCrearJugador, "Perfil creado", true);
	Label perfilCreado = new Label ("Tu perfil ha sido creado");
	Button crearJugador = new Button ("Crear"); 
	Button cerrarJugador = new Button ("Cerrar");

	//VENTANA CREAR PARTIDA
	Frame ventanaCrearPartida = new Frame ("¡El Mentiroso!: Crear Partida");
	Label labelNombrePartida = new Label ("Nombre de la Partida");
	TextField textoNombrePartida = new TextField (30);
	Label labelCreadordePartida = new Label ("Introduce tu codigo:");
	TextField textoCodigoJugadorPartida = new TextField (30);
	Dialog dialogoMensajePartidaCreada = new Dialog(ventanaCrearPartida, "Partida creada", true);
	Label partidaCreada = new Label ("Tu partida no pudo ser creada.");
	Button buttonIniciarPartida = new Button ("Iniciar"); 
	Button cerrarPartida = new Button ("Cerrar"); 

	//VENTANA MEJORES JUGADORES
	Frame ventanaMejoresJugadores = new Frame("Mejores Mentirosos");
	Label labelMejores = new Label ("El Mentiroso: ¡Mejores Mentirosos!");
	TextArea listadoJugadores = new TextArea(5, 30);
	Button cerrar = new Button("cerrar");

	//VENTANA COMO SE JUEGA
	Frame ventanaComoSeJuega = new Frame("¿Como se juega?");
	Label labelAyuda1 = new Label ("info de ayuda 1");
	Label imagenayuda = new Label("iconoAyuda.png");
	TextArea ayuda1 = new TextArea(10, 60);
	Label labelAyuda2 = new Label ("info de ayuda 2");
	TextArea ayuda2 = new TextArea(10, 60);
	Label labelAyuda3 = new Label ("info de ayuda 3");
	TextArea ayuda3 = new TextArea(10, 60);
	Button cerrarAyuda = new Button("Cerrar");

	//PANTALLA DEL JUEGO
	Frame ventanaJuego = new Frame ("Jugando");


	public Vista()
	{
		//CONTENEDOR DE VENTANA PRINCIPAL
		ventanaPrincipal.setLayout(new FlowLayout());
		ventanaPrincipal.add(labelBienvenido);
		ventanaPrincipal.add(buttonCrearJugador);
		ventanaPrincipal.add(buttonCrearPartida);
		ventanaPrincipal.add(buttonMejores);
		ventanaPrincipal.add(buttonComoSeJuega);
		ventanaPrincipal.add(buttonSalir);
		ventanaPrincipal.setSize(290,210);
		ventanaPrincipal.setBackground(Color.yellow);
		ventanaPrincipal.setVisible(true);
		ventanaPrincipal.setResizable(true);
		ventanaPrincipal.setLocationRelativeTo(null);

		//CONTENEDOR DE CREAR JUGADOR (ACTUA COMO UNA ALTA)
		ventanaCrearJugador.setLayout(new FlowLayout());
		ventanaCrearJugador.add(labelcodigojugador);
		ventanaCrearJugador.add(textocodigoJugador);
		ventanaCrearJugador.add(labelNombreJugador);
		ventanaCrearJugador.add(textoNombreJugador);
		ventanaCrearJugador.add(crearJugador);
		ventanaCrearJugador.add(cerrarJugador);
		ventanaCrearJugador.setSize(300,200);
		ventanaCrearJugador.setBackground(Color.yellow);
		ventanaCrearJugador.setLocationRelativeTo(null);
		ventanaCrearJugador.setResizable(false);


		//CONTENEDOR DE CREAR PARTIDA (ACTUA COMO UNA ALTA)
		ventanaCrearPartida.setLayout(new FlowLayout());
		ventanaCrearPartida.add(labelNombrePartida);
		ventanaCrearPartida.add(textoNombrePartida);
		ventanaCrearPartida.add(labelCreadordePartida);
		ventanaCrearPartida.add(textoCodigoJugadorPartida);
		ventanaCrearPartida.add(buttonIniciarPartida);
		ventanaCrearPartida.add(cerrarPartida);
		ventanaCrearPartida.setSize(300,200);
		ventanaCrearPartida.setBackground(Color.yellow);
		ventanaCrearPartida.setLocationRelativeTo(null);
		ventanaCrearPartida.setResizable(false);

		//CONTENEDOR DE MEJORES JUGADORES (ACTUA COMO UNA CONSULTA)
		ventanaMejoresJugadores.setLayout(new FlowLayout());
		ventanaMejoresJugadores.add(labelMejores);
		ventanaMejoresJugadores.add(listadoJugadores);
		ventanaMejoresJugadores.add(cerrar);
		ventanaMejoresJugadores.setSize(300,220);
		ventanaMejoresJugadores.setBackground(Color.yellow);
		ventanaMejoresJugadores.setLocationRelativeTo(null);
		ventanaMejoresJugadores.setResizable(false);

		
		//CONTENEDOR DE COMO SE JUEGA
		ventanaComoSeJuega.setLayout(new FlowLayout());
		ventanaComoSeJuega.add(ayuda1);
		String cadenaAyuda1 = new String("Bienvenido al Mentiroso, Jugador." 
				+"\n"
				+"\nSi has accedido aqui, eso significa que quieres ver el tutorial del Juego."
				+ "\npor lo que dejame decirte que accediste al lugar adecuado.\nEl Mentiroso es un juego de baraja española de 40 cartas."
				+ "\nEn la versión que aquí se ofrece, se jugaran con 48 cartas,"
				+ "es decir la baraja completa española. ");
		ayuda1.setText(cadenaAyuda1);
		ventanaComoSeJuega.add(labelAyuda1);
		ventanaComoSeJuega.add(ayuda2);
		String cadenaAyuda2 = new String("Para jugar al juego, se reparte toda la baraja por igual a todos los jugadores,\nocultando cada uno las cartas a sus adversarios.\nEstos deben intentar "
				+ "deshacerse cuanto antes de todas las cartas que tienen en su poder.\nEl jugador que inicia la partida deposita boca abajo una, dos o tres cartas"
				+ "\ny dice en voz alta una combinación de cartas (todas del mismo número), y que será la jugada que afirma haber lanzado.");
		ayuda2.setText(cadenaAyuda2);
		ventanaComoSeJuega.add(labelAyuda2);
		String cadenaAyuda3 = new String("Si el siguiente jugador (el que esté situado inmediatamente a su derecha), le cree, "
				+ "\ndeberá continuar depositando una o varias cartas en la mesa, "
				+ "\ncoincidiendo en el número de la baraja, pero no necesariamente en el número de cartas depositadas, "
				+ "\ndiciendo explícitamente cuántas son las cartas que deposita "
				+ "\n(por ejemplo, «otro caballo más», u «otros dos»). "
				+ "\nEl juego terminara una vez que uno de los dos jugadores se quede sin cartas.");
		ayuda3.setText(cadenaAyuda3);
		ventanaComoSeJuega.add(ayuda3);
		ventanaComoSeJuega.add(labelAyuda3);
		ventanaComoSeJuega.add(cerrarAyuda);
		ventanaComoSeJuega.setBackground(Color.yellow);
		ventanaComoSeJuega.setSize(500,700);
		ventanaComoSeJuega.setLocationRelativeTo(null);
		ventanaComoSeJuega.setResizable(false);

		//CONTENEDOR DE VENTANA DE JUEGO
		ventanaJuego.setLayout(new FlowLayout());
		ventanaJuego.setSize(900,600);
		ventanaJuego.setLocationRelativeTo(null);
		ventanaJuego.setResizable(false);
		
		
	}

}
