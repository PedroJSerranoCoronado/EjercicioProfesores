package ejercicioProfesores;

import java.io.Serializable;

/* CLASE: PROFESOR
 * 
 * PROPIEDADES:
 * 		id: entero, consultable.
 * 		nombre: cadena, consultable/modificable.
 * 		sexo: caracter, consultable/modificable.	
 * 		edad: entero, consultable/modificable.		
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
 * FUNCIONALIDADES SOBREESCRITAS:
 * 		String toString();
 * 		int hashCode();
 * 		boolean equals(Object obj);
 * 		Object clone();
 * 		int compareTo(Profesor profe);
 */
@SuppressWarnings("serial")
public class ProfesorImpl implements Serializable, Cloneable, Comparable <ProfesorImpl>, Profesor 
{
	//ATRIBUTOS
	private int id;
	private String nombre;
	private char sexo;
	private int edad;
	
	//CONSTRUCTORES
	//Por defecto
	public ProfesorImpl()
	{
		this.nombre = "default";
		this.sexo = ' ';
		this.edad = 0;
	}
	
	//Con parámetros
	public ProfesorImpl(int id, String n, char s, int e)
	{
		this.id = id;
		this.nombre = n;
		this.sexo = s;
		this.edad = e;
	}
	
	//FUNCIONALIDADES
	//Consultores
	public int getId()
	{
		return this.id;
	}
	public String getNombre()
	{
		return this.nombre;
	}
	
	public char getSexo()
	{
		return this.sexo;
	}
	
	public int getEdad()
	{
		return this.edad;
	}
	
	//Modificadores
	public void setNombre(String n)
	{
		this.nombre = n;
	}
	
	public void setSexo(char s)
	{
		this.sexo = s;
	}
	
	public void setEdad(int e)
	{
		this.edad = e;
	}
	
	//Otros metodos
	
	/* INTERFAZ: 
	  * Comentario: este método pasa los atributos de un objeto a una cadena para guardarlos en un fichero de texto.
	  * Precondiciones: no tiene.
	  * Entrada: no tiene.
	  * Salidas: una cadena.
	  * Postcondiciones: ASN se devuelve una cadena con los atributos del objeto.
	  * Entrada/Salida: no tiene.
	  * 
	  * Signatura: String writer()
	  */
	public String writer()
	{
		String w = getId()+"    "+getNombre()+"   "+getEdad()+"   "+getSexo();
		
		return w;
	}
	
	//Sobreescritos
	public String toString()
	{
		String s = "Nombre: "+getNombre()+" \nEdad: "+getEdad()+" \nSexo: "+getSexo();
		
		return s; 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + edad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + sexo;
		return result;
	}

	/* Este método equals devuelve true si los atributos de ambos objetos son iguales, y false si no
	 * lo son
	 */
	@Override
	public boolean equals(Object obj) {
		boolean res=false;
		
		if (obj != null && (obj instanceof ProfesorImpl))
		{
			if (edad == ((ProfesorImpl) obj).edad)
			{
				if (sexo == ((ProfesorImpl) obj).sexo)
				{
					if (nombre != null && ((ProfesorImpl) obj).nombre != null)
					{
						if (nombre.equals(((ProfesorImpl) obj).nombre)) {
							res = true;
						}
					}
				}
			}
		}
		
		return res;
	}

	/* El siguiente método devuelve un objeto de tipo Profesor clonado, igual al que llama al método*/
	@Override
	public Object clone() {
		ProfesorImpl res = null;
		
		try {
			res = (ProfesorImpl) super.clone();
		} catch (CloneNotSupportedException error) {
			System.out.println("Objeto no clonado");
		}
		
		return res;
	}
	
	/* El criterio para comparar a dos profesores es según su edad.
	 * Si tienen la misma edad, se devuelve 0; si el Profesor que llama
	 * al método es mayor que el Profesor dado, se devuelve 1; si el Profesor
	 * que llama al método es menor que el Profesor dado, se devuelve -1.
	 */
	
	public int compareTo(ProfesorImpl profe)
	{
		int res=0;
		
		if (this.getEdad()>profe.getEdad())
		{
			res=1;
		}
		
		if (this.getEdad()<profe.getEdad())
		{
			res=-1;
		}
		
		return res;
	}
}