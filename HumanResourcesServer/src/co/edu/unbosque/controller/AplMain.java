package co.edu.unbosque.controller;

//import serverBs.Servidor;

/**
 * Clase AplMain para ejecutar el programa
 * @author Katherine Patino
 * @author Daniela Pineros
 *
 */
public class AplMain {

	/**
	 * Metodo main del proyecto.
	 * 
	 * @param args para el metodo main
	 */
	
	public static void main(String[] args) {
		
		Servidor server = new Servidor();
    	server.stat();
		Controller control = new Controller();
//		control.abrirServer();
		
	}

}
