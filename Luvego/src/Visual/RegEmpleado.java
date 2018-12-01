package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logico.Disegnador;
import Logico.Empleado;
import Logico.Empresa;
import Logico.Jefe;
import Logico.Planificador;
import Logico.Programador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class RegEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDireccion;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JLabel lblEspecialidades;
	private JCheckBox chckbxJava;
	private JCheckBox chckbxHtml;
	private JCheckBox chckbxCpp;
	private JLabel lblFrecuencia;
	private JSpinner spnFrecuencia;
	private JRadioButton rdbtnJefe;
	private JRadioButton rdbtnProgramador;
	private JRadioButton rdbtnPlanificador;
	private JRadioButton rdbtnDisegnador;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JTextField txtSalarioHora;
	private JSpinner spnEdad;
	private JLabel lblFotoMujer;
	private JLabel lblFotoHombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEmpleado dialog = new RegEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegEmpleado() {
		setBounds(100, 100, 676, 539);
		setResizable(false);
		setTitle("Registrar empleado");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		JPanel panel_InfoPersonal = new JPanel();
		panel_InfoPersonal.setBorder(new TitledBorder(null, "Informacion personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_InfoPersonal.setBounds(12, 13, 644, 193);
		contentPanel.add(panel_InfoPersonal);
		panel_InfoPersonal.setLayout(null);
		{
			JLabel lblId = new JLabel("Id:");
			lblId.setBounds(12, 39, 33, 16);
			panel_InfoPersonal.add(lblId);
		}
		{
			JLabel lblNombre = new JLabel("Nombre: ");
			lblNombre.setBounds(12, 79, 56, 16);
			panel_InfoPersonal.add(lblNombre);
		}
		{
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setBounds(329, 79, 56, 16);
			panel_InfoPersonal.add(lblApellidos);
		}
		{
			JLabel lblSexo = new JLabel("Sexo: ");
			lblSexo.setBounds(12, 119, 56, 16);
			panel_InfoPersonal.add(lblSexo);
		}
		{
			JLabel lblEdad = new JLabel("Edad: ");
			lblEdad.setBounds(329, 119, 56, 16);
			panel_InfoPersonal.add(lblEdad);
		}
		{
			JLabel lblDireccion = new JLabel("Direccion");
			lblDireccion.setBounds(12, 159, 56, 16);
			panel_InfoPersonal.add(lblDireccion);
		}
		{
			txtDireccion = new JTextField();
			txtDireccion.setBounds(80, 157, 211, 19);
			panel_InfoPersonal.add(txtDireccion);
			txtDireccion.setColumns(10);
		}
		{
			txtId = new JTextField();
			Empleado jefe = new Jefe("", "", "", 0, "", 0);
			txtId.setText(jefe.getId());
			int cont = Empleado.getCont()-1;
			Empleado.setCont(cont);
			txtId.setEditable(false);
			txtId.setBounds(80, 36, 172, 22);
			panel_InfoPersonal.add(txtId);
			txtId.setColumns(10);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(80, 76, 211, 22);
			panel_InfoPersonal.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			txtApellidos = new JTextField();
			txtApellidos.setBounds(398, 76, 211, 22);
			panel_InfoPersonal.add(txtApellidos);
			txtApellidos.setColumns(10);
		}
		
		rdbtnHombre = new JRadioButton("");
		rdbtnHombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnMujer.setSelected(false);
				
				if(!rdbtnHombre.isSelected()) {
					rdbtnHombre.setSelected(true);
				}
				
			}
		});
		rdbtnHombre.setSelected(true);
		rdbtnHombre.setBounds(76, 115, 25, 25);
		panel_InfoPersonal.add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("");
		rdbtnMujer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnHombre.setSelected(false);
				
				if(!rdbtnMujer.isSelected()) {
					rdbtnMujer.setSelected(true);
				}
			}
		});
		rdbtnMujer.setBounds(164, 115, 25, 25);
		panel_InfoPersonal.add(rdbtnMujer);
		
		spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(new Integer(18), new Integer(18), null, new Integer(1)));
		spnEdad.setBounds(397, 116, 46, 22);
		panel_InfoPersonal.add(spnEdad);
		{
			lblFotoMujer = new JLabel("");
			lblFotoMujer.setIcon(new ImageIcon(RegEmpleado.class.getResource("/img/empleada.png")));
			lblFotoMujer.setBounds(185, 101, 62, 54);
			panel_InfoPersonal.add(lblFotoMujer);
		}
		{
			lblFotoHombre = new JLabel("");
			lblFotoHombre.setIcon(new ImageIcon(RegEmpleado.class.getResource("/img/empleado.png")));
			lblFotoHombre.setBounds(94, 101, 62, 54);
			panel_InfoPersonal.add(lblFotoHombre);
		}
		{
			JPanel panelOcupacion = new JPanel();
			panelOcupacion.setBorder(new TitledBorder(null, "Ocupación", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelOcupacion.setBounds(12, 216, 644, 109);
			contentPanel.add(panelOcupacion);
			panelOcupacion.setLayout(null);
			{
				rdbtnJefe = new JRadioButton("Jefe");
				rdbtnJefe.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Empleado jefe = new Jefe("", "", "", 0, "", 0);
						txtId.setText(jefe.getId());
						int cont = Empleado.getCont()-1;
						Empleado.setCont(cont);
						
						rdbtnProgramador.setSelected(false);
						rdbtnPlanificador.setSelected(false);
						rdbtnDisegnador.setSelected(false);
						
						lblEspecialidades.setVisible(false);
						chckbxJava.setVisible(false);
						chckbxHtml.setVisible(false);
						chckbxCpp.setVisible(false);
						
						lblFrecuencia.setVisible(false);
						spnFrecuencia.setVisible(false);
						
						if(!rdbtnJefe.isSelected()) {
							rdbtnJefe.setSelected(true);
						}
						
					}
				});
				rdbtnJefe.setSelected(true);
				rdbtnJefe.setBounds(8, 43, 90, 25);
				panelOcupacion.add(rdbtnJefe);
			}
			{
				rdbtnProgramador = new JRadioButton("Programador");
				rdbtnProgramador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Empleado program = new Programador("", "", "", 0, "", 0, null);
						txtId.setText(program.getId());
						int cont = Empleado.getCont()-1;
						Empleado.setCont(cont);
						
						rdbtnJefe.setSelected(false);
						rdbtnPlanificador.setSelected(false);
						rdbtnDisegnador.setSelected(false);
						
						lblEspecialidades.setVisible(true);
						chckbxJava.setVisible(true);
						chckbxHtml.setVisible(true);
						chckbxCpp.setVisible(true);
						
						lblFrecuencia.setVisible(false);
						spnFrecuencia.setVisible(false);
						
						if(!rdbtnProgramador.isSelected()) {
							rdbtnProgramador.setSelected(true);
						}
					}
				});
				rdbtnProgramador.setSelected(false);
				rdbtnProgramador.setBounds(102, 43, 127, 25);
				panelOcupacion.add(rdbtnProgramador);
			}
			{
				rdbtnPlanificador = new JRadioButton("Planificador");
				rdbtnPlanificador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Empleado planif = new Planificador("", "", "", 0, "", 0, 0);
						txtId.setText(planif.getId());
						int cont = Empleado.getCont()-1;
						Empleado.setCont(cont);
						
						rdbtnJefe.setSelected(false);
						rdbtnProgramador.setSelected(false);
						rdbtnDisegnador.setSelected(false);
						
						lblEspecialidades.setVisible(false);
						chckbxJava.setVisible(false);
						chckbxHtml.setVisible(false);
						chckbxCpp.setVisible(false);
						
						lblFrecuencia.setVisible(true);
						spnFrecuencia.setVisible(true);
						
						if(!rdbtnPlanificador.isSelected()) {
							rdbtnPlanificador.setSelected(true);
						}
					}
				});
				rdbtnPlanificador.setBounds(233, 43, 127, 25);
				panelOcupacion.add(rdbtnPlanificador);
			}
			{
				rdbtnDisegnador = new JRadioButton("Dise\u00F1ador");
				rdbtnDisegnador.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Empleado disegn = new Disegnador("", "", "", 0, "", 0);
						txtId.setText(disegn.getId());
						int cont = Empleado.getCont()-1;
						Empleado.setCont(cont);
						
						rdbtnJefe.setSelected(false);
						rdbtnProgramador.setSelected(false);
						rdbtnPlanificador.setSelected(false);

						lblEspecialidades.setVisible(false);
						chckbxJava.setVisible(false);
						chckbxHtml.setVisible(false);
						chckbxCpp.setVisible(false);
						
						lblFrecuencia.setVisible(false);
						spnFrecuencia.setVisible(false);
						
						if(!rdbtnDisegnador.isSelected()) {
							rdbtnDisegnador.setSelected(true);
						}
					}
				});
				rdbtnDisegnador.setBounds(364, 43, 127, 25);
				panelOcupacion.add(rdbtnDisegnador);
			}
		}
		{
			JPanel panel_InfoAdicional = new JPanel();
			panel_InfoAdicional.setBorder(new TitledBorder(null, "Info adicional", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_InfoAdicional.setBounds(12, 332, 644, 109);
			contentPanel.add(panel_InfoAdicional);
			panel_InfoAdicional.setLayout(null);
			{
				JLabel lblSalariohora = new JLabel("Salario/hora:");
				lblSalariohora.setBounds(12, 48, 85, 16);
				panel_InfoAdicional.add(lblSalariohora);
			}
			{
				lblEspecialidades = new JLabel("Especialidades:");
				lblEspecialidades.setVisible(false);
				lblEspecialidades.setBounds(232, 48, 99, 16);
				panel_InfoAdicional.add(lblEspecialidades);
			}
			
			chckbxJava = new JCheckBox("Java");
			chckbxJava.setVisible(false);
			chckbxJava.setBounds(339, 44, 69, 25);
			panel_InfoAdicional.add(chckbxJava);
			
			chckbxHtml = new JCheckBox("HTML");
			chckbxHtml.setVisible(false);
			chckbxHtml.setBounds(412, 44, 69, 25);
			panel_InfoAdicional.add(chckbxHtml);
			
			chckbxCpp = new JCheckBox("C++");
			chckbxCpp.setVisible(false);
			chckbxCpp.setBounds(490, 44, 113, 25);
			panel_InfoAdicional.add(chckbxCpp);
			{
				lblFrecuencia = new JLabel("Frecuencia:");
				lblFrecuencia.setVisible(false);
				lblFrecuencia.setBounds(232, 48, 85, 16);
				panel_InfoAdicional.add(lblFrecuencia);
			}
			
			spnFrecuencia = new JSpinner();
			spnFrecuencia.setVisible(false);
			spnFrecuencia.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnFrecuencia.setBounds(343, 45, 69, 22);
			panel_InfoAdicional.add(spnFrecuencia);
			{
				txtSalarioHora = new JTextField();
				txtSalarioHora.setBounds(109, 45, 85, 22);
				panel_InfoAdicional.add(txtSalarioHora);
				txtSalarioHora.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String nombre = txtNombre.getText();
						String apellidos = txtApellidos.getText();
						String sexo;
						if(rdbtnHombre.isSelected()) {
							sexo = "Hombre";
						}
						else {
							sexo = "Mujer";
						}
						int edad = (int) spnEdad.getValue();
						String direccion = txtDireccion.getText();
						float salarioHora = 0; //Float.valueOf(txtSalarioHora.getText());
						
						if(Empresa.getInstance().ValidadorFlotantes(txtSalarioHora.getText())) {
							salarioHora = Float.valueOf(txtSalarioHora.getText());
						}
						
						ArrayList<String> especialidades = new ArrayList<>();
						if(chckbxJava.isSelected()) {
							especialidades.add("Java");
						}
						if(chckbxHtml.isSelected()) {
							especialidades.add("HTML");
						}
						if(chckbxCpp.isSelected()) {
							especialidades.add("C++");
						}
						
						int frecuancia = (int) spnFrecuencia.getValue();
						
						if(!Empresa.getInstance().ValidadorNombre(nombre) || !Empresa.getInstance().ValidadorNombre(apellidos) || salarioHora == 0 || direccion.equals("")) {
							
							JOptionPane.showMessageDialog(null, "Por favor, llene correctamente todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
							if(!Empresa.getInstance().ValidadorNombre(nombre)) {
								txtNombre.setForeground(Color.RED);
							}
							if(!Empresa.getInstance().ValidadorNombre(apellidos)) {
								txtApellidos.setForeground(Color.RED);
							}
							/*if(direccion.equals("")) {
								txtDireccion.setForeground(Color.RED);
							}*/
							if(salarioHora == 0) {
								txtSalarioHora.setForeground(Color.RED);
							}
						}
						else {
							if(rdbtnProgramador.isSelected() && !chckbxJava.isSelected() && !chckbxHtml.isSelected() && !chckbxCpp.isSelected()) {
								JOptionPane.showMessageDialog(null, "Por favor, seleccione una o más especialidades", "Advertencia", JOptionPane.WARNING_MESSAGE);
							}
							
							else {
							
								if(rdbtnJefe.isSelected()) {
									Empleado jefe = new Jefe(nombre, apellidos, sexo, edad, direccion, salarioHora);
									Empresa.getInstance().nuevoEmpleado(jefe);
								}
								else if(rdbtnProgramador.isSelected()) {
									Empleado programador = new Programador(nombre, apellidos, sexo, edad, direccion, salarioHora, especialidades);
									Empresa.getInstance().nuevoEmpleado(programador);
								}
								else if(rdbtnPlanificador.isSelected()) {
									Empleado planificador = new Planificador(nombre, apellidos, sexo, edad, direccion, salarioHora, frecuancia);
									Empresa.getInstance().nuevoEmpleado(planificador);
								}
								else if(rdbtnDisegnador.isSelected()) {
									Empleado disegnador = new Disegnador(nombre, apellidos, sexo, edad, direccion, salarioHora);
									Empresa.getInstance().nuevoEmpleado(disegnador);
								}
								cleanFields();
							}
						}
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
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
	
	private void cleanFields() {
		
		Empleado jefe = new Jefe("", "", "", 0, "", 0);
		txtId.setText(jefe.getId());
		int cont = Empleado.getCont()-1;
		Empleado.setCont(cont);
		
		txtNombre.setText("");
		txtApellidos.setText("");
		rdbtnHombre.setSelected(true);
		rdbtnMujer.setSelected(false);
		spnEdad.setValue(18);
		txtDireccion.setText("");
		rdbtnJefe.setSelected(true);
		
		rdbtnProgramador.setSelected(false);
		rdbtnPlanificador.setSelected(false);
		rdbtnDisegnador.setSelected(false);
		
		txtSalarioHora.setText("");
		spnFrecuencia.setValue(0);
		chckbxJava.setSelected(false);
		chckbxHtml.setSelected(false);
		chckbxCpp.setSelected(false);
		
		txtNombre.setForeground(Color.BLACK);
		txtApellidos.setForeground(Color.BLACK);
		txtSalarioHora.setForeground(Color.BLACK);
		
	}
}
