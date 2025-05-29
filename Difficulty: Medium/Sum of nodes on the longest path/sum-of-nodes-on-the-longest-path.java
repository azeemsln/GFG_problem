/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    static int mc=0,ms=0;
    public int sumOfLongRootToLeafPath(Node root)
    {
        int count=0, sum=0;
        int msum=0;
        func(root,count,sum);
        mc=0;
        msum=ms;
        ms=0;
        return msum;
    }
    
    public static void func(Node root,int count,int sum){
        if(root==null){
            if(count>mc){
                ms=sum;
                mc=count;
            }else if(count==mc){
                ms=Math.max(ms,sum);
            }
            return;
        }
        
        func(root.left,count+1,sum+root.data);
        func(root.right,count+1,sum+root.data);
    }
}