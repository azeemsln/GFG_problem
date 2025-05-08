//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        Solution solution = new Solution();
        while (t-- > 0) {
            String input = reader.readLine().trim();
            String[] parts = input.split("\\s+");
            int[] arr = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

            System.out.println(solution.findMissing(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findMissing(int[] arr) {
        // code here
        int n=arr.length;
        int x=arr[1]-arr[0];
        for(int i=0;i<n-1;i++){
            if((arr[i]+x)==arr[i+1]){
                continue;
            }
            return arr[i]+x;
        }
        return arr[n-1]+x;
    }
}
