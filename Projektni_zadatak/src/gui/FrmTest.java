package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JColorChooser;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class FrmTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup btnGroup = new ButtonGroup();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	JList listBoje = new JList();
	private JTextField txtUnosBoje;

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
		
		JLabel lblUnosBoje = new JLabel("Unesi boju:");
		
		txtUnosBoje = new JTextField();
		txtUnosBoje.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					dlm.addElement(txtUnosBoje.getText());
					txtUnosBoje.setText("");
				}
			}
		});
		txtUnosBoje.setColumns(10);
		
		JLabel lblOdabirBoje = new JLabel("Odaberi boju: ");
		
		JComboBox<String> cbxBoje = new JComboBox<String>();
		cbxBoje.addItem("Zelena");
		cbxBoje.addItem("Narandzasta");
		cbxBoje.addItem("Ljubicasta");
		
		JButton btnOdaberiBoju = new JButton("Dodaj");
		btnOdaberiBoju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement((String) cbxBoje.getSelectedItem());
			}
		});
		
		JButton btnIzbrisi = new JButton("Izbrisi");
		btnIzbrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!listBoje.isSelectionEmpty()) {
					dlm.removeElement(listBoje.getSelectedValue());
				}
				else {
					JOptionPane.showMessageDialog(null, "Nije selektovana nijedna boja!", "Upozorenje", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnRgbBoja = new JButton("Dodaj RGB");
		btnRgbBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgTest dlgTest = new DlgTest();
				dlgTest.setVisible(true);
				if (dlgTest.isOk) {
					dlm.addElement(dlgTest.txtCrvena.getText() + " " + dlgTest.txtZelena.getText() + " " + dlgTest.txtPlava.getText());
					pnlSouth.setBackground(new Color(Integer.parseInt(dlgTest.txtCrvena.getText()),
							Integer.parseInt(dlgTest.txtZelena.getText()),
							Integer.parseInt(dlgTest.txtPlava.getText())));
							
				}
			}
		});
		
		JButton btnIzmeniBoju = new JButton("Izmeni boju");
		btnIzmeniBoju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int indexOfSelectedElement = listBoje.getSelectedIndex();
				if (indexOfSelectedElement < 0) {
					JOptionPane.showMessageDialog(null, "Mora se selektovati element iz liste", "Message", JOptionPane.ERROR_MESSAGE);
				}
				else {
					String selectedElement = dlm.getElementAt(indexOfSelectedElement);
					String [] rgbColors = selectedElement.split(" ");
					DlgTest dlgIzmene = new DlgTest();
					dlgIzmene.txtCrvena.setText(rgbColors[0]);
					dlgIzmene.txtZelena.setText(rgbColors[1]);
					dlgIzmene.txtPlava.setText(rgbColors[2]);
					dlgIzmene.setVisible(true);
					
					if (dlgIzmene.isOk) {
						String red = dlgIzmene.txtCrvena.getText();
						String green = dlgIzmene.txtZelena.getText();
						String blue = dlgIzmene.txtPlava.getText();
						
						String stringColor = red + " " + green + " " + blue;
						dlm.setElementAt(stringColor, indexOfSelectedElement);
						
						Color color = new Color(Integer.parseInt(red),
								Integer.parseInt(green),
								Integer.parseInt(blue));
						pnlCenter.setBackground(color);
					}
				}
			}
		});
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
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
								.addComponent(lblZuta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(btnRgbBoja))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnIzmeniBoju)
					.addGap(18)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrlPaneBoje, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblOdabirBoje)
								.addComponent(lblUnosBoje))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtUnosBoje)
								.addComponent(cbxBoje, 0, 200, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(btnIzbrisi)
								.addComponent(btnOdaberiBoju))
							.addGap(4)))
					.addGap(61))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(tglbtnCrvena)
						.addComponent(lblCrvena)
						.addComponent(lblUnosBoje)
						.addComponent(txtUnosBoje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(tglbtnPlava)
						.addComponent(lblPlava)
						.addComponent(lblOdabirBoje)
						.addComponent(cbxBoje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOdaberiBoju))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(tglbtnZuta)
						.addComponent(lblZuta)
						.addComponent(btnIzbrisi))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_pnlCenter.createSequentialGroup()
							.addComponent(scrlPaneBoje, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_pnlCenter.createSequentialGroup()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRgbBoja)
								.addComponent(btnIzmeniBoju))
							.addGap(113))))
		);
		
		scrlPaneBoje.setViewportView(listBoje);
		pnlCenter.setLayout(gl_pnlCenter);
		
		
		JButton btnKlikni = new JButton("Klikni me");
		btnKlikni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(FrmTest.this,
						"Antistres dugme",
						"Poruka",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JButton btnBojaPozadine = new JButton("Boja pozadine");
		btnBojaPozadine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color backColor = JColorChooser.showDialog(null, "Choose background color", Color.black);
				if (backColor != null)
					pnlCenter.setBackground(backColor);
			}
		});
		pnlSouth.add(btnBojaPozadine);
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
}
