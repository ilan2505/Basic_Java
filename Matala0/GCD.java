package Matala0;



public class GCD {
	public static void main(String[] args) {
		int n = MyConsole.readInt("Enter num n : ");
		int m = MyConsole.readInt("Enter num m : ");
		int gcd =1;
		for (int i = 2; i < (Math.max(m, n)); i++) {
			if((m % i == 0) && (n % i ==0)){
				gcd = i ;
				System.out.println(gcd);
			}
		}
		System.out.println("gcd("+m+","+n+") ="+gcd);
	}
}
