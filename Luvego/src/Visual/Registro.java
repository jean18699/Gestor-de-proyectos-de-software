package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;

public class Registro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Registro dialog = new Registro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public Registro() {

		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width,dim.height-50);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 88, 51);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JButton btnNewButton = new JButton("New button");
			btnNewButton.setBounds(0, 0, 100, 51);
			panel.add(btnNewButton);
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(87, 0, 105, 51);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		{
			JButton btnNewButton_1 = new JButton("New button");
			btnNewButton_1.setBounds(2, 0, 106, 51);
			panel_1.add(btnNewButton_1);
		}
		{
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(192, 0, 105, 51);
			contentPanel.add(panel_2);
			panel_2.setLayout(null);
			{
				JButton btnNewButton_2 = new JButton("New button");
				btnNewButton_2.setBounds(2, 0, 105, 51);
				panel_2.add(btnNewButton_2);
			}
		}
		{
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel_2.setBounds(0, 49, 1350, 597);
			contentPanel.add(panel_2);
			panel_2.setLayout(null);
			{
				JPanel panel_2_1 = new JPanel();
				panel_2_1.setBounds(244, 11, 904, 422);
				panel_2.add(panel_2_1);
				panel_2_1.setBackground(Color.WHITE);
				panel_2_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			}
			{
				JPanel panel_3 = new JPanel();
				panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, Color.GRAY, null, null));
				panel_3.setBounds(244, 437, 904, 93);
				panel_2.add(panel_3);
				panel_3.setLayout(null);
				{
					JPanel panel_4 = new JPanel();
					panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_4.setBounds(0, 0, 114, 93);
					panel_3.add(panel_4);
				}
				{
					JPanel panel_4 = new JPanel();
					panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_4.setBounds(113, 0, 114, 93);
					panel_3.add(panel_4);
				}
				{
					JPanel panel_4 = new JPanel();
					panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_4.setBounds(227, 0, 114, 93);
					panel_3.add(panel_4);
				}
				{
					JPanel panel_4 = new JPanel();
					panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_4.setBounds(339, 0, 114, 93);
					panel_3.add(panel_4);
				}
				{
					JPanel panel_4 = new JPanel();
					panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_4.setBounds(450, 0, 114, 93);
					panel_3.add(panel_4);
				}
				{
					JPanel panel_4 = new JPanel();
					panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_4.setBounds(561, 0, 114, 93);
					panel_3.add(panel_4);
				}
				{
					JPanel panel_4 = new JPanel();
					panel_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_4.setBounds(675, 0, 228, 93);
					panel_3.add(panel_4);
				}
			}
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
