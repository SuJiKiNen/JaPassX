package ass.test;

import util.AssTime;

public class AssTimeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AssTime assTime = new AssTime("0:00:05.00");
		System.out.println(assTime.toString());
		System.out.println(assTime.toMillis());
	}

}
