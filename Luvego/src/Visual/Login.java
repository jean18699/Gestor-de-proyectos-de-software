package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Cliente;
import Logico.Empresa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtContrasena;

	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream empresa_In;
				FileOutputStream empresa_Out;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				try {
					empresa_In = new FileInputStream ("empresa.dat");
					empresaRead = new ObjectInputStream(empresa_In);
					Empresa temp = (Empresa)empresaRead.readObject();
					Empresa.setEmpresa(temp);
				} catch (FileNotFoundException e) {
					try {
						empresa_Out = new  FileOutputStream("empresa.dat");
						empresaWrite = new ObjectOutputStream(empresa_Out);
						Cliente aux = new Cliente("0000", "Admin", "NULL", "0000");
						Empresa.getInstance().nuevoCliente(aux);
						empresaWrite.writeObject(Empresa.getInstance());
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream empresa_In;
				FileOutputStream empresa_Out;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				try {
					empresa_In = new FileInputStream ("empresa.dat");
					empresaRead = new ObjectInputStream(empresa_In);
					Empresa temp = (Empresa)empresaRead.readObject();
					Empresa.setEmpresa(temp);
				} catch (FileNotFoundException e) {
					try {
						empresa_Out = new  FileOutputStream("empresa.dat");
						empresaWrite = new ObjectOutputStream(empresa_Out);
						Cliente aux = new Cliente("0000", "Admin", "NULL", "0000");
						Empresa.getInstance().nuevoCliente(aux);
						empresaWrite.writeObject(Empresa.getInstance());
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl_Id = new JLabel("Id: ");
			lbl_Id.setBounds(26, 46, 56, 16);
			contentPanel.add(lbl_Id);
		}
		{
			txtId = new JTextField();
			txtId.setText("");
			txtId.setBounds(26, 75, 116, 22);
			contentPanel.add(txtId);
			txtId.setColumns(10);
		}
		{
			JLabel lblContrasena = new JLabel("Contrase\u00F1a");
			lblContrasena.setBounds(26, 110, 86, 16);
			contentPanel.add(lblContrasena);
		}
		{
			txtContrasena = new JTextField();
			txtContrasena.setBounds(26, 139, 116, 22);
			contentPanel.add(txtContrasena);
			txtContrasena.setColumns(10);
		}
		{
			JButton btnIngresar = new JButton("Ingresar");
			btnIngresar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(Empresa.getInstance().getClientes().size());
					if(Empresa.getInstance().confirmLogin(txtId.getText(), txtContrasena.getText())) {
						Principal frame = new Principal();
						dispose();
						frame.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Id o contraseña", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			btnIngresar.setBounds(26, 190, 97, 25);
			contentPanel.add(btnIngresar);
		}
	}

}
