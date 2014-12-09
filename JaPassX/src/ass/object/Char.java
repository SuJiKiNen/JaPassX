package ass.object;


public class Char extends TextUnit implements Cloneable{
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
