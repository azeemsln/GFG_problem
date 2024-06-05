//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    long findSwapValues(long a[], int n, long b[], int m) {
        // Your code goes here
         Arrays.sort(a);
        Arrays.sort(b);
        
        // Initialize variables to hold potential new sums after a swap
        long p1 = 10, p2 = 0;
        
        // Initialize pointers to traverse through the arrays
        int i = 0, j = 0;
        
        // Calculate the sum of elements in array a
        long suma = 0, sumb = 0;
        for(long e : a) {
            suma = suma + e;
        }
        
        // Calculate the sum of elements in array b
        for(long e : b) {
            sumb = sumb + e;
        }
        
        // Traverse through both arrays
        while(i < n && j < m) {


            // If the potential sums are equal, a valid swap is found
            if(p1 == p2) {
                return 1;
            }

           else if(suma >= sumb) {
                // If the sum of array a is greater than the sum of array b,
                // try to find a swap that balances the sums
                p1 = suma - a[i] + b[j];  // Calculate new sum for a
                p2 = sumb - b[j] + a[i];  // Calculate new sum for b
                i++;  // Move pointer in array a
            }

          else {
                // If the sum of array b is greater than or equal to the sum of array a,
                // try to find a swap that balances the sums
                p1 = suma - a[i] + b[j];  // Calculate new sum for a
                p2 = sumb - b[j] + a[i];  // Calculate new sum for b
                j++;  // Move pointer in array b
            }
        }
        
        // If no valid swap is found, return -1
        return -1;
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
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int m = Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a, n, b, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends