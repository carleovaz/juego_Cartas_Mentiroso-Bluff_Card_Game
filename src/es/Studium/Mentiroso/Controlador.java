package es.Studium.Mentiroso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

import es.Studium.Vistas.VistaCrearJugador;
import es.Studium.Vistas.VistaCrearPartida;
import es.Studium.Vistas.VistaJugando;
import es.Studium.Vistas.VistaMejoresJ;
import es.Studium.Vistas.VistaMenuPrincipal;

public class Controlador implements ActionListener, WindowListener, MouseListener
{
	VistaMenuPrincipal vistaMenu;
	VistaCrearJugador vistaCrearJ;
	VistaCrearPartida vistaCrearP;
	VistaJugando vistaJugando;
	VistaMejoresJ vistaMejoresJ;
	Modelo modelo;
	Connection conexion = null;
	String informacion ="";

	int mazoJugador1[] = new int[12];
	int mazoJugador2[] = new int[12];
	int mazoJugador3[] = new int[12];
	int mazoJugador4[] = new int[12];
	int cartaActualJugador1 = 0;
	int cartaActualJugador2 = 0;
	int cartaActualJugador3 = 0;
	int cartaActualJugador4 = 0;
	int puntosJugador1 = 0;
	int puntosJugador2 = 0;
	int puntosJugador3 = 0;
	int puntosJugador4 = 0;
	int turno = 0; // 0 turno jugador 1, 1 turno jugador 2
	int uno,dos,tres,cuatro;

	public Controlador(VistaMejoresJ objvista, VistaMenuPrincipal objvistaM, VistaCrearJugador objvistaJ, VistaCrearPartida objvistaP, VistaJugando objvistaJug, Modelo objmodelo)
	{
		this.vistaMejoresJ = objvista;
		this.vistaMenu = objvistaM;
		this.vistaCrearJ = objvistaJ;
		this.vistaCrearP = objvistaP;
		this.vistaJugando = objvistaJug;

		this.modelo = objmodelo;
		this.vistaMejoresJ.addWindowListener(this);
		this.vistaMenu.addWindowListener(this);
		this.vistaMejoresJ.addWindowListener(this);
		this.vistaJugando.addWindowListener(this);
		this.vistaJugando.addMouseListener(this);


		//ELEMENTOS VISTA JUGADOR
		objvistaJ.addWindowListener(this);
		objvistaJ.ventanaCrearJugador.addWindowListener(this);
		objvistaJ.dialogoMensajeJugadorCreado.addWindowListener(this);
		objvistaJ.crearJugador.addActionListener(this);
		objvistaJ.cerrarJugador.addActionListener(this);

		//ELEMENTOS VISTA PARTIDA
		objvistaP.addWindowListener(this);
		objvistaP.ventanaCrearPartida.addWindowListener(this);
		objvistaP.dialogoMensajePartidaCreada.addWindowListener(this);
		objvistaP.buttonIniciarPartida.addActionListener(this);
		objvistaP.cerrarPartida.addActionListener(this);

		//ELEMENTOS VISTA MENU
		objvistaM.ventanaMenu.addWindowListener(this);
		objvistaM.buttonCrearPartida.addActionListener(this);
		objvistaM.buttonMenuCrearJugador.addActionListener(this);
		objvistaM.buttoncomoSeJuega.addActionListener(this);
		objvistaM.buttonMejoresJugadores.addActionListener(this);
		objvistaM.buttonSalirMenu.addActionListener(this);

		//ELEMENTOS VISTA JUGANDO
		objvistaJug.ventanaJuego.addWindowListener(this);
		objvistaJug.ventanaJuego.addMouseListener(this);
		objvistaJug.dlgMensaje.addWindowListener(this);

		//ELEMENTOS VISTA GENERAL
		objvista.ventanaMejoresJugadores.addWindowListener(this);
		objvista.cerrar.addActionListener(this);
		objvista.addWindowListener(this);
		objvista.setLocationRelativeTo(null);		

	}

