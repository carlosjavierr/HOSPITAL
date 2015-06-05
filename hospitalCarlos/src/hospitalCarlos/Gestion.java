package hospitalCarlos;
/**
 * 
 * @author Carlos Javier Garcia Escribano
 * @version 1.0
 */
public class Gestion {
	/**
	 * Modificacion
	 */
	protected static boolean modificado = false;
	/**
	 * Modifica el estado de modificado(true/false)
	 * @param valor
	 * 				Representa el valor que tendra modificado
	 * @return true o false
	 */
	public static boolean setModificado(boolean valor){
		modificado = valor;
		return true;
	}
	/**
	 * Devuelve si se ha modificado o no
	 * @return true o false
	 */
	public static boolean getModificado(){
		return modificado;
	}
}
