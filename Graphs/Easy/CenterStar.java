class Solution {
    public int findCenter(int[][] edges) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i = 0; i < edges.length; i++){
        //     for(int j  = 0; j <edges[i].length; j++){
        //         map.put(edges[i][j], map.getOrDefault(edges[i][j],0)+1);
        //     }
        // }
        // for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        //     System.out.println(entry.getValue() + " " + entry.getKey());
        //     if(entry.getValue() == edges.length) return entry.getKey();
        // }
        // return -1;
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) return edges[0][0];
        return edges[0][1];
    }
}
