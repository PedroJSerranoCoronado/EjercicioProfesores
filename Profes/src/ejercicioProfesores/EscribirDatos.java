package ejercicioProfesores;

import java.io.*;
import java.util.*;

/* ANALISIS Y DISEÑO
 * 
 * El siguiente programa nos va a permitir escribir los datos de los distintos profesores en un fichero. Para ello se guardarán como objetos
 * para facilitar su escritura y posterior lectura.
 * 
 * ESTUDIO DE LA ESTRUCTURA DE DATOS
 * 
 * Se usarán objetos de tipo Profesor que se guardarán en un fichero binario (de nombre profesores.dat).
 * 
 * PSEUDOCODIGO GENERALIZADO
 * 
 * Inicio Programa Principal
 * 		aperturaFichero
 * 		PARA ()
 * 			generarDatosAleatorios
 * 			crearObjeto
 * 			escribirObjetoEnFichero
 * 		FIN_PARA
 * 		
 * Fin Programa Principal
 */
public class EscribirDatos 
{
	/* INTERFAZ: 
	  * Comentario: este método imprime en pantalla la cabecera del programa.
	  * Precondiciones: no tiene.
	  * Entrada: no tiene.
	  * Salidas: no tiene.
	  * Postcondiciones: no tiene.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: void Presentacion()
	  */
	
	public static void main(String[] args) //throws IOException 
	{
		//Entorno
		File profesores = new File("profesores.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		char sexo;
		int edad;
		String nombre;
		char[] sexos = {'H','M','H','M','H','M','H','M','H','M'};
		int[] edades = {23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60};
		String[] nombres = {"Pedro", "Abraham", "Elena", "Luis", "María", "Josué", "Mario", "Sergio", "Asun", "Leo", "Fernando", "Miguel Ángel", "Nacho", "Javi", "Ignacio", "Gonzaga", "Willy", "Alfonso"};
		Random rnd = new Random();
		
		profesores.delete();
		
		try {
			profesores.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		try 
		{
			//Apertura fichero para escribir
			fos = new FileOutputStream(profesores);
			oos = new ObjectOutputStream(fos);
			
			for (int i = 1; i<=10; i++)
			{
				//generarDatosAleatorios
				sexo = sexos[rnd.nextInt(9)];
				edad = edades[rnd.nextInt(37)];
				nombre = nombres[rnd.nextInt(17)];
				
				//crearObjeto
				Profesor p = new ProfesorImpl(i, nombre, sexo, edad);
				
				//escribirObjetoEnFichero
				oos.writeObject(p);
			}
			
			//cierreFichero
			oos.close();
			fos.close();
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		
		System.out.println("Gracias por usar nuestra aplicación ;)");
	}
}