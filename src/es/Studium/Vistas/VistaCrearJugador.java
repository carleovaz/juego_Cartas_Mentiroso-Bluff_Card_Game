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

public class VistaCrearJugador extends Frame 
{
	private static final long serialVersionUID = 1L;
	
	//VENTANA MENU
	public Frame ventanaCrearJugador = new Frame ("¡El Mentiroso!: Crear Jugador");
	public Label labelcodigojugador = new Label ("Codigo jugador");
	public TextField textocodigoJugador = new TextField (30);
	public Label labelNombreJugador = new Label ("Nombre del Mentiroso");
	public TextField textoNombreJugador = new TextField (30);
	public Dialog dialogoMensajeJugadorCreado = new Dialog(ventanaCrearJugador, "Perfil creado", true);
	public Label perfilCreado = new Label ("Tu perfil ha sido creado");
	public Button crearJugador = new Button ("Crear"); 
	public Button cerrarJugador = new Button ("Cerrar");

	//HERRAMIENTA PARA IMAGENES
	Toolkit herramienta;
	Image fondoMenu;
	
	public VistaCrearJugador() 
	{
		setTitle("¡El Mentiroso!: Crear Jugador");
		setLayout(new FlowLayout());
		add(labelcodigojugador);
		add(textocodigoJugador);
		add(labelNombreJugador);
		add(textoNombreJugador);
		add(crearJugador);
		add(cerrarJugador);
		herramienta = getToolkit(); 
		fondoMenu = herramienta.getImage("fondoVentanas.jpg");
		setVisible(true);
		setSize(300,365); 
		setLocationRelativeTo(null);
	}
	
	public void paint(Graphics g) 
	{ 
		g.drawImage(fondoMenu,8,175,this); 
	}
	

}
