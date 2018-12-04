package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import Logico.Cliente;
import Logico.Contrato;
import Logico.Empleado;
import Logico.Empresa;
import Logico.Proyecto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegContrato extends JDialog {
	private JTextField txtIdContrato;
	private JTextField txtIdProyecto;
	private JTextField txtNombreProyecto;
	private JTextField txtIdCliente;
	private JTextField txtNombreCliente;
	private String patron = "dd/MM/yyyy";
	private JSpinner spnFecha;
	private JTextField txtPrecioContrato;
	private Date fechaEntrega;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ArrayList<Empleado> grupoTrabajo = null;
		//	Cliente cliente = new Cliente();
		//	Proyecto proyecto = new Proyecto("jean", "nombre", grupoTrabajo, "Web");
			RegContrato dialog = new RegContrato(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegContrato(Proyecto proyecto, Cliente cliente) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Contrato contrato = new Contrato(proyecto,fechaEntrega);
		
		setBounds(100, 100, 677, 345);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel.setBounds(0, 0, 661, 270);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			//JSpinner spnFecha = new JSpinner((SpinnerModel) null);
			Date date = new Date();
			SpinnerDateModel sdm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel_1.setBackground(Color.WHITE);
				panel_1.setBounds(0, 0, 219, 270);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
					panel_2.setBounds(0, 201, 219, 69);
					panel_1.add(panel_2);
					panel_2.setLayout(null);
					{
						JLabel lblFechaDeEntrega = new JLabel("Fecha de entrega");
						lblFechaDeEntrega.setBounds(10, 11, 98, 14);
						panel_2.add(lblFechaDeEntrega);
						lblFechaDeEntrega.setFont(new Font("Tahoma", Font.BOLD, 11));
					}
					spnFecha = new JSpinner(sdm);
					spnFecha.setBounds(121, 7, 88, 22);	
					panel_2.add(spnFecha);
					JSpinner.DateEditor DateEdit = new JSpinner.DateEditor(spnFecha, patron);
					DateEdit.getTextField().setEditable(true);
					
					spnFecha.setEditor(DateEdit);
					
					
					JButton btnAceptarFecha = new JButton("Aceptar y obtener precio");
					btnAceptarFecha.setBounds(20, 36, 171, 23);
					btnAceptarFecha.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							fechaEntrega = (Date) spnFecha.getValue();
							Contrato contrato = new Contrato(proyecto,fechaEntrega);
							txtPrecioContrato.setText(Float.toString(contrato.getPrecioFinal()));
						}
					});
					panel_2.add(btnAceptarFecha);
					
					JPanel panel_3 = new JPanel();
					panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_3.setBounds(0, 0, 219, 58);
					panel_1.add(panel_3);
					{
						JLabel lblIdentificadorDelContrato = new JLabel("Identificador del contrato");
						panel_3.add(lblIdentificadorDelContrato);
						lblIdentificadorDelContrato.setFont(new Font("Tahoma", Font.BOLD, 11));
					}
					{
						txtIdContrato = new JTextField(contrato.getId());
						panel_3.add(txtIdContrato);
						txtIdContrato.setEnabled(false);
						txtIdContrato.setColumns(10);
					}
					//fechaEntrega = new Date(spnFecha.getValue().toString());
					
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
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_2.setBounds(221, 228, 440, 42);
					panel.add(panel_2);
					panel_2.setLayout(null);
					{
						JLabel lblPrecioDelContrato = new JLabel("Precio del contrato:");
						lblPrecioDelContrato.setBounds(10, 11, 99, 16);
						panel_2.add(lblPrecioDelContrato);
					}
					{
					//	Date date = new Date(spnFecha.)
					//	Contrato con = new Contrato(proyecto,spnFecha.get)
						txtPrecioContrato = new JTextField();
						txtPrecioContrato.setBounds(119, 8, 137, 22);
						panel_2.add(txtPrecioContrato);
						txtPrecioContrato.setEditable(false);
						txtPrecioContrato.setColumns(10);
						//txtPrecioContrato.setText(proyecto.getS);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_2.setBounds(176, 0, 485, 228);
					panel.add(panel_2);
					panel_2.setLayout(null);
					{
						JPanel panel_3 = new JPanel();
						panel_3.setBorder(new TitledBorder(null, "Datos preliminares del proyecto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						panel_3.setBounds(44, 11, 437, 106);
						panel_2.add(panel_3);
						panel_3.setLayout(null);
						{
							JLabel lblIdentificadorDelProyecto = new JLabel("Identificador del proyecto:");
							lblIdentificadorDelProyecto.setBounds(10, 40, 168, 14);
							panel_3.add(lblIdentificadorDelProyecto);
							lblIdentificadorDelProyecto.setFont(new Font("Tahoma", Font.BOLD, 12));
						}
						{
							JLabel lblNombreProyecto = new JLabel("Nombre del proyecto:");
							lblNombreProyecto.setBounds(38, 67, 140, 14);
							panel_3.add(lblNombreProyecto);
							lblNombreProyecto.setFont(new Font("Tahoma", Font.BOLD, 12));
						}
						{
							txtIdProyecto = new JTextField();
							txtIdProyecto.setBounds(188, 38, 124, 20);
							panel_3.add(txtIdProyecto);
							txtIdProyecto.setEnabled(false);
							txtIdProyecto.setColumns(10);
							txtIdProyecto.setText(proyecto.getId());
						}
						{
							txtNombreProyecto = new JTextField();
							txtNombreProyecto.setBounds(188, 65, 124, 20);
							panel_3.add(txtNombreProyecto);
							txtNombreProyecto.setEnabled(false);
							txtNombreProyecto.setColumns(10);
							txtNombreProyecto.setText(proyecto.getNombre());
						}
						{
							JButton btnVerEquipo = new JButton("Ver equipo");
							btnVerEquipo.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									InfoEquipo info = new InfoEquipo(proyecto.getGrupoTrabajo());
									info.setLocationRelativeTo(null);
									info.setModal(true);
									info.setVisible(true);
								}
							});
							btnVerEquipo.setBounds(317, 64, 110, 23);
							panel_3.add(btnVerEquipo);
						}
					}
					{
						JPanel panel_3 = new JPanel();
						panel_3.setBorder(new TitledBorder(null, "Datos preliminares del cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						panel_3.setBounds(44, 118, 437, 110);
						panel_2.add(panel_3);
						panel_3.setLayout(null);
						{
							JLabel lblNombreDelCliente = new JLabel("Nombre del cliente:");
							lblNombreDelCliente.setBounds(58, 63, 124, 14);
							panel_3.add(lblNombreDelCliente);
							lblNombreDelCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
						}
						{
							txtNombreCliente = new JTextField();
							txtNombreCliente.setBounds(192, 61, 124, 20);
							panel_3.add(txtNombreCliente);
							txtNombreCliente.setEnabled(false);
							txtNombreCliente.setColumns(10);
							txtNombreCliente.setText(cliente.getNombre());
						}
						{
							JLabel lblIdentificadorDelCliente = new JLabel("Identificador del cliente:");
							lblIdentificadorDelCliente.setBounds(31, 38, 157, 14);
							panel_3.add(lblIdentificadorDelCliente);
							lblIdentificadorDelCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
						}
						{
							txtIdCliente = new JTextField();
							txtIdCliente.setBounds(192, 37, 124, 18);
							panel_3.add(txtIdCliente);
							txtIdCliente.setEnabled(false);
							txtIdCliente.setColumns(10);
							txtIdCliente.setText(cliente.getId());
						}
						{
							JButton btnNewButton_2 = new JButton("Informacion");
							btnNewButton_2.setBounds(326, 60, 101, 23);
							panel_3.add(btnNewButton_2);
						}
					}
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel.setBounds(0, 0, 661, 309);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBounds(0, 271, 661, 37);
				panel.add(buttonPane);
				buttonPane.setBackground(Color.LIGHT_GRAY);
				buttonPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				{
					JButton btnAceptar = new JButton("Realizar contrato");
					btnAceptar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							contrato.setFechaEntrega(fechaEntrega);
							proyecto.setContrato(contrato);
							proyecto.getContrato().setCliente(cliente);
							Empresa.getInstance().agregarProyecto(proyecto);
							//Empresa.getInstance().nuevoContrato(cliente.getId(), contrato);
							proyecto.setRealizado(true);
							dispose();
							
						}
					});
					btnAceptar.setActionCommand("OK");
					buttonPane.add(btnAceptar);
					getRootPane().setDefaultButton(btnAceptar);
				}
				{
					JButton btnCancelar = new JButton("Cancelar");
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
	}
}
