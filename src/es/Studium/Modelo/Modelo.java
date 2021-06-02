package es.Studium.Modelo;


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
				contador3++;
			}

			else if (contador4<12)
			{
				cuatro.add(numeroArepartir);
				contador4++;
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
			//CON EL BOOLEAN CONTROLAMOS QUE NO SE ELIMINEN NUMEROS DUPLICADOS DEL MAZO POR ERROR
			boolean noRepetir = false;
			for(int j=0;j<Mazo.size();j++)
			{
				//si la carta
				if(CartasLanzadas.get(i)==Mazo.get(j) && (noRepetir==false)) 
				{
					Mazo.remove(j);
					noRepetir=true;
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
		Random cantidadCarta = new Random();
		ArrayList<Integer>cartasLanzadas = new ArrayList<Integer>();
		Integer cantidadCartaUsada = cantidadCarta.nextInt(5);
		ArrayList<Integer>cartasLanzadasPosicion = new ArrayList<Integer>();

		//EVITAR QUE EL JUGADOR SELECCIONE LA MISMA CARTA DE LA POSICIÓN
		//SI EL RANDOM SALE 0
		if(mazoJugador.size()<5)
		{

			cantidadCartaUsada = cantidadCarta.nextInt(mazoJugador.size());
		}
		else
		{
			while(cantidadCartaUsada==0)
			{
				cantidadCartaUsada = cantidadCarta.nextInt(5);
			}
		}

		//RECORRE EL ARRAY PARA ESCOGER LAS CARTAS
		for(int i=0; i<cantidadCartaUsada;i++)
		{
			//CONTROLA QUE NO SE REPTITA LA POSICION DE UNA CARTA ELEGIDA
			boolean bandera1 = false;
			while(bandera1==false)
			{ 
				//GENERAMOS EL RANDOM
				Integer posicionCartaElegida = cantidadCarta.nextInt(mazoJugador.size()-1);
				//SI EL ARRAY DE POSICIONES ES VACIO
				if(cartasLanzadasPosicion.size()==0)
				{
					bandera1=true;
					cartasLanzadasPosicion.add(posicionCartaElegida);
					cartasLanzadas.add(mazoJugador.get(posicionCartaElegida));
				}
				//CUANDO YA EXISTE UNA POSICION DENTRO DEL ARRAYLIST
				else
				{
					boolean bandera2=false;
					for(int j=0; j<cartasLanzadasPosicion.size();j++)
					{
						if(cartasLanzadasPosicion.get(j)==posicionCartaElegida)
						{
							bandera2=true;
						}
					}
					//SI NO COINCIDE LA POSICION
					if(bandera2==false)
					{
						bandera1=true;
						cartasLanzadasPosicion.add(posicionCartaElegida);
						cartasLanzadas.add(mazoJugador.get(posicionCartaElegida));
					}
				}

			}
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

	public ArrayList<Integer>devolverCartasAJugadores(ArrayList<Integer>mazoJugador, ArrayList<Integer>mazoCentral)
	{
		for(int i=0; i<mazoCentral.size();i++)
		{
			mazoJugador.add(mazoCentral.get(i));
		}
		return mazoJugador;
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

	//METODO PARA CREAR UNA PARTIDA Y QUE A SU VEZ SE LE ASIGNE ESA PARTIDA AL JUGADOR QUE LA HA CREADO
	public void crearPartidaNueva(Connection conexion,String nombre, int puntuacionJugador) 
	{

		Statement statement = null;
		String sentencia="INSERT INTO jugadores VALUES (null, '" + nombre + "','" + puntuacionJugador + "')";
		try
		{
			//CREAMOS LA SENTENCIA
			statement = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			statement.executeUpdate(sentencia);
			System.out.println(sentencia);
		}
		catch (SQLException e)
		{
			System.out.println("Error al introducir datos."+e.getMessage());
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





