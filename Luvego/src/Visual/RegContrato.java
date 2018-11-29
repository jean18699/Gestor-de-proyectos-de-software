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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class RegContrato extends JDialog {
	private JTextField textField;
	private JTextField txtIdProyecto;
	private JTextField txtNombreProyecto;
	private JTextField txtIdCliente;
	private JTextField txtNombreCliente;
	private String patron = "dd/MM/yyyy";
	private JSpinner spnFecha;
	private JTextField textField_5;
	private JTextField textField_6;
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
		setBounds(100, 100, 344, 368);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			buttonPane.setBounds(0, 296, 328, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
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
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel.setBounds(10, 11, 306, 287);
			getContentPane().add(panel);
			panel.setLayout(null);
			{
				JLabel lblIdentificadorDelContrato = new JLabel("Identificador del contrato:");
				lblIdentificadorDelContrato.setBounds(10, 11, 144, 14);
				panel.add(lblIdentificadorDelContrato);
			}
			{
				textField = new JTextField();
				textField.setEnabled(false);
				textField.setBounds(147, 8, 140, 20);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				JLabel lblIdentificadorDelProyecto = new JLabel("Identificador del proyecto");
				lblIdentificadorDelProyecto.setBounds(10, 50, 133, 14);
				panel.add(lblIdentificadorDelProyecto);
			}
			{
				txtIdProyecto = new JTextField();
				txtIdProyecto.setEnabled(false);
				txtIdProyecto.setBounds(10, 71, 124, 20);
				panel.add(txtIdProyecto);
				txtIdProyecto.setColumns(10);
			}
			{
				JLabel lblNombreProyecto = new JLabel("Nombre del proyecto");
				lblNombreProyecto.setBounds(163, 50, 124, 14);
				panel.add(lblNombreProyecto);
			}
			{
				txtNombreProyecto = new JTextField();
				txtNombreProyecto.setEnabled(false);
				txtNombreProyecto.setBounds(163, 71, 124, 20);
				panel.add(txtNombreProyecto);
				txtNombreProyecto.setColumns(10);
			}
			{
				JLabel lblIdentificadorDelCliente = new JLabel("Identificador del cliente");
				lblIdentificadorDelCliente.setBounds(10, 102, 124, 14);
				panel.add(lblIdentificadorDelCliente);
			}
			{
				txtIdCliente = new JTextField();
				txtIdCliente.setEnabled(false);
				txtIdCliente.setBounds(10, 127, 124, 20);
				panel.add(txtIdCliente);
				txtIdCliente.setColumns(10);
			}
			{
				JLabel lblNombreDelCliente = new JLabel("Nombre del cliente");
				lblNombreDelCliente.setBounds(163, 102, 110, 14);
				panel.add(lblNombreDelCliente);
			}
			{
				txtNombreCliente = new JTextField();
				txtNombreCliente.setEnabled(false);
				txtNombreCliente.setBounds(163, 127, 124, 20);
				panel.add(txtNombreCliente);
				txtNombreCliente.setColumns(10);
			}
			{
				JLabel lblFechaDeEntrega = new JLabel("Fecha de entrega");
				lblFechaDeEntrega.setBounds(10, 161, 85, 14);
				panel.add(lblFechaDeEntrega);
			}
			
			//JSpinner spnFecha = new JSpinner((SpinnerModel) null);
			Date date = new Date();
			SpinnerDateModel sdm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
			spnFecha = new JSpinner(sdm);
			spnFecha.setBounds(18, 227, 126, 22);
			JSpinner.DateEditor DateEdit = new JSpinner.DateEditor(spnFecha, patron);
			DateEdit.getTextField().setEditable(true);
			spnFecha.setEditor(DateEdit);
			panel.add(spnFecha);
			
			
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

			
			spnFecha.setBounds(10, 186, 126, 22);
			panel.add(spnFecha);
			{
				textField_6 = new JTextField();
				textField_6.setBounds(163, 246, 124, 22);
				panel.add(textField_6);
				textField_6.setEditable(false);
				textField_6.setColumns(10);
			}
			{
				JLabel label = new JLabel("Precio final:");
				label.setBounds(163, 219, 62, 16);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Precio contrato:");
				label.setBounds(163, 160, 84, 16);
				panel.add(label);
			}
			{
				textField_5 = new JTextField();
				textField_5.setBounds(163, 186, 124, 22);
				panel.add(textField_5);
				textField_5.setEditable(false);
				textField_5.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel.setBounds(0, 11, 313, 298);
			getContentPane().add(panel);
		}
	}
}
