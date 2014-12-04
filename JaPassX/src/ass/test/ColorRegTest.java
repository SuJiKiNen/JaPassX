package ass.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorRegTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String color = "&H000000FF";
		//String color = "&Hffaabbcc";
		//String color = "&H000000gg";
		String color = "&H000000";
		Pattern pattern = Pattern.compile("^&h[0-9a-f]{8}$",Pattern.CASE_INSENSITIVE);
		Matcher matcher =  pattern.matcher(color);
		boolean b = matcher.matches();
		System.out.println(b);
		
	}

}
