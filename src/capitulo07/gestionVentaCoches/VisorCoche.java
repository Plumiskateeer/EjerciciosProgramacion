package capitulo07.gestionVentaCoches;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import capitulo07.gestionVentaCoches.modelo.Coche;
import capitulo07.gestionVentaCoches.modelo.Fabricante;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorCoche;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorFabricante;
import capitulo07.gestionVentaCoches.modelo.controladores.ErrorBBDDException;

public class VisorCoche extends JPanel{
	
	private JComboBox<Fabricante> idFabricanteField;
	private JTextField bastidorField;
	private JTextField modeloField;
	private JTextField colorField;
	private JButton btnPrimerElemento;
	private JButton btnAtras;
	private JButton btnSiguiente;
	private JButton btnUltimoElemento;
	private JButton btnNuevoRegistro;
	private JButton btnGuardarRegistro;
	private JButton btnEliminarRegistro;
	
	private static VisorCoche instance = null;
    private int id = 1, primerId, ultimoId;

    private int accion = 0;
	

	/**
	 * Create the application.
	 */
    
    public static VisorCoche getInstance() throws ErrorBBDDException {
        if(instance == null)
            instance = new VisorCoche();
        return instance;
    }
    
	public VisorCoche() throws ErrorBBDDException {
		initialize();
	}
	
	public void buscarPrimeroYUltimo() throws ErrorBBDDException {
        this.primerId = ControladorCoche.getAll().get(0).getId();
        this.ultimoId = ControladorCoche.getAll().get(ControladorCoche.getAll().size()-1).getId();
    }

	/**
	 * Initialize the contents of the frame.
	 * @throws ErrorBBDDException 
	 */
	private void initialize() throws ErrorBBDDException {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("Gestión de coches");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 2;
		gbc_lblTitulo.insets = new Insets(15, 0, 5, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		this.add(lblNewLabel_1, gbc_lblTitulo);
		
		JLabel lblNewLabel_2 = new JLabel("ID fab:");
		GridBagConstraints gbc_lblidFab = new GridBagConstraints();
		gbc_lblidFab.anchor = GridBagConstraints.EAST;
		gbc_lblidFab.insets = new Insets(0, 0, 5, 5);
		gbc_lblidFab.gridx = 0;
		gbc_lblidFab.gridy = 2;
		this.add(lblNewLabel_2, gbc_lblidFab);
		
		idFabricanteField = new JComboBox<>();
		GridBagConstraints gbc_jtfIdFab = new GridBagConstraints();
		gbc_jtfIdFab.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfIdFab.insets = new Insets(0, 0, 5, 5);
		gbc_jtfIdFab.gridx = 1;
		gbc_jtfIdFab.gridy = 2;
		this.add(idFabricanteField, gbc_jtfIdFab);
		idFabricanteField.setEditable(false);
		
		JLabel lblNewLabel_3 = new JLabel("Bastidor:");
		GridBagConstraints gbc_lblBastidor = new GridBagConstraints();
		gbc_lblBastidor.insets = new Insets(0, 0, 5, 5);
		gbc_lblBastidor.gridx = 0;
		gbc_lblBastidor.gridy = 3;
		this.add(lblNewLabel_3, gbc_lblBastidor);
		
		bastidorField = new JTextField();
		GridBagConstraints gbc_jtfBastidor = new GridBagConstraints();
		gbc_jtfBastidor.insets = new Insets(0, 0, 5, 5);
		gbc_jtfBastidor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfBastidor.gridx = 1;
		gbc_jtfBastidor.gridy = 3;
		this.add(bastidorField, gbc_jtfBastidor);
		bastidorField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Modelo:");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 0;
		gbc_lblModelo.gridy = 4;
		this.add(lblNewLabel_4, gbc_lblModelo);
		
		modeloField = new JTextField();
		GridBagConstraints gbc_jtfModelo = new GridBagConstraints();
		gbc_jtfModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfModelo.insets = new Insets(0, 0, 5, 5);
		gbc_jtfModelo.gridx = 1;
		gbc_jtfModelo.gridy = 4;
		this.add(modeloField, gbc_jtfModelo);
		modeloField.setColumns(10);
		
		colorField = new JTextField();
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 5;
		this.add(colorField, gbc_jtfColor);
		colorField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Color:");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.EAST;
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 5;
		this.add(lblNewLabel_5, gbc_lblColor);
		
		
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
                idFabricanteField.setEditable(true);
                bastidorField.setText("");
                modeloField.setText("");
                colorField.setText("");
            }
        });
        this.add(btnNuevoRegistro);
		
		btnGuardarRegistro = new JButton("Guardar");
        btnGuardarRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                	Coche c = new Coche(getId(),getIdFabricanteSeleccionadoEnJComboBox(),bastidorField.getText(),modeloField.getText(),colorField.getText());
                    if(getId()==0) {
                    	ControladorCoche.almacenarNuevo(c);
                        JOptionPane.showMessageDialog(null, "Registro introducido correctamente");
                        buscarPrimeroYUltimo();
                    }else{
                    	ControladorCoche.almacenarModificado(c);
                        JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
                    }
                } catch (ErrorBBDDException ex) {
                    JOptionPane.showMessageDialog(null,"No se pudo guardar o modificar el registro", "Error", JOptionPane.ERROR_MESSAGE);
                }
                idFabricanteField.setEditable(false);
            }
        });
        this.add(btnGuardarRegistro);
		
		btnEliminarRegistro = new JButton("Eliminar");
        btnEliminarRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	ControladorCoche.eliminar(new Coche(getId(),0, null,null,null));
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
		cargarValoresFabricantesEnJComboBox();
		
	}
	
	private void cargarValoresFabricantesEnJComboBox () throws ErrorBBDDException {
		// Cargamos valores dentro del combobox
		List<Fabricante> lista = ControladorFabricante.getAll();
		for (int i = 0; i < lista.size(); i++) {
			idFabricanteField.addItem(lista.get(i));
		}

	}

	/**
	 * 
	 * @param idFabricante
	 */
	private void seleccionarFabricanteEnJComboBox (int idFabricante) {
		for (int i = 0; i < idFabricanteField.getItemCount(); i++) {
			if ( ((Fabricante) idFabricanteField.getItemAt(i)).getId() == idFabricante) {
				idFabricanteField.setSelectedIndex(i);
			}
		}
	}
	
	
	private int getIdFabricanteSeleccionadoEnJComboBox () {
		return ((Fabricante) idFabricanteField.getSelectedItem()).getId();
	}
	
	private void cargarRegistro (int opcion) {
        setAccion(opcion);

        String consulta = comprobarBoton();
        try {
        	Coche c = ControladorCoche.getCoche(consulta);
            setId(c.getId());
            seleccionarFabricanteEnJComboBox(c.getIdfabricante());
            bastidorField.setText(c.getBastidor());
            modeloField.setText(c.getModelo());
            colorField.setText(c.getColor());
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
            case 0: consulta = "select * from coche order by id asc limit 1"; break;
            case 1: consulta = "select * from coche where id <" + getId() + " order by id desc limit 1"; break;
            case 2: consulta = "select * from coche where id >" + getId() + " order by id asc limit 1"; break;
            case 3: consulta = "select * from coche order by id desc limit 1"; break;
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
