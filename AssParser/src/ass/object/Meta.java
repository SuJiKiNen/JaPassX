package ass.object;

// TODO: Auto-generated Javadoc
/**
 * The Class Meta.
 */
public class Meta implements Cloneable{
	
	/** The height. */
	public int height;
	
	/** The width. */
	public int width;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
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
