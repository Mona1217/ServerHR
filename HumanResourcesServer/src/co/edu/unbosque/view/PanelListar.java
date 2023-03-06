package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Clase PanelListar del proyecto.
 * 
 * @author Katherine Patino
 * @author Daniela Pineros
 *
 */
public class PanelListar extends JPanel {
	
	/**
	 * Area que muestra los candidatos
	 */
	private JTextArea area;

	/**
	 * Boton para ir atras
	 */
	private JButton back;
	
	/**
	 * Boton para buscar
	 */
	private JButton buscar;

	/**
	 * Metodo constructor
	 * <b> pre </b> La existencia de los atributos<br>
	 * <b> post </b> Atributos inicializados correctamente<br>
	 */
	public PanelListar() {
		
		setLayout(null);
		setBackground(new Color(116, 131, 171));

		inicalizarComponentes();
		setVisible(false);
	}
	
	/**
	 * Metodo para asignar las caracteristicas a cada atributo
	 */
	public void inicalizarComponentes() {
		
		Font fuente = new Font("Times New Roman", Font.BOLD, 15);
		
		area = new JTextArea();
		area.setOpaque(false);
		area.setFont(fuente);
		area.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(area);
		scroll.setBounds(80, 20, 540, 240);
		scroll.getViewport().setOpaque(false);
		scroll.setOpaque(false);
		scroll.setBorder(null);
		
		add(scroll);
		
		back = new JButton("Back");
		back.setBounds(650, 225, 100, 50);
		back.setActionCommand("back");
		ImageIcon btn9 = new ImageIcon("Media/btn_back.png");
		Icon icono9 = new ImageIcon(
				btn9.getImage().getScaledInstance(back.getWidth(), back.getHeight(), Image.SCALE_DEFAULT));
		back.setIcon(icono9);
		
		add(back);
		
		buscar = new JButton("Buscar");
		buscar.setBounds(650, 105, 100, 50);
		buscar.setFocusable(false);
		buscar.setContentAreaFilled(false);
		buscar.setActionCommand("BUSCAR");
		
		add(buscar);
	}

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the area
	 */
	public JTextArea getArea() {
		return area;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param area the area to set
	 */
	public void setArea(JTextArea area) {
		this.area = area;
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
	 * @return the buscar
	 */
	public JButton getBuscar() {
		return buscar;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param buscar the buscar to set
	 */
	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}
	
	
}
