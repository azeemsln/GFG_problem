//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
         int m=s.length(),n=p.length();
        if(m<n) return new String("-1");
        int arr2[]=new int[26];
        int unmatched=n;
        for(int i=0;i<n;i++){
            char ch=p.charAt(i);
            arr2[ch-'a']++;
        }
        int min=Integer.MAX_VALUE;
        int arr1[]=new int[26];
        int beg=0;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<m;i++){
            char ch=s.charAt(i);
            if(arr2[ch-'a']>0&&arr1[ch-'a']<arr2[ch-'a']){
                unmatched--;
            }
            arr1[ch-'a']++;
            while(beg<m&&unmatched==0){
                if(min>i-beg){
                    str.setLength(0); 
                    str.append(s, beg, i+1); 
                    min=i-beg;
                }
                char ch1=s.charAt(beg);
                arr1[ch1-'a']--;
                if(arr2[ch1-'a']>0&&arr1[ch1-'a']<arr2[ch1-'a']){
                    unmatched++;
                }
                beg++;
            }
        }
        if(min==Integer.MAX_VALUE) return new String("-1");
        return str.toString();
    }
}