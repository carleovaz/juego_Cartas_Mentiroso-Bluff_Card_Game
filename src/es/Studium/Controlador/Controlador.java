package es.Studium.Controlador; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.util.ArrayList;

import es.Studium.Modelo.Modelo;
import es.Studium.Vistas.VistaCrearPartida;
import es.Studium.Vistas.VistaJugando;
import es.Studium.Vistas.VistaMejoresJ;
import es.Studium.Vistas.VistaMenuPrincipal;

public class Controlador implements ActionListener, WindowListener, MouseListener
{
	//HACEMOS UN IMPORT DE LAS CLASES VISTAS Y EL MODELO
	VistaMenuPrincipal vistaMenu;
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
	int turno = 1;
	int puntuacionJugador1=0;
	int puntuacionJugador2=0;
	int puntuacionJugador3=0;
	int puntuacionJugador4=0;
	int uno,dos,tres,cuatro;
	boolean bandera =false;

	//COLOCAMOS LOS PARAMETROS EN EL CONTROLADOR
	public Controlador(VistaMejoresJ objvistaMej, VistaMenuPrincipal objvistaM, VistaCrearPartida objvistaP, VistaJugando objvistaJug, Modelo objmodelo)
	{
		//HACEMOS LAS LLAMADAS CORRESPONDIENTES
		this.vistaMejoresJ = objvistaMej;
		this.vistaMenu = objvistaM;
		this.vistaCrearP = objvistaP;
		this.vistaJugando = objvistaJug;
		this.modelo = objmodelo;

		//AGREGAMOS LOS LISTENER
		this.vistaMejoresJ.addWindowListener(this);
		this.vistaCrearP.addWindowListener(this);
		this.vistaMenu.addWindowListener(this);
		this.vistaJugando.addWindowListener(this);
		this.vistaJugando.addMouseListener(this);

		//ELEMENTOS VISTA PARTIDA
		objvistaP.addWindowListener(this);
		objvistaP.ventanaCrearPartida.addWindowListener(this);
		objvistaP.dialogoMensajePartidaCreada.addWindowListener(this);
		objvistaP.buttonIniciarPartida.addActionListener(this);
		objvistaP.cerrarPartida.addActionListener(this);
		objvistaP.dialogoMensajePartidaCreada.addWindowListener(this);

		//ELEMENTOS VISTA MENU
		objvistaM.ventanaMenu.addWindowListener(this);
		objvistaM.buttonCrearPartida.addActionListener(this);
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
			if(this.vistaCrearP.buttonIniciarPartida.equals(evento.getSource()))
			{
				String texto1=this.vistaCrearP.textoNombreJugador1.getText();
				String texto2=this.vistaCrearP.textoNombreJugador2.getText();
				String texto3=this.vistaCrearP.textoNombreJugador3.getText();
				String texto4=this.vistaCrearP.textoNombreJugador4.getText();
				texto1=texto1.replaceAll(" ", "");
				texto2=texto2.replaceAll(" ", "");
				texto3=texto3.replaceAll(" ", "");
				texto4=texto4.replaceAll(" ", "");
				if(texto2.length()==0 && texto2.length()==0 && (texto3.length()==0) && (texto4.length()==0))
				{
					this.vistaCrearP.partidaCreada.setText("ERROR: FALTAN DATOS.");
					this.vistaCrearP.dialogoMensajePartidaCreada.setVisible(true);  
				}
				else if(texto2.length()==0)
				{
					this.vistaCrearP.partidaCreada.setText("ERROR: FALTAN DATOS.");
					this.vistaCrearP.dialogoMensajePartidaCreada.setVisible(true);  
				}
				else if(texto3.length()==0)
				{
					this.vistaCrearP.partidaCreada.setText("ERROR: FALTAN DATOS.");
					this.vistaCrearP.dialogoMensajePartidaCreada.setVisible(true);  
				}
				else if(texto4.length()==0)
				{
					this.vistaCrearP.partidaCreada.setText("ERROR: FALTAN DATOS.");
					this.vistaCrearP.dialogoMensajePartidaCreada.setVisible(true);  
				}
				this.vistaJugando.setVisible(false);
			}

			if(this.vistaCrearP.buttonIniciarPartida.equals(evento.getSource()))
			{
				new VistaJugando();	
				this.vistaJugando.setVisible(true);
				//BARAJAMOS LAS CARTAS CON EL METODO DEL MODELO
				this.modelo.barajar(mazoJugador1, mazoJugador2, mazoJugador3, mazoJugador4); 
				numeroInicial=7; 
				this.vistaJugando.lblComienzo.setText("CARTAS REPARTIDAS, NUMERO A LANZAR:" + this.modelo.numeroInicialSeleccionado(null) );
				this.vistaJugando.avisoTurno(+1);
				this.vistaJugando.dialogoComienzo.setVisible(true);
				//DEL 0 AL 12 ASIGNAMOS LAS CARTAS A LOS JUGADORES	
				System.out.println("MAZO JUGADOR 1: " + mazoJugador1+""
						+ ""+"\nMAZO JUGADOR 2: " +mazoJugador2+""
						+ ""+"\nMAZO JUGADOR 3: " +mazoJugador3+""
						+ ""+"\nMAZO JUGADOR 4: " +mazoJugador4);
			}
		}

