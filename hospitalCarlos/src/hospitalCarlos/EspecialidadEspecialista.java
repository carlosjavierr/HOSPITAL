package hospitalCarlos;
/**
 * 
 * @author Carlos Javier Garcia Escribano
 * @version 1.0
 */
public enum EspecialidadEspecialista {
	
	PEDIATRIA,NEUROLOGIA,OFTALMOLOGIA,RADIOLOGIA;
	
private static final EspecialidadEspecialista[] VALUES = EspecialidadEspecialista.values();
	/**
	 * Devuelve las opciones del meneu
	 * @return opcionesMenu
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (EspecialidadEspecialista espEsp : getValues()) {
			opcionesMenu[i++] = espEsp.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
	/**
	 * Devuelve los valores de la enumeracion
	 * @return Values
	 */
	public static EspecialidadEspecialista[] getValues() {
		return VALUES;
	}
}