	@Override
	public void actionPerformed(ActionEvent evento) 
	{
		//CREAR PARTIDA
		if(vistaMenu.buttonCrearPartida.equals(evento.getSource()))
		{
			this.vistaCrearP.setVisible(true);
			new VistaCrearPartida();

		}
		//INICIO DE LA PARTIDA
		if(vistaCrearP.buttonIniciarPartida.equals(evento.getSource()))
		{
			//CONECTAMOS A LA BASE DE DATOS
			//			conexion = this.modelo.conectar();
			//			//REALIZAR LA CONSULTA E INSERTAR INFORMACIÓN
			//			informacion = this.modelo.crearPartidaNueva(conexion);
			//			//RELLENAMOS EL TEXTAREA
			//			this.vistaCrearJ.textocodigoJugador.append(informacion);
			//			this.vistaCrearJ.textoNombreJugador.append(informacion);
			//			//CERRAMOS CONEXION
			//			this.modelo.cerrar(conexion);

			this.vistaJugando.setVisible(true);
			new VistaJugando();
			this.modelo.barajar(mazoJugador1, mazoJugador2, mazoJugador3, mazoJugador4);
			for(int i= 0; i < 12; i++)
			{
				System.out.println("Carta jugador1: " + mazoJugador1[i]+"   --    >"+"Carta jugador2: " +mazoJugador2[i]+"   --    >"+"Carta jugador3: " +mazoJugador3[i]+"   --    >"+"Carta jugador4: " +mazoJugador4[i]);

			}

		}

		//CREAR JUGADOR
		else if(vistaMenu.buttonMenuCrearJugador.equals(evento.getSource()))
		{
			this.vistaCrearJ.setVisible(true);
			new VistaCrearJugador();

		}

		else if(vistaCrearJ.crearJugador.equals(evento.getSource()))
		{

		}

		//COMO SE JUEGA
		else if(vistaMenu.buttoncomoSeJuega.equals(evento.getSource()))
		{
			this.modelo.ayuda();
		}

		//CONSULTA MEJORES JUGADORES
		else if(vistaMenu.buttonMejoresJugadores.equals(evento.getSource()))
		{
			vistaMejoresJ.ventanaMejoresJugadores.setVisible(true);
			//CONECTAMOS A LA BASE DE DATOS
			conexion = this.modelo.conectar();
			//REALIZAR LA CONSULTA E INSERTAR INFORMACIÓN
			informacion = this.modelo.mejoresJugadores(conexion);
			//RELLENAMOS EL TEXTAREA
			this.vistaMejoresJ.listadoJugadores.append(informacion);
			//CERRAMOS CONEXION
			this.modelo.cerrar(conexion);
		}

		//BOTONES QUE CIERRAN VENTANAS
		if(vistaMenu.buttonSalirMenu.equals(evento.getSource()))
		{
			System.exit(0);
		}

		else if(vistaCrearJ.cerrarJugador.equals(evento.getSource()))
		{
			this.vistaCrearJ.setVisible(false);

		}

		else if(vistaCrearP.cerrarPartida.equals(evento.getSource()))
		{
			this.vistaCrearP.setVisible(false);

		}

		else if(vistaMejoresJ.cerrar.equals(evento.getSource()))
		{
			this.vistaMejoresJ.ventanaMejoresJugadores.setVisible(false);
		}

	}

	public void windowClosing(WindowEvent evento) 
	{		
		this.vistaMenu.equals(evento.getSource());
		{
			System.exit(0);
		}

		this.vistaJugando.ventanaJuego.equals(evento.getSource());
		{
			System.exit(0);
		}


		if(this.vistaJugando.dlgMensaje.isActive())
		{
			this.vistaJugando.dlgMensaje.setVisible(false);
			// Reinicio
			cartaActualJugador1 = 0;
			cartaActualJugador2 = 0;
			puntosJugador1 = 0;
			puntosJugador2 = 0;
			this.vistaJugando.resetearContadores();
			turno = 0;
			this.vistaJugando.mostrarCartaMazo1(-1); // Quitar última carta mostrada
			this.vistaJugando.mostrarCartaMazo2(-1); // Quitar última carta mostrada
			this.modelo.barajar(mazoJugador1, mazoJugador2, mazoJugador3, mazoJugador4);
		}
		else
		{
			System.exit(0);
		}
	}


