package ass.util;

import ass.object.TextUnit;

public interface Filter {
	boolean accept(TextUnit textUnit);
}
