package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.glass.events.MouseEvent;

import Logico.Empresa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

public class ListarProyectos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private static JTable table;
	private int index;
	private JButton btnVerDetalles;
	private static DefaultTableModel model;
	private static Object[] fila;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarProyectos dialog = new ListarProyectos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarProyectos() {
		
		setTitle("Lista de proyectos");
		setBounds(100, 100, 700, 377);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		scrollPane.setBounds(158, 65, 408, 243);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPanel.add(scrollPane);
		{
			table = new JTable();
			table.setRowHeight(25);
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					index = table.getSelectedRow();
					if(index >= 0) {
						btnVerDetalles.setEnabled(true);
					}
				}
			});
			table.setFont(new Font("Tahoma", Font.PLAIN, 16));
			table.getTableHeader().setFont(new Font("Tahoma", Font.ITALIC, 18));
			
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			model = new DefaultTableModel();
			String[] columnnames = {"Código", "Nombre", "Jefe de Proyecto"};
			model.setColumnIdentifiers(columnnames);
			table.setModel(model);
			scrollPane.setViewportView(table);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
			panel.setBackground(new Color(211, 211, 211));
			panel.setBounds(0, 65, 155, 243);
			contentPanel.add(panel);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel_1.setBackground(new Color(220, 220, 220));
				panel_1.setBounds(0, 0, 155, 78);
				panel.add(panel_1);
				{
					textField = new JTextField();
					textField.setColumns(10);
					textField.setBounds(10, 20, 135, 20);
					panel_1.add(textField);
				}
				{
					JButton button = new JButton("Consultar");
					button.setBackground(new Color(220, 220, 220));
					button.setBounds(38, 45, 79, 23);
					panel_1.add(button);
				}
				{
					JLabel lblBuscarPorNombre = new JLabel("Buscar por nombre");
					lblBuscarPorNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblBuscarPorNombre.setBounds(27, 5, 124, 14);
					panel_1.add(lblBuscarPorNombre);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
				panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel_1.setBackground(new Color(220, 220, 220));
				panel_1.setBounds(0, 78, 155, 86);
				panel.add(panel_1);
				{
					textField_1 = new JTextField();
					textField_1.setColumns(10);
					textField_1.setBounds(10, 20, 135, 20);
					panel_1.add(textField_1);
				}
				{
					JButton button = new JButton("Consultar");
					button.setBackground(new Color(220, 220, 220));
					button.setBounds(38, 45, 79, 23);
					panel_1.add(button);
				}
				{
					JLabel lblBuscarPorId = new JLabel("Buscar por ID");
					lblBuscarPorId.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblBuscarPorId.setBounds(38, 6, 86, 14);
					panel_1.add(lblBuscarPorId);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel_1.setBackground(new Color(220, 220, 220));
				panel_1.setBounds(0, 165, 155, 78);
				panel.add(panel_1);
				{
					JComboBox<String> comboBox = new JComboBox<String>();
					comboBox.setMaximumRowCount(15);
					comboBox.setBounds(10, 20, 135, 20);
					panel_1.add(comboBox);
				}
				{
					JButton button = new JButton("Consultar");
					button.setBackground(new Color(220, 220, 220));
					button.setBounds(38, 45, 79, 23);
					panel_1.add(button);
				}
				{
					JLabel lblBuscarPorTipo = new JLabel("Buscar por tipo");
					lblBuscarPorTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblBuscarPorTipo.setBounds(38, 5, 118, 14);
					panel_1.add(lblBuscarPorTipo);
				}
			}
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			buttonPane.setBounds(0, 308, 684, 34);
			contentPanel.add(buttonPane);
			{
				btnVerDetalles = new JButton("Ver detalles");
				btnVerDetalles.setBounds(515, 5, 106, 23);
				btnVerDetalles.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				buttonPane.setLayout(null);
				btnVerDetalles.setEnabled(false);
				btnVerDetalles.setActionCommand("OK");
				buttonPane.add(btnVerDetalles);
				getRootPane().setDefaultButton(btnVerDetalles);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.setBounds(626, 5, 53, 23);
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
		{
			JButton btnNuevoProyecto = new JButton("Nuevo proyecto");
			btnNuevoProyecto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegProyecto reg = new RegProyecto();
					reg.setLocationRelativeTo(null);
					reg.setModal(true);
					reg.setVisible(true);
				}
			});
			btnNuevoProyecto.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			btnNuevoProyecto.setBounds(0, 0, 155, 53);
			contentPanel.add(btnNuevoProyecto);
			btnNuevoProyecto.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNuevoProyecto.setIcon(new ImageIcon(ListarProyectos.class.getResource("/img/nuevo archivo.png")));
		}
		{
			JButton btnRegistroDeContratos = new JButton("Registro de contratos");
			btnRegistroDeContratos.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			btnRegistroDeContratos.setIcon(new ImageIcon(ListarProyectos.class.getResource("/img/Contratos/contratos.png")));
			btnRegistroDeContratos.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnRegistroDeContratos.setBounds(152, 0, 183, 53);
			contentPanel.add(btnRegistroDeContratos);
		}
		{
			JButton button = new JButton("");
			button.setIcon(new ImageIcon(ListarProyectos.class.getResource("/img/Contratos/Aplazo de contratos.png")));
			button.setFont(new Font("Tahoma", Font.BOLD, 11));
			button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			button.setBounds(567, 136, 115, 75);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("");
			button.setIcon(new ImageIcon(ListarProyectos.class.getResource("/img/Contratos/Contratos 64x64.png")));
			button.setFont(new Font("Tahoma", Font.BOLD, 11));
			button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			button.setBounds(567, 65, 115, 75);
			contentPanel.add(button);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel.setBounds(567, 65, 115, 243);
			contentPanel.add(panel);
		}
		cargarProyectos();
	}
	
	private void cargarProyectos() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(int i = 0; i < Empresa.getInstance().getProyectos().size(); i++) {
			fila[0] = Empresa.getInstance().getProyectos().get(i).getId();
			fila[1] = Empresa.getInstance().getProyectos().get(i).getNombre();
			fila[2] = Empresa.getInstance().getProyectos().get(i).getJefeProyecto().getApellidos();
			
			model.addRow(fila);
		}
		
		table.getColumnModel().getColumn(0).setMinWidth(200);
		table.getColumnModel().getColumn(0).setMaxWidth(200);
		
		table.getColumnModel().getColumn(1).setMinWidth(200);
		table.getColumnModel().getColumn(1).setMaxWidth(200);
	}
}
