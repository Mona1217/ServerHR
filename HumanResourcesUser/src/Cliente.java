/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Daniela Pineros
 * @author Katherine Patino
 */
public class Cliente extends Thread {

	private Socket socket;
	private ServerSocket server;
	private Scanner sn;
	private DataOutputStream out;
	private DataInputStream in;
	private String address;
	private int port;

	/**
	 * Metodo constructor
	 * 
	 * @param address
	 * @param port
	 */
	
	public Cliente(String address, int port) {

		this.socket = null;
		this.server = null;
		this.sn = new Scanner(System.in);
		this.out = null;
		this.address = address;
		this.port = port;

	}

	/**
	 * Metodo tipo void run
	 */
	@Override
	public void run() {

		String line = "";

		while (!line.equals("Over")) {

			try {
				
				this.socket = new Socket(this.address, this.port);
				System.out.println("Connected Digite la cedula que desea buscar:");

				this.socket.setSoTimeout(2000); // 5 seconds
				this.out = new DataOutputStream(socket.getOutputStream());

				line = sn.next();
				this.out.writeUTF(line);

				this.out.close();
				this.socket.close();

				this.server = new ServerSocket(this.port + 1);
				this.socket = server.accept();
				System.out.println("Received message:");

				this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

				System.out.println(in.readUTF());
				
				this.in.close();
				this.server.close();
				
			} catch (SocketTimeoutException ste) {
				
				System.out.println("Server is not responding. Closing connection.");
				line = "Over";
				
				try {
					this.socket.close();
				} catch (IOException e) {
					System.out.println("Error closing socket: " + e.getMessage());
				}
			} catch (IOException i) {
				System.out.println("Error: " + i.getMessage());
			}
		}

		try {
			out.close();
			socket.close();
		} catch (IOException i) {
			System.out.println(i);
		}

	}

	/**
	 * Metodo main
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		Cliente client = new Cliente("127.0.0.1", 9669);
		client.start();

	}

}