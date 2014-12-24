package ass.object;

public class Point {
	public float x;
	public float y;
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public Point(float x,float y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	
	public Point(Size size) {
		this.x = size.width;
		this.y = size.height;
	}
	public Point midPoint(Point p){
		float newX = this.x + (p.x-this.x)/2.0f;
		float newY = this.y + (p.y-this.y)/2.0f;
		p.x = newX;
		p.y = newY;
		return p;
	}
}
