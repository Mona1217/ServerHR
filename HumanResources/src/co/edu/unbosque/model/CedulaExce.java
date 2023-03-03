package co.edu.unbosque.model;

/**
 * Clase de excepcion del formato de cedula
 * 
 * @author Katherine Patino
 * @author Daniela Pineros
 *
 */
public class CedulaExce extends Exception {

	/**
	 * Metodo constructor con su respectivo super
	 */
	public CedulaExce() {
		super();
	}

	/**
	 * Metodo constructor con su respectivo super <b>post</b> Muestra el mensaje en
	 * caso del error<br>
	 * 
	 * @param msj El mensaje a mostrar
	 */
	public CedulaExce(String msj) {
		super(msj);
	}

}
