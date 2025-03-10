//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        List<Integer>neg=new ArrayList<>();
      List<Integer>pos=new ArrayList<>();
      for(int i=0;i<arr.size();i++){
          if(arr.get(i)<0)
          neg.add(arr.get(i));
          else
          pos.add(arr.get(i));
      }
      int i=0,j=0,k=0;
      while( j<pos.size() || k<neg.size()){
          if(j<pos.size())arr.set(i++,pos.get(j++));
          if(k<neg.size())arr.set(i++,neg.get(k++));
         
      }
    }
}