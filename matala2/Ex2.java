package matala2;



//342615648, Souffir Ilan Meyer.

public class Ex2 {
	
//Question 1
	public static double f(double[] poly, double x){ //f(x)
		double sum = 0;
		for (int i = 0; i < poly.length; i++) {
			sum += (poly[i]*Math.pow(x, i));
		}
     return sum;
   }
//-----------------------------------------------------------------------------------------------		
//Question 2    
//array -> String
	
	public static String poly(double[] poly) {            // prints the polynome.
		reverse(poly);                                    //reverse the array
		String pp="";
		for (int i = 0; i < poly.length; i++) {          //loop for for every element in the array
			if ((poly.length-i-1)>0 && poly[i] != 0) {   //we dont print elements with 0
				pp =  pp+ (poly[i]+ "x^"+(poly.length-i-1)+" +" );
			}
		}
		double x = poly[poly.length-1];                 //the last number of the polynom
		return(pp + x );                                //result of the polynom
    }

//-----------------------------------------------------------------------------------------------
//Question 3
// returns a value (x) such that |f(p,x)|<=eps,
// assumes f(p,x1) * f(p,x2) <=0, see: Bisection_method (wikipedia)
	//in wikipedia we have the code for x1<x2, but now we don't know, so we need to make x1>x2 too.

	public static double root(double[] p,double x1,double x2,double eps){
		
		double c;
		double n=1;          //for the loop infinite
		  
		  if (x1<x2) {                      //in case we have x1 < x2
			  while (n<100000000) {         // limit iterations to prevent infinite loop
				  c = (x1+x2)/2;            //new midpoint
				  
				  if (f(p,c)==0 || (x2 - x1)/2 <eps)    // solution found
					  return c;
				      n++;                               
				      if (sign(f(p,c),f(p,x1)))     // new interval for x1 and x2
				    	  x1=c;
				      else x2=c;
			  }
		  }
		  
		  if (x2 < x1) {                    //in case we have x1 > x2
			  while (n<100000000) {         // limit iterations to prevent infinite loop
				  c = (x1+x2)/2;            //new midpoint
				  
				  if (f(p,c)==0 || (x1 - x2)/2 <eps)      // solution found
					  return c;
				      n++;
				      if (sign(f(p,c),f(p,x2)))       // new interval for x1 and x2
				    	  x2=c;
				      else x1=c;
			  }
		  }
		  if(f(p,x1)*f(p,x2)==0)   //if we have the result 0 so the root is on the line X.
			  return 0;
		  
		  return -1;                  // max number of steps exceeded
	}
	
	
	
//-------------------------------------------------------------------------------------------------	
//Question 4
// returns a new array representing the polynom of p1+p2 :
	
	public static double[] add(double[] p1, double[] p2) {// returns a new array representing the polynom of p1+p2
		double x = p1.length;
		double y = p2.length;
		double min = Math.min(x, y);            //make the array of the commons elements (longueur = min)
		double arr [] = new double [(int)min] ;
		for (int i = 0; i < min; i++) {        
			arr[i] = p1[i] + p2[i];
		}
		
		double max = Math.max(x, y);                   //make the rest of the max arr in a new array
		double sof = max-min;
		double [] z = arr_max(p1,p2);                  //choose the biggest arrray   (new fonction)
		double arr2 [] = new double [(int) sof] ;
		   for (int i = 0; i < sof; i++) {
			  arr2[i] = z[(int) max-1-i];              
		   }
		reverse(arr2);                                 //reverse of arr2
		
		double num = arr.length + arr2.length;         //assembly of arr and arr2 of length num
	    double[] arr_final = new double[(int) num];  
	    int pos = 0;                              //position of the new element
	       for (double i : arr) {                 //loop for each i in the arr
	    	   arr_final[pos] = i;
	              pos++;        
	       }
	       for (double i : arr2) {                //loop for each i in the arr2
	    	   arr_final[pos] = i;
	              pos++;
	       }
	    return arr_final;                    //answer
	}
	
//-----------------------------------------------------------------------------------------------	
	//Question 5
	// returns a new array representing the polynom of (p1)*(p2)
	
	public static double[] mul(double[] p1, double[] p2) {      
		reverse(p1);                                            //reverse p1 and p2 to have in the right order
		reverse(p2);
		
		double [] arr = new double [(p1.length)+(p2.length)-1];  //create a new array with elements "0"
		for (int i = 0; i < arr.length; i++) {
			   arr[i]=0;
		}
		
		for (int i = 0; i < p1.length; i++) {                    // double loop to multiply elements of p1 with every elements of p2.
            for (int j = 0; j < p2.length; j++) { 
                arr[i + j] += p1[i] * p2[j]; 
            } 
        }
		reverse(arr);                                             //we had the right order of the polynom and now we need to put him in the array.
		return arr;                                               //answer
	}
	
//-----------------------------------------------------------------------------------------------
   //Question 6
   //returns a new polynom representing the derivative of (po)
	
	   public static double[] derivative (double[] po) {  
			reverse(po);
			double [] po2 = new double [po.length-1];       //create a new array of length -1 with elements "0".
			   for (int i = 0; i < po2.length; i++) {
				   po2[i]=0;
			   }
	           for (int i = 0; i < po2.length; i++) {
	    	       po2[i]=po[i]*(po.length-1-i);
		       }
	         reverse(po2);
	      return po2;
	   }
	   
//----------------------------------------------------------------------------------------------------
	 //Functions for Ex2 :
	   
	   //function of the biggest array betwen two arrays.	   
	   public static double [] arr_max(double[]p1, double[]p2) {    
			double Max = Math.max(p1.length, p2.length);
		    double[] max = new double [(int) Max];
		        if (p1.length > p2.length) 
		    	   max = p1;
		        else 
		    	   max=p2;
		   return max;
	   }
	   
	 //function inverse the array.
		public static double[] reverse(double[] poly) {      
			  for (int i = 0; i < poly.length / 2; i++) {    
				  double temp = poly[i];
				  poly[i] = poly[poly.length-1-i];
				  poly[poly.length-1-i] = temp;
			  }
		    return poly ;
	    }
		
	//function to know if two numbers have the same sign.
		public static boolean sign(double x, double y) {
			if ((x<=0 && y<=0) || (x>=0 && y>=0))
				return true;
			else
				return false;
		}
//------------------------------------------------------------------------------------------------
}



