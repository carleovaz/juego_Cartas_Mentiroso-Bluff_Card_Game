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

import Musica.Sonido2;

public class VistaJugando extends Frame
{
	private static final long serialVersionUID = 1L;
	Toolkit herramientas;
	Image tapete, reverso;
	// A --> Diamantes
	// B --> Corazones
	// C --> Tréboles
	// D --> Picas
	Image A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13;
	Image B1, B2, B3, B4, B5, B6, B7, B8, B9, B10, B11, B12, B13;
	Image C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13;
	Image D1, D2, D3, D4, D5, D6, D7, D8, D9, D10, D11, D12, D13;
	int imagenAmostrar1 = 0;
	int imagenAmostrar2 = 0;
	int imagenAmostrar3 = 0;
	int imagenAmostrar4 = 0;
	int imagenAmostrar5 = 0;
	int puntosJugador1 = 0;
	int puntosJugador2 = 0;
	int puntosJugador3 = 0;
	int puntosJugador4 = 0;

	public Frame ventanaJuego = new Frame ("Jugando");
	public Dialog dlgMensaje = new Dialog(this, "Fin", true);
	public Dialog dialogoHaMentido1 = new Dialog(this,"El Jugador 4  ha mentido");
	public Dialog dialogoNoHaMentido1 = new Dialog (this,"El Jugador 4 no ha mentido");
	public Dialog dialogoHaMentido2 = new Dialog(this,"El Jugador 1 ha mentido");
	public Dialog dialogoNoHaMentido2 = new Dialog (this,"El Jugador 1 no ha mentido");
	public Dialog dialogoHaMentido3 = new Dialog(this,"El Jugador 2 ha mentido");
	public Dialog dialogoNoHaMentido3 = new Dialog (this,"El Jugador 2 no ha mentido");
	public Dialog dialogoHaMentido4 = new Dialog(this,"El Jugador 3 ha mentido");
	public Dialog dialogoNoHaMentido4 = new Dialog (this,"El Jugador 3 no ha mentido");
	public Label lblMensaje = new Label("Gana Jugador 1");

