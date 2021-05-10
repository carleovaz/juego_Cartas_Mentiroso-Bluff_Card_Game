package es.Studium.Mentiroso;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controlador implements ActionListener, WindowListener, MouseListener
{
	BaseDeDatos bd;
	String sentencia = "";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;

	Vista vista;
	Modelo modelo;
	int mazoJugador1[] = new int[24];
	int mazoJugador2[] = new int[24];
	int cartaActualJugador1 = 0;
	int cartaActualJugador2 = 0;
	int puntosJugador1 = 0;
	int puntosJugador2 = 0;
	int turno = 0; // 0 turno jugador 1, 1 turno jugador 2
	int uno, dos;

	public Controlador(Vista objvista, Modelo objmodelo)
	{
		this.vista = objvista;
		this.modelo = objmodelo;
		this.vista.addWindowListener(this);
		this.vista.addMouseListener(this);

		objvista.ventanaPrincipal.addWindowListener(this);
		objvista.ventanaCrearJugador.addWindowListener(this);
		objvista.ventanaCrearPartida.addWindowListener(this);
		objvista.ventanaComoSeJuega.addWindowListener(this);
		objvista.ventanaMejoresJugadores.addWindowListener(this);
		objvista.ventanaJuego.addWindowListener(this);

		objvista.buttonCrearJugador.addActionListener(this);
		objvista.buttonCrearPartida.addActionListener(this);
		objvista.crearJugador.addActionListener(this);
		objvista.buttonMejores.addActionListener(this);
		objvista.buttonIniciarPartida.addActionListener(this);
		objvista.buttonSalir.addActionListener(this);
		objvista.cerrarJugador.addActionListener(this);
		objvista.cerrarPartida.addActionListener(this);
		objvista.buttonComoSeJuega.addActionListener(this);
		objvista.cerrar.addActionListener(this);
		objvista.cerrarAyuda.addActionListener(this);

		objvista.addWindowListener(this);
		objvista.setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent evento) 
	{
		if(vista.buttonCrearPartida.equals(evento.getSource()))
		{
			vista.ventanaCrearPartida.setVisible(true);

		}
		
		else if(vista.buttonComoSeJuega.equals(evento.getSource()))
		{
			vista.ventanaComoSeJuega.setVisible(true);
		}


		else if(vista.buttonIniciarPartida.equals(evento.getSource()))
		{
			bd = new BaseDeDatos();
			connection = bd.conectar();
			try
			{
				//CREAMOS LA SENTENCIA
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				//TOMAMOS EL TEXTO
				if((vista.textoNombrePartida.getText().length()!=0))
				{
					sentencia = "INSERT INTO partidas VALUES (null, '" + 
							vista.textoNombrePartida.getText() + "','" + 
							vista.textoCodigoJugadorPartida.getText() + "')";
					System.out.println(sentencia);
					statement.executeUpdate(sentencia);
					vista.ventanaJuego.setVisible(true);
				}
				else
				{
					vista.partidaCreada.setText("FALLO: Faltan datos, revisa los campos por favor.");
				}
			}
			catch (SQLException sqle)
			{
				vista.partidaCreada.setText("ERROR: Tu partida no pudo ser creada.");
			}
			finally
			{
				vista.dialogoMensajeJugadorCreado.setLayout(new FlowLayout());
				vista.dialogoMensajeJugadorCreado.addWindowListener(this);
				vista.dialogoMensajeJugadorCreado.setSize(430,100);
				vista.dialogoMensajeJugadorCreado.setResizable(false);
				vista.dialogoMensajeJugadorCreado.setLocationRelativeTo(null);
				vista.dialogoMensajeJugadorCreado.add(vista.partidaCreada);
				vista.dialogoMensajeJugadorCreado.setVisible(true);
			}
		}

		else if(vista.buttonCrearJugador.equals(evento.getSource()))
		{
			vista.ventanaCrearJugador.setVisible(true);
		}
		
		//AGREGAMOS LOS DATOS DEL NOMBRE DEL JUGADOR EN LA BASE DE DATOS
		else if(vista.crearJugador.equals(evento.getSource()))
		{
			bd = new BaseDeDatos();
			connection = bd.conectar();
			try
			{
				//CREAMOS LA SENTENCIA
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				//TOMAMOS EL TEXTO

				if((vista.textoNombreJugador.getText().length()!=0))
				{
					sentencia = "INSERT INTO jugadores VALUES ('" + 
							vista.textocodigoJugador.getText() + "','" + 
							vista.textoNombreJugador.getText() + "'," + 
							"null)";
					System.out.println(sentencia);
					statement.executeUpdate(sentencia);
				}
				else
				{
					vista.perfilCreado.setText("FALLO: Faltan datos, revisa los campos por favor.");
				}
			}
			catch (SQLException sqle)
			{
				vista.perfilCreado.setText("ERROR: ese codigo ya pertenece a otro jugador, introduce otro por favor.");
			}
			finally
			{
				vista.dialogoMensajeJugadorCreado.setLayout(new FlowLayout());
				vista.dialogoMensajeJugadorCreado.addWindowListener(this);
				vista.dialogoMensajeJugadorCreado.setSize(430,100);
				vista.dialogoMensajeJugadorCreado.setResizable(false);
				vista.dialogoMensajeJugadorCreado.setLocationRelativeTo(null);
				vista.dialogoMensajeJugadorCreado.add(vista.perfilCreado);
				vista.dialogoMensajeJugadorCreado.setVisible(true);
			}
		}

		else if(vista.buttonMejores.equals(evento.getSource()))
		{
			vista.ventanaMejoresJugadores.setVisible(true);	
		}


		//BOTONES QUE CIERRAN VENTANAS
		if(vista.buttonSalir.equals(evento.getSource()))
		{
			System.exit(0);
		}

		else if(vista.cerrarJugador.equals(evento.getSource()))
		{
			vista.ventanaCrearJugador.setVisible(false);

		}

		else if(vista.cerrarPartida.equals(evento.getSource()))
		{
			vista.ventanaCrearPartida.setVisible(false);

		}

		else if(vista.cerrar.equals(evento.getSource()))
		{
			vista.ventanaMejoresJugadores.setVisible(false);
		}

		else if(vista.cerrarAyuda.equals(evento.getSource()))
		{
			vista.ventanaComoSeJuega.setVisible(false);
		}

	}

	public void windowClosing(WindowEvent arg0) 
	{
		vista.dialogoMensajeJugadorCreado.setVisible(false);
		vista.dialogoMensajePartidaCreada.setVisible(false);
		vista.ventanaPrincipal.setVisible(false);
		vista.ventanaCrearPartida.setVisible(false);
		vista.ventanaCrearJugador.setVisible(false);
		vista.ventanaMejoresJugadores.setVisible(false);
		vista.ventanaComoSeJuega.setVisible(false);
		vista.ventanaJuego.setVisible(false);
	}


	public void mouseClicked(MouseEvent arg0) {

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
