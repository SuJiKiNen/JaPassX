package ass.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class AssColor.
 */
public class AssColor {
	/*
	 * web color notation. For example: color c = #006699 For hex notation,
	 * prefix the values with 0x, for instance color c = 0xCC006699. In that
	 * example, CC (the hex value of 204) is the alpha value, and the remainder
	 * is identical to a web color.
	 */
	/** The r. */
	public int r;
	
	/** The g. */
	public int g;
	
	/** The b. */
	public int b;
	
	/** The a. */
	public int a;
	private boolean hasAlpha;
	
	/**
	 * Instantiates a new ass color.
	 * 
	 * @param r
	 *            the r
	 * @param g
	 *            the g
	 * @param b
	 *            the b
	 */
	public AssColor(int r,int g,int b){
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	/**
	 * Instantiates a new ass color.
	 * 
	 * @param r
	 *            the r
	 * @param g
	 *            the g
	 * @param b
	 *            the b
	 * @param a
	 *            the a
	 */
	public AssColor(int r,int g,int b,int a){
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
		hasAlpha = true;
	}
	
	/**
	 * Instantiates a new ass color.
	 * 
	 * @param color
	 *            the color
	 */
	public AssColor(String color){
		Pattern pattern = Pattern.compile("^&h[0-9a-f]{8}$",Pattern.CASE_INSENSITIVE);
		Matcher matcher =  pattern.matcher(color);
		boolean match = matcher.matches();
		if (match) {
			a = Integer.parseInt(color.substring(2, 3));
			b = Integer.parseInt(color.substring(4, 5));
			g = Integer.parseInt(color.substring(6, 7));
			r = Integer.parseInt(color.substring(8, 9));
			// swap red and blue component
			int nb = r;
			int nr = b;
			b = nb;
			r = nr;
			// invert alpha value
			a = 255 - a;
			if(a!=255) {
				hasAlpha = true; 
			}
		}else{
			// excepiton
			throw new IllegalArgumentException("the format of color notation is wrong!");
		}
		
	}
	
	// return string format 2 fit with processing type;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String hexString="";
		if (hasAlpha)  {
			hexString = String.format("0x%02x%02x%02x%02x",a,r,g,b);
		}else {
			hexString = String.format("#%02x%02x%02x", r,g,b);
		}
		return hexString;
	}
}
