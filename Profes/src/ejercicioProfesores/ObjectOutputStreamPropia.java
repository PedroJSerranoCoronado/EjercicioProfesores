package ejercicioProfesores;

/**
 * Clase ObjectOutputStream propia.
 * 
 * El objetivo de la redefinici�n de esta clase es evitar la escritura de una nueva Cabecera en el fichero binario cuando se
 * van a guardar nuevos datos en dicho fichero por segunda, o sucesivas, veces.
 */

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class ObjectOutputStreamPropia extends ObjectOutputStream
{
    /** Constructor que recibe OutputStream */
    public ObjectOutputStreamPropia(OutputStream out) throws IOException
    {
        super(out);
    }

    /** Redefinici�n del m�todo de escribir la cabecera para que no haga nada. */
    protected void writeStreamHeader() throws IOException
    {
    	//M�todo vac�o para evitar la escritura de nuevas cabeceras
    }
}
