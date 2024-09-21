package drawing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

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
	private boolean isLineDrawing = false;
	private final ButtonGroup btnGroupDrawSelect = new ButtonGroup();
	private final ButtonGroup btnGroupShapes = new ButtonGroup();
	private static final int SHAPE_NONE = 0;
	private static final int SHAPE_POINT = 1;
	private static final int SHAPE_LINE = 2;
	private static final int SHAPE_RECTANGLE = 3;
	private static final int SHAPE_CIRCLE = 4;
	private static final int SHAPE_DONUT = 5;
	private Shape selectedShape = null;
	private static final int MODE_DRAW = 1;
	private static final int MODE_SELECT = 2;
	
	
	JToggleButton tglbtnDraw = new JToggleButton("Draw");
	JToggleButton tglbtnSelect = new JToggleButton("Select");
	JButton btnModify = new JButton("Modify");
	JButton btnDelete = new JButton("Delete");
	JToggleButton tglbtnPoint = new JToggleButton("Point");
	JToggleButton tglbtnLine = new JToggleButton("Line");
	JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
	JToggleButton tglbtnCircle = new JToggleButton("Circle");
	JToggleButton tglbtnDonut = new JToggleButton("Donut");
	
	private int currentMode = MODE_DRAW;
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
		setDefaultDrawMode();

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pnlDrawing = new PnlDrawing();
		pnlDrawing.addMouseListener(pnlDrawClickListener());
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		
		JPanel pnlWest = new JPanel();
		pnlWest.setBackground(Color.BLACK);
		pnlWest.repaint();
		contentPane.add(pnlWest, BorderLayout.WEST);
		pnlWest.setLayout(new GridLayout(0, 1));
		
		JPanel pnlDrawSelect = new JPanel();
		pnlWest.add(pnlDrawSelect);
		
		tglbtnDraw.setSelected(true);
		tglbtnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnDraw.isSelected()) {
					currentMode = MODE_DRAW;
					setDefaultDrawMode();
				}
				else {
					currentMode = MODE_SELECT;
				}
			}
		});
		pnlDrawSelect.add(tglbtnDraw);
		
		tglbtnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnSelect.isSelected()) {
					btnModify.setEnabled(true);
					btnDelete.setEnabled(true);
					disableDrawButtons();
					currentMode = MODE_SELECT;
				}
				else{
					enableDrawButtons();
					btnModify.setEnabled(false);
					btnDelete.setEnabled(false);
				}
			}
		});
		
		pnlDrawSelect.add(tglbtnSelect);
		
		JPanel pnlModifyDelete = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlModifyDelete.getLayout();
		pnlWest.add(pnlModifyDelete);
		pnlModifyDelete.setPreferredSize(new Dimension(10,10));
		btnModify.addActionListener(btnModifyListener());
		
		pnlModifyDelete.add(btnModify);
		btnDelete.addActionListener(btnDeleteListener());
		
		pnlModifyDelete.add(btnDelete);
		
		JPanel pnlShapes = new JPanel();
		pnlWest.add(pnlShapes);
		
		tglbtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShapeMode = SHAPE_POINT;
			}
		});
		
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShapeMode = SHAPE_LINE;
			}
		});
		
		tglbtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShapeMode = SHAPE_RECTANGLE;
			}
		});
		
		tglbtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShapeMode = SHAPE_CIRCLE;
			}
		});
		
		tglbtnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentShapeMode = SHAPE_DONUT;
			}
		});
		
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
		
		pnlShapes.setBackground(Color.GRAY);
		pnlDrawSelect.setBackground(Color.GRAY);
		pnlModifyDelete.setBackground(Color.GRAY);
		
	}
	
	private MouseAdapter pnlDrawClickListener() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point clickedPoint = new Point(e.getX(), e.getY());
				pnlDrawing.deselect();
				
				if (currentMode == MODE_DRAW) {
		
				switch(currentShapeMode) {
				
				case SHAPE_POINT:
					
						DlgPoint dlgPoint = new DlgPoint();
						dlgPoint.setPoint(clickedPoint);
						dlgPoint.setVisible(true);
						dlgPoint.setColor(edgeColor);
						if(dlgPoint.isOk()) {
							Point point = dlgPoint.getPoint();
							pnlDrawing.addShape(point);
						}
						break;
		
				case SHAPE_LINE:
						if(!isLineDrawing) {
						startPoint = clickedPoint;
						isLineDrawing = true; 
					} 	
						else {
							DlgLine dlgLine = new DlgLine();
							dlgLine.setStartPoint(startPoint);
							dlgLine.setEndPoint(clickedPoint);
							dlgLine.setVisible(true);
							dlgLine.setColor(edgeColor);
							if(dlgLine.isOk()) {
								Line line = dlgLine.getLine();
								pnlDrawing.addShape(line);
							}
							isLineDrawing = false;
							startPoint = null;
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
					}
					break;
				
				case SHAPE_DONUT:
					DlgDonut dlgDonut = new DlgDonut();
					dlgDonut.setPoint(clickedPoint);
					dlgDonut.setVisible(true);
					dlgDonut.setColors(edgeColor, innerColor);
					if(dlgDonut.isOk()) {
						Donut donut = dlgDonut.getDonut();
						pnlDrawing.addShape(donut);
						
					}
					break;
				}
		}else if(currentMode == MODE_SELECT) {
			pnlDrawing.select(clickedPoint);
			return;
		}
				
		};
		};
	}
	
	private ActionListener btnModifyListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = pnlDrawing.getSelected();
				if (index == -1) 
					return;
				
				Shape shape = pnlDrawing.getShape(index);
				
				if (shape instanceof Point) {
					DlgPoint dlgPoint = new DlgPoint();
					dlgPoint.setPoint((Point)shape);
					dlgPoint.setVisible(true);
					
					if(dlgPoint.isOk()) {
						pnlDrawing.setShape(index, dlgPoint.getPoint());
						
					}
			}
				else if (shape instanceof Line) {
					DlgLine dlgLine = new DlgLine();
					dlgLine.setLine((Line)shape);
					dlgLine.setVisible(true);
					if(dlgLine.isOk()) {
						pnlDrawing.setShape(index, dlgLine.getLine());
						
					}
				}
				
				else if (shape instanceof Rectangle) {
					DlgRectangle dlgRectangle = new DlgRectangle();
					dlgRectangle.setRectangle((Rectangle)shape);
					dlgRectangle.setVisible(true);
					if(dlgRectangle.isOk()) {
						pnlDrawing.setShape(index, dlgRectangle.getRectangle());
						
					}
				}
				
				else if (shape instanceof Circle) {
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.setCircle((Circle)shape);
					dlgCircle.setVisible(true);
					if(dlgCircle.isOk()) {
						pnlDrawing.setShape(index, dlgCircle.getCircle());
					}
				}
				
				// Modify Donut
				else if (shape instanceof Donut) {
					DlgDonut dlgDonut = new DlgDonut();
					dlgDonut.setDonut((Donut)shape);
					dlgDonut.setVisible(true);
					if(dlgDonut.isOk()) {
						pnlDrawing.setShape(index, dlgDonut.getDonut());
					}
				}
				// Modify Donut
		}
	};
	};
	
	private ActionListener btnDeleteListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = pnlDrawing.getSelected();
				if(index == -1) { 
					JOptionPane.showMessageDialog(null, "Please select a shape to delete.", "No Shape Selected", JOptionPane.WARNING_MESSAGE);
					return;
				}
				int confirmation = JOptionPane.showConfirmDialog(null, 
						"Are you sure you want to delete the selected shape?", 
						"Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(confirmation == JOptionPane.YES_OPTION) {
					pnlDrawing.removeSelected();
				}
			}
		};
	}
	
	private void disableDrawButtons() {
		tglbtnPoint.setEnabled(false);
		tglbtnLine.setEnabled(false);
		tglbtnCircle.setEnabled(false);
		tglbtnDonut.setEnabled(false);
		tglbtnRectangle.setEnabled(false);
	}
	
	private void enableDrawButtons() {
		tglbtnPoint.setEnabled(true);
		tglbtnLine.setEnabled(true);
		tglbtnCircle.setEnabled(true);
		tglbtnDonut.setEnabled(true);
		tglbtnRectangle.setEnabled(true);
	}
	
	private void setDefaultDrawMode() {
		enableDrawButtons();
		btnModify.setEnabled(false);
		btnDelete.setEnabled(false);
	}
	
	
}