	public VistaJugando()
	{
		herramientas = getToolkit();
		tapete = herramientas.getImage("tapete2.png");
		reverso = herramientas.getImage("reverso.png");
		cargarCartas();
		this.setTitle("Cartas");
		this.setSize(820,490);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(false);

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
		g.setColor(Color.black);
		g.drawString("Jugador 1: " + puntosJugador1 + " puntos", 310, 55);
		g.drawImage(reverso, 340, 65, this);
		g.drawString("Jugador 2: " + puntosJugador2 + " puntos", 310, 470);
		g.drawImage(reverso, 340, 295, this);
		g.drawString("Jugador 3: " + puntosJugador3 + " puntos", 30, 175);
		g.drawImage(reverso, 60, 180, this);
		g.drawString("Jugador 4: " + puntosJugador4 + " puntos", 610, 175);
		g.drawImage(reverso, 650, 180, this); 

		//JUGADOR1
		//POSICION DE LAS CARTAS
		switch(imagenAmostrar1)
		{
		//ORO
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

			//BASTOS
		case 13:
			g.drawImage(reverso, 340, 140, this);
			break;
		case 14:
			g.drawImage(reverso, 340, 140, this);
			break;
		case 15:
			g.drawImage(reverso, 340, 140, this);
			break;
		case 16:
			g.drawImage(reverso, 340, 140, this);
			break;
		case 17:
			g.drawImage(reverso, 340, 140, this);
			break;
		case 18:
			g.drawImage(reverso, 340, 140, this);
			break;
		case 19:
			g.drawImage(reverso, 340, 140, this);
			break;
		case 20:
			g.drawImage(reverso, 340, 140, this);
			break;
		case 21:
			g.drawImage(reverso, 340, 140, this);
			break;
		case 22:
			g.drawImage(reverso, 340, 140, this);
			break;
		case 23:
			g.drawImage(reverso, 340, 140, this);
			break;
		case 24:
			g.drawImage(reverso, 340, 140, this);
			break;

			//COPAS
		case 25:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 26:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 27:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 28:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 29:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 30:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 31:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 32:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 33:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 34:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 35:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 36:
			g.drawImage(reverso, 285, 80, this);
			break;

			//ESPADAS
		case 37:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 38:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 39:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 40:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 41:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 42:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 43:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 44:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 45:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 46:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 47:
			g.drawImage(reverso, 285, 80, this);
			break;
		case 48:
			g.drawImage(reverso, 285, 80, this);
			break;
		}

		//JUGADOR2
		switch(imagenAmostrar2)
		{
		//ORO
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

			//BASTOS
		case 13:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 14:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 15:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 16:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 17:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 18:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 19:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 20:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 21:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 22:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 23:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 24:
			g.drawImage(reverso, 310, 250, this);
			break;

			//COPAS
		case 25:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 26:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 27:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 28:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 29:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 30:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 31:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 32:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 33:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 34:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 35:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 36:
			g.drawImage(reverso, 310, 250, this);
			break;

			//ESPADAS
		case 37:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 38:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 39:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 40:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 41:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 42:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 43:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 44:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 45:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 46:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 47:
			g.drawImage(reverso, 310, 250, this);
			break;
		case 48:
			g.drawImage(reverso, 310, 250, this);
			break;
		}

		//JUGADOR 3
		switch(imagenAmostrar3)
		{
		//ORO
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

			//BASTOS
		case 13:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 14:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 15:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 16:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 17:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 18:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 19:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 20:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 21:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 22:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 23:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 24:
			g.drawImage(reverso, 170, 180, this);
			break;

			//COPAS
		case 25:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 26:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 27:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 28:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 29:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 30:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 31:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 32:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 33:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 34:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 35:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 36:
			g.drawImage(reverso, 170, 180, this);
			break;

			//ESPADAS
		case 37:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 38:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 39:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 40:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 41:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 42:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 43:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 44:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 45:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 46:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 47:
			g.drawImage(reverso, 170, 180, this);
			break;
		case 48:
			g.drawImage(reverso, 170, 180, this);
			break;
		}
		
		//JUGADOR 4
		switch(imagenAmostrar4)
		{
		//ORO
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

			//BASTOS
		case 13:
			g.drawImage(reverso, 340, 180, this);
			break;
		case 14:
			g.drawImage(reverso, 340, 180, this);
			break;
		case 15:
			g.drawImage(reverso, 340, 180, this);
			break;
		case 16:
			g.drawImage(reverso, 340, 180, this);
			break;
		case 17:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 18:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 19:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 20:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 21:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 22:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 23:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 24:
			g.drawImage(reverso, 340, 160, this);
			break;

			//COPAS
		case 25:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 26:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 27:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 28:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 29:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 30:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 31:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 32:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 33:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 34:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 35:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 36:
			g.drawImage(reverso, 340, 160, this);
			break;

			//ESPADAS
		case 37:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 38:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 39:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 40:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 41:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 42:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 43:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 44:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 45:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 46:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 47:
			g.drawImage(reverso, 340, 160, this);
			break;
		case 48:
			g.drawImage(reverso, 340, 160, this);
			break;
		}
		
		//JUGADOR 4
		switch(imagenAmostrar5)
		{
		//ORO
		case 1:
			g.drawImage(A1, 340, 165, this);
			break;
		case 2:
			g.drawImage(A2, 340, 165, this);
			break;
		case 3:
			g.drawImage(A3, 340, 165, this);
			break;
		case 4:
			g.drawImage(A4, 340, 165, this);
			break;
		case 5:
			g.drawImage(A5, 340, 165, this);
			break;
		case 6:
			g.drawImage(A6, 340, 165, this);
			break;
		case 7:
			g.drawImage(A7, 340, 165, this);
			break;
		case 8:
			g.drawImage(A8, 340, 165, this);
			break;
		case 9:
			g.drawImage(A9, 340, 165, this);
			break;
		case 10:
			g.drawImage(A10, 340, 165, this);
			break;
		case 11:
			g.drawImage(A11, 340, 165, this);
			break;
		case 12:
			g.drawImage(A12, 340, 165, this);
			break;

			//BASTOS
		case 13:
			g.drawImage(B1, 340, 180, this);
			break;
		case 14:
			g.drawImage(B2, 340, 180, this);
			break;
		case 15:
			g.drawImage(B3, 340, 180, this);
			break;
		case 16:
			g.drawImage(B4, 340, 180, this);
			break;
		case 17:
			g.drawImage(B5, 340, 160, this);
			break;
		case 18:
			g.drawImage(B6, 340, 160, this);
			break;
		case 19:
			g.drawImage(B7, 340, 160, this);
			break;
		case 20:
			g.drawImage(B8, 340, 160, this);
			break;
		case 21:
			g.drawImage(B9, 340, 160, this);
			break;
		case 22:
			g.drawImage(B10, 340, 160, this);
			break;
		case 23:
			g.drawImage(B11, 340, 160, this);
			break;
		case 24:
			g.drawImage(B12, 340, 160, this);
			break;

			//COPAS
		case 25:
			g.drawImage(C1, 340, 160, this);
			break;
		case 26:
			g.drawImage(C2, 340, 160, this);
			break;
		case 27:
			g.drawImage(C3, 340, 160, this);
			break;
		case 28:
			g.drawImage(C4, 340, 160, this);
			break;
		case 29:
			g.drawImage(C5, 340, 160, this);
			break;
		case 30:
			g.drawImage(C6, 340, 160, this);
			break;
		case 31:
			g.drawImage(C7, 340, 160, this);
			break;
		case 32:
			g.drawImage(C8, 340, 160, this);
			break;
		case 33:
			g.drawImage(C9, 340, 160, this);
			break;
		case 34:
			g.drawImage(C10, 340, 160, this);
			break;
		case 35:
			g.drawImage(C11, 340, 160, this);
			break;
		case 36:
			g.drawImage(C12, 340, 160, this);
			break;

			//ESPADAS
		case 37:
			g.drawImage(D1, 340, 160, this);
			break;
		case 38:
			g.drawImage(D2, 340, 160, this);
			break;
		case 39:
			g.drawImage(D3, 340, 160, this);
			break;
		case 40:
			g.drawImage(D4, 340, 160, this);
			break;
		case 41:
			g.drawImage(D5, 340, 160, this);
			break;
		case 42:
			g.drawImage(D6, 340, 160, this);
			break;
		case 43:
			g.drawImage(D7, 340, 160, this);
			break;
		case 44:
			g.drawImage(D8, 340, 160, this);
			break;
		case 45:
			g.drawImage(D9, 340, 160, this);
			break;
		case 46:
			g.drawImage(D10, 340, 160, this);
			break;
		case 47:
			g.drawImage(D11, 340, 160, this);
			break;
		case 48:
			g.drawImage(D12, 340, 160, this);
			break;
		}
	}

