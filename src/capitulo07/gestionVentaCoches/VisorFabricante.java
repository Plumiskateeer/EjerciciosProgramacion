package capitulo07.gestionVentaCoches;
import capitulo07.gestionVentaCoches.modelo.Fabricante;
import capitulo07.gestionVentaCoches.modelo.controladores.ControladorFabricante;
import capitulo07.gestionVentaCoches.modelo.controladores.ErrorBBDDException;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisorFabricante {

    private JFrame frame;
    private JTextField cifField;
    private JTextField nombreField;

    private JButton btnAtras;
    private JButton btnSiguiente;
    private JButton btnPrimerElemento;
    private JButton btnUltimoElemento;
    private JButton btnNuevoRegistro;
    private JButton btnGuardarRegistro;
    private JButton btnEliminarRegistro;

    private int id = 1, primerId, ultimoId;

    private int accion = 0; // 0 primer elemento, 1 elemento atras, 2 elemento siguiente, 3 ultimo elemento // otherwise ignorar

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VisorFabricante window = new VisorFabricante();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public VisorFabricante() throws ErrorBBDDException {
        initialize();
        buscarPrimeroYUltimo();
    }

    public void buscarPrimeroYUltimo() throws ErrorBBDDException {
        this.primerId = ControladorFabricante.getAll().get(0).getId();
        this.ultimoId = ControladorFabricante.getAll().get(ControladorFabricante.getAll().size()-1).getId();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 568, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("CRUD Fabricantes");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        lblNewLabel.setBounds(172, 11, 222, 28);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1_1 = new JLabel("CIF");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_1.setBounds(139, 112, 46, 14);
        frame.getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("Nombre");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_1_2.setBounds(139, 160, 71, 14);
        frame.getContentPane().add(lblNewLabel_1_2);

        cifField = new JTextField();
        cifField.setColumns(10);
        cifField.setBounds(220, 111, 138, 20);
        frame.getContentPane().add(cifField);

        nombreField = new JTextField();
        nombreField.setColumns(10);
        nombreField.setBounds(220, 159, 138, 20);
        frame.getContentPane().add(nombreField);

        btnPrimerElemento = new JButton("<<");
        btnPrimerElemento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarRegistro(0);
            }
        });
        btnPrimerElemento.setBounds(43, 251, 89, 23);
        frame.getContentPane().add(btnPrimerElemento);

        btnAtras = new JButton("<");
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarRegistro(1);
            }
        });
        btnAtras.setBounds(176, 251, 89, 23);
        frame.getContentPane().add(btnAtras);

        btnSiguiente = new JButton(">");
        btnSiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarRegistro(2);
            }
        });
        btnSiguiente.setBounds(296, 251, 89, 23);
        frame.getContentPane().add(btnSiguiente);

        btnUltimoElemento = new JButton(">>");
        btnUltimoElemento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarRegistro(3);
            }
        });
        btnUltimoElemento.setBounds(416, 251, 89, 23);
        frame.getContentPane().add(btnUltimoElemento);

        btnNuevoRegistro = new JButton("Nuevo");
        btnNuevoRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setId(0);
                cifField.setText("");
                nombreField.setText("");
            }
        });
        btnNuevoRegistro.setBounds(107, 309, 89, 23);
        frame.getContentPane().add(btnNuevoRegistro);

        btnGuardarRegistro = new JButton("Guardar");
        btnGuardarRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    if(getId()==0) {
                        ControladorFabricante.almacenarNuevo
                                (new Fabricante(getId(), cifField.getText(), nombreField.getText()));
                        JOptionPane.showMessageDialog(null, "Registro introducido correctamente");
                        buscarPrimeroYUltimo();
                    }else{
                        ControladorFabricante.almacenarModificado
                                (new Fabricante(getId(), cifField.getText(), nombreField.getText()));
                        JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
                    }
                } catch (ErrorBBDDException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnGuardarRegistro.setBounds(235, 309, 89, 23);
        frame.getContentPane().add(btnGuardarRegistro);

        btnEliminarRegistro = new JButton("Eliminar");
        btnEliminarRegistro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ControladorFabricante.eliminar(new Fabricante(getId(),null,null));
                    JOptionPane.showMessageDialog(null,"Registro eliminado correctamente");

                    if (getId() <= getUltimoId() && getId() > getPrimerId()) {
                        btnAtras.doClick();
                    }else btnSiguiente.doClick();
                    buscarPrimeroYUltimo();
                } catch (ErrorBBDDException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnEliminarRegistro.setBounds(361, 309, 89, 23);
        frame.getContentPane().add(btnEliminarRegistro);
    }


    private void cargarRegistro (int opcion) {
        setAccion(opcion);

        String consulta = comprobarBoton();
        try {
            setId(ControladorFabricante.getFabricante(consulta).getId());
            cifField.setText(ControladorFabricante.getFabricante(consulta).getCif());
            nombreField.setText(ControladorFabricante.getFabricante(consulta).getNombre());
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
            case 0: consulta = "select * from fabricante order by id asc limit 1"; break;
            case 1: consulta = "select * from fabricante where id <" + getId() + " order by id desc limit 1"; break;
            case 2: consulta = "select * from fabricante where id >" + getId() + " order by id asc limit 1"; break;
            case 3: consulta = "select * from fabricante order by id desc limit 1"; break;
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



