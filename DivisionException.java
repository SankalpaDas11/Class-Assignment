/*QUESTION : You will be given two integers x and y as input, you have to compute x/y. If x and y are 
not 32 bit signed integers or if y is zero, exception will occur and you have to report it. 
Read sample Input/Output to know what to report in case of exceptions.
Sample Input 1:
10
3
Sample Output 1:
3
Sample Input 2:
10
Hello
Sample Output 2:
java.util.InputMismatchException
Sample Input 3:
10
0
Sample Output 3:
java.lang.ArithmeticException: / by zero
Sample Input 4:
23.323
0
Sample Output 4:
java.util.InputMismatchException
*/

package Exception;
import java.util.InputMismatchException;// importing InputMismatchException Package
import java.util.Scanner;      //importing Scanner Class
public class DivisionException {
	public static void main(String[] args) {
		        try {
		            Scanner scan = new Scanner(System.in);//creating object of Scanner class to take inputs
		            System.out.println("Enter the values of x and y : ");
		            int x = scan.nextInt();//taking input for x
		            int y = scan.nextInt();//taking input for y
		            System.out.println(x/y);//printing the division
		        } 
		        catch (ArithmeticException AE) {//using catch block trying to catch the exception if any ArithmeticException occurs
		            System.out.println(AE);//printing the ArithmeticException
		        } 
		        catch (InputMismatchException IME) {//using catch block trying to catch the exception if any InputMismatchException exception occurs
		            System.out.println(IME);//printing the InputMismatchException
		        } 
		    }
		}
