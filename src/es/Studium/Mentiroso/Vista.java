package es.Studium.Mentiroso;

//ESTRUCTURA DE LA CLASE VISTA
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.Graphics;

public class Vista  extends Frame
{
	private static final long serialVersionUID = 1L;
	//IMAGENES
	//DECLARAMOS EL OBJETO IMAGEN
	Toolkit herramientas;
	Image tapete, reverso;
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
	int Mentiroso1 = 0;
	int Mentiroso2 = 0;

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
	Dialog dlgMensaje = new Dialog(this, "Fin", true);
	Label lblMensaje = new Label("Gana Jugador 1");

	public Vista()
	{

		//CONTENEDOR DE CREAR JUGADOR (ACTUA COMO UNA ALTA)
		ventanaCrearJugador.setLayout(new FlowLayout());
		ventanaCrearJugador.add(labelcodigojugador);
		ventanaCrearJugador.add(textocodigoJugador);
		ventanaCrearJugador.add(labelNombreJugador);
		ventanaCrearJugador.add(textoNombreJugador);
		ventanaCrearJugador.add(crearJugador);
		ventanaCrearJugador.add(cerrarJugador);
		ventanaCrearJugador.setSize(300,200);
		ventanaCrearJugador.setBackground(Color.white);
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
		ventanaCrearPartida.setBackground(Color.white);
		ventanaCrearPartida.setLocationRelativeTo(null);
		ventanaCrearPartida.setResizable(false);

		//CONTENEDOR DE MEJORES JUGADORES (ACTUA COMO UNA CONSULTA)
		ventanaMejoresJugadores.setLayout(new FlowLayout());
		ventanaMejoresJugadores.add(labelMejores);
		ventanaMejoresJugadores.add(listadoJugadores);
		listadoJugadores.append("ID\tJUGADOR\tPUNTOS\n");
		ventanaMejoresJugadores.add(cerrar);
		ventanaMejoresJugadores.setSize(300,220);
		ventanaMejoresJugadores.setBackground(Color.white);
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
		ventanaComoSeJuega.setBackground(Color.white);
		ventanaComoSeJuega.setSize(500,700);
		ventanaComoSeJuega.setLocationRelativeTo(null);
		ventanaComoSeJuega.setResizable(false);

		//CONTENEDOR DE VENTANA DE JUEGO
		ventanaJuego.setLayout(new FlowLayout());
		ventanaJuego.setTitle("Jugando");
		ventanaJuego.setSize(628,454);
		ventanaJuego.setLocationRelativeTo(null);
		ventanaJuego.setResizable(false);
		dlgMensaje.setLayout(new FlowLayout());
		dlgMensaje.setSize(100,100);
		dlgMensaje.setLocationRelativeTo(null);
		dlgMensaje.setResizable(false);
		dlgMensaje.add(lblMensaje);

	}
	public void paint(Graphics g)
	{
		g.drawImage(tapete, 0, 30, this);
		Font fuente = new Font("Arial", Font.BOLD, 18);
		g.setFont(fuente);
		g.setColor(Color.red);
		g.drawString("Jugador 1: " + Mentiroso1 + " puntos", 200, 60);
		g.drawImage(reverso, 320, 80, this);
		g.setColor(Color.yellow);
		g.drawString("Jugador 2: " + Mentiroso2 + " puntos", 200, 430);
		g.drawImage(reverso, 320, 250, this);
		switch(imagenAmostrar1)
		{
		case 1:
			g.drawImage(A1, 210, 80, this);
			break;
		case 2:
			g.drawImage(A2, 210, 80, this);
			break;
		case 3:
			g.drawImage(A3, 210, 80, this);
			break;
		case 4:
			g.drawImage(A4, 210, 80, this);
			break;
		case 5:
			g.drawImage(A5, 210, 80, this);
			break;
		case 6:
			g.drawImage(A6, 210, 80, this);
			break;
		case 7:
			g.drawImage(A7, 210, 80, this);
			break;
		case 8:
			g.drawImage(A8, 210, 80, this);
			break;
		case 9:
			g.drawImage(A9, 210, 80, this);
			break;
		case 10:
			g.drawImage(A10, 210, 80, this);
			break;
		case 11:
			g.drawImage(A11, 210, 80, this);
			break;
		case 12:
			g.drawImage(A12, 210, 80, this);
			break;
		case 14:
			g.drawImage(B1, 210, 80, this);
			break;
		case 15:
			g.drawImage(B2, 210, 80, this);
			break;
		case 16:
			g.drawImage(B3, 210, 80, this);
			break;
		case 17:
			g.drawImage(B4, 210, 80, this);
			break;
		case 18:
			g.drawImage(B5, 210, 80, this);
			break;
		case 19:
			g.drawImage(B6, 210, 80, this);
			break;
		case 20:
			g.drawImage(B7, 210, 80, this);
			break;
		case 21:
			g.drawImage(B8, 210, 80, this);
			break;
		case 22:
			g.drawImage(B9, 210, 80, this);
			break;
		case 23:
			g.drawImage(B10, 210, 80, this);
			break;
		case 24:
			g.drawImage(B11, 210, 80, this);
			break;
		case 25:
			g.drawImage(B12, 210, 80, this);
			break;
		case 27:
			g.drawImage(C1, 210, 80, this);
			break;
		case 28:
			g.drawImage(C2, 210, 80, this);
			break;
		case 29:
			g.drawImage(C3, 210, 80, this);
			break;
		case 30:
			g.drawImage(C4, 210, 80, this);
			break;
		case 31:
			g.drawImage(C5, 210, 80, this);
			break;
		case 32:
			g.drawImage(C6, 210, 80, this);
			break;
		case 33:
			g.drawImage(C7, 210, 80, this);
			break;
		case 34:
			g.drawImage(C8, 210, 80, this);
			break;
		case 35:
			g.drawImage(C9, 210, 80, this);
			break;
		case 36:
			g.drawImage(C10, 210, 80, this);
			break;
		case 37:
			g.drawImage(C11, 210, 80, this);
			break;
		case 38:
			g.drawImage(C12, 210, 80, this);
			break;
		case 40:
			g.drawImage(D1, 210, 80, this);
			break;
		case 41:
			g.drawImage(D2, 210, 80, this);
			break;
		case 42:
			g.drawImage(D3, 210, 80, this);
			break;
		case 43:
			g.drawImage(D4, 210, 80, this);
			break;
		case 44:
			g.drawImage(D5, 210, 80, this);
			break;
		case 45:
			g.drawImage(D6, 210, 80, this);
			break;
		case 46:
			g.drawImage(D7, 210, 80, this);
			break;
		case 47:
			g.drawImage(D8, 210, 80, this);
			break;
		case 48:
			g.drawImage(D9, 210, 80, this);
			break;
		case 49:
			g.drawImage(D10, 210, 80, this);
			break;
		case 50:
			g.drawImage(D11, 210, 80, this);
			break;
		case 51:
			g.drawImage(D12, 210, 80, this);
			break;	
		}
		switch(imagenAmostrar2)
		{
		case 1:
			g.drawImage(A1, 210, 250, this);
			break;
		case 2:
			g.drawImage(A2, 210, 250, this);
			break;
		case 3:
			g.drawImage(A3, 210, 250, this);
			break;
		case 4:
			g.drawImage(A4, 210, 250, this);
			break;
		case 5:
			g.drawImage(A5, 210, 250, this);
			break;
		case 6:
			g.drawImage(A6, 210, 250, this);
			break;
		case 7:
			g.drawImage(A7, 210, 250, this);
			break;
		case 8:
			g.drawImage(A8, 210, 250, this);
			break;
		case 9:
			g.drawImage(A9, 210, 250, this);
			break;
		case 10:
			g.drawImage(A10, 210, 250, this);
			break;
		case 11:
			g.drawImage(A11, 210, 250, this);
			break;
		case 12:
			g.drawImage(A12, 210, 250, this);
			break;
		case 13:
			g.drawImage(B1, 210, 250, this);
			break;
		case 14:
			g.drawImage(B2, 210, 250, this);
			break;
		case 15:
			g.drawImage(B3, 210, 250, this);
			break;
		case 16:
			g.drawImage(B4, 210, 250, this);
			break;
		case 17:
			g.drawImage(B5, 210, 250, this);
			break;
		case 18:
			g.drawImage(B6, 210, 250, this);
			break;
		case 19:
			g.drawImage(B7, 210, 250, this);
			break;
		case 20:
			g.drawImage(B8, 210, 250, this);
			break;
		case 21:
			g.drawImage(B9, 210, 250, this);
			break;
		case 22:
			g.drawImage(B10, 210, 250, this);
			break;
		case 23:
			g.drawImage(B11, 210, 250, this);
			break;
		case 24:
			g.drawImage(B12, 210, 250, this);
			break;
		case 25:
			g.drawImage(C1, 210, 250, this);
			break;
		case 26:
			g.drawImage(C2, 210, 250, this);
			break;
		case 27:
			g.drawImage(C3, 210, 250, this);
			break;
		case 28:
			g.drawImage(C4, 210, 250, this);
			break;
		case 29:
			g.drawImage(C5, 210, 250, this);
			break;
		case 30:
			g.drawImage(C6, 210, 250, this);
			break;
		case 31:
			g.drawImage(C7, 210, 250, this);
			break;
		case 32:
			g.drawImage(C8, 210, 250, this);
			break;
		case 33:
			g.drawImage(C9, 210, 250, this);
			break;
		case 34:
			g.drawImage(C10, 210, 250, this);
			break;
		case 35:
			g.drawImage(C11, 210, 250, this);
			break;
		case 36:
			g.drawImage(C12, 210, 250, this);
			break;
		case 37:
			g.drawImage(D1, 210, 250, this);
			break;
		case 38:
			g.drawImage(D2, 210, 250, this);
			break;
		case 39:
			g.drawImage(D3, 210, 250, this);
			break;
		case 40:
			g.drawImage(D4, 210, 250, this);
			break;
		case 41:
			g.drawImage(D5, 210, 250, this);
			break;
		case 42:
			g.drawImage(D6, 210, 250, this);
			break;
		case 43:
			g.drawImage(D7, 210, 250, this);
			break;
		case 44:
			g.drawImage(D8, 210, 250, this);
			break;
		case 45:
			g.drawImage(D9, 210, 250, this);
			break;
		case 46:
			g.drawImage(D10, 210, 250, this);
			break;
		case 47:
			g.drawImage(D11, 210, 250, this);
			break;
		case 48:
			g.drawImage(D12, 210, 250, this);
			break;
		}
	}

