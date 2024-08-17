//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
          long[] res = new long[nums.length];
        long product = 1;
        int zeroCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeroCnt++;
            else product *= nums[i];
        }
        int k = 0;
       if (zeroCnt>1) return res;
       for (int i = 0; i < nums.length; i++) {
            if (zeroCnt == 1) {
                res[i] = (nums[i] == 0) ? product : 0;
            } else {
                res[i] = product / nums[i];
            }
        }
       return res;
    }
}
