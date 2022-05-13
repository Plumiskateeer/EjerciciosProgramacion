package capitulo07.centroEducativo.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import capitulo07.centroEducativo.ErrorBBDDException;
import capitulo07.centroEducativo.modelo.Estudiante;
import capitulo07.centroEducativo.modelo.controladores.ControladorEstudiante;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Botones extends JPanel {

	private JToolBar toolBar;
	private JButton btnPrimerElemento;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimoElemento;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private Campos panelCampos;
	
	/**
	 * Create the panel.
	 * @throws ErrorBBDDException 
	 * @throws ClassNotFoundException 
	 */	
	public Botones() throws ErrorBBDDException {
		this.panelCampos = new Campos();
		
		setLayout(new BorderLayout(0, 0));
		
		toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		btnPrimerElemento = new JButton("");
		btnPrimerElemento.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/gotostart.png")));
		
		btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/previous.png")));
		
		btnSiguiente = new JButton("");
		btnSiguiente.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/next.png")));
		
		btnUltimoElemento = new JButton("");
		btnUltimoElemento.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/gotoend.png")));
		
		btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/nuevo.png")));
		
		btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/guardar.png")));
		
		btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/eliminar.png")));
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Profesores.getInstance().setId(0);
					Estudiantes.getInstance().setId(0);
					
				} catch (ErrorBBDDException e1) {
					e1.printStackTrace();
				}
				panelCampos.setNombreField("");
				panelCampos.setApellido1Field("");
				panelCampos.setApellido2Field("");
				panelCampos.setDniField("");
				panelCampos.setDireccionField("");
				panelCampos.setEmailField("");
				panelCampos.setTelefonoField("");
				panelCampos.getSexocomboBox().setEditable(true);
				panelCampos.getSexocomboBox().setEnabled(true);
				JLabel lblIcono = new JLabel("Sin imagen");
				panelCampos.getScrollPane().setViewportView(lblIcono);
			}
		});
		toolBar.add(btnNuevo);

		panelCampos.cargarValoresSexoEnJComboBox();
	}

	public JToolBar getToolBar() {
		return toolBar;
	}

	public void setToolBar(JToolBar toolBar) {
		this.toolBar = toolBar;
	}

	public JButton getBtnPrimerElemento() {
		return btnPrimerElemento;
	}

	public void setBtnPrimerElemento(JButton btnPrimerElemento) {
		this.btnPrimerElemento = btnPrimerElemento;
	}

	public JButton getBtnAnterior() {
		return btnAnterior;
	}

	public void setBtnAnterior(JButton btnAnterior) {
		this.btnAnterior = btnAnterior;
	}

	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	public void setBtnSiguiente(JButton btnSiguiente) {
		this.btnSiguiente = btnSiguiente;
	}

	public JButton getBtnUltimoElemento() {
		return btnUltimoElemento;
	}

	public void setBtnUltimoElemento(JButton btnUltimoElemento) {
		this.btnUltimoElemento = btnUltimoElemento;
	}

	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	public void setBtnNuevo(JButton btnNuevo) {
		this.btnNuevo = btnNuevo;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public Campos getPanelCampos() {
		return panelCampos;
	}

	public void setPanelCampos(Campos panelCampos) {
		this.panelCampos = panelCampos;
	}
	
	
	
}
