package ass.object;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;

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
		Hashtable<String,Style> styles = new Hashtable<String,Style>();
		ArrayList<Line> lines = new ArrayList<Line>();
		
		String curLine = null;
		try {
			// https://github.com/processing/processing/blob/d0e696c69449483a3967c157b1042e06934637cb/core/methods/demo/PApplet.java#L4703
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF-8"));
			while ( (curLine = bufferedReader.readLine()) !=null ) {
				
				if (curLine.startsWith("PlayResX")) {
					meta.width = Integer.parseInt( curLine.substring(10) );
				}
				
				if(curLine.startsWith("PlayResY")) {
					meta.height = Integer.parseInt( curLine.substring(10) );
				}
				
				if(curLine.startsWith("Style")) {
					Style style = new Style(curLine);
					styles.put(style.name, style);
					System.out.println(style.toString());
				}
				
				if(curLine.startsWith("Dialogue")) {
					Line line = new Line(curLine);
					line.createExtras(styles.get(line.style),frameRate,meta);
					lines.add(line);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

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
	
	public static void main(String [] args){
		AssParser assParser = new AssParser();
		Ass ass = assParser.parseFile("C:\\Users\\LuiShenGa\\Desktop\\LiSA - oath sign.ass");
		System.out.println(ass.meta.width);
		System.out.println(ass.meta.height);
		ArrayList<Line> lines = ass.getLines();
		System.out.println(lines.get(0).text);
		System.out.println(lines.get(0).text.length());
	}
}
