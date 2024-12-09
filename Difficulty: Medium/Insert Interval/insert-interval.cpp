//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    vector<vector<int>> insertInterval(vector<vector<int>> &intervals,
                                       vector<int> &newInterval) {
        // code here
         vector<vector<int>> temp;
        bool flag=false;
        for(int i=0;i<intervals.size();i++){
            if(!flag && newInterval[0] <= intervals[i][0]){
                temp.push_back(newInterval);
                flag=true;
                i--;
            }else{
                temp.push_back(intervals[i]);
            }
        }
        
        if(flag == false){
            temp.push_back(newInterval);
        }
        
        vector<vector<int>> ans;
        vector<int> val;
        val.push_back(temp[0][0]);
        val.push_back(temp[0][1]);
        
        for(int i=1;i<temp.size();i++){
            if(val[1] >= temp[i][0]){
                val[1]=max(val[1],temp[i][1]);
            }else{
                ans.push_back(val);
                val=temp[i];
            }
        }
        ans.push_back(val);
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        vector<vector<int>> intervals(N, vector<int>(2));
        for (int i = 0; i < N; i++) {
            cin >> intervals[i][0] >> intervals[i][1];
        }
        vector<int> newInterval(2);
        cin >> newInterval[0] >> newInterval[1];

        Solution obj;
        vector<vector<int>> ans = obj.insertInterval(intervals, newInterval);
        cout << "[";
        for (int i = 0; i < ans.size(); i++) {
            cout << "[" << ans[i][0] << ',' << ans[i][1] << ']';
            if (i != (ans.size() - 1))
                cout << ",";
        }
        cout << "]" << endl;

        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends