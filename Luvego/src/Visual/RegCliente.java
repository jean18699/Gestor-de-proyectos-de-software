package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

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
		setBounds(100, 100, 607, 368);
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
		panel_contrato.setVisible(false);
		panel_contrato.setBorder(new TitledBorder(null, "Informacion contrato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		((javax.swing.border.TitledBorder) panel_contrato.getBorder()).setTitleFont(new Font("Tahoma", Font.BOLD, 16));
		panel_contrato.setBounds(12, 23, 580, 262);
		contentPanel.add(panel_contrato);
		panel_contrato.setLayout(null);
		
		lbl_IdContrato = new JLabel("Id contrato: ");
		lbl_IdContrato.setBounds(12, 37, 116, 16);
		panel_contrato.add(lbl_IdContrato);
		
		txtIdContrato = new JTextField();
		txtIdContrato.setEditable(false);
		txtIdContrato.setBounds(127, 34, 197, 22);
		panel_contrato.add(txtIdContrato);
		txtIdContrato.setColumns(10);
		
		lblNombreProyecto = new JLabel("Nombre proyecto: ");
		lblNombreProyecto.setBounds(12, 66, 116, 16);
		panel_contrato.add(lblNombreProyecto);
		
		txtNombreProyecto = new JTextField();
		txtNombreProyecto.setEditable(false);
		txtNombreProyecto.setBounds(127, 66, 197, 22);
		panel_contrato.add(txtNombreProyecto);
		txtNombreProyecto.setColumns(10);
		
		lblFechaEntrega = new JLabel("Fecha entrega:");
		lblFechaEntrega.setBounds(12, 95, 116, 16);
		panel_contrato.add(lblFechaEntrega);
		
		Date date = new Date();
		SpinnerDateModel sdm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
		spnFecha = new JSpinner(sdm);
		spnFecha.setBounds(127, 92, 197, 22);
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
		lblPrecioContrato.setBounds(12, 124, 116, 16);
		panel_contrato.add(lblPrecioContrato);
		
		txtPrecioContrato = new JTextField();
		txtPrecioContrato.setColumns(10);
		txtPrecioContrato.setBounds(127, 121, 197, 22);
		panel_contrato.add(txtPrecioContrato);
		
		panel_proyecto = new JPanel();
		panel_proyecto.setVisible(false);
		panel_proyecto.setBorder(new TitledBorder(null, "Informacion proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		((javax.swing.border.TitledBorder) panel_proyecto.getBorder()).setTitleFont(new Font("Tahoma", Font.BOLD, 16));
		panel_proyecto.setBounds(12, 23, 580, 262);
		contentPanel.add(panel_proyecto);
		panel_proyecto.setLayout(null);

			
		panel_infoPersonal = new JPanel();
		panel_infoPersonal.setBorder(new TitledBorder(null, "Informacion personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		((javax.swing.border.TitledBorder) panel_infoPersonal.getBorder()).setTitleFont(new Font("Tahoma", Font.BOLD, 16));
		panel_infoPersonal.setBounds(12, 23, 580, 262);
		contentPanel.add(panel_infoPersonal);
		panel_infoPersonal.setLayout(null);
		
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
		
		lblJefeDeProyecto = new JLabel("Jefe de proyecto: ");
		lblJefeDeProyecto.setBounds(12, 95, 116, 16);
		panel_proyecto.add(lblJefeDeProyecto);
		
		JComboBox cbxJefes = new JComboBox();
		cbxJefes.setBounds(127, 92, 197, 22);
		panel_proyecto.add(cbxJefes);
		
		JLabel lblPlanificador = new JLabel("Planificador: ");
		lblPlanificador.setBounds(12, 124, 91, 16);
		panel_proyecto.add(lblPlanificador);
		
		cbxPlanificadores = new JComboBox();
		cbxPlanificadores.setBounds(127, 121, 197, 22);
		panel_proyecto.add(cbxPlanificadores);
		
		lblProgramador1 = new JLabel("Programador 1:");
		lblProgramador1.setBounds(12, 153, 91, 16);
		panel_proyecto.add(lblProgramador1);
		
		cbxProgram1 = new JComboBox();
		cbxProgram1.setBounds(127, 150, 197, 22);
		panel_proyecto.add(cbxProgram1);
		
		lblProgramador2 = new JLabel("Programador 2:");
		lblProgramador2.setBounds(12, 182, 91, 16);
		panel_proyecto.add(lblProgramador2);
		
		cbxProgram2 = new JComboBox();
		cbxProgram2.setBounds(127, 179, 197, 22);
		panel_proyecto.add(cbxProgram2);
		
		lblAuxiliar = new JLabel("Auxiliar:");
		lblAuxiliar.setBounds(12, 211, 91, 16);
		panel_proyecto.add(lblAuxiliar);
		
		cbxAuxiliar = new JComboBox();
		cbxAuxiliar.setBounds(127, 208, 197, 22);
		panel_proyecto.add(cbxAuxiliar);
		
		lblBuscarPorId = new JLabel("Buscar por Id:");
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
		panel_proyecto.add(txtIdProyecto);
		
		lblNombreProyecto = new JLabel("Nombre Proyecto: ");
		lblNombreProyecto.setBounds(12, 66, 116, 16);
		panel_proyecto.add(lblNombreProyecto);
		
		txtNombreProyecto = new JTextField();
		txtNombreProyecto.setColumns(10);
		txtNombreProyecto.setBounds(127, 63, 197, 22);
		panel_proyecto.add(txtNombreProyecto);
		
			
		{
			btnAnterior = new JButton("Anterior");
			btnAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ventana > 0) {
						ventana--;
					}
					if(ventana == 0) {
						panel_infoPersonal.setVisible(true);
						panel_proyecto.setVisible(false);
						panel_contrato.setVisible(false);
					}
					if(ventana == 1) {
						panel_infoPersonal.setVisible(false);
						panel_proyecto.setVisible(true);
						panel_contrato.setVisible(false);
					}
					if(ventana == 2) {
						panel_infoPersonal.setVisible(false);
						panel_proyecto.setVisible(false);
						panel_contrato.setVisible(true);
					}
					System.out.println(ventana);
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
						panel_infoPersonal.setVisible(true);
						panel_proyecto.setVisible(false);
						panel_contrato.setVisible(false);
					}
					if(ventana == 1) {
						panel_infoPersonal.setVisible(false);
						panel_proyecto.setVisible(true);
						panel_contrato.setVisible(false);
					}
					if(ventana == 2){
						panel_infoPersonal.setVisible(false);
						panel_proyecto.setVisible(false);
						panel_contrato.setVisible(true);
					}
					System.out.println(ventana);
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
}
