package ass.object;

import java.util.ArrayList;
import java.util.Hashtable;

public class Ass {
	Meta meta;
	Hashtable<String,Style> styles;
	ArrayList<Line> lines;
	
	public Ass(){
		meta = new Meta();
		styles = new Hashtable<String, Style>();
		lines = new ArrayList<Line>();
	}
	
	public Meta getMeta() {
		return meta;
	}
	
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	
	public Hashtable<String, Style> getStyles() {
		return styles;
	}
	
	public void setStyles(Hashtable<String,Style> styles) {
		this.styles = styles;
	}
	
	public ArrayList<Line> getLines() {
		return lines;
	}
	
	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}
	
}