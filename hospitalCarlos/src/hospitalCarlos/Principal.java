package hospitalCarlos;

public class Principal {

	public static void main(String[] args) {
		Especialista especialista1 = new Especialista("a","a","a","a","a","a","a",5,"a","a",3,false,"a");
		Especialista especialista2 = new Especialista("b","b","b","a","a","a","a",5,"b","a",3,false,"a");
		Especialista especialista3 = new Especialista("c","c","c","c","a","a","a",5,"a","a",3,false,"a");
		ListaEmpleados lista1 = new ListaEmpleados();
		lista1.annadir(especialista1);
		lista1.annadir(especialista2);
		lista1.annadir(especialista3);
		//lista1.mostrarLista();
		
		lista1.eliminar(especialista2);
		
		//lista1.mostrarLista();
		
	}

}