	public void cargarCartas()
	{
		A1 = herramientas.getImage("A1.png");
		A2 = herramientas.getImage("A2.png");
		A3 = herramientas.getImage("A3.png");
		A4 = herramientas.getImage("A4.png");
		A5 = herramientas.getImage("A5.png");
		A6 = herramientas.getImage("A6.png");
		A7 = herramientas.getImage("A7.png");
		A8 = herramientas.getImage("A8.png");
		A9 = herramientas.getImage("A9.png");
		A10 = herramientas.getImage("A10.png");
		A11 = herramientas.getImage("A11.png");
		A12 = herramientas.getImage("A12.png");

		B1 = herramientas.getImage("B1.png");
		B2 = herramientas.getImage("B2.png");
		B3 = herramientas.getImage("B3.png");
		B4 = herramientas.getImage("B4.png");
		B5 = herramientas.getImage("B5.png");
		B6 = herramientas.getImage("B6.png");
		B7 = herramientas.getImage("B7.png");
		B8 = herramientas.getImage("B8.png");
		B9 = herramientas.getImage("B9.png");
		B10 = herramientas.getImage("B10.png");
		B11 = herramientas.getImage("B11.png");
		B12 = herramientas.getImage("B12.png");

		C1 = herramientas.getImage("C1.png");
		C2 = herramientas.getImage("C2.png");
		C3 = herramientas.getImage("C3.png");
		C4 = herramientas.getImage("C4.png");
		C5 = herramientas.getImage("C5.png");
		C6 = herramientas.getImage("C6.png");
		C7 = herramientas.getImage("C7.png");
		C8 = herramientas.getImage("C8.png");
		C9 = herramientas.getImage("C9.png");
		C10 = herramientas.getImage("C10.png");
		C11 = herramientas.getImage("C11.png");
		C12 = herramientas.getImage("C12.png");

		D1 = herramientas.getImage("D1.png");
		D2 = herramientas.getImage("D2.png");
		D3 = herramientas.getImage("D3.png");
		D4 = herramientas.getImage("D4.png");
		D5 = herramientas.getImage("D5.png");
		D6 = herramientas.getImage("D6.png");
		D7 = herramientas.getImage("D7.png");
		D8 = herramientas.getImage("D8.png");
		D9 = herramientas.getImage("D9.png");
		D10 = herramientas.getImage("D10.png");
		D11 = herramientas.getImage("D11.png");
		D12 = herramientas.getImage("D12.png");

	}

	public void mostrarCartaMazo1(int carta)
	{
		imagenAmostrar1 = carta;
		repaint();
	}
	public void mostrarCartaMazo2(int carta)
	{
		imagenAmostrar2 = carta;
		repaint();
	}
	public void aumentarPuntosJugador1()
	{
		Mentiroso1++;
		repaint();
	}
	public void aumentarPuntosJugador2()
	{
		Mentiroso2++;
		repaint();
	}
	public void resetearContadores()
	{
		Mentiroso1 = 0;
		Mentiroso2 = 0;
		repaint();
	}

}
