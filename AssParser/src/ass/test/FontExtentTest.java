package ass.test;
import ass.object.Line;
import ass.object.Style;
import ass.util.TextExtents;

public class FontExtentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Style style = new Style("Style: Default2,仿宋,30,&H0BFFFFFF,&H000000FF,&H00000000,&H00000000,0,0,0,0,100,100,0,0,1,0,0,5,0,0,10,1");
		Line line = new Line("Dialogue: 0,0:00:00.00,0:00:05.00,Default2,,0,0,0,karaoke,舸123",23.976f);
		
		// size infomation seems wrong
		TextExtents textExtents = new TextExtents(line.text, style);
		System.out.println("text is "+line.text);
		System.out.println(line.text.length());
		System.out.println("size is "+style.fontSize);
		System.out.println("height is "+textExtents.getHeight());
		System.out.println("width is "+textExtents.getWidth());
		System.out.println("ascent is "+textExtents.getAscent());
		System.out.println("descent is "+textExtents.getDescent());
		System.out.println("leading is "+textExtents.getLeading());
	}
}
