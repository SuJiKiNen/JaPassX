package ass.object;
import java.util.regex.Pattern;

import ass.util.AssTime;

public class Line {

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
	
	/*****************/

	public Line(String s) {
		// add check
		
		this.rawText =  s;
		
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
		/*
		 * for(String str : items) { System.out.println(str+"item"+i); }
		 */
	}

	int assTime2Ms(String format) {
		// to do add check
		format = format.replace(".", ":");
		Pattern p = Pattern.compile(":");

		String[] items = p.split(format);
		int h = Integer.parseInt(items[0]);
		int m = Integer.parseInt(items[1]);
		int s = Integer.parseInt(items[2]);
		int hs = Integer.parseInt(items[3]);
		int ms = hs * 10 + s * 1000 + m * 60000 + h * 3600000;
		return ms;
	}
	
}