package co.edu.unbosque.model.persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import co.edu.unbosque.controller.Controller;
import co.edu.unbosque.model.*;

/**
 * Clase donde se ubica las acciones del candidato
 * 
 * @author Katherine Patino
 * @author Daniela Pineros
 *
 */
public class CandidatosDAO {

	/**
	 * Archivo en donde ira la información
	 */
	private Archivo archivito;
	private Controller con;

	public CandidatosDAO() {
		con = new Controller();

	}

	/**
	 * Metodo constructor <b> pre </b> La existencia de los atributos<br>
	 * <b> post </b> Atributos inicializados correctamente<br>
	 * 
	 * @param archivo El dato inicial para archivito
	 */
	public CandidatosDAO(Archivo archivo) {

		this.archivito = archivo;

	}

	/**
	 * Metodo para agregar un nuevo candidato <b> pre </b> Tener la informacion
	 * solicitada en el formato correcto <br>
	 * <b> post </b> El candidato es agregado correctamente <br>
	 * 
	 * @param nombre   Nombre del candidato
	 * @param apellido Apellido del candidato
	 * @param cedula   Cedula del candidato
	 * @param edad     Edad del candidato
	 * @param cargo    Cargo al que se postula
	 * @param candi    Lista en donde se guardara el candidato
	 * @throws CedulaExce   Excepcion del formato de la cedula la cual solo puede
	 *                      ser numerica
	 * @throws RepetidoExce Excepcion si la cedula está repetida
	 */
	public void agregar(String nombre, String apellido, String cedula, int edad, String cargo,
			ArrayList<CandidatosDTO> candi) throws CedulaExce, RepetidoExce, NumExce {

		for (int i = 0; i < candi.size(); i++) {

			String repe = candi.get(i).getCedula();

			if (repe.equals(cedula)) {

				throw new RepetidoExce("La cedula ya existe en el sistema");

			} else if (!cedula.matches("[0-9]*")) {

				throw new CedulaExce("La cedula solo debe contener numeros");

			} else if (!apellido.matches("[A-Za-z]*")) {

				throw new NumExce("El apellido no permite caracteres especiales ni numeros");

			} else if (!cargo.matches("[A-Za-z]*")) {

				throw new NumExce("El cargo no permite caracteres especiales ni numeros");

			}
		}

		CandidatosDTO nuevo = new CandidatosDTO(nombre, apellido, cedula, edad, cargo);
		candi.add(nuevo);
		archivito.escribirEnArchivo(candi);

	}

	public String mostrar(int i) {
		String res = "";

		res += "Nombre " + con.getCandi().get(i).getNombre() + "\n";
		res += "Apellido " + con.getCandi().get(i).getApellido() + "\n";
		res += "Cargo " + con.getCandi().get(i).getCargo() + "\n";
		res += "Edad " + con.getCandi().get(i).getEdad() + "\n";
		res += "Cedula " + con.getCandi().get(i).getCedula() + "\n";

		return res;
	}

	public int buscadorCedu(String cedula) {
		int aux = -1;
		for (int i = 0; i < con.getCandi().size(); i++) {

			if (con.getCandi().get(i).getCedula().equals(cedula)) {

				try {
					System.out.println("" + i);
					aux = i;

					return aux;

				} catch (Exception e) {

					return aux;

				}

			}
		}
		return aux;
	}

	/**
	 * Metodo que busca el candidato por su cedula <b> pre </b> La existencia del
	 * candidato <br>
	 * <b> post </b> El candidato es encontrado <br>
	 * 
	 * @param cedula La cedula por la que se va a buscar
	 * @param candi  La lista de donde se buscara
	 * @return El candidato encontrado
	 */
	public CandidatosDTO search(String cedula, ArrayList<CandidatosDTO> candi) throws CedulaExce {

		CandidatosDTO encontrado = null;

		if (!cedula.matches("[0-9]*")) {

			throw new CedulaExce("La cedula solo debe contener numeros");
		}

		if (!candi.isEmpty()) {

			for (int i = 0; i < candi.size(); i++) {

				if (candi.get(i).getCedula().equals(cedula)) {

					encontrado = candi.get(i);

					return encontrado;
				}
			}
		}

		return encontrado;
	}

