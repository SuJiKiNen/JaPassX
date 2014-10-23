package ass.object;
import java.util.ArrayList;
import java.util.regex.Pattern;

import util.AssTag;
import util.AssTime;
import util.TextExtents;


public class Line implements Cloneable{
	static int lineCount;
	
	public int layer;
	public int startTime;
	public int endTime;
	public String style;
	public String actor;
	public int marginL;
	public int marginR;
	public int marginV;
	public String effect;
	public String kText;
	
	public int midTime;
	public int duration;
	public int dur;
	public int inGap;
	public int outGap;

	public float width;
	public float height;
	public float left;
	public float top;
	public float right;
	public float bottom;
	public float center;
	public float middle;
	public float x;
	public float y;

	public String text;
	public String rawText;
	public Style styleRef;
	public int i;

	ArrayList<Syl> syls;
	ArrayList<Char> chars;
	
	public Line(String s) {
		// add check
		++lineCount;
		s = s.substring(10);
		Pattern p = Pattern.compile(",");
		String[] items = p.split(s);
		layer = Integer.parseInt(items[0]);
		startTime = new AssTime(items[1]).toMillis();
		endTime = new AssTime(items[2]).toMillis();
		style = items[3];
		actor = items[4];
		marginL = Integer.parseInt(items[5]);
		marginR = Integer.parseInt(items[6]);
		marginV = Integer.parseInt(items[7]);
		effect = items[8];
		kText = items[9];
		rawText =  s;
	}
	
	public void BuildOtherBasics(Style style){
		midTime = (startTime + endTime) >> 1;
		duration = endTime - startTime;
		dur = duration;
		text = AssTag.clean(kText);
		i = lineCount;
		styleRef = style;
	}
	
	public void BuildPositions(Style style) {
		
	}
	
	public void BuildSizes(Style style) {
		
	}
	
	public void BuildSyls(Style style) {
		
	}
	
	public void BuildChars(Style style) {
		
	}
	
}