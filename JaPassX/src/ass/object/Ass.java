package ass.object;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Enumeration;;

public class Ass implements Cloneable{
	public Meta meta;
	public Hashtable<String,Style> styles;
	public ArrayList<Line> lines;
	
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
	
	public Line[] getLines() {
		return lines.toArray(new Line[ lines.size() ]);
	}
	
	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}
	public Line getLineByFrame(int frame) {
		// to do 
		return lines.get(0);
	}
	
	
	public Ass clone(){
		Ass ass = null;
		try {
			ass = (Ass)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		ass.meta = meta.clone();
		ass.styles = new Hashtable<String, Style>();
		Enumeration<String> enumKey = styles.keys();
		while(enumKey.hasMoreElements()) {
		    String key = enumKey.nextElement();
		    Style val = styles.get(key).clone();
		    ass.styles.put(key, val);
		}
		ass.lines = new ArrayList<Line>();
		for(int i=0; i<lines.size(); i++){
			ass.lines.add(lines.get(i).clone());
		}
		return ass;
	}
	
}