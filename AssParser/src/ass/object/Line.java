package ass.object;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ass.util.AssTag;
import ass.util.AssTime;
import ass.util.Regex;
import ass.util.TextExtents;


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
	public float frameRate;

	public String text;
	public String rawText;
	public Style styleRef;
	public int i;
	
	public ArrayList<Syl> syls;
	public ArrayList<Char> chars;
	
	public Line(String s,float frameRate) {
		// add check
		this.frameRate = frameRate;
		++lineCount;
		s = s.substring(10);
		Pattern p = Pattern.compile(",");
		String[] items = p.split(s);
		layer = Integer.parseInt(items[0]);
		startTime = new AssTime(items[1]).toFrame(frameRate);
		endTime = new AssTime(items[2]).toFrame(frameRate);
		style = items[3];
		actor = items[4];
		marginL = Integer.parseInt(items[5]);
		marginR = Integer.parseInt(items[6]);	
		marginV = Integer.parseInt(items[7]);
		effect = items[8];
		kText = items[9];
		rawText =  s;
		text = AssTag.strip(kText);
	}
	
	public void createExtras(Style lineStyle,Meta meta){
		duration = endTime - startTime;
		midTime = startTime + (duration>>1);
		dur = duration;
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
		x = center;	
		y = top+textExtents.getAscent();
		createSyls();
		createChars();
	}
	public void createSyls( ){
		syls = new ArrayList<Syl>();
		Pattern p = Pattern.compile("\\{(.*?)\\\\([kK][of]?)(\\d+)(.*?)\\}([^{]*)");
		Matcher matcher = p.matcher(kText);
		int sylCount = 0;
		int start2Syl = 0;
		float currentX = this.left;
		while (matcher.find()) {
			Syl syl = new Syl();
			++sylCount;
			syl.kTag = matcher.group(2);
			syl.duration = new AssTime( Integer.parseInt(matcher.group(3))*10 ).toMillis();
			syl.dur = syl.duration;
			syl.sText = matcher.group(5);
			syl.startTime = start2Syl+this.startTime;
			syl.endTime = syl.startTime + syl.dur;
			syl.syl2End = this.dur - syl.endTime;
			syl.start2Syl = start2Syl;
			start2Syl+=syl.dur;
			
			String preSpaceReg = "^([\\s"+Regex.UNICODE_SPACES+"]*)";
			String PostSpaceReg = "([\\s"+Regex.UNICODE_SPACES+"]*)$";
			String textReg = "(.*?)";
			Pattern headTailSpacePattern = Pattern.compile(preSpaceReg + textReg + PostSpaceReg);
			Matcher headTailSpaceMatcher = headTailSpacePattern.matcher(syl.sText);
			if(headTailSpaceMatcher.find()) {
				syl.preSpace = headTailSpaceMatcher.group(1);
				syl.text = headTailSpaceMatcher.group(2);
				syl.postSpace = headTailSpaceMatcher.group(3);
			}else {
				
			}
			TextExtents textExtents = new TextExtents(syl.preSpace, styleRef);
			currentX = currentX + textExtents.getWidth();
			syl.left = currentX;
			
			textExtents = new TextExtents(syl.text, styleRef);
			syl.height = textExtents.getHeight();
			syl.width = textExtents.getWidth();
			currentX = currentX + syl.width;
			
			textExtents = new TextExtents(syl.postSpace, styleRef);
			currentX = currentX + textExtents.getWidth();
			
			syl.right = syl.left + syl.width;
			syl.top = top;
			syl.bottom = bottom;
			syl.center = syl.left + syl.width/2.0f;
			syl.middle = syl.top + syl.height/2.0f;
			syl.i = sylCount;
			syl.li = i;
			syl.styleRef = styleRef.clone();
			syls.add(syl);
		}
	}
	
	public void createChars(){
		chars = new ArrayList<Char>();
		for(int i=0; i<syls.size(); i++) {
			Syl syl = syls.get(i);
			float curX = syl.left;
			for(int j=0; j<syl.text.length(); j++) {
				Char c = new Char();
				c.startTime = syl.start2Syl;
				c.endTime = syl.endTime;
				c.midTime = syl.midTime;
				c.duration = c.endTime - startTime;
				c.dur = c.duration;
				c.text = String.valueOf( syl.text.charAt(j) );
				TextExtents textExtents = new TextExtents(c.text, syl.styleRef);
				c.width = textExtents.getWidth();
				c.height = textExtents.getHeight();
				c.top = syl.top;
				c.bottom = syl.bottom;
				c.left = curX;
				c.right = c.left + c.width;
				curX = c.right;
				c.center = c.left + c.width/2.0f;
				c.middle = c.top + c.height/2.0f;
				c.styleRef = syl.styleRef.clone();
				c.sylRef = syl.clone();
				chars.add(c);
			}
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

	public  Syl[] getSyls() {
		return syls.toArray(new Syl[ syls.size() ]);
	}

	public Char[] getChars() {
		return chars.toArray(new Char[ chars.size() ]);
	}

}