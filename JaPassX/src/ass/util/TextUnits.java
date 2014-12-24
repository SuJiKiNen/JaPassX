package ass.util;

import ass.object.Char;
import ass.object.Line;
import ass.object.Syl;

public class TextUnits {
	public static Line [] filter(Line [] lines,Filter filter) {
		int j = 0;
		for(int i=0; i<lines.length; i++) {
			if(filter == null || filter.accept(lines[i])) {
				lines[j++] = lines[i];
			}
		}
		Line [] leftLines = new Line[j];
		System.arraycopy(lines,0,leftLines,0,j);
		return leftLines;
	}
	public static Syl [] filter(Syl [] syls,Filter filter) {
		int j = 0;
		for(int i=0; i<syls.length; i++) {
			if(filter == null || filter.accept(syls[i])) {
				syls[j++] = syls[i];
			}
		}
		Syl [] leftSyls = new Syl[j];
		System.arraycopy(syls,0,leftSyls,0,j);
		return leftSyls;
	}
	public static Char [] filter(Char [] chars,Filter filter) {
		int j = 0;
		for(int i=0; i<chars.length; i++) {
			if(filter == null || filter.accept(chars[i])) {
				chars[j++] = chars[i];
			}
		}
		Char [] leftChars = new Char[j];
		System.arraycopy(chars,0,leftChars,0,j);
		return leftChars;
	}
}
