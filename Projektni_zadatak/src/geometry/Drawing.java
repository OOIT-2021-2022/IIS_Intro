package geometry;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	private static final long serialVersionUID = 1L;

	public Drawing() {
	}
	
	public static void main(String args[]) {
		JFrame frame = new JFrame ("Drawing frame");
		frame.setSize(800, 600);
		JPanel drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
		
	}
	
	public void paint(Graphics g) {
		/* drawing
		Point p = new Point(10,15);
		g.setColor(Color.red);
		p.draw(g);
		g.setColor(Color.blue);
		Line l = new Line(new Point(20,30), new Point(40,50));
		l.draw(g);
		g.setColor(Color.black);
		Donut d = new Donut(new Point(60,70), 50, 40, true);
		d.draw(g);
		Shape shape1 = new Point(50,60);
		shape1.draw(g);
		Shape shape2 = new Line(new Point(100, 100), new Point(200,200));
		shape2.draw(g);
		*/
		Point p = new Point(20,20, true);
		Line l = new Line(new Point(15,15), new Point(25,25), true);
		Circle c = new Circle(new Point(30,30), 15, true);
		Donut d = new Donut(new Point(10,10), 10, 2, true);
		Rectangle r = new Rectangle(new Point(12,12), 40, 20, true);
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(p);
		shapes.add(l);
		shapes.add(c);
		shapes.add(d);
		shapes.add(r);
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()) {
			Shape sh = it.next();
			sh.moveBy(10, 0);
			System.out.println(sh);
		}
		shapes.get(3).draw(g);
		shapes.get(shapes.size()-1).draw(g);
		shapes.remove(1);
		System.out.println(shapes);
		shapes.get(1).draw(g);
		shapes.get(3).draw(g);
		shapes.add(3, l);
		shapes.get(3).draw(g);
		
		try {
			c.setRadius(-10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		p.draw(g);
	}
}
