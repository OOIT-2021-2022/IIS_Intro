package geometry;

import java.awt.Graphics;

public class Rectangle extends Shape {
	private Point upperLeftPoint;
	private int width;
	private int height;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		this (upperLeftPoint, width, height);
		setSelected(selected);
	}
	
	public double area() {
		return this.width * this.height;
	}
	
	public int circumference() {
		return this.width * 2 + this.height * 2;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
	}
	
	public Point getUpperLeftPoint() {
		return this.upperLeftPoint;
	}
	
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public String toString() {
		return "Upper left point: " + "(" + this.upperLeftPoint.getX() + "," + this.getUpperLeftPoint().getY() + "), width = " + 
	this.width + ", height = " + this.height;
	}
	
	public boolean equals (Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle pomocna = (Rectangle) obj;
			if (this.getUpperLeftPoint().equals(pomocna.upperLeftPoint) 
				&& this.getWidth() == pomocna.getWidth() 
				&& this.getHeight() == pomocna.getHeight())
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean contains(int x, int y) {
		return this.getUpperLeftPoint().getX() <= x && this.getUpperLeftPoint().getY() <= y 
				&& this.getUpperLeftPoint().getX() + this.width >= x && this.getUpperLeftPoint().getY() + this.height >= y;
	}
	
	public boolean contains(Point clickPoint) {
		return this.getUpperLeftPoint().getX() <= clickPoint.getX() && this.getUpperLeftPoint().getY() <= clickPoint.getY() 
				&& this.getUpperLeftPoint().getX() + this.width >= clickPoint.getX() 
				&& this.getUpperLeftPoint().getY() + this.height >= clickPoint.getY();
	}
	
}
