package hospitalCarlos;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * @author Carlos Javier Garcia Escribano
 * @version 1.0
 */
public class Fichero  {	
/**
 * Abre un Fichero
 * @param abre
 * 			Representa el abrir fichero
 * @return Devuelve los objetos leidos
 * @throws FileNotFoundException
 * 			Si el fichero no existe
 * @throws IOException
 * 			Si se ha producido un error en la entrada o salida 
 * @throws ClassNotFoundException
 * 		Si la clase no existe
 */    

	public static ListaEmpleados abrir(File abre) throws FileNotFoundException,IOException, ClassNotFoundException {
		try (ObjectInputStream oos = new ObjectInputStream(new BufferedInputStream(new FileInputStream(abre)))) {
				return (ListaEmpleados) oos.readObject();
		}
	}
	/**
	 * Guarda un Fichero
	 * @param concesionario
	 * 						Lista de Empleados a guardar
	 * @param fichero
	 * 						Fichero
	 * @throws FileNotFoundException
	 *			 			Si el fichero no existe
	
	 * @throws IOException
	 * 						Si se ha producido un error en la entrada o salida 
	 */
	public static void guardar(ListaEmpleados concesionario, File fichero) throws FileNotFoundException, IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream( new BufferedOutputStream(new FileOutputStream(fichero)));) {
			oos.writeObject(concesionario);
		}
	}
	
	  /**
     * Confirma la existencia del fichero de la aplicación. Para ello le añade
     * la extensión en caso de no tenerla.
     * 
     * @param file
     *            Fichero a comprobar
     * @return true si existe. false en otro caso.
     */
    public static boolean confirmarExistencia(File file) {
        file = annadirExtension(file);
        return file.exists();
    }

    /**
     * Añade la extensión ".obj" sólo en caso de ser necesario
     * 
     * @param file
     *            Fichero a añadir la extensión
     * @return Fichero con la extensión ".obj"
     */
    static File annadirExtension(File file) {
        String path = file.getPath();
        if (!path.endsWith(".obj"))
            return new File(path + ".obj");
        return file;
    }


	
	
	
}
