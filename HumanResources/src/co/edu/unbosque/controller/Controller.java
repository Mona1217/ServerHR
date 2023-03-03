package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.view.*;

/**
 * Clase controller
 * 
 * @author Katherine Patino
 * @author Daniela Pineros
 *
 */
public class Controller implements ActionListener {

	/**
	 * Conexion a los metodos
	 */
	private CandidatosDAO candidatos;

	/**
	 * Lista de candidatos
	 */
	private ArrayList<CandidatosDTO> candi;

	/**
	 * Archivo y sus metodos
	 */
	private Archivo archivito;

	/**
	 * Ventana principal del programa
	 */
	private VentanaPrincipal vp;

	/**
	 * Metodo constructor <b> pre </b> La existencia de los atributos<br>
	 * <b> post </b> Atributos inicializados correctamente<br>
	 */
	public Controller() {

		archivito = new Archivo();
		candi = new ArrayList<CandidatosDTO>();
		candi = archivito.leerArchivo();
		candidatos = new CandidatosDAO(archivito);

		vp = new VentanaPrincipal();
		asignarOyentes();

	}

	/**
	 * Metodo que se encarga de asignar las funciones a cada boton <b> pre </b> La
	 * existencia de los botones con sus respectivos comandos<br>
	 * <b> post </b> Boton funcional para asignarle una funcion<br>
	 */
	private void asignarOyentes() {

		vp.getPanelO().getAgregar().addActionListener(this);
		vp.getPanelO().getModificar().addActionListener(this);
		vp.getPanelO().getListar().addActionListener(this);
		vp.getPanelO().getEliminar().addActionListener(this);
		vp.getPanelA().getBtn1().addActionListener(this);
		vp.getPanelA().getBack().addActionListener(this);
		vp.getPanelE().getNom().addActionListener(this);
		vp.getPanelE().getApe().addActionListener(this);
		vp.getPanelE().getEdad().addActionListener(this);
		vp.getPanelE().getCargo().addActionListener(this);
		vp.getPanelE().getBack().addActionListener(this);
		vp.getListar().getBack().addActionListener(this);
		vp.getListar().getBuscar().addActionListener(this);
	}

	/**
	 * Metodo encargado de accionar los comandos
	 */

