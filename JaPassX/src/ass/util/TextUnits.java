package ass.util;

import java.util.ArrayList;

import ass.object.TextUnit;

public class TextUnits {
	public static void filter(TextUnit [] textUnits,Filter filter) {
		ArrayList<TextUnit> newTextUnits = new ArrayList<TextUnit>();
		for(int i=0; i<textUnits.length; i++) {
			if(filter == null || filter.accept(textUnits[i])) {
				newTextUnits.add(textUnits[i]);
			}
		}
		textUnits = newTextUnits.toArray(new TextUnit[ newTextUnits.size() ]);
	}
	public static void filter(ArrayList<TextUnit> textUnits,Filter filter) {
		ArrayList<TextUnit> newTextUnits = new ArrayList<TextUnit>();
		for(int i=0; i<textUnits.size(); i++) {
			if(filter == null || filter.accept(textUnits.get(i))) {
				newTextUnits.add(textUnits.get(i));
			}
		}
		textUnits = newTextUnits;
	}
}
