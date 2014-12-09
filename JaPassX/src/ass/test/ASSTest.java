package ass.test;

import ass.object.ASS;
import ass.object.ASSParser;
import ass.object.Line;
import ass.object.Syl;
import ass.object.TextUnit;
import ass.object.Time;

public class ASSTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ASS ass = ASSParser.parseFile("G:\\FXWorks\\idolm\\idolm-furigana - 4processing.ass");
		
		Line[] lines = ass.getLines();
		//Time.shift(lines,20);
		
		for(Line line: lines) {
			System.out.println(line.time.start+" "+line.text);
		}
	}
}
