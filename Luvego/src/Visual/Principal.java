package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Principal() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width,(dim.height-50));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProyectos = new JMenu("Proyectos");
		menuBar.add(mnProyectos);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo proyecto");
		mnProyectos.add(mntmNuevo);
		
		JMenuItem mntmEstado = new JMenuItem("Estado");
		mnProyectos.add(mntmEstado);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmGestionar = new JMenuItem("Gestionar");
		mnEmpleados.add(mntmGestionar);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mnClientes.add(mntmRegistrar);
		
		JMenu mnConsulta_1 = new JMenu("Consulta");
		menuBar.add(mnConsulta_1);
		
		JMenuItem mntmVentas = new JMenuItem("Ventas");
		mnConsulta_1.add(mntmVentas);
		
		JMenuItem mntmContratos = new JMenuItem("Contratos");
		mnConsulta_1.add(mntmContratos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 484, 47);
		contentPane.add(panel);
	}
}
