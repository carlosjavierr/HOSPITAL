package hospitalCarlos;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Especialista extends Empleado implements Serializable{

	
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
	
	///static final private Pattern patternMatricula = Pattern.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");

	//private String datos;
	
	public Especialista(String dni, String nombre, String apellidos,
			String sexo, String fNacimiento, String direccion, String email,
			int idEmpleado, String FAlta, String FBaja, int diasTrabajados,
			boolean situacionLabor,String Espe)  {
		super(dni, nombre, apellidos, sexo, fNacimiento, direccion, email, idEmpleado,FAlta, FBaja, diasTrabajados, situacionLabor);
		
		//Para almacenar en el arrayList
		this.dni = dni;
//		setDni(dni);
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
		//this.datos = null;
	}

	public Especialista(String dni) {
		super(dni);
		this.Espe = null;
		//this.datos = dni;
	}


	@Override
	public float nomina() {
		float lanomina=0;
		switch (this.Espe)
		{
		case "PEDIATRIA": lanomina=1250;break;
		case "NEUROLOGIA": lanomina=1350; break;
		case "OFTALMOLOGIA": lanomina=1450;break;
		case "RADIOLOGIA": lanomina=1550;break;
		case "null": lanomina=900;break;
		case "URGENCIAS":lanomina=800; break;
		case "NOURGENCIAS":lanomina=775; break;
		}
		return lanomina;
	}

//	public String getDatos()
//	{
//		return datos;
//	}
	
//	public void setDatos(String datos)
//	{
//		this.datos=datos;
//	}
	
	public String getEspe() {
		return Espe;
	}

	public void setEspe(String espe) {
		Espe = espe;
	}

	public String getDni() {
		return dni;
	}
//	public  boolean esValida(String matricula) {
//		return patternMatricula.matcher(matricula).matches();
//	}
	public void setDni(String dni) {
		this.dni = dni;
	}
//	public void setDni(String dni)throws DniNoValidoException {
//		if (esValida(dni))
//			this.dni = dni;
//		else
//			throw new DniNoValidoException("La matrícula no es válida");
//
//	}


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

	public boolean isSituacionLabor() {
		return situacionLabor;
	}

	public void setSituacionLabor(boolean situacionLabor) {
		this.situacionLabor = situacionLabor;
	}
	
	
	
	
}
