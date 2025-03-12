//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int n = str.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            int res = sln.minCostClimbingStairs(arr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        int n = cost.length;
        int[] dp = new int[n+1];
      
        for(int i = n-1; i >= 0; i--) {
            int onestep = cost[i] + dp[i + 1];
            int twostep = Integer.MAX_VALUE;
            if(i + 2 <= n) twostep = cost[i] + dp[i +2];
            dp[i] = Math.min(onestep, twostep);
        }
        return Math.min(dp[0], dp[1]);
        
    }
};