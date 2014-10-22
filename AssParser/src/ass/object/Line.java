package ass.object;
import java.util.ArrayList;
import java.util.regex.Pattern;

import util.AssTime;


public class Line {
	static int lineCount;
	
	// time information
	public int startTime;
	public int midTime;
	public int endTime;
	public int duration;
	public int dur;
	public int inGap;
	public int outGap;
	/***************/

	// position and size infomation
	public int marginL;
	public int marginR;
	public int marginV;
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
	/******************/

	// other infomation
	public String kText;
	public String text;
	public String rawText;
	
	public String style;
	public Style styleRef;
	
	public int i;
	public int layer;
	
	public String actor;
	public String effect;
	
	ArrayList<Syl> syls;
	
	/*****************/

	public Line(String s) {
		// add check
		++lineCount;
		s = s.substring(10);
		Pattern p = Pattern.compile(",");
		String[] items = p.split(s);
		layer = Integer.parseInt(items[0]);
		startTime = new AssTime(items[1]).toMillis();
		endTime = new AssTime(items[2]).toMillis();
		midTime = (startTime + endTime) >> 1;
		duration = endTime - startTime;
		dur =  duration;
		
		style = items[3];
		actor = items[4];
		marginL = Integer.parseInt(items[5]);
		marginR = Integer.parseInt(items[6]);
		marginV = Integer.parseInt(items[7]);
		effect = items[8];
		kText = items[9];
		this.rawText =  s;
		
		this.i = lineCount;
		
		// build syls
		syls = new ArrayList<Syl>();
		
	}

}