	/**
	 * Metodo que elimina algun candidato <b> pre </b> La existencia del candidato
	 * <br>
	 * <b> post </b> El candidato es eliminado <br>
	 * 
	 * @param cedula Cedula del candidato a eliminar
	 * @param candi  Lista de donde se eliminara el candidato
	 * @return Un valor de verdad dependiendo si se encontro el candidato
	 */
	public boolean eliminar(String cedula, ArrayList<CandidatosDTO> candi) {

		try {

			CandidatosDTO encontrado = search(cedula, candi);

			if (encontrado != null) {
				candi.remove(encontrado);

				archivito.getArchivo().delete();
				archivito.getArchivo().createNewFile();
				archivito.escribirEnArchivo(candi);

				return true;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (CedulaExce e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Metodo para modificar el nombre del candidato <b> pre </b> La existencia del
	 * candidato<br>
	 * <b> post </b> La informacion del candidato es modificada <br>
	 * 
	 * @param cedula Cedula para buscar el candidato
	 * @param nombre Nuevo nombre a editar
	 * @param candi  Lista la cual se ediatra
	 */
	public void modificarNom(String cedula, String nombre, ArrayList<CandidatosDTO> candi) {

		try {
			CandidatosDTO encontrado = search(cedula, candi);

			if (!encontrado.equals(null)) {

				encontrado.setNombre(nombre);

				archivito.getArchivo().delete();
				archivito.getArchivo().createNewFile();
				archivito.escribirEnArchivo(candi);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CedulaExce e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para modificar el apellido del candidato <b> pre </b> La existencia
	 * del candidato<br>
	 * <b> post </b> La informacion del candidato es modificada <br>
	 * 
	 * @param cedula   Cedula para buscar el candidato
	 * @param apellido Nuevo apellido a editar
	 * @param candi    Lista la cual se ediatra
	 */
	public void modificarApe(String cedula, String apellido, ArrayList<CandidatosDTO> candi) throws NumExce {

		try {
			CandidatosDTO encontrado = search(cedula, candi);

			if (!apellido.matches("[A-Za-z]*")) {

				throw new NumExce("El apellido no permite caracteres especiales ni numeros");

			}

			if (!encontrado.equals(null)) {

				encontrado.setApellido(apellido);

				archivito.getArchivo().delete();
				archivito.getArchivo().createNewFile();
				archivito.escribirEnArchivo(candi);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CedulaExce e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Metodo para modificar la edad del candidato <b> pre </b> La existencia del
	 * candidato<br>
	 * <b> post </b> La informacion del candidato es modificada <br>
	 * 
	 * @param cedula Cedula para buscar el candidato
	 * @param edad   La edad actual del candidato
	 * @param candi  Lista la cual se ediatra
	 */
	public void modificarAnios(String cedula, int edad, ArrayList<CandidatosDTO> candi) {

		try {
			CandidatosDTO encontrado = search(cedula, candi);

			if (!encontrado.equals(null)) {

				encontrado.setEdad(edad);

				archivito.getArchivo().delete();
				archivito.getArchivo().createNewFile();
				archivito.escribirEnArchivo(candi);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CedulaExce e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Metodo para modificar el cargo del candidato <b> pre </b> La existencia del
	 * candidato<br>
	 * <b> post </b> La informacion del candidato es modificada <br>
	 * 
	 * @param cedula Cedula para buscar el candidato
	 * @param cargo  Nuevo cargo al que se postulo
	 * @param candi  Lista la cual se ediatra
	 */
	public void modificarCar(String cedula, String cargo, ArrayList<CandidatosDTO> candi) throws NumExce {

		try {
			CandidatosDTO encontrado = search(cedula, candi);

			if (!cargo.matches("[A-Za-z]*")) {

				throw new NumExce("El cargo no permite caracteres especiales ni numeros");

			}

			if (!encontrado.equals(null)) {

				encontrado.setCargo(cargo);

				archivito.getArchivo().delete();
				archivito.getArchivo().createNewFile();
				archivito.escribirEnArchivo(candi);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CedulaExce e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
