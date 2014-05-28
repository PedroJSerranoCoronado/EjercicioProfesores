package ejercicioProfesores;

import java.io.*;
import java.util.ArrayList;

/* CLASE DE UTILIDADES
 * 
 * El propósito de esta clase es manejar el fichero de profesores para las distintas operaciones.
 * 
 * Métodos:
 * 		edadPromedio
 * 		profesorMasJoven
 * 		profesorMasMayor
 * 		profesoresEncimaMedia
 * 		profesoresDebajoMedia
 * 		nuevoRegistro
 * 		borrarRegistros
 * 		ordenarFichero
 * 		listadoProfesores
 * 
 */
public class UtilidadesProfesor
{	
	//Atributos
	private FileInputStream fis;
	private ObjectInputStream ois;
	
	private FileOutputStream fos;
	private ObjectOutputStreamPropia oosp;
	private ObjectOutputStream oos;
	
	
	/* INTERFAZ: 
	  * Comentario: este método calcula la edad media de una lista de profesores.
	  * Precondiciones: no tiene.
	  * Entrada: una cadena que será la ruta al fichero donde están los profesores.
	  * Salidas: un real.
	  * Postcondiciones: el valor devuelto es la edad media de los profesores.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: double edadPromedio(String rutaProfesores)
	  */
	public double edadPromedio(String rutaProfesores) throws ClassNotFoundException
	{
		double contador=0.0, edadPro = 0.0;
		int edadTotal=0;
		//File profesores = new File(rutaProfesores);
		Profesor aux = null;
		
		try {
			// Abrir archivo para lectura
			fis = new FileInputStream(rutaProfesores);
			ois = new ObjectInputStream(fis);
			
			// Leer primer objeto
			aux = (ProfesorImpl) ois.readObject();
			
			// Leer los demás objetos
			while(aux!=null)
			{
				if(aux instanceof ProfesorImpl)
				{
					// sumar edad
					edadTotal = edadTotal + aux.getEdad();
					
					// aumentar contador
					contador++;
					
					//Leemos el siguiente registro
					try {
						aux = (ProfesorImpl) ois.readObject();
					}  catch (EOFException e) {
						//e.printStackTrace();
						aux=null;
					}
				}
			}
			
			// calcular edad media
			edadPro = edadTotal/contador;
			
			// cerrar flujos
			ois.close();
			fis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return edadPro;
	}
	
	/* INTERFAZ: 
	  * Comentario: el método recorre la lista de profesores buscando el más joven de todos ellos.
	  * Precondiciones: no tiene.
	  * Entrada: una cadena que será la ruta al fichero donde están los profesores.
	  * Salidas: una cadena.
	  * Postcondiciones: la cadena devuelta es el nombre del profesor mas joven.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: string profesorMasJoven(String rutaProfesores)
	  */
	public String profesorMasJoven(String rutaProfesores) throws ClassNotFoundException 
	{
		//System.out.println("Método en construcción");
		
		String joven = null;
		int edad=Integer.MAX_VALUE, edadAux=0;
		//File profesores = new File(rutaProfesores);
		Profesor aux = null;
				
		try {
			// Abrir archivo para lectura
			fis = new FileInputStream(rutaProfesores);
			ois = new ObjectInputStream(fis);
					
			// Leer primer objeto
			try {
				aux = (ProfesorImpl) ois.readObject();
			}  catch (EOFException e) {
				//e.printStackTrace();
				aux=null;
			}
					
			while(aux!=null)
			{
				edadAux = aux.getEdad();
						
				if (edadAux<edad) // comparamos las edades
				{
					// Asignar menor edad
					edad=edadAux;
					// Asignar nombre del menor profesor
					joven= aux.getNombre();
				}
						
				//Leemos el siguiente registro
				try {
					aux = (ProfesorImpl) ois.readObject();
				}  catch (EOFException e) {
					//e.printStackTrace();
					aux=null;
				}
			}
					
			// Cerrar fichero
			ois.close();
			fis.close();
					
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		return joven;
	}
	
	/* INTERFAZ: 
	  * Comentario: este método recorre la lista de profesores y busca el de más edad de todos ellos.
	  * Precondiciones: no tiene.
	  * Entrada: una cadena que será la ruta al fichero donde están los profesores.
	  * Salidas: una cadena.
	  * Postcondiciones: la cadena devuelta es el nombre del profesor de mayor edad.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: string profesorMasMayor(String rutaProfesores)
	  */
	public String profesorMasMayor(String rutaProfesores)
	{
		//System.out.println("Método en construcción");
		
		String s = "javier";
				
		return s;
	}
	
	/* INTERFAZ: 
	  * Comentario: este método recorre la lista de profesores y busca aquellos que tienen una edad justo por encima de la edad media.
	  * Precondiciones: no tiene.
	  * Entrada: una cadena que será la ruta al fichero donde están los profesores.
	  * Salidas: un entero.
	  * Postcondiciones: el entero de salida es el numero de profesores cuya edad esta por encima de la media.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: int profesoresEncimaMedia(String rutaProfesores)
	  */
	public int profesoresEncimaMedia(String rutaProfesores) throws ClassNotFoundException
	{
		// System.out.println("Método en construcción");
		
		int viejos = 0;
		double media=0.0;
		Profesor aux = null;
				
		try {
			// Abrir archivo para lectura
			fis = new FileInputStream(rutaProfesores);
			ois = new ObjectInputStream(fis);
					
			// Calcular media
			media = edadPromedio(rutaProfesores);
					
			// Leer el primer objeto
			try {
				aux = (ProfesorImpl) ois.readObject();
			}  catch (EOFException e) {
				//e.printStackTrace();
				aux=null;
			}
					
			while(aux!=null)
			{
				// Aumentar contador de viejos
				if (aux.getEdad()>media) {
					viejos++;
				}
						
				try {
					aux = (ProfesorImpl) ois.readObject();
				}  catch (EOFException e) {
					//e.printStackTrace();
					aux=null;
				}
			}
					
			// Cerrar fichero
			fis.close();
			ois.close();
					
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		return viejos;
	}
	
	/* INTERFAZ: 
	  * Comentario: este método recorre la lista de profesores y busca aquellos que tienen una edad justo por debajo de la edad media.
	  * Precondiciones: no tiene.
	  * Entrada: una cadena que será la ruta al fichero donde están los profesores.
	  * Salidas: un entero.
	  * Postcondiciones: el entero de salida es el numero de profesores cuya edad esta por debajo de la media.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: int profesoresDebajoMedia(String rutaProfesores)
	  */
	public int profesoresDebajoMedia(String rutaProfesores)
	{
		//System.out.println("Método en construcción");
		
		int jovenes=2;
				
		return jovenes;
	}
	
	/* INTERFAZ: 
	  * Comentario: este método añade un registro al fichero de movimientos para borrar.
	  * Precondiciones: no tiene.
	  * Entrada: una cadena, ruta del fichero de movimientos.
	  * Salidas: un booleano.
	  * Postcondiciones: el fichero de movimientos queda modificado con la baja introducida.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: boolean borrarRegistros(String ficheroMaster, String ficheroMov)
	  */
	public boolean borrarRegistros(String ficheroMov)
	{	
		//System.out.println("En construcción.");
		
		File profesoresMov = new File(ficheroMov);
		boolean exito = false;
		char sexo = ' ';
		int edad = 0, id = 0;
		String nombre = null;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		
		try 
		{
			//leerID
			do
			{
				System.out.println("Introduzca el id del profesor: ");
				try
				{
					id=Integer.parseInt(br.readLine());
				} catch (Exception e)
				{
					id = -1;
				}
				if(id<0)
					System.out.println("Id incorrecta, debe ser mayor que 0.");
			}while(id<0);
			
			//leerNombre
			System.out.print("Introduzca el nombre del profesor: ");
			try {
				nombre=br.readLine();
			} catch (IOException e1) {
				//e1.printStackTrace();
				nombre = "default";
			}
			
			//leerYValidarEdad
			do
			{
				System.out.print("\nIntroduzca la edad del profesor: ");
				try
				{
					edad=Integer.parseInt(br.readLine());
				} catch (Exception e)
				{
					edad = -1;
				}
				if(edad<0)
					System.out.println("Edad incorrecta, debe ser mayor que 0.");
			}while(edad<0);
			
			//leerYValidarSexo
			do
			{
				System.out.print("\nIntroduzca el sexo del profesor (H/M): ");
				try {
					sexo=br.readLine().charAt(0);
				} catch (IOException e) {
					//e.printStackTrace();
					sexo = ' ';
				}
				if(sexo!='H' && sexo!='M')
					System.out.println("Sexo incorrecto, debe elegir 'H' o 'M'.");
			}while(sexo!='H' && sexo!='M');
			
			//crearObjeto
			ProfesorImpl p = new ProfesorImpl(id, nombre, sexo, edad);
			
			//Apertura fichero para escribir
			fos = new FileOutputStream(profesoresMov,true);
			oos = new ObjectOutputStream(fos);
			
			//comprobacion si el fichero existe
			if(!profesoresMov.exists())
				profesoresMov.createNewFile();		//si no existe, lo creamos
			
			//escribirObjetoEnFichero
			oos.writeObject(p);
				
			//cierreFichero
			oos.close();
			fos.close();
			
			exito = true;
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		
		return exito;
	}
	
	/* INTERFAZ: 
	  * Comentario: este método añade un nuevo registro al fichero Maestro.
	  * Precondiciones: no tiene.
	  * Entrada: una cadena (ruta del fichero Maestro).
	  * Salidas: un booleano.
	  * Postcondiciones: se añade un nuevo registro al fichero.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: boolean nuevoRegistro(String ficheroMaster)
	  */
	public boolean nuevoRegistro(String ficheroMaster)
	{
		File profesores = new File(ficheroMaster);
		boolean exito = false;
		char sexo = ' ';
		int edad = 0, id = 0;
		String nombre = null;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		
		try 
		{
			//leerID
			do
			{
				System.out.println("Introduzca el id del profesor: ");
				try
				{
					id=Integer.parseInt(br.readLine());
				} catch (Exception e)
				{
					id = -1;
				}
				if(id<0)
					System.out.println("Id incorrecta, debe ser mayor que 0.");
			}while(id<0);
			
			//leerNombre
			System.out.print("Introduzca el nombre del profesor: ");
			try {
				nombre=br.readLine();
			} catch (IOException e1) {
				//e1.printStackTrace();
				nombre = "default";
			}
			
			//leerYValidarEdad
			do
			{
				System.out.print("\nIntroduzca la edad del profesor: ");
				try
				{
					edad=Integer.parseInt(br.readLine());
				} catch (Exception e)
				{
					edad = -1;
				}
				if(edad<0)
					System.out.println("Edad incorrecta, debe ser mayor que 0.");
			}while(edad<0);
			
			//leerYValidarSexo
			do
			{
				System.out.print("\nIntroduzca el sexo del profesor (H/M): ");
				try {
					sexo=br.readLine().charAt(0);
				} catch (IOException e) {
					//e.printStackTrace();
					sexo = ' ';
				}
				if(sexo!='H' && sexo!='M')
					System.out.println("Sexo incorrecto, debe elegir 'H' o 'M'.");
			}while(sexo!='H' && sexo!='M');
			
			//crearObjeto
			ProfesorImpl p = new ProfesorImpl(id, nombre, sexo, edad);
			
			//Apertura fichero para escribir
			fos = new FileOutputStream(profesores,true);
			oosp = new ObjectOutputStreamPropia(fos);
			
			//escribirObjetoEnFichero
			oosp.writeObject(p);
				
			//cierreFichero
			oosp.close();
			fos.close();
			
			exito = true;
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		
		return exito;
	}
	
	/* INTERFAZ: 
	  * Comentario: este método muestra en pantalla los profesores guardados en el fichero.
	  * Precondiciones: no tiene.
	  * Entrada: no tiene.
	  * Salidas: un arrayList de profesores.
	  * Postcondiciones: no tiene.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: ArrayList<Profesor> listadoProfesores()
	  */

	public ArrayList<Profesor> listadoProfesores(String rutaProfesores)
	{
		ArrayList<Profesor> lista = new ArrayList<Profesor>();
		Profesor p;
		
		try {
			// Abrir archivo para lectura
			fis = new FileInputStream(rutaProfesores);
			ois = new ObjectInputStream(fis);
			
			//lectura inicial
			p = (ProfesorImpl) ois.readObject();
			
			while (p!= null)
			{
				//añadimos el objeto a la lista
				lista.add(p);
				
				//actualización
				try
				{
					p = (ProfesorImpl) ois.readObject();
				} catch (EOFException e)
				{
					p = null;
				}
			}
			
			// Cerrar fichero
			fis.close();
			ois.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}
	
	/* INTERFAZ: 
	  * Comentario: este método recibe un arrayList de profesores y guarda cada objeto en un fichero de texto.
	  * Precondiciones: no tiene.
	  * Entrada: un ArrayList de profesores.
	  * Salidas: no tiene.
	  * Postcondiciones: no tiene.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: void arrayATexto(ArrayList<ProfesorImpl> lista)
	  */
	public void arrayATexto(ArrayList<Profesor> lista)
	{
		File fichero = new File("listaProfes.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		//String cabecera = "NOMBRE    EDAD    SEXO";
		
		try {
			//Apertura para escribir
			fw = new FileWriter(fichero);
			bw = new BufferedWriter(fw);
			
			//Creamos el fichero
			if(fichero.exists())
				fichero.delete();
			
			fichero.createNewFile();
			
			//Escribimos la cabecera
			//bw.write(cabecera);
			//bw.newLine();
			
			//Bucle para escribir los objetos del array
			for (int i = 0; i < lista.size(); i++) 
			{
				bw.write(lista.get(i).writer());
				bw.newLine();
			}
			bw.flush();
			
			//cerramos fichero
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/* INTERFAZ: 
	  * Comentario: este método actualiza el fichero Maestro de acuerdo a los registros del fichero de Movimientos.
	  * Precondiciones: no tiene.
	  * Entrada: dos cadenas, una la ruta al fichero Maestro y la otra la ruta al fichero de movimientos.
	  * Salidas: un booleano.
	  * Postcondiciones: el fichero estará ordenado por edad.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: boolean actualizarFichero(String fichero, String ficheroMov)
	  */
	public boolean actualizarFichero(String fichero, String ficheroMov)
	{
		boolean actualizado = false;
		//herramientas fichero maestro
		File maestro = new File(fichero);
		FileInputStream fisMas;
		ObjectInputStream oisMas;
		
		//herramientas fichero movimiento
		File movimientos = new File(ficheroMov);
		FileInputStream fisMov;
		ObjectInputStream oisMov;
		
		//herramientas fichero actualizado
		File profesoresAct = new File("ficheroAct.dat");
		
		Profesor pMas;
		Profesor pMov;
		
		try {
			// Abrir archivo maestro para lectura
			fisMas = new FileInputStream(maestro);
			oisMas = new ObjectInputStream(fisMas);
			
			// Abrir archivo movimientos para lectura
			fisMov = new FileInputStream(ficheroMov);
			oisMov = new ObjectInputStream(fisMov);
			
			//Apertura fichero actualizado para escribir
			fos = new FileOutputStream(profesoresAct);
			oos = new ObjectOutputStream(fos);
			
			if(!profesoresAct.exists())		//comprobamos si existe el fichero actualizado
				profesoresAct.createNewFile();	//si no existe lo creamos
			
			//leer registro Mov
			pMov = (ProfesorImpl) oisMov.readObject();
			
			//leerRegistro Mas
			pMas = (ProfesorImpl) oisMas.readObject();
			
			while(pMov != null && pMas != null)
			{
				if(pMov.getId() == pMas.getId())	//Si los id son iguales, consideramos que con la misma persona
				{
					if(!pMov.equals(pMas))	/*si el valor de sus atributos, exceptuando id, son diferentes, consideramos 
					que fue modificacion y escribiremos en el fichero actualizado el registro leido desde el fichero de movimientos.
					en caso contrario, al ser sus atributos iguales, se considerará baja y no se escribirá ningun registro en el
					fichero actualizado.*/
					{
						//escribimos el registro leido del fichero de movimientos en el fichero actualizado
						oos.writeObject(pMov);
					}
					
					//leemos nuevos registros de los ficheros de movimiento y el maestro
					try
					{
						pMov = (ProfesorImpl) oisMov.readObject();
					} catch (EOFException e)
					{
						//System.out.println(e.getMessage());
						pMov = null;
					}
					
					try
					{
						pMas = (ProfesorImpl) oisMas.readObject();
					} catch (EOFException e)
					{
						//System.out.println(e.getMessage());
						pMas = null;
					}
					
				}//fin si para los id iguales
				else			//Si los id no son iguales
				{
					if(pMov.getId() > pMas.getId())		//Si el id del registro leido del fichero movimientos mayor que del registro del fichero maestro
					{
						/*Hay registros en el fichero de maestro que no tienen movimientos en el fichero de movimientos, y deben
						 * en el fichero actualizado*/
						while((pMov.getId() > pMas.getId()) && pMas != null)
						{
							//escribimos en el fichero actualizado
							oos.writeObject(pMas);
							
							//leemos del fichero maestro
							try
							{
								pMas = (ProfesorImpl) oisMas.readObject();
							} catch (EOFException e)
							{
								//System.out.println(e.getMessage());
								pMas = null;
							}
						}
					}//fin if idMov mayor idMas
					else		//Si el id del registro leido del fichero de movimientos es menor que del registro del fichero maestro
					{
						/*Es un alta, asi que escribimos el registro leido desde movimientos en el fichero actualizado*/
						
						//escribimos en el fichero actualizado
						oos.writeObject(pMov);
						
						//leemos desde el fichero de movimientos
						try
						{
							pMov = (ProfesorImpl) oisMov.readObject();
						} catch (EOFException e)
						{
							//System.out.println(e.getMessage());
							pMov = null;
						}
					}//fin else idMov menor idMas
				}//fin else donde los id son diferentes
			}//fin while
			
			/*Ahora debemos tener en cuenta que es posible que uno de los dos ficheros no se haya recorrido entero, y 
			debemos escribir los registros restantes*/
			
			while(pMov != null)		//bucle while para el caso en el que no se haya terminado el fichero de movimientos
			{
				//escribimos en el fichero actualizado
				oos.writeObject(pMov);
				
				//leemos desde el fichero de movimientos
				try
				{
					pMov = (ProfesorImpl) oisMov.readObject();
				} catch (EOFException e)
				{
					//System.out.println(e.getMessage());
					pMov = null;
				}
			}//fin while
			
			while(pMas != null)		//bucle while para el caso en el que no se haya terminado el fichero maestro
			{
				//escribimos en el fichero actualizado
				oos.writeObject(pMas);
				
				//leemos desde el fichero de movimientos
				try
				{
					pMas = (ProfesorImpl) oisMas.readObject();
				} catch (EOFException e)
				{
					//System.out.println(e.getMessage());
					pMas = null;
				}
			}//fin while
			
			// Cerrar ficheros
			fisMas.close();
			oisMas.close();
			
			fisMov.close();
			oisMov.close();
			
			fis.close();
			oos.close();
			
			actualizado = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{	//cambiamos el nombre, y al fichero actualizado le ponemos el del fichero maestro, borrando el fichero maestro anterior
			maestro.delete();
			profesoresAct.renameTo(maestro);
		}
		
		return actualizado;
	}
	
	/* INTERFAZ: 
	  * Comentario: este método ordena el fichero, de acuerdo a la edad, de forma externa mediante el método de mezcla.
	  * Precondiciones: no tiene.
	  * Entrada: una cadena (ruta del fichero a ordenar).
	  * Salidas: no tiene.
	  * Postcondiciones: el fichero estará ordenado por edad.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: void ordenarFicheroEdad()
	  */

	public void ordenarFicheroEdad(String ficheroMaestro) throws ClassNotFoundException
	{
		//System.out.println("En construccion");
		int numeroRegistros = 0;
		
		numeroRegistros = contarRegistros(ficheroMaestro);
		
		for(int secuencia = 1; secuencia <= numeroRegistros; )
		{
			//llamada a partir fichero
			partir(ficheroMaestro, secuencia);
			
			//llamada a mezclar fichero
			mezclar(secuencia);
			
			//actualizamos la secuencia
			secuencia = secuencia * 2;
		}
	}
	
	/* INTERFAZ: 
	  * Comentario: este método cuenta el numero de registros que tiene un fichero.
	  * Precondiciones: no tiene.
	  * Entrada: una cadena (ruta del fichero a ordenar).
	  * Salidas: un entero.
	  * Postcondiciones: ASN se devuelve el numero de registros del fichero.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: int contarRegistros(String ficheroMaestro)
	  */
	public int contarRegistros(String ficheroMaestro) throws ClassNotFoundException
	{
		int cont = 0;
		Profesor aux;
		
		try {
			// Abrir archivo para lectura
			fis = new FileInputStream(ficheroMaestro);
			ois = new ObjectInputStream(fis);
			
			// Leer primer objeto
			aux = (ProfesorImpl) ois.readObject();
			
			// Leer los demás objetos
			while(aux!=null)
			{
				// aumentar contador
				cont++;
					
				//Leemos el siguiente registro
				try {
					aux = (ProfesorImpl) ois.readObject();
				}  catch (EOFException e) {
					//e.printStackTrace();
					aux=null;
				}
			}
			
			// cerrar flujos
			ois.close();
			fis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		return cont;
	}
	
	/* INTERFAZ: 
	  * Comentario: este método parte el fichero maestro en dos fichero auxiliares, para su posterior mezcla, siguiendo una
	  * secuencia.
	  * Precondiciones: no tiene.
	  * Entrada: una cadena (ruta del fichero a ordenar) y un entero (secuencia a seguir para partir).
	  * Salidas: no tiene.
	  * Postcondiciones: se crean dos ficheros auxiliares con los datos repartidos del fichero maestro, que es borrado.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: void partir(String ficheroMaestro, int secuencia)
	  */
	public void partir(String ficheroMaestro, int secuencia)
	{
		int secAux1, secAux2;
		Profesor p = null;
		
		//herramientas para el fichero auxiliar1
		File aux1 = new File("auxiliar1.dat");
		FileOutputStream fosA1;
		ObjectOutputStream oosA1;
		
		//herramientas para el fichero auxiliar1
		File aux2 = new File("auxiliar2.dat");
		FileOutputStream fosA2;
		ObjectOutputStream oosA2;
		
		//herramientas para el fichero maestro
		File maestro = new File(ficheroMaestro);
		FileInputStream fisM;
		ObjectInputStream oisM;
		
		try
		{
			//apertura fichero maestro para leer
			fisM = new FileInputStream(maestro);
			oisM = new ObjectInputStream(fisM);
			
			//apertura ficharo auxiliar1 para escribir
			if(!aux1.exists())
				aux1.createNewFile();
			fosA1 = new FileOutputStream(aux1);
			oosA1 = new ObjectOutputStream(fosA1);
			
			//apertura ficharo auxiliar2 para escribir
			if(!aux2.exists())
				aux2.createNewFile();
			fosA2 = new FileOutputStream(aux2);
			oosA2 = new ObjectOutputStream(fosA2);
			
			//lectura primer registro del fichero maestro
			try
			{
				p = (ProfesorImpl) oisM.readObject();
			} catch (EOFException e)
			{
				//e.printStackTrace();
				p = null;
			}
			
			//bucle para recorrer el fichero maestro
			while(p != null)
			{
				//bucle para partir fichero maestro en secuencias y guardar registros en auxiliar1
				for(secAux1 = 1; p != null && secAux1 <= secuencia; secAux1++)
				{
					//guardamos registro del fichero maestro en auxiliar1
					oosA1.writeObject(p);
					
					//leemos registro fichero maestro
					try
					{
						p = (ProfesorImpl) oisM.readObject();
					} catch (EOFException e)
					{
						//e.printStackTrace();
						p = null;
					}
				}//fin bucle
				
				//bucle para partir fichero maestro en secuencias y guardar registros en auxiliar2
				for(secAux2 = 1; p != null && secAux2 <= secuencia; secAux2++)
				{
					//guardamos registro del fichero maestro en auxiliar1
					oosA2.writeObject(p);
					
					//leemos registro fichero maestro
					try
					{
						p = (ProfesorImpl) oisM.readObject();
					} catch (EOFException e)
					{
						//e.printStackTrace();
						p = null;
					}
				}//fin bucle
			}
			
			//cerrar ficheros
			oosA1.close();
			oosA2.close();
			oisM.close();
			
			//borramosFicheroMaestro
			//maestro.delete();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/* INTERFAZ: 
	  * Comentario: este método mezcla los dos ficheros auxiliares siguiendo una secuencia, ordenandolos en un fichero
	  * maestro
	  * Precondiciones: no tiene.
	  * Entrada: una cadena (ruta del fichero a ordenar) y un entero (secuencia a seguir para mezclar).
	  * Salidas: no tiene.
	  * Postcondiciones: se crea un fichero maestro con los registros ordenados de acuerdo a una secuencia. Los ficheros
	  * auxiliares son borrados.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: void partir(String ficheroMaestro, int secuencia)
	  */
	
	public void mezclar(int secuencia)
	{
		int secAux1, secAux2;
		Profesor pA1 = null;
		Profesor pA2 = null;
		
		//herramientas para el fichero maestro
		File maestro = new File("profesores.dat");
		FileOutputStream fosM;
		ObjectOutputStream oosM;
		
		//herramientas para el fichero auxiliar1
		File aux1 = new File("auxiliar1.dat");
		FileInputStream fisAux1;
		ObjectInputStream oisAux1;
		
		//herramientas para el fichero auxiliar1
		File aux2 = new File("auxiliar2.dat");
		FileInputStream fisAux2;
		ObjectInputStream oisAux2;
		
		try
		{
			//creacion fichero maestro y apertura para escribir
			if(!maestro.exists())
				maestro.createNewFile();
			fosM = new FileOutputStream(maestro);
			oosM = new ObjectOutputStream(fosM);
			
			//apertura fichero auxiliar1 para leer
			fisAux1 = new FileInputStream(aux1);
			oisAux1 = new ObjectInputStream(fisAux1);
			
			//apertura fichero auxiliar2 para leer
			fisAux2 = new FileInputStream(aux2);
			oisAux2 = new ObjectInputStream(fisAux2);
			
			//leemos primer registro del fichero auxiliar1
			try
			{
				pA1 = (ProfesorImpl) oisAux1.readObject();
			} catch (EOFException e)
			{
				pA1 = null;
			}
			
			//leemos primer registro del fichero auxiliar2
			try
			{
				pA2 = (ProfesorImpl) oisAux2.readObject();
			} catch (EOFException e)
			{
				pA2 = null;
			}
			
			//bucle mientras
			while(pA1 != null && pA2 != null)
			{
				for(secAux1 = 1, secAux2 = 1; secAux1 <= secuencia && secAux2 <= secuencia && pA1 != null && pA2 != null; )
				{
					if(pA1.getEdad() <= pA2.getEdad())	//si edad del registro de auxisliar1 menor que la del auxiliar2
					{
						//escribimos el registro de auxiliar1 en el fichero maestro
						oosM.writeObject(pA1);
						
						//leemos registro de auxiliar1
						try
						{
							pA1 = (ProfesorImpl) oisAux1.readObject();
						} catch (EOFException e)
						{
							pA1 = null;
						}
						
						//aumentamos la secuencia del fichero auxiliar1
						secAux1++;
					}//fin si edad del registro de auxiliar1 menor que auxiliar2
					else	//si no
					{
						//escribimos el registro de auxuliar2 en el fichero maestro
						oosM.writeObject(pA2);
							
						//leemos registro de auxiliar2
						try
						{
							pA2 = (ProfesorImpl) oisAux2.readObject();
						} catch (EOFException e)
						{
							pA2 = null;
						}
						//aumentamos la secuencia del fichero auxiliar2
						secAux2++;
					}//fin else
				}//fin bucle for
				
				//si no se ha completado la secuencia con el fichero auxiliar1
				if(secAux1 <= secuencia)
				{
					//mientras no FF
					while(pA1 != null && secAux1 <= secuencia)
					{
						//escribimos registro de auxiliar1 en fichero maestro
						oosM.writeObject(pA1);
						
						//leemos registro de auxiliar1
						try
						{
							pA1 = (ProfesorImpl) oisAux1.readObject();
						} catch (EOFException e)
						{
							pA1 = null;
						}
						//aumentamos la secuencia de auxiliar1
						secAux1++;
					}
				}//fin si
				
				//si no se ha completado la secuencia con el fichero auxiliar2
				if(secAux2 <= secuencia)
				{
					//mientras no FF
					while(pA2 != null && secAux2 <= secuencia)
					{
						//escribimos el registro de auxuliar2 en el fichero maestro
						oosM.writeObject(pA2);
						
						//leemos registro de auxiliar2
						try
						{
							pA2 = (ProfesorImpl) oisAux2.readObject();
						} catch (EOFException e)
						{
							pA2 = null;
						}
						//aumentamos la secuencia de auxiliar2
						secAux2++;
					}
				}//fin si
			}//fin while
			
			//si no se alcanzo FF de auxiliar1
			while(pA1 != null)
			{
				//escribimos registro de auxiliar1 en fichero maestro
				oosM.writeObject(pA1);
				
				//leemos registro de auxiliar1
				try
				{
					pA1 = (ProfesorImpl) oisAux1.readObject();
				} catch (EOFException e)
				{
					pA1 = null;
				}
			}
			
			//si no se alcanzo FF de auxiliar2
			while(pA2 != null)
			{
				//escribimos el registro de auxuliar2 en el fichero maestro
				oosM.writeObject(pA2);
				
				//leemos registro de auxiliar2
				try
				{
					pA2 = (ProfesorImpl) oisAux2.readObject();
				} catch (EOFException e)
				{
					pA2 = null;
				}
			}
			
			//cerramos ficheros
			oisAux1.close();
			oisAux2.close();
			oosM.close();
			
			//borramos ficheros auxiliares
			//aux1.delete();
			//aux2.delete();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void pintar(String ruta)
	{
		Profesor p;
		
		try {
			// Abrir archivo para lectura
			fis = new FileInputStream(ruta);
			ois = new ObjectInputStream(fis);
			
			//lectura inicial
			try
			{
				p = (ProfesorImpl) ois.readObject();
			} catch (EOFException e)
			{
				p = null;
			}
			
			while (p!= null)
			{
				System.out.println(p.writer());
				
				//actualización
				try
				{
					p = (ProfesorImpl) ois.readObject();
				} catch (EOFException e)
				{
					p = null;
				}
			}
			
			// Cerrar fichero
			fis.close();
			ois.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
