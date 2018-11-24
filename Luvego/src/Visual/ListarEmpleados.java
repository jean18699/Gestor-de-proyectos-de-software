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

public class ListarEmpleados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private static JTable table;
	private int index;
	private JButton btnDetalles;
	private static DefaultTableModel model;
	private static Object[] fila;

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
		setBounds(100, 100, 1000, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new BorderLayout(0,0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		{
			table = new JTable();
			table.setRowHeight(25);
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					index = table.getSelectedRow();
					if(index >= 0) {
						btnDetalles.setEnabled(true);
					}
				}
			});
			table.setFont(new Font("Tahoma", Font.PLAIN, 16));
			table.getTableHeader().setFont(new Font("Tahoma", Font.ITALIC, 18));
			
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			model = new DefaultTableModel();
			String[] columnnames = {"Código", "Nombre", "Apellidos", "Posición"};
			model.setColumnIdentifiers(columnnames);
			table.setModel(model);
			scrollPane.setViewportView(table);
			
		}
		{
			JPanel buttonPane = new JPanel();
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
		for(int i = 0; i < Empresa.getInstance().getProyectos().size(); i++) {
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
