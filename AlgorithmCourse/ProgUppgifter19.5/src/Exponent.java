/**
 * <h1>Exponent.java</h1>
 * <p>this is a program that shows the simplicity of the recursion</p>
 * @author fredrik
 *
 */
public class Exponent {
	public static void main(String[] args) {
		System.out.print(expo(5, 4));			//  the thing that write and set everything
	}

	public static int expo(int bas, int exponent) {
		if (exponent == 0) {
			return 1;   //when the everything go up again
		}
		return expo(bas, exponent - 1) * bas; // saves the value to next time so it can be writen later
	}
}
