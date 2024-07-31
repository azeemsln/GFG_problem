//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        String s1 = arr[0];
        String s2 = arr[n-1];
        String ans = "";
        for(int i =0; i<arr[0].length(); i++){
            if(s1.charAt(i) == s2.charAt(i)){
                ans = ans + (Character.toString(s1.charAt(i)));
            }
            else{
                break;
            }
        }
        if(ans.isEmpty()) return "-1";
        else return ans;
    }
}