//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

class Array {
  public:
    template <class T>
    static void input(vector<T> &A, int n) {
        for (int i = 0; i < n; i++) {
            scanf("%d ", &A[i]);
        }
    }

    template <class T>
    static void print(vector<T> &A) {
        for (int i = 0; i < A.size(); i++) {
            cout << A[i] << " ";
        }
        cout << endl;
    }
};


// } Driver Code Ends

class Solution {
  public:
    vector<int> getPrimes(int n) {
        // code here
        vector<bool>blackbox(n+1,true);
        blackbox[0]=blackbox[1]=false;
        for( int i=2 ; i*i<=n ;i++)
        {
            if(blackbox[i])
            {
                for(int j=i*i ;j<=n ; j+=i)
                {
                    blackbox[j]=false;
                }
            }
        }
        vector<int> ans;
        for( int i=2;i<=n;i++)
        {
         if(blackbox[i])
           ans.push_back(i);
        }
        int l=0;
        int N=ans.size();
        int r=N-1;
        while(l<=r)
        {
            if((ans[l]+ans[r])<n)
            {
                l++;
            }
            else if ((ans[l]+ans[r])>n)
            {
                r--;
            }
            else
            {
                return {ans[l],ans[r]};
            }
        }
        return {-1,-1};   
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        int n;
        scanf("%d", &n);

        Solution obj;
        vector<int> res = obj.getPrimes(n);

        Array::print(res);
    }
}

// } Driver Code Ends