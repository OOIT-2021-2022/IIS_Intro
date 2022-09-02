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
import geometry.SurfShape;

import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;

public class FrmDrawing extends JFrame {

	private final int OPERATION_DRAWING = 1;
	private final int OPERATION_EDIT_DELETE = 1;
	
	private int activeOperation = OPERATION_DRAWING;
	
	private PnlDrawing pnlDrawing = new PnlDrawing();
	private ButtonGroup btnsOperation = new ButtonGroup();
	private ButtonGroup btnsShapes = new ButtonGroup();
	private JToggleButton btnOperationDrawing = new JToggleButton("Drawing");
	private JToggleButton btnOperationEditOrDelete = new JToggleButton("Select");
	private JButton btnActionEdit = new JButton("Modify");
	private JButton btnActionDelete = new JButton("Delete");
	private JToggleButton btnPoint = new JToggleButton("Point");
	private JToggleButton btnLine = new JToggleButton("Line");
	private JToggleButton btnRectangle = new JToggleButton("Rectangle");
	private JToggleButton btnCircle = new JToggleButton("Circle");
	private JToggleButton btnDonut = new JToggleButton("Donut");
	private JButton btnColorEdge = new JButton("Edge color");
	private JButton btnColorInner = new JButton("Inner color");
	
	private Color edgeColor = Color.BLACK, innerColor = Color.WHITE;
	boolean lineWaitingForEndPoint = false;
	private Point startPoint;
	
