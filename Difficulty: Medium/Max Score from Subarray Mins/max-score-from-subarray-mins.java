class Solution {
    public int maxSum(int arr[]) {
        // code here
        int sum=0;
        int max=arr[0];
        for(int i=0;i<arr.length-1;i++){
            sum=arr[i]+arr[i+1];
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }
}