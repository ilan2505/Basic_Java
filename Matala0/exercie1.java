package Matala0;

public class exercie1 {
	public static void main(String[] args) {
	int x = MyConsole.readInt("Enter the first number for max prime GCD : ");
	int y = MyConsole.readInt("Enter the second number for max prime GCD : ");
	int mpcd =1;
	
	   for(int i=2; i<= (Math.max(x,y)); i++) {
	       while(x%i==0 && y%i==0) {
	           mpcd=i;
	           x = x/mpcd;
	           y = y/mpcd;
	       }
	   }
	    System.out.println("Max prime common divider : "+mpcd);
      if (mpcd == 1 || mpcd==0) {
		   System.out.println("there isn't solution because 0 or 1 are not prime");
	   }
	}
}

