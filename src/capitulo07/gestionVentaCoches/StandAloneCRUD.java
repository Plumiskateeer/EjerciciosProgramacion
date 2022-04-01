package capitulo07.gestionVentaCoches;

import capitulo07.gestionVentaCoches.modelo.controladores.ErrorBBDDException;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
        setBounds(100, 100, 517, 421);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(5, 5, 499, 375);
        contentPane.add(tabbedPane);

        tabbedPane.addTab("Fabricantes",  VisorFabricante.getInstance());

        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("New tab", null, panel_1, null);

        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("New tab", null, panel_2, null);

        JPanel panel_3 = new JPanel();
        tabbedPane.addTab("New tab", null, panel_3, null);

        JPanel panel_4 = new JPanel();
        tabbedPane.addTab("New tab", null, panel_4, null);
    }
}