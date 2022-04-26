package capitulo07.centroEducativo.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class Campos extends JPanel {
	private JTextField nombreField;
	private JTextField apellido1Field;
	private JTextField apellido2Field;
	private JTextField dniField;
	private JTextField direccionField;
	private JTextField emailField;
	private JTextField telefonoField;

	/**
	 * Create the panel.
	 */
	public Campos() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);
		
		nombreField = new JTextField();
		GridBagConstraints gbc_nombreField = new GridBagConstraints();
		gbc_nombreField.insets = new Insets(0, 0, 5, 0);
		gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreField.gridx = 1;
		gbc_nombreField.gridy = 0;
		add(nombreField, gbc_nombreField);
		nombreField.setColumns(10);
		
		JLabel lblApellido1 = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido1 = new GridBagConstraints();
		gbc_lblApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido1.gridx = 0;
		gbc_lblApellido1.gridy = 1;
		add(lblApellido1, gbc_lblApellido1);
		
		apellido1Field = new JTextField();
		GridBagConstraints gbc_apellido1Field = new GridBagConstraints();
		gbc_apellido1Field.insets = new Insets(0, 0, 5, 0);
		gbc_apellido1Field.fill = GridBagConstraints.HORIZONTAL;
		gbc_apellido1Field.gridx = 1;
		gbc_apellido1Field.gridy = 1;
		add(apellido1Field, gbc_apellido1Field);
		apellido1Field.setColumns(10);
		
		JLabel lblApellido2 = new JLabel("2do Apellido");
		GridBagConstraints gbc_lblApellido2 = new GridBagConstraints();
		gbc_lblApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido2.gridx = 0;
		gbc_lblApellido2.gridy = 2;
		add(lblApellido2, gbc_lblApellido2);
		
		apellido2Field = new JTextField();
		GridBagConstraints gbc_apellido2Field = new GridBagConstraints();
		gbc_apellido2Field.insets = new Insets(0, 0, 5, 0);
		gbc_apellido2Field.fill = GridBagConstraints.HORIZONTAL;
		gbc_apellido2Field.gridx = 1;
		gbc_apellido2Field.gridy = 2;
		add(apellido2Field, gbc_apellido2Field);
		apellido2Field.setColumns(10);
		
		JLabel lblDni = new JLabel("Dni");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 3;
		add(lblDni, gbc_lblDni);
		
		dniField = new JTextField();
		GridBagConstraints gbc_dniField = new GridBagConstraints();
		gbc_dniField.insets = new Insets(0, 0, 5, 0);
		gbc_dniField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dniField.gridx = 1;
		gbc_dniField.gridy = 3;
		add(dniField, gbc_dniField);
		dniField.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 0;
		gbc_lblDireccion.gridy = 4;
		add(lblDireccion, gbc_lblDireccion);
		
		direccionField = new JTextField();
		GridBagConstraints gbc_direccionField = new GridBagConstraints();
		gbc_direccionField.insets = new Insets(0, 0, 5, 0);
		gbc_direccionField.fill = GridBagConstraints.HORIZONTAL;
		gbc_direccionField.gridx = 1;
		gbc_direccionField.gridy = 4;
		add(direccionField, gbc_direccionField);
		direccionField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 5;
		add(lblEmail, gbc_lblEmail);
		
		emailField = new JTextField();
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(0, 0, 5, 0);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 5;
		add(emailField, gbc_emailField);
		emailField.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.insets = new Insets(0, 0, 0, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 6;
		add(lblTelefono, gbc_lblTelefono);
		
		telefonoField = new JTextField();
		GridBagConstraints gbc_telefonoField = new GridBagConstraints();
		gbc_telefonoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_telefonoField.gridx = 1;
		gbc_telefonoField.gridy = 6;
		add(telefonoField, gbc_telefonoField);
		telefonoField.setColumns(10);

	}

	public JTextField getNombreField() {
		return nombreField;
	}

	public void setNombreField(String nombreField) {
		this.nombreField.setText(nombreField);
	}

	public JTextField getApellido1Field() {
		return apellido1Field;
	}

	public void setApellido1Field(String apellido1Field) {
		this.apellido1Field.setText(apellido1Field);
	}

	public JTextField getApellido2Field() {
		return apellido2Field;
	}

	public void setApellido2Field(String apellido2Field) {
		this.apellido2Field.setText(apellido2Field);
	}

	public JTextField getDniField() {
		return dniField;
	}

	public void setDniField(String dniField) {
		this.dniField.setText(dniField);
	}

	public JTextField getDireccionField() {
		return direccionField;
	}

	public void setDireccionField(String direccionField) {
		this.direccionField.setText(direccionField);
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public void setEmailField(String emailField) {
		this.emailField.setText(emailField);
	}

	public JTextField getTelefonoField() {
		return telefonoField;
	}

	public void setTelefonoField(String telefonoField) {
		this.telefonoField.setText(telefonoField);
	}
	
	

}
