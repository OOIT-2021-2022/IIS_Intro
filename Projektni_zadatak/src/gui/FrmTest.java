package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FrmTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup btnGroup = new ButtonGroup();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	JList listBoje = new JList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 461);
		setTitle("Zadatak 1");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane); 
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		JLabel lblCrvena = new JLabel("Crvena");
		lblCrvena.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblPlava = new JLabel("Plava");
		lblPlava.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlava.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblZuta = new JLabel("Zuta");
		lblZuta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblZuta.setHorizontalAlignment(SwingConstants.CENTER);
		
		JToggleButton tglbtnCrvena = new JToggleButton("Crvena");
		tglbtnCrvena.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnCrvena.isSelected()) {
					lblCrvena.setForeground(Color.RED);
					dlm.addElement(lblCrvena.getText());
				}
				else {
					lblCrvena.setForeground(Color.BLACK);
				}
			}
		});
		tglbtnCrvena.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JToggleButton tglbtnPlava = new JToggleButton("Plava");
		tglbtnPlava.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnPlava.isSelected()) {
					lblPlava.setForeground(Color.RED);
					dlm.addElement(lblPlava.getText());
				}
				else {
					lblPlava.setForeground(Color.BLACK);
				}
			}
		});
		tglbtnPlava.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JToggleButton tglbtnZuta = new JToggleButton("Zuta");
		tglbtnZuta.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnZuta.isSelected()) {
					lblZuta.setForeground(Color.RED);
					dlm.addElement(lblZuta.getText());
				}
				else {
					lblZuta.setForeground(Color.BLACK);
				}
			}
		});
		tglbtnZuta.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnGroup.add(tglbtnCrvena);
		btnGroup.add(tglbtnPlava);
		btnGroup.add(tglbtnZuta);
		
		JScrollPane scrlPaneBoje = new JScrollPane();
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tglbtnCrvena, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tglbtnPlava, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tglbtnZuta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblPlava, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCrvena, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblZuta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(562, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_pnlCenter.createSequentialGroup()
					.addContainerGap(208, Short.MAX_VALUE)
					.addComponent(scrlPaneBoje, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
					.addGap(61))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(tglbtnCrvena)
						.addComponent(lblCrvena))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(tglbtnPlava)
						.addComponent(lblPlava))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(tglbtnZuta)
						.addComponent(lblZuta))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(scrlPaneBoje, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		scrlPaneBoje.setViewportView(listBoje);
		pnlCenter.setLayout(gl_pnlCenter);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnKlikni = new JButton("Klikni me");
		btnKlikni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(FrmTest.this,
						"Antistres dugme",
						"Poruka",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		pnlSouth.add(btnKlikni);
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.GREEN);
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		
		JLabel lblZadatak1 = new JLabel("Zadatak 1");
		lblZadatak1.setBackground(Color.WHITE);
		lblZadatak1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblZadatak1.setHorizontalAlignment(SwingConstants.CENTER);
		pnlNorth.add(lblZadatak1);
		
		listBoje.setModel(dlm); //bindovanje modela (dlm) na listu boja (listBoje) !!!
		
		
	}
	
	/* prvo sam pokusao preko novog JFrame-a uraditi Antistres dugme
	private void openNewWindow() {
		JFrame newWindow = new JFrame("Antistres");
		newWindow.setSize(250, 150);
		newWindow.setLocationRelativeTo(null);
		newWindow.getContentPane().setLayout(new BorderLayout());
		
		Icon infoIcon = UIManager.getIcon("OptionPane.informationIcon");
		
		JLabel messageLabel = new JLabel("Antistres dugme", infoIcon, JLabel.CENTER);
		messageLabel.setHorizontalTextPosition(JLabel.RIGHT);
		messageLabel.setVerticalAlignment(JLabel.CENTER);
		messageLabel.setHorizontalAlignment(JLabel.CENTER);
		
		newWindow.getContentPane().add(messageLabel, BorderLayout.CENTER);
		
		newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		newWindow.setVisible(true);
		
		JButton okButton = new JButton("OK");
		
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				newWindow.dispose();
			}
			
		});
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		newWindow.getContentPane().add(okButton, BorderLayout.SOUTH);
		
	}
	*/
}
