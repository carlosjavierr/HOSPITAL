package hospitalCarlos;


/**
 * 
 * @author Carlos Javier Garcia Escribano
 *
 */
public enum Sexo {
	HOMBRE, MUJER;
	
	private static final Sexo[] VALUES = Sexo.values();
	
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Sexo sexo : getValues()) {
			opcionesMenu[i++] = sexo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
	
	public static Sexo[] getValues() {
		return VALUES;
	}
}
