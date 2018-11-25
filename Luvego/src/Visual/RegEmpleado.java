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

public class RegEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;

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
		setBounds(100, 100, 598, 448);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(111, 11, 461, 354);
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
			
			JRadioButton rdbtnHombre = new JRadioButton("Hombre");
			buttonGroup.add(rdbtnHombre);
			rdbtnHombre.setBounds(66, 74, 63, 23);
			panel.add(rdbtnHombre);
			
			JRadioButton rdbtnMujer = new JRadioButton("Mujer");
			buttonGroup.add(rdbtnMujer);
			rdbtnMujer.setBounds(131, 74, 53, 23);
			panel.add(rdbtnMujer);
			
			JLabel lblEdad = new JLabel("Edad:");
			lblEdad.setBounds(10, 112, 46, 14);
			panel.add(lblEdad);
			
			JSpinner spnEdad = new JSpinner();
			spnEdad.setModel(new SpinnerNumberModel(18, 18, 70, 1));
			spnEdad.setBounds(66, 109, 46, 20);
			panel.add(spnEdad);
			
			JLabel lblNewLabel = new JLabel("Direccion:");
			lblNewLabel.setBounds(10, 148, 63, 14);
			panel.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(10, 173, 208, 54);
			panel.add(textField);
			textField.setColumns(10);
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
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
