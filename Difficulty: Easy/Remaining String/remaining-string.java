//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            char ch = sc.next().charAt(0);
            int count = sc.nextInt();
            Solution ob = new Solution();
            String result = ob.printString(s, ch, count);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


class Solution {
    public String printString(String s, char ch, int count) {
        // code here
        int i=0,j=0;
        String z;
        if(count>s.length()){
            return "";
        }
        for(i=0;i<s.length();i++){
            
            if(s.charAt(i)==ch){
                count--;
                j=i;
            }
            if(count==0){
                break;
            }
            
        }
        if(count==0){
            z= s.substring(j+1);
        }
        else{
            z="";
        }
        return z;
    }
}