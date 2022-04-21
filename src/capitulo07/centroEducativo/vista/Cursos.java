package capitulo07.centroEducativo.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class Cursos extends JPanel {
	private static Cursos instance = null;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 * 
	 */
	
	public static Cursos getInstance() {
		if(instance == null) {
			instance = new Cursos();
		}
		return instance;
	}
	
	
	public Cursos() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnPrimerElemento = new JButton("");
		btnPrimerElemento.setIcon(new ImageIcon(Cursos.class.getResource("/capitulo07/resources/gotostart.png")));
		toolBar.add(btnPrimerElemento);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(Cursos.class.getResource("/capitulo07/resources/previous.png")));
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.setIcon(new ImageIcon(Cursos.class.getResource("/capitulo07/resources/next.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimoElemento = new JButton("");
		btnUltimoElemento.setIcon(new ImageIcon(Cursos.class.getResource("/capitulo07/resources/gotoend.png")));
		toolBar.add(btnUltimoElemento);
		
		JButton btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(Cursos.class.getResource("/capitulo07/resources/nuevo.png")));
		toolBar.add(btnNuevo);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(Cursos.class.getResource("/capitulo07/resources/guardar.png")));
		toolBar.add(btnGuardar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(Cursos.class.getResource("/capitulo07/resources/eliminar.png")));
		toolBar.add(btnEliminar);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 4, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Cursos");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		
		JLabel lbId = new JLabel("Id :");
		GridBagConstraints gbc_lbId = new GridBagConstraints();
		gbc_lbId.insets = new Insets(0, 0, 5, 5);
		gbc_lbId.gridx = 0;
		gbc_lbId.gridy = 1;
		panel.add(lbId, gbc_lbId);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lbDescripcion = new JLabel("Descripcion :");
		GridBagConstraints gbc_lbDescripcion = new GridBagConstraints();
		gbc_lbDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lbDescripcion.gridx = 0;
		gbc_lbDescripcion.gridy = 2;
		panel.add(lbDescripcion, gbc_lbDescripcion);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		

	}
}
