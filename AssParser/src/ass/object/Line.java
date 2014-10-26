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
	
	public void buildExtras(Style lineStyle,float frameRate,Meta meta){
		duration = endTime - startTime;
		midTime = startTime + (duration>>1);
		dur = duration;
		text = AssTag.strip(kText);
		i = lineCount;
		styleRef = lineStyle;
		TextExtents textExtents = new TextExtents(text, lineStyle);
		width = textExtents.getWidth();
		height = textExtents.getHeight();
	
		int actualMarginL = this.marginL > 0 ? this.marginL : lineStyle.marginL;
		int actualMarginR = this.marginR > 0 ? this.marginR : lineStyle.marginR;
		int actualMarginV = this.marginV > 0 ? this.marginV : lineStyle.marginV;
		
		// alignment 1,4,7
		if( (lineStyle.align-1)%3 == 0 ){
			left = (float)actualMarginL;
			right = left + width;
			center = left + width / 2.0f;
		}
		
		// alignment 2,5,8 
		if( (lineStyle.align-2)%3 ==0 ) {
			left = (meta.width - actualMarginL - actualMarginR - width) / 2 + actualMarginL;
			right = left + width;
			center = left + width / 2.0f;
		}
		
		//alignment 3,6,9
		if( lineStyle.align%3==0 ) {
			left = meta.width - actualMarginR - width;
			right = left + width / 2;
			center = left  + width / 2.0f;
		}
		
		// process top bottom middle
		if(lineStyle.align >=1 && lineStyle.align <=3) {
			bottom = meta.height - actualMarginV;
			middle = bottom -height / 2.0f;
			top = bottom - height;
		}
		if(lineStyle.align >=4 && lineStyle.align <=6) {
			bottom = ( meta.height - height ) / 2.0f;
			middle = bottom - height / 2.0f;
			top = bottom - height;
		}
		if(lineStyle.align >=7 && lineStyle.align <=9) {
			bottom = actualMarginV + height;
			middle = bottom - height / 2.0f;
			top = bottom - height;
		}
	}
	
	public Line clone(){
		Line line  = null;
		try {
			line = (Line)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		line.styleRef = styleRef.clone();  
		line.syls = new ArrayList<Syl>( );
		line.chars = new ArrayList<Char>( );
		for(int i=0; i<syls.size(); i++) {
			line.syls.add(syls.get(i).clone());
		}
		for(int i=0; i<chars.size(); i++) {
			line.chars.add(chars.get(i).clone());
		}
		return line;
	}
}