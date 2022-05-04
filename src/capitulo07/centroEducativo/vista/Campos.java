package capitulo07.centroEducativo.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import capitulo07.centroEducativo.ErrorBBDDException;
import capitulo07.centroEducativo.ImposibleConectarException;
import capitulo07.centroEducativo.modelo.TipologiaSexo;
import capitulo07.centroEducativo.modelo.controladores.ControladorEstudiante;
import capitulo07.centroEducativo.modelo.controladores.ControladorTipologiaSexo;

import java.awt.Insets;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import java.nio.file.Files;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Campos extends JPanel {
	private JTextField nombreField;
	private JTextField apellido1Field;
	private JTextField apellido2Field;
	private JTextField dniField;
	private JTextField direccionField;
	private JTextField emailField;
	private JTextField telefonoField;
	private JLabel lblSexo;
	private JComboBox sexocomboBox;
	private JScrollPane scrollPane;
	private byte[] imagenEnArrayDeBytes;
	private JButton btnCargarImagen;

	/**
	 * Create the panel.
	 */
	public Campos() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 116, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);
		
		nombreField = new JTextField();
		GridBagConstraints gbc_nombreField = new GridBagConstraints();
		gbc_nombreField.insets = new Insets(0, 0, 5, 5);
		gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreField.gridx = 1;
		gbc_nombreField.gridy = 0;
		add(nombreField, gbc_nombreField);
		nombreField.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		JLabel lblApellido1 = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido1 = new GridBagConstraints();
		gbc_lblApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido1.gridx = 0;
		gbc_lblApellido1.gridy = 1;
		add(lblApellido1, gbc_lblApellido1);
		
		apellido1Field = new JTextField();
		GridBagConstraints gbc_apellido1Field = new GridBagConstraints();
		gbc_apellido1Field.insets = new Insets(0, 0, 5, 5);
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
		gbc_apellido2Field.insets = new Insets(0, 0, 5, 5);
		gbc_apellido2Field.fill = GridBagConstraints.HORIZONTAL;
		gbc_apellido2Field.gridx = 1;
		gbc_apellido2Field.gridy = 2;
		add(apellido2Field, gbc_apellido2Field);
		apellido2Field.setColumns(10);
		
		lblSexo = new JLabel("Sexo");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 0;
		gbc_lblSexo.gridy = 3;
		add(lblSexo, gbc_lblSexo);
		
		sexocomboBox = new JComboBox<TipologiaSexo>();
		GridBagConstraints gbc_sexocomboBox = new GridBagConstraints();
		gbc_sexocomboBox.insets = new Insets(0, 0, 5, 5);
		gbc_sexocomboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_sexocomboBox.gridx = 1;
		gbc_sexocomboBox.gridy = 3;
		add(sexocomboBox, gbc_sexocomboBox);
		
		JLabel lblDni = new JLabel("Dni");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 0;
		gbc_lblDni.gridy = 4;
		add(lblDni, gbc_lblDni);
		
		dniField = new JTextField();
		GridBagConstraints gbc_dniField = new GridBagConstraints();
		gbc_dniField.insets = new Insets(0, 0, 5, 5);
		gbc_dniField.fill = GridBagConstraints.HORIZONTAL;
		gbc_dniField.gridx = 1;
		gbc_dniField.gridy = 4;
		add(dniField, gbc_dniField);
		dniField.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 0;
		gbc_lblDireccion.gridy = 5;
		add(lblDireccion, gbc_lblDireccion);
		
		direccionField = new JTextField();
		GridBagConstraints gbc_direccionField = new GridBagConstraints();
		gbc_direccionField.insets = new Insets(0, 0, 5, 5);
		gbc_direccionField.fill = GridBagConstraints.HORIZONTAL;
		gbc_direccionField.gridx = 1;
		gbc_direccionField.gridy = 5;
		add(direccionField, gbc_direccionField);
		direccionField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		add(lblEmail, gbc_lblEmail);
		
		emailField = new JTextField();
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(0, 0, 5, 5);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 1;
		gbc_emailField.gridy = 6;
		add(emailField, gbc_emailField);
		emailField.setColumns(10);
		
		btnCargarImagen = new JButton("");
		btnCargarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
				actualizarImagenEnTabla();
			}
		});
		btnCargarImagen.setIcon(new ImageIcon(Campos.class.getResource("/capitulo07/resources/ruedadentada.png")));
		GridBagConstraints gbc_btnCargarImagen = new GridBagConstraints();
		gbc_btnCargarImagen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCargarImagen.insets = new Insets(0, 0, 5, 0);
		gbc_btnCargarImagen.gridx = 2;
		gbc_btnCargarImagen.gridy = 6;
		add(btnCargarImagen, gbc_btnCargarImagen);
		
		JLabel lblTelefono = new JLabel("Telefono");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.insets = new Insets(0, 0, 0, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 7;
		add(lblTelefono, gbc_lblTelefono);
		
		telefonoField = new JTextField();
		GridBagConstraints gbc_telefonoField = new GridBagConstraints();
		gbc_telefonoField.insets = new Insets(0, 0, 0, 5);
		gbc_telefonoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_telefonoField.gridx = 1;
		gbc_telefonoField.gridy = 7;
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
	
	
	public JComboBox getSexocomboBox() {
		return sexocomboBox;
	}

	public void setSexocomboBox(JComboBox sexocomboBox) {
		this.sexocomboBox = sexocomboBox;
	}

	public void cargarValoresSexoEnJComboBox () throws ErrorBBDDException {
		// Cargamos valores dentro del combobox
		List<TipologiaSexo> lista = ControladorTipologiaSexo.getAll();
		for (int i = 0; i < lista.size(); i++) {
			sexocomboBox.addItem(lista.get(i));
		}
	}
    
	public void seleccionarSexoEnJComboBox (int idTipologia) {
		for (int i = 0; i < sexocomboBox.getItemCount(); i++) {
			if ( ((TipologiaSexo) sexocomboBox.getItemAt(i)).getId() == idTipologia) {
				sexocomboBox.setSelectedIndex(i);
			}
		}
	}
    
	public int getIdSexoSeleccionadoEnJComboBox () {
		return ((TipologiaSexo) sexocomboBox.getSelectedItem()).getId();
	}
	
	private void seleccionaImagen () {
		JFileChooser jfileChooser = new JFileChooser();
		
		// Configurando el componente
		
		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() &&
						(f.getAbsolutePath().endsWith(".jpg") || 
								f.getAbsolutePath().endsWith(".jpeg")|| 
								f.getAbsolutePath().endsWith(".png")|| 
								f.getAbsolutePath().endsWith(".gif")))) 
					return true;
				return false;
			}
		});
		
		// Abro el diálogo para la elección del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);
		
		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();
			
			if (fichero.isFile()) {
				try {
					this.imagenEnArrayDeBytes = Files.readAllBytes(fichero.toPath());
					mostrarImagen();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
		
	
	/**
	 * 
	 */
	private void mostrarImagen () {
		if (imagenEnArrayDeBytes != null && imagenEnArrayDeBytes.length > 0) {
			ImageIcon icono = new ImageIcon(imagenEnArrayDeBytes);
			JLabel lblIcono = new JLabel(icono);
			scrollPane.setViewportView(lblIcono);
		}
		else {
			JLabel lblIcono = new JLabel("Sin imagen");
			scrollPane.setViewportView(lblIcono);
		}

	}
	
	
	/**
	 * 
	 */
	private void actualizarImagenEnTabla() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		   
			Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://localhost/centroeducativo?serverTimezone=UTC","java", "Abcdefgh.1");
		   
			PreparedStatement ps = (PreparedStatement) conexion.
					prepareStatement("UPDATE centroeducativo.estudiante set imagen=? where id=?");
			
			ps.setBytes(1, imagenEnArrayDeBytes);
			ps.setInt(2, 1);
		   
			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados > 0) {
				JOptionPane.showMessageDialog(null, "Inserción correcta en la tabla");
			}
			
			// Cierre de los elementos
			ps.close();
			conexion.close();
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Imposible acceder al driver Mysql");
			ex.printStackTrace();
		}
		catch (SQLException ex) {
			System.out.println("Error en la ejecuci�n SQL: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	
}
