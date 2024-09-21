package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Point;
import geometry.Shape;

public class PnlDrawing extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private int i;

	/**
	 * Create the panel.
	 */
	public PnlDrawing() {
		
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
		repaint();
	}
	
	public void deselect() {
		shapes.forEach(shape -> shape.setSelected(false));
		repaint();
	}
	
	public void select(Point point) {
		for (i = shapes.size()-1; i >= 0; i--) {
			if (shapes.get(i).contains(point.getX(), point.getY())) {
				shapes.get(i).setSelected(true);
				repaint();
				return;
			}
		}
	}
	
	public int getSelected() {
		for(int i = 0; i < shapes.size(); i++) {
			if(shapes.get(i).isSelected()) {
				return i;
			}
		}
		return -1;
	}
	
	public Shape getShape(int index) {
		return shapes.get(index);
	}
	
	public void setShape(int index, Shape shape) {
		shapes.set(index, shape);
	}
	
	public void removeSelected() {
	    for (int i = shapes.size() - 1; i >= 0; i--) {
	        if (shapes.get(i).isSelected()) {
	            shapes.remove(i);
	        }
	    }
	    repaint();
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			it.next().draw(g);
		}
		
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
}
