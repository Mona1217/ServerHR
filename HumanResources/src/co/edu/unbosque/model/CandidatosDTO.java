package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Clase con los atributos de los candidatos
 * 
 * @author Katherine Patino
 * @author Daniela Pineros
 *
 */
public class CandidatosDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Nombre del candidato
	 */
	private String nombre;

	/**
	 * Apellido del candidato
	 */
	private String apellido;

	/**
	 * Cedula correspondiente del candidato
	 */
	private String cedula;

	/**
	 * Edad del candidato
	 */
	private int edad;

	/**
	 * Cargo en el que se postula el candidato
	 */
	private String cargo;

	/**
	 * Metodo Constructor <b> pre </b> La existencia de los atributos<br>
	 * <b> post </b> Atributos inicializados correctamente<br>
	 * 
	 * @param nombre   Nombre que se ingresa
	 * @param apellido Apellido que se ingresa
	 * @param cedula   Cedula del candidato
	 * @param edad     Edad ingresada
	 * @param cargo    Cargo postulado
	 */
	public CandidatosDTO(String nombre, String apellido, String cedula, int edad, String cargo) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.edad = edad;
		this.cargo = cargo;
	}

	/**
	 * Obtiene el nombre
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna el nombre
	 * 
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el apellido
	 * 
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Asigna el apellido
	 * 
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Obtiene la cedula
	 * 
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * Asigna la cedula
	 * 
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * Obtiene la edad
	 * 
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Asigna la edad
	 * 
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Obtiene el cargo
	 * 
	 * @return the cargo
	 */
	public String getCargo() {
		return cargo;
	}

	/**
	 * Asigna el cargo
	 * 
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	/**
	 * Metodo para mostrar la informacion
	 * @return Mensaje que muestra todos los atributos de la cklase en forma de String
	 */
	
	@Override
	public String toString() {

		return "Nombre= " + nombre + "\n Apellido= " + apellido + "\n Cedula= " + cedula + "\n Edad= " + edad
				+ "\n Cargo= " + cargo + "\n";
	}

}
