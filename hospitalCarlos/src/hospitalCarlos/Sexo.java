package hospitalCarlos;
/**
 * 
 * @author Carlos Javier Garcia Escribano
 * @version 1.0
 */
public enum Sexo {
	HOMBRE, MUJER;
	
	private static final Sexo[] VALUES = Sexo.values();
	/**
	 * Devuelve las opciones del menu
	 * @return Opciones
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Sexo sexo : getValues()) {
			opcionesMenu[i++] = sexo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
	/**
	 * Devuelve los elementos de la enumeracion(Hombre / Mujer)
	 * @return Valores de la enumeracion
	 */
	public static Sexo[] getValues() {
		return VALUES;
	}
}
