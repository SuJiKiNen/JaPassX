package ass.object;


public class Syl extends TextUnit implements Cloneable{
	// time info
	public int start2Syl;
	public int syl2End;
	// text and size info
	public String sText;
	public String preSpace;
	public String postSpace;
	public String kTag;
	
	public int li;
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

	@Override
	public String toString() {
		return "Syl [startTime=" + startTime + ", endTime=" + endTime
				+ ", midTime=" + midTime + ", text=" + text + ", i=" + i + "]";
	}
	
}