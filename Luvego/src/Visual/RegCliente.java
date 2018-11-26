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
import Logico.Empresa;
import Logico.Jefe;
import Logico.Planificador;
import Logico.Programador;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JComboBox;

public class RegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int ventana;
	private JButton btnSiguiente;
	private JButton btnCancelar;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtId;
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblDireccion;
	private JPanel panel_infoPersonal;
	private JPanel panel_proyecto;
	private JPanel buttonPane;
	private JButton btnAnterior;
	private JLabel lblJefeDeProyecto;
	private JComboBox cbxPlanificadores;
	private JLabel lblProgramador1;
	private JComboBox cbxProgram1;
	private JLabel lblProgramador2;
	private JComboBox cbxProgram2;
	private JLabel lblAuxiliar;
	private JComboBox cbxAuxiliar;
	private JLabel lblBuscarPorId;
	private JTextField txtBuscarJefe;
	private JTextField txtBuscarPlanificador;
	private JTextField txtBuscarProgram1;
	private JTextField txtBuscarProgram2;
	private JTextField txtBuscarAuxiliar;
	private JLabel idProyecto;
	private JTextField txtIdProyecto;
	private JPanel panel_contrato;
	private JLabel lbl_IdContrato;
	private JTextField txtIdContrato;
	private JLabel lblNombreProyecto;
	private JTextField txtNombreProyecto;
	private JLabel lblFechaEntrega;
	private JSpinner spnFecha;
	private String patron = "dd/MM/yyyy";
	private JLabel lblPrecioContrato;
	private JTextField txtPrecioContrato;
	private int caretPosition;
	private JTextField txtPrecioFinal;
	private JLabel lblIdProyecto;
	private JTextField textField;
	private JPanel panel_InfoEmpleado;
	private JPanel panelFotoEmpleado;
	private JButton btnFotoEmpleado;
	private JLabel lblId_1;
	private JLabel lblNombre_1;
	private JLabel lblOcupacin;
	private JLabel lblSalariohora;
	private JLabel lblCondicin;
	private JLabel lblNewLabel;
	private JLabel lblOcupacionEmpleado;
	private JLabel lblNombreEmpleado;
	private JLabel lbl_IdEmpleado;
	private JLabel lblCondicion;
	private JLabel lblCategoria;
	private JComboBox cbxCategoria;
	private JPanel panelEquipo;
	private JLabel lblEquipoDeTrabajo;
	private JTextField txtJefe;
	private JTextField txtPlanificador;
	private JTextField txtProgramador1;
	private JTextField txtProgramador2;
	private JTextField txtAuxiliar;
	private JButton btnCargarPlanif;
	private JButton btnCargarProgram1;
	private JButton btnCargarProgram2;
	private JComboBox cbxOcupacionAuxiliar;
	private JButton btnInfoJefe;
	private JButton btnInfoPlanif;
	private JButton btnInfoProgram1;
	private JButton btnProgram2;
	private JButton btnInfoAuxiliar;
	private JScrollPane scrollListaEmpleados;
	private JLabel lblSeleccionarEmpleado;
	private static DefaultTableModel model;
	private static Object fila[];
	private JTable table;
	private JLabel lblFotoEmpresa;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegCliente dialog = new RegCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCliente() {
		setBounds(100, 100, 924, 404);
		setResizable(false);
		setTitle("Registrar cliente");
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		ventana = 0;
		
		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		panel_contrato = new JPanel();
		//panel_contrato.setVisible(false);
		panel_contrato.setBorder(new TitledBorder(null, "Informacion contrato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		((javax.swing.border.TitledBorder) panel_contrato.getBorder()).setTitleFont(new Font("Tahoma", Font.BOLD, 16));
		panel_contrato.setBounds(12, 23, 894, 288);
		contentPanel.add(panel_contrato);
		panel_contrato.setLayout(null);
		
		lbl_IdContrato = new JLabel("Id contrato: ");
		lbl_IdContrato.setBounds(12, 37, 116, 16);
		panel_contrato.add(lbl_IdContrato);
		
		txtIdContrato = new JTextField();
		txtIdContrato.setEditable(false);
		txtIdContrato.setBounds(93, 34, 126, 22);
		panel_contrato.add(txtIdContrato);
		txtIdContrato.setColumns(10);
		
		lblNombreProyecto = new JLabel("Nombre proyecto: ");
		lblNombreProyecto.setBounds(12, 102, 116, 16);
		panel_contrato.add(lblNombreProyecto);
		
		txtNombreProyecto = new JTextField();
		txtNombreProyecto.setEditable(false);
		txtNombreProyecto.setBounds(140, 99, 189, 22);
		panel_contrato.add(txtNombreProyecto);
		txtNombreProyecto.setColumns(10);
		
		lblFechaEntrega = new JLabel("Fecha entrega:");
		lblFechaEntrega.setBounds(12, 158, 103, 16);
		panel_contrato.add(lblFechaEntrega);
		
		Date date = new Date();
		SpinnerDateModel sdm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
		spnFecha = new JSpinner(sdm);
		spnFecha.setBounds(124, 155, 243, 22);
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
		lblPrecioContrato.setBounds(12, 233, 116, 16);
		panel_contrato.add(lblPrecioContrato);
		
		txtPrecioContrato = new JTextField();
		txtPrecioContrato.setEditable(false);
		txtPrecioContrato.setColumns(10);
		txtPrecioContrato.setBounds(127, 230, 157, 22);
		panel_contrato.add(txtPrecioContrato);
		
		JLabel lblPrecioFinal = new JLabel("Precio final:");
		lblPrecioFinal.setBounds(319, 233, 116, 16);
		panel_contrato.add(lblPrecioFinal);
		
		txtPrecioFinal = new JTextField();
		txtPrecioFinal.setEditable(false);
		txtPrecioFinal.setColumns(10);
		txtPrecioFinal.setBounds(411, 230, 157, 22);
		panel_contrato.add(txtPrecioFinal);
		
		lblIdProyecto = new JLabel("Id Proyecto:");
		lblIdProyecto.setBounds(311, 37, 69, 16);
		panel_contrato.add(lblIdProyecto);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(392, 34, 176, 22);
		panel_contrato.add(textField);
		textField.setColumns(10);
		
		panel_proyecto = new JPanel();
		//panel_proyecto.setVisible(false);
		panel_proyecto.setBorder(new TitledBorder(null, "Informacion proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		((javax.swing.border.TitledBorder) panel_proyecto.getBorder()).setTitleFont(new Font("Tahoma", Font.BOLD, 16));
		panel_proyecto.setBounds(12, 23, 894, 288);
		contentPanel.add(panel_proyecto);
		panel_proyecto.setLayout(null);

			
		panel_infoPersonal = new JPanel();
		panel_infoPersonal.setBorder(new TitledBorder(null, "Informacion personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		((javax.swing.border.TitledBorder) panel_infoPersonal.getBorder()).setTitleFont(new Font("Tahoma", Font.BOLD, 16));
		panel_infoPersonal.setBounds(12, 23, 525, 288);
		contentPanel.add(panel_infoPersonal);
		panel_infoPersonal.setLayout(null);
		
		lblFotoEmpresa = new JLabel("New label");
		lblFotoEmpresa.setBounds(537, 0, 362, 288);
		panel_infoPersonal.add(lblFotoEmpresa);
		
		lblId = new JLabel("Id cliente:");
		lblId.setBounds(12, 36, 70, 16);
		panel_infoPersonal.add(lblId);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(12, 98, 56, 16);
		panel_infoPersonal.add(lblNombre);
		
		lblDireccion = new JLabel("Direccion: ");
		lblDireccion.setBounds(12, 158, 72, 16);
		panel_infoPersonal.add(lblDireccion);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(80, 95, 243, 22);
		panel_infoPersonal.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(80, 155, 243, 22);
		panel_infoPersonal.add(txtDireccion);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(80, 33, 243, 22);
		panel_infoPersonal.add(txtId);
		
		panel_InfoEmpleado = new JPanel();
		panel_InfoEmpleado.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_InfoEmpleado.setBounds(15, 25, 233, 248);
		panel_proyecto.add(panel_InfoEmpleado);
		panel_InfoEmpleado.setLayout(null);
		
		panelFotoEmpleado = new JPanel();
		panelFotoEmpleado.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelFotoEmpleado.setBounds(0, 0, 233, 91);
		panel_InfoEmpleado.add(panelFotoEmpleado);
		panelFotoEmpleado.setLayout(new BorderLayout(0, 0));
		
		btnFotoEmpleado = new JButton("");
		btnFotoEmpleado.setEnabled(false);
		btnFotoEmpleado.setIcon(new ImageIcon(RegProyecto.class.getResource("/img/Nuevo Proyecto.png")));
		panelFotoEmpleado.add(btnFotoEmpleado, BorderLayout.CENTER);
		
		lblId_1 = new JLabel("Id: ");
		lblId_1.setBounds(10, 104, 29, 16);
		panel_InfoEmpleado.add(lblId_1);
		
		lblNombre_1 = new JLabel("Nombre: ");
		lblNombre_1.setBounds(10, 134, 56, 16);
		panel_InfoEmpleado.add(lblNombre_1);
		
		lblOcupacin = new JLabel("Ocupaci\u00F3n:");
		lblOcupacin.setBounds(10, 163, 74, 16);
		panel_InfoEmpleado.add(lblOcupacin);
		
		lblSalariohora = new JLabel("Salario/Hora:");
		lblSalariohora.setBounds(10, 192, 84, 16);
		panel_InfoEmpleado.add(lblSalariohora);
		
		lblCondicin = new JLabel("Condici\u00F3n: ");
		lblCondicin.setBounds(10, 219, 74, 16);
		panel_InfoEmpleado.add(lblCondicin);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(106, 192, 115, 16);
		panel_InfoEmpleado.add(lblNewLabel);
		
		lblOcupacionEmpleado = new JLabel("New label");
		lblOcupacionEmpleado.setBounds(106, 163, 115, 16);
		panel_InfoEmpleado.add(lblOcupacionEmpleado);
		
		lblNombreEmpleado = new JLabel("New label");
		lblNombreEmpleado.setBounds(106, 134, 115, 16);
		panel_InfoEmpleado.add(lblNombreEmpleado);
		
		lbl_IdEmpleado = new JLabel("New label");
		lbl_IdEmpleado.setBounds(106, 104, 115, 16);
		panel_InfoEmpleado.add(lbl_IdEmpleado);
		
		lblCondicion = new JLabel("New label");
		lblCondicion.setBounds(106, 219, 115, 16);
		panel_InfoEmpleado.add(lblCondicion);
		
		panelEquipo = new JPanel();
		panelEquipo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelEquipo.setBounds(260, 118, 412, 155);
		panel_proyecto.add(panelEquipo);
		panelEquipo.setLayout(null);
		
		
		lblJefeDeProyecto = new JLabel("Jefe de proyecto: ");
		lblJefeDeProyecto.setBounds(12, 13, 103, 16);
		panelEquipo.add(lblJefeDeProyecto);
		
		JTextField txtJefe = new JTextField();
		txtJefe.setBounds(127, 9, 111, 25);
		panelEquipo.add(txtJefe);
		
		JLabel lblPlanificador = new JLabel("Planificador: ");
		lblPlanificador.setBounds(12, 42, 91, 16);
		panelEquipo.add(lblPlanificador);
		
		txtPlanificador = new JTextField();
		txtPlanificador.setBounds(127, 38, 111, 25);
		panelEquipo.add(txtPlanificador);
		
		lblProgramador1 = new JLabel("Programador 1:");
		lblProgramador1.setBounds(12, 71, 91, 16);
		panelEquipo.add(lblProgramador1);
		
		txtProgramador1 = new JTextField();
		txtProgramador1.setBounds(127, 67, 111, 25);
		panelEquipo.add(txtProgramador1);
		
		lblProgramador2 = new JLabel("Programador 2:");
		lblProgramador2.setBounds(12, 100, 91, 16);
		panelEquipo.add(lblProgramador2);
		
		txtProgramador2 = new JTextField();
		txtProgramador2.setBounds(127, 96, 111, 25);
		panelEquipo.add(txtProgramador2);
		
		lblAuxiliar = new JLabel("Auxiliar:");
		lblAuxiliar.setBounds(12, 129, 91, 16);
		panelEquipo.add(lblAuxiliar);
		
		txtAuxiliar = new JTextField();
		txtAuxiliar.setBounds(127, 125, 111, 22);
		panelEquipo.add(txtAuxiliar);
		
		JButton btnCargarJefe = new JButton("Cargar");
		btnCargarJefe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarJefes();
			}
		});
		btnCargarJefe.setBounds(240, 9, 93, 25);
		panelEquipo.add(btnCargarJefe);
		
		btnCargarPlanif = new JButton("Cargar");
		btnCargarPlanif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPlanificadores();
			}
		});
		btnCargarPlanif.setBounds(240, 38, 93, 25);
		panelEquipo.add(btnCargarPlanif);
		
		btnCargarProgram1 = new JButton("Cargar");
		btnCargarProgram1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarProgramadores();
			}
		});
		btnCargarProgram1.setBounds(240, 67, 93, 25);
		panelEquipo.add(btnCargarProgram1);
		
		btnCargarProgram2 = new JButton("Cargar");
		btnCargarProgram2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarProgramadores();
			}
		});
		btnCargarProgram2.setBounds(240, 96, 93, 25);
		panelEquipo.add(btnCargarProgram2);
		
		cbxOcupacionAuxiliar = new JComboBox();
		cbxOcupacionAuxiliar.setModel(new DefaultComboBoxModel(new String[] {"<Ocupacion>", "Planificador", "Programador", "Dise\u00F1ador"}));
		cbxOcupacionAuxiliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbxOcupacionAuxiliar.getSelectedIndex() == 1) {
					cargarPlanificadores();
				}
				else if(cbxOcupacionAuxiliar.getSelectedIndex() == 2) {
					cargarProgramadores();
				}
				else if(cbxOcupacionAuxiliar.getSelectedIndex() == 3) {
					cargarDisegnadores();
				}
			}
		});
		cbxOcupacionAuxiliar.setBounds(240, 125, 103, 23);
		panelEquipo.add(cbxOcupacionAuxiliar);
		
		btnInfoJefe = new JButton("Info");
		btnInfoJefe.setBounds(346, 9, 58, 25);
		panelEquipo.add(btnInfoJefe);
		
		btnInfoPlanif = new JButton("Info");
		btnInfoPlanif.setBounds(346, 38, 58, 25);
		panelEquipo.add(btnInfoPlanif);
		
		btnInfoProgram1 = new JButton("Info");
		btnInfoProgram1.setBounds(346, 67, 58, 25);
		panelEquipo.add(btnInfoProgram1);
		
		btnProgram2 = new JButton("Info");
		btnProgram2.setBounds(346, 96, 58, 25);
		panelEquipo.add(btnProgram2);
		
		btnInfoAuxiliar = new JButton("Info");
		btnInfoAuxiliar.setBounds(346, 125, 58, 25);
		panelEquipo.add(btnInfoAuxiliar);
		
		/*lblBuscarPorId = new JLabel("Buscar por Id:");
		lblBuscarPorId.setBounds(391, 66, 139, 16);
		panel_proyecto.add(lblBuscarPorId);
		
		txtBuscarJefe = new JTextField();
		txtBuscarJefe.setBounds(391, 92, 116, 22);
		panel_proyecto.add(txtBuscarJefe);
		txtBuscarJefe.setColumns(10);
		
		txtBuscarPlanificador = new JTextField();
		txtBuscarPlanificador.setColumns(10);
		txtBuscarPlanificador.setBounds(391, 121, 116, 22);
		panel_proyecto.add(txtBuscarPlanificador);
		
		txtBuscarProgram1 = new JTextField();
		txtBuscarProgram1.setColumns(10);
		txtBuscarProgram1.setBounds(391, 150, 116, 22);
		panel_proyecto.add(txtBuscarProgram1);
		
		txtBuscarProgram2 = new JTextField();
		txtBuscarProgram2.setColumns(10);
		txtBuscarProgram2.setBounds(391, 179, 116, 22);
		panel_proyecto.add(txtBuscarProgram2);
		
		txtBuscarAuxiliar = new JTextField();
		txtBuscarAuxiliar.setColumns(10);
		txtBuscarAuxiliar.setBounds(391, 208, 116, 22);
		panel_proyecto.add(txtBuscarAuxiliar);
		
		idProyecto = new JLabel("id Proyecto: ");
		idProyecto.setBounds(12, 37, 116, 16);
		panel_proyecto.add(idProyecto);
		
		txtIdProyecto = new JTextField();
		txtIdProyecto.setEditable(false);
		txtIdProyecto.setColumns(10);
		txtIdProyecto.setBounds(127, 34, 197, 22);
		panel_proyecto.add(txtIdProyecto);*/
		
		lblNombreProyecto = new JLabel("Nombre Proyecto: ");
		lblNombreProyecto.setBounds(260, 25, 116, 16);
		panel_proyecto.add(lblNombreProyecto);
		
		txtNombreProyecto = new JTextField();
		txtNombreProyecto.setColumns(10);
		txtNombreProyecto.setBounds(372, 22, 197, 22);
		panel_proyecto.add(txtNombreProyecto);
		
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(260, 54, 72, 16);
		panel_proyecto.add(lblCategoria);
		
		cbxCategoria = new JComboBox();
		cbxCategoria.setBounds(372, 54, 197, 22);
		panel_proyecto.add(cbxCategoria);
		
		lblEquipoDeTrabajo = new JLabel("Equipo de trabajo");
		lblEquipoDeTrabajo.setBounds(260, 89, 121, 16);
		panel_proyecto.add(lblEquipoDeTrabajo);
		
		panel_contrato.setVisible(false);
		panel_infoPersonal.setVisible(false);
		panel_proyecto.setVisible(false);
		
		table = new JTable();
		model = new DefaultTableModel();
		
		model.setColumnIdentifiers(new String [] {"Id"});
		table.setModel(model);
		
		scrollListaEmpleados = new JScrollPane();
		scrollListaEmpleados.setBounds(706, 54, 176, 219);
		panel_proyecto.add(scrollListaEmpleados);
		scrollListaEmpleados.setViewportView(table);
		
		lblSeleccionarEmpleado = new JLabel("Seleccionar empleado:");
		lblSeleccionarEmpleado.setBounds(706, 25, 143, 16);
		panel_proyecto.add(lblSeleccionarEmpleado);
			
		{
			btnAnterior = new JButton("Anterior");
			btnAnterior.setEnabled(false);
			btnAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ventana > 0) {
						ventana--;
					}
					if(ventana == 0) {
						btnAnterior.setEnabled(false);
						btnSiguiente.setText("Siguiente");
						panel_infoPersonal.setVisible(true);
						panel_proyecto.setVisible(false);
						panel_contrato.setVisible(false);
					}
					if(ventana == 1) {
						btnAnterior.setEnabled(true);
						btnSiguiente.setText("Siguiente");
						panel_infoPersonal.setVisible(false);
						panel_proyecto.setVisible(true);
						panel_contrato.setVisible(false);
					}
					if(ventana == 2) {
						btnAnterior.setEnabled(true);
						btnSiguiente.setText("Terminar");
						panel_infoPersonal.setVisible(false);
						panel_proyecto.setVisible(false);
						panel_contrato.setVisible(true);
					}
				}
			});
			buttonPane.add(btnAnterior);
		}
			
		{
			btnSiguiente = new JButton("Siguiente");
			btnSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ventana < 2) {
						ventana++;
					}
					if(ventana == 0) {
						btnAnterior.setEnabled(false);
						btnSiguiente.setText("Siguiente");
						panel_infoPersonal.setVisible(true);
						panel_proyecto.setVisible(false);
						panel_contrato.setVisible(false);
					}
					if(ventana == 1) {
						btnAnterior.setEnabled(true);
						btnSiguiente.setText("Siguiente");
						panel_infoPersonal.setVisible(false);
						panel_proyecto.setVisible(true);
						panel_contrato.setVisible(false);
					}
					if(ventana == 2){
						btnAnterior.setEnabled(true);
						btnSiguiente.setText("Terminar");
						panel_infoPersonal.setVisible(false);
						panel_proyecto.setVisible(false);
						panel_contrato.setVisible(true);
					}
				}
			});
			btnSiguiente.setActionCommand("OK");
			buttonPane.add(btnSiguiente);
			getRootPane().setDefaultButton(btnSiguiente);
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
	
	private void cargarJefes() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(int i = 0; i < Empresa.getInstance().getEmpleados().size(); i++) {
			if(Empresa.getInstance().getEmpleados().get(i) instanceof Jefe)
			{
				fila[0] = Empresa.getInstance().getEmpleados().get(i).getId();
				
			}
			model.addRow(fila);
		}
		
		table.getColumnModel().getColumn(0).setMinWidth(100);
	}
	
	private void cargarPlanificadores() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(int i = 0; i < Empresa.getInstance().getEmpleados().size(); i++) {
			if(Empresa.getInstance().getEmpleados().get(i) instanceof Planificador)
			{
				fila[0] = Empresa.getInstance().getEmpleados().get(i).getId();
				
			}
			model.addRow(fila);
		}
		
		table.getColumnModel().getColumn(0).setMinWidth(100);
		
	}
	
	private void cargarProgramadores() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(int i = 0; i < Empresa.getInstance().getEmpleados().size(); i++) {
			if(Empresa.getInstance().getEmpleados().get(i) instanceof Programador)
			{
				fila[0] = Empresa.getInstance().getEmpleados().get(i).getId();
				
			}
			model.addRow(fila);
		}
		
		table.getColumnModel().getColumn(0).setMinWidth(100);
		
	}
	
	private void cargarDisegnadores() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for(int i = 0; i < Empresa.getInstance().getEmpleados().size(); i++) {
			if(Empresa.getInstance().getEmpleados().get(i) instanceof Disegnador)
			{
				fila[0] = Empresa.getInstance().getEmpleados().get(i).getId();
				
			}
			model.addRow(fila);
		}
		
		table.getColumnModel().getColumn(0).setMinWidth(100);
		
	}
}
