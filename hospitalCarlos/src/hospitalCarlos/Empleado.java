package hospitalCarlos;

/**
 * 
 * @author Carlos Javier Garcia Escribano
 * @version 1.0
 */

public abstract class Empleado extends Persona{
	/**
	 * id del empleado
	 */
	private int idEmpleado;
	/**
	 * Fecha de Alta
	 */
	private String FAlta;
	/**
	 * Fecha de Baja
	 */
	private String FBaja;
	/**
	 * Numero de dias Trabajados
	 */
	private int diasTrabajados;
	/**
	 * Situacion laboral(true/false)
	 */
	private Boolean situacionLabor;
	
	public Empleado(String dni, String nombre, String apellidos, String sexo,
			String fNacimiento, String direccion, String email,int idEmpleado,String FAlta,String FBaja,int diasTrabajados,boolean situacionLabor) {
		super(dni, nombre, apellidos, sexo, fNacimiento, direccion, email);
		this.idEmpleado = idEmpleado;
		this.FAlta = FAlta;
		this.FBaja = FBaja;
		this.diasTrabajados = diasTrabajados;
		this.situacionLabor = situacionLabor;
		
	}
	
	public Empleado() {
		
		this.idEmpleado = 0;
		this.FAlta = null;
		this.FBaja = null;
		this.diasTrabajados = 0;
		this.situacionLabor = false;
	}
	
	public Empleado(String dni) {
		super(dni);
		this.idEmpleado = 0;
		this.FAlta = null;
		this.FBaja = null;
		this.diasTrabajados = 0;
		this.situacionLabor = false;
	}
	
	/**
	 * Devuelve el id del empleado 
	 * @return idEmpleado
	 */
	public int getIdEmpleado() {
		return idEmpleado;
	}
	/**
	 * Modifica el id del empleado
	 * @param idEmpleado
	 * 						Representa el id del empleado
	 */
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	/**
	 * Devuelve la fecha de alta del empleado
	 * @return Fecha de alta
	 */
	public String getFAlta() {
		return FAlta;
	}
	/**
	 * Modifica fecha de alta
	 * @param fAlta
	 * 				Representa la fecha de alta del Empleado
	 */
	public void setFAlta(String fAlta) {
		FAlta = fAlta;
	}
	/**
	 * Devuelve la fecha de baja
	 * @return Fecha de baja
	 */
	public String getFBaja() {
		return FBaja;
	}
	/**
	 * Modifica la fecha de baja
	 * @param fBaja
	 * 				Representa la fecha de baja del Empleado
	 */
	public void setFBaja(String fBaja) {
		FBaja = fBaja;
	}
	/**
	 * Devuelve los dias trabajados
	 * @return Dias trabajados
	 */
	public int getDiasTrabajados() {
		return diasTrabajados;
	}
	/**
	 * Modifica los dias trabajaods
	 * @param diasTrabajados
	 * 							Representa el numero de dias trabajados
	 */
	public void setDiasTrabajados(int diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}
	/**
	 * Devuelve situacion laboral
	 * @return Situacion laboral
	 */
	public Boolean getSituacionLabor() {
		return situacionLabor;
	}
	/**
	 * Modifica la situacion laboral
	 * @param situacionLabor
	 * 							Representa la situacion laboral
	 */
	public void setSituacionLabor(Boolean situacionLabor) {
		this.situacionLabor = situacionLabor;
	}
	
	abstract public float nomina();
	
	
	
	
	
	
}
