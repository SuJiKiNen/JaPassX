package ass.test;

import ass.object.AssParser;
import ass.object.Line;

public class AssTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Line line = new Line("Dialogue: 0,0:00:00.00,0:00:05.00,Default,,0,0,0,,123ô´");
		System.out.print(line.kText);
		AssParser assParser = new AssParser(30);
		System.out.print(assParser.getFrameRate());
	}
	
}
