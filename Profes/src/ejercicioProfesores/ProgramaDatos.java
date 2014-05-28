package ejercicioProfesores;

import java.util.*;

/* ANALISIS Y DISEÑO 
 * 
 * El programa a desarrollar debe trabajar con un archivo que contendrá datos sobre profesores.
 * 
 * Para ello se ha diseñado una clase Profesor y una clase de utilidades, llamada UtilidadesProfesor, que contendrá los distintos métodos
 * para trabajar con los datos de los Profesores. 
 *  
 * Se trabajará sobre un fichero que contiene los datos de Profesores (nombre, edad y sexo), guardados todos ellos como objeto.
 * 
 * ENTRADAS
 * 
 * Las entradas serán un fichero sobre el que trabajarán los distintos métodos y la opción seleccionada del menú.
 * 
 * SALIDAS
 * 
 * Mensajes por pantalla con la información requerida.
 * 
 * ESTUDIO DE LAS ESTRUCTURA DE DATOS
 * 
 * Se usará un fichero con los datos de profesores; una clase de utilidades llamada UtilidadesProfesor que contiene los
 * distintos métodos para trabajar con la clase Profesor, que a su vez ha sido diseñada para esta aplicación.
 * 
 * PSEUDOCODIGO GENERALIZADO
 * 
 * Inicio Programa Principal
 * 		mostrarPresentacion
 * 		REPETIR
 * 			leerYValidarOpcionMenu
 * 			SI(opcion distinta de salir)
 * 				SEGUN (opcion)
 * 					caso 1:				//averiguamos el nombre del profesor mas joven
 * 						profesorMasJoven*
 * 					caso 2:				//averiguamos el nombre del profesor mas veterano
 * 						profesorMenosJoven*
 * 					caso 3:				//averiguamos el numero de profesores por encima de la edad media
 * 						profesoresEncimaMedia*
 * 					caso 4:				//averiguamos el numero de profesores por debajo de la edad media
 * 						profesoresDebajomedia
 * 					caso 5:				//opcion para gestion del fichero
 * 						leerYValidarOpcionSubMenu
 * 						SEGUN (opcion submenu)
 * 							caso 1:				//añadir un nuevo registro
 * 								nuevoRegistro*
 * 							case 2:				//ordenar fichero por edad
 * 								ordenarFicheroEdad*
 * 							case 3:				//obtener listado de profesores
 * 								obtenerArrayProfesores*
 * 								arrayATexto*
 * 							caso 4:				//borrar registros
 * 								borrarRegistros*
 * 						FIN_SEGUN
 * 				FIN_SEGUN
 * 			FIN_SI
 * 		leerYValidarNuevaEjecucion
 * 		MIENTRAS (opcion distinta de salir)
 * Fin Programa Principal
 */
