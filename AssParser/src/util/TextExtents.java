package util;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.util.Hashtable;
import java.util.Map;
import ass.object.Style;

public class TextExtents {
	private float height;
	private float width;
	private float ascent;
	private float descent;
	private float leading;
	 
	public TextExtents(String text,Style style) {
		int fontStyle = Font.PLAIN;
		
		if (style.bold) {
			fontStyle = fontStyle | Font.BOLD;
		}
		
		if (style.italic) {
			fontStyle = fontStyle | Font.ITALIC;
		}
		
		Font font = new Font(style.fontName, fontStyle, style.fontSize);
		BufferedImage bufferedImage = new BufferedImage(128, 128,BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D graphics2d = bufferedImage.createGraphics();
		FontMetrics fontMetrics = graphics2d.getFontMetrics(font);
		height = fontMetrics.getHeight();
		width = fontMetrics.stringWidth(text);
		ascent = fontMetrics.getAscent();
		descent = fontMetrics.getDescent();
		leading = fontMetrics.getLeading();
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
