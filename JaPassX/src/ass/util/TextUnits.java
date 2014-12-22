package ass.util;

import java.util.Arrays;

import ass.object.TextUnit;

public class TextUnits {
	public static TextUnit [] filter(TextUnit [] textUnits,Filter filter) {
		int j = 0;
		for(int i=0; i<textUnits.length; i++) {
			if(filter == null || filter.accept(textUnits[i])) {
				textUnits[j++] = textUnits[i];
			}
		}
		System.arraycopy(textUnits,0,textUnits,0,j);
		System.out.println(textUnits.length);
		return textUnits;
	}
}
