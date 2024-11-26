//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {

        // Your code here
        int n = arr.length;

        int maxKadane = kadane(arr, n);

       
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

       
        int minKadane = kadaneInverted(arr, n);
        
        
        int maxCircular = totalSum - minKadane;

      
        if (maxCircular == 0) {
            return maxKadane;
        }

        // Step 5: The answer is the maximum of maxKadane and maxCircular
        return Math.max(maxKadane, maxCircular);
    }

    // Helper function for Kadane's algorithm to find maximum subarray sum
    private int kadane(int arr[], int n) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    // Helper function to find minimum subarray sum by applying Kadane's on the inverted array
    private int kadaneInverted(int arr[], int n) {
        int minEndingHere = arr[0];
        int minSoFar = arr[0];

        for (int i = 1; i < n; i++) {
            minEndingHere = Math.min(arr[i], minEndingHere + arr[i]);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }

        return minSoFar;
    }
}
