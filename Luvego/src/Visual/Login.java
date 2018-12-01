package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.File;
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
	 * @throws IOException 
	 * @throws ClassNotFoundException 
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
	
	private void leerArchivo() throws IOException, ClassNotFoundException {
		File archivoEmpresa = new File("empresa.dat");
		if(!archivoEmpresa.exists()) {
			FileOutputStream f = new FileOutputStream(new File("empresa.dat"));
			Cliente admin = new Cliente("0000", "Admin", "NULL", "0000");
			Empresa.getInstance().setLoginUser(admin);
			escribirArchivo();
		}
		FileInputStream fIn = new FileInputStream(archivoEmpresa);
		if(archivoEmpresa.length() > 0) {
			ObjectInputStream oi = new ObjectInputStream(fIn);
			Empresa.getInstance().setEmpresa((Empresa) oi.readObject());
			oi.close();
		}
	}
	
	private void escribirArchivo() throws IOException {
		FileOutputStream f = new FileOutputStream(new File("empresa.dat"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(Empresa.getInstance());
		f.close();
		o.close();

	}
	
	/*private void escribirArchivo() throws IOException {
		File archivoEmpresa = new File("registroBiblioteca.dat");
		FileOutputStream fOut = new FileOutputStream(archivoEmpresa);
		ObjectOutputStream o = new ObjectOutputStream(fOut);
		o.writeObject(Empresa.getInstance());
		fOut.close();
		o.close();
	}*/
	
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					File archivoEmpresa = new File("empresa.dat");
					FileInputStream fIn = new FileInputStream(archivoEmpresa);
					ObjectInputStream oi = new ObjectInputStream(fIn);
					Empresa.getInstance().setEmpresa((Empresa) oi.readObject());
					oi.close();
				}
				catch (Exception e) {
					File archivoEmpresa = new File("empresa.dat");
					Cliente admin = new Cliente("Admin", "Admin", "NULL", "0000");
					Empresa.getInstance().setLoginUser(admin);
					System.out.println(Empresa.getInstance().getLoginUser().getId());
					FileOutputStream fOut;
					try {
						fOut = new FileOutputStream(archivoEmpresa);
					} catch (FileNotFoundException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
					try {
						ObjectOutputStream empresaWrite = new ObjectOutputStream(fOut);
					} catch (IOException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					try {
						fOut = new FileOutputStream(archivoEmpresa);
						fOut.close();

					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				try {
					Login frame = new Login();
					frame.setVisible(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
			}
		});
	}*/
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Login() throws ClassNotFoundException, IOException {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		leerArchivo();
		
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
					System.out.println(Empresa.getInstance().getLoginUser().getId());
					System.out.println(Empresa.getInstance().getLoginUser().getPass());
					/*if(Empresa.getInstance().confirmLogin("Admin", "0000")) {
						Principal frame = new Principal();
						dispose();
						frame.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Id o contraseña", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}*/
				}
			});
			btnIngresar.setBounds(26, 190, 97, 25);
			contentPanel.add(btnIngresar);
		}
	}

}
