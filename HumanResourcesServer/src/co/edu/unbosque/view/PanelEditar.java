package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Clase PanelEditar del proyecto.
 * 
 * @author Katherine Patino
 * @author Daniela Pineros
 */

public class PanelEditar extends JPanel {
	/**
	 * Atributo tipo JButton el cual acciona las funciones principales
	 */
	private JButton nom, ape, edad, cedu, cargo, back;

	/**
	 * Metodo constructor de la clase
	 */
	
	public PanelEditar() {
		setLayout(null);
		setBackground(new Color(116, 131, 171));

		inicalizarComponentes();
		setVisible(false);
	}

	   /**
		 * Metodo para asignar las caracteristicas a cada atributo
		 */

	public void inicalizarComponentes() {

		nom = new JButton("Nombre");
		nom.setBounds(120, 60, 150, 50);
		nom.setActionCommand("nom");

		ape = new JButton("Apellido");
		ape.setBounds(120, 130, 150, 50);
		ape.setActionCommand("ape");

		edad = new JButton("Edad");
		edad.setBounds(440, 130, 150, 50);
		edad.setActionCommand("edad");

		cargo = new JButton("Cargo");
		cargo.setBounds(440, 60, 150, 50);
		cargo.setActionCommand("cargo");

		back = new JButton("Back");
		back.setBounds(650, 225, 100, 50);
		back.setActionCommand("back");
		ImageIcon btn9 = new ImageIcon("Media/btn_back.png");
		Icon icono9 = new ImageIcon(
				btn9.getImage().getScaledInstance(back.getWidth(), back.getHeight(), Image.SCALE_DEFAULT));
		back.setIcon(icono9);
		
		add(nom);
		add(ape);
		add(edad);
		add(cargo);
		add(back);

	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the back
	 */
	public JButton getBack() {
		return back;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param back the back to set
	 */
	public void setBack(JButton back) {
		this.back = back;
	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the nom
	 */
	public JButton getNom() {
		return nom;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(JButton nom) {
		this.nom = nom;
	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the ape
	 */
	public JButton getApe() {
		return ape;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param ape the ape to set
	 */
	public void setApe(JButton ape) {
		this.ape = ape;
	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the edad
	 */
	public JButton getEdad() {
		return edad;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param edad the edad to set
	 */
	public void setEdad(JButton edad) {
		this.edad = edad;
	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the cedu
	 */
	public JButton getCedu() {
		return cedu;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param cedu the cedu to set
	 */
	public void setCedu(JButton cedu) {
		this.cedu = cedu;
	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the cargo
	 */
	public JButton getCargo() {
		return cargo;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param cargo the cargo to set
	 */
	public void setCargo(JButton cargo) {
		this.cargo = cargo;
	}
	
	
}