	@Override
	public void actionPerformed(ActionEvent e)  {

		String comando = e.getActionCommand();

		switch (comando) {

		case "agregar":

			vp.getPanelO().setVisible(false);
			vp.getPanelA().setVisible(true);

			break;

		case "aceptar":

			try {

				String nom = vp.getPanelA().getT_nombre().getText();
				String ape = vp.getPanelA().getT_apellido().getText();
				String cedula = vp.getPanelA().getT_cedula().getText();
				int edad = Integer.parseInt(vp.getPanelA().getT_edad().getText());
				String car = vp.getPanelA().getT_cargo().getText();

				candidatos.agregar(nom, ape, cedula, edad, car, candi);
				System.out.println(candi.toString());

			} catch (CedulaExce e1) {

				vp.getView().show(e1.getMessage());

			} catch (RepetidoExce e1) {
				vp.getView().show(e1.getMessage());
			} catch (NumExce e1) {
				vp.getView().show(e1.getMessage());
			}

			vp.getPanelA().getT_nombre().setText(null);
			vp.getPanelA().getT_apellido().setText(null);
			vp.getPanelA().getT_edad().setText(null);
			vp.getPanelA().getT_cedula().setText(null);
			vp.getPanelA().getT_cargo().setText(null);

			break;

		case "back":

			vp.getPanelA().setVisible(false);
			vp.getPanelO().setVisible(true);
			vp.getPanelE().setVisible(false);
			vp.getListar().setVisible(false);

			vp.getPanelA().getT_nombre().setText(null);
			vp.getPanelA().getT_apellido().setText(null);
			vp.getPanelA().getT_edad().setText(null);
			vp.getPanelA().getT_cedula().setText(null);
			vp.getPanelA().getT_cargo().setText(null);

			break;

		case "eliminar":


			
			String ced = vp.getView().leerDato("Digite la cedula que desea eliminar");
			
			try {
				if (candidatos.search(ced, candi) == null) {
					
					vp.getView().show("No se encontro ningun candidato disponible");
					
				}else if (candidatos.eliminar(ced, candi)) {

					vp.getView().show("El candidato se elimino correctamente");
					
				} else {
					
					vp.getView().show("El candidato no existe en la base de datos");

				}

			} catch (CedulaExce e2) {
				vp.getView().show(e2.getMessage());
			}
			break;

		case "modificar":

			vp.getPanelO().setVisible(false);
			vp.getPanelA().setVisible(false);
			vp.getPanelE().setVisible(true);

			break;

		case "nom":
			
			try {
			
				String nom = vp.getView().leerDato("Digite la cedula del candidato");

				if (candidatos.search(nom, candi) == null) {

					vp.getView().show("La cedula no se encuentra en el sistema");

				} else {

					String nomb = vp.getView().leerDato("Digite el nuevo nombre del candidato");
					candidatos.modificarNom(nom, nomb, candi);

					vp.getView().show("El nombre se modifico con exito");

				}
			} catch (CedulaExce e1) {
				// TODO Auto-generated catch block
				vp.getView().show(e1.getMessage());
				
			}
			break;

		case "ape":

			try {
			String ape = vp.getView().leerDato("Digite la cedula del candidato");

				if (candidatos.search(ape, candi) == null) {

					vp.getView().show("La cedula no se encuentra en el sistema");

				} else {

					String apel = vp.getView().leerDato("Digite el nuevo apellido del candidato");
					candidatos.modificarApe(ape, apel, candi);

					vp.getView().show("El apellido se modifico con exito");

				}
			} catch (CedulaExce e1) {
				vp.getView().show(e1.getMessage());
			} catch (NumExce e1) {
				vp.getView().show(e1.getMessage());
			}

			break;

		case "edad":

			try {
			String age = vp.getView().leerDato("Digite la cedula del candidato");

				if (candidatos.search(age, candi) == null) {

					vp.getView().show("La cedula no se encuentra en el sistema");

				} else {

					int ages = vp.getView().leerDatoEntero("Digite la edad actual del candidato");
					candidatos.modificarAnios(age, ages, candi);

					vp.getView().show("La edad se modifico con exito");

				}
			} catch (CedulaExce e1) {
				vp.getView().show(e1.getMessage());
			}

			break;

		case "cargo":

			try {
			String car = vp.getView().leerDato("Digite la cedula del candidato");

				if (candidatos.search(car, candi) == null) {

					vp.getView().show("La cedula no se encuentra en el sistema");

				} else {

					String carg = vp.getView().leerDato("Digite el nuevo cargo al que se postulo el candidato");
					candidatos.modificarCar(car, carg, candi);

					vp.getView().show("El cargo se modifico con exito");

				}
			} catch (CedulaExce e1) {
				vp.getView().show(e1.getMessage());
			} catch (NumExce e1) {
				vp.getView().show(e1.getMessage());
			}

			break;

		case "listar":

			vp.getPanelO().setVisible(false);
			vp.getPanelA().setVisible(false);
			vp.getPanelE().setVisible(false);
			vp.getListar().setVisible(true);

			vp.getListar().getArea().setText(candi.toString());
			vp.getListar().repaint();

			break;

		case "BUSCAR":

			try {

				vp.getListar().getArea().setText(null);
				
				String bus = vp.getView().leerDato("Digite la cedula que desea buscar");
				
				if (candidatos.search(bus, candi) == null) {

					vp.getView().show("La cedula no se encuentra en la base de datos");

				} else {

					vp.getListar().getArea().setText(candidatos.search(bus, candi).toString());
				}
				
			} catch (CedulaExce e1) {
				vp.getView().show(e1.getMessage());
			}

		default:
			break;
		}
	}
}
