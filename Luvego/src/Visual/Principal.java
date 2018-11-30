package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Logico.Empresa;

import java.awt.event.WindowEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;

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
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Principal() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream empresa_Out;
				ObjectOutputStream empresaWrite;
				try {
					empresa_Out = new  FileOutputStream("empresa.dat");
					empresaWrite = new ObjectOutputStream(empresa_Out);
					empresaWrite.writeObject(Empresa.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dim = super.getToolkit().getScreenSize();
		super.setSize((dim.width),(dim.height-50));
		setExtendedState(JFrame.MAXIMIZED_BOTH); //Fullscreen
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProyectos = new JMenu("Proyectos");
		mnProyectos.setIcon(new ImageIcon(Principal.class.getResource("/img/Nuevo Proyecto 32x32.png")));
		menuBar.add(mnProyectos);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo proyecto");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegProyecto regProyecto = new RegProyecto();
				regProyecto.setModal(true);
				regProyecto.setVisible(true);
			}
		});
		mnProyectos.add(mntmNuevo);
		
		JMenuItem mntmRegistro = new JMenuItem("Registro");
		mntmRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProyectos listar = new ListarProyectos();
				listar.setLocationRelativeTo(null);
				listar.setModal(true);
				listar.setVisible(true);
			}
		});
		mnProyectos.add(mntmRegistro);
		
		JMenuItem mntmEstado = new JMenuItem("Estado");
		mnProyectos.add(mntmEstado);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		mnEmpleados.setIcon(new ImageIcon(Principal.class.getResource("/img/empleados.png")));
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmNuevo_1 = new JMenuItem("Nuevo");
		mntmNuevo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEmpleado reg = new RegEmpleado();
				reg.setLocationRelativeTo(null);
				reg.setModal(true);
				reg.setVisible(true);
				
			}
		});
		mnEmpleados.add(mntmNuevo_1);
		
		JMenuItem mntmGestionar = new JMenuItem("Gestionar");
		mnEmpleados.add(mntmGestionar);
		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setIcon(new ImageIcon(Principal.class.getResource("/img/cliente a color 32x32.png")));
		menuBar.add(mnClientes);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar");
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegCliente reg = new RegCliente();
				reg.setLocationRelativeTo(null);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
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
	}
}
