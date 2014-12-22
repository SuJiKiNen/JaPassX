package ass.object;

public class Size extends Dimension{
	public Size(float width,float height) {
		this.width = width;
		this.height = height;
	}
	public Size(Size another) {
		this.width  = another.width;
		this.height = another.height;
	}
}
