package gui;

public class Nombre {

	private String nombre_fichero=null;
	
	Nombre(String nombre)
	{
		this.nombre_fichero=nombre;
	}
	
	public String getNombre()
	{
		return this.nombre_fichero;
	}
	
	public void setNombre(String n)
	{
		this.nombre_fichero=n;
	}
}
