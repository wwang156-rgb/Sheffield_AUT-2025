import sheffield.*;
import java.math.*;


 /**
 * QuadraticSolver.java
 * solves quadratic equations for x given a*x*x + b*x + c = 0
 * the code should be modified so that a, b, and c are input by the user
 */
 public class QuadraticSolver {
     public static void main( String[] arg) {
 
     // initially, these are stored as both integers and float
     //  int aInt = 1, bInt = 2000000, cInt = 1;
     //double aFloat = 1, bFloat = 2000000, cFloat = 1;10
     EasyReader keyboard = new EasyReader();
     // 提示使用者輸入 a，並讀取
     System.out.println("Please enter a value for a:");
     double aFloat = keyboard.readDouble();

     // 提示使用者輸入 b，並讀取
     System.out.println("Please enter a value for b:");
     double bFloat = keyboard.readDouble();

     // 提示使用者輸入 c，並讀取
     System.out.println("Please enter a value for c:");
     double cFloat = keyboard.readDouble();
 
     // declare variables to store the two values of x that satisfy the equation
     double x1, x2;
     double result1, result2;
 
     double discriminant = bFloat*bFloat - 4*aFloat*cFloat;

     if (discriminant > 0) {
        x1 = (-bFloat + Math.sqrt(discriminant)) / (2 * aFloat);
        x2 = (-bFloat - Math.sqrt(discriminant)) / (2 * aFloat);
        System.out.println("Two real roots: x1 = " + x1 + ", x2 = " + x2);
        // verify ax^{2}+bx+c=0 for both roots
        result1 = aFloat*x1*x1 + bFloat*x1 + cFloat;
        result2 = aFloat*x2*x2 + bFloat*x2 + cFloat;
        System.out.println("result1 = " + result1 + ", and result2 = " + result2);
     } else if (discriminant == 0) {
        double x = -bFloat / (2 * aFloat);
        System.out.println("One real root: x = " + x);
        // verify single root
        result1 = aFloat*x*x + bFloat*x + cFloat;
        System.out.println("result = " + result1);
     } else {
        System.out.println("No real roots (discriminant < 0).");
     }
     
     }

 }
 