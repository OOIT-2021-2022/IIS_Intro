package geometry;


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
	}

}
