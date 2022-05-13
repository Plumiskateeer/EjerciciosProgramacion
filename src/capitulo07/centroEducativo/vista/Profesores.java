package capitulo07.centroEducativo.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import capitulo07.centroEducativo.ErrorBBDDException;
import capitulo07.centroEducativo.modelo.Profesor;
import capitulo07.centroEducativo.modelo.controladores.ControladorProfesor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profesores extends JPanel {

	private int id = 1;

    private Botones botones;
	private static Profesores instance = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
	 			try {
					Profesores frame = new Profesores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Profesores getInstance() throws ErrorBBDDException {
		if(instance == null) {
			instance = new Profesores();
		}
		return instance;
	}

	/**
	 * Create the frame.
	 * @throws ErrorBBDDException 
	 */
	public Profesores() throws ErrorBBDDException {
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
				}
			}
		});
		botones.getToolBar().add(botones.getBtnGuardar());
		
		botones.getBtnEliminar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		botones.getToolBar().add(botones.getBtnEliminar());
		
		botones.getBtnPrimerElemento().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Profesor est = ControladorProfesor.findPrimero();
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
					Profesor est = ControladorProfesor.findAnterior(getId());
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
					Profesor est = ControladorProfesor.findSiguiente(getId());
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
					Profesor est = ControladorProfesor.findUltimo();
					setId(est.getId());
					cargarRegistro(est);
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botones.getToolBar().add(botones.getBtnUltimoElemento());
		
		cargarRegistro(ControladorProfesor.findPrimero());
		this.add(botones.getPanelCampos(), BorderLayout.SOUTH);
		
	}
	
	private void eliminar() {
		try {
			ControladorProfesor.eliminar(new Profesor(getId(),null,null,null,null,null,null,null,1,null,null));
            JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");

        } catch (ErrorBBDDException e1) {
			// TODO Auto-generated catch block
        	JOptionPane.showMessageDialog(null,"No se pudo eliminar el registro", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void guardar() throws ErrorBBDDException{
		Profesor es = new Profesor(getId(), botones.getPanelCampos().getNombreField().getText(), botones.getPanelCampos().getApellido1Field().getText(), 
				botones.getPanelCampos().getApellido2Field().getText(), botones.getPanelCampos().getDniField().getText(), botones.getPanelCampos().getDireccionField().getText(),
				botones.getPanelCampos().getEmailField().getText(), botones.getPanelCampos().getTelefonoField().getText(),botones.getPanelCampos().getIdSexoSeleccionadoEnJComboBox(),
				botones.getPanelCampos().getImagenEnArrayDeBytes(),botones.getPanelCampos().getColorField().getText());
		try {
            if(getId()==0) {
                ControladorProfesor.almacenarNuevo(es);
                JOptionPane.showMessageDialog(null, "Registro introducido correctamente");
            }else{
            	ControladorProfesor.almacenarModificado(es);
                JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
            }
        } catch (ErrorBBDDException e1) {
        	JOptionPane.showMessageDialog(null,"No se pudo guardar o modificar el registro", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void cargarRegistro (Profesor e) throws ErrorBBDDException {
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
			botones.getPanelCampos().setColorPreferido(e.getColorpreferido());
        if (ControladorProfesor.findAnterior(e.getId()) == null) {
				botones.getBtnPrimerElemento().setEnabled(false);
				botones.getBtnAnterior().setEnabled(false);
			}
			else {
				botones.getBtnPrimerElemento().setEnabled(true);
				botones.getBtnAnterior().setEnabled(true);
			}
			// Si no existe un siguiente deshabilito los botones de último y siguiente
			boolean existeSiguiente = 
					(ControladorProfesor.findSiguiente(e.getId()) == null)? false : true;
			botones.getBtnUltimoElemento().setEnabled(existeSiguiente);
			botones.getBtnSiguiente().setEnabled(existeSiguiente);
			}
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
