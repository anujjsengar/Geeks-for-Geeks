import java.util.*;

class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < V; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            //graph.get(edge[1]).add(edge[0]);
        }
        int dp[]=new int[V];
        Arrays.fill(dp,-1);
        HashSet<Integer> visited = new HashSet<>();
        return count(src, dest, graph, visited,dp);
    }

    private int count(int src, int dest, HashMap<Integer, HashSet<Integer>> graph, HashSet<Integer> visited,int dp[]) {
        if (src == dest) return 1;
        if(dp[src]!=-1){
            return dp[src];
        }
        visited.add(src);
        int totalPaths = 0;
        for (int neighbor : graph.get(src)) {
            if (!visited.contains(neighbor)) {
                totalPaths += count(neighbor, dest, graph, visited,dp);
            }
        }
        visited.remove(src);
        return dp[src]=totalPaths;
    }
}
