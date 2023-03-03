package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Ventana que gestiona las funciones de refistrarse e ingresar y extiende de
 * JFrame
 * 
 * @author Katherine
 * @author Daniela
 */

public class VentanaPrincipal extends JFrame {
    /**
     * Clase PanelOpciones del proyecto renombrada como panelO
     */
    private PanelOpciones panelO;
    /**
     * Clase PanelEditar del proyecto renombrada como panelE
     */
    private PanelEditar panelE;
    /**
     * Clase PanelAgregar del proyecto renombrada como panelA
     */
    private PanelAgregar panelA;
    
    /**
     * Panel para listar
     */
    private PanelListar listar;
    
    /**
     * Ventanas empergentes
     */
    private VentanasEmergentes view;
    
    /**
     * Atributo tipo JLabel el cual tiene la imagen del fondo
     */
    private JLabel img_fondo;
    /**
     * Icono del programa
     */
    private ImageIcon icono;

    /**
     * Metodo constructor de la clase
     */
    public VentanaPrincipal() {

        setTitle("Manejo de candidatos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        setLayout(null);
        setSize(800, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        inicalizarComponentes();
        setVisible(true);

        iconoVista();
        
        view = new VentanasEmergentes();
    }

    /**
     * Metodo que se usa para establecer el icono
     */
    
    private void iconoVista() {
        icono = new ImageIcon("Media/Icono.png");
        setIconImage(icono.getImage());

    }

    /**
	 * Metodo para asignar las caracteristicas a cada atributo
	 */

    public void inicalizarComponentes() {
        getContentPane().setLayout(new BorderLayout());
        
        panelO = new PanelOpciones();
        panelO.setBounds(0, 125, 800, 450);
        add(panelO);
        
        panelA = new PanelAgregar();
        panelA.setBounds(0, 125, 800, 450);
        add(panelA);
        
        panelE = new PanelEditar();
        panelE.setBounds(0, 125, 800, 450);
        add(panelE);
        
        listar = new PanelListar();
        listar.setBounds(-60, 125, 800, 450);
        add(listar);
        
        img_fondo = new JLabel("", JLabel.CENTER);
        img_fondo.setIcon(new ImageIcon("Media/fondo.png"));
        add(img_fondo);
        
    }

    

	/**
	 * El metodo get funciona para tomar o llamar el atributo
	 * 
	 * @return the panelE
	 */
	public PanelEditar getPanelE() {
		return panelE;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param panelE the panelE to set
	 */
	public void setPanelE(PanelEditar panelE) {
		this.panelE = panelE;
	}

	/**
     * El metodo get funciona para tomar o llamar el atributo
     * 
	 * @return the panelA
	 */
	public PanelAgregar getPanelA() {
		return panelA;
	}

	/**
	 * El metodo set funciona para actualizar el atributo
	 * 
	 * @param panelA the panelA to set
	 */
	public void setPanelA(PanelAgregar panelA) {
		this.panelA = panelA;
	}

	/**
     * El metodo get funciona para tomar o llamar el atributo
     * 
     * @return the panelO
     */
    public PanelOpciones getPanelO() {
        return panelO;
    }

    /**
     * El metodo set funciona para actualizar el atributo
     * 
     * @param panelO the panelO to set
     */
    public void setPanelO(PanelOpciones panelO) {
        this.panelO = panelO;
    }

    /**
     * El metodo get funciona para tomar o llamar el atributo
     * 
     * @return the img_fondo
     */
    public JLabel getImg_fondo() {
        return img_fondo;
    }

    /**
     * El metodo set funciona para actualizar el atributo
     * 
     * @param img_fondo the img_fondo to set
     */
    public void setImg_fondo(JLabel img_fondo) {
        this.img_fondo = img_fondo;
    }

	/**
	 * Obtiene el panel listar
	 * @return the listar
	 */
	public PanelListar getListar() {
		return listar;
	}

	/**
	 * Asigna el panel listar
	 * @param listar the listar to set
	 */
	public void setListar(PanelListar listar) {
		this.listar = listar;
	}

	/**
	 * Obtiene las ventanas emergentes
	 * @return the view
	 */
	public VentanasEmergentes getView() {
		return view;
	}

	/**
	 * Obtienes las ventanas emergentes
	 * @param view the view to set
	 */
	public void setView(VentanasEmergentes view) {
		this.view = view;
	}

	
    
}