package ass.util;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.image.BufferedImage;
import ass.object.Style;

public class TextExtents {
	private final static int SCALE=64;
	private float height;
	private float width;
	private float ascent;
	private float descent;
	private float leading;
	public TextExtents(String text,Style style) {
		/* text extents get wrong when mixed plain with others
		int fontStyle = Font.PLAIN;
		
		if (style.bold) {
			fontStyle = (fontStyle + Font.BOLD);
		}
		
		if (style.italic) {
			fontStyle = (fontStyle + Font.ITALIC);
		}
		*/
		
		/* processing create font use filename or invoke new Font Constructor
		 * notice that processing invoke font constructor with PLAIN style 
		 * if we want a bold style(if font support) we must get font face name,not fixed yet
		 */
		//https://github.com/processing/processing/blob/bf8ca5c0f2072e25d89a733cef24358500fb62c0/core/src/processing/core/PFont.java#L893
		//https://github.com/processing/processing/blob/bf8ca5c0f2072e25d89a733cef24358500fb62c0/core/src/processing/core/PApplet.java#L6677
		//http://processing.org/reference/javadoc/core/processing/core/PFont.html
		Font font = new Font(style.fontName, Font.PLAIN, style.fontSize*SCALE);
		//System.out.println("AssFont family is "+style.fontName);
		//System.out.println("logic name "+font.getName());
		//System.out.println("font face name"+font.getFontName());
		//System.out.println("Ps Name"+font.getPSName());
		BufferedImage bufferedImage = new BufferedImage(128, 128,BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D graphics2d = bufferedImage.createGraphics();
		graphics2d.setFont(font);
		
		FontRenderContext fontRenderContext = graphics2d.getFontRenderContext();
		FontMetrics fontMetrics = graphics2d.getFontMetrics();		
		LineMetrics lineMetrics = font.getLineMetrics(text, fontRenderContext);
		width = (float)( fontMetrics.stringWidth(text) +style.spacing*text.length()*SCALE)/(float)SCALE;
		//System.out.println(fontMetrics.stringWidth(text));
		ascent = lineMetrics.getAscent()/(float)SCALE;
		descent = lineMetrics.getDescent()/(float)SCALE;
		leading = lineMetrics.getLeading()/(float)SCALE;
		height = ( lineMetrics.getAscent() + lineMetrics.getDescent() )/(float)SCALE;
		/*
		FontMetrics fontMetrics = graphics2d.getFontMetrics(font);
		height = fontMetrics.getHeight();
		width = fontMetrics.stringWidth(text);
		ascent = fontMetrics.getAscent();
		descent = fontMetrics.getDescent();
		leading = fontMetrics.getLeading();
		*/
	}

	public float getHeight() {
		return height;
	}

	public float getWidth() {
		return width;
	}

	public float getAscent() {
		return ascent;
	}

	public float getDescent() {
		return descent;
	}

	public float getLeading() {
		return leading;
	}
}
