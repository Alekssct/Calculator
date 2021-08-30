package calc;

public class Test1 {

	public static void main(String[] args) {
		double a1 = 3;
		double b1 = 0.3;
		double c1 = 0.31;
		double d1 = 0.3111111111111111;
		
		double res1 = a1 * b1;
		double res2 = a1 * c1;
		double res3 = a1 * d1;
		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);

		double res4 = a1 * b1;
		double res5 = a1 * c1;
		double res6 = a1 * d1;
		System.out.println(Math.ceil(res4 * 1000000000)/1000000000);
		System.out.println(Math.ceil(res5 * 1000000000)/1000000000);
		System.out.println(Math.ceil(res6 * 1000000000)/1000000000);

	}
}