		//COMO SE JUEGA
		if(vistaMenu.buttoncomoSeJuega.equals(evento.getSource()))
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

		else if(vistaCrearP.dialogoMensajePartidaCreada.isActive())
		{
			vistaCrearP.dialogoMensajePartidaCreada.setVisible(false);
		}
	}

	//FUNCIONALIDAD DEL JUEGO
	public void mouseClicked(MouseEvent evento)
	{       
		int x = evento.getX();
		int y = evento.getY();


		//TURNOS
		/* JUGADOR 1==1
		 * JUGADOR 2==2
		 * JUGADOR 3==3
		 * JUGADOR 4==4
		 */

		//TURNO JUGADOR 1		
		if((x>=340)&&(x<=449)&&(y>=65)&&(y<=215)&&(turno==1))//JUGADOR 1 LANZA CARTA

		{   
			bandera=false;
			cartasLanzadas = this.modelo.accionJugador(mazoJugador1);//EL JUGADOR 1 EJECUTA UNA ACCION
			cartasLanzadas = new ArrayList<Integer>();
			cartasLanzadas.add(7);
			cartasLanzadas.add(7);
			cartasLanzadas.add(7);
			System.out.println("LANZA CARTAS EL JUGADOR 1 " + cartasLanzadas);
			mazoJugador1 =this.modelo.lanzamientos(mazoJugador1, cartasLanzadas); //JUGADOR 1 LANZA CARTAS	
			System.out.println("LE QUEDAN AL JUGADOR 1: " +mazoJugador1);
			mazoCentral=this.modelo.mazoCartaCentral(mazoCentral, cartasLanzadas);//LAS CARTAS DEL JUGADOR 1 PASAN AL MAZO CENTRAL
			this.vistaJugando.reversoCarta();//MUESTRA EL DIBUJO DEL REVERSO DE LA CARTA
			turno = 2;//PASA EL TURNO AL JUGADOR 2
			if(turno==2)
			{
				this.vistaJugando.avisoTurno(+2);
			}
			System.out.println("JUGADOR 2 ¿LANZAS O LEVANTAS?");

		}

		if((x>=340)&&(x<=449)&&(y>=165)&&(y<=315)&&(turno==1))//JUGADOR 1 LEVANTA LA CARTA DEL JUGADOR 4
		{
			if(bandera==false)//ASEGURA QUE SE PASE EL TURNO A OTRO JUGADOR
			{
				boolean bandera1=false;//DETERMINA SI EL JUGADOR HA MENTIDO
				System.out.println("JUGADOR 1 LLAMA MENTIROSO AL JUGADOR 4. LEVANTA SUS CARTAS.");
				for(int i=0;i<cartasLanzadas.size();i++)
				{
					//SI VE QUE UNA DE LAS CARTAS ES DISTINTA
					if(numeroInicial!=cartasLanzadas.get(i))
					{
						bandera1=true;
					}
				}
				//SI VE QUE NINGUNA CARTA ES DISTINTA
				if(bandera1==false)
				{
					//Todas las cartas son iguales
					mazoJugador1 = this.modelo.devolverCartasAJugadores(mazoJugador1, mazoCentral);
					this.vistaJugando.lblNoMintio.setText("EL JUGADOR 4 NO MINTIÓ");
					this.vistaJugando.dialogoAcusacion1.setVisible(true);
					turno=2;
					bandera=true;
					this.vistaJugando.avisoTurno(+2);
				}

				else
				{
					mazoJugador4 = this.modelo.devolverCartasAJugadores(mazoJugador4, mazoCentral);
					this.vistaJugando.lblMentido.setText("EL JUGADOR 4 MINTIÓ");
					this.vistaJugando.dialogoAcusacion2.setVisible(true);
					turno=1;
				}
				mazoCentral = new ArrayList<Integer>();
				System.out.println("EL JUGADOR 1, SELECCIONA UN NUEVO NUMERO EL:" + (numeroInicial=this.modelo.nuevoNumeroSeleccionado(null)));
			}
			
		}


		//TURNO JUGADOR 2
		else if ((x>=340)&&(x<=449)&&(y>=295)&&(y<=445)&&(turno==2))//jUGADOR 2 LANZA CARTA 
		{
			bandera=false;
			cartasLanzadas = this.modelo.accionJugador(mazoJugador2);//MAZO ACTUALIZADO	
			System.out.println("LANZA CARTAS EL JUGADOR 2 " + cartasLanzadas);
			mazoJugador2 =this.modelo.lanzamientos(mazoJugador2, cartasLanzadas);
			System.out.println("LE QUEDAN AL JUGADOR 2: " +mazoJugador2);
			mazoCentral=this.modelo.mazoCartaCentral(mazoCentral, cartasLanzadas);
			this.vistaJugando.reversoCarta();
			turno = 3;
			if(turno==3)
			{
				this.vistaJugando.avisoTurno(+3);
			}
			System.out.println("JUGADOR 3 ¿LANZAS O LEVANTAS?");
		} 

		if((x>=340)&&(x<=449)&&(y>=165)&&(y<=315)&&(turno==2))//JUGADOR 2 LEVANTA CARTA JUGADOR 1
		{

			if(bandera==false)
			{
				boolean bandera1=false;
				System.out.println("JUGADOR 1 LLAMA MENTIROSO AL JUGADOR 4. LEVANTA SUS CARTAS.");
				for(int i=0;i<cartasLanzadas.size();i++)
				{
					//SI VE QUE UNA DE LAS CARTAS ES DISTINTA
					if(numeroInicial!=cartasLanzadas.get(i))
					{
						bandera1=true;
					}
				}
				//SI VE QUE NINGUNA CARTA ES DISTINTA
				if(bandera1==false)
				{
					//Todas las cartas son iguales
					mazoJugador2 = this.modelo.devolverCartasAJugadores(mazoJugador2, mazoCentral);
					this.vistaJugando.lblNoMintio.setText("EL JUGADOR 1 NO MINTIÓ");
					this.vistaJugando.dialogoAcusacion1.setVisible(true);
					turno=3;
					bandera=true;
					this.vistaJugando.avisoTurno(+3);

				}

				else
				{
					mazoJugador1 = this.modelo.devolverCartasAJugadores(mazoJugador1, mazoCentral);
					this.vistaJugando.lblMentido.setText("EL JUGADOR 1 MINTIÓ");
					this.vistaJugando.dialogoAcusacion2.setVisible(true);
					turno=2;
					

				}
				mazoCentral = new ArrayList<Integer>();
				System.out.println("EL JUGADOR 2, SELECCIONA UN NUEVO NUMERO EL:" + (numeroInicial=this.modelo.nuevoNumeroSeleccionado(null)));
			}


		}

		//TURNO JUGADOR 3
		else if((x>=60)&&(x<=169)&&(y>=180)&&(y<=330)&&(turno==3))//JUGADOR 3 LANZA CARTA
		{
			bandera=false;
			this.vistaJugando.avisoTurno(+1);
			cartasLanzadas = this.modelo.accionJugador(mazoJugador3);//MAZO ACTUALIZADO	
			System.out.println("LANZA CARTAS EL JUGADOR 3 " + cartasLanzadas);
			mazoJugador3 =this.modelo.lanzamientos(mazoJugador3, cartasLanzadas);
			System.out.println("LE QUEDAN AL JUGADOR 3: " +mazoJugador3);
			mazoCentral=this.modelo.mazoCartaCentral(mazoCentral, cartasLanzadas);
			this.vistaJugando.reversoCarta();
			turno = 4;
			if(turno==4)
			{
				this.vistaJugando.avisoTurno(+4);
			}
			System.out.println("JUGADOR 4 ¿LANZAS O LEVANTAS?");
		}

		//JUGADOR 3 LEVANTA CARTAS DEL JUGADOR 2
		if((x>=340)&&(x<=419)&&(y>=165)&&(y<=315)&&(turno==3))
		{
			if(bandera==false)
			{
				this.vistaJugando.avisoTurno(+1);
				boolean bandera1=false;
				System.out.println("JUGADOR 3 LLAMA MENTIROSO AL JUGADOR 2. LEVANTA SUS CARTAS.");
				for(int i=0;i<cartasLanzadas.size();i++)
				{
					//SI VE QUE UNA DE LAS CARTAS ES DISTINTA
					if(numeroInicial!=cartasLanzadas.get(i))
					{
						bandera1=true;
					}
				}
				//SI VE QUE NINGUNA CARTA ES DISTINTA
				if(bandera1==false)
				{
					//Todas las cartas son iguales
					mazoJugador3 = this.modelo.devolverCartasAJugadores(mazoJugador3, mazoCentral);
					this.vistaJugando.lblNoMintio.setText("EL JUGADOR 2 NO MINTIÓ");
					this.vistaJugando.dialogoAcusacion1.setVisible(true);
					turno=4;
					bandera=true;
					this.vistaJugando.avisoTurno(+4);
				}

				else
				{
					mazoJugador2 = this.modelo.devolverCartasAJugadores(mazoJugador2, mazoCentral);
					this.vistaJugando.lblMentido.setText("EL JUGADOR 2 MINTIÓ");
					this.vistaJugando.dialogoAcusacion2.setVisible(true);
					turno=3;
				}
				mazoCentral = new ArrayList<Integer>();
				System.out.println("EL JUGADOR 3, SELECCIONA UN NUEVO NUMERO EL:" + (numeroInicial=this.modelo.nuevoNumeroSeleccionado(null)));

			}

		}

		//TURNO JUGADOR 4
		else if((x>=650)&&(x<=759)&&(y>=180)&&(y<=330)&&(turno==4))
		{
			bandera=false;
			this.vistaJugando.avisoTurno(+1);
			cartasLanzadas = this.modelo.accionJugador(mazoJugador4);//EL JUGADOR 1 EJECUTA UNA ACCION
			System.out.println("LANZA CARTAS EL JUGADOR 4 " + cartasLanzadas);
			mazoJugador4 =this.modelo.lanzamientos(mazoJugador4, cartasLanzadas); //JUGADOR 1 LANZA CARTAS	
			System.out.println("LE QUEDAN AL JUGADOR 4: " + mazoJugador4);
			mazoCentral=this.modelo.mazoCartaCentral(mazoCentral, cartasLanzadas);//LAS CARTAS DEL JUGADOR 1 PASAN AL MAZO CENTRAL
			this.vistaJugando.reversoCarta();
			turno = 1;
			System.out.println("JUGADOR 1 ¿LANZAS O LEVANTAS?");

		}

		//JUGADOR 4 LEVANTA CARTAS DEL JUGADOR 3
		if((x>=340)&&(x<=449)&&(y>=165)&&(y<=315)&&(turno==4))
		{
			if(bandera==false)
			{
				boolean bandera1=false;
				System.out.println("JUGADOR 4 LLAMA MENTIROSO AL JUGADOR 3. LEVANTA SUS CARTAS.");
				for(int i=0;i<cartasLanzadas.size();i++)
				{
					//SI VE QUE UNA DE LAS CARTAS ES DISTINTA
					if(numeroInicial!=cartasLanzadas.get(i))
					{
						bandera1=true;
					}
				}
				//SI VE QUE NINGUNA CARTA ES DISTINTA
				if(bandera1==false)
				{
					//Todas las cartas son iguales
					mazoJugador4 = this.modelo.devolverCartasAJugadores(mazoJugador4, mazoCentral);
					this.vistaJugando.lblNoMintio.setText("EL JUGADOR 3 NO MINTIÓ");
					this.vistaJugando.dialogoAcusacion1.setVisible(true);
					turno=1;
					bandera=true;
					this.vistaJugando.avisoTurno(+1);
				}

				else
				{
					mazoJugador3 = this.modelo.devolverCartasAJugadores(mazoJugador3, mazoCentral);
					this.vistaJugando.lblMentido.setText("EL JUGADOR 3 MINTIÓ");
					this.vistaJugando.dialogoAcusacion2.setVisible(true);
					turno=4;
				}
				mazoCentral = new ArrayList<Integer>();
				System.out.println("EL JUGADOR 4, SELECCIONA UN NUEVO NUMERO EL:" + (numeroInicial=this.modelo.nuevoNumeroSeleccionado(null)));
			}

		}

		//JUGADOR GANADOR
		if (mazoJugador1.isEmpty())
		{
			puntuacionJugador1++;
			this.vistaJugando.lblVictoria.setText("EL JUGADOR 1 " + this.vistaCrearP.textoNombreJugador1.getText() + " HA GANADO");
			this.vistaJugando.dialogoVictoria.setVisible(true);
			//CONECTAMOS A LA BASE DE DATOS
			conexion = this.modelo.conectar();
			//INSERTAR INFORMACIÓN
			this.modelo.crearPartidaNueva(conexion,this.vistaCrearP.textoNombreJugador1.getText(),puntuacionJugador1);
			//CERRAMOS CONEXION
			this.modelo.cerrar(conexion);
		} 
		else if (mazoJugador2.isEmpty())
		{
			puntuacionJugador2++;
			this.vistaJugando.lblVictoria.setText("EL JUGADOR 2 " + this.vistaCrearP.textoNombreJugador2.getText() + " HA GANADO");
			this.vistaJugando.dialogoVictoria.setVisible(true);
			//CONECTAMOS A LA BASE DE DATOS
			conexion = this.modelo.conectar();
			//INSERTAR INFORMACIÓN
			this.modelo.crearPartidaNueva(conexion,this.vistaCrearP.textoNombreJugador2.getText(),puntuacionJugador2);
			//CERRAMOS CONEXION
			this.modelo.cerrar(conexion);
		}
		else if (mazoJugador3.isEmpty())
		{
			puntuacionJugador3++;
			this.vistaJugando.lblVictoria.setText("EL JUGADOR 3 " + this.vistaCrearP.textoNombreJugador3.getText() + " HA GANADO");
			this.vistaJugando.dialogoVictoria.setVisible(true);
			//CONECTAMOS A LA BASE DE DATOS
			conexion = this.modelo.conectar();
			//INSERTAR INFORMACIÓN
			this.modelo.crearPartidaNueva(conexion,this.vistaCrearP.textoNombreJugador3.getText(),puntuacionJugador3);
			//CERRAMOS CONEXION
			this.modelo.cerrar(conexion);
		}
		else if (mazoJugador4.isEmpty())
		{
			puntuacionJugador4++;
			this.vistaJugando.lblVictoria.setText("EL JUGADOR 4 " + this.vistaCrearP.textoNombreJugador4.getText() + " HA GANADO");
			this.vistaJugando.dialogoVictoria.setVisible(true);
			//CONECTAMOS A LA BASE DE DATOS
			conexion = this.modelo.conectar();
			//INSERTAR INFORMACIÓN
			this.modelo.crearPartidaNueva(conexion,this.vistaCrearP.textoNombreJugador4.getText(),puntuacionJugador4);
			//CERRAMOS CONEXION
			this.modelo.cerrar(conexion);
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
