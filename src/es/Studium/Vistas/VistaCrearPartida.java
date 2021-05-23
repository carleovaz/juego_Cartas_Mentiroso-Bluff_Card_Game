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
	public Label labelNombrePartida = new Label ("Nombre de la Partida");
	public TextField textoNombrePartida = new TextField (30);
	public Label labelCodigoCreadordePartida = new Label ("Introduce tu codigo:");
	public TextField textoCodigoJugadorPartida = new TextField (30);
	public Dialog dialogoMensajePartidaCreada = new Dialog(ventanaCrearPartida, "Partida creada", true);
	public Label partidaCreada = new Label ("Tu partida no pudo ser creada.");
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
		add(labelNombrePartida);
		add(textoNombrePartida);
		add(labelCodigoCreadordePartida);
		add(textoCodigoJugadorPartida);
		add(buttonIniciarPartida);
		add(cerrarPartida);
		herramienta = getToolkit(); 
		fondoMenu = herramienta.getImage("fondoCrearPartida.jpg");
		setVisible(false);
		setSize(300,365); 
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public void paint(Graphics g) 
	{ 
		g.drawImage(fondoMenu,0,185,this); 
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



