package es.Studium.Mentiroso; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import es.Studium.Vistas.VistaCrearJugador;
import es.Studium.Vistas.VistaCrearPartida;
import es.Studium.Vistas.VistaJugando;
import es.Studium.Vistas.VistaMejoresJ;
import es.Studium.Vistas.VistaMenuPrincipal;

public class Controlador implements ActionListener, WindowListener, MouseListener
{
	//HACEMOS UN IMPORT DE LAS CLASES VISTAS Y EL MODELO
	VistaMenuPrincipal vistaMenu;
	VistaCrearJugador vistaCrearJ;
	VistaCrearPartida vistaCrearP;
	VistaJugando vistaJugando;
	VistaMejoresJ vistaMejoresJ;
	Modelo modelo;
	Connection conexion = null;
	String informacion ="";

	//MAZOS DE LOS JUGADORES
	/*	HACEMOS UN ARRAYLIST PARA LOS MAZOS DE LOS JUGADORES, PUES INTERESAN ARRAYS DINAMICOS
	 * 	QUE PUEDAN IR CAMBIANDO SUS VALORES Y NO ARRAYS ESTATICOS
	 */
	ArrayList<Integer>mazoJugador1 = new ArrayList<Integer>();
	ArrayList<Integer>mazoJugador2 = new ArrayList<Integer>();
	ArrayList<Integer>mazoJugador3 = new ArrayList<Integer>();
	ArrayList<Integer>mazoJugador4 = new ArrayList<Integer>();
	ArrayList<Integer>mazoCentral = new ArrayList<Integer>();
	ArrayList<Integer>cartasLanzadas = new ArrayList<Integer>();

	//ESTABLECEMOS VALORES POR DEFECTO A LOS VALORES
	int numeroInicial = 0;
	int cartaActual =0;
	int cartaActualJugador1 = 0;
	int cartaActualJugador2 = 0;
	int cartaActualJugador3 = 0;
	int cartaActualJugador4 = 0;
	int turno = 0;
	int uno,dos,tres,cuatro;

