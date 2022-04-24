package capitulo07.centroEducativo.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

import capitulo07.centroEducativo.ErrorBBDDException;
import capitulo07.centroEducativo.modelo.Curso;
import capitulo07.centroEducativo.modelo.Materia;
import capitulo07.centroEducativo.modelo.controladores.ControladorCurso;
import capitulo07.centroEducativo.modelo.controladores.ControladorMateria;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Materias extends JPanel {
	private JTextField idField;
	private JTextField nombreField;
	private JTextField acronimoField;
	private static Materias instance = null;
	private JButton btnPrimerElemento;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimoElemento;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEliminar;
	private int id = 1, primerId, ultimoId;

    private int accion = 0;
    private JComboBox<Curso> cursoComboBox;

	/**
	 * Create the panel.
	 * @throws ErrorBBDDException 
	 */
	
	public static Materias getInstance() throws ErrorBBDDException {
		if(instance == null) {
			instance = new Materias();
		}
		return instance;
	}
	public Materias() throws ErrorBBDDException {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		btnPrimerElemento = new JButton("");
		btnPrimerElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarRegistro(0);
			}
		});
		btnPrimerElemento.setIcon(new ImageIcon(Materias.class.getResource("/capitulo07/resources/gotostart.png")));
		toolBar.add(btnPrimerElemento);
		
		btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarRegistro(1);
			}
		});
		btnAnterior.setIcon(new ImageIcon(Materias.class.getResource("/capitulo07/resources/previous.png")));
		toolBar.add(btnAnterior);
		
		btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarRegistro(2);
			}
		});
		btnSiguiente.setIcon(new ImageIcon(Materias.class.getResource("/capitulo07/resources/next.png")));
		toolBar.add(btnSiguiente);
		
		btnUltimoElemento = new JButton("");
		btnUltimoElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarRegistro(3);
			}
		});
		btnUltimoElemento.setIcon(new ImageIcon(Materias.class.getResource("/capitulo07/resources/gotoend.png")));
		toolBar.add(btnUltimoElemento);
		
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setId(0);
                idField.setText("0");
                nombreField.setText("");
                acronimoField.setText("");
                cursoComboBox.setEditable(true);
                cursoComboBox.setEnabled(true);
			}
		});
		btnNuevo.setIcon(new ImageIcon(Materias.class.getResource("/capitulo07/resources/nuevo.png")));
		toolBar.add(btnNuevo);
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Materia m = new Materia(getId(), nombreField.getText(), acronimoField.getText(),getIdCursoSeleccionadoEnJComboBox());
				try {
                    if(getId()==0) {
                        ControladorMateria.almacenarNuevo(m);
                        JOptionPane.showMessageDialog(null, "Registro introducido correctamente");
                        buscarPrimeroYUltimo();
                    }else{
                    	ControladorMateria.almacenarModificado(m);
                        JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
                    }
                } catch (ErrorBBDDException e1) {
                	JOptionPane.showMessageDialog(null,"No se pudo guardar o modificar el registro", "Error", JOptionPane.ERROR_MESSAGE);
				}
				comprobarEstadoBotones();
				cursoComboBox.setEditable(false);
                cursoComboBox.setEnabled(true);
			}
		});
		btnGuardar.setIcon(new ImageIcon(Materias.class.getResource("/capitulo07/resources/guardar.png")));
		toolBar.add(btnGuardar);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControladorMateria.eliminar(new Materia(getId(),null,null,0));
	                JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");
	
	                if (getId() <= getUltimoId() && getId() > getPrimerId()) {
	                    btnAnterior.doClick();
	                    btnSiguiente.setEnabled(false);
	                    btnUltimoElemento.setEnabled(false);
	                }else btnSiguiente.doClick();
	                buscarPrimeroYUltimo();
	            } catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
	            	JOptionPane.showMessageDialog(null,"No se pudo eliminar el registro", "Error", JOptionPane.ERROR_MESSAGE);
				}}
		});
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
		idField.setEnabled(false);
		
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
		
		cursoComboBox = new JComboBox();
		GridBagConstraints gbc_cursoComboBox = new GridBagConstraints();
		gbc_cursoComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_cursoComboBox.gridx = 1;
		gbc_cursoComboBox.gridy = 4;
		panel.add(cursoComboBox, gbc_cursoComboBox);
		cursoComboBox.setEnabled(false);
		
		cargarRegistro(0);
        btnPrimerElemento.setEnabled(false);
        btnAnterior.setEnabled(false);
        cargarValoresCursosEnJComboBox();
        cursoComboBox.setEnabled(false);
	}
	
	private void cargarRegistro (int opcion) {
        setAccion(opcion);

        String consulta = comprobarBoton();
        try {
        	Materia m  = ControladorMateria.getMateria(consulta);
            setId(m.getId());
            idField.setText(m.getId()+"");
            nombreField.setText(m.getNombre());
            acronimoField.setText(m.getAcronimo());
            seleccionarCursoEnJComboBox(m.getCursoid());

        } catch (ErrorBBDDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        comprobarEstadoBotones();
    }
	
	public void buscarPrimeroYUltimo() throws ErrorBBDDException {
        this.primerId = ControladorMateria.getAll().get(0).getId();
        this.ultimoId = ControladorMateria.getAll().get(ControladorMateria.getAll().size()-1).getId();
    }
	
	private void comprobarEstadoBotones() {
        if(getId() == getPrimerId()){
            btnAnterior.setEnabled(false);
            btnPrimerElemento.setEnabled(false);
            btnSiguiente.setEnabled(true);
            btnUltimoElemento.setEnabled(true);
        }else if (getId() == getUltimoId()) {
            btnAnterior.setEnabled(true);
            btnPrimerElemento.setEnabled(true);
            btnSiguiente.setEnabled(false);
            btnUltimoElemento.setEnabled(false);
        }else if(getAccion()==0 || getAccion()==1){
            btnSiguiente.setEnabled(true);
            btnUltimoElemento.setEnabled(true);
        }else if(getAccion()==2 || getAccion()==3){
        	btnAnterior.setEnabled(true);
            btnPrimerElemento.setEnabled(true);
        }
    }

    public String comprobarBoton(){
        String consulta = null;
        switch (getAccion()){
            case 0: consulta = "select * from materia order by id asc limit 1"; break;
            case 1: consulta = "select * from materia where id <" + getId() + " order by id desc limit 1"; break;
            case 2: consulta = "select * from materia where id >" + getId() + " order by id asc limit 1"; break;
            case 3: consulta = "select * from materia order by id desc limit 1"; break;
            default: break;
        }
        return consulta;
    }
    
    private void cargarValoresCursosEnJComboBox () throws ErrorBBDDException {
		// Cargamos valores dentro del combobox
		List<Curso> lista = ControladorCurso.getAll();
		for (int i = 0; i < lista.size(); i++) {
			cursoComboBox.addItem(lista.get(i));
		}
	}
    
    private void seleccionarCursoEnJComboBox (int idCoche) {
		for (int i = 0; i < cursoComboBox.getItemCount(); i++) {
			if ( ((Curso) cursoComboBox.getItemAt(i)).getId() == idCoche) {
				cursoComboBox.setSelectedIndex(i);
			}
		}
	}
    
    private int getIdCursoSeleccionadoEnJComboBox () {
		return ((Curso) cursoComboBox.getSelectedItem()).getId();
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
