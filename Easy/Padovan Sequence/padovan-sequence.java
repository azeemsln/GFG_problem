//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
        //code here.
         if(n<3){
            return 1;
        }
        
        int a[] = new int[n+1];
        a[0] = 1;
        a[1] = 1;
        a[2] = 1;
        
        for(int i=3;i<=n;i++){
            a[i] = (a[i-2] + a[i-3]%1000000007)%1000000007;
        }
        return a[n]%1000000007;
    }
    
}
