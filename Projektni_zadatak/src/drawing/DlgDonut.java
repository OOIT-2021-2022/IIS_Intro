package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
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

public class DlgDonut extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	private JTextField txtDonutRadius;
	private JTextField txtDonutInnerRadius;
	private Color edgeColor = Color.BLACK;
	private Color innerColor = Color.WHITE;
	private Donut donut;
	private boolean isOk = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setTitle("Donut");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblCenterXCoordinate = new JLabel("Center X Coordinate:");
		JLabel lblCenterYCoordinate = new JLabel("Center Y Coordinate:");
		JLabel lblRadius = new JLabel("Donut Radius:");
		JLabel lblInnerRadius = new JLabel("Donut Inner Radius:");
		txtXCoordinate = new JTextField();
		txtXCoordinate.setHorizontalAlignment(SwingConstants.TRAILING);
		txtXCoordinate.setColumns(10);
		txtYCoordinate = new JTextField();
		txtYCoordinate.setHorizontalAlignment(SwingConstants.TRAILING);
		txtYCoordinate.setColumns(10);
		txtDonutRadius = new JTextField();
		txtDonutRadius.setHorizontalAlignment(SwingConstants.TRAILING);
		txtDonutRadius.setColumns(10);
		txtDonutInnerRadius = new JTextField();
		txtDonutInnerRadius.setHorizontalAlignment(SwingConstants.TRAILING);
		txtDonutInnerRadius.setColumns(10);
		JButton btnEdgeColor = new JButton("Edge Color");
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "Choose an edge color for your Donut", edgeColor);
			}
		});
		
		JButton btnInnerColor = new JButton("Inner Color");
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				innerColor = JColorChooser.showDialog(null, "Choose an inner color for your Donut", innerColor);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(lblCenterXCoordinate)
								.addGap(18)
								.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblCenterYCoordinate)
									.addComponent(lblRadius)
									.addComponent(lblInnerRadius))
								.addGap(18)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(txtDonutInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtDonutRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addComponent(btnEdgeColor, Alignment.TRAILING))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnInnerColor)
					.addContainerGap(165, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCenterXCoordinate)
						.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCenterYCoordinate)
						.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(txtDonutRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInnerRadius)
						.addComponent(txtDonutInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEdgeColor)
						.addComponent(btnInnerColor))
					.addContainerGap())
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
							if(txtXCoordinate.getText().trim().isEmpty() || txtYCoordinate.getText().trim().isEmpty() || 
									txtDonutRadius.getText().trim().isEmpty() || txtDonutInnerRadius.getText().trim().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Input cannot be empty for any elements!", "Warning", JOptionPane.ERROR_MESSAGE);
							}
							else {
								int x = Integer.parseInt(txtXCoordinate.getText());
								int y = Integer.parseInt(txtYCoordinate.getText());
								int radius = Integer.parseInt(txtDonutRadius.getText());
								int innerRadius = Integer.parseInt(txtDonutInnerRadius.getText());
								if(x < 0 || y < 0 || radius <= 0 || innerRadius <= 0 || radius <= innerRadius) {
									JOptionPane.showMessageDialog(null, "Coordinates cannot be less than (or for Radius and Inner Radius equal to) zero!\n"
											+ "Radius cannot be smaller or equal to innerRadius", "Warning", 
											JOptionPane.ERROR_MESSAGE);
									
								}
								else {
									isOk = true;
									donut = new Donut(new Point(x,y), radius, innerRadius, false, edgeColor, innerColor);
									setVisible(false);
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
						isOk = false;
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Donut getDonut() {
		return donut;
	}
	
	public void setDonut(Donut donut) {
		txtXCoordinate.setText(String.valueOf(donut.getCenter().getX()));
		txtYCoordinate.setText(String.valueOf(donut.getCenter().getY()));
		txtDonutRadius.setText(String.valueOf(donut.getRadius()));
		txtDonutInnerRadius.setText(String.valueOf(donut.getInnerRadius()));
		edgeColor = donut.getColor();
		innerColor = donut.getInnerColor();
	}
	
	public void setPoint(Point point) {
		txtXCoordinate.setText(String.valueOf(point.getX()));
		txtYCoordinate.setText(String.valueOf(point.getY()));
		
	}
	
	public void setColors(Color edgeColor, Color innerColor) {
		this.edgeColor = edgeColor;
		this.innerColor = innerColor;
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

	public JTextField getTxtDonutRadius() {
		return txtDonutRadius;
	}

	public void setTxtDonutRadius(JTextField txtDonutRadius) {
		this.txtDonutRadius = txtDonutRadius;
	}

	public JTextField getTxtDonutInnerRadius() {
		return txtDonutInnerRadius;
	}

	public void setTxtDonutInnerRadius(JTextField txtDonutInnerRadius) {
		this.txtDonutInnerRadius = txtDonutInnerRadius;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

}
