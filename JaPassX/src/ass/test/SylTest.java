package ass.test;

import ass.object.ASS;
import ass.object.ASSParser;
import ass.object.Line;
import ass.object.Syl;

public class SylTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ASS ass = ASSParser.parseFile("G:\\FXWorks\\idolm\\idolm-furigana - 4processing.ass");
		Line [] lines = ass.getLines();
		Line line = lines[0];
		System.out.println(line.text);
		Syl [] syls = line.getSyls();
		for(Syl syl:syls) {
			System.out.println(syl.text);
		}
	}

}
