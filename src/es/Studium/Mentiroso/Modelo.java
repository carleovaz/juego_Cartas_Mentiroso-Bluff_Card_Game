package es.Studium.Mentiroso;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Modelo
{
	Random rnd = new Random();

	public void barajar(int uno[], int dos[])
	{		
		int jugador = 0;
		int numeroArepartir = 1;
		int contador1=0, contador2=0;
		for(int i = 0; i < 48; i++)
		{
			jugador = rnd.nextInt(2);
			if((jugador==0)&&(contador1<24))
			{
				uno[contador1] = numeroArepartir;
				contador1++;
			}
			else if (contador2<24)
			{
				dos[contador2] = numeroArepartir;
				contador2++;
			}
			if(numeroArepartir%12==0)
			{
				numeroArepartir=1;
			}
			else
			{
				numeroArepartir++;
			}
		}
	}

	public void rebarajar(int t[])
	{
		int aleatorio, auxiliar;
		for(int i=0; i<24; i++)
		{
			aleatorio = rnd.nextInt(23)+1;
			auxiliar = t[i];
			t[i] = t[aleatorio];
			t[aleatorio] = auxiliar;
		}
	}

	//METODO CONECTAR
	public Connection conectar()
	{
		Connection c = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/el_mentiroso?serverTimezone=UTC";//ESPECIFICAMOS LA URL
		String Login = "root";
		String password = "Studium2020;";
		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexión con la BD clientes
			c = DriverManager.getConnection(url, Login, password);
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1-"+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2-"+sqle.getMessage());
		}
		return (c);
	}

	public void cerrar(Connection conexion) 
	{
		try
		{
			if(conexion!=null)
			{
				conexion.close();
			}
		}
		catch (SQLException error)
		{
			System.out.println("Error 3-" +error.getMessage());
		}

	}

	public String mejoresJugadores(Connection conexion) 
	{
		String datos ="";
		Statement statement = null;
		ResultSet rs = null;
		String sentencia = "SELECT idJugador, nombreJugador, puntosJugador FROM jugadores ORDER BY puntosJugador DESC;";

		try
		{
			statement = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery(sentencia);
			while(rs.next())
			{
				datos = datos + rs.getInt("idJugador") + "\t";
				datos = datos + rs.getString("nombreJugador")+ "\t";
				datos = datos + rs.getInt("puntosJugador") + "\n";
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return(datos);
	}

	public void ayuda() 
	{
		try 
		{ 
			//EJECUTA EL ARCHIVO DE AYUDA
			Runtime.getRuntime().exec("hh.exe ayuda.chm"); 
		} 
		catch (IOException e) 
		{ 
			e.printStackTrace(); 
		} 
	}

}





