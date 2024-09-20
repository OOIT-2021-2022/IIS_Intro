package drawing;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Shape;

public class PnlDrawing extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	/**
	 * Create the panel.
	 */
	public PnlDrawing() {
		
	}
	
	public void paint(Graphics g) {
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			it.next().draw(g);
		}
		
	}
}
