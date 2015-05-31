package hospitalCarlos;


/**
 * 
 * @author Carlos Javier Garcia Escribano
 *
 */
public enum AtsEspecialidad {
	URGENCIAS, NOURGENCIAS;
	
	private static final AtsEspecialidad[] VALUES = AtsEspecialidad.values();
	
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (AtsEspecialidad sexo : getValues()) {
			opcionesMenu[i++] = sexo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
	
	public static AtsEspecialidad[] getValues() {
		return VALUES;
	}
}
