package Matala0;

public class prime {
	public static void main(String[] args) {
		int n = MyConsole.readInt("enter num : ");
		boolean prime = true;
		for (int i = 2; i < n; i++) {
			if (n%i == 0)
				prime = false;
		}
		if (prime)
			System.out.println(n + " is prime");
		else 
			System.out.println(n + " is not prime");
		
		
	}

}
