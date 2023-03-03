package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Clase PanelAgregar del proyecto.
 * 
 * @author Katherine Patino
 * @author Daniela Pineros
 */

public class PanelAgregar extends JPanel {

	/**
	 * Atributo tipo JLabel el cual indica el tipo de informacion que se debe
	 * agregar
	 */
	private JLabel nombre, apellido, cedula, edad, cargo;
	/**
	 * Atributo tipo JTextField el cual tiene el campo de texto para ingresar la
	 * informacion solicitada
	 */
	private JTextField t_nombre, t_apellido, t_cedula, t_edad, t_cargo;
	/**
	 * Atributo tipo JButton el cual acciona la opcion de aceptar y back
	 */
	private JButton btn1, back;
	/**
	 * Atributo tipo JLabel el cual tiene el enunciado
	 */
	private JLabel titulo;

	/**
	 * Metodo constructor de la clase
	 */
	public PanelAgregar() {

		setLayout(null);
		setBackground(new Color(116, 131, 171));

		inicalizarComponentes();

		setVisible(false);

	}

	/**
	 * Metodo para asignar las caracteristicas a cada atributo
	 */
	private void inicalizarComponentes() {

		nombre = new JLabel("Ingrese el nombre:");
		nombre.setBounds(100, 50, 400, 20);
		nombre.setFont(new Font("Arial", 3, 15));
		nombre.setForeground(Color.white);
		nombre.setVisible(true);
		add(nombre);

		apellido = new JLabel("Ingrese el apellido:");
		apellido.setBounds(100, 80, 400, 20);
		apellido.setFont(new Font("Arial", 3, 15));
		apellido.setForeground(Color.white);
		apellido.setVisible(true);
		add(apellido);
		
		cedula = new JLabel("Ingrese la cedula:");
		cedula.setBounds(100, 110, 400, 20);
		cedula.setFont(new Font("Arial", 3, 15));
		cedula.setForeground(Color.white);
		cedula.setVisible(true);
		add(cedula);
		
		edad = new JLabel("Ingrese la edad:");
		edad.setBounds(100, 140, 400, 20);
		edad.setFont(new Font("Arial", 3, 15));
		edad.setForeground(Color.white);
		edad.setVisible(true);
		add(edad);
		
		cargo = new JLabel("Ingrese el cargo:");
		cargo.setBounds(100, 170, 400, 20);
		cargo.setFont(new Font("Arial", 3, 15));
		cargo.setForeground(Color.white);
		cargo.setVisible(true);
		add(cargo);
		
		t_nombre = new JTextField();
		t_nombre.setFont(new Font("Arial", 3, 15));
		t_nombre.setBounds(300, 50, 250, 23);
		t_nombre.setVisible(true);
		add(t_nombre);
		
		t_apellido = new JTextField();
		t_apellido.setFont(new Font("Arial", 3, 15));
		t_apellido.setBounds(300, 80, 250, 23);
		t_apellido.setVisible(true);
		add(t_apellido);
		
		t_cedula = new JTextField();
		t_cedula.setFont(new Font("Arial", 3, 15));
		t_cedula.setBounds(300, 110, 250, 23);
		t_cedula.setVisible(true);
		add(t_cedula);
		
		t_edad = new JTextField();
		t_edad.setFont(new Font("Arial", 3, 15));
		t_edad.setBounds(300, 140, 250, 23);
		t_edad.setVisible(true);
		add(t_edad);
		
		t_cargo = new JTextField();
		t_cargo.setFont(new Font("Arial", 3, 15));
		t_cargo.setBounds(300, 170, 250, 23);
		t_cargo.setVisible(true);
		add(t_cargo);
		
		btn1 = new JButton("Aceptar");
		btn1.setBounds(380, 220, 100, 50);
		btn1.setActionCommand("aceptar");
		ImageIcon btn8 = new ImageIcon("Media/btn_aceptar.png");
		Icon icono8 = new ImageIcon(
				btn8.getImage().getScaledInstance(btn1.getWidth(), btn1.getHeight(), Image.SCALE_DEFAULT));
		btn1.setIcon(icono8);

		back = new JButton("Back");
		back.setBounds(650, 225, 100, 50);
		back.setActionCommand("back");
		ImageIcon btn9 = new ImageIcon("Media/btn_back.png");
		Icon icono9 = new ImageIcon(
				btn9.getImage().getScaledInstance(btn1.getWidth(), btn1.getHeight(), Image.SCALE_DEFAULT));
		back.setIcon(icono9);

		titulo = new JLabel("Agregue la informacion del candidato:");
		titulo.setBounds(10, 10, 550, 20);
		titulo.setFont(new Font("Monospaced", Font.BOLD, 18));

		add(titulo);
		add(btn1);
		add(nombre);
		add(apellido);
		add(edad);
		add(cedula);
		add(cargo);
		add(t_nombre);
		add(t_apellido);
		add(t_cedula);
		add(t_edad);
		add(t_cargo);
		add(back);
		
	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the t_nombre
	 */
	public JTextField getT_nombre() {
		return t_nombre;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param t_nombre the t_nombre to set
	 */
	public void setT_nombre(JTextField t_nombre) {
		this.t_nombre = t_nombre;
	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the t_apellido
	 */
	public JTextField getT_apellido() {
		return t_apellido;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param t_apellido the t_apellido to set
	 */
	public void setT_apellido(JTextField t_apellido) {
		this.t_apellido = t_apellido;
	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the t_cedula
	 */
	public JTextField getT_cedula() {
		return t_cedula;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param t_cedula the t_cedula to set
	 */
	public void setT_cedula(JTextField t_cedula) {
		this.t_cedula = t_cedula;
	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the t_edad
	 */
	public JTextField getT_edad() {
		return t_edad;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param t_edad the t_edad to set
	 */
	public void setT_edad(JTextField t_edad) {
		this.t_edad = t_edad;
	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the t_cargo
	 */
	public JTextField getT_cargo() {
		return t_cargo;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param t_cargo the t_cargo to set
	 */
	public void setT_cargo(JTextField t_cargo) {
		this.t_cargo = t_cargo;
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
	 * @return the btn1
	 */
	public JButton getBtn1() {
		return btn1;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param btn1 the btn1 to set
	 */
	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

}