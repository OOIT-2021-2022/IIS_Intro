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

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtX2;
	private JTextField txtY2;
	
	private Line line = null;
	private Color color = null;

	public Line getLine() {
		return line;
	}

	public void setColors(Color edgeColor) {
		this.color = color;
	}
	
	public void setStartPoint(Point point) {
		txtX.setText("" + point.getX());
		txtY.setText("" + point.getY());
	}
	
	public void setEndPoint(Point point) {
		txtX2.setText("" + point.getX());
		txtY2.setText("" + point.getY());
	}
	
	public void setLine(Line line) {
		txtX.setText("" + line.getStartPoint().getX());
		txtY.setText("" + line.getStartPoint().getY());
		txtX2.setText("" + line.getEndPoint().getX());
		txtY2.setText("" + line.getEndPoint().getY());
		color = line.getColor();
	}
	
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
		setModal(true);
		setTitle("Ivan Stankovic, IT-22/2020");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX1 = new JLabel("Coordinate X1:");
			lblX1.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblX1 = new GridBagConstraints();
			gbc_lblX1.insets = new Insets(0, 0, 5, 5);
			gbc_lblX1.gridx = 1;
			gbc_lblX1.gridy = 1;
			contentPanel.add(lblX1, gbc_lblX1);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.insets = new Insets(0, 0, 5, 0);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 2;
			gbc_txtX.gridy = 1;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lblY1 = new JLabel("Coordinate Y1:");
			lblY1.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblY1 = new GridBagConstraints();
			gbc_lblY1.insets = new Insets(0, 0, 5, 5);
			gbc_lblY1.gridx = 1;
			gbc_lblY1.gridy = 2;
			contentPanel.add(lblY1, gbc_lblY1);
		}
		{
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 2;
			gbc_txtY.gridy = 2;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblX2 = new JLabel("Coordinate X2:");
			lblX2.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblX2 = new GridBagConstraints();
			gbc_lblX2.insets = new Insets(0, 0, 5, 5);
			gbc_lblX2.gridx = 1;
			gbc_lblX2.gridy = 3;
			contentPanel.add(lblX2, gbc_lblX2);
		}
		{
			txtX2 = new JTextField();
			GridBagConstraints gbc_txtX2 = new GridBagConstraints();
			gbc_txtX2.insets = new Insets(0, 0, 5, 0);
			gbc_txtX2.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX2.gridx = 2;
			gbc_txtX2.gridy = 3;
			contentPanel.add(txtX2, gbc_txtX2);
			txtX2.setColumns(10);
		}
		{
			JLabel lblY2 = new JLabel("Coordinate Y2:");
			GridBagConstraints gbc_lblY2 = new GridBagConstraints();
			gbc_lblY2.insets = new Insets(0, 0, 5, 5);
			gbc_lblY2.gridx = 1;
			gbc_lblY2.gridy = 4;
			contentPanel.add(lblY2, gbc_lblY2);
		}
		{
			txtY2 = new JTextField();
			GridBagConstraints gbc_txtY2 = new GridBagConstraints();
			gbc_txtY2.insets = new Insets(0, 0, 5, 0);
			gbc_txtY2.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY2.gridx = 2;
			gbc_txtY2.gridy = 4;
			contentPanel.add(txtY2, gbc_txtY2);
			txtY2.setColumns(10);
		}
		{
			JButton btnColor = new JButton("Color");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(null, "Choose a color: ", color);
					if(color == null)
						color = Color.BLACK;
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.insets = new Insets(0, 0, 0, 5);
			gbc_btnColor.gridx = 1;
			gbc_btnColor.gridy = 6;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int X1 = Integer.parseInt(txtX.getText());
							int Y1 = Integer.parseInt(txtY.getText());
							int X3 = Integer.parseInt(txtX2.getText());
							int Y3 = Integer.parseInt(txtY2.getText());
							
							if(X1 < 0 || Y1 < 0 || X3 < 0 || Y3 < 0) {
								JOptionPane.showMessageDialog(null, "You entered a wrong value", "ERROR", JOptionPane.ERROR_MESSAGE);
								return;
							}
							line = new Line(new Point(X1, Y1), new Point (X3, Y3), false, color);
							dispose();
						}
						
						catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "You entered a wrong data type", "ERROR", JOptionPane.ERROR_MESSAGE);
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
