package ejercicioProfesores;

/* INTERFACE: PROFESOR
 * 
 * PROPIEDADES:
 * 		nombre: cadena, consultable/modificable.
 * 		sexo: caracter, consultable/modificable.	//F-M
 * 		edad: entero, consultable/modificable.		//Mayor que 0.
 * 
 * FUNCIONALIDADES:
 * 		Consultores:
 * 			public int getId();
 * 			String getNombre();
 * 			char getSexo();
 * 			int getEdad();
 * 
 * 		Modificadores:
 * 			void setNombre(String n);
 * 			void setSexo(char s);
 * 			void setEdad(int e);
 * 
 * 		Otras:
 * 			String writer()
 */

public interface Profesor {
	// Consultores
	public int getId();
	public String getNombre();
	public char getSexo();
	public int getEdad();
	
	// Modificadores
	public void setNombre(String n);
	public void setSexo(char s);
	public void setEdad(int e);
	
	//Otras
	public String writer();
	
	//prueba de git
	//otra prueba de git
}
