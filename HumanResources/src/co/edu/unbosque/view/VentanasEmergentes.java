package co.edu.unbosque.view;

import javax.swing.JOptionPane;

/**
 * Clase para las ventanas emergentes
 * 
 * @author Katherine Patino
 * @author Daniela Pineros
 *
 */
public class VentanasEmergentes {

	/**
	 * Metodo para leer un dato dado por el usuario <b>pre</b> El dato ingresado
	 * tiene que ser una cadena de texto <br>
	 * <b>post</b> Guarda el dato en una variable <br>
	 * 
	 * @param mensaje El mensaje a mostrar para el usuario
	 * @return El dato ingresado
	 */
	public String leerDato(String mensaje) {

		String msj = JOptionPane.showInputDialog(mensaje);
		return msj;
	}

	/**
	 * Metodo para leer un dato entero dado por el usuario <b>pre</b> El dato
	 * ingresado tiene que ser un entero <br>
	 * <b>post</b> Guarda el dato en una variable <br>
	 * 
	 * @param mensaje El mensaje a mostrar para el usuario
	 * @return El dato ingresado
	 */
	public int leerDatoEntero(String mensaje) {

		String msj = JOptionPane.showInputDialog(mensaje);
		int rta = Integer.parseInt(msj);

		return rta;
	}

	/**
	 * Metodo que muestra un mensaje al usuario
	 * 
	 * @param mensaje El mensaje que se va a mostrar
	 */
	public void show(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
