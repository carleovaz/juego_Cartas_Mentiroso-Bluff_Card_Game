package es.Studium.Mentiroso;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class Modelo
{
	Random rnd = new Random();

	//BARAJAMOS LA CARTA DE LOS JUGADORES Y LOS METEMOS EN SUS ARRAYLIST CORRESPONDIENTES
	public void barajar(ArrayList<Integer> uno,ArrayList<Integer>dos, ArrayList<Integer> tres, ArrayList<Integer> cuatro)
	{		
		int jugador = 0;
		int numeroArepartir = 1;
		int contador1=0, contador2=0, contador3=0, contador4=0;
		for(int i = 0; i < 48; i++)
		{
			jugador = rnd.nextInt(4);
			if((jugador==0)&&(contador1<12))
			{
				uno.add(numeroArepartir);
				contador1++;
			}
			else if (contador2<12)
			{
				dos.add(numeroArepartir);
				contador2++;
			}

			else if (contador3<12)
			{
				tres.add(numeroArepartir);
				contador2++;
			}

			else if (contador4<12)
			{
				cuatro.add(numeroArepartir);
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


	//LANZAMIENTO DE CARTAS Y ELIMINACIÓN DE LAS CARTAS LANZADAS DEL MAZO DEL JUGADOR
	public ArrayList<Integer>lanzamientos(ArrayList<Integer>Mazo ,ArrayList<Integer>CartasLanzadas)
	{
		for(int i=0; i<CartasLanzadas.size();i++)
		{
			for(int j=0;j<Mazo.size();j++)
			{
				if(CartasLanzadas.get(i)==Mazo.get(j))
				{
					Mazo.remove(j);
				}
			}
		}

		return Mazo;
	}

	/*METODO POR EL CUAL SELECCIONAMOS CUANTAS CARTAS VA A LANZAR EL JUGADOR CON UN RANDOM, SI 1 O 4
	 * CON EL OTRO RANDOM, POSICIONCARTA, LO QUE HACEMOS ES QUE ESCOJA LAS CARTAS SEGÚN SU POSICION, ES
	 * DECIR ENTRE LA POSICION UNA A 12.
	 */
	public ArrayList<Integer>accionJugador(ArrayList<Integer>mazoJugador) 
	{
		Random cantidadCarta = new Random(4);
		ArrayList<Integer>cartasLanzadas = new ArrayList<Integer>();
		for(int i=0; i<cantidadCarta.nextInt();i++)
		{
			Random posicionCarta = new Random(12);
			cartasLanzadas.add(mazoJugador.get(posicionCarta.nextInt()));				
		}

		return cartasLanzadas;
	}
	
	//METODO POR EL CUAL AÑADIMOS LAS CARTAS LANZADAS AL MAZO CENTRAL
	public ArrayList<Integer>mazoCartaCentral(ArrayList<Integer>mazoCentral, ArrayList<Integer>CartasLanzadas)
	{
		for(int i=0; i<CartasLanzadas.size();i++)
		{
			mazoCentral.add(CartasLanzadas.get(i));
		}

		return mazoCentral;
	}


	//ESCOGEMOS UN NUMERO INICIAL UNA VEZ INICIADA LA PARTIDA, PARA QUE SEA ESE NUMERO EL QUE TENGA QUE LANZAR LOS JUGADORES
	public int numeroInicialSeleccionado(int numero[])
	{
		Math.random();
		int numeroAleatorio = (int) (Math.random()*12+1);
		System.out.println("EL NUMERO INICIAL A LANZAR ES UN: " + numeroAleatorio + " BUENA SUERTE, MENTIROSOS");
		return numeroAleatorio;
	}

	//SI UN JUGADOR LEVANTA A OTRO JUGADOR, SE DEBERA ESCOGER OTRO NUMERO A LANZAR
	public int nuevoNumeroSeleccionado(int numero[])
	{
		Math.random();
		int numeroAleatorio = (int) (Math.random()*12+1);
		System.out.println(numeroAleatorio);
		return numeroAleatorio;
	}


	//METODO CONECTAR BASE DE DATOS
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

	//METODO CERRAR LA CONEXIÓN DE LA BASE DE DATOS
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
	//METODO QUE ME MUESTRA CUALES SON LOS MEJORES JUGADORES SEGUN SUS PUNTOS
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


	//METODO PARA CREAR UN JUGADOR NUEVO
	public String crearJugadorNuevo(Connection conexion) 
	{
		return null;

	}
	//METODO PARA CREAR UNA PARTIDA Y QUE A SU VEZ SE LE ASIGNE ESA PARTIDA AL JUGADOR QUE LA HA CREADO
	public void crearPartidaNueva(Connection conexion,String codigo, String nombre) 
	{
		Statement statement = null;
		String sentencia="INSERT INTO partidas VALUES (null, '" + 
				codigo + "','" + 
				nombre + "')";
		System.out.println(sentencia);
		try
		{
			//CREAMOS LA SENTENCIA
			statement = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			//TOMAMOS EL TEXTO
			statement.executeUpdate(sentencia);
			System.out.println(sentencia);
		}

		catch (SQLException e)
		{
			e.printStackTrace();
		}


	}
	//METODO POR EL CUAL SE ABRE EL "MENU" AYUDA
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





