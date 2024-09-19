//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // code here
        String s[]=str.split("\\.");
        int n=s.length;
        int start=0;
        int end=n-1;
        while(start<end){
            String temp=s[start];
            s[start]=s[end];
            s[end]=temp;
            start++;
            end--;
        }
        String res=String.join(".",s);
        return res;
    }
}