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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class VistaCrearPartida extends Frame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;

	//VENTANA MENU
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

	//HERRAMIENTA PARA IMAGENES
	Toolkit herramienta;
	Image fondoMenu;

	public VistaCrearPartida() 
	{
		addWindowListener(this);
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
		fondoMenu = herramienta.getImage("fondoCrearPartida.jpg");
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

	public void paint(Graphics g) 
	{ 
		g.drawImage(fondoMenu,0,295,this); 
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) 
	{
		
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}



