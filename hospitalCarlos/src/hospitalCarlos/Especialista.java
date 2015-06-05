package hospitalCarlos;

import java.io.Serializable;

/**
 * 
 * @author Carlos Javier Garcia Escribano
 * @version 1.0
 */
public class Especialista extends Empleado implements Serializable,Comparable<Especialista>{
	private static final long serialVersionUID = 1L;
	private String Espe;
	private String dni;
	private String nombre;
	private String apellidos;
	private String sexo;
	private String fNacimiento;
	private String direccion;
	private String email;
	private int idEmpleado;
	private String FAlta;
	private String FBaja;
	private int diasTrabajados;
	private boolean situacionLabor;
	private String datos;
	
	public Especialista(String dni, String nombre, String apellidos,
			String sexo, String fNacimiento, String direccion, String email,
			int idEmpleado, String FAlta, String FBaja, int diasTrabajados,
			boolean situacionLabor,String Espe) {
		super(dni, nombre, apellidos, sexo, fNacimiento, direccion, email, idEmpleado,FAlta, FBaja, diasTrabajados, situacionLabor);
		this.datos=dni+")"+nombre+")"+apellidos+")"+sexo+")"+fNacimiento+")"+direccion+")"+email+")"+idEmpleado+")"+FAlta+")"+FBaja+")"+diasTrabajados+")"+situacionLabor;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.fNacimiento = fNacimiento;
		this.direccion = direccion;
		this.email = email;
		this.idEmpleado = idEmpleado;
		this.FAlta = FAlta;
		this.FBaja = FBaja;
		this.diasTrabajados = diasTrabajados;
		this.situacionLabor = situacionLabor;
		this.Espe = Espe;
		
	}
	
	public Especialista() {
		
		this.Espe = null;
		this.datos = null;
	}

	public Especialista(String dni) {
		super(dni);
		this.Espe = null;
		this.datos = dni;
	}


	@Override
	public float nomina() {
		float lanomina=0;
		switch (this.Espe){
			case "PEDIATRIA": lanomina=1250;
				break;
			case "NEUROLOGIA": lanomina=1350; 
				break;
			case "OFTALMOLOGIA": lanomina=1450;
				break;
			case "RADIOLOGIA": lanomina=1550;
				break;
			case "null": lanomina=900;
				break;
			case "URGENCIAS":lanomina=800; 
				break;
			case "NOURGENCIAS":lanomina=775; 
				break;
		}
		return lanomina;
	}
	/**
	 * Devuelve los Datos
	 * @return Datos
	 */
	public String getDatos(){
		return datos;
	}
	/**
	 * Modifica los Datos 
	 * @param datos
	 * 				Representa los datos
	 */
	public void setDatos(String datos){
		this.datos=datos;
	}
	/**
	 * Devuelve la Especialidad
	 * @return Especialidad
	 */
	public String getEspe() {
		return Espe;
	}
	/**
	 * Modifica la Especialidad
	 * @param espe
	 * 				Reprensenta la Especialidad
	 */
	public void setEspe(String espe) {
		Espe = espe;
	}
	/**
	 * Devuelve el Dni del Especialista
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * Modifica el Dni del Especialista
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * Devuelve el nombre del Especialista 
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Modifica el nombre del Especialista
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Devuelve los apellidos del Especialista
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * Modifica los apellidos del Especialista
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * Devuelve el sexo del Especialista
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * Modifica el sexo del Especialista
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getfNacimiento() {
		return fNacimiento;
	}
	/**
	 * Modifica la fecha de nacimiento del especialista
	 */
	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
	/**
	 * Devuelve la direccion del Especialista
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Modifica la direccion dle Especialista
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Devuelve el email del especialista
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Modifica el email del Especialista
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Devuelve el id
	 */
	public int getIdEmpleado() {
		return idEmpleado;
	}
	/**
	 * Modifica el id
	 */
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	/**
	 * Devuelve la fecha de alta
	 */
	public String getFAlta() {
		return FAlta;
	}
	/**
	 * Modific ala fecha de alta
	 */
	public void setFAlta(String fAlta) {
		FAlta = fAlta;
	}
	/**
	 * Devuelve la fecha de baja
	 */
	public String getFBaja() {
		return FBaja;
	}
	/**
	 * Modifica la fecha de baja
	 */
	public void setFBaja(String fBaja) {
		FBaja = fBaja;
	}
	/**
	 * Devuelve el numero de dias trabajados
	 */
	public int getDiasTrabajados() {
		return diasTrabajados;
	}
	/**
	 * Modifica el numero de dias trabajados
	 */
	public void setDiasTrabajados(int diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}
	/**
	 * Devuelve la situacion laboral
	 * @return Situacion Laboral
	 */
	public boolean isSituacionLabor() {
		return situacionLabor;
	}
	/**
	 * Modifica la situacion laboral
	 * @param situacionLabor
	 * 						Representa la situacion laboral
	 */
	public void setSituacionLabor(boolean situacionLabor) {
		this.situacionLabor = situacionLabor;
	}
	/**
	 * Interfaz Comparable
	 */
	@Override
	public int compareTo(Especialista e) {
		if(this.diasTrabajados > e.getDiasTrabajados()){
			return 1;
		}else{
			if(this.diasTrabajados < e.getDiasTrabajados()){
				return 2;
			}else{
				if(this.nombre.compareTo(e.getNombre()) == 1){
					return 1;
				}else{
					return 2;
				}
			}
		}
	
	}
	
	
	
	
}
