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
	
	public static Estudiantes getInstance() throws ErrorBBDDException, ClassNotFoundException {
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
	public Estudiantes() throws ErrorBBDDException, ClassNotFoundException {
		botones = new Botones();
		setBounds(100, 100, 457, 241);
		
		this.setLayout(new BorderLayout(0, 0));
		
		
		
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
					cargarRegistro(0);
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botones.getToolBar().add(botones.getBtnPrimerElemento());
		
		botones.getBtnAnterior().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarRegistro(1);
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botones.getToolBar().add(botones.getBtnAnterior());
		
		botones.getBtnSiguiente().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarRegistro(2);
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botones.getToolBar().add(botones.getBtnSiguiente());
		
		botones.getBtnUltimoElemento().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarRegistro(3);
				} catch (ErrorBBDDException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		botones.getToolBar().add(botones.getBtnUltimoElemento());
		
		cargarRegistro(0);
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
                buscarPrimeroYUltimo();
            }else{
            	ControladorEstudiante.almacenarModificado(es);
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
            buscarPrimeroYUltimo();
        } catch (ErrorBBDDException e1) {
			// TODO Auto-generated catch block
        	JOptionPane.showMessageDialog(null,"No se pudo eliminar el registro", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void cargarRegistro (int opcion) throws ErrorBBDDException, ClassNotFoundException {
        setAccion(opcion);

        String consulta = comprobarBoton();
        try {
        	Estudiante e  = ControladorEstudiante.getEstudiante(consulta);
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
        	
        } catch (ErrorBBDDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        comprobarEstadoBotones();
    }
	
	public void buscarPrimeroYUltimo() throws ErrorBBDDException {
        this.primerId = ControladorEstudiante.getAll().get(0).getId();
        this.ultimoId = ControladorEstudiante.getAll().get(ControladorEstudiante.getAll().size()-1).getId();
    }
	
	private void comprobarEstadoBotones() throws ErrorBBDDException {
		boolean existeAnterior = (ControladorProfesor.getProfesor(comprobarBoton(1)) == null)? false:true;
		botones.getBtnPrimerElemento().setEnabled(existeAnterior);
        botones.getBtnAnterior().setEnabled(existeAnterior);
        
        boolean existeSiguiente = (ControladorProfesor.getProfesor(comprobarBoton(2)) == null)? false : true;
        botones.getBtnUltimoElemento().setEnabled(existeSiguiente);
        botones.getBtnSiguiente().setEnabled(existeSiguiente);
        botones.getBtnAnterior().setEnabled(!existeSiguiente);
        botones.getBtnPrimerElemento().setEnabled(!existeSiguiente);
	}
	
	public String comprobarBoton(int i){
        String consulta = null;
        switch (i){
            case 0: consulta = "select * from profesor order by id asc limit 1"; break;
            case 1: consulta = "select * from profesor where id <" + getId() + " order by id desc limit 1"; break;
            case 2: consulta = "select * from profesor where id >" + getId() + " order by id asc limit 1"; break;
            case 3: consulta = "select * from profesor order by id desc limit 1"; break;
            default: break;
        }
        return consulta;
    }

    public String comprobarBoton(){
        String consulta = null;
        switch (getAccion()){
            case 0: consulta = "select * from estudiante order by id asc limit 1"; break;
            case 1: consulta = "select * from estudiante where id <" + getId() + " order by id desc limit 1"; break;
            case 2: consulta = "select * from estudiante where id >" + getId() + " order by id asc limit 1"; break;
            case 3: consulta = "select * from estudiante order by id desc limit 1"; break;
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
