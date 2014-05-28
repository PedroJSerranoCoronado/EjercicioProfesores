package ejercicioProfesores;

public class ProfesorImplTest 
{
	public static void main(String[] args)
	{
		//Probamos los constructores
		ProfesorImpl profe1 = new ProfesorImpl();
		ProfesorImpl profe2 = new ProfesorImpl(1, "Pedro", 'M', 26);
		ProfesorImpl profe3;
		
		//Probamos sets y toString
		profe1.setNombre("Elena");
		profe1.setSexo('F');
		profe1.setEdad(25);
		
		System.out.println(profe1.toString());
		System.out.println(profe2.toString());
		
		//Probamos los gets
		System.out.println("Nombre: "+profe1.getNombre());
		System.out.println("Sexo: "+profe1.getSexo());
		System.out.println("Edad: "+profe1.getEdad());
		
		//Probamos el hashCode
		System.out.println("Cod. Hash: "+profe1.hashCode());
		
		//Probamos el equals
		System.out.println("Son iguales? "+profe1.equals(profe2));
		
		//Probamos el clone
		profe3 = (ProfesorImpl) profe1.clone();
		System.out.println("Son iguales luego de la clonacion? "+profe3.equals(profe1));
		
		//Prueba del compareTo
		System.out.println("Orden de profe1 y profe2: "+profe1.compareTo(profe2));
		
		//Probamos el writer
		System.out.println(profe1.writer());
		System.out.println(profe2.writer());
	}
}