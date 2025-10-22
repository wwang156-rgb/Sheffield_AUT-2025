/*
 * KeyboardInput.java  	1.0 26/08/2011
 *
 * Copyright (c) University of Sheffield 2011
 */

import sheffield.*;

/**
* KeyboardInput.java
* 
* This class provides a template for reading input from the keyboard using the
* EasyReader class in the sheffield package
*/
public class KeyboardInput {
    public static void main(String[] args) {

	// step 1, create a new EasyReader object to model the keyboard
	//為什麼要 new 一個 object？因為 EasyReader (類別) 只是設計圖，你無法叫一張設計圖去「讀取鍵盤」。
	//你必須使用 new 來實際建造一個「鍵盤讀取器」物件 (儲存在 keyboard 變數中)，然後你才能命令那個物件去幫你工作。
	EasyReader keyboard = new EasyReader(); 

	// step 2, prompt the user to input values for a, b, and c and
	// store these as doubles
	double a = keyboard.readDouble("Input a value for a: ");
	double b = keyboard.readDouble("Input a value for b: ");
	double c = keyboard.readDouble("Input a value for c: ");

	// step 3, display the values that hae been entered
	System.out.println("You entered a=" + a + ", b=" + b + ", c=" + c);
    }
}
