package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends SurfShape{

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
		this(upperLeftPoint, width, height);
		this.selected = selected;

	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected, Color color) {
		this(upperLeftPoint, width, height, selected);
		this.setColor(color);

	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, Color color, Color innerColor) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
		this.setColor(color);
		this.setInnerColor(innerColor);

	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected, Color color, Color innerColor) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
		this.selected = selected;
		this.setColor(color);
		this.setInnerColor(innerColor);
	}


	public int area() {
		return this.width * this.height;
	}

	public int circumference() {
		return 2 * this.width + 2 * this.height;
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean contains(int x, int y) {
		if (x >= upperLeftPoint.getX() && x <= upperLeftPoint.getX() + width) {
			if (y >= upperLeftPoint.getY() && y <= upperLeftPoint.getY() + height)
				return true;
			else
				return false;
		}
		else
			return false;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		this.fill(g);
		
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.upperLeftPoint.getX() - 2, this.upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(this.upperLeftPoint.getX() + width - 2, this.getUpperLeftPoint().getY() - 2, 4, 4);
			g.drawRect(this.upperLeftPoint.getX() - 2, this.getUpperLeftPoint().getY() + height - 2, 4, 4);
			g.drawRect(this.upperLeftPoint.getX() + width - 2, this.getUpperLeftPoint().getY() + height - 2, 4, 4);
			g.setColor(Color.black);
			
		}
		
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
	public int compareTo(Object o) {
		
		if(o instanceof Rectangle) {
			return this.area() - ((Rectangle)o).area();
		}
		
		return 0;
	}
	
	public String toString() {
		return "Upper left point:" + " " + upperLeftPoint + ", width: " + width + ", height: " + height;
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillRect(this.upperLeftPoint.getX() + 1,
				this.upperLeftPoint.getY() + 1,
				this.width - 1,
				this.height - 1);	
	}
	
	
	
	
	
	
	
	
	
}
