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
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import org.omg.CosNaming.NamingContextExtPackage.URLStringHelper;

import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;


@SuppressWarnings("serial")
public class RegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtCedula;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtTelefono2;
	private JTextField txtCorreo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public RegCliente() {
		setType(Type.UTILITY);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setBackground(Color.BLACK);
		
		
		setTitle("Registro de cliente");
		setBounds(100, 100, 444, 334);
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
		panel.setBounds(0, 0, 428, 264);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 47, 59, 14);
		lblNombre.setBackground(new Color(0, 0, 0));
		lblNombre.setForeground(new Color(0, 0, 0));
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(79, 44, 180, 20);
		txtNombre.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(314, 166, 73, 14);
		lblDireccion.setForeground(new Color(0, 0, 0));
		panel.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(271, 192, 145, 56);
		txtDireccion.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(12, 19, 55, 16);
		panel.add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(79, 17, 180, 20);
		panel.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 82, 55, 16);
		panel.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(79, 76, 180, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(20, 110, 45, 16);
		panel.add(lblSexo);
		
		JRadioButton rdbtnHombre = new JRadioButton("Hombre");
		buttonGroup.add(rdbtnHombre);
		rdbtnHombre.setBounds(79, 104, 88, 24);
		panel.add(rdbtnHombre);
		
		JRadioButton rdbtnMujer = new JRadioButton("Mujer");
		buttonGroup.add(rdbtnMujer);
		rdbtnMujer.setBounds(173, 104, 88, 24);
		panel.add(rdbtnMujer);
		
		JLabel lblTelefono = new JLabel("Telefono 1:");
		lblTelefono.setBounds(10, 141, 75, 16);
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(79, 139, 180, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblTelefono_1 = new JLabel("Telefono 2:");
		lblTelefono_1.setBounds(10, 165, 75, 16);
		panel.add(lblTelefono_1);
		
		txtTelefono2 = new JTextField();
		txtTelefono2.setBounds(79, 163, 180, 20);
		panel.add(txtTelefono2);
		txtTelefono2.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(30, 193, 55, 16);
		panel.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(79, 191, 180, 20);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(271, 11, 145, 143);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setEnabled(false);
		label.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(RegCliente.class.getResource("/img/Cliente/Cliente 1 124pix.png")));
		label.setBounds(0, 0, 145, 142);
		panel_1.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			buttonPane.setBounds(0, 263, 428, 32);
			contentPanel.add(buttonPane);
			buttonPane.setBackground(Color.LIGHT_GRAY);
			{
				buttonPane.setLayout(null);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBorder(new LineBorder(new Color(112, 128, 144)));
				cancelButton.setBounds(353, 5, 63, 26);
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
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String genero  = null;
					if(rdbtnHombre.isSelected())
					{
						genero = "Hombre";
						
					}
					if(rdbtnMujer.isSelected())
					{
						genero = "Mujer";
					}
					Cliente cliente = new Cliente(txtCedula.getText(),txtNombre.getText(),txtCorreo.getText(),txtTelefono.getText(),txtTelefono2.getText(),
							txtDireccion.getText(),genero);
					Empresa.getInstance().nuevoCliente(cliente);
					dispose();
				}
			});
			btnAceptar.setBorder(new LineBorder(new Color(112, 128, 144)));
			btnAceptar.setBounds(269, 5, 72, 26);
	/*		btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					boolean repetido = false;
					boolean encontrado = false;
					int i = 0 ;
					
					/*if(txtId.getText().equalsIgnoreCase("") || txtDireccion.getText().equalsIgnoreCase("")
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
						
							Cliente cliente = new Cliente(txtId.getText(),txtNombre.getText(),txtDireccion.getText(), "1234");
							Empresa.getInstance().nuevoCliente(cliente);
							dispose();
						}
					}
				}
			});*/
			btnAceptar.setForeground(new Color(0, 0, 0));
			btnAceptar.setBackground(new Color(245, 245, 245));
			
			btnAceptar.setActionCommand("btnAceptar");
			buttonPane.add(btnAceptar);
			getRootPane().setDefaultButton(btnAceptar);
		}
	}
}
