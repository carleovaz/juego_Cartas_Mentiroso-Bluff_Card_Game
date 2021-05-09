package es.Studium.Mentiroso;

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

public class Controlador implements ActionListener, WindowListener,MouseListener
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

		objvista.buttonCrearJugador.addActionListener(this);
		objvista.buttonCrearPartida.addActionListener(this);
		objvista.buttonMejores.addActionListener(this);
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

//			bd = new BaseDeDatos();
//			connection = bd.conectar();
//			try
//			{
//				sentencia="INSERT INTO peliculas VALUES(null,'"
//						+textoNombrePelicula.getText()+"','"
//						+textoDirectorPelicula.getText()+"','"
//						+textoPrecioPelicula.getText()+"',"
//						//SELECICONAMOS EL PROPIETARIO, SACAMOS EL ITEM ELEGIDO Y NOS QUEDAMOS CON UNICO ELEMENTO
//						+choPropietarios.getSelectedItem().split("-")[0]
//								+")";
//				//CREAMOS SENTENCIA
//				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
//						ResultSet.CONCUR_READ_ONLY);
//				statement.executeUpdate(sentencia);
//				
//			}
//			catch (SQLException sqle)
//			{
//				
//			}

		}
		
		else if(vista.buttonCrearJugador.equals(evento.getSource()))
		{
			vista.ventanaCrearJugador.setVisible(true);
		}

		else if(vista.buttonMejores.equals(evento.getSource()))
		{
			vista.ventanaMejoresJugadores.setVisible(true);	
		}

		else if(vista.buttonComoSeJuega.equals(evento.getSource()))
		{
			vista.ventanaComoSeJuega.setVisible(true);
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
		vista.ventanaPrincipal.setVisible(false);
		vista.ventanaCrearPartida.setVisible(false);
		vista.ventanaCrearJugador.setVisible(false);
		vista.ventanaMejoresJugadores.setVisible(false);
		vista.ventanaComoSeJuega.setVisible(false);
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
