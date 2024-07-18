//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited=new boolean[V];
        boolean[] stack=new boolean[V];
        for(int i=0;i<V;i++){
           if(cycle(adj,V,i,visited,stack)){
               return true;
           }
        }
        return false;
    }
    public boolean cycle(ArrayList<ArrayList<Integer>> adj,int V,int S,boolean[] visited,boolean[] stack){
         visited[S] = true;
         stack[S]=true;
        for(Integer n:adj.get(S)){
            if(!visited[n] && cycle(adj,V,n,visited,stack)){
                return true;
            }
            if(stack[n]){
                return true;
            }
        }
        stack[S]=false;
        return false;
    }
}