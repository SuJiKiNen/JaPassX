package ass.object;

import java.util.regex.Pattern;

import ass.util.ASSColor;


public class Style implements Cloneable{
	public String name;
	public String fontName;
	public int fontSize;
	public String color1;
	public String color2;
	public String color3;
	public String color4;
	public boolean bold;
	public boolean italic;
	public boolean underline;
	public boolean strikeout;
	public float scaleX;
	public float scaleY;
	public float spacing;
	public float angle;
	public int borderstyle;
	public float outline;
	public float shadow;
	public int align;
	public int marginL;
	public int marginR;
	public int marginV;
	public String encoding;
	
	public Style(String s) {
		s = s.substring(7);
		Pattern p = Pattern.compile(",");
		String[] items = p.split(s);
		name = items[0];
		fontName =  items[1];
		fontSize = Integer.parseInt(items[2]);
		color1 = new ASSColor(items[3]).toString();
		color2 = new ASSColor(items[4]).toString();
		color3 = new ASSColor(items[5]).toString();
		color4 = new ASSColor(items[6]).toString();
		bold = (Integer.parseInt(items[7]) == -1);
		italic = (Integer.parseInt(items[8]) == -1);
		underline = (Integer.parseInt(items[9]) == -1);
		strikeout = (Integer.parseInt(items[10]) == -1);
		scaleX = Float.parseFloat(items[11]);
		scaleY = Float.parseFloat(items[12]);
		spacing = Float.parseFloat(items[13]);
		angle = Float.parseFloat(items[14]);
		borderstyle = Integer.parseInt(items[15]);
		outline = Float.parseFloat(items[16]);
		shadow = Float.parseFloat(items[17]);
		align = Integer.parseInt(items[18]);
		marginL = Integer.parseInt(items[19]);
		marginR = Integer.parseInt(items[20]);
		marginV = Integer.parseInt(items[21]);
		encoding = items[22];
	}
	public Style clone(){
		Style style = null;
		try {
			style = (Style)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return style;
	}
	@Override
	public String toString() {
		return "Style [name=" + name + ", fontName=" + fontName + ", fontSize="
				+ fontSize + ", color1=" + color1 + ", color2=" + color2
				+ ", color3=" + color3 + ", color4=" + color4 + ", bold="
				+ bold + ", italic=" + italic + ", underline=" + underline
				+ ", strikeout=" + strikeout + ", scaleX=" + scaleX
				+ ", scaleY=" + scaleY + ", spacing=" + spacing + ", angle="
				+ angle + ", borderstyle=" + borderstyle + ", outline="
				+ outline + ", shadow=" + shadow + ", align=" + align
				+ ", marginL=" + marginL + ", marginR=" + marginR
				+ ", marginV=" + marginV + ", encoding=" + encoding + "]";
	}
	
}
