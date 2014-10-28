package ass.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssTag {
	public static String strip(String text){
		Pattern pattern = Pattern.compile("\\{[^\\{]*\\}");
		Matcher matcher = pattern.matcher(text);
		return matcher.replaceAll("");
	}
	public static void main(String [] args) {
		String s="123{\\kfsc}12";
		System.out.println(AssTag.strip(s));
	}
}