public class ProgramaDatos 
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
	public static void Presentacion()
	{
		System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
		System.out.println("          ProfeMaster 3000             ");
		System.out.println("            Versión Beta               ");
		System.out.println("                 Por                   ");
		System.out.println("       AbPer Corporation UNLTD         ");
		System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-\n\n");
	}
	
	/* INTERFAZ: 
	  * Comentario: este método imprime por pantalla el menú principal del programa.
	  * Precondiciones: no tiene.
	  * Entrada: no tiene.
	  * Salidas: no tiene.
	  * Postcondiciones: no tiene.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: void Menu()
	  */
	public static void Menu()
	{
		System.out.println("\n1) Nombre del profesor más joven de grupo.");
		System.out.println("2) Nombre del profesor de más edad.");
		System.out.println("3) Número de profesores con edad mayor al promedio.");
		System.out.println("4) Número de profesores con edad menor al promedio.");
		System.out.println("5) Gestión del fichero.");
		System.out.println("6) Salir.");
	}
	
	/* INTERFAZ: 
	  * Comentario: este método imprime por pantalla un submenú del programa.
	  * Precondiciones: no tiene.
	  * Entrada: no tiene.
	  * Salidas: no tiene.
	  * Postcondiciones: no tiene.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: void subMenu()
	  */
	public static void subMenu()
	{
		System.out.println("\n1) Añadir registro.");
		System.out.println("2) Ordenar fichero.");
		System.out.println("3) Obtener listado.");
		System.out.println("4) Actualización del fichero");
		System.out.println("5) Borrar registro.\n");
	}
	
	//Programa Principal
	public static void main(String[] args) //throws ClassNotFoundException
	{
		//Entorno
		UtilidadesProfesor UP = new UtilidadesProfesor();
		int opcion=0, opcionSM=0, cantidad=0;
		String fichero="profesores.dat", ficheroMov="ficheroMov.dat", nombre=" ";
		double edadMedia=0.0;
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Profesor> lista = new ArrayList<Profesor>();
		boolean res;
		
		//mostrarPresentacion
		Presentacion();
		
		//bucle Do-While principal con menu y opciones
		do
		{
			//leerYValidarOpcionMenu
			do
			{
				Menu();
				System.out.print("Elija una opcion: ");
				opcion=keyboard.nextInt();
				if(opcion<1 || opcion>6)
					System.out.println("\nOpcion incorrecta, debe elegir entre 1 y 5");
			}while(opcion<1 || opcion>6);
			
			//SI opcion distinta de salir
			if(opcion!=6)
			{
				//Estructura SEGUN
				switch(opcion)
				{
					case 1:		//Averiguar el profesor mas joven
					{
						try {
							nombre=UP.profesorMasJoven(fichero);
						} catch (ClassNotFoundException e) {
							//e.printStackTrace();
							System.out.println(e.getMessage());
						}
						System.out.println("\nEl profesor mas joven es: "+nombre+"\n");
						break;
					}//Fin case 1
					case 2:		//Averiguar el profesor de mas edad
					{
						nombre=UP.profesorMasMayor(fichero);
						System.out.println("\nEl profesor de mas edad es: "+nombre+"\n");
						break;
					}//Fin case 2
					case 3:		//Averiguar numero de profesores por encima de la media
					{
						try {
							edadMedia=UP.edadPromedio(fichero);
							cantidad=UP.profesoresEncimaMedia(fichero);
						} catch (ClassNotFoundException e) {
							//e.printStackTrace();
							System.out.println(e.getMessage());
						}
						System.out.println("\nLa edad media es "+edadMedia+" y la cantidad de profesores por encima de ella es de "+cantidad+"\n");
						break;
					}//Fin case 3
					case 4:		//Averiguar profesores por debajo de la media
					{
						try {
							edadMedia=UP.edadPromedio(fichero);
							cantidad=UP.profesoresDebajoMedia(fichero);
						} catch (ClassNotFoundException e) {
							//e.printStackTrace();
							System.out.println(e.getMessage());
						}
						System.out.println("\nLa edad media es "+edadMedia+" y la cantidad de profesores por debajo de ella es de "+cantidad+"\n\n");
						break;
					}//Fin case 4
					case 5:		//Gestión del fichero
					{
						//leerYValidarOpcionSubMenu
						do
						{
							subMenu();
							System.out.print("Elija una opcion: ");
							opcionSM=keyboard.nextInt();
							if(opcionSM<1 || opcionSM>5)
								System.out.println("\nOpcion incorrecta, debe elegir una de las siguientes opciones:");
						}while(opcionSM<1 || opcionSM>5);
						
						//Segun opcion SubMenu
						switch(opcionSM)
						{
							case 1:		//añadir registro
							{
								//nuevoRegistro
								res = UP.nuevoRegistro(fichero);
								
								System.out.println("\nObjeto guardado? "+res+"\n");
								break;
							}//fin case submenu 1
							case 2:		//ordenar el fichero por edad
							{
								try
								{
									UP.ordenarFicheroEdad(fichero);
								} catch (Exception e)
								{
									System.out.println(e.getMessage());
								}
								//UP.pintar("auxiliar1.dat");
								//System.out.println("\n\n\n\n");
								//UP.pintar("auxiliar2.dat");
								break;
							}//fin case submenu 2
							case 3:		//obtener listado de profesores
							{
								lista = UP.listadoProfesores(fichero);
								/*for (int i = 0; i < lista.size(); i++) 
								{
									System.out.println(lista.get(i).toString());
								}*/
								UP.arrayATexto(lista);
								break;
							}//fin case submenu 3
							case 4:
							{
								res = UP.actualizarFichero(fichero, ficheroMov);
								
								System.out.println("El fichero ha sido actualizado? "+res+"\n");
								break;
							}//fin case submenu 4
							case 5:		//borrar registros
							{
								res = UP.borrarRegistros(ficheroMov);
						
								System.out.println("\nRegistros borrados? "+res+"\n");
								break;
							}//fin case submenu 5
						}//Fin SEGUN submenu
						break;
					}//Fin case 5
				}//Fin SEGUN
			}//Fin IF
		}while(opcion!=6);	//FIN do-while principal
		
		//despedida
		System.out.println("Gracias por usar nuestra aplicación ;)");
		
		// cerramos el Scanner
		keyboard.close();
	}
}