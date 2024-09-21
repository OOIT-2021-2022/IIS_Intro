package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle{
	private int innerRadius;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super (center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		super (center, radius, selected); //moze this.center = center ako nije private nego protected u Circle
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, Color color) {
		super(center, radius);
		this.innerRadius = innerRadius;
		this.setColor(color);
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color) {
		super (center, radius, selected);
		this.innerRadius = innerRadius;
		this.setColor(color);
	}
	
	public Donut(Point center, int radius, int innerRadius, Color color, Color innerColor) {
		super (center, radius);
		this.innerRadius = innerRadius;
		this.setColor(color);
		this.setInnerColor(innerColor);
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color, Color innerColor) {
		super (center, radius, selected);
		this.innerRadius = innerRadius;
		this.setColor(color);
		this.setInnerColor(innerColor);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut pomocna = (Donut) obj;
			if(super.equals(pomocna) && this.innerRadius == pomocna.innerRadius)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean contains(int x, int y) {
		return super.contains(x, y) && this.center.distance(x, y) >= this.innerRadius;
	}
	
	public boolean contains(Point clickPoint) {
		return super.contains(clickPoint) && clickPoint.distance(this.getCenter().getX(), this.getCenter().getY()) >= this.innerRadius;
	}
	
	public double area() {
		return super.area() - this.innerRadius * this.innerRadius * Math.PI;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(getColor());
		g.drawOval(getCenter().getX() - this.innerRadius, getCenter().getY() - this.innerRadius, this.innerRadius*2, this.innerRadius*2);
		this.fill(g);
		
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX()-2, center.getY()-2, 4, 4);
			g.drawRect(center.getX()-innerRadius-2, center.getY()-2, 4, 4);
			g.drawRect(center.getX()-2+innerRadius, center.getY()-2, 4, 4);
			g.drawRect(center.getX()-2, center.getY()-innerRadius-2, 4, 4);
			g.drawRect(center.getX()-2, center.getY()+innerRadius-2, 4, 4);
		}
	}
	
	public int getInnerRadius() {
		return this.innerRadius;
	}
	
	public void setInnerRadiius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public String toString() {
		return super.toString() + ", innerRadius = " + this.innerRadius + ", area = " + String.format("%.2f", this.area());
 	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Donut) {
			Donut donutToCompare = (Donut)obj;
			return Double.compare(donutToCompare.area(), this.area());
		}	
		return 0;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		super.fill(g);
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(getCenter().getX() - this.innerRadius, getCenter().getY() - this.innerRadius, this.innerRadius * 2 - 2, this.innerRadius * 2 - 2);
	}

}
