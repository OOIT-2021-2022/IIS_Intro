package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends SurfShape {

	protected Point center;
	private int radius;

	public Circle() {
	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		this.selected = selected;
	}
	
	public Circle(Point center, int radius, boolean selected, Color color) {
		this(center, radius, selected);
		this.setColor(color);
	}
	
	public Circle(Point center, int radius, boolean selected, Color color, Color innerColor) {
		this(center, radius, selected, color);
		this.setInnerColor(innerColor);
	}

	public double area() {
		return this.radius * this.radius * Math.PI;
	}

	public double circumference() {
		return (this.radius + this.radius) * Math.PI;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) throws Exception {
		if(radius < 0) {
			throw new Exception("Radius ne sme biti manji od 0.");
		}
		
		this.radius = radius;
		
	
	}

	public String toString() {
		return "Center:" + " " + center + ", radius: " + radius;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle pomocna = (Circle) obj;
			if (this.center.equals(pomocna.center) && this.radius == pomocna.radius)
				return true;
			else
				return false;
		}
		 else
			return false;
	}
	
	public boolean contains (int x, int y) {
		return center.distance(x, y) <= radius;
	}
	
	public boolean contains (Point p) {
		return center.distance(p.getX(), p.getY()) <= radius;
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius);
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - radius - 2, 4, 4);
			g.drawRect(center.getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + radius - 2, 4, 4);
			g.setColor(Color.black);
		}
		
	}
	
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
		
	}

	@Override
	public void moveBy(int x, int y) {
		center.moveBy(x, y);
		
		
	}
	
	public int compareTo(Object o) {
		
		if(o instanceof Circle) {
			return (int)(this.area() - ((Circle)o).area());
		}
		
		return 0;
	}

	@Override
	public void fill(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getInnerColor());
		g.fillOval(this.center.getX() - this.radius + 1, this.center.getY() - this.radius + 1, this.radius*2 - 2, 
				this.radius*2 - 2);
		
	}

	
	
	

}
