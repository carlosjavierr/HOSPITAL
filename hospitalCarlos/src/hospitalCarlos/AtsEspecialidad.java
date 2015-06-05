package hospitalCarlos;
/**
 * 
 * @author Carlos Javier Garcia Escribano
 * @version 1.0
 */
public enum AtsEspecialidad {
	URGENCIAS, NOURGENCIAS;
	
	private static final AtsEspecialidad[] VALUES = AtsEspecialidad.values();
	
	/**
	 * Genera las opciones del menu
	 * @return String
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (AtsEspecialidad sexo : getValues()) {
			opcionesMenu[i++] = sexo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
	/**
	 * Devuelve los valores de las enumeracios
	 * @return Valor de la enumeracion
	 */
	public static AtsEspecialidad[] getValues() {
		return VALUES;
	}
}
