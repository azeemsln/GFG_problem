//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static String armstrongNumber(int n) {
        // code here
        int m=n;
        String d;
            int a=m%10;
            m=m/10;
            int b=m%10;
            m=m/10;
            int c=m;
            if(a*a*a + b*b*b+c*c*c==n)
                d= "true";
            else
                d="false";
        return d;
    }
}