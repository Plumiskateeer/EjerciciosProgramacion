package capitulo07.centroEducativo.vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Botones extends JPanel {

	/**
	 * Create the panel.
	 */
	public Botones() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnPrimerElemento = new JButton("");
		btnPrimerElemento.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/gotostart.png")));
		toolBar.add(btnPrimerElemento);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/previous.png")));
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/next.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimoElemento = new JButton("");
		btnUltimoElemento.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/gotoend.png")));
		toolBar.add(btnUltimoElemento);
		
		JButton btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/nuevo.png")));
		toolBar.add(btnNuevo);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/guardar.png")));
		toolBar.add(btnGuardar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(Botones.class.getResource("/capitulo07/resources/eliminar.png")));
		toolBar.add(btnEliminar);

	}

}
