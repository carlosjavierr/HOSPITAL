package hospitalCarlos;

import java.io.Serializable;
import java.util.ArrayList;



public class ListaEmpleados implements Serializable{
	
	/**
	 * 
	 */

	private ArrayList<Empleado> lista;
	private Empleado e;

	public ListaEmpleados() {
		
		 lista = new ArrayList<Empleado>();
	}
	

	/**
	 * Añadir un empleado
	 * @param e
	 * @return un empleado
	 */
	public boolean annadir(Empleado e){
		Empleado d;
		d=devolverDni(e.getDni());
		if (d==null)
		{
			lista.add(e);
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public Empleado devolver(int i){
		if (i>=0 && i<=lista.size()-1)
			return lista.get(i);
		else return null;
	}
	/**
	 * Borra la lista de empleados(ArrayList)
	 */
	public void cero(){
		lista.clear();
	}
	

	/**
	 * Elimina un empleado
	 * @param e
	 * @return
	 */
	public boolean eliminar(Empleado e){
		if(lista.contains(e)){
		return lista.remove(e);
		}else{
			return false;
		}
	}
	/**
	 * Tamaño de la Lista Empleados
	 * @return
	 */
	public int size(){
		return lista.size();
	}
	

	
	public Empleado get(int index) {
		if(lista.isEmpty())
			return null;
		if(index < 0 | index > lista.size()-1)
			return null;
		return lista.get(index);
	}
	
	public Empleado devolverDni(String dni){
		int i = 0;
		int encontrado=0;
		
		while (i<lista.size() && encontrado==0)
		{
			if (lista.get(i).getDni().compareTo(dni)==0)
			{
				e=lista.get(i);
				encontrado=1;
			}
			else
				i++;
		}
		if(encontrado ==1){			
			return e;
		}else
			return null;		
	}	
}
