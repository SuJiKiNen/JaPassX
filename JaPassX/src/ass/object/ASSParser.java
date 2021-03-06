package ass.object;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;

import org.omg.CORBA.VersionSpecHelper;

public class ASSParser {
	// http://semver.org/
	public static final String VERSION = "0.1.0";
	/**
	 * Parses the ass file,the filename can be absolute path,or you can drop the ass file 
	 * to processing data folder,then use dataPath to get the absolute ass file
	 * @param filename
	 * @return the ass
	 */
	public static ASS parseFile(String filename) {
		Line.lineCount = 0;
		return parseFile(filename, 23.976f);
	}
	public static ASS parseFile(String filename,float frameRate){
		Line.lineCount = 0;
		Meta meta = new Meta();
		Hashtable<String,Style> styles = new Hashtable<String,Style>();
		ArrayList<Line> lines = new ArrayList<Line>();
		meta.frameRate = frameRate;
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
				}
				
				if(curLine.startsWith("Dialogue")) {
					Line line = new Line(curLine,frameRate);
					line.createExtras(styles.get(line.style),meta);
					lines.add(line);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ASS ass = new ASS();
		ass.setMeta(meta);
		ass.setStyles(styles);
		ass.setLines(lines);
		return ass;
	}
	public static String getVersion() {
		return VERSION;
	}
	
}