	public void mouseClicked(MouseEvent evento)
	{		
		int x = evento.getX();
		int y = evento.getY();
		
		//TURNOS
		if((x>=340)&&(x<=449)&&(y>=65)&&(y<=215)&&(turno==0))
		{
			//MOSTRAR LA CARTA DEL MAZO 1
			this.vistaJugando.mostrarCartaMazo1(mazoJugador1[cartaActualJugador1]);
			turno = 1;
			System.out.println("Pulsaste el mazo 1");
		}

		else if ((x>=340)&&(x<=449)&&(y>=295)&&(y<=445)&&(turno==1))
		{
			//MOSTRAR LA CARTA DEL MAZO 2
			this.vistaJugando.mostrarCartaMazo2(mazoJugador2[cartaActualJugador2]);
			turno = 2;
			System.out.println("Pulsaste el mazo 2");
		
		}

		else if((x>=60)&&(x<=169)&&(y>=180)&&(y<=330)&&(turno==2))
		{
			//MOSTRAR LA CARTA DEL MAZO 3
			this.vistaJugando.mostrarCartaMazo3(mazoJugador3[cartaActualJugador3]);
			turno = 3;
			System.out.println("Pulsaste el mazo 3");
		}

		else if((x>=650)&&(x<=759)&&(y>=180)&&(y<=330)&&(turno==3))
		{
			//MOSTRAR LA CARTA DEL MAZO 4
			this.vistaJugando.mostrarCartaMazo4(mazoJugador4[cartaActualJugador4]);
			turno =3;
			System.out.println("Pulsaste el mazo 4");
		}


		if(puntosJugador1 == 1)
		{
			//GANADOR JUGADOR 1
			this.vistaJugando.lblMensaje.setText("GANA Jugador 1");
			this.vistaJugando.dlgMensaje.setVisible(true);
		}
		else if (puntosJugador2 == 1)
		{
			//GANADOR JUGADOR 2
			this.vistaJugando.lblMensaje.setText("GANA Jugador 2");
			this.vistaJugando.dlgMensaje.setVisible(true);
			uno = mazoJugador1[cartaActualJugador1] % 12;
			if(uno==0)
			{
				uno = 12;
			}
			dos = mazoJugador2[cartaActualJugador2] % 12;
			if(dos==0)
			{
				dos = 12;
			}
			if(uno>dos)
			{
				puntosJugador1++;
				this.vistaJugando.aumentarPuntosJugador1();
			}
			else if (uno<dos)
			{
				puntosJugador2++;
				this.vistaJugando.aumentarPuntosJugador2();
			}
			cartaActualJugador1++;
			cartaActualJugador2++;
			turno = 0;
		}
		else if (puntosJugador3 == 1)
		{
			//GANADOR JUGADOR 3
			this.vistaJugando.lblMensaje.setText("GANA Jugador 3");
			this.vistaJugando.dlgMensaje.setVisible(true);
		}
		else if (puntosJugador4 == 1)
		{
			//GANADOR JUGADOR 4
			this.vistaJugando.lblMensaje.setText("GANA Jugador 4");
			this.vistaJugando.dlgMensaje.setVisible(true);
		}
	}
	public void mouseEntered(MouseEvent arg0) {

	}
	public void mouseExited(MouseEvent arg0) {

	}
	public void mousePressed(MouseEvent arg0) {

	}
	public void mouseReleased(MouseEvent arg0) {

	}
	public void windowActivated(WindowEvent arg0) {
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
	}

}
