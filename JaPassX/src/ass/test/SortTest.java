package ass.test;

import java.util.Arrays;
import java.util.Comparator;

import ass.object.ASS;
import ass.object.ASSParser;
import ass.object.Line;
import ass.object.Syl;
import ass.util.TextUnits;

public class SortTest {
	public static void main(String [] args){
		ASS ass = ASSParser.parseFile("G:\\FXWorks\\idolm\\idolm-furigana - 4processing.ass");
		Line lines[] = ass.getLines();
		TextUnits.sort(lines,new Comparator<Line>() {
			@Override
			public int compare(Line l1,Line l2){
				return Integer.compare(l1.startTime, l2.startTime);
			}
		});
		for(Line line: lines) {
			System.out.println(line.time.start+" "+line.text);
		}
		Syl syls[] = lines[0].getSyls();
		for(Syl syl: syls) {
			System.out.println(syl.i+" "+syl.text);
		}
		TextUnits.sort(syls, new Comparator<Syl>() {
			@Override
			public int compare(Syl s1,Syl s2) {
				return s1.text.compareTo(s2.text);
			}
		});
		for(Syl syl: syls) {
			System.out.println(syl.i+" "+syl.text);
		}
	}
}
