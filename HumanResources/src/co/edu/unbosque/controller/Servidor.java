/**
 * 
 */
package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.CandidatosDTO;
import co.edu.unbosque.model.persistence.CandidatosDAO;
import co.edu.unbosque.view.VentanasEmergentes;

/**
 * @author Katherine Patino
 *
 */
public class Servidor extends Thread {
	
	private Socket recibir;
	private Socket enviar;
	private ServerSocket servi;
	private ObjectInputStream inpu;
	private ObjectOutputStream outpu;
	private int puerto;
	private String direccionCl;
	private CandidatosDAO candi;
	private CandidatosDTO candto;
	private VentanasEmergentes vent;
	
	public Servidor(int port) {
		
		this.recibir = null;
		this.enviar = null;
		this.servi = null;
		this.inpu = null;
		this.outpu = null;
		this.puerto = port;
		this.direccionCl = direccionCl;
		
		candto = null;
		vent = new VentanasEmergentes();
	}

	@Override
	public void run() {
		
		String line = "";
		
		while(!line.equals("Terminado")) {
			
			try {
				servi = new ServerSocket(puerto);
				System.out.println("Servidor listo");
				System.out.println("Conectando cliente...");
				recibir = servi.accept();
				System.out.println("Cliente recibido");
				
				inpu = new ObjectInputStream(recibir.getInputStream());
				candto = (CandidatosDTO)inpu.readObject();
				
				recibir.close();
		
			
			}catch(IOException e){
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	

}
