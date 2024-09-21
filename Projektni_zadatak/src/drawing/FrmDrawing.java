package drawing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDrawing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Color edgeColor = Color.BLACK;
	private Color innerColor = Color.WHITE;
	private PnlDrawing pnlDrawing;
	private Point startPoint = null;
	private Point endPoint = null; //for line
	private boolean isLineDrawing = false;
	private final ButtonGroup btnGroupDrawSelect = new ButtonGroup();
	private final ButtonGroup btnGroupShapes = new ButtonGroup();
	private static final int SHAPE_NONE = 0;
	private static final int SHAPE_POINT = 1;
	private static final int SHAPE_LINE = 2;
	private static final int SHAPE_RECTANGLE = 3;
	private static final int SHAPE_CIRCLE = 4;
	private static final int SHAPE_DONUT = 5;
	
	private int currentShapeMode = SHAPE_NONE;
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
		tglbtnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		pnlDrawSelect.add(tglbtnDraw);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		pnlDrawSelect.add(tglbtnSelect);
		
		JPanel pnlModifyDelete = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlModifyDelete.getLayout();
		pnlWest.add(pnlModifyDelete);
		pnlModifyDelete.setPreferredSize(new Dimension(10,10));
		
		JButton btnModify = new JButton("Modify");
		pnlModifyDelete.add(btnModify);
		
		JButton btnDelete = new JButton("Delete");
		pnlModifyDelete.add(btnDelete);
		
		JPanel pnlShapes = new JPanel();
		pnlWest.add(pnlShapes);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShapeMode = SHAPE_POINT;
			}
		});
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShapeMode = SHAPE_LINE;
			}
		});
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShapeMode = SHAPE_RECTANGLE;
			}
		});
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShapeMode = SHAPE_CIRCLE;
			}
		});
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		
		btnGroupDrawSelect.add(tglbtnDraw);
		btnGroupDrawSelect.add(tglbtnSelect);
		
		btnGroupShapes.add(tglbtnPoint);
		btnGroupShapes.add(tglbtnLine);
		btnGroupShapes.add(tglbtnRectangle);
		btnGroupShapes.add(tglbtnCircle);
		btnGroupShapes.add(tglbtnDonut);
		
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
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point clickedPoint = new Point(e.getX(), e.getY());
				switch(currentShapeMode) {
				
				case SHAPE_POINT:
					
						DlgPoint dlgPoint = new DlgPoint();
						dlgPoint.setPoint(clickedPoint);
						dlgPoint.setVisible(true);
						dlgPoint.setColor(edgeColor);
						if(dlgPoint.isOk()) {
							Point point = dlgPoint.getPoint();
							pnlDrawing.addShape(point);
							pnlDrawing.repaint();
						}
						break;
		
				case SHAPE_LINE:
						if(isLineDrawing) {
							DlgLine dlgLine = new DlgLine();
							
					}
						break;
				
				case SHAPE_RECTANGLE:
					DlgRectangle dlgRectangle = new DlgRectangle();
					dlgRectangle.setPoint(clickedPoint);
					dlgRectangle.setVisible(true);
					dlgRectangle.setColors(edgeColor, innerColor);
					if(dlgRectangle.isOk()) {
						Rectangle rectangle = dlgRectangle.getRectangle();
						pnlDrawing.addShape(rectangle);
						pnlDrawing.repaint();
					}
					break;
				case SHAPE_CIRCLE:
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.setPoint(clickedPoint);
					dlgCircle.setVisible(true);
					dlgCircle.setColors(edgeColor, innerColor);
					if(dlgCircle.isOk()) {
						Circle circle = dlgCircle.getCircle();
						pnlDrawing.addShape(circle);
						pnlDrawing.repaint();
					}
				
				}	
		}};
		
	}
	
	public void resetDrawingState() {
		currentShapeMode = SHAPE_NONE;
		startPoint = null;
		endPoint = null;
		isLineDrawing = false;
	}
}
