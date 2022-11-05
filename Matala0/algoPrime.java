package Matala0;

public class algoPrime {
	public static void main(String[] args) {
		int n = 1;
		boolean prime = true;
		int i = 2;
		int t;
		while (i<n) {
			t = n%i;
			if (t==0) {
				prime = false;
			}
			i++;
		}
		System.out.println(prime);
	}

}
