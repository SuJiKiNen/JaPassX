package ass.test;

import ass.util.AssColor;

public class ColorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AssColor assColor= new AssColor(0, 255, 255);
		System.out.println(assColor.toString());
		assColor= new AssColor(255, 0, 255,0);
		System.out.println(assColor.toString());
	}

}
