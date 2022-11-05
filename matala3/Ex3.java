package matala3;
//Souffir Ilan Meyer
//342615648

import java.util.Arrays;

public class Ex3 {
//MyID
	public static String myID (String str) {
		return "342615648";
	}

//Question 1 :
	public static String moveCharToLast(String str, char ch) {
		
		    //the condition : if str<1 we return a empty string.
		    if(str.length() < 1) {
		        return "";
		    }

		    String newString = str.substring(1);   //Create new string without the first char.

		    if(str.indexOf(ch) == 0) {             //This is when your char is found.
		        return moveCharToLast(newString, ch) + ch;
		    } else {                               //This is with all the others char.
		        return str.charAt(0) + moveCharToLast(newString, ch);
		    }
    }
//------------------------------------------------------------------------------------------------
//Question 2 :
	public static String reduce(String str) {
		//the condition : if str<=1 we return the string of the beginning .
		if ( str.length() <= 1 ) 
			return str;
		//if the letter in the location [i+1] = the location of [i], we return only the letter [i]
	    if( str.substring(1,2).equals(str.substring(0,1)) ) 
	    	return reduce(str.substring(1));
	    else 
	    	return str.substring(0,1) + reduce(str.substring(1));
	}
//------------------------------------------------------------------------------------------------
//Question 3 :
	// Function to start the recursive calls 
	public static boolean mySplit(int[] nums) {
         int n = nums.length;
	     // Initially the input
	    return function(nums, n, 0, 0, 0); 
	}
	
	static boolean function(int nums[], int index, int input, int mod5, int mod3) { 
            //conditions : 
            if (input == index) 
                return mod5 == mod3; 
            if (nums[input] % 5 == 0)      // If this is divisible by 5 :
                mod5 += nums[input]; 
            else if (nums[input] % 3 == 0) // If this is divisible by (and not by 5)
                mod3 += nums[input]; 

            else     //if the sum of the two array is the same :
                 return function(nums, index, input + 1, mod5 + nums[input], mod3) || function(nums, index, input + 1, mod5, mod3 + nums[input]); 
                 return function(nums, index, input + 1, mod5, mod3); // if an element is multiple of 3 or 5. 
} 
//------------------------------------------------------------------------------------------------
//Question 4 :
	public static int[][] sumOfNeighbours(int[][] mat){
		
    //creation of the final array with the same length elements of arr but with elements =0.
    int [][] fin= new int [mat.length][mat[0].length];  
    for (int i = 0; i < fin.length; i++) {
        for (int j = 0; j < fin[0].length; j++) {
			fin [i][j] = 0;
	    }
    }
        
    int x = mat.length-1;
    int y = mat.length-2;
    int z = (mat[0].length)-1;
    int w = (mat[0].length)-2;
    
         //elements in the corner of the array with 3 neighborhoods.   
         fin[0][0] = mat[0][1] + mat[1][0] + mat[1][1];
         fin[0][z] = mat[0][w] + mat[1][z] + mat[1][w];
         fin[x][0] = mat[x][1] + mat[y][0] + mat[y][1];
         fin[x][z] = mat[x][w] + mat[y][z] + mat[y][w];

         //elements in the middle of the right and left colons with 5 neighborhoods :
         for (int i = 1; i < fin.length-1; i++) {
        	     //right :
        	     fin[i][z] = mat[i-1][z] + mat[i-1][w] + mat[i][w]
		                     + mat[i+1][w] + mat[i+1][z];
        	     //left :
                 fin[i][0] = mat[i-1][0] + mat[i-1][1] + mat[i][1]
		                     + mat[i+1][1] + mat[i+1][0]; 
         } 
        	 
        //elements in the middle of the first and last lines with 5 neighborhoods :	 
        for (int j = 1; j < fin[0].length-1; j++) {
    	        //first :
	            fin[0][j] = mat[0][j-1] + mat[1][j-1] + mat[1][j]
	                        + mat[1][j+1] + mat[0][j+1];
	    	 
                //last :
		        fin[x][j] = mat[x][j-1] + mat[y][j-1] + mat[y][j]
	                        + mat[y][j+1] + mat[x][j+1];
        }
    
       //elements of the middle with 8 neighborhoods :
       for (int i = 1; i < fin.length-1; i++) {
            for (int j = 1; j < fin[0].length-1; j++) {
			      fin[i][j] = mat[i-1][j-1] + mat[i-1][j] + mat[i-1][j+1] + mat[i][j+1] 
						      + mat[i+1][j+1] + mat[i+1][j] + mat[i+1][j-1] + mat[i][j-1];
	        }
       }
     return fin;  
 }
	
	public static void main(String[] args) {
		int[][] mat = {{1,2,3},{1,0,1},{1,1,1}};
		
		System.out.println(Arrays.toString(sumOfNeighbours(mat)));
	}
//------------------------------------------------------------------------------------------------	
//Question 5 :
	public static String caesarCipherText(String str, int key) {
		    String alphabet = "abcdefghijklmnopqrstuvwxyz";
		    String str_final = "";
		    if (key < 0) {                //if the key is negative, change to a positive key.
		    	key = 26 + key;
		    }
		    for (int i = 0; i < str.length(); i++) {     //for the spaces.
			     if (str.charAt(i)== ' ') {         
				     str_final = str_final +" ";
			     }
			     for (int j = 0; j < alphabet.length(); j++) {  //the calcul of the cesar cipher :
				    int numlettre = key + j;                    //create a new location to run in the loop j
				    while (numlettre > 25) {                    //while our lettre is > 26 (alphabet)
					    numlettre = numlettre-26;
				    }
				    if (alphabet.charAt(j) == str.charAt(i)) {   //we put the lettre with the key
					    str_final = str_final + alphabet.charAt(numlettre);
				    }  
			    }
		   }
        return str_final;
	}
//------------------------------------------------------------------------------------------------
//Question 6 :
	////Vigenere Cipher :
	public static String vigenereCipherText(String str, String key){
		
	    String str_final = "";
	    str = str.toLowerCase();
	    for(int i = 0; i < str.length(); i++) {
	        int indexofkey = key.charAt(i%key.length()) - 'a'; //location (index) of the letters (key) in the string (str), we need to put the -a for the real location in the alphabet
	        int indexoftext = str.charAt(i) - 'a';     //location (index) of the letters of the string (str). space = -65
	        if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') { //check if letter is in alphabet
	            int cipher = ((indexoftext + indexofkey) % 26) + 'a';   //calculation vigenere
	            str_final = str_final + (char)cipher; //char to transform number in char
	        } 
	        else 
	        	str_final = str_final+ str.charAt(i);
	    }
	   return str_final;       //return the cipher text.
	}
	
	//Vigenere Decipher :
	public static String vigenereDecipherText(String str, String key) {
		
	      String str_final = "";
	      str = str.toLowerCase();
	      for(int i = 0; i < str.length(); i++) {
	         int indexofkey = key.charAt(i%key.length()) - 'a';  //location (index) of the letters (key) in the string (str), we need to put the -a for the real location in the alphabet
	         int indexoftext = str.charAt(i) - 'a';              //location (index) of the letters of the string (str). space = -65
	         if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') { //check if letter is in alphabet
	             int decipher = (((indexoftext - indexofkey)+26) % 26) + 'a';    //calculation vigenere
	             str_final = str_final + (char)decipher;    //char to transform number in char
	         } 
	         else 
	        	 str_final = str_final + str.charAt(i);
	     }
	   return str_final;     //return the decipher text
	}
	
}
