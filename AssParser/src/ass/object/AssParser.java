package ass.object;

import java.io.BufferedInputStream;
import java.util.ArrayList;

public class AssParser {
	private float frameRate = 23.976f;
	
	/**
	 * Instantiates a new ass parser,and the default frame rate is 23.976.
	 */
	public AssParser(){
		
	}
	
	/**
	 * Instantiates a new ass parser, use specific frame rate to create a parser.
	 * @param frameRate
	 *           
	 */
	public AssParser(float frameRate){
		this.frameRate = frameRate;
	}
	
	/**
	 * Parses the ass file,the filename can be absolute path,or you can drop the ass file 
	 * to processing data folder,then use dataPath to get the absolute ass file
	 * @param filename
	 * @return the ass
	 */
	public Ass parseFile(String filename){
		Meta meta = new Meta();
		ArrayList<Style> styles = new ArrayList<Style>();
		ArrayList<Line> lines = new ArrayList<Line>();
		
		//BufferedInputStream 
		
		Ass ass = new Ass();
		ass.setMeta(meta);
		ass.setStyles(styles);
		ass.setLines(lines);
		return ass;
	}

	public float getFrameRate() {
		return frameRate;
	}

	public void setFrameRate(float frameRate) {
		this.frameRate = frameRate;
	}
	
}
