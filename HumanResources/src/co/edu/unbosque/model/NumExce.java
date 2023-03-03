package co.edu.unbosque.model;

/**
 * Clase de excepcion de numeros+
 * 
 * @author Katherine Patino
 * @author Daniela Pineros
 *
 */
public class NumExce extends Exception {

	/**
	 * Metodo constructor con su respectivo super
	 */
	public NumExce() {
		super();
	}

	/**
	 * Metodo constructor con su respectivo super <b>post</b> Muestra el mensaje en
	 * caso del error<br>
	 * 
	 * @param msj El mensaje a mostrar
	 */
	public NumExce(String msj) {
		super(msj);
	}

}
