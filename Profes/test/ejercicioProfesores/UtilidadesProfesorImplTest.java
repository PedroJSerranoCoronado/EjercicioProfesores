package ejercicioProfesores;

public class UtilidadesProfesorImplTest 
{
	public static void main(String[] args) throws ClassNotFoundException 
	{
		UtilidadesProfesor UP = new UtilidadesProfesor();
		double edadMedia;
		String s;
		int b;
		boolean prueba;
		
		//Prueba del m�todo para calcular la edad promedio
		edadMedia=UP.edadPromedio("profesores.dat");
		System.out.println("Edad media: "+edadMedia);
		
		//Prueba del m�todo profesor mas joven
		s=UP.profesorMasJoven("profesores.dat");
		System.out.println("Profesor mas joven: "+s);
		
		//Prueba del m�todo para calcular el numero de profesores por encima de la edad media
		b=UP.profesoresEncimaMedia("profesores.dat");
		System.out.println("Profesores por encima de la media: "+b);
		
		//Prueba del metodo a�adir registro
		prueba = UP.nuevoRegistro("profesores.dat");
		System.out.println("Exito? "+prueba);
	}
}