package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Cliente;
import Logico.Disegnador;
import Logico.Empleado;
import Logico.Empresa;
import Logico.Jefe;
import Logico.Planificador;
import Logico.Programador;
import Logico.Proyecto;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Color;

public class RegProyecto extends JDialog {

	private final JPanel panelProyecto = new JPanel();
	private JTextField txtNombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private static DefaultTableModel model;
	private static Object fila[];
	private JTextField txtJefe;
	private JTextField txtIdPlanificador;
	private JTextField txtIdProgramador1;
	private JTextField txtIdProgramador2;
	private JTextField txtIdAdicional;
	private JComboBox<String> cmbOcupacion;
	private JComboBox cmbCategoria;
	private String select;
	private String selectCliente;
	private int index;
	private JLabel lblIdEmpleado;
	private JLabel lblNombreEmpleado;
	private JLabel lblSalarioEmpleado;
	private JLabel lblOcupacionEmpleado;
	private JLabel lblSalarioempleado;
	private JLabel lblCondicionempleado;
	private JPanel panel_2;
	private JLabel lblNombre;
	private JLabel lblId;
	private JLabel lblOcupacion;
	private JLabel lblSalariohora;
	private JLabel lblEstado;
	private JLabel lblIdempleado;
	private JPanel panel_3;
	private JButton button;
	private JPanel panel;
	private JLabel lblNombreDelProyecto;
	private JLabel lblEquipo;
	private JPanel panel_1;
	private JLabel lblProgramador;
	private JLabel lblPlanificador;
	private JLabel lblJefeDelProyecto;
	private JLabel lblProgramador_1;
	private JButton btnCargarJefe;
	private JButton btnCargarPlanificador;
	private JButton btnCargarProgramador;
	private JButton btnCargarProgramador2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	//private JButton btnCargarAdicional;
	private JButton btnNewButton_4;
	private JLabel lblAdicional;
	private JLabel lblCategoria;
	private JPanel buttonPane;
	private JButton btnSiguiente;
	private JButton cancelButton;
	private JPanel panelClientes;
	private JScrollPane scrollPane_1;
	private static DefaultTableModel modelClientes;
	private JTable tablaClientes;
	private JButton btnAgregarCliente;
	private JButton btnAnterior;
	private JButton btnSiguiente2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegProyecto dialog = new RegProyecto();
			
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public RegProyecto() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		setBounds(100, 100, 769, 402);
		getContentPane().setLayout(new BorderLayout());

		
		//Prueba
		ArrayList<String> esp = new ArrayList<>();
		esp.add("C");
		esp.add("Java");
		
		Cliente c = new Cliente("123","jean","cerro alto");
		
		Empleado p = new Planificador("jeasn","j","hombre",19,"cerro alto",15);
		Empleado p2 = new Planificador("jeasn","j","hombre",19,"cerro alto",15);
		Empleado p3= new Planificador("jeasn","j","hombre",19,"cerro alto",15);
		
		Empleado pro = new Programador("jeaasdfn","j","hombre",19,"cerro alto",156,esp);
		Empleado pro2 = new Programador("jeaasdfn","j","hombre",19,"cerro alto",156,esp);
		Empleado pro3 = new Programador("jeaasdfn","j","hombre",19,"cerro alto",156,esp);
		Empleado dsg = new Disegnador("jeane","j","hombre",19,"cerro alto",15);
		Empleado chef = new Jefe("jeanff","j","hombre",19,"cerro alto",15);
		
		Empresa.getInstance().nuevoEmpleado(p);
		Empresa.getInstance().nuevoEmpleado(pro);
		Empresa.getInstance().nuevoEmpleado(pro2);
		Empresa.getInstance().nuevoEmpleado(pro3);
		Empresa.getInstance().nuevoEmpleado(dsg);
		Empresa.getInstance().nuevoEmpleado(chef);
		Empresa.getInstance().nuevoEmpleado(p2);
		Empresa.getInstance().nuevoEmpleado(p3);
		Empresa.getInstance().nuevoCliente(c);
		
		model = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		
		String[] titulos = {"ID"};
		model.setColumnIdentifiers(titulos);
		
