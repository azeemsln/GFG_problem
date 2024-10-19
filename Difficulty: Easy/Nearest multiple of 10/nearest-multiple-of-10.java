//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    String roundToNearest(String str) {
        // Complete the function
        int n = str.length();
        //if str has only one digit
        if(n<2){
            int y = Integer.parseInt(str);
            return y>5? "10" : "0";
        }
        
        //if unit digit is less than equal to 5 i.e. 24->20 
        if(str.charAt(n-1)<='5'){
            return str.substring(0,n-1)+"0";
        }
        
        //if unit digit is greater than 5 i.e. 246->250
        String sb = "0";
        for(int i=str.length()-2;i>=0;i--){
            int x = (int)(str.charAt(i)-'0');
            
            //if it is  9 then update to 0 else add 1
            if(x != 9){
                return str.substring(0, i)+(x+1)+sb;
            }
            sb = "0"+sb;
        }
        return "1"+sb;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends