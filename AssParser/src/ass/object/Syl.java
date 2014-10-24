package ass.object;

public class Syl implements Cloneable{
	// time info
	public int startTime;
	public int endTime;
	public int midTime;
	public int duration;
	public int start2Syl;
	public int syl2End;

	// position info
	public float left;
	public float top;
	public float right;
	public float bottom;
	public float center;
	public float middle;
	public float x;
	public float y;

	// text and size info
	public float height;
	public float width;
	public String kText;
	public String text;
	
	public int i; 
	public Style styleRef;
	public Syl clone(){
		Syl syl = null;
		try {
			syl = (Syl)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		syl.styleRef = styleRef.clone();
		return syl;
	}
}