		modelClientes = new DefaultTableModel(){

			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};;
		String[] cols = {"ID","Nombre","Direccion","Proyectos activos","Total proyectos solicitados"};
		modelClientes.setColumnIdentifiers(cols);
		
		
		panelProyecto.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelProyecto, BorderLayout.CENTER);
		panelProyecto.setLayout(null);
		{
			panel = new JPanel();
			panel.setBounds(182, 11, 437, 316);
			panelProyecto.add(panel);
			panel.setLayout(null);
			
			lblNombreDelProyecto = new JLabel("Nombre del proyecto:");
			lblNombreDelProyecto.setBounds(10, 11, 121, 14);
			panel.add(lblNombreDelProyecto);
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(121, 8, 133, 20);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				lblEquipo = new JLabel("Equipo de trabajo");
				lblEquipo.setBounds(10, 42, 133, 14);
				panel.add(lblEquipo);
			}
			
			panel_1 = new JPanel();
			panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel_1.setBounds(10, 58, 416, 248);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			lblProgramador = new JLabel("Programador 1:");
			lblProgramador.setBounds(24, 61, 93, 14);
			panel_1.add(lblProgramador);
			
			lblPlanificador = new JLabel("Planificador:");
			lblPlanificador.setBounds(42, 36, 75, 14);
			panel_1.add(lblPlanificador);
			
			
			
			{
				lblJefeDelProyecto = new JLabel("Jefe del proyecto:");
				lblJefeDelProyecto.setBounds(10, 11, 114, 14);
				panel_1.add(lblJefeDelProyecto);
			}
			
			lblProgramador_1 = new JLabel("Programador 2:");
			lblProgramador_1.setBounds(24, 86, 93, 14);
			panel_1.add(lblProgramador_1);
			
			txtJefe = new JTextField();
			txtJefe.setEnabled(false);
			txtJefe.setBounds(105, 8, 144, 20);
			panel_1.add(txtJefe);
			txtJefe.setColumns(10);
			
			btnCargarJefe = new JButton("Cargar");
			btnCargarJefe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarJefes();
					btnCargarProgramador.setEnabled(true);
					btnCargarProgramador2.setEnabled(true);
					btnCargarJefe.setEnabled(false);
					btnCargarPlanificador.setEnabled(true);
					//btnCargarAdicional.setEnabled(true);
				}
			});
			btnCargarJefe.setBounds(251, 7, 93, 23);
			panel_1.add(btnCargarJefe);
			
			txtIdPlanificador = new JTextField();
			txtIdPlanificador.setEnabled(false);
			txtIdPlanificador.setBounds(105, 33, 144, 20);
			panel_1.add(txtIdPlanificador);
			txtIdPlanificador.setColumns(10);
			
			txtIdProgramador1 = new JTextField();
			txtIdProgramador1.setEnabled(false);
			txtIdProgramador1.setBounds(105, 58, 144, 20);
			panel_1.add(txtIdProgramador1);
			txtIdProgramador1.setColumns(10);
			
			txtIdProgramador2 = new JTextField();
			txtIdProgramador2.setEnabled(false);
			txtIdProgramador2.setBounds(105, 83, 144, 20);
			panel_1.add(txtIdProgramador2);
			txtIdProgramador2.setColumns(10);
			
			btnCargarPlanificador = new JButton("Cargar");
			btnCargarPlanificador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarPlanificadores();
					btnCargarProgramador.setEnabled(true);
					btnCargarProgramador2.setEnabled(true);
					btnCargarJefe.setEnabled(true);
					btnCargarPlanificador.setEnabled(false);
					//btnCargarAdicional.setEnabled(true);
				}
			});
			btnCargarPlanificador.setBounds(251, 32, 93, 23);
			panel_1.add(btnCargarPlanificador);
			
			btnCargarProgramador = new JButton("Cargar");
			btnCargarProgramador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarProgramadores();
					btnCargarProgramador.setEnabled(false);
					btnCargarJefe.setEnabled(true);
					btnCargarPlanificador.setEnabled(true);
					//btnCargarAdicional.setEnabled(true);
					btnCargarProgramador2.setEnabled(true);
				}
			});
			btnCargarProgramador.setBounds(251, 57, 93, 23);
			panel_1.add(btnCargarProgramador);
			
			btnCargarProgramador2 = new JButton("Cargar");
			btnCargarProgramador2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarProgramadores();
					btnCargarProgramador.setEnabled(true);
					btnCargarProgramador2.setEnabled(false);
					btnCargarJefe.setEnabled(true);
					btnCargarPlanificador.setEnabled(true);
					//btnCargarAdicional.setEnabled(true);
				}
			});
			btnCargarProgramador2.setBounds(251, 82, 93, 23);
			panel_1.add(btnCargarProgramador2);
			
			btnNewButton = new JButton("Info");
			btnNewButton.setBounds(348, 7, 58, 23);
			panel_1.add(btnNewButton);
			
			btnNewButton_1 = new JButton("Info");
			btnNewButton_1.setBounds(348, 32, 58, 23);
			panel_1.add(btnNewButton_1);
			
			btnNewButton_2 = new JButton("Info");
			btnNewButton_2.setBounds(348, 57, 58, 23);
			panel_1.add(btnNewButton_2);
			
			btnNewButton_3 = new JButton("Info");
			btnNewButton_3.setBounds(348, 82, 58, 23);
			panel_1.add(btnNewButton_3);
			
			/*cmbOcupacion = new JComboBox();
			cmbOcupacion.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					btnCargarAdicional.setEnabled(true);
					btnCargarJefe.setEnabled(true);
					btnCargarProgramador.setEnabled(true);
					btnCargarProgramador2.setEnabled(true);
					btnCargarPlanificador.setEnabled(true);
					
					int indexOcupacion = cmbOcupacion.getSelectedIndex();
					System.out.println(indexOcupacion);
					if(indexOcupacion == 1) {
						cargarPlanificadores();
					}
					else if(indexOcupacion == 2) {
						cargarProgramadores();
					}
					else if(indexOcupacion == 3) {
						cargarDisegnadores();
					}
					
				}
			});*/
			
			cmbOcupacion = new JComboBox();
			cmbOcupacion.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {

					//btnCargarAdicional.setEnabled(true);
					btnCargarJefe.setEnabled(true);
					btnCargarProgramador.setEnabled(true);
					btnCargarProgramador2.setEnabled(true);
					btnCargarPlanificador.setEnabled(true);
					
					int indexOcupacion = cmbOcupacion.getSelectedIndex();
					System.out.println(indexOcupacion);
					if(indexOcupacion == 1) {
						cargarPlanificadores();
					}
					else if(indexOcupacion == 2) {
						cargarProgramadores();
					}
					else if(indexOcupacion == 3) {
						cargarDisegnadores();
					}
					
				}
			});
			
			cmbOcupacion.setModel(new DefaultComboBoxModel(new String[] {"<Ocupacion>", "Planificador", "Programador", "Dise\u00F1ador"}));
			cmbOcupacion.setBounds(251, 110, 93, 20);
			panel_1.add(cmbOcupacion);
			
			txtIdAdicional = new JTextField();
			txtIdAdicional.setEnabled(false);
			txtIdAdicional.setBounds(105, 111, 144, 20);
			panel_1.add(txtIdAdicional);
			txtIdAdicional.setColumns(10);
			
			/*btnCargarAdicional = new JButton("Cargar");
			btnCargarAdicional.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					
					if(cmbOcupacion.getSelectedItem().toString().equalsIgnoreCase("Programador"))
					{
						btnCargarAdicional.setEnabled(false);
						cargarProgramadores();
					}
					if(cmbOcupacion.getSelectedItem().toString().equalsIgnoreCase("Planificador"))
					{
						btnCargarAdicional.setEnabled(false);
						cargarPlanificadores();
					}
					if(cmbOcupacion.getSelectedItem().toString().equalsIgnoreCase("Diseñador"))
					{
						btnCargarAdicional.setEnabled(false);
						cargarDisegnadores();
					}
					
				}
				});
			
			
			btnCargarAdicional.setBounds(105, 142, 65, 23);
			panel_1.add(btnCargarAdicional);*/
			
			btnNewButton_4 = new JButton("Info");
			btnNewButton_4.setBounds(348, 109, 58, 23);
			panel_1.add(btnNewButton_4);
			
			lblAdicional = new JLabel("Adicional:");
			lblAdicional.setBounds(49, 113, 46, 14);
			panel_1.add(lblAdicional);
			
			lblCategoria = new JLabel("Categoria:");
			lblCategoria.setBounds(269, 11, 64, 14);
			panel.add(lblCategoria);
			
			cmbCategoria = new JComboBox();
			cmbCategoria.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Escritorio", "Web", "Movil"}));
			cmbCategoria.setBounds(328, 8, 98, 20);
			panel.add(cmbCategoria);
		}
		{
			panel_2 = new JPanel();
			panel_2.setBounds(10, 11, 174, 309);
			panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panelProyecto.add(panel_2);
			panel_2.setLayout(null);
			
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNombre.setBounds(10, 175, 64, 14);
			panel_2.add(lblNombre);
			
			lblId = new JLabel("Identificador:");
			lblId.setFont(new Font("Sitka Text", Font.BOLD, 11));
			lblId.setBounds(10, 150, 78, 14);
			panel_2.add(lblId);
			
			lblOcupacion = new JLabel("Ocupacion:");
			lblOcupacion.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblOcupacion.setBounds(10, 200, 78, 14);
			panel_2.add(lblOcupacion);
			
			lblSalariohora = new JLabel("Salario/Hora:");
			lblSalariohora.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblSalariohora.setBounds(10, 225, 78, 14);
			panel_2.add(lblSalariohora);
			
			lblEstado = new JLabel("Condicion:");
			lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblEstado.setBounds(10, 250, 64, 14);
			panel_2.add(lblEstado);
			
			lblIdempleado = new JLabel("IdEmpleado");
			lblIdempleado.setBounds(93, 149, 81, 14);
			panel_2.add(lblIdempleado);
			
			panel_3 = new JPanel();
			panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_3.setBounds(0, 0, 174, 116);
			panel_2.add(panel_3);
			panel_3.setLayout(new BorderLayout(0, 0));
			
			button = new JButton("");
			button.setEnabled(false);
			button.setIcon(new ImageIcon(RegProyecto.class.getResource("/img/Nuevo Proyecto.png")));
			panel_3.add(button, BorderLayout.CENTER);
			
			lblNombreEmpleado = new JLabel("NombreEmpleado");
			lblNombreEmpleado.setBounds(66, 175, 98, 14);
			panel_2.add(lblNombreEmpleado);
			
			lblOcupacionEmpleado = new JLabel("");
			lblOcupacionEmpleado.setBounds(76, 200, 91, 14);
			panel_2.add(lblOcupacionEmpleado);
			
			lblSalarioempleado = new JLabel("salarioEmpleado");
			lblSalarioempleado.setBounds(93, 225, 81, 14);
			panel_2.add(lblSalarioempleado);
			
			lblCondicionempleado = new JLabel("condicionEmpleado");
			lblCondicionempleado.setBounds(76, 250, 98, 14);
			panel_2.add(lblCondicionempleado);
		}
		{
			buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setBounds(0, 324, 753, 39);
			panelProyecto.add(buttonPane);
			buttonPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			{
				btnSiguiente = new JButton("Siguiente");
				btnSiguiente.setBounds(589, 7, 77, 23);
				btnSiguiente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						btnAgregarCliente.setVisible(true);
						btnAnterior.setVisible(true);
						btnSiguiente.setVisible(false);
						btnSiguiente2.setVisible(true);
						btnSiguiente2.setEnabled(false);
						panel.setVisible(false);
						panel_1.setVisible(false);
						panel_2.setVisible(false);
						scrollPane_1.setVisible(true);
						panelClientes.setVisible(true);
						cargarClientes();
												/*
						Jefe jefe = (Jefe) Empresa.getInstance().getEmpleadoById(txtJefe.getText());
						Planificador planificador = (Planificador) Empresa.getInstance().getEmpleadoById(txtIdPlanificador.getText());
						Programador programador1 = (Programador) Empresa.getInstance().getEmpleadoById(txtIdProgramador1.getText());
						Programador programador2 = (Programador) Empresa.getInstance().getEmpleadoById(txtIdProgramador2.getText());
						if(cmbOcupacion.getSelectedItem().toString().equalsIgnoreCase("Planificador"))
						{
							Planificador planificador2 = (Planificador) Empresa.getInstance().getEmpleadoById(txtIdAdicional.getText());
							Proyecto proyecto = new Proyecto("123",txtNombre.getText(),jefe,planificador,programador1,programador2,planificador2, cmbCategoria.getSelectedItem().toString());
							Empresa.getInstance().nuevoProyecto(proyecto);
							
						}else if(cmbOcupacion.getSelectedItem().toString().equalsIgnoreCase("Programador"))
						{
							Programador programador3 = (Programador) Empresa.getInstance().getEmpleadoById(txtIdAdicional.getText());
							Proyecto proyecto = new Proyecto("123",txtNombre.getText(),jefe,planificador,programador1,programador2,programador3, cmbCategoria.getSelectedItem().toString());
							Empresa.getInstance().nuevoProyecto(proyecto);
							
						}else if(cmbOcupacion.getSelectedItem().toString().equalsIgnoreCase("Diseñador"))
						{
							Disegnador disegnador = (Disegnador) Empresa.getInstance().getEmpleadoById(txtIdAdicional.getText());
							Proyecto proyecto = new Proyecto("123",txtNombre.getText(),jefe,planificador,programador1,programador2,disegnador, cmbCategoria.getSelectedItem().toString());
							Empresa.getInstance().nuevoProyecto(proyecto);		
						}
						*/				
					}
				});
				buttonPane.setLayout(null);
				btnSiguiente.setActionCommand("OK");
				buttonPane.add(btnSiguiente);
				getRootPane().setDefaultButton(btnSiguiente);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBounds(671, 7, 75, 23);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			btnAnterior = new JButton("Anterior");
			btnAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					btnAgregarCliente.setVisible(false);
					btnAnterior.setVisible(false);
					btnSiguiente.setVisible(true);
					btnSiguiente.setEnabled(true);
					btnSiguiente2.setVisible(false);
					panel.setVisible(true);
					panel_1.setVisible(true);
					panel_2.setVisible(true);
					scrollPane_1.setVisible(false);
					panelClientes.setVisible(false);
				}
			});
			btnAnterior.setVisible(false);
			btnAnterior.setBounds(496, 7, 89, 23);
			buttonPane.add(btnAnterior);
			
			btnAgregarCliente = new JButton("Nuevo cliente");
			btnAgregarCliente.setBounds(10, 2, 133, 33);
			buttonPane.add(btnAgregarCliente);
			btnAgregarCliente.setIcon(new ImageIcon(RegProyecto.class.getResource("/img/Cliente 32x32.png")));
			
			btnSiguiente2 = new JButton("Siguiente");
			btnSiguiente2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Cliente cliente = Empresa.getInstance().getClienteById(select);
					RegContrato reg = new RegContrato();
					reg.setLocationRelativeTo(null);
					reg.setModal(true);
					reg.setVisible(true);
				}
			});
			btnSiguiente2.setBounds(589, 7, 77, 23);
			buttonPane.add(btnSiguiente2);
			btnAgregarCliente.setVisible(false);
			btnAgregarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegCliente reg = new RegCliente();
					reg.setLocationRelativeTo(null);
					reg.setModal(true);
					reg.setVisible(true);
					cargarClientes();
				}
			});
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(627, 11, 115, 170);
		panelProyecto.add(scrollPane);
		
		//TABLA
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setShowVerticalLines(false);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int index = table.getSelectedRow();
				if(index >= 0)
				{	
						//Jefe j = new Jefe("dasd", "d", "hombre", 8, "si", 5);
						//Empresa.getInstance().nuevoEmpleado(j);
						select = table.getValueAt(index, 0).toString();
						
						if(btnCargarJefe.isEnabled() && btnCargarProgramador.isEnabled() && btnCargarProgramador2.isEnabled() && btnCargarPlanificador.isEnabled()) {
							txtIdAdicional.setText(select);
						}
				
						if(!btnCargarJefe.isEnabled())
						{
							txtJefe.setText(select);
						}
						if(!btnCargarProgramador.isEnabled())
						{
							txtIdProgramador1.setText(select);
						}
						if(!btnCargarProgramador2.isEnabled())
						{
							txtIdProgramador2.setText(select);
						}
						if(!btnCargarPlanificador.isEnabled())
						{
							txtIdPlanificador.setText(select);
						}
						/*if(!btnCargarAdicional.isEnabled())
						{
							txtIdAdicional.setText(select);
						}*/
						
						lblNombreEmpleado.setText(Empresa.getInstance().getEmpleadoById(select).getNombre());
						lblIdempleado.setText(select.toString());
						lblOcupacionEmpleado.setText(Empresa.getInstance().getEmpleadoById(select).getCargo());
						lblCondicionempleado.setText(Character.toString(Empresa.getInstance().getEmpleadoById(select).getEvaluacionAnual()));
						lblSalarioempleado.setText(Float.toString(Empresa.getInstance().getEmpleadoById(select).getSalarioHora()));
				}

			}
		});
		table.setModel(model);
		
		
		
		scrollPane.setViewportView(table);
		
		panelClientes = new JPanel();
		panelClientes.setVisible(false);
		panelClientes.setBounds(0, -1, 753, 327);
		panelProyecto.add(panelClientes);
		panelClientes.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 733, 213);
		panelClientes.add(scrollPane_1);
		
		tablaClientes = new JTable();
		tablaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tablaClientes.getSelectedRow();
				if(index >= 0)
				{
					select = tablaClientes.getValueAt(index, 0).toString();
					btnSiguiente2.setEnabled(true);
				}else
				{
					btnSiguiente2.setEnabled(false);
				}
			}
		});
		
		scrollPane_1.setViewportView(tablaClientes);
		tablaClientes.setModel(modelClientes);
		
		
		
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panelProyecto, panel_2, lblNombre, lblId, lblOcupacion, lblSalariohora, lblEstado, lblIdempleado, panel_3, button, lblNombreEmpleado, lblOcupacionEmpleado, lblSalarioempleado, lblCondicionempleado, panel, lblNombreDelProyecto, txtNombre, lblEquipo, panel_1, lblProgramador, lblPlanificador, lblJefeDelProyecto, lblProgramador_1, txtJefe, btnCargarJefe, txtIdPlanificador, txtIdProgramador1, txtIdProgramador2, btnCargarPlanificador, btnCargarProgramador, btnCargarProgramador2, btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3, cmbOcupacion, txtIdAdicional, /*btnCargarAdicional, */btnNewButton_4, lblAdicional, lblCategoria, cmbCategoria, scrollPane_1, table, buttonPane, btnSiguiente, cancelButton}));
	}
	
	private void cargarJefes() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(int i = 0; i < Empresa.getInstance().getEmpleados().size(); i++) {
			if(Empresa.getInstance().getEmpleados().get(i) instanceof Jefe)
			{
				fila[0] = Empresa.getInstance().getEmpleados().get(i).getId();
				//fila[1] = Empresa.getInstance().getEmpleados().get(i).getNombre();
				//fila[2] = Empresa.getInstance().getEmpleados().get(i).getApellidos();
				model.addRow(fila);	
			}
		}
		
		table.getColumnModel().getColumn(0).setMinWidth(100);
		//table.getColumnModel().getColumn(0).setMaxWidth(100);	
	}
	
	private void cargarProgramadores() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(int i = 0; i < Empresa.getInstance().getEmpleados().size(); i++) {
			if(Empresa.getInstance().getEmpleados().get(i) instanceof Programador)
			{
				fila[0] = Empresa.getInstance().getEmpleados().get(i).getId();
				//fila[1] = Empresa.getInstance().getEmpleados().get(i).getNombre();
				//fila[2] = Empresa.getInstance().getEmpleados().get(i).getApellidos();
				model.addRow(fila);
			}
		}
		
		table.getColumnModel().getColumn(0).setMinWidth(100);
		//table.getColumnModel().getColumn(0).setMaxWidth(100);
		
	}
	private void cargarPlanificadores() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(int i = 0; i < Empresa.getInstance().getEmpleados().size(); i++) {
			if(Empresa.getInstance().getEmpleados().get(i) instanceof Planificador)
			{
				fila[0] = Empresa.getInstance().getEmpleados().get(i).getId();
				//fila[1] = Empresa.getInstance().getEmpleados().get(i).getNombre();
				//fila[2] = Empresa.getInstance().getEmpleados().get(i).getApellidos();
				model.addRow(fila);	
			}
			
		}
		
		table.getColumnModel().getColumn(0).setMinWidth(100);
		//table.getColumnModel().getColumn(0).setMaxWidth(100);
		
	}
	private void cargarDisegnadores() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(int i = 0; i < Empresa.getInstance().getEmpleados().size(); i++) {
			if(Empresa.getInstance().getEmpleados().get(i) instanceof Jefe)
			{
				fila[0] = Empresa.getInstance().getEmpleados().get(i).getId();
				//fila[1] = Empresa.getInstance().getEmpleados().get(i).getNombre();
				//fila[2] = Empresa.getInstance().getEmpleados().get(i).getApellidos();
				model.addRow(fila);
		
			}
		}
		
		table.getColumnModel().getColumn(0).setMinWidth(100);
		//table.getColumnModel().getColumn(0).setMaxWidth(100);
	}
	
	private void cargarClientes() {
		modelClientes.setRowCount(0);
		fila = new Object[modelClientes.getColumnCount()];
		for(int i = 0; i < Empresa.getInstance().getClientes().size(); i++) {
			fila[0] = Empresa.getInstance().getClientes().get(i).getId();
			fila[1] = Empresa.getInstance().getClientes().get(i).getNombre();
			fila[2] = Empresa.getInstance().getClientes().get(i).getDireccion();
			fila[3] = Empresa.getInstance().getClientes().get(i).getContratos().size();
			fila[4] = Empresa.getInstance().getClientes().get(i).getTotalContratos();
			
			modelClientes.addRow(fila);
		}
	}
	
}
