//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    private void topologicalSort(int node, boolean[] visited, Stack<Integer> stack, List<List<int[]>> adj) {
        visited[node] = true;
        
        for (int[] neighbor : adj.get(node)) {
            int v = neighbor[0];
            if (!visited[v]) {
                topologicalSort(v, visited, stack, adj);
            }
        }
        
        stack.push(node);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, stack, adj);
            }
        }
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            
            if (dist[node] != Integer.MAX_VALUE) {
                for (int[] neighbor : adj.get(node)) {
                    int v = neighbor[0];
                    int weight = neighbor[1];
                    
                    if (dist[node] + weight < dist[v]) {
                        dist[v] = dist[node] + weight;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        
        return dist;
    }

	
	
}
