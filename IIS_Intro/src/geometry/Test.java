package geometry;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		/*
		// TODO Auto-generated method stub
		Point p = new Point();
		// System.out.println(p.x); nije moguce, zbog private
		// System.out.println(p.getX() + " " + p.getY() + " " + p.isSelected());

		p.setX(10);
		p.setY(10);
		/*
		 * p.setSelected(true); System.out.println(p.getX() + " " + p.getY() + " " +
		 * p.isSelected()); double d = p.distance(40, 50); System.out.println(d);
		 */

		Point p1 = new Point();
		p1.setX(15);
		p1.setY(27);
		p1.setSelected(true);
		Line l1 = new Line();
		Rectangle r1 = new Rectangle();
		Circle c1 = new Circle();

		l1.setEndPoint(p1);

		l1.getEndPoint().setY(23);

		l1.getStartPoint().setX(l1.getEndPoint().getY());

		l1.getEndPoint().setX((int) (l1.length() - (l1.getStartPoint().getX() + l1.getStartPoint().getY())));

		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);
		r1.setWidth(20);
		r1.setHeight(30);

		c1.setCenter(r1.getUpperLeftPoint());

		c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());

		Point p2 = new Point(50, 100);
		
		Line l2 = new Line(p2,new Point(400,500));
		
		Rectangle r2 = new Rectangle(p2,100,500);
		
		
		System.out.println(p2);
		System.out.println(l1);
		System.out.println(c1);
		
		Point p3 = new Point(20,30);
		Line l4 = new Line(p2, p3);
		Line l5 = new Line(p2, p3);
		
		System.out.println(l4.equals(l5));
		
		Circle c3 = new Circle(p2,50);
		Circle c4 = new Circle(p2,50);
		
		System.out.println(c3.equals(c4));
		
		System.out.println("\nVezbe 7 - testiranje metoda");
		
		System.out.println(p1);
		p1.moveBy(3, 5);
		System.out.println(p1);
		p1.moveTo(3, 5);
		System.out.println(p1);
		
		System.out.println(l1);
		l1.moveBy(3, 5);
		System.out.println(l1);
		l1.moveTo(3, 5);
		System.out.println(l1);
		
		System.out.println(r1);
		r1.moveBy(3, 5);
		System.out.println(r1);
		r1.moveTo(3, 5);
		System.out.println(r1);
		
		
		Shape d8 = new Donut(p1, 10, 5);
		Shape p9 = new Point();
		Shape l9 = l1;
		Shape c9 = c1;
		Shape[] shapes = {d8, p9, l9, c9};
		for(int i=0; i<shapes.length;i++) {
			System.out.println(shapes[i]);
		}
		
		for(int i=0; i<shapes.length;i++) {
			shapes[i].moveBy(1, 2);
			System.out.println(shapes[i]);
		}
		
		int[] ints = {5,6,2,3,1,4};
		for(int i=0; i<ints.length;i++) {
			System.out.println(ints[i]);
		}
		Arrays.sort(ints);
		for(int i=0; i<ints.length;i++) {
			System.out.println(ints[i]);
		}
		
		Point p10 = new Point(10, 10);
		Point p20 = new Point(20, 20);
		Point p30 = new Point(30, 30);
		Point p40 = new Point(40, 40);
		Point p50 = new Point(50, 50);
		Point[] points = {p20,p10,p50,p40,p30};
		for(int i=0; i<points.length;i++) {
			System.out.println(points[i]);
		}
		Arrays.sort(points);
		for(int i=0; i<points.length;i++) {
			System.out.println(points[i]);
			
		}
		
		
	}

}
