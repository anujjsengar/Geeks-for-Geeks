// User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        HashMap<Integer,HashSet<Integer>> graph=new HashMap<>();
        for(int i=1;i<=V;i++){
            graph.put(i,new HashSet<>());
        }
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<V;j++){
                if(i!=j && adj.get(i).get(j)==1){
                    graph.get(i+1).add(j+1);
                    graph.get(j+1).add(i+1);
                }
            }
        }
        return solve(graph);
    }
    static int solve(HashMap<Integer,HashSet<Integer>> graph){
        HashSet<Integer> map=new HashSet<>();
        int count=0;
        for(int i=1;i<=graph.size();i++){
            if(map.contains(i)){
                continue;
            }
            count++;
            Queue<Integer> q=new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()){
                int curr=q.poll();
                if(map.contains(curr)){
                    continue;
                }
                map.add(curr);
                for(int neigh:graph.get(curr)){
                    if(!map.contains(neigh)){
                        q.add(neigh);
                    }
                }
            }
        }
        return count;
    }
};