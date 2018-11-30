package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import Logico.Cliente;
import Logico.Proyecto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;

public class RegContrato extends JDialog {
	private JTextField textField;
	private JTextField txtIdProyecto;
	private JTextField txtNombreProyecto;
	private JTextField txtIdCliente;
	private JTextField txtNombreCliente;
	private String patron = "dd/MM/yyyy";
	private JSpinner spnFecha;
	private JTextField txtPrecioContrato;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
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
		setBounds(100, 100, 519, 346);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel.setBounds(0, 0, 557, 270);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JLabel lblIdentificadorDelProyecto = new JLabel("Identificador del proyecto:");
				lblIdentificadorDelProyecto.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblIdentificadorDelProyecto.setBounds(189, 42, 168, 14);
				panel.add(lblIdentificadorDelProyecto);
			}
			{
				txtIdProyecto = new JTextField();
				txtIdProyecto.setBounds(367, 40, 124, 20);
				txtIdProyecto.setEnabled(false);
				panel.add(txtIdProyecto);
				txtIdProyecto.setColumns(10);
				txtIdProyecto.setText(proyecto.getId());
			}
			{
				JLabel lblNombreProyecto = new JLabel("Nombre del proyecto:");
				lblNombreProyecto.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNombreProyecto.setBounds(217, 67, 140, 14);
				panel.add(lblNombreProyecto);
			}
			{
				txtNombreProyecto = new JTextField();
				txtNombreProyecto.setBounds(367, 65, 124, 20);
				txtNombreProyecto.setEnabled(false);
				panel.add(txtNombreProyecto);
				txtNombreProyecto.setColumns(10);
				txtNombreProyecto.setText(proyecto.getNombre());
			}
			{
				JLabel lblIdentificadorDelCliente = new JLabel("Identificador del cliente:");
				lblIdentificadorDelCliente.setBounds(207, 129, 157, 14);
				lblIdentificadorDelCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
				panel.add(lblIdentificadorDelCliente);
			}
			{
				txtIdCliente = new JTextField();
				txtIdCliente.setBounds(367, 128, 124, 18);
				txtIdCliente.setEnabled(false);
				panel.add(txtIdCliente);
				txtIdCliente.setColumns(10);
				txtIdCliente.setText(cliente.getId());
			}
			{
				JLabel lblNombreDelCliente = new JLabel("Nombre del cliente:");
				lblNombreDelCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNombreDelCliente.setBounds(233, 154, 124, 14);
				panel.add(lblNombreDelCliente);
			}
			{
				txtNombreCliente = new JTextField();
				txtNombreCliente.setBounds(367, 152, 124, 20);
				txtNombreCliente.setEnabled(false);
				panel.add(txtNombreCliente);
				txtNombreCliente.setColumns(10);
				txtNombreCliente.setText(cliente.getNombre());
			}
			
			//JSpinner spnFecha = new JSpinner((SpinnerModel) null);
			Date date = new Date();
			SpinnerDateModel sdm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel_1.setBackground(Color.WHITE);
				panel_1.setBounds(0, 0, 177, 270);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					textField = new JTextField();
					textField.setBounds(10, 30, 157, 20);
					panel_1.add(textField);
					textField.setEnabled(false);
					textField.setColumns(10);
				}
				{
					JLabel lblIdentificadorDelContrato = new JLabel("Identificador del contrato");
					lblIdentificadorDelContrato.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblIdentificadorDelContrato.setBounds(10, 11, 157, 14);
					panel_1.add(lblIdentificadorDelContrato);
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
					panel_2.setBounds(0, 201, 177, 69);
					panel_1.add(panel_2);
					panel_2.setLayout(null);
					{
						JLabel lblFechaDeEntrega = new JLabel("Fecha de entrega");
						lblFechaDeEntrega.setBounds(44, 11, 98, 14);
						panel_2.add(lblFechaDeEntrega);
						lblFechaDeEntrega.setFont(new Font("Tahoma", Font.BOLD, 11));
					}
					spnFecha = new JSpinner(sdm);
					spnFecha.setBounds(32, 34, 121, 22);
					panel_2.add(spnFecha);
					JSpinner.DateEditor DateEdit = new JSpinner.DateEditor(spnFecha, patron);
					DateEdit.getTextField().setEditable(true);
					spnFecha.setEditor(DateEdit);
					
					
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
					panel_2.setBounds(176, 228, 328, 42);
					panel.add(panel_2);
					panel_2.setLayout(null);
					{
						JLabel lblPrecioDelContrato = new JLabel("Precio del contrato:");
						lblPrecioDelContrato.setBounds(10, 11, 99, 16);
						panel_2.add(lblPrecioDelContrato);
					}
					{
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
					panel_2.setBounds(176, 0, 328, 228);
					panel.add(panel_2);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel.setBounds(0, 0, 608, 309);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBounds(0, 272, 503, 37);
				panel.add(buttonPane);
				buttonPane.setBackground(Color.LIGHT_GRAY);
				buttonPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				{
					JButton btnAceptar = new JButton("Realizar contrato");
					btnAceptar.setActionCommand("OK");
					buttonPane.add(btnAceptar);
					getRootPane().setDefaultButton(btnAceptar);
				}
				{
					JButton btnCancelar = new JButton("Cancelar");
					btnCancelar.setActionCommand("Cancel");
					buttonPane.add(btnCancelar);
				}
			}
		}
	}
}
