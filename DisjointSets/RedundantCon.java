class Solution {
    int[] parent;
    public int find(int node){
        if(parent[node] == node) return node;
        return find(parent[node]);
    }
    public int[] findRedundantConnection(int[][] edges) {
       int n = edges.length;
       parent = new int[edges.length+1];
       for(int i =1; i< n+1; i++){
        parent[i]=i;
       }
       for(int[] edge:edges){
        int u = edge[0];
        int v = edge[1];
        int pu = find(u);
        int pv = find(v);
        if(pu==pv) return edge;
        else parent[pv]=pu;
       }
       return new int[0];
    }
}
