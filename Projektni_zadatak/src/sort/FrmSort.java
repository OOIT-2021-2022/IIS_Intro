package sort;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class FrmSort extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Donut donut;
	JList<Donut> listDonut = new JList<>();
	private DefaultListModel<Donut> dlm = new DefaultListModel<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
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
	public FrmSort() {
		setTitle("Ivan Stankovic IT-22/2020");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(48)
					.addComponent(listDonut, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(56, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlCenter.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addComponent(listDonut, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		pnlCenter.setLayout(gl_pnlCenter);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnAddDonut = new JButton("Add Donut");
		btnAddDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgSort dlgSort = new DlgSort();
				dlgSort.setVisible(true);
				if(dlgSort.isOk()) {
					dlm.addElement(dlgSort.getDonut());
				}
			}
		});
		pnlSouth.add(btnAddDonut);
		
		JButton btnSortDonut = new JButton("Sort Donut");
		btnSortDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Donut> donuts = new ArrayList<Donut>();
				for (int i = 0; i < dlm.size(); i++) {
					donuts.add(dlm.getElementAt(i));
				}
				Collections.sort(donuts);
				dlm.clear();
				for (Donut donut : donuts) {
					dlm.addElement(donut);
				}
			}
		});
		pnlSouth.add(btnSortDonut);
		listDonut.setModel(dlm);
	}
}
