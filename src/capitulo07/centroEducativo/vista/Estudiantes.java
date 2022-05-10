package capitulo07.centroEducativo.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

import capitulo07.centroEducativo.ErrorBBDDException;
import capitulo07.centroEducativo.modelo.Estudiante;
import capitulo07.centroEducativo.modelo.controladores.ControladorEstudiante;
import capitulo07.centroEducativo.modelo.controladores.ControladorMateria;
import capitulo07.centroEducativo.modelo.controladores.ControladorProfesor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Estudiantes extends JPanel {
	private int id = 1, primerId, ultimoId;

    private int accion = 0;
    private Botones botones;
	private static Estudiantes instance = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estudiantes frame = new Estudiantes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Estudiantes getInstance() throws ErrorBBDDException {
		if(instance == null) {
			instance = new Estudiantes();
		}
		return instance;
	}

	/**
	 * Create the frame.
	 * @throws ErrorBBDDException 
	 * @throws ClassNotFoundException 
	 */
	public Estudiantes() throws ErrorBBDDException{
		botones = new Botones();
		setBounds(100, 100, 457, 241);
		
		this.setLayout(new BorderLayout(0, 0));
		
		this.add(botones.getToolBar(), BorderLayout.NORTH);
		
		botones.getBtnGuardar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					guardar();
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botones.getBtnGuardar().setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/guardar.png")));
		botones.getToolBar().add(botones.getBtnGuardar());
		
		botones.getBtnEliminar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		botones.getBtnEliminar().setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/eliminar.png")));
		botones.getToolBar().add(botones.getBtnEliminar());
		
		botones.getBtnPrimerElemento().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Estudiante est = ControladorEstudiante.findPrimero();
					setId(est.getId());
					cargarRegistro(est);
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botones.getToolBar().add(botones.getBtnPrimerElemento());
		
		botones.getBtnAnterior().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Estudiante est = ControladorEstudiante.findAnterior(getId());
					setId(est.getId());
					cargarRegistro(est);
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botones.getToolBar().add(botones.getBtnAnterior());
		
		botones.getBtnSiguiente().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Estudiante est = ControladorEstudiante.findSiguiente(getId());
					setId(est.getId());
					cargarRegistro(est);
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botones.getToolBar().add(botones.getBtnSiguiente());
		
		botones.getBtnUltimoElemento().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Estudiante est = ControladorEstudiante.findUltimo();
					setId(est.getId());
					cargarRegistro(est);
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botones.getToolBar().add(botones.getBtnUltimoElemento());
		
		cargarRegistro(ControladorEstudiante.findPrimero());
		this.add(botones.getPanelCampos(), BorderLayout.SOUTH);
		
	}
	
	private void guardar() throws ErrorBBDDException, ClassNotFoundException {
		Estudiante es = new Estudiante(
				getId(), botones.getPanelCampos().getNombreField().getText(), botones.getPanelCampos().getApellido1Field().getText(), 
				botones.getPanelCampos().getApellido2Field().getText(), botones.getPanelCampos().getDniField().getText(), botones.getPanelCampos().getDireccionField().getText(),
				botones.getPanelCampos().getEmailField().getText(), botones.getPanelCampos().getTelefonoField().getText(),botones.getPanelCampos().getIdSexoSeleccionadoEnJComboBox(),
				botones.getPanelCampos().getImagenEnArrayDeBytes());
		try {
            if(getId()==0) {
                ControladorEstudiante.almacenarNuevo(es);
                JOptionPane.showMessageDialog(null, "Registro introducido correctamente");
            }else{
            	ControladorEstudiante.almacenarModificado(es);
                JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
            }
        } catch (ErrorBBDDException e1) {
        	JOptionPane.showMessageDialog(null,"No se pudo guardar o modificar el registro", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		botones.getPanelCampos().getSexocomboBox().setEditable(false);
		botones.getPanelCampos().getSexocomboBox().setEnabled(true);
	}
	
	private void eliminar() {
		try {
			ControladorEstudiante.eliminar(new Estudiante(getId(),null,null,null,null,null,null,null,0,null));
            JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");

            if (getId() <= getUltimoId() && getId() > getPrimerId()) {
                botones.getBtnAnterior().doClick();
                botones.getBtnSiguiente().setEnabled(false);
                botones.getBtnUltimoElemento().setEnabled(false);
            }else botones.getBtnSiguiente().doClick();
        } catch (ErrorBBDDException e1) {
			// TODO Auto-generated catch block
        	JOptionPane.showMessageDialog(null,"No se pudo eliminar el registro", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void cargarRegistro (Estudiante e) throws ErrorBBDDException {
        
        if(e!=null) {
			botones.getPanelCampos().setNombreField(e.getNombre());
			botones.getPanelCampos().setApellido1Field(e.getApellido1());
			botones.getPanelCampos().setApellido2Field(e.getApellido2());
			botones.getPanelCampos().seleccionarSexoEnJComboBox(e.getSexo());
			botones.getPanelCampos().setDniField(e.getDni());
			botones.getPanelCampos().setDireccionField(e.getDireccion());
			botones.getPanelCampos().setEmailField(e.getEmail());
			botones.getPanelCampos().setTelefonoField(e.getTelefono());
			botones.getPanelCampos().setImagenEnArrayDeBytes(e.getImagen());
			botones.getPanelCampos().mostrarImagen();
		}
     // Ahora habilitamos o deshabilitamos botones de navegación
     			// Si no existe un anterior deshabilito los botones de primero y anterior
     			if (ControladorEstudiante.findAnterior(e.getId()) == null) {
     				botones.getBtnPrimerElemento().setEnabled(false);
     				botones.getBtnAnterior().setEnabled(false);
     			}
     			else {
     				botones.getBtnPrimerElemento().setEnabled(true);
     				botones.getBtnAnterior().setEnabled(true);
     			}
     			// Si no existe un siguiente deshabilito los botones de último y siguiente
     			boolean existeSiguiente = 
     					(ControladorEstudiante.findSiguiente(e.getId()) == null)? false : true;
     			botones.getBtnUltimoElemento().setEnabled(existeSiguiente);
     			botones.getBtnSiguiente().setEnabled(existeSiguiente);
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
