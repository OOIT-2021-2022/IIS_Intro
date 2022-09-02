package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	private Point startPoint;
	private Point endPoint;

	public Line() {
	}

	public Line(Point startPoint, Point endPoint) {
		this.endPoint = endPoint;
		this.startPoint = startPoint;
	}

	public Line(Point startPoint, Point endPoint, Color color) {
		this(startPoint, endPoint);
		this.setColor(color);
	}
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected, Color color) {
		this(startPoint, endPoint, selected);
		this.setColor(color);
		
	}
	
	public double length() {
		return this.startPoint.distance(this.endPoint.getX(), this.endPoint.getY());
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getStartPoint() {
		return this.startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public String toString() {
		return startPoint + "-->" + endPoint;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line pomocna = (Line) obj;
			if (this.startPoint.equals(pomocna.startPoint) && this.endPoint.equals(pomocna.endPoint))
				return true;
			else
				return false;
		} else
			return false;

	}

	public boolean contains(int x, int y) {
		return (this.startPoint.distance(x, y) + this.endPoint.distance(x, y) - length()) <= 2;
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.startPoint.getX() - 2, this.startPoint.getY() - 2 , 4, 4);
			g.drawRect(this.endPoint.getX() - 2, this.endPoint.getY() - 2, 4, 4);
			g.setColor(Color.black);
			
		}
		
	}

	@Override
	public void moveTo(int x, int y) {
		//nije moguce implementirati
		
	}

	@Override
	public void moveBy(int x, int y) {
		startPoint.moveBy(x, y);
		endPoint.moveBy(x, y);
		
	}
	
	public int compareTo(Object o) {
		if (o instanceof Line) {	
		return (int)(this.length() - ((Line)o).length()) ;
		}
		return 0;
	}
	
	
	

}
