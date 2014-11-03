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
	
	public float frameRate;
	public Meta(int width,int height,float frameRate){
		this.width = width;
		this.height = height;
		this.frameRate = frameRate;
	}
	
	public Meta(int width,int height) {
		this.width = width;
		this.height = height;
		this.frameRate = 23.976f;
	}
	
	public Meta(){
		this.width = 1280;
		this.height = 720;
		this.frameRate = 23.976f;
	}

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
