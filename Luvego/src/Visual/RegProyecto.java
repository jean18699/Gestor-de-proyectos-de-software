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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

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

public class RegProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
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
	private int index;
	private JLabel lblIdEmpleado;
	private JLabel lblNombreEmpleado;
	private JLabel lblOcupacionEmpleado;
	private JLabel lblSalarioEmpleado;
	private JLabel lblOcupacionepleado;
	private JLabel lblSalarioempleado;
	private JLabel lblCondicionempleado;


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
		
		Jefe j = new Jefe("jean","carlos","hombre",19,"cerro alto",100);
		Empresa.getInstance().nuevoEmpleado(j);
		System.out.println(j.getId());
		setBounds(100, 100, 769, 392);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel.setBounds(10, 11, 174, 309);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNombre.setBounds(10, 175, 64, 14);
			panel.add(lblNombre);
			
			JLabel lblId = new JLabel("Identificador:");
			lblId.setFont(new Font("Sitka Text", Font.BOLD, 11));
			lblId.setBounds(10, 150, 78, 14);
			panel.add(lblId);
			
			JLabel lblOcupacion = new JLabel("Ocupacion:");
			lblOcupacion.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblOcupacion.setBounds(10, 200, 78, 14);
			panel.add(lblOcupacion);
			
			JLabel lblSalariohora = new JLabel("Salario/Hora:");
			lblSalariohora.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblSalariohora.setBounds(10, 225, 78, 14);
			panel.add(lblSalariohora);
			
			JLabel lblEstado = new JLabel("Condicion:");
			lblEstado.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblEstado.setBounds(10, 250, 64, 14);
			panel.add(lblEstado);
			
			JLabel lblIdempleado = new JLabel("IdEmpleado");
			lblIdempleado.setBounds(93, 149, 81, 14);
			panel.add(lblIdempleado);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_1.setBounds(0, 0, 174, 116);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JButton button = new JButton("");
			button.setEnabled(false);
			button.setIcon(new ImageIcon(RegProyecto.class.getResource("/img/Nuevo Proyecto.png")));
			panel_1.add(button, BorderLayout.CENTER);
			
			lblNombreEmpleado = new JLabel("NombreEmpleado");
			lblNombreEmpleado.setBounds(66, 175, 98, 14);
			panel.add(lblNombreEmpleado);
			
			lblOcupacionepleado = new JLabel("ocupacionEpleado");
			lblOcupacionepleado.setBounds(76, 200, 91, 14);
			panel.add(lblOcupacionepleado);
			
			lblSalarioempleado = new JLabel("salarioEmpleado");
			lblSalarioempleado.setBounds(93, 225, 81, 14);
			panel.add(lblSalarioempleado);
			
			lblCondicionempleado = new JLabel("condicionEmpleado");
			lblCondicionempleado.setBounds(76, 250, 98, 14);
			panel.add(lblCondicionempleado);
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(182, 11, 437, 340);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNombreDelProyecto = new JLabel("Nombre del proyecto:");
			lblNombreDelProyecto.setBounds(10, 11, 121, 14);
			panel.add(lblNombreDelProyecto);
			{
				txtNombre = new JTextField();
				txtNombre.setBounds(121, 8, 133, 20);
				panel.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				JLabel lblEquipo = new JLabel("Equipo de trabajo");
				lblEquipo.setBounds(10, 42, 133, 14);
				panel.add(lblEquipo);
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel_1.setBounds(10, 58, 416, 248);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblProgramador = new JLabel("Programador 1:");
			lblProgramador.setBounds(24, 61, 93, 14);
			panel_1.add(lblProgramador);
			
			JLabel lblPlanificador = new JLabel("Planificador:");
			lblPlanificador.setBounds(42, 36, 75, 14);
			panel_1.add(lblPlanificador);
			
			
			
			{
				JLabel lblJefeDelProyecto = new JLabel("Jefe del proyecto:");
				lblJefeDelProyecto.setBounds(10, 11, 114, 14);
				panel_1.add(lblJefeDelProyecto);
			}
			
			JLabel lblProgramador_1 = new JLabel("Programador 2:");
			lblProgramador_1.setBounds(24, 86, 93, 14);
			panel_1.add(lblProgramador_1);
			
			txtJefe = new JTextField();
			txtJefe.setBounds(105, 8, 144, 20);
			panel_1.add(txtJefe);
			txtJefe.setColumns(10);
			
			JButton btnCargarJefe = new JButton("Cargar");
			btnCargarJefe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarJefes();
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
			
			JButton btnCargarPlanificador = new JButton("Cargar");
			btnCargarPlanificador.setBounds(251, 32, 93, 23);
			panel_1.add(btnCargarPlanificador);
			
			JButton btnCargarProgramador = new JButton("Cargar");
			btnCargarProgramador.setBounds(251, 57, 93, 23);
			panel_1.add(btnCargarProgramador);
			
			JButton btnCargarProgramador2 = new JButton("Cargar");
			btnCargarProgramador2.setBounds(251, 82, 93, 23);
			panel_1.add(btnCargarProgramador2);
			
			JButton btnNewButton_1 = new JButton("Info");
			btnNewButton_1.setBounds(348, 7, 58, 23);
			panel_1.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Info");
			btnNewButton_2.setBounds(348, 32, 58, 23);
			panel_1.add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("Info");
			btnNewButton_3.setBounds(348, 57, 58, 23);
			panel_1.add(btnNewButton_3);
			
			JButton btnNewButton_4 = new JButton("Info");
			btnNewButton_4.setBounds(348, 82, 58, 23);
			panel_1.add(btnNewButton_4);
			
			cmbOcupacion = new JComboBox();
			cmbOcupacion.setModel(new DefaultComboBoxModel(new String[] {"<Ocupacion>", "Planificador", "Programador", "Dise\u00F1ador"}));
			cmbOcupacion.setBounds(251, 110, 93, 20);
			panel_1.add(cmbOcupacion);
			
			txtIdAdicional = new JTextField();
			txtIdAdicional.setEnabled(false);
			txtIdAdicional.setBounds(105, 111, 144, 20);
			panel_1.add(txtIdAdicional);
			txtIdAdicional.setColumns(10);
			
			JButton btnCargarAdicional = new JButton("Cargar");
			btnCargarAdicional.setBounds(251, 141, 65, 23);
			panel_1.add(btnCargarAdicional);
			
			JButton btnNewButton_5 = new JButton("Info");
			btnNewButton_5.setBounds(348, 109, 58, 23);
			panel_1.add(btnNewButton_5);
			
			JLabel lblAdicional = new JLabel("Adicional:");
			lblAdicional.setBounds(49, 113, 46, 14);
			panel_1.add(lblAdicional);
			
			JLabel lblCategoria = new JLabel("Categoria:");
			lblCategoria.setBounds(269, 11, 64, 14);
			panel.add(lblCategoria);
			
			cmbCategoria = new JComboBox();
			cmbCategoria.setBounds(328, 8, 98, 20);
			panel.add(cmbCategoria);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(627, 11, 115, 170);
		contentPanel.add(scrollPane);
		
		//TABLA
		table = new JTable();
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
						System.out.println(select);
						Empleado emp = Empresa.getInstance().getEmpleadoById(select);
						lblIdEmpleado.setText(emp.getId());
						
						
						
				}

			}
		});

		model = new DefaultTableModel();
		String[] titulos = {"ID"};
		model.setColumnIdentifiers(titulos);
		table.setModel(model);
		
		
		
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Siguiente");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
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
				
			}
			model.addRow(fila);
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
				
			}
			model.addRow(fila);
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
				
			}
			model.addRow(fila);
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
				
			}
			model.addRow(fila);
		}
		
		table.getColumnModel().getColumn(0).setMinWidth(100);
		//table.getColumnModel().getColumn(0).setMaxWidth(100);
		
	}

}
