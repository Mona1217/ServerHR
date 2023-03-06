package co.edu.unbosque.model;

/**
 * Clase de excepcion en caso de la repeticion de la cedula
 * 
 * @author Katherine Patino
 * @author Daniela Pineros
 *
 */
public class RepetidoExce extends Exception {

	/**
	 * Metodo constructor con su respectivo super
	 */
	public RepetidoExce() {
		super();
	}

	/**
	 * Metodo constructor con su respectivo super <b>post</b> Muestra el mensaje en
	 * caso del error<br>
	 * 
	 * @param msj El mensaje a mostrar
	 */
	public RepetidoExce(String msj) {
		super(msj);
	}

}
