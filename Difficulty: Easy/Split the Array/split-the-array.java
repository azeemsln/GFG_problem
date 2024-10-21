//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    public static int countgroup(int arr[]) {
        // Complete the function
        int allXOR = 0;
        for(int x : arr){
            allXOR ^= x;
        }
        
        //2 disjoint group out of given elements exist if XOR of array is zero
        if(allXOR != 0){
            return 0;
        }
        
        //No. of disjoint sets of a set = 2^(n-1)-1
        //where n = size of set or array
        int n = arr.length;
        long MOD = 1000000007;
        return (int)(((1<<(n-1))-1)%MOD);
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int ans = obj.countgroup(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends