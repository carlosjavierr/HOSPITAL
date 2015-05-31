package hospitalCarlos;

import java.util.regex.Pattern;

/**
 * 
 * @author Carlos Javier Garcia Escribano
 *
 */

public class Persona {
	private String dni;
	private String nombre;
	private String apellidos;
	private String sexo;
	private String fNacimiento;
	private String direccion;
	private String email;
	// static final Pattern patternMatricula = Pattern.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");

	// private int edad;

	public Persona(String dni) {
		this.dni = dni;
	}

	public Persona() {
		this.dni = null;
		this.nombre = null;
		this.apellidos = null;
		this.sexo = null;
		this.fNacimiento = null;
		this.direccion = null;
		this.email = null;
	}

	public Persona(String dni, String nombre, String apellidos, String sexo,
			String fNacimiento, String direccion, String email)  {
		this.dni = dni;
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.fNacimiento = fNacimiento;
		this.direccion = direccion;
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
//	public  boolean esValida(String matricula) {
//		if(patternMatricula.matcher(matricula).matches()){
//			System.out.println(matricula);
//			return true;
//		}
//		return false;
//		
//	}
	


//}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
