package ass.object;

public class Point {
	public float x;
	public float y;
	public float z;
	
	public Point() {
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
	}
	
	public Point(float x,float y) {
		this.x = x;
		this.y = y;
		this.z = 0.0f;
	}
	
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
		this.z = p.z;
	}
	
	public Point(Size size) {
		this.x = size.width;
		this.y = size.height;
		this.z = 0.0f;
	}
	public Point midPoint(Point p){
		float newX = this.x + (p.x-this.x)/2.0f;
		float newY = this.y + (p.y-this.y)/2.0f;
		float newZ = this.z + (p.z-this.z)/2.0f;
		p.x = newX;
		p.y = newY;
		p.z = newZ;
		return p;
	}
}