	private JPanel contentPane;
	
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
		setTitle("Ivan Stankovic, IT-22/2020");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlDrawing = new JPanel();
		pnlDrawing.addMouseListener(pnlDrawingClickListener());
		contentPane.add(pnlDrawing, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JToggleButton btnOperationDrawing = new JToggleButton("Drawing");
		btnOperationDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperationDrawing();
			}
		});
		btnOperationDrawing.setSelected(true);
		btnsOperation.add(btnOperationDrawing);
		panel_1.add(btnOperationDrawing);
		
		JToggleButton btnOperationEditorDelete = new JToggleButton("Select");
		btnOperationEditorDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperationEditDelete();
			}
		});
		btnsOperation.add(btnOperationEditorDelete);
		panel_1.add(btnOperationEditorDelete);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JButton btnActionEdit = new JButton("Modify");
		btnActionEdit.setEnabled(false);
		panel_2.add(btnActionEdit);
		
		JButton btnActionDelete = new JButton("Delete");
		btnActionDelete.setEnabled(false);
		panel_2.add(btnActionDelete);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JToggleButton btnPoint = new JToggleButton("Point");
		btnsShapes.add(btnPoint);
		panel_3.add(btnPoint);
		
		JToggleButton btnLine = new JToggleButton("Line");
		btnsShapes.add(btnLine);
		panel_3.add(btnLine);
		
		JToggleButton btnRectangle = new JToggleButton("Rectangle");
		btnsShapes.add(btnRectangle);
		panel_3.add(btnRectangle);
		
		JToggleButton btnCircle = new JToggleButton("Circle");
		btnsShapes.add(btnCircle);
		panel_3.add(btnCircle);
		
		JToggleButton btnDonut = new JToggleButton("Donut");
		btnsShapes.add(btnDonut);
		panel_3.add(btnDonut);
		
		btnOperationDrawing.setSelected(true);
		setOperationDrawing();
		
		
	}
	
	private MouseAdapter pnlDrawingClickListener() {
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Point mouseClick = new Point(e.getX(), e.getY());
				pnlDrawing.deselect();
				
				if (activeOperation == OPERATION_EDIT_DELETE) {
					pnlDrawing.select(mouseClick);
					return;
				}
				
				if (btnPoint.isSelected()) {
					DlgPoint dlgPoint = new DlgPoint();
					dlgPoint.setPoint(mouseClick);
					dlgPoint.setColors(edgeColor);
					dlgPoint.setVisible(true);
					if(dlgPoint.getPoint() != null) pnlDrawing.addShape(dlgPoint.getPoint());
					return;
					
				} else if (btnLine.isSelected()) {
					if(lineWaitingForEndPoint) {
						
						DlgLine dlgLine = new DlgLine();
						Line line = new Line(startPoint,mouseClick);
						dlgLine.setLine(line);
						dlgLine.setColors(edgeColor);
						dlgLine.setVisible(true);
						if(dlgLine.getLine()!= null) pnlDrawing.addShape(dlgLine.getLine());
						lineWaitingForEndPoint=false;
						return;
					}
					startPoint = mouseClick;
					lineWaitingForEndPoint=true;
					return;
					
		
				} else if (btnRectangle.isSelected()) {
					DlgRectangle dlgRectangle = new DlgRectangle();
					dlgRectangle.setPoint(mouseClick);
					dlgRectangle.setColors(edgeColor, innerColor);
					dlgRectangle.setVisible(true);
					
					if(dlgRectangle.getRectangle() != null) pnlDrawing.addShape(dlgRectangle.getRectangle());
					return;
				} else if (btnCircle.isSelected()) {
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.setPoint(mouseClick);
					dlgCircle.setColors(innerColor, edgeColor);
					dlgCircle.setVisible(true);
					
					if(dlgCircle.getCircle() != null) pnlDrawing.addShape(dlgCircle.getCircle());
					return;
				} else if (btnDonut.isSelected()) {
					DlgDonut dlgDonut = new DlgDonut();
					dlgDonut.setPoint(mouseClick);
					dlgDonut.setColors(edgeColor, innerColor);
					dlgDonut.setVisible(true);
					
					if(dlgDonut.getDonut() != null) pnlDrawing.addShape(dlgDonut.getDonut());
					return;
				}
			}
		};
	}
	
	private ActionListener btnActionEditClickListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = pnlDrawing.getSelected();
				if (index == -1) return;
				
				Shape shape = pnlDrawing.getShape(index);
				
				if (shape instanceof Point) {
					DlgPoint dlgPoint = new DlgPoint();
					dlgPoint.setPoint((Point)shape);
					dlgPoint.setVisible(true);
					
					if(dlgPoint.getPoint() != null) {
						pnlDrawing.setShape(index, dlgPoint.getPoint());
						pnlDrawing.repaint();
					}
				} else if (shape instanceof Line) {
					DlgLine dlgLine = new DlgLine();
					dlgLine.setLine((Line)shape);
					dlgLine.setVisible(true);
					
					if(dlgLine.getLine() != null) {
						pnlDrawing.setShape(index, dlgLine.getLine());
						pnlDrawing.repaint();
					}
				} else if (shape instanceof Rectangle) {
					DlgRectangle dlgRectangle = new DlgRectangle();
					dlgRectangle.setRectangle((Rectangle)shape);
					dlgRectangle.setVisible(true);
					
					if(dlgRectangle.getRectangle() != null) {
						pnlDrawing.setShape(index, dlgRectangle.getRectangle());
						pnlDrawing.repaint();
					}
				
				}else if (shape instanceof Donut) {
						DlgDonut dlgDonut = new DlgDonut();
						dlgDonut.setDonut((Donut)shape);
						dlgDonut.setVisible(true);
						
						if(dlgDonut.getDonut() != null) {
							pnlDrawing.setShape(index, dlgDonut.getDonut());
							pnlDrawing.repaint();
						}
				} else if (shape instanceof Circle) {
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.setCircle((Circle)shape);
					dlgCircle.setVisible(true);
					
					if(dlgCircle.getCircle() != null) {
						pnlDrawing.setShape(index, dlgCircle.getCircle());
						pnlDrawing.repaint();
					}
				} 
			}
		};
	}
	
	private ActionListener btnActionDeleteClickListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pnlDrawing.isEmpty()) return;
				if (JOptionPane.showConfirmDialog(null, "Are you sure that you want to delete the selected shape?", "Yes", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) pnlDrawing.removeSelected(); 
			}
		};
	}
	

	private ActionListener btnColorEdgeClickListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "Choose edge color", edgeColor);
				if (edgeColor == null) edgeColor = Color.BLACK;
			}
		};
	}
	
	private ActionListener btnColorInnerClickListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerColor = JColorChooser.showDialog(null, "Choose inner color", innerColor);
				if (innerColor == null) innerColor = Color.WHITE;
			}
		};
	}

	private void setOperationDrawing() {
		activeOperation = OPERATION_DRAWING;
		
		pnlDrawing.deselect();
		
		btnActionEdit.setEnabled(false);
		btnActionDelete.setEnabled(false);
		
		btnPoint.setEnabled(true);
		btnLine.setEnabled(true);
		btnRectangle.setEnabled(true);
		btnCircle.setEnabled(true);
		btnDonut.setEnabled(true);
		
		btnColorEdge.setEnabled(true);
		btnColorInner.setEnabled(true);
	
	}
	
	private void setOperationEditDelete() {
		activeOperation = OPERATION_EDIT_DELETE;
		
		btnActionEdit.setEnabled(true);
		btnActionDelete.setEnabled(true);
		
		btnPoint.setEnabled(false);
		btnLine.setEnabled(false);
		btnRectangle.setEnabled(false);
		btnCircle.setEnabled(false);
		btnDonut.setEnabled(false);
		
		btnColorEdge.setEnabled(false);
		btnColorInner.setEnabled(false);
	
	}

	
}
