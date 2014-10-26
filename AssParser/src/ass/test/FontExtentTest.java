package ass.test;
import util.TextExtents;
import ass.object.Line;
import ass.object.Style;

public class FontExtentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Style style = new Style("Style: Default2,仿宋,30,&H0BFFFFFF,&H000000FF,&H00000000,&H00000000,0,0,0,0,100,100,0,0,1,0,0,5,0,0,10,1");
		Line line = new Line("Dialogue: 0,0:00:00.00,0:00:05.00,Default2,,0,0,0,,舸123");
		
		// size infomation seems wrong
		TextExtents textExtents = new TextExtents("　12", style);
		System.out.println(line.text);
		System.out.println(style.fontSize);
		System.out.println(textExtents.getHeight());
		System.out.println(textExtents.getWidth());
		System.out.println(textExtents.getAscent());
		System.out.println(textExtents.getDescent());
		System.out.println(textExtents.getLeading());
	}
}
