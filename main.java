//Lupoli Michele 
//Inserite le misurazioni di temperature di 10 città nell'arco di 24 ore, calcolare temperatura Max e Min per ogni città
import java.io.*;
public class MatriceCittà {
	public static void main (String args[])
	{
		//Impostazione standard input
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);
		
		//Dichiarazione variabili
		String città[] = new String[10];
		int temp[][] = new int[100][100];
		final int riga = 2, colonna = 4;
		int i, j, min = 1000, max = temp[0][0];
		int media, somma = 0;
		int x=0, y=0;
		
		//Inserimento città nel vettore
		for (i=0; i<riga; i++)
		{
			System.out.print("Inserisci la città n. "+i+": ");
			try {
				città[i] = tastiera.readLine();
				}
			catch (Exception e)
			{
				System.out.println("Il valore inserito non è valido! ");
				i--;
			}
		}
	
		//Inserimento temperature nella matrice e successiva stampa di temperatura massima/minima/media
		for (i=0; i<riga; i++)
		{
			somma = 0;
			System.out.println("Città: " + città[i]);
			for (j=0; j<colonna; j++)
			{
				System.out.print("Inserisci la temperatura registrata alle ore "+j+": ");
				try {
					String numeroLetto = tastiera.readLine();
					temp[i][j] = Integer.valueOf(numeroLetto).intValue();
					}
				catch (Exception e)
					{
					System.out.println("Il valore inserito non è valido! ");
					i--;
					}
				
				//Calcolo massimo e minimo
				if (temp[i][j] > max)
				{
					max = temp[i][j];
					y = j;
				}
				if (temp[i][j] < min)
				{
					min = temp[i][j];
					x = j;
				}
				somma = somma + temp[i][j];    						//Somma le temperature
			}
				media = somma / colonna;      						//Fa la media delle temperature
				//Stampa la temperatura media/massima/minima
				System.out.println("La temperatura media nella città di "+"'"+città[i]+"'"+" è di "+media+"° gradi");
				System.out.println("La temperatura minima nella città di "+"'"+città[i]+"'"+" si è verificata alle ore "+x+" ed è di "+min+"° gradi");
				System.out.println("La temperatura massima nella città di "+"'"+città[i]+"'"+" si è verificata alle ore "+y+" ed è di "+max+"° gradi");
				System.out.println(" ");  //Va a capo per creare uno spazio
		}
	}
}
