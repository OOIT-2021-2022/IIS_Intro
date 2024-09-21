package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends SurfaceShape {
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
	
	public Rectangle(Point upperLeftPoint, int width, int height, Color color) {
		this(upperLeftPoint, width, height);
		this.setColor(color);
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected, Color color) {
		this(upperLeftPoint, width, height, selected);
		this.setColor(color);
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, Color color, Color innerColor) {
		this(upperLeftPoint, width, height, color);
		this.setInnerColor(innerColor);
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected, Color color, Color innerColor) {
		this(upperLeftPoint, width, height, selected);
		this.setColor(color);
		this.setInnerColor(innerColor);
	}
	
	public double area() {
		return this.width * this.height;
	}
	
	public int circumference() {
		return this.width * 2 + this.height * 2;
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

	@Override
	public void moveTo(int x, int y) {
		upperLeftPoint.moveTo(x, y);
	}

	@Override
	public void moveBy(int x, int y) {
		upperLeftPoint.moveBy(x, y);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		this.fill(g);
		
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(upperLeftPoint.getX()-2, upperLeftPoint.getY()-2, 4, 4);
			g.drawRect(upperLeftPoint.getX()-2, upperLeftPoint.getY()+height-2, 4, 4);
			g.drawRect(upperLeftPoint.getX()-2+width, upperLeftPoint.getY()-2, 4, 4);
			g.drawRect(upperLeftPoint.getX()-2+width, upperLeftPoint.getY()+height-2, 4, 4);
			g.setColor(Color.BLACK);
		}
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			Rectangle recToCompare = (Rectangle)o;
			return (int)(this.area() - recToCompare.area());
		}
		return 0;
	}

	@Override
	public void fill(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getInnerColor());
		g.fillRect(upperLeftPoint.getX()+1, upperLeftPoint.getY()+1, width-1, height-1);
	}
	
}
