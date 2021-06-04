package es.Studium.Vistas;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

public class VistaJugando extends Frame
{
	private static final long serialVersionUID = 1L;
	Toolkit herramientas;
	Image tapete, reverso;
	int cartaReverso = 0;
	int cargarCartas=0;
	int imagenAmostrar2 = 0;
	int imagenAmostrar3 = 0;
	int imagenAmostrar4 = 0;
	int imagenAmostrar5 = 0;
	int turno = 0;

	public Frame ventanaJuego = new Frame ("¡EL MENTIROSO!: JUGANDO");
	public Dialog dialogoTurno = new Dialog(this, "TURNO", true);
	public Dialog dialogoAcusacion1 = new Dialog(this,"ACUSACIÓN");
	public Dialog dialogoAcusacion2 = new Dialog(this,"ACUSACIÓN");
	public Dialog dialogoVictoria = new Dialog(this,"GANADOR");
	public Dialog dialogoComienzo = new Dialog(this,"INICIO");
	public Label lblTurno = new Label();
	public Label lblComienzo = new Label();
	public Label lblVictoria = new Label();
	public Label lblNoMintio = new Label();
	public Label lblMentido = new Label();

	//CONSTRUCTOR
	public VistaJugando()
	{
		herramientas = getToolkit();
		tapete = herramientas.getImage("tapete2.png");
		reverso = herramientas.getImage("reverso.png");

		this.setTitle("¡EL MENTIROSO! - JUGANDO");
		this.setSize(820,490);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(false);

		dialogoComienzo.setLayout(new FlowLayout());
		dialogoComienzo.setSize(200,100);
		dialogoComienzo.setLocationRelativeTo(null);
		dialogoComienzo.setResizable(false);
		dialogoComienzo.add(lblComienzo);

		dialogoComienzo.setLayout(new FlowLayout());
		dialogoComienzo.setSize(300,100);
		dialogoComienzo.setLocationRelativeTo(null);
		dialogoComienzo.setResizable(false);
		dialogoComienzo.add(lblTurno);

		dialogoVictoria.setLayout(new FlowLayout());
		dialogoVictoria.setSize(200,100);
		dialogoVictoria.setLocationRelativeTo(null);
		dialogoVictoria.setResizable(false);
		dialogoVictoria.add(lblVictoria);

		dialogoAcusacion1.setLayout(new FlowLayout());
		dialogoAcusacion1.setSize(200,100);
		dialogoAcusacion1.setLocationRelativeTo(null);
		dialogoAcusacion1.setResizable(false);
		dialogoAcusacion1.add(lblNoMintio);

		dialogoAcusacion2.setLayout(new FlowLayout());
		dialogoAcusacion2.setSize(200,100);
		dialogoAcusacion2.setLocationRelativeTo(null);
		dialogoAcusacion2.setResizable(false);
		dialogoAcusacion2.add(lblMentido);		
	}
	
	//DIBUJAMOS
	public void paint(Graphics g)
	{
		g.drawImage(tapete, 0, 30, this);
		Font fuente = new Font("Arial", Font.BOLD, 18);
		g.setFont(fuente);
		g.setColor(Color.black);
		g.drawString("Jugador 1", 350, 55);
		g.drawImage(reverso, 340, 65, this);
		g.drawString("Jugador 2", 350, 470);
		g.drawImage(reverso, 340, 295, this);
		g.drawString("Jugador 3", 30, 175);
		g.drawImage(reverso, 20, 180, this);
		g.drawString("Jugador 4", 610, 175);
		g.drawImage(reverso, 600, 180, this); 
		g.setColor(Color.black);
		g.drawRect(85, 35, 175, 35);
		g.drawString("Turno del jugador " + turno, 90, 55);

		//POSICION DE LAS CARTAS
		switch(cartaReverso)
		{
		case 1:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 2:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 3:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 4:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 5:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 6:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 7:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 8:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 9:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 10:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 11:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 12:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 13:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 14:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 15:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 16:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 17:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 18:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 19:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 20:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 21:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 22:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 23:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 24:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 25:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 26:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 27:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 28:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 29:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 30:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 31:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 32:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 33:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 34:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 35:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 36:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 37:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 38:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 39:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 40:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 41:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 42:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 43:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 44:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 45:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 46:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 47:
			g.drawImage(reverso, 340, 165, this);
			break;
		case 48:
			g.drawImage(reverso, 340, 165, this);
			break;
		}
	}
	
	//DIBUJAMOS 
	public void reversoCarta()
	{
		cartaReverso++;
		repaint();
	}
	
	//DIBUJAMOS TURNOS
	public void avisoTurno(int t)
	{
		this.turno=t;
		repaint();
	}

}
