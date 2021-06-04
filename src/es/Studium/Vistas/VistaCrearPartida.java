package es.Studium.Vistas;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;

public class VistaCrearPartida extends Frame 
{
	private static final long serialVersionUID = 1L;
	public Frame ventanaCrearPartida = new Frame ("¡El Mentiroso!: Crear Partida");
	public Label labelNombreJugador1 = new Label ("Nombre Jugador 1:");
	public TextField textoNombreJugador1 = new TextField (30);
	public Label labelNombreJugador2 = new Label ("Nombre Jugador 2:");
	public TextField textoNombreJugador2 = new TextField (30);
	public Label labelNombreJugador3 = new Label ("Nombre Jugador 3:");
	public TextField textoNombreJugador3 = new TextField (30);
	public Label labelNombreJugador4 = new Label ("Nombre Jugador 4:");
	public TextField textoNombreJugador4 = new TextField (30);
	public Label labelCodigoCreadordePartida = new Label ("Introduce tu codigo:");
	public TextField textoCodigoJugadorPartida = new TextField (30);
	public Dialog dialogoMensajePartidaCreada = new Dialog(ventanaCrearPartida, "Partida creada", true);
	public Label partidaCreada = new Label ("ERROR: Faltan datos");
	public Button buttonIniciarPartida = new Button ("Iniciar"); 
	public Button cerrarPartida = new Button ("Cerrar");
	Toolkit herramienta;
	Image fondoCrearPartida;

	public VistaCrearPartida() 
	{
		setTitle("¡El Mentiroso!: Crear Jugador");
		setLayout(new FlowLayout());
		add(labelNombreJugador1);
		add(textoNombreJugador1);
		add(labelNombreJugador2);
		add(textoNombreJugador2);
		add(labelNombreJugador3);
		add(textoNombreJugador3);
		add(labelNombreJugador4);
		add(textoNombreJugador4);
		add(buttonIniciarPartida);
		add(cerrarPartida);
		herramienta = getToolkit(); 
		fondoCrearPartida = herramienta.getImage("fondoCrearPartida.jpg");
		setVisible(false);
		setSize(300,455); 
		setLocationRelativeTo(null);
		setResizable(false);
		
		dialogoMensajePartidaCreada.setLayout(new FlowLayout());
		dialogoMensajePartidaCreada.setSize(200,100);
		dialogoMensajePartidaCreada.setLocationRelativeTo(null);
		dialogoMensajePartidaCreada.setResizable(false);
		dialogoMensajePartidaCreada.add(partidaCreada);
	}
	//DIBUJAMOS
	public void paint(Graphics g) 
	{ 
		g.drawImage(fondoCrearPartida,0,295,this); 
	}

}



