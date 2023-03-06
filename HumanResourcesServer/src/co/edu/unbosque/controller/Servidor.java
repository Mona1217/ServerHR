/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.persistence.CandidatosDAO;

/**
 * @author Daniela Pineros
 * @author Katherine Patino
 */
public class Servidor {

	private Socket socket;
	private Socket socketR;
	private ServerSocket server;
	private DataInputStream in;
	private DataOutputStream out;
	private int port;

	private CandidatosDAO candao;

	/**
	 * Metodo constructor
	 */
	public Servidor() {

		this.socket = null;
		this.socketR = null;
		this.server = null;
		this.in = null;
		this.out = null;
		port = 9669;
		this.candao = new CandidatosDAO();

	}

	/**
	 * Metodo stat
	 */
	public void stat() {

		String line = "";
		int aux1;
		boolean aux2 = false;

		while (!line.equals("Over")) {
			try {
				this.server = new ServerSocket(this.port);
				System.out.println("Servidor abierto");
				System.out.println("Esperando usuario ...");
				this.socket = server.accept();
				System.out.println("Usuario aceptado :D");

				this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

				line = in.readUTF();

				aux1 = candao.buscadorCedu(line);

				if (aux1 == -1) {

					System.out.println("Revise la cedula ya que no se encontro");
					aux2 = false;
				} else {
					System.out.println(candao.mostrar(aux1));
					aux2 = true;
				}

				this.socketR = new Socket(this.socket.getInetAddress(), this.port + 1);

				this.out = new DataOutputStream(socketR.getOutputStream());

				if (aux2 == false) {
					this.out.writeUTF("Revise la cedula ya que no se encontro");

				} else {

					this.out.writeUTF(candao.mostrar(aux1));
				}

				this.out.close();
				this.socketR.close();

				this.in.close();
				this.server.close();
			} catch (IOException i) {

			} catch (NumberFormatException i) {

				break;
			}
		}
		
		System.out.println("Closing connection");

		try {
			socket.close();
			in.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
