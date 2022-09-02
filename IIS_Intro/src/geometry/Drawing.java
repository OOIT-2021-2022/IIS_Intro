package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {
	
	public static void main (String[] args){
		
		JFrame frame = new JFrame("Drawings");
		frame.setSize(800, 600);
		frame.setVisible(true);
		
		Drawing draw = new Drawing();
		frame.getContentPane().add(draw);
	}

	@Override
	public void paint(Graphics g) {
		
		Point p = new Point (50,50);
		p.draw(g);
		
		Line l1 = new Line (new Point (100,100), new Point (200,200));
		l1.draw(g);
		
		Rectangle r1 = new Rectangle(l1.getEndPoint(),100,50);
		r1.draw(g);
		
		Circle c1 = new Circle (new Point(500,100), 80);
		c1.draw(g);
		
		Donut d1 = new Donut (new Point (800,100), 50, 25);
		d1.draw(g);
		
		Rectangle k1 = new Rectangle (new Point(500,500), 50, 50);
		k1.draw(g);
		
		int inneR = (int)(k1.getHeight()*Math.sqrt(2)/2);
		Donut d2 = new Donut(new Point(k1.getUpperLeftPoint().getX() + k1.getWidth()/2, k1.getUpperLeftPoint().getY() + k1.getWidth()/2), 80, inneR);
		g.setColor(Color.GREEN);
		d2.draw(g);
	
	
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	shapes.add(p);
	shapes.get(0).draw(g);
	shapes.add(l1);
	shapes.add(c1);
	shapes.add(d1);
	shapes.add(k1);
	Iterator<Shape> it = shapes.iterator();

	while (it.hasNext()) {
		Shape sh = it.next();
		sh.moveBy(10, 0);
		System.out.println(sh);
	}
	
	shapes.get(3).draw(g);

	shapes.get(shapes.size() - 1).draw(g);

	shapes.remove(1);
	
	shapes.get(1).draw(g);

	shapes.get(3).draw(g);

	shapes.add(3, l1);
	
	
	try {
		c1.setRadius(-10);
		System.out.println("try");
	} catch (Exception e) {
		//e.printStackTrace();
		System.out.println(e.getMessage());
	}
	
	it = shapes.iterator();
	while (it.hasNext()) {
		Shape sh = it.next();
		sh.moveBy(10, 0);
		sh.setSelected(true);
		sh.draw(g);
	}
	
	
	
	
	
	}
	
}
