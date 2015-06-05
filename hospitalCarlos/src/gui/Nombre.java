package gui;
/**
 * 
 * @author Carlos Javier Garcia Escribano
 * @version 1.0
 */
public class Nombre {
	/**
	 * Nombre del fichero
	 */
	private String nombre_fichero=null;
	
	Nombre(String nombre){
		this.nombre_fichero=nombre;
	}
	/**
	 * Devuelve nombre del fichero
	 * @return Nombre_fichero
	 */
	public String getNombre(){
		return this.nombre_fichero;
	}
	/**
	 * Modifica el nombre del fichero
	 * @param n
	 * 			Representa un nombre de fichero
	 */
	public void setNombre(String n){
		this.nombre_fichero=n;
	}
}
