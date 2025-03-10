//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        int len1= str1.length();
int len2= str2.length();
int maxLength=0;
        
for(int i=0; i< len1; i++) {
   for(int j=i; j< len1; j++) {
                
     String subStr= str1.substring(i, j+1);
                
     if(str2.contains(subStr)) {
        maxLength= Math.max(maxLength, subStr.length());
     }
   }
}

return maxLength;
    }
}