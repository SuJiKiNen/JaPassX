package ass.object;

import java.util.ArrayList;

public class Ass {
	Meta meta;
	ArrayList<Style> styles;
	ArrayList<Line> lines;
	
	public Ass(){
		meta = new Meta();
		styles = new ArrayList<Style>();
		lines = new ArrayList<Line>();
	}
	
	public Meta getMeta() {
		return meta;
	}
	
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	
	public ArrayList<Style> getStyles() {
		return styles;
	}
	
	public void setStyles(ArrayList<Style> styles) {
		this.styles = styles;
	}
	
	public ArrayList<Line> getLines() {
		return lines;
	}
	
	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}
	
}