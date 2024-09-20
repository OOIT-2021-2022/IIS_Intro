package drawing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmDrawing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Color edgeColor = Color.BLACK;
	private Color innerColor = Color.WHITE;
	private PnlDrawing pnlDrawing;
	private Point startPoint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
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
	public FrmDrawing() {
		setTitle("Ivan Stankovic IT-22/2020");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pnlDrawing = new PnlDrawing();
		pnlDrawing.addMouseListener(pnlDrawClickListener());
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		
		JPanel pnlWest = new JPanel();
		pnlWest.setBackground(Color.LIGHT_GRAY);
		pnlWest.repaint();
		contentPane.add(pnlWest, BorderLayout.WEST);
		pnlWest.setLayout(new GridLayout(0, 1));
		
		JPanel pnlDrawSelect = new JPanel();
		pnlWest.add(pnlDrawSelect);
		
		JToggleButton tglbtnDraw = new JToggleButton("Draw");
		pnlDrawSelect.add(tglbtnDraw);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		pnlDrawSelect.add(tglbtnSelect);
		
		JPanel pnlModifyDelete = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlModifyDelete.getLayout();
		pnlWest.add(pnlModifyDelete);
		pnlModifyDelete.setPreferredSize(new Dimension(10,10));
		
		JToggleButton tglbtnModify = new JToggleButton("Modify");
		pnlModifyDelete.add(tglbtnModify);
		
		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		pnlModifyDelete.add(tglbtnDelete);
		
		JPanel pnlShapes = new JPanel();
		pnlWest.add(pnlShapes);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		GroupLayout gl_pnlShapes = new GroupLayout(pnlShapes);
		gl_pnlShapes.setHorizontalGroup(
			gl_pnlShapes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlShapes.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_pnlShapes.createParallelGroup(Alignment.LEADING)
						.addComponent(tglbtnDonut)
						.addComponent(tglbtnCircle)
						.addComponent(tglbtnRectangle)
						.addComponent(tglbtnLine)
						.addComponent(tglbtnPoint))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_pnlShapes.setVerticalGroup(
			gl_pnlShapes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlShapes.createSequentialGroup()
					.addComponent(tglbtnPoint)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tglbtnLine)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tglbtnRectangle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tglbtnCircle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tglbtnDonut)
					.addGap(183))
		);
		pnlShapes.setLayout(gl_pnlShapes);
	}
	
	private MouseAdapter pnlDrawClickListener() {
		
	}
}
