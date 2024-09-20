package geometry;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		/* Point test 
		Point p1 = new Point();
		p1.setX(3);
		p1.setY(5);
		p1.setSelected(true);
		
		System.out.println("x p1: " + p1.getX());
		System.out.println("y p1: " + p1.getY());
		System.out.println("selected p1: " + p1.getSelected());
		
		Point p2 = new Point();
		p2.setX(13);
		p2.setY(15);
		p2.setSelected(true);
		
		System.out.println("Udaljenost je: " + p1.distance(p2.getX(), p2.getY()));
		p1.setX(p2.getX());
		System.out.println("Udaljenost je: " + p1.distance(p2.getX(), p2.getY()));
		*/
		
		/* Line test
		Point A = new Point();
		A.setX(3);
		A.setY(5);
		Point B = new Point();
		B.setX(6);
		B.setY(6);
		
		Line l1 = new Line();
		l1.setStartPoint(A);
		l1.setEndPoint(B);
		
		System.out.println(l1.length());
		*/
		
		/* Rectangle test
		Point p1 = new Point();
		p1.setX(5);
		p1.setY(5);
		
		Rectangle r1 = new Rectangle();
		r1.setUpperLeftPoint(p1);
		r1.setWidth(30);
		r1.setHeight(15);
		System.out.println(r1.area());
		System.out.println(r1.circumference());
		*/
		
		/* Circle test
		Point p = new Point();
		p.setX(5);
		p.setY(5);
		
		Circle c1 = new Circle();
		c1.setCenter(p);
		c1.setRadius(10);
		c1.setSelected(true);
		
		System.out.println(c1.area());
		System.out.println(c1.circumference());
		*/
		
		/*
		//vezbe 3 zadaci i domaci
		Point point1 = new Point();
		Point point2 = new Point();
		Line line1 = new Line();
		
		point1.setX(5); //4
		point1.setY(3);
		point2.setX(6);
		point2.setY(4);
		
		point1.setX(point2.getY());
		
		line1.setStartPoint(point1); 
		line1.setEndPoint(point2); // line 1 = (4,3),(6,4)
		
		System.out.println(line1.getStartPoint().getX()); // 4
		System.out.println(line1.getEndPoint().getY()); // 4
		
		System.out.println(line1.getEndPoint().getY()); // 4
		line1.getEndPoint().setY(23); 
		System.out.println(line1.getEndPoint().getY());// 23
		
		line1.getStartPoint().setX(line1.getEndPoint().getY());
		System.out.println(line1.getStartPoint().getX()); //23
		
		System.out.println(point1.getX() + " " + point2.getY()); //23 23 zato sto se menjalo gore preko line1 endpoint i startpoint
		
		System.out.println(line1.getEndPoint().getX()); //startPoint = (23,3), endPoint = (6,23)
		System.out.println(line1.getEndPoint().getY());
		System.out.println(line1.getStartPoint().getX());
		System.out.println(line1.getStartPoint().getY());
		
		line1.getEndPoint().setX((int)(line1.length() - (line1.getStartPoint().getX() + line1.getStartPoint().getY()))); //26 - 46
		System.out.println(line1.getEndPoint().getX());
		
		
		Rectangle rect1 = new Rectangle();
		Circle circle1 = new Circle();
		
		rect1.setUpperLeftPoint(point2); // mora, zato sto onda je upperLeftPoint null
		rect1.getUpperLeftPoint().setX(10);
		rect1.getUpperLeftPoint().setY(15);
		
		circle1.setCenter(rect1.getUpperLeftPoint());
		
		rect1.setHeight(10);
		rect1.setWidth(20);
		circle1.getCenter().setX((int)rect1.area() - line1.getStartPoint().getY());
		System.out.println(circle1.getCenter().getX());
		
		
		//vezbe 4 zadatak
		System.out.println("End point: " + line1.getEndPoint().getX() + " " + line1.getEndPoint().getY());
		System.out.println("Start point: " + line1.getStartPoint().getX() + " " + line1.getStartPoint().getY());
		circle1.setRadius(10);
		circle1.getCenter().setX((int)(circle1.getRadius() + line1.getStartPoint().distance(line1.getEndPoint().getX(), line1.getEndPoint().getY())));
		System.out.println("Circle center: " + circle1.getCenter().getX() + " " + circle1.getCenter().getY());
		*/
		
		/* testiranje konstruktora
		Point p1 = new Point(10,12);
		Point p2 = new Point(11,7,true);
		System.out.println(p2.isSelected() + " " + p1.getX());
		
		Line l1 = new Line(p1, p2);
		System.out.println("(" + l1.getEndPoint().getX() + ", " + l1.getEndPoint().getY() + ")");
		
		Rectangle r1 = new Rectangle(p1, 15, 10);
		System.out.println("Rectangle area: " + r1.area());
		System.out.println(r1.getUpperLeftPoint().getX());	
		*/
		
		/* testiranje redefinisane toString() metode
		Point p = new Point(3,4);
		System.out.println(p.toString());
		Point p2 = new Point(6,7);
		Line l = new Line(p,p2);
		System.out.println(l.toString());
		Rectangle r = new Rectangle(p2,20,15);
		System.out.println(r.toString());
		*/
		
		/* testiranje redefinisane equals() metode
		Point p = new Point(5,5);
		Point p2 = new Point(5,5);
		System.out.println(p == p2);
		System.out.println(p.equals(p2));
		
		Point p3 = new Point(3,1);
		Line l1 = new Line(p,p2);
		Line l2 = new Line(p,p2);
		System.out.println(l1.equals(l2));
		
		Rectangle r1 = new Rectangle(p,10,15);
		Rectangle r2 = new Rectangle(p3,10,15);
		System.out.println(r1.equals(r2));
		*/
		
		/* testiranje toString() i equals() za Circle
		Point p = new Point(2,2);
		Circle c = new Circle(p,5);
		System.out.println(c.toString());
		Circle c2 = new Circle(p,5);
		System.out.println(c.equals(c2));
		*/
		
		/* testiranje contains()
		Point p = new Point(2,2);
		System.out.println(p.contains(2, 1));
		Point p1 = new Point(3,3);
		Line l = new Line(p,p1);
		System.out.println(l.contains(2, 4));
		
		Rectangle r = new Rectangle(p,10,10);
		System.out.println(r.contains(6, 1));
		*/
		
		/* testiranje contains(Point)
		Point p = new Point(3,3);
		Rectangle r = new Rectangle(p,10,10);
		System.out.println(r.contains(new Point(2,3)));
		
		Circle c = new Circle(p,5);
		System.out.println(c.contains(2, 1));
		System.out.println(c.contains(new Point(4,4)));
		*/
		
		/* Testiranje Donut i svih njegovih metoda i konstruktora
		Point p = new Point(2,2);
		Donut d = new Donut(p,10,3);
		System.out.println(d.contains(new Point(5,5)));
		
		System.out.println(d.area());
		System.out.println(d.toString());
		System.out.println(d.contains(5, 5));
		System.out.println(d.equals(new Donut(new Point(2,2),10,3)));
		*/
		
		/* Testiranje Moveable (moveBy i moveTo)
		Point p = new Point(2,2);
		p.moveBy(4, 1);
		System.out.println(p);
		
		Line l = new Line(p, new Point(6,6));
		System.out.println(l);
		l.moveBy(1, 2);
		System.out.println(l);
		l.moveTo(1, 1);
		System.out.println(l);
		System.out.println(p);
		
		Rectangle r = new Rectangle(p, 20, 10);
		r.moveTo(4, 4);
		System.out.println(r);
		r.moveBy(6, 6);
		System.out.println(r);
		
		Donut d = new Donut(p,10,2);
		d.moveTo(2, 2);
		System.out.println(d);
		d.moveBy(4, 1);
		System.out.println(d);
		*/
		
		/* Testiranje Comparable
		Point p = new Point(10,10);
		int n = p.compareTo(new Point(15,15));
		System.out.println(n);
		*/
		
		/* testiranje nizova
		Rectangle rec1 = new Rectangle(new Point(10,10), 20, 15);
		Rectangle rec2 = new Rectangle(new Point(5,6), 30, 10);
		Rectangle rec3 = new Rectangle(new Point(9,1), 12, 19);
		
		Rectangle[] rectangles = {rec1, rec2, rec3};
		
		for(int i = 0; i < rectangles.length; i++) {
			System.out.println(rectangles[i]);
		}
		
		Arrays.sort(rectangles);
		System.out.println("\n");
		for(int i = 0; i < rectangles.length; i++) {
			System.out.println(rectangles[i]);
		}
	`	*/	
		/*
		Donut d1 = new Donut(new Point(5,5), 10, 5);
		Donut d2 = new Donut(new Point(5,5), 10, 2);
		Donut d3 = new Donut(new Point(5,5), 10, 7);
		
		Donut[] donuts = {d1, d2, d3};
		for (int i = 0; i < donuts.length; i++) {
			System.out.println(donuts[i]);
		}
		Arrays.sort(donuts);
		System.out.println("\n");
		for (int i = 0; i < donuts.length; i++) {
			System.out.println(donuts[i]);
		}
		*/
	}

}
