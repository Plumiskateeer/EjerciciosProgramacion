package capitulo07.centroEducativo.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import capitulo07.centroEducativo.ErrorBBDDException;
import capitulo07.centroEducativo.modelo.Curso;
import capitulo07.centroEducativo.modelo.controladores.ControladorCurso;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cursos extends JPanel {
	private static Cursos instance = null;
	private JTextField idField;
	private JTextField descripcionField;
	private int id = 1, primerId, ultimoId;

    private int accion = 0;
	private JButton btnPrimerElemento;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimoElemento;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEliminar;

	/**
	 * Create the panel.
	 * @throws ErrorBBDDException 
	 * 
	 */
	
	public static Cursos getInstance() throws ErrorBBDDException {
		if(instance == null) {
			instance = new Cursos();
		}
		return instance;
	}
	
	
	public Cursos() throws ErrorBBDDException {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		btnPrimerElemento = new JButton("");
		btnPrimerElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarRegistro(0);
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrimerElemento.setIcon(new ImageIcon(Cursos.class.getResource("/capitulo07/resources/gotostart.png")));
		toolBar.add(btnPrimerElemento);
		
		btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarRegistro(1);
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAnterior.setIcon(new ImageIcon(Cursos.class.getResource("/capitulo07/resources/previous.png")));
		toolBar.add(btnAnterior);
		
		btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarRegistro(2);
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSiguiente.setIcon(new ImageIcon(Cursos.class.getResource("/capitulo07/resources/next.png")));
		toolBar.add(btnSiguiente);
		
		btnUltimoElemento = new JButton("");
		btnUltimoElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarRegistro(3);
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUltimoElemento.setIcon(new ImageIcon(Cursos.class.getResource("/capitulo07/resources/gotoend.png")));
		toolBar.add(btnUltimoElemento);
		
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setId(0);
                idField.setText("");
                descripcionField.setText("");
			}
		});
		btnNuevo.setIcon(new ImageIcon(Cursos.class.getResource("/capitulo07/resources/nuevo.png")));
		toolBar.add(btnNuevo);
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curso c = new Curso(getId(), descripcionField.getText());
				try {
                    if(getId()==0) {
                        ControladorCurso.almacenarNuevo(c);
                        JOptionPane.showMessageDialog(null, "Registro introducido correctamente");
                        buscarPrimeroYUltimo();
                    }else{
                    	ControladorCurso.almacenarModificado(c);
                        JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
                    }
                } catch (ErrorBBDDException e1) {
                	JOptionPane.showMessageDialog(null,"No se pudo guardar o modificar el registro", "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {
					comprobarEstadoBotones();
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				btnSiguiente.doClick();
			}
		});
		btnGuardar.setIcon(new ImageIcon(Cursos.class.getResource("/capitulo07/resources/guardar.png")));
		toolBar.add(btnGuardar);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    ControladorCurso.eliminar(new Curso(getId(),null));
                    JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");

                    if (getId() > getPrimerId()) {
                        btnAnterior.doClick();
                    }else btnSiguiente.doClick();
                    buscarPrimeroYUltimo();
                } catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
                	JOptionPane.showMessageDialog(null,"No se pudo eliminar el registro", "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {
					comprobarEstadoBotones();
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
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
		
		idField = new JTextField();
		GridBagConstraints gbc_idField = new GridBagConstraints();
		gbc_idField.insets = new Insets(0, 0, 5, 5);
		gbc_idField.gridx = 1;
		gbc_idField.gridy = 1;
		panel.add(idField, gbc_idField);
		idField.setColumns(10);
		idField.setEnabled(false);
		
		JLabel lbDescripcion = new JLabel("Descripcion :");
		GridBagConstraints gbc_lbDescripcion = new GridBagConstraints();
		gbc_lbDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lbDescripcion.gridx = 0;
		gbc_lbDescripcion.gridy = 2;
		panel.add(lbDescripcion, gbc_lbDescripcion);
		
		descripcionField = new JTextField();
		GridBagConstraints gbc_descripcionField = new GridBagConstraints();
		gbc_descripcionField.insets = new Insets(0, 0, 5, 5);
		gbc_descripcionField.gridx = 1;
		gbc_descripcionField.gridy = 2;
		panel.add(descripcionField, gbc_descripcionField);
		descripcionField.setColumns(10);
	
		cargarRegistro(0);
        btnPrimerElemento.setEnabled(false);
        btnAnterior.setEnabled(false);
	}
	
	private void cargarRegistro (int opcion) throws ErrorBBDDException {
        setAccion(opcion);

        String consulta = comprobarBoton();
        try {
        	Curso c  = ControladorCurso.getCurso(consulta);
            setId(c.getId());
            idField.setText(c.getId()+"");
            descripcionField.setText(c.getDescripcion());
        } catch (ErrorBBDDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        comprobarEstadoBotones();
    }
	
	public void buscarPrimeroYUltimo() throws ErrorBBDDException {
        this.primerId = ControladorCurso.getAll().get(0).getId();
        this.ultimoId = ControladorCurso.getAll().get(ControladorCurso.getAll().size()-1).getId();
    }
	
	private void comprobarEstadoBotones() throws ErrorBBDDException {
		int accion = getAccion();
		setAccion(1);
		if (ControladorCurso.getCurso(comprobarBoton()) == null) {
            btnPrimerElemento.setEnabled(false);
            btnAnterior.setEnabled(false);
        }
        else {
        	btnPrimerElemento.setEnabled(true);
        	btnAnterior.setEnabled(true);
        }
        // Si no existe un siguiente deshabilito los botones de último y siguiente
      	setAccion(2);
        boolean existeSiguiente = (ControladorCurso.getCurso(comprobarBoton()) == null)? false : true;
        btnUltimoElemento.setEnabled(existeSiguiente);
        btnSiguiente.setEnabled(existeSiguiente);
        
        setAccion(accion);
	}

    public String comprobarBoton(){
        String consulta = null;
        switch (getAccion()){
            case 0: consulta = "select * from curso order by id asc limit 1"; break;
            case 1: consulta = "select * from curso where id <" + getId() + " order by id desc limit 1"; break;
            case 2: consulta = "select * from curso where id >" + getId() + " order by id asc limit 1"; break;
            case 3: consulta = "select * from curso order by id desc limit 1"; break;
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
