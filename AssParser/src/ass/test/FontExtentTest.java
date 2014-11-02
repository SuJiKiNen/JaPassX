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
		Style style = new Style("Style: JP,宋体,50,&HFFFF0000,&H000000FF,&H00000000,&H00000000,-1,0,0,0,100,100,0,0,1,4,0,2,0,0,32,1");
		Line line = new Line("Dialogue: 0,0:00:00.00,0:00:05.99,JP,,0,0,0,fx,繰り返す世界 何度手を伸ばしたら",23.976f);
		
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
