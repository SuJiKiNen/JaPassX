package ass.test;

import java.util.ArrayList;

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
		
			for(int i=0; i<ass.lines.size(); i++) {
				Line line = ass.lines.get(i);
				//Time.shift(line,20);
				System.out.println(ass.lines.get(i).startTime);
			}
	}
}
