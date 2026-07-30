class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int i  =0; i < pre.length; i++){
            int u = pre[i][0];
            int v = pre[i][1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i  = 0; i < numCourses; i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        int[] result = new int[numCourses];
        int i = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            result[i++]=node;
            for(int neigh : adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh] == 0) queue.add(neigh);
            }
        }
        // for(int in: indegree){
        //     if(in > 0) return new int[]{};
        // }
        // return result;
        return i == numCourses ? result : new int[]{};       
    }
}
