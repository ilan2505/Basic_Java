package matala1;

import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x=0,y=0;
		int mpcd =1;
		
		if(args.length > 0) {        //if we have arguments :
			x = Integer.parseInt(args[0]);
			y= Integer.parseInt(args[1]);
			System.out.println("Enter the first number for max prime GCD: "+x);
			System.out.println("Enter the second number for max prime GCD: "+y);
			System.out.println("Computes the GPCD(" + x+ "," + y+") =");
		}
		
		else {     //If we don't have arguments : we need to input them.
		    System.out.print("Enter the first number for max prime GCD: ");
	        x = sc.nextInt();							
	        System.out.print("Enter the second number for max prime GCD: ");
	        y = sc.nextInt();
	        System.out.println("Computes the GPCD(" + x+ "," + y+") =");
	    }
		
		for(int i=2; i<= (Math.max(x,y)); i++) {
		       while(x%i==0 && y%i==0) {
		           mpcd=i;
		           x = x/mpcd;
		           y = y/mpcd;
		       }
	    }
		    System.out.println("Max Prime Common Divider: "+mpcd);
		    
	      if (mpcd == 1 || mpcd==0) {        //a prime number is >= 2.
			   System.out.println("there isn't solution because 0 or 1 are not prime");
		   
		  } 
	   sc.close();
	}

}