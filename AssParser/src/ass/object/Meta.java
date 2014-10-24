package ass.object;

// TODO: Auto-generated Javadoc
/**
 * The Class Meta.
 */
public class Meta implements Cloneable{
	
	/** The height. */
	public float height;
	
	/** The width. */
	public float width;
	
	public float getHeight() {
		return height;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}
	
	public float getWidth() {
		return width;
	}
	
	public void setWidth(float width) {
		this.width = width;
	}
	public Meta clone(){
		Meta meta = null;
		try {
			meta = (Meta)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return meta;
	}
	
}
