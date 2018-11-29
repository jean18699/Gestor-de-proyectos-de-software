package Visual;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Cliente;
import Logico.Empresa;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;


@SuppressWarnings("serial")
public class RegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtId;
	
	public RegCliente() {
		setType(Type.UTILITY);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setBackground(Color.BLACK);
		
		
		setTitle("Registro de cliente");
		setBounds(100, 100, 493, 221);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(220, 220, 220));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.GREEN);
		panel.setBackground(new Color(245, 245, 245));
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(12, 11, 281, 126);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBackground(new Color(0, 0, 0));
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setBounds(10, 47, 59, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtNombre.setBounds(79, 44, 180, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setForeground(new Color(0, 0, 0));
		lblDireccion.setBounds(10, 79, 59, 14);
		panel.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtDireccion.setBounds(79, 76, 180, 20);
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(295, 11, 171, 126);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblIdPersonal = new JLabel("ID Personal");
		lblIdPersonal.setForeground(new Color(0, 0, 0));
		lblIdPersonal.setBackground(new Color(255, 255, 255));
		lblIdPersonal.setBounds(51, 28, 83, 16);
		panel_1.add(lblIdPersonal);
		
		txtId = new JTextField();
		txtId.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		txtId.setBounds(12, 56, 146, 20);
		panel_1.add(txtId);
		txtId.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			buttonPane.setBounds(0, 149, 510, 31);
			contentPanel.add(buttonPane);
			buttonPane.setBackground(new Color(112, 128, 144));
			{
				buttonPane.setLayout(null);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBorder(new LineBorder(new Color(112, 128, 144)));
				cancelButton.setBounds(402, 5, 63, 26);
				cancelButton.setFont(new Font("Arial", Font.BOLD, 12));
				cancelButton.setForeground(new Color(0, 0, 0));
				cancelButton.setBackground(new Color(245, 245, 245));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("btnCancelar");
				buttonPane.add(cancelButton);
			}
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.setBorder(new LineBorder(new Color(112, 128, 144)));
			btnAceptar.setBounds(323, 5, 72, 26);
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					boolean repetido = false;
					boolean encontrado = false;
					int i = 0 ;
					
					if(txtId.getText().equalsIgnoreCase("") || txtDireccion.getText().equalsIgnoreCase("")
							|| txtId.getText().equalsIgnoreCase(""))
					{

						JOptionPane.showMessageDialog(null, "Complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
					}else
					{
						while(i < Empresa.getInstance().getClientes().size() && !encontrado)
						{
							if(Empresa.getInstance().getClientes().get(i).getId().equalsIgnoreCase(txtId.getText()))
							{
								repetido = true;
								encontrado = true;
							}
							i++;	
						}
					
						if(repetido == true)
						{
							JOptionPane.showMessageDialog(null, "Este usuario ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
							
						}else
						{
						
							Cliente cliente = new Cliente(txtId.getText(),txtNombre.getText(),txtDireccion.getText());
							Empresa.getInstance().nuevoCliente(cliente);
							dispose();
						}
					}
				}
			});
			btnAceptar.setForeground(new Color(0, 0, 0));
			btnAceptar.setBackground(new Color(245, 245, 245));
			
			btnAceptar.setActionCommand("btnAceptar");
			buttonPane.add(btnAceptar);
			getRootPane().setDefaultButton(btnAceptar);
		}
	}
}
