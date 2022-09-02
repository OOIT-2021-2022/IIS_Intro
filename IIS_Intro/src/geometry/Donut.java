package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle{
	
	private int innerRadius;
	
	public Donut() {}
	
	public Donut(Point center, int radius, int innerRadius) {
		// this.setCenter(center); ako je u Circle center private, ako je protected onda moze i this.center = center;
		// this.setRadius(radius);
		// this.center = center;
		// this.radius = radius;
		super(center,radius); //!!!! super
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center,radius,innerRadius);
		setSelected(selected);
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color) {
		this(center, radius, innerRadius, selected);
		setColor(color);
	}
	

	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color, Color innerColor) {
		this(center, radius, innerRadius, selected, color);
		setInnerColor(innerColor);
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public double area() {
		return super.area() - this.innerRadius * Math.PI;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut pomocna = (Donut) obj;
			if (this.center.equals(pomocna.center) && this.getRadius() == pomocna.getRadius() && this.innerRadius == pomocna.innerRadius)
				return true;
			else
				return false;
		}
		 else
			return false;
	}
	
	// center moze da se pozove zato sto je protected, radius nije protected pa mora da se pozove metoda getRadius()
	
	public String toString() {
		return "Center:" + " " + center + ", radius: " + getRadius() + ", inner radius: " + innerRadius;
	}
	
	public boolean contains (Point p) {
		if(center.distance(p.getX(), p.getY()) <= getRadius() && center.distance(p.getX(),p.getY()) >= innerRadius)
			return true;
		else
			return false;
	}
	
	public boolean contains (int x, int y) {
		if(center.distance(x, y) <= getRadius() && center.distance(x,y) >= innerRadius)
			return true;
		else
			return false;
			
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(center.getX() - innerRadius, center.getY() - innerRadius, 2 * innerRadius, 2 * innerRadius);
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - getRadius() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - getRadius() - 2, 4, 4);
			g.drawRect(center.getX() + getRadius() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + getRadius() - 2, 4, 4);
			g.drawRect(center.getX() - innerRadius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - innerRadius - 2, 4, 4);
			g.drawRect(center.getX() + innerRadius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + innerRadius - 2, 4, 4);
			g.setColor(Color.black);
		}
	}
	
	public int compareTo(Object o) {
		
		if(o instanceof Donut) {
			return (int)(this.area() - ((Donut)o).area());
		}
		
		return 0;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		super.fill(g);
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(getCenter().getX() - this.innerRadius,
				getCenter().getY() - this.innerRadius,
				this.innerRadius * 2 - 2, 
				this.innerRadius * 2 - 2);
	}
	
	
	
	
}
