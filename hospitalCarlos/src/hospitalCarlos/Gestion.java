package hospitalCarlos;

public class Gestion {
	protected static boolean modificado = false;
	
	public static boolean setModificado(boolean valor){
		modificado = valor;
		return true;
	}
	
	public static boolean getModificado(){
		return modificado;
	}
}
