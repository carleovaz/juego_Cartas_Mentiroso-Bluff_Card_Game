package es.Studium.Vistas;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

public class VistaMenuPrincipal extends Frame 
{
	private static final long serialVersionUID = 1L;
	
	//VENTANA MENU
	public Frame ventanaMenu = new Frame ("¡El Mentiroso!");
	public Label labelMenu = new Label("¡BIENVENIDO AL MENTIROSO!");
	public Button buttonCrearPartida = new Button ("Nueva Partida");
	public Button buttonMenuCrearJugador = new Button ("Crear Jugador");
	public Button buttonMejoresJugadores = new Button ("Mejores jugadores");//SIMILAR A CONSULTA DE PROGRAMA DE GESTIÓN
	public Button buttoncomoSeJuega = new Button ("¿Como se juega?");
	public Button buttonSalirMenu = new Button ("Salir");

	//HERRAMIENTA PARA IMAGENES
	Toolkit herramienta;
	Image fondoMenu;
	
	public VistaMenuPrincipal() 
	{
		setTitle("¡El Mentiroso");
		setLayout(new FlowLayout());
		add(labelMenu);
		add(buttonCrearPartida);
		add(buttonMenuCrearJugador);
		add(buttonMejoresJugadores);
		add(buttoncomoSeJuega);
		add(buttonSalirMenu);
		herramienta = getToolkit(); 
		fondoMenu = herramienta.getImage("fondoMenu.jpg"); 
		setVisible(true);
		setSize(295,365); 
		setLocationRelativeTo(null);
	}
	
	public void paint(Graphics g) 
	{ 
		g.drawImage(fondoMenu,30,140,this); 
	}

}
