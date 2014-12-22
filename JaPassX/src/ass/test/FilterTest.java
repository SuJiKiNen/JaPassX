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
	
		TextUnits.filter(lines, new Filter() {
			
			@Override
			public boolean accept(TextUnit textUnit) {
				// TODO Auto-generated method stub
				if(textUnit.startTime>12) {
					return true;
				}
				return false;
			}
		});

	}

}
