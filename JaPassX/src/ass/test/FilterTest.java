package ass.test;

import java.util.ArrayList;

import ass.object.ASS;
import ass.object.ASSParser;
import ass.object.Line;
import ass.object.Syl;
import ass.object.TextUnit;
import ass.util.Filter;
import ass.util.TextUnits;

public class FilterTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ASS ass = ASSParser.parseFile("G:\\FXWorks\\idolm\\idolm-furigana - 4processing.ass");
		Line lines[] = ass.getLines();
		lines = TextUnits.filterBlank(lines);
		for(Line line: lines) {
			System.out.println(line.time.start+" "+line.text);
		}
	}

}
