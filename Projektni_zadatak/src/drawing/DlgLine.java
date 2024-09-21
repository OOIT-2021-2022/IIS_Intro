package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Line;
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

public class DlgLine extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX1Coordinate;
	private JTextField txtY1Coordinate;
	private JTextField txtX2Coordinate;
	private JTextField txtY2Coordinate;
	private Color color;
	private Line line;
	private boolean isOk = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblX1Coordinate = new JLabel("Start Point X Coordinate:");
		JLabel lblY1Coordinate = new JLabel("Start Point Y Coordinate:");
		JLabel lblX2Coordinate = new JLabel("End Point X Coordinate:");
		JLabel lblY2Coordinate = new JLabel("End Point Y Coordinate:");
		JButton btnColor = new JButton("Color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(null, "Choose a color for your Line", color);
			}
		});
		txtX1Coordinate = new JTextField();
		txtX1Coordinate.setHorizontalAlignment(SwingConstants.TRAILING);
		txtX1Coordinate.setColumns(10);
		txtY1Coordinate = new JTextField();
		txtY1Coordinate.setHorizontalAlignment(SwingConstants.TRAILING);
		txtY1Coordinate.setColumns(10);
		txtX2Coordinate = new JTextField();
		txtX2Coordinate.setHorizontalAlignment(SwingConstants.TRAILING);
		txtX2Coordinate.setColumns(10);
		txtY2Coordinate = new JTextField();
		txtY2Coordinate.setHorizontalAlignment(SwingConstants.TRAILING);
		txtY2Coordinate.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblX1Coordinate)
									.addGap(18)
									.addComponent(txtX1Coordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblY1Coordinate)
										.addComponent(lblX2Coordinate)
										.addComponent(lblY2Coordinate))
									.addGap(18)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtY2Coordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtX2Coordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtY1Coordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(196)
							.addComponent(btnColor)))
					.addContainerGap(213, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX1Coordinate)
						.addComponent(txtX1Coordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY1Coordinate)
						.addComponent(txtY1Coordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX2Coordinate)
						.addComponent(txtX2Coordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY2Coordinate)
						.addComponent(txtY2Coordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addComponent(btnColor)
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
							if(txtX1Coordinate.getText().trim().isEmpty() || txtY1Coordinate.getText().trim().isEmpty() || 
									txtX2Coordinate.getText().trim().isEmpty() || txtY2Coordinate.getText().trim().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Input cannot be empty for any elements!", "Warning", JOptionPane.ERROR_MESSAGE);
							}
							else {
								int x1 = Integer.parseInt(txtX1Coordinate.getText());
								int y1 = Integer.parseInt(txtY1Coordinate.getText());
								int x2 = Integer.parseInt(txtX2Coordinate.getText());
								int y2 = Integer.parseInt(txtY2Coordinate.getText());
								if(x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) {
									JOptionPane.showMessageDialog(null, "Coordinates cannot be less than zero!", "Warning", JOptionPane.ERROR_MESSAGE);
									
								}
								else {
									isOk = true;
									line = new Line(new Point(x1,y1), new Point(x2,y2), false, color);
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
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		txtX1Coordinate.setText(String.valueOf(line.getStartPoint().getX()));
		txtY1Coordinate.setText(String.valueOf(line.getStartPoint().getY()));
		txtX2Coordinate.setText(String.valueOf(line.getEndPoint().getX()));
		txtY2Coordinate.setText(String.valueOf(line.getEndPoint().getY()));
		color = line.getColor();
	}

	public JTextField getTxtX1Coordinate() {
		return txtX1Coordinate;
	}

	public void setTxtX1Coordinate(JTextField txtX1Coordinate) {
		this.txtX1Coordinate = txtX1Coordinate;
	}

	public JTextField getTxtY1Coordinate() {
		return txtY1Coordinate;
	}

	public void setTxtY1Coordinate(JTextField txtY1Coordinate) {
		this.txtY1Coordinate = txtY1Coordinate;
	}

	public JTextField getTxtX2Coordinate() {
		return txtX2Coordinate;
	}

	public void setTxtX2Coordinate(JTextField txtX2Coordinate) {
		this.txtX2Coordinate = txtX2Coordinate;
	}

	public JTextField getTxtY2Coordinate() {
		return txtY2Coordinate;
	}

	public void setTxtY2Coordinate(JTextField txtY2Coordinate) {
		this.txtY2Coordinate = txtY2Coordinate;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
