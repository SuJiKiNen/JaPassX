package ass.test;

import ass.util.ASSTime;

public class ASSTimeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ASSTime assTime = new ASSTime("0:00:05.00");
		System.out.println(assTime.toString());
		System.out.println(assTime.toMillis());
	}

}
