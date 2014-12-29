package ass.object;

import java.util.ArrayList;

public class Time implements Cloneable {
	 public int start;
	 public int end;
	 
	 public Time(){
		 this.start = 0;
		 this.end   = 0;
	 }
	 public Time(Time t) {
		 this.start = t.start;
		 this.end = t.end;
	 }
	 
	 public Time(int start,int end){
		 this.start = start;
		 this.end = end;
	 }
	 
	 public Time add(Time augend){
		 Time result = new Time();
		 result.start = this.start + augend.start;
		 result.end   = this.end   + augend.end;
		 return result;
	 }
	 
	 public void shift(int amount) {
		 this.start += amount;
		 this.end   += amount;
	 }
	 
	 public static void shift(ASS ass,int amount){
		   ArrayList<Line> lines = ass.lines;
		   for(int i=0; i<lines.size(); i++) {
			   Line line = lines.get(i);
			   line.time.shift(amount);
			   line.startTime += amount;
			   line.endTime   += amount;
			   
			   for(int j=0; j<line.syls.size(); j++) {
				   Syl syl = line.syls.get(j);
				   syl.time.shift(amount);
				   syl.startTime += amount;
				   syl.endTime   += amount;
			   }
			   
			   for(int j=0; j<line.chars.size(); j++) {
				   Char c = line.chars.get(j);
				   c.time.shift(amount);
				   c.startTime += amount;
				   c.endTime   += amount;
			   }
		   }
	 }

	 public static void shift(Line line,int amount) {
		 Line lines[] = {line};
		 shift(lines,amount);
	 }
	 
	 public static void shift(Line lines[],int amount) {
		   for(int i=0; i<lines.length; i++) {
			   Line line = lines[i];
			   line.time.shift(amount);
			   line.startTime += amount;
			   line.endTime   += amount;
			   
			   for(int j=0; j<line.syls.size(); j++) {
				   Syl syl = line.syls.get(j);
				   syl.time.shift(amount);
				   syl.startTime += amount;
				   syl.endTime   += amount;
			   }
			   
			   for(int j=0; j<line.chars.size(); j++) {
				   Char c = line.chars.get(j);
				   c.time.shift(amount);
				   c.startTime += amount;
				   c.endTime   += amount;
			   }
		   }
	 }
	 
	 public static void shift(Syl syl,int amount) {
		 Syl syls[] = {syl};
		 shift(syls, amount);
	 }
	 
	 public static void shift(Syl syls[],int amount){
		 for(int i=0; i<syls.length; i++) {
			 Syl syl = syls[i];
			 syl.time.shift(amount);
			 syl.startTime  += amount;
			 syl.endTime    += amount;
		 }
	 }
	 
	 public static void shift(Char c,int amount){
		 Char chars[] = {c};
		 shift(chars,amount);
	 }
	 
	 public static void shift(Char chars[],int amount) {
		 for(int i=0; i<chars.length; i++) {
			 Char c = chars[i];
			 c.time.shift(amount);
			 c.startTime += amount;
			 c.endTime   += amount;
		 }
	 }

	 public Time clone(){
		Time time=null;
		try {
			time = (Time) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		 return time;
	 }
}
