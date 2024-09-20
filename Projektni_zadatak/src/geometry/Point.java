package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape{
	private int x;
	private int y;
	
	public Point() {
		
	}
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, boolean selected) {
		this(x, y);
		setSelected(selected);
	}
	
	public Point(int x, int y, Color color) {
		this(x,y);
		this.setColor(color);
	}
	
	public Point(int x, int y, boolean selected, Color color) {
		this(x,y,selected);
		this.setColor(color);
	}
	
	
	public double distance(int x, int y) {
		int dX = this.x - x;
		int dY = this.y - y;
		double d = Math.sqrt(dX*dX + dY*dY);
		return d;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(x - 2, y, x + 2, y);
		g.drawLine(x, y - 2, x, y + 2);
		
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(x-2, y-2, 4, 4);
			g.setColor(Color.BLACK);
		}
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")"; 
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point pomocna = (Point) obj;
			if (this.x == pomocna.x && this.y == pomocna.y)
				return true;
			else
				return false;
		}
		else
			return false;
		}
	
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 1;
	}

	@Override
	public void moveTo(int x, int y) {
		this.setX(x);
		this.y = y;
	}

	@Override
	public void moveBy(int x, int y) {
		this.setX(this.x + x);
		this.y += y;
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Point) {
			Point pointToCompare = (Point)obj;
			return (int)(this.distance(0, 0) - pointToCompare.distance(0, 0));
		}
		return 0;
	}
	
	
}
