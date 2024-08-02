//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String str1, String str2) {
        // Code here
         int m = str1.length();
        int n = str2.length();
        
        // Create a DP table to store the results of subproblems
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill dp[][] in bottom-up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty, the only option is to insert all characters of second string
                if (i == 0) {
                    dp[i][j] = j; // Insert all j characters
                }
                // If second string is empty, the only option is to remove all characters of the first string
                else if (j == 0) {
                    dp[i][j] = i; // Remove all i characters
                }
                // If last characters are the same, ignore the last character and get the count for the remaining strings
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // If the last character is different, consider all possibilities and find the minimum
                else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], // Insert
                                    Math.min(dp[i - 1][j], // Remove
                                             dp[i - 1][j - 1])); // Replace
                }
            }
        }
        return dp[m][n];
    }
}