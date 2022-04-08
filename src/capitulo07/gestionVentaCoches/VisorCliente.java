package capitulo07.gestionVentaCoches;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import capitulo07.gestionVentaCoches.modelo.Cliente;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorCliente;
import capitulo07.gestionVentaCoches.modelo.controladores.ErrorBBDDException;

public class VisorCliente extends JPanel{
	private static JTextField nombreField;
	private static JTextField apellidoField;
	private static JTextField localidadField;
	private static JTextField dniField;
	private static JTextField fechaField;
	private static JCheckBox activoField;
	private JButton btnPrimerElemento;
	private JButton btnAtras;
	private JButton btnSiguiente;
	private JButton btnUltimoElemento;
	private JButton btnNuevoRegistro;
	private JButton btnGuardarRegistro;
	private JButton btnEliminarRegistro;
	
	private static VisorCliente instance = null;
    private int id = 1, primerId, ultimoId;

    private int accion = 0;

	/**
	 * Create the application.
	 */
    
    public static VisorCliente getInstance() throws ErrorBBDDException {
        if(instance == null)
            instance = new VisorCliente();
        return instance;
    }
    
	public VisorCliente() {
		initialize();
	}
	
	public void buscarPrimeroYUltimo() throws ErrorBBDDException {
        this.primerId = ControladorCliente.getAll().get(0).getId();
        this.ultimoId = ControladorCliente.getAll().get(ControladorCliente.getAll().size()-1).getId();
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("Gestión de clientes");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(15, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		this.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		this.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		nombreField = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		this.add(nombreField, gbc_jtfNombre);
		nombreField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Apellido:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 3;
		this.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		apellidoField = new JTextField();
		GridBagConstraints gbc_jtfApellido = new GridBagConstraints();
		gbc_jtfApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido.gridx = 1;
		gbc_jtfApellido.gridy = 3;
		this.add(apellidoField, gbc_jtfApellido);
		apellidoField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Localidad:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		this.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		localidadField = new JTextField();
		GridBagConstraints gbc_jtfLocalidad = new GridBagConstraints();
		gbc_jtfLocalidad.insets = new Insets(0, 0, 5, 5);
		gbc_jtfLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLocalidad.gridx = 1;
		gbc_jtfLocalidad.gridy = 4;
		this.add(localidadField, gbc_jtfLocalidad);
		localidadField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		this.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		dniField = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		this.add(dniField, gbc_jtfDni);
		dniField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha Nacimiento:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		this.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		fechaField = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 6;
		this.add(fechaField, gbc_jtfFecha);
		fechaField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Activo:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		this.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		activoField = new JCheckBox();
		GridBagConstraints gbc_jtfActivo = new GridBagConstraints();
		gbc_jtfActivo.insets = new Insets(0, 0, 5, 5);
		gbc_jtfActivo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfActivo.gridx = 1;
		gbc_jtfActivo.gridy = 7;
		this.add(activoField, gbc_jtfActivo);
		
		btnPrimerElemento = new JButton("<<");
        btnPrimerElemento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarRegistro(0);
            }
        });
        this.add(btnPrimerElemento);
		
		btnAtras = new JButton("<");
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarRegistro(1);
            }
        });
        this.add(btnAtras);
		
		btnSiguiente = new JButton(">");
        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarRegistro(2);
            }
        });
        this.add(btnSiguiente);
		
		btnUltimoElemento = new JButton(">>");
        btnUltimoElemento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarRegistro(3);
            }
        });
        this.add(btnUltimoElemento);
		
		btnNuevoRegistro = new JButton("Nuevo");
        btnNuevoRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setId(0);
                nombreField.setText("");
                apellidoField.setText("");
                localidadField.setText("");
                dniField.setText("");
                fechaField.setText("");
                activoField.setText("");
            }
        });
        this.add(btnNuevoRegistro);
		
		btnGuardarRegistro = new JButton("Guardar");
        btnGuardarRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            	Cliente c = null;
				try {
					c = new Cliente(getId(),nombreField.getText(), apellidoField.getText(), localidadField.getText(), dniField.getText(),sdf.parse(fechaField.getText()),activoField.isSelected());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                try {
                    if(getId()==0) {
                    	ControladorCliente.almacenarNuevo(c);
                        JOptionPane.showMessageDialog(null, "Registro introducido correctamente");
                        buscarPrimeroYUltimo();
                    }else{
                    	ControladorCliente.almacenarModificado(c);
                        JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
                    }
                } catch (ErrorBBDDException ex) {
                    JOptionPane.showMessageDialog(null,"No se pudo guardar o modificar el registro", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.add(btnGuardarRegistro);
		
		btnEliminarRegistro = new JButton("Eliminar");
        btnEliminarRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	ControladorCliente.eliminar(new Cliente(getId(),null,null,null,null,null,false));
                    JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");

                    if (getId() <= getUltimoId() && getId() > getPrimerId()) {
                        btnAtras.doClick();
                        btnSiguiente.setEnabled(false);
                        btnUltimoElemento.setEnabled(false);
                    }else btnSiguiente.doClick();
                    buscarPrimeroYUltimo();
                } catch (ErrorBBDDException ex) {
                    JOptionPane.showMessageDialog(null,"No se pudo eliminar el registro", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        this.add(btnEliminarRegistro);

        cargarRegistro(0);
        btnPrimerElemento.setEnabled(false);
        btnAtras.setEnabled(false);
		
	}
	private void cargarRegistro (int opcion) {
        setAccion(opcion);

        String consulta = comprobarBoton();
        try {
        	Cliente cl  = ControladorCliente.getCliente(consulta);
            setId(cl.getId());
            nombreField.setText(cl.getNombre() + " " + cl.getApellidos());
            apellidoField.setText(cl.getApellidos());
            localidadField.setText(cl.getLocalidad());
            dniField.setText(cl.getDniNie());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fechaField.setText(sdf.format(cl.getFechaNac()));
            activoField.setSelected(cl.getActivo());
        } catch (ErrorBBDDException ex) {
            ex.printStackTrace();
        }
        comprobarEstadoBotones();
    }

    /**
     *
     */
    private void comprobarEstadoBotones() {
        if(getId() == getPrimerId()){
            btnAtras.setEnabled(false);
            btnPrimerElemento.setEnabled(false);
            btnSiguiente.setEnabled(true);
            btnUltimoElemento.setEnabled(true);
        }else if (getId() == getUltimoId()) {
            btnAtras.setEnabled(true);
            btnPrimerElemento.setEnabled(true);
            btnSiguiente.setEnabled(false);
            btnUltimoElemento.setEnabled(false);
        }else if(getAccion()==0 || getAccion()==1){
            btnSiguiente.setEnabled(true);
            btnUltimoElemento.setEnabled(true);
        }else if(getAccion()==2 || getAccion()==3){
            btnAtras.setEnabled(true);
            btnPrimerElemento.setEnabled(true);
        }
    }

    public String comprobarBoton(){
        String consulta = null;
        switch (getAccion()){
            case 0: consulta = "select * from cliente order by id asc limit 1"; break;
            case 1: consulta = "select * from cliente where id <" + getId() + " order by id desc limit 1"; break;
            case 2: consulta = "select * from cliente where id >" + getId() + " order by id asc limit 1"; break;
            case 3: consulta = "select * from cliente order by id desc limit 1"; break;
            default: break;
        }
        return consulta;
    }

    public int getAccion(){
        return this.accion;
    }
    public void setAccion(int accion){
        this.accion = accion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getPrimerId() {
        return primerId;
    }

    public void setPrimerId(int primerId) {
        this.primerId = primerId;
    }

    public int getUltimoId() {
        return ultimoId;
    }

}
