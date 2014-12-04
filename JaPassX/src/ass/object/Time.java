package ass.object;

public class Time implements Cloneable {
	 public int start;
	 public int mid;
	 public int end;
	 public Time add(Time augend){
		 Time result = new Time();
		 result.start = this.start + augend.start;
		 result.mid   = this.mid   + augend.mid;
		 result.end   = this.end   + augend.end;
		 return result;
	 }
	 
	 public void shift(int amount) {
		 this.start = this.start + amount;
		 this.mid   = this.mid   + amount;
		 this.end   = this.end   + amount;
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