	//COLOCAMOS LOS PARAMETROS EN EL CONTROLADOR
	public Controlador(VistaMejoresJ objvistaMej, VistaMenuPrincipal objvistaM, VistaCrearJugador objvistaJ, VistaCrearPartida objvistaP, VistaJugando objvistaJug, Modelo objmodelo)
	{
		//HACEMOS LAS LLAMADAS CORRESPONDIENTES
		this.vistaMejoresJ = objvistaMej;
		this.vistaMenu = objvistaM;
		this.vistaCrearJ = objvistaJ;
		this.vistaCrearP = objvistaP;
		this.vistaJugando = objvistaJug;
		this.modelo = objmodelo;
		//AGREGAMOS LOS LISTENER
		this.vistaMejoresJ.addWindowListener(this);
		this.vistaCrearP.addWindowListener(this);
		this.vistaMenu.addWindowListener(this);
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
		objvistaJug.dialogoTurno.addWindowListener(this);
		objvistaJug.dialogoComienzo.addWindowListener(this);
		objvistaJug.dialogoVictoria.addWindowListener(this);
		objvistaJug.dialogoAcusacion1.addWindowListener(this);
		objvistaJug.dialogoAcusacion2.addWindowListener(this);

		//ELEMENTOS VISTA MEJORES JUGADORES
		objvistaMej.ventanaMejoresJugadores.addWindowListener(this);
		objvistaMej.cerrar.addActionListener(this);
		objvistaMej.addWindowListener(this);
		objvistaMej.setLocationRelativeTo(null);		

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
		//INICIO DE LA PARTIDA Y AGREGAR PARTIDA A LA BASE DE DATOS
		if(vistaCrearP.buttonIniciarPartida.equals(evento.getSource()))
		{	
			//CONECTAMOS A LA BASE DE DATOS
			conexion = this.modelo.conectar();
			//INSERTAR INFORMACIÓN
			this.modelo.crearPartidaNueva(conexion,this.vistaCrearP.textoNombrePartida.getText(),this.vistaCrearP.textoCodigoJugadorPartida.getText());
			//CERRAMOS CONEXION
			this.modelo.cerrar(conexion);
			//MOSTRAMOS LA VISTA DEL JUEGO, EL TAPETE CON SUS CARTAS
			new VistaJugando();	
			this.vistaJugando.setVisible(true);
			//BARAJAMOS LAS CARTAS CON EL METODO DEL MODELO
			this.modelo.barajar(mazoJugador1, mazoJugador2, mazoJugador3, mazoJugador4); 
			//SELECCIONAMOS UN NUMERO INICIAL PARA LANZAR CON EL METODO DEL MODELO
			numeroInicial= this.modelo.numeroInicialSeleccionado(null); 
			this.vistaJugando.lblComienzo.setText("CARTAS REPARTIDAS:");
			this.vistaJugando.dialogoComienzo.setVisible(true);
			//DEL 0 AL 12 ASIGNAMOS LAS CARTAS A LOS JUGADORES
			for(int i= 0; i < 12; i++)
			{
				System.out.println("Carta jugador1: " + mazoJugador1+"   --    >"
						+ ""+"Carta jugador2: " +mazoJugador2+"   --    >"
						+ ""+"Carta jugador3: " +mazoJugador3+"   --    >"
						+ ""+"Carta jugador4: " +mazoJugador4);

			}	

		}

		//CREAR JUGADOR
		else if(vistaMenu.buttonMenuCrearJugador.equals(evento.getSource()))
		{
			this.vistaCrearJ.setVisible(true);
			new VistaCrearJugador();

		}
		//AGREGAR JUGADOR A LA BASE DE DATOS
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
	//FUNCIONALIDAD DEL CLOSING
	public void windowClosing(WindowEvent evento) 
	{       
		if (vistaMenu.isActive())
		{
			vistaMenu.setVisible(false);
		}

		if(vistaCrearP.isActive())
		{
			this.vistaCrearP.setVisible(false);
		}

		else if(vistaCrearJ.isActive())
		{
			this.vistaCrearJ.setVisible(false);
		}

		else if(vistaJugando.isActive())
		{
			this.vistaJugando.setVisible(false);
		}

		else if(vistaMejoresJ.ventanaMejoresJugadores.isActive())
		{
			this.vistaMejoresJ.ventanaMejoresJugadores.setVisible(false);
		}


		//DIALOGOS
		else if(vistaJugando.dialogoAcusacion1.isActive())
		{
			vistaJugando.dialogoAcusacion1.setVisible(false);
		}

		else if(vistaJugando.dialogoAcusacion2.isActive())
		{
			vistaJugando.dialogoAcusacion2.setVisible(false);
		}

		else if(vistaJugando.dialogoComienzo.isActive())
		{
			vistaJugando.dialogoComienzo.setVisible(false);
		}

		else if(vistaJugando.dialogoVictoria.isActive())
		{
			vistaJugando.dialogoVictoria.setVisible(false);
		}
	}

	//FUNCIONALIDAD DEL JUEGO
	public void mouseClicked(MouseEvent evento)
	{       
		int x = evento.getX();
		int y = evento.getY();

		//TURNOS
		//TURNO JUGADOR 1
		
		/*
		 * SI EL JUGADOR PINCHA EN ESAS COORDENADAS
		 */
		if((x>=340)&&(x<=449)&&(y>=65)&&(y<=215)&&(turno==0))//JUGADOR 1 LANZA CARTA
		{   
			cartasLanzadas = this.modelo.accionJugador(mazoJugador1);//MAZO ACTUALIZADO	
			mazoJugador1 =this.modelo.lanzamientos(mazoJugador1, cartasLanzadas);	
			mazoCentral=this.modelo.mazoCartaCentral(mazoCentral, cartasLanzadas);
			this.vistaJugando.reversoCarta();
			turno = 1;
			System.out.println("JUGADOR 1 HA LANZADO CARTA, TURNO DEL JUGADOR 2.");
			System.out.println("JUGADOR 2 ¿LANZAS O LEVANTAS?");

		}

		if((x>=340)&&(x<=449)&&(y>=165)&&(y<=315)&&(turno==0))//JUGADOR 1 LEVANTA LA CARTA DEL JUGADOR 4
		{
			System.out.println("JUGADOR 1 LLAMA MENTIROSO AL JUGADOR 4. LEVANTA SUS CARTAS.");

			//ERROR QUE DEBO CORREGIR
			if(numeroInicial==mazoJugador4[cartaActualJugador4-1])
			{
				this.vistaJugando.lblNoMintio.setText("EL JUGADOR 4 NO MINTIO");
				this.vistaJugando.dialogoAcusacion1.setVisible(true);
			}
			
			//ERROR QUE DEBO CORREGIR
			else if(numeroInicial!=mazoJugador4[cartaActualJugador4-1])
			{
				this.vistaJugando.lblMentido.setText("EL JUGADOR 4 MINTIO");
				this.vistaJugando.dialogoAcusacion2.setVisible(true);

			}
			System.out.println("EL JUGADOR 1, SELECCIONA UN NUEVO NUMERO EL:");
			numeroInicial=this.modelo.nuevoNumeroSeleccionado(null);
		}


		//TURNO JUGADOR 2
		else if ((x>=340)&&(x<=449)&&(y>=295)&&(y<=445)&&(turno==1))//jUGADOR 2 LANZA CARTA
		{
			cartasLanzadas = this.modelo.accionJugador(mazoJugador2);//MAZO ACTUALIZADO	
			mazoJugador2 =this.modelo.lanzamientos(mazoJugador2, cartasLanzadas);	
			mazoCentral=this.modelo.mazoCartaCentral(mazoCentral, cartasLanzadas);		
			this.vistaJugando.reversoCarta();
			turno = 2;
			System.out.println("JUGADOR 2 HA LANZADO CARTA, TURNO DEL JUGADOR 2.");
			System.out.println("JUGADOR 3 ¿LANZAS O LEVANTAS?");
		} 

		if((x>=340)&&(x<=449)&&(y>=165)&&(y<=315)&&(turno==1))//JUGADOR 2 LEVANTA CARTA JUGADOR 1
		{
			//ERROR QUE DEBO CORREGIR
			System.out.println("JUGADOR 2 LLAMA MENTIROSO AL JUGADOR 1. LEVANTA SUS CARTAS.");
			if(numeroInicial==mazoJugador1[cartaActualJugador1-1])
			{
				this.vistaJugando.lblNoMintio.setText("EL JUGADOR 1 NO MINTIÓ");
				this.vistaJugando.dialogoAcusacion1.setVisible(true);
			}
			//ERROR QUE DEBO CORREGIR
			else if(numeroInicial!=mazoJugador1[cartaActualJugador1-1])
			{
				this.vistaJugando.lblMentido.setText("EL JUGADOR 1 MINTIÓ");
				this.vistaJugando.dialogoAcusacion2.setVisible(true);
			}
			System.out.println("EL JUGADOR 2, SELECCIONA UN NUEVO NUMERO EL:");
			numeroInicial=this.modelo.nuevoNumeroSeleccionado(null);

		}

		//TURNO JUGADOR 3
		else if((x>=60)&&(x<=169)&&(y>=180)&&(y<=330)&&(turno==2))//JUGADOR 3 LANZA CARTA
		{
			cartasLanzadas = this.modelo.accionJugador(mazoJugador3);//MAZO ACTUALIZADO	
			mazoJugador3 =this.modelo.lanzamientos(mazoJugador3, cartasLanzadas);	
			mazoCentral=this.modelo.mazoCartaCentral(mazoCentral, cartasLanzadas);	
			this.vistaJugando.reversoCarta();
			turno = 3;
			System.out.println("JUGADOR 3 HA LANZADO CARTA, TURNO DEL JUGADOR 2.");
			System.out.println("JUGADOR 4 ¿LANZAS O LEVANTAS?");
		}

		//JUGADOR 3 LEVANTA CARTAS DEL JUGADOR 2
		if((x>=340)&&(x<=419)&&(y>=165)&&(y<=315)&&(turno==2))
		{
			System.out.println("JUGADOR 3 LLAMA MENTIROSO AL JUGADOR 2. LEVANTA SUS CARTAS.");
			//ERROR QUE DEBO CORREGIR
			if(numeroInicial==mazoJugador2[cartaActualJugador2-1])
			{
				this.vistaJugando.lblNoMintio.setText("EL JUGADOR 2 NO MINTIÓ");
				this.vistaJugando.dialogoAcusacion1.setVisible(true);
			}
			//ERROR QUE DEBO CORREGIR
			else if(numeroInicial!=mazoJugador2[cartaActualJugador2-1])
			{
				this.vistaJugando.lblMentido.setText("EL JUGADOR 2 MINTIÓ");
				this.vistaJugando.dialogoAcusacion2.setVisible(true);
			}
			System.out.println("EL JUGADOR 3, SELECCIONA UN NUEVO NUMERO EL:");
			numeroInicial=this.modelo.nuevoNumeroSeleccionado(null);
		}

		//TURNO JUGADOR 4
		else if((x>=650)&&(x<=759)&&(y>=180)&&(y<=330)&&(turno==3))
		{
			cartasLanzadas = this.modelo.accionJugador(mazoJugador4);//MAZO ACTUALIZADO	
			mazoJugador4 =this.modelo.lanzamientos(mazoJugador4, cartasLanzadas);	
			mazoCentral=this.modelo.mazoCartaCentral(mazoCentral, cartasLanzadas);	
			this.vistaJugando.reversoCarta();
			turno = 4;
			System.out.println("JUGADOR 1 HA LANZADO CARTA, TURNO DEL JUGADOR 2.");
			System.out.println("JUGADOR 2 ¿LANZAS O LEVANTAS?");
		}

		//JUGADOR 4 LEVANTA CARTAS DEL JUGADOR 3
		if((x>=340)&&(x<=449)&&(y>=165)&&(y<=315)&&(turno==3))
		{
			System.out.println("JUGADOR 4 LLAMA MENTIROSO AL JUGADOR 3. LEVANTA SUS CARTAS.");
			//ERROR QUE DEBO CORREGIR
			if(numeroInicial==mazoJugador3[cartaActualJugador3-1])
			{
				this.vistaJugando.lblNoMintio.setText("EL JUGADOR 3 NO MINTIÓ");
				this.vistaJugando.dialogoAcusacion1.setVisible(true);
			}
			//ERROR QUE DEBO CORREGIR
			else if(numeroInicial!=mazoJugador3[cartaActualJugador3-1])
			{
				this.vistaJugando.lblMentido.setText("EL JUGADOR 3 MINTIÓ");
				this.vistaJugando.dialogoAcusacion2.setVisible(true);
			}
			System.out.println("EL JUGADOR 4, SELECCIONA UN NUEVO NUMERO EL:");
			numeroInicial=this.modelo.nuevoNumeroSeleccionado(null);
		}

		//DEBO AÑADIR UN METODO POR EL CUAL CUANDO UN JUGADOR SE QUEDE SIN CARTAS, GANE


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
