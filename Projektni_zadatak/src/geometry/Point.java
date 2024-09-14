package geometry;

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
	
	
}
