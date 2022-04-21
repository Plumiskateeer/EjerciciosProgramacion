package capitulo07.centroEducativo.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Materias extends JPanel {
	private JTextField idField;
	private JTextField nombreField;
	private JTextField acronimoField;
	private JTextField cursoField;
	private static Materias instance = null;

	/**
	 * Create the panel.
	 */
	
	public static Materias getInstance() {
		if(instance == null) {
			instance = new Materias();
		}
		return instance;
	}
	public Materias() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnPrimerElemento = new JButton("");
		btnPrimerElemento.setIcon(new ImageIcon(Materias.class.getResource("/capitulo07/resources/gotostart.png")));
		toolBar.add(btnPrimerElemento);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(Materias.class.getResource("/capitulo07/resources/previous.png")));
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.setIcon(new ImageIcon(Materias.class.getResource("/capitulo07/resources/next.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimoElemento = new JButton("");
		btnUltimoElemento.setIcon(new ImageIcon(Materias.class.getResource("/capitulo07/resources/gotoend.png")));
		toolBar.add(btnUltimoElemento);
		
		JButton btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(Materias.class.getResource("/capitulo07/resources/nuevo.png")));
		toolBar.add(btnNuevo);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(Materias.class.getResource("/capitulo07/resources/guardar.png")));
		toolBar.add(btnGuardar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(Materias.class.getResource("/capitulo07/resources/eliminar.png")));
		toolBar.add(btnEliminar);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lbMaterias = new JLabel("Materias");
		GridBagConstraints gbc_lbMaterias = new GridBagConstraints();
		gbc_lbMaterias.insets = new Insets(0, 0, 5, 5);
		gbc_lbMaterias.gridx = 0;
		gbc_lbMaterias.gridy = 0;
		panel.add(lbMaterias, gbc_lbMaterias);
		lbMaterias.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbMaterias.setHorizontalAlignment(SwingConstants.CENTER);
		lbMaterias.setVerticalAlignment(SwingConstants.TOP);
		
		JLabel lbId = new JLabel("Id :");
		GridBagConstraints gbc_lbId = new GridBagConstraints();
		gbc_lbId.insets = new Insets(0, 0, 5, 5);
		gbc_lbId.gridx = 0;
		gbc_lbId.gridy = 1;
		panel.add(lbId, gbc_lbId);
		
		idField = new JTextField();
		GridBagConstraints gbc_idField = new GridBagConstraints();
		gbc_idField.fill = GridBagConstraints.HORIZONTAL;
		gbc_idField.insets = new Insets(0, 0, 5, 0);
		gbc_idField.gridx = 1;
		gbc_idField.gridy = 1;
		panel.add(idField, gbc_idField);
		idField.setColumns(10);
		
		JLabel lbNombre = new JLabel("Nombre :");
		GridBagConstraints gbc_lbNombre = new GridBagConstraints();
		gbc_lbNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lbNombre.gridx = 0;
		gbc_lbNombre.gridy = 2;
		panel.add(lbNombre, gbc_lbNombre);
		
		nombreField = new JTextField();
		GridBagConstraints gbc_nombreField = new GridBagConstraints();
		gbc_nombreField.insets = new Insets(0, 0, 5, 0);
		gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreField.gridx = 1;
		gbc_nombreField.gridy = 2;
		panel.add(nombreField, gbc_nombreField);
		nombreField.setColumns(10);
		
		JLabel lbAcronimo = new JLabel("Acronimo :");
		GridBagConstraints gbc_lbAcronimo = new GridBagConstraints();
		gbc_lbAcronimo.insets = new Insets(0, 0, 5, 5);
		gbc_lbAcronimo.gridx = 0;
		gbc_lbAcronimo.gridy = 3;
		panel.add(lbAcronimo, gbc_lbAcronimo);
		
		acronimoField = new JTextField();
		GridBagConstraints gbc_acronimoField = new GridBagConstraints();
		gbc_acronimoField.insets = new Insets(0, 0, 5, 0);
		gbc_acronimoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_acronimoField.gridx = 1;
		gbc_acronimoField.gridy = 3;
		panel.add(acronimoField, gbc_acronimoField);
		acronimoField.setColumns(10);
		
		JLabel lbIdCurso = new JLabel("Id Curso :");
		GridBagConstraints gbc_lbIdCurso = new GridBagConstraints();
		gbc_lbIdCurso.insets = new Insets(0, 0, 0, 5);
		gbc_lbIdCurso.gridx = 0;
		gbc_lbIdCurso.gridy = 4;
		panel.add(lbIdCurso, gbc_lbIdCurso);
		
		cursoField = new JTextField();
		GridBagConstraints gbc_cursoField = new GridBagConstraints();
		gbc_cursoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_cursoField.gridx = 1;
		gbc_cursoField.gridy = 4;
		panel.add(cursoField, gbc_cursoField);
		cursoField.setColumns(10);
		

	}
}
