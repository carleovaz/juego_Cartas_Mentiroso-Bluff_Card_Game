package es.Studium.Mentiroso;

import java.util.Random;

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
}
