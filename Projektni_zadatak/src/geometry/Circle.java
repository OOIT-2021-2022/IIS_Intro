package geometry;

import java.awt.Graphics;

public class Circle extends Shape{
	protected Point center;
	private int radius;
	private boolean selected;
	
	public Circle() {
		
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this (center, radius);
		setSelected(selected);
	}
	
	public double circumference() {
		return 2 * this.radius * Math.PI;
	}
	
	public double area() {
		return this.radius * this.radius * Math.PI;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
	}
	
	public Point getCenter() {
		return this.center;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public String toString() {
		return "Center=" + center + ", radius=" + radius;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle pomocna = (Circle) obj;
			if(this.center.equals(pomocna.center) && this.radius == pomocna.radius)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean contains(int x, int y) {
		return center.distance(x, y) <= radius;
	}
	
	public boolean contains(Point clickPoint) {
		return center.distance(clickPoint.getX(), clickPoint.getY()) <= radius;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}
