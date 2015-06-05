package hospitalCarlos;
/**
 * 
 * @author Carlos Javier Garcia Escribano
 * @version 1.0 
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


	public Persona(String dni) {
		this.dni = dni;
	}
	/**
	 * Constructor sin parametros
	 */
	public Persona() {
		this.dni = null;
		this.nombre = null;
		this.apellidos = null;
		this.sexo = null;
		this.fNacimiento = null;
		this.direccion = null;
		this.email = null;
	}
	/**
	 * Constructor con parametros
	 * @param dni
	 * 				Representa el dni de una Persona
	 * @param nombre
	 * 				Representa el nombre de una Persona
	 * @param apellidos
	 * 				Representa los apellidos de una Persona
	 * @param sexo
	 * 				Representa el sexo de una persona
	 * @param fNacimiento
	 * 				Representa la fecha de nacimiento de una Persona
	 * @param direccion
	 * 				Representa la direccion de una Persona
	 * @param email
	 * 				Representa el email de una Persona
	 */
	public Persona(String dni, String nombre, String apellidos, String sexo,
			String fNacimiento, String direccion, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.fNacimiento = fNacimiento;
		this.direccion = direccion;
		this.email = email;
	}
/**
 * Devuelve el dni de una persona
 * @return Dni
 */
	public String getDni() {
		return dni;
	}
	/**
	 * Modifica el Dni
	 * @param dni
	 * 			Representa el dni de una persona
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * Devuelve el nombre de una persona
	 * @return Nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Modifica el Nombre de la persona
	 * @param nombre 
	 * 					Representa el nombre de una Persona
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Devuelve los apellidos de una persona
	 * @return apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * Modifica los Apellidos de la persona
	 * @param apellidos
	 * 						Representa los apellidos de una Persona
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * Devuelve el sexo de una persona
	 * @return Sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * Modifica el Sexo
	 * @param sexo
	 * 				Representa el sexo de una Persona
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * Devuelve la fecha de nacimiento de una persona
	 * @return fecha de nacimiento
	 */
	public String getfNacimiento() {
		return fNacimiento;
	}
	/**
	 * Modifica la fecha de nacimiento
	 * @param fNacimiento
	 * 						Representa la fecha de nacimiento de una Persona
	 */
	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
	/**
	 * Devuelve la direccion de una persona
	 * @return Direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Modifica la Direccion
	 * @param direccion
	 * 						Representa la direccion de una Persona
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Devuelve el email de una persona
	 * @return Email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Modifica el email
	 * @param email
	 * 				Representa el email de una persona
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
