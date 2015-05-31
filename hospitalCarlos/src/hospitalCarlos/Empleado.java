package hospitalCarlos;

import java.util.Date;

public abstract class Empleado extends Persona{
	
	private int idEmpleado;
	private String FAlta;
	private String FBaja;
	private int diasTrabajados;
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
	
	
	
//	public void mostrarEmpleado(){
//		(getDni() + getNombre()+ getApellidos() + getDiasTrabajados()+ getDireccion());
//	}
	
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getFAlta() {
		return FAlta;
	}
	public void setFAlta(String fAlta) {
		FAlta = fAlta;
	}
	public String getFBaja() {
		return FBaja;
	}
	public void setFBaja(String fBaja) {
		FBaja = fBaja;
	}
	public int getDiasTrabajados() {
		return diasTrabajados;
	}
	public void setDiasTrabajados(int diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}
	public Boolean getSituacionLabor() {
		return situacionLabor;
	}
	public void setSituacionLabor(Boolean situacionLabor) {
		this.situacionLabor = situacionLabor;
	}
	
	abstract public float nomina();
	
	
	
	
	
	
}
