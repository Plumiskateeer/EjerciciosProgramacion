package capitulo07.gestionVentaCoches;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import capitulo07.gestionVentaCoches.modelo.Cliente;
import capitulo07.gestionVentaCoches.modelo.Coche;
import capitulo07.gestionVentaCoches.modelo.Concesionario;
import capitulo07.gestionVentaCoches.modelo.Fabricante;
import capitulo07.gestionVentaCoches.modelo.Venta;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorCliente;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorCoche;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorConcesionario;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorFabricante;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorVenta;
import capitulo07.gestionVentaCoches.modelo.controladores.ErrorBBDDException;

public class VisorVenta extends JPanel{
	private JComboBox<Coche> cocheCombo;
	private JComboBox<Cliente> clienteCombo;
	private JComboBox<Concesionario> concesionarioCombo;
	private JTextField fechaField;
	private JTextField precioField;
	private JButton btnPrimerElemento;
	private JButton btnAtras;
	private JButton btnSiguiente;
	private JButton btnUltimoElemento;
	private JButton btnNuevoRegistro;
	private JButton btnGuardarRegistro;
	private JButton btnEliminarRegistro;
	
	private static VisorVenta instance = null;
    private int id = 1, primerId, ultimoId;

    private int accion = 0;
	

	/**
	 * Create the application.
	 */
    
    public static VisorVenta getInstance() throws ErrorBBDDException {
        if(instance == null)
            instance = new VisorVenta();
        return instance;
    }
    
	public VisorVenta() throws ErrorBBDDException {
		initialize();
	}
	
	public void buscarPrimeroYUltimo() throws ErrorBBDDException {
        this.primerId = ControladorVenta.getAll().get(0).getId();
        this.ultimoId = ControladorVenta.getAll().get(ControladorVenta.getAll().size()-1).getId();
    }

	/**
	 * Initialize the contents of the frame.
	 * @throws ErrorBBDDException 
	 */
	private void initialize() throws ErrorBBDDException {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("Gestión de ventas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 2;
		gbc_lblTitulo.insets = new Insets(15, 0, 5, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		this.add(lblNewLabel_1, gbc_lblTitulo);
		
		JLabel lblNewLabel_2 = new JLabel("Coche:");
		GridBagConstraints gbc_lblidCoche = new GridBagConstraints();
		gbc_lblidCoche.anchor = GridBagConstraints.EAST;
		gbc_lblidCoche.insets = new Insets(0, 0, 5, 5);
		gbc_lblidCoche.gridx = 0;
		gbc_lblidCoche.gridy = 2;
		this.add(lblNewLabel_2, gbc_lblidCoche);
		
		cocheCombo = new JComboBox<>();
		GridBagConstraints gbc_jtfcomboCoche = new GridBagConstraints();
		gbc_jtfcomboCoche.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfcomboCoche.insets = new Insets(0, 0, 5, 5);
		gbc_jtfcomboCoche.gridx = 1;
		gbc_jtfcomboCoche.gridy = 2;
		this.add(cocheCombo, gbc_jtfcomboCoche);
		cocheCombo.setEditable(false);
		
		JLabel lblNewLabel_3 = new JLabel("Cliente:");
		GridBagConstraints gbc_lblidCliente = new GridBagConstraints();
		gbc_lblidCliente.anchor = GridBagConstraints.EAST;
		gbc_lblidCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblidCliente.gridx = 0;
		gbc_lblidCliente.gridy = 3;
		this.add(lblNewLabel_3, gbc_lblidCliente);
		
		clienteCombo = new JComboBox<>();
		GridBagConstraints gbc_jtfcomboCliente = new GridBagConstraints();
		gbc_jtfcomboCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfcomboCliente.insets = new Insets(0, 0, 5, 5);
		gbc_jtfcomboCliente.gridx = 1;
		gbc_jtfcomboCliente.gridy = 3;
		this.add(clienteCombo, gbc_jtfcomboCliente);
		clienteCombo.setEditable(false);
		
		JLabel lblNewLabel_4 = new JLabel("Concesionario:");
		GridBagConstraints gbc_lblidConcesionario = new GridBagConstraints();
		gbc_lblidConcesionario.anchor = GridBagConstraints.EAST;
		gbc_lblidConcesionario.insets = new Insets(0, 0, 5, 5);
		gbc_lblidConcesionario.gridx = 0;
		gbc_lblidConcesionario.gridy = 4;
		this.add(lblNewLabel_4, gbc_lblidConcesionario);
		
		concesionarioCombo = new JComboBox<>();
		GridBagConstraints gbc_jtfcomboConcesionario = new GridBagConstraints();
		gbc_jtfcomboConcesionario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfcomboConcesionario.insets = new Insets(0, 0, 5, 5);
		gbc_jtfcomboConcesionario.gridx = 1;
		gbc_jtfcomboConcesionario.gridy = 4;
		this.add(concesionarioCombo, gbc_jtfcomboConcesionario);
		concesionarioCombo.setEditable(false);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de venta:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		this.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		fechaField = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 5;
		this.add(fechaField, gbc_jtfFecha);
		fechaField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Precio de venta:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		this.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		precioField = new JTextField();
		GridBagConstraints gbc_jtfPrecio = new GridBagConstraints();
		gbc_jtfPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_jtfPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrecio.gridx = 1;
		gbc_jtfPrecio.gridy = 6;
		this.add(precioField, gbc_jtfPrecio);
		precioField.setColumns(10);
		
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
                cocheCombo.setEditable(true);
                clienteCombo.setEditable(true);
                concesionarioCombo.setEditable(true);
                fechaField.setText("");
                precioField.setText("");
            }
        });
        this.add(btnNuevoRegistro);
		
