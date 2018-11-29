package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;

import Logico.Empleado;
import Logico.Empresa;
import Logico.Planificador;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtDireccion;
	private JTextField txtSalario;
	private JTextField txtFrecuencia;
	private JRadioButton radHombre;
	private JRadioButton radMujer;
	private JSpinner spnEdad;
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
		setBounds(100, 100, 619, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(111, 11, 492, 295);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(10, 11, 46, 14);
				panel.add(lblNombre);
			}
			
			txtNombre = new JTextField();
			txtNombre.setBounds(66, 8, 152, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(10, 42, 46, 14);
			panel.add(lblApellido);
			
			txtApellido = new JTextField();
			txtApellido.setBounds(66, 39, 152, 20);
			panel.add(txtApellido);
			txtApellido.setColumns(10);
			
			JLabel lblGenero = new JLabel("Genero:");
			lblGenero.setBounds(10, 78, 46, 14);
			panel.add(lblGenero);
			
			radHombre = new JRadioButton("Hombre");
			buttonGroup.add(radHombre);
			radHombre.setBounds(66, 74, 63, 23);
			panel.add(radHombre);
			
			radMujer = new JRadioButton("Mujer");
			buttonGroup.add(radMujer);
			radMujer.setBounds(131, 74, 53, 23);
			panel.add(radMujer);
			
			JLabel lblEdad = new JLabel("Edad:");
			lblEdad.setBounds(10, 112, 46, 14);
			panel.add(lblEdad);
			
			spnEdad = new JSpinner();
			spnEdad.setModel(new SpinnerNumberModel(18, 18, 70, 1));
			spnEdad.setBounds(66, 109, 46, 20);
			panel.add(spnEdad);
			
			JLabel lblNewLabel = new JLabel("Direccion:");
			lblNewLabel.setBounds(10, 148, 63, 14);
			panel.add(lblNewLabel);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(10, 173, 208, 54);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JLabel lblSalarioPorHora = new JLabel("Salario por hora a pagar:");
			lblSalarioPorHora.setBounds(10, 253, 152, 14);
			panel.add(lblSalarioPorHora);
			
			txtSalario = new JTextField();
			txtSalario.setBounds(132, 250, 107, 20);
			panel.add(txtSalario);
			txtSalario.setColumns(10);
			
			JLabel lblRd = new JLabel("RD$");
			lblRd.setBounds(249, 253, 46, 14);
			panel.add(lblRd);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Informacion adicional", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(249, 11, 233, 216);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblFrecuencia = new JLabel("Frecuencia:");
			lblFrecuencia.setBounds(10, 31, 75, 14);
			panel_1.add(lblFrecuencia);
			
			txtFrecuencia = new JTextField();
			txtFrecuencia.setBounds(88, 28, 86, 20);
			panel_1.add(txtFrecuencia);
			txtFrecuencia.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel.setBounds(0, 11, 108, 74);
			contentPanel.add(panel);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel.setBounds(0, 85, 108, 74);
			contentPanel.add(panel);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel.setBounds(0, 159, 108, 73);
			contentPanel.add(panel);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel.setBounds(0, 232, 108, 74);
			contentPanel.add(panel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String genero = null;
						if(radHombre.isSelected())
						{
							genero = radHombre.getLabel();
						}else if(radMujer.isSelected())
						{
							genero = radMujer.getLabel();
						}
						
						Empleado emp = new Planificador(txtNombre.getText(),txtApellido.getText(),genero, Integer.parseInt(spnEdad.getValue().toString()),txtDireccion.getText(),Float.parseFloat(txtSalario.getText()));
						Empresa.getInstance().nuevoEmpleado(emp);
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
