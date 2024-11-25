//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        int max=arr[0];
        int currProduct=1;
        for(int i=0;i<arr.length;i++){
            currProduct=arr[i];
            if(arr[i]>max){
                max=arr[i];
            }
            for(int j=i+1;j<arr.length;j++){
                currProduct=currProduct*arr[j];
                if(currProduct>max){
                    max=currProduct;
                }
            }
        }
        return max;
    }
}