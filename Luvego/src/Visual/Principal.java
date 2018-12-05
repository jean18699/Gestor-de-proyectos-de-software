package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import Logico.Empleado;
import Logico.Empresa;
import Logico.Jefe;
import Logico.Proyecto;

import java.awt.event.WindowEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JTextField;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1995139449296392536L;
	private JPanel contentPane;
	private Dimension dim;
	private JTable tablaProyectos;
	private DefaultTableModel model;
	private static Object[] fila;
	private JTextField txtCantidadProyectos;
	private JTextField txtGanancias;
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
//
	
	public Principal() {
		
		Empleado emp1 = new Jefe("0", "Pepe", "Aguilar", "M", 12, "88", "47", "VV1", (float)748);
		
		ArrayList<Empleado> emps = new ArrayList<>();
		emps.add(emp1);
		
		/*System.out.println(Proyecto.getCont());
		Proyecto p1 = new Proyecto("p1", emps, "klv");
		System.out.println(Proyecto.getCont());
		Proyecto p2 = new Proyecto("p2", emps, "oq");
		System.out.println(Proyecto.getCont());
		
		Empresa.getInstance().agregarProyecto(p1);
		Empresa.getInstance().agregarProyecto(p2);*/
		
		
		setTitle("Luvego");
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	try {
					FileOutputStream fichero = new FileOutputStream("registro.bin");
					ObjectOutputStream guardar = new ObjectOutputStream(fichero);
					guardar.writeObject(Empresa.getInstance().getEmpresa());
					fichero.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	System.exit(0);
		    
		    }
		});
			
		
		try {
			File arch = new File("registro.bin");
			
			if(!arch.exists())
			{
				arch.createNewFile();
			}
		
			FileInputStream archivo = new FileInputStream(arch);
			
			ObjectInputStream cargar = new ObjectInputStream(archivo);
			Empresa.getInstance().setEmpresa((Empresa)cargar.readObject());
			
			archivo.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dim = super.getToolkit().getScreenSize();
		super.setSize((dim.width),(dim.height-50));
		setExtendedState(JFrame.MAXIMIZED_BOTH); //Fullscreen
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(176, 196, 222));
		menuBar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
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
		
		JMenuItem mntmRegistro = new JMenuItem("Registro de proyectos");
		mntmRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProyectos listar = new ListarProyectos();
				listar.setLocationRelativeTo(null);
				listar.setModal(true);
				listar.setVisible(true);
			}
		});
		mnProyectos.add(mntmRegistro);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		mnEmpleados.setIcon(new ImageIcon(Principal.class.getResource("/img/empleados.png")));
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmNuevo_1 = new JMenuItem("Registrar empleado");
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
		mntmGestionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEmpleados list = new ListarEmpleados();
				list.setLocationRelativeTo(null);
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnEmpleados.add(mntmGestionar);

		
		JMenu mnClientes = new JMenu("Clientes");
		mnClientes.setIcon(new ImageIcon(Principal.class.getResource("/img/cliente a color 32x32.png")));
		menuBar.add(mnClientes);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar cliente");
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
		
		JMenuItem mntmVentas = new JMenuItem("Ventas de la empresa");
		mnConsulta_1.add(mntmVentas);
		
		JMenuItem mntmContratos = new JMenuItem("Contratos realizados");
		mnConsulta_1.add(mntmContratos);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		model = new DefaultTableModel();
		String[] cols = {"ID","Nombre del proyecto","Estado"};
		model.setColumnIdentifiers(cols);
		cargarProyectos();
		contentPane.setLayout(null);
		
		JPanel panelProyectosSolicitados = new JPanel();
		panelProyectosSolicitados.setBounds(895, 211, 452, 447);
		panelProyectosSolicitados.setBackground(Color.WHITE);
		contentPane.add(panelProyectosSolicitados);
		
		DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Escritorio",Empresa.getInstance().getCantDesktop());
        data.setValue("Web", Empresa.getInstance().getCantWeb());
        data.setValue("Movil",Empresa.getInstance().getCantMovil());

        
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "Tipos de proyectos mas solicitados", 
         data, 
         true, 
         true, 
         false);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        panelProyectosSolicitados.add(chartPanel);
        
        JPanel panel = new JPanel();
        panel.setBounds(878, 0, 489, 206);
        panel.setBackground(new Color(112, 128, 144));
        panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblEstadoDeProyectos = new JLabel("Estado de proyectos");
        lblEstadoDeProyectos.setForeground(new Color(255, 255, 255));
        lblEstadoDeProyectos.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEstadoDeProyectos.setBounds(20, 11, 160, 14);
        panel.add(lblEstadoDeProyectos);
        
        for (int i = 0; i < Empresa.getInstance().getProyectos().size(); i++) {
		 	System.out.println(Empresa.getInstance().getProyectos().get(i).getId());

		}
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(20, 36, 452, 112);
        panel.add(scrollPane);
        scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
        scrollPane.setBackground(Color.WHITE);
        
        tablaProyectos = new JTable();
        scrollPane.setViewportView(tablaProyectos);
        tablaProyectos.setModel(model);
        
        JButton btnGestionar = new JButton("Gestionar");
        btnGestionar.setBounds(20, 159, 89, 23);
        panel.add(btnGestionar);
        
        txtCantidadProyectos = new JTextField();
        txtCantidadProyectos.setEditable(false);
        txtCantidadProyectos.setBounds(379, 175, 86, 20);
        panel.add(txtCantidadProyectos);
        txtCantidadProyectos.setColumns(10);
        txtCantidadProyectos.setText(Integer.toString(Empresa.getInstance().getProyectos().size()));
        
        JLabel lblTotalDeProyectos = new JLabel("Total de proyectos:");
        lblTotalDeProyectos.setForeground(new Color(255, 255, 255));
        lblTotalDeProyectos.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblTotalDeProyectos.setBounds(263, 178, 115, 14);
        panel.add(lblTotalDeProyectos);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(878, 205, 489, 464);
        panel_1.setBackground(new Color(112, 128, 144));
        panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        contentPane.add(panel_1);
        
        txtGanancias = new JTextField();
        txtGanancias.setBounds(10, 612, 124, 20);
        contentPane.add(txtGanancias);
        txtGanancias.setColumns(10);
        txtGanancias.setText(Long.toString(Empresa.getInstance().getGanancias()));
        btnGestionar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ListarProyectos list = new ListarProyectos();
        		list.setLocationRelativeTo(null);
        		list.setModal(true);
        		list.setVisible(true);
        	}
        });
	}
	
	private void cargarProyectos() {
		System.out.println(Empresa.getInstance().getProyectos().size());
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		
		
		for (int i = 0; i < Empresa.getInstance().getProyectos().size(); i++) {
		 	fila[0] = Empresa.getInstance().getProyectos().get(i).getId();
		    fila[1] = Empresa.getInstance().getProyectos().get(i).getNombre();
		 	fila[2] = Empresa.getInstance().getProyectos().get(i).getEstado();

			model.addRow(fila);
		}

		
	}
}
