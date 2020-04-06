package com.w2a.rough;

import java.util.Date;

public class TestTimeStamp {
	
	public static void main(String[] args) {
		
		Date d = new Date();
		// System.out.println(); will print : Sun Mar 22 09:12:51 IST 2020
		// we need to convert the date into String and replace colon with underscore
		//System.out.println(d.toString().replace(":", "_").replace(" ", "_")); //prints : Sun_Mar_22_09_17_04_IST_2020
		
		String screenShotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		System.out.println(screenShotName);
		
		
	}

}
