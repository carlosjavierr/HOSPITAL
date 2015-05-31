package hospitalCarlos;

public enum EspecialidadEspecialista {
	
	PEDIATRIA,NEUROLOGIA,OFTALMOLOGIA,RADIOLOGIA;
	
private static final EspecialidadEspecialista[] VALUES = EspecialidadEspecialista.values();
	
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (EspecialidadEspecialista espEsp : getValues()) {
			opcionesMenu[i++] = espEsp.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
	
	public static EspecialidadEspecialista[] getValues() {
		return VALUES;
	}
}
