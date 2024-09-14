package geometry;

public interface Moveable {
	
	void moveTo(int x, int y);  //moze i bez public abstract
	
	public abstract void moveBy(int x, int y);
}
