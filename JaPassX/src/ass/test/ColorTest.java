package ass.test;

import ass.util.ASSColor;

public class ColorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ASSColor assColor= new ASSColor(0, 255, 255);
		System.out.println(assColor.toString());
		assColor= new ASSColor(255, 0, 255,0);
		System.out.println(assColor.toString());
	}

}
