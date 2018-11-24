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
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import Logico.Empleado;
import Logico.Empresa;
import Logico.Jefe;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class RegProyecto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private JTextField txtJefe;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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

	/**
	 * Create the dialog.
	 */
	public RegProyecto() {
		setBounds(100, 100, 880, 392);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel.setBounds(10, 11, 166, 309);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 175, 46, 14);
			panel.add(lblNombre);
			
			JLabel lblId = new JLabel("Id:");
			lblId.setBounds(10, 150, 26, 14);
			panel.add(lblId);
			
			JLabel lblOcupacion = new JLabel("Ocupacion:");
			lblOcupacion.setBounds(10, 200, 78, 14);
			panel.add(lblOcupacion);
			
			JLabel lblSalariohora = new JLabel("Salario/Hora:");
			lblSalariohora.setBounds(10, 225, 78, 14);
			panel.add(lblSalariohora);
			
			JLabel lblEstado = new JLabel("Condicion:");
			lblEstado.setBounds(10, 250, 64, 14);
			panel.add(lblEstado);
			
			JLabel lblIdempleado = new JLabel("IdEmpleado");
			lblIdempleado.setBounds(30, 150, 126, 14);
			panel.add(lblIdempleado);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel_1.setBounds(0, 0, 166, 116);
			panel.add(panel_1);
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
				textField = new JTextField();
				textField.setBounds(121, 8, 133, 20);
				panel.add(textField);
				textField.setColumns(10);
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
			
			Empleado j1 = new Jefe("jean","carlos","hombre",19,"cerro alto",80);
			Empleado j2 = new Jefe("jean","carlos","hombre",19,"cerro alto",80);
			Empleado j3 = new Jefe("jean","carlos","hombre",19,"cerro alto",80);
			
			Empresa.getInstance().nuevoEmpleado(j1);
			Empresa.getInstance().nuevoEmpleado(j2);
			Empresa.getInstance().nuevoEmpleado(j3);
			
			ArrayList<String> idJefes = new ArrayList<>();
			for(int i = 0; i < Empresa.getInstance().getEmpleados().size();i++)
			{
				if(Empresa.getInstance().getEmpleados().get(i) instanceof Jefe)
				{
					idJefes.add(((Jefe)Empresa.getInstance().getEmpleados().get(i)).getId());
				}
			}
			{
				JLabel lblJefeDelProyecto = new JLabel("Jefe del proyecto:");
				lblJefeDelProyecto.setBounds(10, 11, 114, 14);
				panel_1.add(lblJefeDelProyecto);
			}
			
			JLabel lblProgramador_1 = new JLabel("Programador 2:");
			lblProgramador_1.setBounds(24, 86, 93, 14);
			panel_1.add(lblProgramador_1);
			
			JLabel lblAgregarAuxiliar = new JLabel("Auxiliar:");
			lblAgregarAuxiliar.setBounds(24, 131, 46, 14);
			panel_1.add(lblAgregarAuxiliar);
			
			JRadioButton rdbtnSi = new JRadioButton("Si");
			rdbtnSi.setBounds(76, 127, 33, 23);
			panel_1.add(rdbtnSi);
			buttonGroup.add(rdbtnSi);
			
			JRadioButton rdbtnNo = new JRadioButton("No");
			rdbtnNo.setBounds(111, 127, 46, 23);
			panel_1.add(rdbtnNo);
			buttonGroup.add(rdbtnNo);
			rdbtnNo.setSelected(true);
			
			txtJefe = new JTextField();
			txtJefe.setEnabled(false);
			txtJefe.setBounds(105, 8, 144, 20);
			panel_1.add(txtJefe);
			txtJefe.setColumns(10);
			
			JButton btnRegistro = new JButton("Cargar");
			btnRegistro.setBounds(251, 7, 93, 23);
			panel_1.add(btnRegistro);
			
			textField_1 = new JTextField();
			textField_1.setEnabled(false);
			textField_1.setBounds(105, 33, 144, 20);
			panel_1.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setEnabled(false);
			textField_2.setBounds(105, 58, 144, 20);
			panel_1.add(textField_2);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setEnabled(false);
			textField_3.setBounds(105, 83, 144, 20);
			panel_1.add(textField_3);
			textField_3.setColumns(10);
			
			JButton btnCargar = new JButton("Cargar");
			btnCargar.setBounds(251, 32, 93, 23);
			panel_1.add(btnCargar);
			
			JButton btnCargar_1 = new JButton("Cargar");
			btnCargar_1.setBounds(251, 57, 93, 23);
			panel_1.add(btnCargar_1);
			
			JButton btnCargar_2 = new JButton("Cargar");
			btnCargar_2.setBounds(251, 82, 93, 23);
			panel_1.add(btnCargar_2);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Empleado adicional:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(10, 155, 335, 82);
			panel_1.add(panel_2);
			panel_2.setLayout(null);
			
			JButton btnNewButton = new JButton("Cargar");
			btnNewButton.setBounds(146, 50, 89, 23);
			panel_2.add(btnNewButton);
			
			textField_4 = new JTextField();
			textField_4.setBounds(10, 51, 133, 20);
			panel_2.add(textField_4);
			textField_4.setColumns(10);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(10, 20, 133, 20);
			panel_2.add(comboBox);
			
			JButton btnNewButton_5 = new JButton("Info");
			btnNewButton_5.setBounds(240, 50, 53, 23);
			panel_2.add(btnNewButton_5);
			
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
			
			JLabel lblCategoria = new JLabel("Categoria:");
			lblCategoria.setBounds(269, 11, 64, 14);
			panel.add(lblCategoria);
			
			JComboBox comboBox_6 = new JComboBox();
			comboBox_6.setBounds(328, 8, 98, 20);
			panel.add(comboBox_6);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(627, 11, 227, 309);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Siguiente");
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
}