		btnGuardarRegistro = new JButton("Guardar");
        btnGuardarRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                	Venta v = new Venta(getId(),getIdClienteSeleccionadoEnJComboBox(), getIdConcesionarioSeleccionadoEnJComboBox(),getIdCocheSeleccionadoEnJComboBox(), sdf.parse(fechaField.getText()), Float.parseFloat(precioField.getText()));
                    if(getId()==0) {
                    	ControladorVenta.almacenarNuevo(v);
                        JOptionPane.showMessageDialog(null, "Registro introducido correctamente");
                        buscarPrimeroYUltimo();
                    }else{
                    	ControladorVenta.almacenarModificado(v);
                        JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
                    }
                } catch (ErrorBBDDException ex) {
                    JOptionPane.showMessageDialog(null,"No se pudo guardar o modificar el registro", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                cocheCombo.setEditable(false);
                clienteCombo.setEditable(false);
                concesionarioCombo.setEditable(false);
            }
        });
        this.add(btnGuardarRegistro);
		
		btnEliminarRegistro = new JButton("Eliminar");
        btnEliminarRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	ControladorVenta.eliminar(new Venta(getId(),2, 2,2,null,2f));
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
		cargarValoresCochesEnJComboBox();
		cargarValoresClientesEnJComboBox();
		cargarValoresConcesionariosEnJComboBox();
		
	}
	
	private void cargarValoresCochesEnJComboBox () throws ErrorBBDDException {
		// Cargamos valores dentro del combobox
		List<Coche> lista = ControladorCoche.getAll();
		for (int i = 0; i < lista.size(); i++) {
			cocheCombo.addItem(lista.get(i));
		}

	}
	
	private void cargarValoresClientesEnJComboBox () throws ErrorBBDDException {
		// Cargamos valores dentro del combobox
		List<Cliente> lista = ControladorCliente.getAll();
		for (int i = 0; i < lista.size(); i++) {
			clienteCombo.addItem(lista.get(i));
		}

	}
	
	private void cargarValoresConcesionariosEnJComboBox () throws ErrorBBDDException {
		// Cargamos valores dentro del combobox
		List<Concesionario> lista = ControladorConcesionario.getAll();
		for (int i = 0; i < lista.size(); i++) {
			concesionarioCombo.addItem(lista.get(i));
		}

	}

	/**
	 * 
	 * @param idFabricante
	 */
	private void seleccionarCocheEnJComboBox (int idCoche) {
		for (int i = 0; i < cocheCombo.getItemCount(); i++) {
			if ( ((Coche) cocheCombo.getItemAt(i)).getId() == idCoche) {
				cocheCombo.setSelectedIndex(i);
			}
		}
	}
	
	private void seleccionarClienteEnJComboBox (int idCliente) {
		for (int i = 0; i < clienteCombo.getItemCount(); i++) {
			if ( ((Cliente) clienteCombo.getItemAt(i)).getId() == idCliente) {
				clienteCombo.setSelectedIndex(i);
			}
		}
	}
	
	private void seleccionarConcesionarioEnJComboBox (int idConcesionario) {
		for (int i = 0; i < concesionarioCombo.getItemCount(); i++) {
			if ( ((Concesionario) concesionarioCombo.getItemAt(i)).getId() == idConcesionario) {
				concesionarioCombo.setSelectedIndex(i);
			}
		}
	}
	
	private int getIdCocheSeleccionadoEnJComboBox () {
		return ((Coche) cocheCombo.getSelectedItem()).getId();
	}
	
	private int getIdClienteSeleccionadoEnJComboBox () {
		return ((Cliente) clienteCombo.getSelectedItem()).getId();
	}
	
	private int getIdConcesionarioSeleccionadoEnJComboBox () {
		return ((Concesionario) concesionarioCombo.getSelectedItem()).getId();
	}
	
	private void cargarRegistro (int opcion) {
        setAccion(opcion);

        String consulta = comprobarBoton();
        try {
        	Venta v = ControladorVenta.getVenta(consulta);
            setId(v.getId());
            seleccionarCocheEnJComboBox(v.getIdCoche());
            seleccionarClienteEnJComboBox(v.getIdCliente());
            seleccionarConcesionarioEnJComboBox(v.getIdConcesionario());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            fechaField.setText(sdf.format(v.getFecha()));
            precioField.setText(v.getPrecioventa()+"");
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
            case 0: consulta = "select * from venta order by id asc limit 1"; break;
            case 1: consulta = "select * from venta where id <" + getId() + " order by id desc limit 1"; break;
            case 2: consulta = "select * from venta where id >" + getId() + " order by id asc limit 1"; break;
            case 3: consulta = "select * from venta order by id desc limit 1"; break;
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
