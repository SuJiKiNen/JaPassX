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
		Style style = new Style("Style: Default,·ÂËÎ,30,&H0BFFFFFF,&H000000FF,&H00000000,&H00000000,0,0,0,0,100,100,0,0,1,2,2,2,10,10,10,1");
		Line line = new Line("Dialogue: 0,0:00:00.00,0:00:05.00,Default,,0,0,0,fx,30 30.015625ô´");
		
		// size infomation seems wrong
		TextExtents textExtents = new TextExtents("ô´", style);
		System.out.println(style.fontSize);
		System.out.println(textExtents.getHeight());
		System.out.println(textExtents.getWidth());
		System.out.println(textExtents.getAscent());
		System.out.println(textExtents.getDescent());
		System.out.println(textExtents.getLeading());
	}
}
