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
		g.drawOval(center.getX()-innerRadius, center.getY()-innerRadius, innerRadius*2, innerRadius*2);
		
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
}
