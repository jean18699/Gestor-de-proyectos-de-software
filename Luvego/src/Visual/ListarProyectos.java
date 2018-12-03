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

public class ListarProyectos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private static JTable table;
	private int index;
	private JButton btnVerEquipo;
	private static DefaultTableModel model;
	private static Object[] fila;
	private JTextField txtNombre;
	private JTextField txtId;
	JComboBox<String> cmbCategoria;
	private String select;
	private JButton btnContratoInfo;

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
		setResizable(false);

		setTitle("Lista de proyectos");
		setBounds(100, 100, 943, 359);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		scrollPane.setBounds(160, 11, 690, 281);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPanel.add(scrollPane);
		{
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
				
					int index = table.getSelectedRow();
					if(index >= 0)
					{
						select = table.getValueAt(index, 0).toString();
						//btnAplazar.setEnabled(true);
						btnContratoInfo.setEnabled(true);
						btnVerEquipo.setEnabled(true);
					}else
					{
						//btnAplazar.setEnabled(false);
						btnContratoInfo.setEnabled(false);
						btnVerEquipo.setEnabled(false);
					}
				}
			});
			table.setRowHeight(25);
			
			
			table.setFont(new Font("Tahoma", Font.PLAIN, 12));
			table.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 12));

			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			model = new DefaultTableModel();
			
			
			String[] columnnames = { "Código", "Nombre", "Jefe de Proyecto","Estado" };
			model.setColumnIdentifiers(columnnames);
			table.setModel(model);
			scrollPane.setViewportView(table);
		
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, null, null));
			panel.setBackground(new Color(211, 211, 211));
			panel.setBounds(0, 10, 155, 243);
			contentPanel.add(panel);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel_1.setBackground(new Color(220, 220, 220));
				panel_1.setBounds(0, 0, 155, 78);
				panel.add(panel_1);
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
							cargarPorNombre(txtNombre.getText());
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
				panel.add(panel_1);
				{
					txtId = new JTextField();
					txtId.setColumns(10);
					txtId.setBounds(10, 20, 135, 20);
					panel_1.add(txtId);
				}
				{
					JButton btnCargarPorId = new JButton("Consultar");
					btnCargarPorId.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							cargarPorId(txtId.getText());
						}
					});
					btnCargarPorId.setBackground(new Color(220, 220, 220));
					btnCargarPorId.setBounds(38, 45, 79, 23);
					panel_1.add(btnCargarPorId);
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
					cmbCategoria = new JComboBox<String>();
					cmbCategoria.setModel(
							new DefaultComboBoxModel(new String[] { "<Seleccione>", "Escritorio", "Web", "Movil" }));
					cmbCategoria.setMaximumRowCount(15);
					cmbCategoria.setBounds(10, 20, 135, 20);
					panel_1.add(cmbCategoria);
				}
				{
					JButton button = new JButton("Consultar");
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(cmbCategoria.getSelectedItem().toString().equalsIgnoreCase("Escritorio"))
							{
								cargarProyectosDesktop();
							}
							if(cmbCategoria.getSelectedItem().toString().equalsIgnoreCase("Web"))
							{
								cargarProyectosWeb();
							}
							if(cmbCategoria.getSelectedItem().toString().equalsIgnoreCase("Movil"))
							{
								cargarProyectosMovil();
							}
						}
					});
					button.setBackground(new Color(220, 220, 220));
					button.setBounds(38, 45, 79, 23);
					panel_1.add(button);
				}
				{
					JLabel lblBuscarPorTipo = new JLabel("Buscar por categoria");
					lblBuscarPorTipo.setHorizontalAlignment(SwingConstants.CENTER);
					lblBuscarPorTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblBuscarPorTipo.setBounds(0, 5, 156, 14);
					panel_1.add(lblBuscarPorTipo);
				}
			}
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
			buttonPane.setBounds(0, 299, 937, 34);
			contentPanel.add(buttonPane);
			{
				btnVerEquipo = new JButton("Ver equipo");
				btnVerEquipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnVerEquipo.setBounds(758, 5, 106, 23);
				btnVerEquipo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArrayList<Empleado> equipo = Empresa.getInstance().getProyectoById(select).getGrupoTrabajo();
						InfoEquipo info = new  InfoEquipo(equipo);
						info.setLocationRelativeTo(null);
						info.setModal(true);
						info.setVisible(true);
					}
				});
				buttonPane.setLayout(null);
				btnVerEquipo.setEnabled(false);
				btnVerEquipo.setActionCommand("OK");
				buttonPane.add(btnVerEquipo);
				getRootPane().setDefaultButton(btnVerEquipo);
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnSalir.setBounds(874, 5, 53, 23);
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
			{
				JButton btnNuevoProyecto = new JButton("Nuevo proyecto");
				btnNuevoProyecto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnNuevoProyecto.setBounds(0, 5, 155, 23);
				buttonPane.add(btnNuevoProyecto);
				btnNuevoProyecto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegProyecto reg = new RegProyecto();
						reg.setLocationRelativeTo(null);
						reg.setModal(true);
						reg.setVisible(true);
					}
				});
				btnNuevoProyecto.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				btnNuevoProyecto.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnNuevoProyecto.setIcon(new ImageIcon(ListarProyectos.class.getResource("/img/nuevo archivo.png")));
			}
			{
				JButton btnRegistroDeContratos = new JButton("Registro de contratos");
				btnRegistroDeContratos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ListarContratos list = new ListarContratos();
						list.setLocationRelativeTo(null);
						list.setModal(true);
						list.setVisible(true);
					}
				});
				btnRegistroDeContratos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnRegistroDeContratos.setBounds(165, 3, 183, 26);
				buttonPane.add(btnRegistroDeContratos);
				btnRegistroDeContratos.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				btnRegistroDeContratos
						.setIcon(new ImageIcon(ListarProyectos.class.getResource("/img/Contratos/contratos.png")));
				btnRegistroDeContratos.setFont(new Font("Tahoma", Font.BOLD, 11));
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(112, 128, 144));
			panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel.setBounds(0, 0, 969, 300);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JPanel panel_2 = new JPanel();
				panel_2.setBounds(850, 11, 91, 289);
				panel.add(panel_2);
				panel_2.setBackground(Color.LIGHT_GRAY);
				panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel_2.setLayout(null);
				{
				    btnContratoInfo = new JButton("");
				    btnContratoInfo.setBounds(0, 0, 87, 83);
				    panel_2.add(btnContratoInfo);
					btnContratoInfo.setEnabled(false);
					btnContratoInfo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Proyecto proyecto = Empresa.getInstance().getProyectoById(select);
							Cliente cliente = Empresa.getInstance().getClienteByIdProyecto(proyecto.getId());
							InfoContrato info = new InfoContrato(proyecto, cliente);
							info.setLocationRelativeTo(null);
							info.setModal(true);
							info.setVisible(true);
							cargarProyectos();
						}
					});
					btnContratoInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnContratoInfo.setToolTipText("Ver contrato");
					btnContratoInfo.setBackground(Color.WHITE);
					btnContratoInfo.setIcon(
							new ImageIcon(ListarProyectos.class.getResource("/img/Contratos/Contratos 64x64.png")));
					btnContratoInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
					btnContratoInfo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				}
			}
		}
		cargarProyectos();
	}

	private void cargarProyectos() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Empresa.getInstance().getProyectos().size(); i++) {
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

	private void cargarProyectosMovil() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Empresa.getInstance().getProyectos().size(); i++) {
			if (Empresa.getInstance().getProyectos().get(i).getClasificacion().equalsIgnoreCase("Movil")) {
				fila[0] = Empresa.getInstance().getProyectos().get(i).getId();
				fila[1] = Empresa.getInstance().getProyectos().get(i).getNombre();
				fila[2] = Empresa.getInstance().getProyectos().get(i).getJefeProyecto().getNombre() +" "+ Empresa.getInstance().getProyectos().get(i).getJefeProyecto().getApellidos();

				model.addRow(fila);
			}
		}

		table.getColumnModel().getColumn(0).setMinWidth(200);
		table.getColumnModel().getColumn(0).setMaxWidth(200);

		table.getColumnModel().getColumn(1).setMinWidth(200);
		table.getColumnModel().getColumn(1).setMaxWidth(200);
	}

	private void cargarProyectosWeb() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Empresa.getInstance().getProyectos().size(); i++) {

			if (Empresa.getInstance().getProyectos().get(i).getClasificacion().equalsIgnoreCase("Web")) {
				fila[0] = Empresa.getInstance().getProyectos().get(i).getId();
				fila[1] = Empresa.getInstance().getProyectos().get(i).getNombre();
				fila[2] = Empresa.getInstance().getProyectos().get(i).getJefeProyecto().getNombre() +" "+ Empresa.getInstance().getProyectos().get(i).getJefeProyecto().getApellidos();

				model.addRow(fila);
			}

		}

		table.getColumnModel().getColumn(0).setMinWidth(200);
		table.getColumnModel().getColumn(0).setMaxWidth(200);

		table.getColumnModel().getColumn(1).setMinWidth(200);
		table.getColumnModel().getColumn(1).setMaxWidth(200);
	}

	private void cargarProyectosDesktop() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Empresa.getInstance().getProyectos().size(); i++) {
			if (Empresa.getInstance().getProyectos().get(i).getClasificacion().equalsIgnoreCase("Escritorio")) {
				fila[0] = Empresa.getInstance().getProyectos().get(i).getId();
				fila[1] = Empresa.getInstance().getProyectos().get(i).getNombre();
				fila[2] = Empresa.getInstance().getProyectos().get(i).getJefeProyecto().getNombre() +" "+ Empresa.getInstance().getProyectos().get(i).getJefeProyecto().getApellidos();
				fila[3] = Empresa.getInstance().getProyectos().get(i).getEstado();

				model.addRow(fila);
			}
		}

		table.getColumnModel().getColumn(0).setMinWidth(200);
		table.getColumnModel().getColumn(0).setMaxWidth(200);

		table.getColumnModel().getColumn(1).setMinWidth(200);
		table.getColumnModel().getColumn(1).setMaxWidth(200);
	}
	
	private void cargarPorNombre(String nombre) {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Empresa.getInstance().getProyectos().size(); i++) {
			if (Empresa.getInstance().getProyectos().get(i).getNombre().equalsIgnoreCase(nombre)) {
				fila[0] = Empresa.getInstance().getProyectos().get(i).getId();
				fila[1] = Empresa.getInstance().getProyectos().get(i).getNombre();
				fila[2] = Empresa.getInstance().getProyectos().get(i).getJefeProyecto().getNombre() +" "+ Empresa.getInstance().getProyectos().get(i).getJefeProyecto().getApellidos();
				fila[3] = Empresa.getInstance().getProyectos().get(i).getEstado();

				model.addRow(fila);
			}
		}

		table.getColumnModel().getColumn(0).setMinWidth(200);
		table.getColumnModel().getColumn(0).setMaxWidth(200);

		table.getColumnModel().getColumn(1).setMinWidth(200);
		table.getColumnModel().getColumn(1).setMaxWidth(200);
	}
	
	private void cargarPorId(String id) {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (int i = 0; i < Empresa.getInstance().getProyectos().size(); i++) {
			if (Empresa.getInstance().getProyectos().get(i).getId().equalsIgnoreCase(id)) {
				fila[0] = Empresa.getInstance().getProyectos().get(i).getId();
				fila[1] = Empresa.getInstance().getProyectos().get(i).getNombre();
				fila[2] = Empresa.getInstance().getProyectos().get(i).getJefeProyecto().getNombre() +" "+ Empresa.getInstance().getProyectos().get(i).getJefeProyecto().getApellidos();
				fila[3] = Empresa.getInstance().getProyectos().get(i).getEstado();

				model.addRow(fila);
			}
		}

		table.getColumnModel().getColumn(0).setMinWidth(200);
		table.getColumnModel().getColumn(0).setMaxWidth(200);

		table.getColumnModel().getColumn(1).setMinWidth(200);
		table.getColumnModel().getColumn(1).setMaxWidth(200);
	}
	
}
