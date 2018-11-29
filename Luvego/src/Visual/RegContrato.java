package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

import Logico.Disegnador;
import Logico.Empleado;
import Logico.Empresa;
import Logico.Jefe;
import Logico.Planificador;
import Logico.Programador;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JComboBox;

public class RegContrato extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int ventana;
	private JButton btnCrear;
	private JButton btnCancelar;
	private JPanel buttonPane;
	private JComboBox cbxPlanificadores;
	private JComboBox cbxProgram1;
	private JComboBox cbxProgram2;
	private JComboBox cbxAuxiliar;
	private JPanel panel_contrato;
	private JLabel lbl_IdContrato;
	private JTextField txtIdContrato;
	private JLabel lblNombreProyecto;
	private JTextField txtNombreProyecto_panelContrato;
	private JLabel lblFechaEntrega;
	private JSpinner spnFecha;
	private String patron = "dd/MM/yyyy";
	private JLabel lblPrecioContrato;
	private JTextField txtPrecioContrato;
	private int caretPosition;
	private JTextField txtPrecioFinal;
	private JLabel lblIdProyecto;
	private JTextField textField;
	private JTextField txtJefe;
	private static DefaultTableModel model;
	private static Object fila[];
	private int index;
	private int opcionSeleccionada;
	private String identificadorSeleccionado;
	private String condicion;
	private JPanel panel;
	private JTextField txtIdCliente;
	private JTextField txtNombreCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegContrato dialog = new RegContrato();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegContrato() {
		setBounds(100, 100, 361, 404);
		setResizable(false);
		setTitle("Contrato");
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

				
		buttonPane = new JPanel();
		buttonPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		panel_contrato = new JPanel();
		//panel_contrato.setVisible(false);
		panel_contrato.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		((javax.swing.border.TitledBorder) panel_contrato.getBorder()).setTitleFont(new Font("Tahoma", Font.BOLD, 16));
		panel_contrato.setBounds(10, 11, 334, 331);
		contentPanel.add(panel_contrato);
		panel_contrato.setLayout(null);
		
		lbl_IdContrato = new JLabel("Identificador de contrato:");
		lbl_IdContrato.setBounds(18, 11, 126, 16);
		panel_contrato.add(lbl_IdContrato);
		
		txtIdContrato = new JTextField();
		txtIdContrato.setEditable(false);
		txtIdContrato.setBounds(147, 8, 130, 22);
		panel_contrato.add(txtIdContrato);
		txtIdContrato.setColumns(10);
		
		lblNombreProyecto = new JLabel("Nombre del proyecto");
		lblNombreProyecto.setBounds(182, 62, 142, 16);
		panel_contrato.add(lblNombreProyecto);
		
		txtNombreProyecto_panelContrato = new JTextField();
		txtNombreProyecto_panelContrato.setEditable(false);
		txtNombreProyecto_panelContrato.setBounds(182, 89, 148, 22);
		panel_contrato.add(txtNombreProyecto_panelContrato);
		txtNombreProyecto_panelContrato.setColumns(10);
		
		lblFechaEntrega = new JLabel("Fecha entrega");
		lblFechaEntrega.setBounds(18, 200, 84, 16);
		panel_contrato.add(lblFechaEntrega);
		
		Date date = new Date();
		SpinnerDateModel sdm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
		spnFecha = new JSpinner(sdm);
		spnFecha.setBounds(18, 227, 126, 22);
		JSpinner.DateEditor DateEdit = new JSpinner.DateEditor(spnFecha, patron);
		DateEdit.getTextField().setEditable(true);
		spnFecha.setEditor(DateEdit);
		panel_contrato.add(spnFecha);
		
		((DefaultEditor) spnFecha.getEditor()).getTextField().setHorizontalAlignment(SwingConstants.CENTER);
		((JSpinner.DefaultEditor)spnFecha.getEditor()).getTextField().addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {
				// TODO Auto-generated method stub
				caretPosition = e.getDot();				
			}
		});;
		
		((JSpinner.DefaultEditor)spnFecha.getEditor()).getTextField().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

				if(e.getKeyCode() != KeyEvent.VK_RIGHT && e.getKeyCode() != KeyEvent.VK_LEFT && e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN) {
					e.consume();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub


								
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

				if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
					e.consume();
				}

			}
		});
		
		lblPrecioContrato = new JLabel("Precio contrato:");
		lblPrecioContrato.setBounds(182, 200, 84, 16);
		panel_contrato.add(lblPrecioContrato);
		
		txtPrecioContrato = new JTextField();
		txtPrecioContrato.setEditable(false);
		txtPrecioContrato.setColumns(10);
		txtPrecioContrato.setBounds(182, 227, 148, 22);
		panel_contrato.add(txtPrecioContrato);
		
		JLabel lblPrecioFinal = new JLabel("Precio final:");
		lblPrecioFinal.setBounds(182, 260, 62, 16);
		panel_contrato.add(lblPrecioFinal);
		
		txtPrecioFinal = new JTextField();
		txtPrecioFinal.setEditable(false);
		txtPrecioFinal.setColumns(10);
		txtPrecioFinal.setBounds(182, 287, 148, 22);
		panel_contrato.add(txtPrecioFinal);
		
		lblIdProyecto = new JLabel("Identificador del Proyecto");
		lblIdProyecto.setBounds(18, 62, 139, 16);
		panel_contrato.add(lblIdProyecto);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(17, 89, 119, 22);
		panel_contrato.add(textField);
		textField.setColumns(10);
		
		JLabel lblIdDelCliente = new JLabel("Identificador del cliente");
		lblIdDelCliente.setBounds(18, 127, 119, 16);
		panel_contrato.add(lblIdDelCliente);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setEnabled(false);
		txtIdCliente.setBounds(15, 154, 121, 20);
		panel_contrato.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		JLabel lblNombreDelCliente = new JLabel("Nombre del cliente");
		lblNombreDelCliente.setBounds(182, 125, 95, 14);
		panel_contrato.add(lblNombreDelCliente);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setEnabled(false);
		txtNombreCliente.setBounds(182, 154, 148, 20);
		panel_contrato.add(txtNombreCliente);
		txtNombreCliente.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(0, 0, 355, 342);
		contentPanel.add(panel);
		model = new DefaultTableModel() {
			@Override
		    public boolean isCellEditable(int row, int column) {
		       return false;
		    }
		};
		
		model.setColumnIdentifiers(new String [] {"Id"});
		panel_contrato.setVisible(false);
			
		{
			btnCrear = new JButton("Crear contrato");
			
			btnCrear.setActionCommand("OK");
			buttonPane.add(btnCrear);
			getRootPane().setDefaultButton(btnCrear);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnCancelar.setActionCommand("Cancel");
			buttonPane.add(btnCancelar);
		}
		
	}
}