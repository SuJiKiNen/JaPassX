package ass.object;

public class Char implements Cloneable{
	// time info
	public int startTime; 
	public int endTime;
	public int midTime;
	public int duration;
	public int dur;

	// position info
	public float left;
	public float top;
	public float right;
	public float bottom;
	public float center;
	public float middle;
	public float x;
	public float y;

	// size info
	public float height;
	public float width;
	public String text;
	
	// reference info
	public Style styleRef;
	public Syl sylRef;
	public Line lineRef;
	
	public Char clone(){
		Char c = null;
		try {
			c = (Char)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		c.styleRef = styleRef.clone();
		c.sylRef = sylRef.clone();
		c.lineRef = lineRef.clone();
		return c;
	}
}