	public void cargarCartas()
	{
		//OROS
		A1 = herramientas.getImage("oros_1s.jpg");
		A2 = herramientas.getImage("oros_2s.jpg");
		A3 = herramientas.getImage("oros_3s.jpg");
		A4 = herramientas.getImage("oros_4s.jpg");
		A5 = herramientas.getImage("oros_5s.jpg");
		A6 = herramientas.getImage("oros_6s.jpg");
		A7 = herramientas.getImage("oros_7s.jpg");
		A8 = herramientas.getImage("oros_8s.jpg");
		A9 = herramientas.getImage("oros_9s.jpg");
		A10 = herramientas.getImage("oros_10s.jpg");
		A11 = herramientas.getImage("oros_11s.jpg");
		A12 = herramientas.getImage("oros_12s.jpg");

		//BASTOS
		B1 = herramientas.getImage("bastos_1s.jpg");
		B2 = herramientas.getImage("bastos_2s.jpg");
		B3 = herramientas.getImage("bastos_3s.jpg");
		B4 = herramientas.getImage("bastos_4s.jpg");
		B5 = herramientas.getImage("bastos_5s.jpg");
		B6 = herramientas.getImage("bastos_6s.jpg");
		B7 = herramientas.getImage("bastos_7s.jpg");
		B8 = herramientas.getImage("bastos_8s.jpg");
		B9 = herramientas.getImage("bastos_9s.jpg");
		B10 = herramientas.getImage("bastos_10s.jpg");
		B11 = herramientas.getImage("bastos_11s.jpg");
		B12 = herramientas.getImage("bastos_12s.jpg");

		//COPAS
		C1 = herramientas.getImage("copas_1s.jpg");
		C2 = herramientas.getImage("copas_2s.jpg");
		C3 = herramientas.getImage("copas_3s.jpg");
		C4 = herramientas.getImage("copas_4s.jpg");
		C5 = herramientas.getImage("copas_5s.jpg");
		C6 = herramientas.getImage("copas_6s.jpg");
		C7 = herramientas.getImage("copas_7s.jpg");
		C8 = herramientas.getImage("copas_8s.jpg");
		C9 = herramientas.getImage("copas_9s.jpg");
		C10 = herramientas.getImage("copas_10s.jpg");
		C11 = herramientas.getImage("copas_11s.jpg");
		C12 = herramientas.getImage("copas_12s.jpg");

		//ESPADAS
		D1 = herramientas.getImage("espadas_1s.jpg");
		D2 = herramientas.getImage("espadas_2s.jpg");
		D3 = herramientas.getImage("espadas_3s.jpg");
		D4 = herramientas.getImage("espadas_4s.jpg");
		D5 = herramientas.getImage("espadas_5s.jpg");
		D6 = herramientas.getImage("espadas_6s.jpg");
		D7 = herramientas.getImage("espadas_7s.jpg");
		D8 = herramientas.getImage("espadas_8s.jpg");
		D9 = herramientas.getImage("espadas_9s.jpg");
		D10 = herramientas.getImage("espadas_10s.jpg");
		D11 = herramientas.getImage("espadas_11s.jpg");
		D12 = herramientas.getImage("espadas_12s.jpg");

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

	public void mostrarCartaMazo3(int carta)
	{
		imagenAmostrar3 = carta;
		repaint();
	}

	public void mostrarCartaMazo4(int carta)
	{
		imagenAmostrar4 = carta;
		repaint();
	}
	
	public void cartaSeleccionada(Object object)
	{
		imagenAmostrar5= (int) object;
		repaint();
	}

	public void aumentarPuntosJugador1()
	{
		puntosJugador1++;
		repaint();
	}
	public void aumentarPuntosJugador2()
	{
		puntosJugador2++;
		repaint();
	}

	public void aumentarPuntosJugador3()
	{
		puntosJugador3++;
		repaint();
	}

	public void aumentarPuntosJugador4()
	{
		puntosJugador4++;
		repaint();
	}

	public void resetearContadores()
	{
		puntosJugador1 = 0;
		puntosJugador2 = 0;
		puntosJugador3 = 0;
		puntosJugador4 = 0;
		repaint();
	}

	public void musica()
	{
		new Sonido2();
	}


}
