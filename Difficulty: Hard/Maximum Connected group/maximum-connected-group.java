//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {

    public int MaxConnection(int grid[][]) {
        // Your code here
        int n = grid[0].length;
        UnionFind uf = new UnionFind(n*n);
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==1){
                    
                    int cellValue = n*j + i;
                    
                    for(int[] dir : dirs){
                        int nx = dir[0] + i;
                        int ny = dir[1] + j;
                        
                        if(isValid(nx,ny,n) || grid[nx][ny]==0)
                        continue;
                        
                        int neighBourCellValue = n*ny + nx;
                        
                        uf.union(cellValue,neighBourCellValue);
                    }
                }
            }
        }
        
        int max = 0;
        
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]==0){
                    int cellValue = n*j + i;
                    int cellSize = 1;
                    Set<Integer> visited = new HashSet<>();
                    
                    for(int[] dir : dirs){
                        int nx = dir[0] + i;
                        int ny = dir[1] + j;
                        
                        if(isValid(nx,ny,n) || grid[nx][ny]==0)
                        continue;
                        
                        int neighBourCellValue = n*ny + nx;
                        int parent = uf.findPar(neighBourCellValue);
                        
                        if(visited.contains(parent))
                        continue;
                        
                        visited.add(parent);
                        
                        int size = uf.size(parent);
                        cellSize += size;
                    }
                    
                    max = Math.max(max,cellSize);
                }
            }
        }
        
        return Math.max(max,uf.maxSize());
    }
    private boolean isValid(int i,int j,int n){
        return (i<0 || j<0 || i>=n || j>=n);
    }
}

class UnionFind{
    int[] par,size;
    
    public UnionFind(int n){
        par = new int[n];
        size = new int[n];
        
        for(int i=0;i<n;++i){
            par[i] = i;
            size[i] = 1;
        }
    }
    
    public int findPar(int u){
        if(u==par[u])
        return u;
        
        return par[u] = findPar(par[u]);
    }
    
    public void union(int x,int y){
        int parx = findPar(x);
        int pary = findPar(y);
        
        if(parx==pary)
        return;
        
        if(size[parx] > size[pary]){
            par[pary] = parx;
            size[parx] += size[pary];
        }
        else{
            par[parx] = par[pary];
            size[pary] += size[parx];
        }
    }
    
    public int size(int cellValue){
        return size[cellValue];
    }
    
    public int maxSize(){
        int max = 0;
        
        for(int a : size)
        max = Math.max(a,max);
        
        return max;
    }
}