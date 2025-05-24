class Solution {
    public static int sumSubstrings(String s) {
        // code here
        // int num= Integer.parseInt(s);
        int n=s.length();
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                int x=Integer.parseInt(s.substring(i,j));
                res+=x;
            }
        }
        return res;
    }
}