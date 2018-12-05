package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

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

import Logico.Cliente;
import Logico.ColorTabla;
import Logico.Empleado;
import Logico.Empresa;
import Logico.Proyecto;

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
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class ListarClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private static JTable table;
	private int index;
	private static DefaultTableModel modelClientes;
	private static Object[] fila;
	private JTextField txtNombre;
	private JTextField txtCedula;
	private String select;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarClientes dialog = new ListarClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarClientes() {
		setResizable(false);

		setTitle("Lista de proyectos");
		setBounds(100, 100, 1137, 453);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			modelClientes = new DefaultTableModel();

			String[] columnnames = {"Cedula", "Nombre", "Proyectos activos", "Proyectos totales" };
			modelClientes.setColumnIdentifiers(columnnames);

		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
			buttonPane.setBounds(0, 390, 1134, 34);
			contentPanel.add(buttonPane);
			{
				buttonPane.setLayout(null);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnSalir.setBounds(1010, 5, 114, 23);
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
			{
				JButton btnNuevoCliente = new JButton("Nuevo cliente");
				btnNuevoCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNuevoCliente.setBounds(0, 5, 155, 23);
				buttonPane.add(btnNuevoCliente);
				btnNuevoCliente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegProyecto reg = new RegProyecto();
						reg.setLocationRelativeTo(null);
						reg.setModal(true);
						reg.setVisible(true);
					}
				});
				btnNuevoCliente.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				btnNuevoCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnNuevoCliente.setIcon(new ImageIcon(ListarClientes.class.getResource("/img/nuevo archivo.png")));
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(112, 128, 144));
			panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel.setBounds(0, 0, 1134, 391);
			contentPanel.add(panel);
			panel.setLayout(null);

			scrollPane = new JScrollPane();
			scrollPane.setBounds(161, 22, 963, 330);
			panel.add(scrollPane);
			scrollPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {

					int index = table.getSelectedRow();
					if (index >= 0) {
						select = table.getValueAt(index, 0).toString();
						// btnAplazar.setEnabled(true);

					}
				}
			});
			table.setRowHeight(25);

			table.setFont(new Font("Tahoma", Font.PLAIN, 12));
			table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 12));

			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(modelClientes);
			scrollPane.setViewportView(table);
			{
				JPanel panel_2 = new JPanel();
				panel_2.setBounds(0, 11, 155, 243);
				panel.add(panel_2);
				panel_2.setLayout(null);
				panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
				panel_2.setBackground(new Color(211, 211, 211));
				{
					JPanel panel_1 = new JPanel();
					panel_1.setLayout(null);
					panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_1.setBackground(new Color(220, 220, 220));
					panel_1.setBounds(0, 0, 155, 78);
					panel_2.add(panel_1);
					{
						txtNombre = new JTextField();
						txtNombre.setColumns(10);
						txtNombre.setBounds(10, 20, 135, 20);
						panel_1.add(txtNombre);
					}
					{
						JButton btnCargarPorNombre = new JButton("Consultar");
						btnCargarPorNombre.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// cargarPorNombre(txtNombre.getText());
							}
						});
						btnCargarPorNombre.setBackground(new Color(220, 220, 220));
						btnCargarPorNombre.setBounds(38, 45, 79, 23);
						panel_1.add(btnCargarPorNombre);
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
					panel_2.add(panel_1);
					{
						txtCedula = new JTextField();
						txtCedula.setColumns(10);
						txtCedula.setBounds(10, 20, 135, 20);
						panel_1.add(txtCedula);
					}
					{
						JButton btnCargarPorId = new JButton("Consultar");
						btnCargarPorId.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								 cargarPorCedula();
							}
						});
						btnCargarPorId.setBackground(new Color(220, 220, 220));
						btnCargarPorId.setBounds(38, 45, 79, 23);
						panel_1.add(btnCargarPorId);
					}
					{
						JLabel lblBuscarPorCedula = new JLabel("Buscar por cedula");
						lblBuscarPorCedula.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblBuscarPorCedula.setBounds(25, 4, 114, 14);
						panel_1.add(lblBuscarPorCedula);
					}
				}
			}
		}
		cargarClientes();
	}

	private void cargarClientes() {
		modelClientes.setRowCount(0);
		fila = new Object[modelClientes.getColumnCount()];

		
		for (int i = 0; i < Empresa.getInstance().getClientes().size(); i++) {
			
			//fila[0] = Empresa.getInstance().getClientes().get(i).getId();
			//fila[0] = Empresa.getInstance().getClientes().get(i).getId();
			fila[0] = Empresa.getInstance().getClientes().get(i).getCedula();
			fila[1] = Empresa.getInstance().getClientes().get(i).getNombre();
			fila[2] = Empresa.getInstance().getClientes().get(i).getContratos().size();
			fila[3] = Empresa.getInstance().getClientes().get(i).getTotalContratos();

			modelClientes.addRow(fila);
		}
	}

	private void cargarPorNombre() {
		modelClientes.setRowCount(0);
		fila = new Object[modelClientes.getColumnCount()];

		for (int i = 0; i < Empresa.getInstance().getClientes().size(); i++) {
			if (Empresa.getInstance().getClientes().get(i).getNombre().equalsIgnoreCase(txtNombre.getText())) {
				fila[0] = Empresa.getInstance().getClientes().get(i).getId();
				fila[1] = Empresa.getInstance().getClientes().get(i).getCedula();
				fila[2] = Empresa.getInstance().getClientes().get(i).getNombre();
				fila[3] = Empresa.getInstance().getClientes().get(i).getContratos().size();
				fila[4] = Empresa.getInstance().getClientes().get(i).getTotalContratos();

				modelClientes.addRow(fila);
			}
		}
	}

	private void cargarPorCedula() {
		modelClientes.setRowCount(0);
		fila = new Object[modelClientes.getColumnCount()];

		for (int i = 0; i < Empresa.getInstance().getClientes().size(); i++) {
			if (Empresa.getInstance().getClientes().get(i).getNombre().equalsIgnoreCase(txtCedula.getText())) {
				fila[0] = Empresa.getInstance().getClientes().get(i).getId();
				fila[1] = Empresa.getInstance().getClientes().get(i).getCedula();
				fila[2] = Empresa.getInstance().getClientes().get(i).getNombre();
				fila[3] = Empresa.getInstance().getClientes().get(i).getContratos().size();
				fila[4] = Empresa.getInstance().getClientes().get(i).getTotalContratos();

				modelClientes.addRow(fila);
			}
		}
	}

	
}