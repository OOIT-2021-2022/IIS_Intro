package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
import geometry.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgStack extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	protected JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	private JTextField txtRadius;
	private boolean isOk = false;
	private Donut donut;
	private JTextField txtInnerRadius;

	public Donut getDonut() {
		return donut;
	}

	public void setDonut(Donut donut) {
		txtXCoordinate.setText(String.valueOf(donut.getCenter().getX()));
		txtYCoordinate.setText(String.valueOf(donut.getCenter().getY()));
		txtRadius.setText(String.valueOf(donut.getRadius()));
		txtInnerRadius.setText(String.valueOf(donut.getInnerRadius()));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgStack dialog = new DlgStack(true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStack(boolean isEditable) {
		setModal(true);
		setTitle("Donut");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblXCoordinate = new JLabel("X coordinate:");
		JLabel lblYCoordinate = new JLabel("Y coordinate:");
		JLabel lblRadius = new JLabel("Radius:");
		txtXCoordinate = new JTextField();
		txtXCoordinate.setHorizontalAlignment(SwingConstants.TRAILING);
		txtXCoordinate.setColumns(10);
		txtYCoordinate = new JTextField();
		txtYCoordinate.setHorizontalAlignment(SwingConstants.TRAILING);
		txtYCoordinate.setColumns(10);
		txtRadius = new JTextField();
		txtRadius.setHorizontalAlignment(SwingConstants.TRAILING);
		txtRadius.setColumns(10);
		
		JLabel lblInnerRadius = new JLabel("Inner radius:");
		
		txtInnerRadius = new JTextField();
		txtInnerRadius.setHorizontalAlignment(SwingConstants.TRAILING);
		txtInnerRadius.setColumns(10);
		txtXCoordinate.setEditable(isEditable);
		txtYCoordinate.setEditable(isEditable);
		txtRadius.setEditable(isEditable);
		txtInnerRadius.setEditable(isEditable);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblXCoordinate)
							.addGap(18)
							.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblInnerRadius)
								.addComponent(lblYCoordinate)
								.addComponent(lblRadius))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(264, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXCoordinate)
						.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYCoordinate)
						.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInnerRadius)
						.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(118, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int x = Integer.parseInt(txtXCoordinate.getText());
							int y = Integer.parseInt(txtYCoordinate.getText());
							int radius = Integer.parseInt(txtRadius.getText());
							int innerRadius = Integer.parseInt(txtInnerRadius.getText());
							if(txtXCoordinate.getText().trim().isEmpty() || txtYCoordinate.getText().trim().isEmpty() || 
									txtRadius.getText().trim().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Input cannot be empty!", "Warning", JOptionPane.ERROR_MESSAGE);
							}
								else {
									if (Integer.parseInt(txtRadius.getText()) > 0 &&
											Integer.parseInt(txtInnerRadius.getText()) > 0) {
										isOk = true;
										donut = new Donut(new Point(x,y), radius, innerRadius);
										setVisible(false);
									}
									else {
										JOptionPane.showMessageDialog(null, "Input has to be greater than or equal (for coordinates) to 0!",
												"Warning", JOptionPane.ERROR_MESSAGE);
									}
								}
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Input has to be a number!", "Warning", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTxtXCoordinate() {
		return txtXCoordinate;
	}

	public void setTxtXCoordinate(JTextField txtXCoordinate) {
		this.txtXCoordinate = txtXCoordinate;
	}

	public JTextField getTxtYCoordinate() {
		return txtYCoordinate;
	}

	public void setTxtYCoordinate(JTextField txtYCoordinate) {
		this.txtYCoordinate = txtYCoordinate;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

}
