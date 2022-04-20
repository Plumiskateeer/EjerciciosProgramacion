package capitulo07.gestionVentaCoches;

import capitulo07.gestionVentaCoches.modelo.controladores.ErrorBBDDException;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

public class StandAloneCRUD extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StandAloneCRUD frame = new StandAloneCRUD();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public StandAloneCRUD() throws ErrorBBDDException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 675, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    //    tabbedPane.setBounds(5, 5, 499, 375);

        tabbedPane.addTab("Fabricantes", null,  VisorFabricante.getInstance(), null);
        tabbedPane.addTab("Coches", null, VisorCoche.getInstance(), null);
        tabbedPane.addTab("Concesionarios", null, VisorConcesionario.getInstance(), null);
        tabbedPane.addTab("Clientes", null, VisorCliente.getInstance(), null);
        tabbedPane.addTab("Ventas", null, VisorVenta.getInstance(), null);

        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }
}