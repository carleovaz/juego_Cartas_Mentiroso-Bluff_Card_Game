package es.Studium.Vistas;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;



public class VistaMejoresJ  extends Frame
{
	private static final long serialVersionUID = 1L;

	//VENTANA MEJORES JUGADORES
	public Frame ventanaMejoresJugadores = new Frame("Mejores Mentirosos");
	public Label labelMejores = new Label ("El Mentiroso: ¡Mejores Mentirosos!");
	public TextArea listadoJugadores = new TextArea(15, 40);
	public Button cerrar = new Button("cerrar");

	//CONSTRUCTOR
	public VistaMejoresJ()
	{
		ventanaMejoresJugadores.setLayout(new FlowLayout());
		ventanaMejoresJugadores.add(labelMejores);
		ventanaMejoresJugadores.add(listadoJugadores);
		listadoJugadores.append("ID\tJUGADOR\tPUNTOS\n");
		ventanaMejoresJugadores.add(cerrar);
		ventanaMejoresJugadores.setSize(600,420);
		ventanaMejoresJugadores.setBackground(Color.white);
		ventanaMejoresJugadores.setLocationRelativeTo(null);
		ventanaMejoresJugadores.setResizable(false);
	}
	
}
