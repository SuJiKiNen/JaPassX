package ass.util;

import ass.object.Char;
import ass.object.Line;
import ass.object.Syl;
import ass.object.TextUnit;
import ass.util.Regex;

public class TextUnits {
	
	public static String SPACE_STR = "^"+Regex.UNICODE_SPACES+"*$";
	
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
	public static Line[] filterBlank(Line [] lines){
		lines = filter(lines, new Filter() {
			@Override
			public boolean accept(TextUnit textUnit) {
				if(textUnit.dur==0 || textUnit.text.equals("") || textUnit.text.matches(SPACE_STR)) {
					return false;
				}
				return true;
			}
		});
		return lines;
	}
	public static Syl[] filterBlank(Syl [] syls){
		syls = filter(syls, new Filter() {
			@Override
			public boolean accept(TextUnit textUnit) {
				if(textUnit.dur==0 || textUnit.text.equals("") || textUnit.text.matches(SPACE_STR)) {
					return false;
				}
				return true;
			}
		});
		return syls;
	}
	public static Char[] filterBlank(Char [] chars){
		chars = filter(chars, new Filter() {
			@Override
			public boolean accept(TextUnit textUnit) {
				if(textUnit.dur==0 || textUnit.text.equals("") || textUnit.text.matches(SPACE_STR)) {
					return false;
				}
				return true;
			}
		});
		return chars;
	}
}
