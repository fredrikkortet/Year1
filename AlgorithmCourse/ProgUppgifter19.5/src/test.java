/**
 * <h1>test.java</h1>
 * <p>Its a test to see if everything is working so i don't need to tweak it ;)</p>
 * @author fredrik
 *
 */
public class test {
	public static void main(String[] args) {
		int choose = 5;
		print(0,choose);
	}
	public static void print(int a, int n) {
		if (a <= n) {
			System.out.println(a);
			print(a+1,n);
		}
	}
}
