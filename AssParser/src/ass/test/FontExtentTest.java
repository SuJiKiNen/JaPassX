package ass.test;
import ass.object.Line;
import ass.object.Meta;
import ass.object.Style;
import ass.util.TextExtents;

public class FontExtentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Style style = new Style("Style: JP,宋体,50,&HFFFF0000,&H000000FF,&H00000000,&H00000000,-1,0,0,0,100,100,10,0,1,4,0,2,0,0,32,1");
		Line line = new Line("Dialogue: 0,0:00:00.00,0:00:05.99,JP,,0,0,0,fx,{\\kf43}繰{\\kf26}り{\\kf57}返{\\kf62}す{\\kf33}世{\\kf47}界{\\kf0} {\\kf34}何{\\kf52}度{\\kf26}手{\\kf42}を{\\kf11}{\\kf28}伸{\\kf28}ば{\\kf25}し{\\kf24}た{\\kf61}ら",23.976f);
		line.createExtras(style, new Meta(1280,720));
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
		System.out.println(line.startTime);
		for(int i=0; i<line.syls.size(); i++) {
			System.out.println(i+" "+line.syls.get(i).startTime);
		}
	}
}
