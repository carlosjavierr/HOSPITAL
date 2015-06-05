package hospitalCarlos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;
import expceciones.CorreoNoValidoException;
import expceciones.DniNoValidoException;
/**
 * 
 * @author Carlos Javier García Escribano
 * @version 1.0
 */
public class ListaEmpleados implements Serializable{
	
	/**
	 * lista de Empleados(ArrayList)
	 */
	private ArrayList<Empleado> lista;
	/**
	 * Empleado
	 */
	private Empleado e;
	/**
	 * Patron para un DNI valido
	 */
	static final Pattern patternMatricula = Pattern.compile("\\d{8}[-]?[A-Z]{1}");
	/**
	 * Patron para un EMAIL valido
	 */
	static final Pattern patternCE = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	/**
	 * Devuelve una lista de empleados
	 * @return lista de Empleados
	 */
	public ListaEmpleados copiar(){
		ListaEmpleados listaEmpleados1= new ListaEmpleados();
		for (int i = 0; i <lista.size()-1; i++) {
			listaEmpleados1.annadir((Especialista)lista.get(i));
		}
		return listaEmpleados1;
	}
	
	
	
	/**
	 * Crea una lista de empledos
	 */
	public ListaEmpleados() {
		
		 lista = new ArrayList<Empleado>();
	}
	/**
	 * Comproueva el correo electronico
	 * @param correo
	 * 					Representa el correo electronico que se comprobara
	 * @throws CorreoNoValidoException
	 * 					Si el correo no es valido
	 */
	public void comprobar_correo(String correo) throws CorreoNoValidoException
	{
		if (!patternCE.matcher(correo).matches())
			throw new CorreoNoValidoException("El especialista no tiene un correo correcto. uncorreo@ejemplo.net");
		
	}
	/**
	 * Comprueba el Dni
	 * @param dni
	 * 					Representa el dni que se comprobara
	 * @throws DniNoValidoException
	 * 					Si el DNI no es valido
	 */
	public void comprobar_dni(String dni) throws DniNoValidoException
	{
		if (!patternMatricula.matcher(dni).matches())
			throw new DniNoValidoException("El especialista no tiene un dni correcto. 11111111-X.");
		
	}
	/**
	 * Añade elementos a la lista
	 * @param e
	 * 				Representa un empleado
	 * @param dni
	 * 				Representa el dni
	 */
	public void realmacenar(Empleado e, String dni){
		Empleado eliminar;
		for (int i=0;i<lista.size()-1;i++){
			eliminar = lista.get(i);
			if (eliminar.getDni().compareTo(dni)==0){
				lista.remove(i);
			}
		}
		lista.add(e);
	}
	/**
	 * Añande un empleado
	 * @param e
	 *			Representa un empleado 		
	 * @return true o false
	 */
	public boolean annadir(Empleado e){
		Empleado d;
		d=devolverDni(e.getDni());
		if (d==null){
			lista.add(e);
			return true;
		}else{
			return false;
		}
		
	}
	/**
	 * Devuelve el contenidio del arrayList de una posicion concreta
	 * @param i
	 * 				Representa la posicion de un empleado en el ArrayList
	 * @return elemento arrayList
	 * 			
	 */
	public Empleado devolver(int i){
		if (i>=0 && i<=lista.size()-1)
			return lista.get(i);
		else return null;
	}
	/**
	 * Borra la lista de empleados
	 */
	public void cero(){
		lista.clear();
	}
	
	public Empleado copiar(Empleado e)
	{
		if (lista.contains(e))
			return e;
		return null;
	}
	/**
	 * Elimina un empleado
	 * @param e
	 * 		Representa un empleado
	 * @return true o false
	 */
	public boolean eliminar(Empleado e){
		if(lista.contains(e)){
			return lista.remove(e);
		}else{
			return false;
		}
	}
	/**
	 * Devuelve el tamaño de la lista
	 * @return tamaño de  la lista(int)
	 */
	public int size(){
		return lista.size();
	}
	

	/**
	 * Devuelve elementos de la lista
	 * @param index
	 * 		Representa posicion de un elemento de arrayList
	 * @return elemento de la lista
	 */
	public Empleado get(int index) {
		if(lista.isEmpty())
			return null;
		if(index < 0 | index > lista.size()-1)
			return null;
		return lista.get(index);
	}
	/**
	 * Devuelve empleados
	 * @param dni
	 * 		Representa el dnio
	 * @return Empleado
	 */
	public Empleado devolverDni(String dni){
		int i = 0;
		int encontrado=0;
		
		while (i<lista.size() && encontrado==0){
			if (lista.get(i).getDni().compareTo(dni)==0){
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
