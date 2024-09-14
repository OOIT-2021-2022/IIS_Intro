package geometry;

import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	private static final long serialVersionUID = 1L;

	public Drawing() {
	}
	
	public static void main(String args[]) {
		JFrame frame = new JFrame ("Drawing");
		frame.setSize(800, 600);
		JPanel drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
		
	}
	
	public void paint(Graphics g) {
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
	}
}
