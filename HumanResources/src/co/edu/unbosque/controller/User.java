package co.edu.unbosque.controller;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.CandidatosDTO;
import co.edu.unbosque.view.PanelAgregar;
import co.edu.unbosque.view.VentanasEmergentes;

public class User extends Thread {

	private Socket socket;
	private  ServerSocket servi;
	private ObjectOutputStream out;
	private ObjectInputStream inp;
	private String direccion;
	private int puerto;
	private CandidatosDTO candto;
	private PanelAgregar ag;
	private VentanasEmergentes ve;
	
	public User(String direccion, int puerto) {
		
		this.socket = null;
		this.servi = null;
		this.out = null;
		this.direccion = direccion;
		this.puerto = puerto;
		
		candto = null;
		ag = new PanelAgregar();
		ve = new VentanasEmergentes();
	}

	@Override
	public void run() {
		
		String line = "";
		
		while(!line.equals("Terminado")) {
			
			try {
				
				socket = new Socket(direccion, puerto);
				System.out.println("Se ha conectado con el server");
			
				candto.setNombre(ag.getT_nombre().getText());
				candto.setApellido(ag.getT_apellido().getText());
				candto.setCedula(ag.getT_cedula().getText());
				candto.setEdad(Integer.parseInt(ag.getT_edad().getText()));
				candto.setCargo(ag.getT_cargo().getText());
				
				
				out = new ObjectOutputStream(socket.getOutputStream());
				out.writeObject(candto);
				
				out.close();
				socket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
