package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
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

import Logico.Disegnador;
import Logico.Empresa;
import Logico.Jefe;
import Logico.Programador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class ListarEmpleados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private static JTable table;
	private int index;
	private JButton btnDetalles;
	private static DefaultTableModel model;
	private static Object[] fila;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblX;
	private JPanel panel_2;
	private JLabel label;
	private JPanel panel_3;
	private JLabel label_1;
	private String select;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarEmpleados dialog = new ListarEmpleados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarEmpleados() {
		setTitle("Lista de proyectos");
		setBounds(100, 100, 807, 310);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		scrollPane.setBounds(0, 0, 700, 230);
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
						System.out.println(select);
					}
				}
			});
			table.setRowHeight(25);
			
		
			table.setFont(new Font("Tahoma", Font.PLAIN, 12));
			table.getTableHeader().setFont(new Font("Tahoma", Font.ITALIC, 18));
			
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			model = new DefaultTableModel();
			String[] columnnames = {"Código", "Nombre", "Apellidos", "Posición"};
			model.setColumnIdentifiers(columnnames);
			table.setModel(model);
			scrollPane.setViewportView(table);
			{
				panel = new JPanel();
				panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel.setBounds(699, 0, 93, 230);
				contentPanel.add(panel);
				panel.setLayout(null);
				{
					panel_1 = new JPanel();
					panel_1.setBackground(Color.RED);
					panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_1.setBounds(0, 160, 93, 70);
					panel.add(panel_1);
					panel_1.setLayout(null);
					{
						lblX = new JLabel("X");
						lblX.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(java.awt.event.MouseEvent e) {
								Empresa.getInstance().eliminarEmpleado(select);
								cargarEmpleados();
							
							}
						});
						lblX.setBackground(Color.RED);
						lblX.setToolTipText("Eliminar");
						lblX.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
						lblX.setForeground(Color.WHITE);
						lblX.setHorizontalAlignment(SwingConstants.CENTER);
						lblX.setFont(new Font("Tahoma", Font.BOLD, 48));
						lblX.setBounds(0, 0, 93, 70);
						panel_1.add(lblX);
					}
				}
				{
					panel_2 = new JPanel();
					panel_2.setBackground(Color.WHITE);
					panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_2.setBounds(0, 0, 93, 84);
					panel.add(panel_2);
					panel_2.setLayout(null);
					{
						label = new JLabel("");
						label.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(java.awt.event.MouseEvent e) {
								RegEmpleado reg = new RegEmpleado();
								reg.setLocationRelativeTo(null);
								reg.setModal(true);
								reg.setVisible(true);
								cargarEmpleados();
							}
						});
						label.setToolTipText("Nuevo empleado");
						label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
						label.setBackground(Color.WHITE);
						label.setBounds(0, 0, 93, 84);
						panel_2.add(label);
						label.setHorizontalAlignment(SwingConstants.CENTER);
						label.setIcon(new ImageIcon(ListarEmpleados.class.getResource("/img/Cliente a color.png")));
					}
				}
				{
					panel_3 = new JPanel();
					panel_3.setBackground(Color.WHITE);
					panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_3.setBounds(0, 83, 93, 78);
					panel.add(panel_3);
					panel_3.setLayout(null);
					{
						label_1 = new JLabel("\u00A1");
						label_1.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(java.awt.event.MouseEvent e) {
								InfoEmpleado info = new InfoEmpleado(Empresa.getInstance().getEmpleadoById(select));
								info.setLocationRelativeTo(null);
								info.setModal(true);
								info.setVisible(true);
								cargarEmpleados();
							}
						});
						label_1.setToolTipText("Informacion");
						label_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
						label_1.setForeground(Color.BLUE);
						label_1.setHorizontalAlignment(SwingConstants.CENTER);
						label_1.setFont(new Font("Tahoma", Font.BOLD, 50));
						label_1.setBounds(0, 0, 93, 78);
						panel_3.add(label_1);
					}
				}
			}
			cargarEmpleados();
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnDetalles = new JButton("Detalles");
				btnDetalles.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnDetalles.setEnabled(false);
				btnDetalles.setActionCommand("OK");
				buttonPane.add(btnDetalles);
				getRootPane().setDefaultButton(btnDetalles);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		cargarEmpleados();
	}
	
	private void cargarEmpleados() {
		
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(int i = 0; i < Empresa.getInstance().getEmpleados().size(); i++) {
			fila[0] = Empresa.getInstance().getEmpleados().get(i).getId();
			fila[1] = Empresa.getInstance().getEmpleados().get(i).getNombre();
			fila[2] = Empresa.getInstance().getEmpleados().get(i).getApellidos();
			
			if(Empresa.getInstance().getEmpleados().get(i) instanceof Jefe) {
				fila[3] = "Jefe de proyecto";
			}
			else if(Empresa.getInstance().getEmpleados().get(i) instanceof Disegnador) {
				fila[3] = "Diseñador";
			}
			else if(Empresa.getInstance().getEmpleados().get(i) instanceof Programador) {
				fila[3] = "Programador";
			}
			else {
				fila[3] = "Planificador";
			}
			
			model.addRow(fila);
		}
		
		table.getColumnModel().getColumn(0).setMinWidth(200);
		table.getColumnModel().getColumn(0).setMaxWidth(200);
		
		table.getColumnModel().getColumn(1).setMinWidth(250);
		table.getColumnModel().getColumn(1).setMaxWidth(250);
		
		table.getColumnModel().getColumn(1).setMinWidth(250);
		table.getColumnModel().getColumn(1).setMaxWidth(250);
		
		table.getColumnModel().getColumn(1).setMinWidth(250);
		table.getColumnModel().getColumn(1).setMaxWidth(250);

	}

}
