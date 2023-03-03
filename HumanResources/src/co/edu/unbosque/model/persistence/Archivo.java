package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model.CandidatosDTO;

/**
 * Clase de serializacion
 * 
 * @author Katherine Patino
 * @author Daniela Pineros
 *
 */
public class Archivo {

	/**
	 * Atributo para la salida de informacion
	 */
	private ObjectInputStream entrada;

	/**
	 * Atributo para la entrada de informacion
	 */
	private ObjectOutputStream salida;

	/**
	 * El archivo de destino
	 */
	private File archivo = new File("Datos/Candidatos.dat");

	/**
	 * Metodo constructor <b>pre</b> La existencia del archivo <br>
	 * <b>post</b> Archivo inicilizado y/o creado<br>
	 */
	public Archivo() {
		if (archivo.exists()) {
			System.out.println("El archivo si existe");

		} else {
			try {
				archivo.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metodo que escribe en el archivo seleccionado <b>pre</b> La existencia del
	 * archivo <br>
	 * <b>post</b> El archivo es escrito con la informacion deseada <br>
	 * 
	 * @param candi La informacion de los candidatos que se desea escribir
	 */
	public void escribirEnArchivo(ArrayList<CandidatosDTO> candi) {
		try {
			salida = new ObjectOutputStream(new FileOutputStream(archivo));
			salida.writeObject(candi);
			salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo para leer el archivo selecionado <b>pre</b> La existencia del archivo
	 * <br>
	 * <b>post</b> El archivo leido y cargado <br>
	 * 
	 * @return La informacion del archivo
	 */
	public ArrayList<CandidatosDTO> leerArchivo() {
		ArrayList<CandidatosDTO> contactos = new ArrayList<CandidatosDTO>();
		if (archivo.length() != 0) {
			try {
				entrada = new ObjectInputStream(new FileInputStream(archivo));
				contactos = (ArrayList<CandidatosDTO>) entrada.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
		return contactos;
	}

	/**
	 * Obtiene el archivo
	 * 
	 * @return the archivo
	 */
	public File getArchivo() {
		return archivo;
	}

	/**
	 * Asigna el archivo
	 * 
	 * @param archivo the archivo to set
	 */
	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

}
