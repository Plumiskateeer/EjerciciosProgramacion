package capitulo07.centroEducativo.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import capitulo07.centroEducativo.ErrorBBDDException;
import capitulo07.centroEducativo.modelo.Estudiante;
import capitulo07.centroEducativo.modelo.Materia;
import capitulo07.centroEducativo.modelo.Profesor;
import capitulo07.centroEducativo.modelo.controladores.ControladorEstudiante;
import capitulo07.centroEducativo.modelo.controladores.ControladorMateria;
import capitulo07.centroEducativo.modelo.controladores.ControladorProfesor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profesores extends JPanel {

	private JPanel contentPane;
	private Campos panelCampos = new Campos();
	private int id = 1, primerId, ultimoId;

    private int accion = 0;
    private JButton btnPrimerElemento;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimoElemento;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEliminar;
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
		setBounds(100, 100, 450, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		this.add(contentPane);
		
		this.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		this.add(toolBar, BorderLayout.NORTH);
		
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
		btnPrimerElemento.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/gotostart.png")));
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
		btnAnterior.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/previous.png")));
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
		btnSiguiente.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/next.png")));
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
		btnUltimoElemento.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/gotoend.png")));
		toolBar.add(btnUltimoElemento);
		
		btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setId(0);
				panelCampos.setNombreField("");
				panelCampos.setApellido1Field("");
				panelCampos.setApellido2Field("");
				panelCampos.setDniField("");
				panelCampos.setDireccionField("");
				panelCampos.setEmailField("");
				panelCampos.setTelefonoField("");
			}
		});
		btnNuevo.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/nuevo.png")));
		toolBar.add(btnNuevo);
		
		btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profesor es = new Profesor(getId(), panelCampos.getNombreField().getText(), panelCampos.getApellido1Field().getText(), 
						panelCampos.getApellido2Field().getText(), panelCampos.getDniField().getText(), panelCampos.getDireccionField().getText(),
						panelCampos.getEmailField().getText(), panelCampos.getTelefonoField().getText());
				try {
                    if(getId()==0) {
                        ControladorProfesor.almacenarNuevo(es);
                        JOptionPane.showMessageDialog(null, "Registro introducido correctamente");
                        buscarPrimeroYUltimo();
                    }else{
                    	ControladorProfesor.almacenarModificado(es);
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
			
			}
		});
		btnGuardar.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/guardar.png")));
		toolBar.add(btnGuardar);
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControladorProfesor.eliminar(new Profesor(getId(),null,null,null,null,null,null,null));
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
				}
			}
		});
		btnEliminar.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/eliminar.png")));
		toolBar.add(btnEliminar);
		
		
		this.add(panelCampos, BorderLayout.CENTER);
		
		cargarRegistro(0);
		
	}
	private void cargarRegistro (int opcion) throws ErrorBBDDException {
        setAccion(opcion);

        String consulta = comprobarBoton();
        try {
        	Profesor e  = ControladorProfesor.getProfesor(consulta);
        	panelCampos.setNombreField(e.getNombre());
        	panelCampos.setApellido1Field(e.getApellido1());
        	panelCampos.setApellido2Field(e.getApellido2());
        	panelCampos.setDniField(e.getDni());
        	panelCampos.setDireccionField(e.getDireccion());
        	panelCampos.setEmailField(e.getEmail());
        	panelCampos.setTelefonoField(e.getTelefono());
        	
        } catch (ErrorBBDDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        comprobarEstadoBotones();
    }
	
	public void buscarPrimeroYUltimo() throws ErrorBBDDException {
        this.primerId = ControladorProfesor.getAll().get(0).getId();
        this.ultimoId = ControladorProfesor.getAll().get(ControladorProfesor.getAll().size()-1).getId();
    }
	
	private void comprobarEstadoBotones() throws ErrorBBDDException {
		int accion = getAccion();
		setAccion(1);
		if (ControladorProfesor.getProfesor(comprobarBoton()) == null) {
            btnPrimerElemento.setEnabled(false);
            btnAnterior.setEnabled(false);
        }
        else {
        	btnPrimerElemento.setEnabled(true);
        	btnAnterior.setEnabled(true);
        }
        // Si no existe un siguiente deshabilito los botones de �ltimo y siguiente
      	setAccion(2);
        boolean existeSiguiente = (ControladorProfesor.getProfesor(comprobarBoton()) == null)? false : true;
        btnUltimoElemento.setEnabled(existeSiguiente);
        btnSiguiente.setEnabled(existeSiguiente);
        
        setAccion(accion);
	}

    public String comprobarBoton(){
        String consulta = null;
        switch (getAccion()){
            case 0: consulta = "select * from profesor order by id asc limit 1"; break;
            case 1: consulta = "select * from profesor where id <" + getId() + " order by id desc limit 1"; break;
            case 2: consulta = "select * from profesor where id >" + getId() + " order by id asc limit 1"; break;
            case 3: consulta = "select * from profesor order by id desc limit 1"; break;
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
