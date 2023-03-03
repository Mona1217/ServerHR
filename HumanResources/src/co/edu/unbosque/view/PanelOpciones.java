package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Clase PanelOpciones del proyecto.
 * 
 * @author Katherine
 * @author Daniela
 */

public class PanelOpciones extends JPanel {
	/**
	 * Atributo tipo JButton el cual acciona las funciones principales
	 */
	private JButton listar, eliminar, modificar, agregar;

	/**
	 * Metodo constructor de la clase
	 */
	
	public PanelOpciones() {
		setLayout(null);
		setBackground(new Color(116, 131, 171));

		inicalizarComponentes();
		setVisible(true);
	}

	   /**
		 * Metodo para asignar las caracteristicas a cada atributo
		 */

	public void inicalizarComponentes() {

		agregar = new JButton("Agregar");
		agregar.setBounds(120, 60, 150, 50);
		agregar.setActionCommand("agregar");
		ImageIcon btn1 = new ImageIcon("Media/btn_agregar.png");
		Icon icono1 = new ImageIcon(
				btn1.getImage().getScaledInstance(agregar.getWidth(), agregar.getHeight(), Image.SCALE_DEFAULT));
		agregar.setIcon(icono1);

		listar = new JButton("Listar");
		listar.setBounds(120, 130, 150, 50);
		listar.setActionCommand("listar");
		ImageIcon btn2 = new ImageIcon("Media/btn_listar.png");
		Icon icono2 = new ImageIcon(
				btn2.getImage().getScaledInstance(agregar.getWidth(), agregar.getHeight(), Image.SCALE_DEFAULT));
		listar.setIcon(icono2);

		modificar = new JButton("Modificar");
		modificar.setBounds(440, 130, 150, 50);
		modificar.setActionCommand("modificar");
		ImageIcon btn3 = new ImageIcon("Media/btn_modificar.png");
		Icon icono3 = new ImageIcon(
				btn3.getImage().getScaledInstance(agregar.getWidth(), agregar.getHeight(), Image.SCALE_DEFAULT));
		modificar.setIcon(icono3);

		eliminar = new JButton("Eliminar");
		eliminar.setBounds(440, 60, 150, 50);
		eliminar.setActionCommand("eliminar");
		ImageIcon btn4 = new ImageIcon("Media/btn_eliminar.png");
		Icon icono4 = new ImageIcon(
				btn4.getImage().getScaledInstance(agregar.getWidth(), agregar.getHeight(), Image.SCALE_DEFAULT));
		eliminar.setIcon(icono4);

		add(agregar);
		add(listar);
		add(modificar);
		add(eliminar);

	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the listar
	 */
	public JButton getListar() {
		return listar;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param listar the listar to set
	 */
	public void setListar(JButton listar) {
		this.listar = listar;
	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the eliminar
	 */
	public JButton getEliminar() {
		return eliminar;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param eliminar the eliminar to set
	 */
	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the modificar
	 */
	public JButton getModificar() {
		return modificar;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param modificar the modificar to set
	 */
	public void setModificar(JButton modificar) {
		this.modificar = modificar;
	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the agregar
	 */
	public JButton getAgregar() {
		return agregar;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param agregar the agregar to set
	 */
	public void setAgregar(JButton agregar) {
		this.agregar = agregar;
	}

}