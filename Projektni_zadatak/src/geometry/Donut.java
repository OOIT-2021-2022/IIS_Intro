package geometry;

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
	
	public int getInnerRadius() {
		return this.innerRadius;
	}
	
	public void setInnerRadiius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public String toString() {
		return super.toString() + ", innerRadius=" + this.innerRadius;
 	}
}
