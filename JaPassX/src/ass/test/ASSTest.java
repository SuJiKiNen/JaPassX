package ass.test;

import java.util.ArrayList;

import ass.object.ASS;
import ass.object.ASSParser;
import ass.object.Line;
import ass.object.Syl;
import ass.object.TextUnit;
import ass.object.Time;
import ass.util.Filter;
import ass.util.TextUnits;

public class ASSTest {

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
					if(textUnit.time.start>500) {
						return true;
					}
					return false;
				}
			});
			for(Line line: lines) {
				System.out.println(line.time.start+" "+line.text);
			}
			/*
	        for(int i=0; i<lines.length; i++) {
	        	Line line = lines[i];
	        	System.out.println( line.time.start + " " + line.text );
	        }*/
	}
}
