class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int maxi=0;
        for(int i:arr) maxi=Math.max(i,maxi);
        
        int low=1,high=maxi,res=Integer.MAX_VALUE;
        
        while(low<=high){
            int mid=low+(high-low)/2;
           
            if(isPossible(mid,arr,k)){
                res=Math.min(res,mid);
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        
        return res==Integer.MAX_VALUE ? maxi :res;
    }
    private boolean isPossible(int start,int[] arr,int k){
        int count=0;
        
        for(int i:arr){
            if(i%start!=0){
                count+=(i/start)+1;
            }else{
                count+=(i/start);
            }
            if(count>k) return false;
        }
        return true;
    }
}
