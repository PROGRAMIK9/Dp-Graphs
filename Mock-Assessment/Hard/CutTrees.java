class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest == null || forest.size() == 0) return 0;
        int row = forest.size();
        int col = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for(int i = 0; i < row; i++){
            for(int j = 0; j <col; j++){
                int val = forest.get(i).get(j);
                if(val>1){
                    pq.add(new int[]{i, j, val});
                }
            }
        }
        int[] start = {0,0};
        int shortestPath=0;
        while(!pq.isEmpty()){
            int[] target = pq.poll();
            int steps = bfs(forest, target, start, row, col);
            if(steps == -1)return -1;
            shortestPath += steps;
            start[0] = target[0];
            start[1] = target[1];
        }
        return shortestPath;
    }
    private int bfs(List<List<Integer>> forest, int[] target, int[] start, int row, int col){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        int[][] dir ={{0,-1},{0,1},{1,0},{-1,0}};
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int steps = curr[2];
            if(r == target[0] && c == target[1]) return steps;
            for(int[] d: dir){
                int nx = d[0]+r;
                int ny = d[1]+c;
                if(nx >= 0 && ny >= 0 && nx < row && ny < col){
                    if(!visited[nx][ny] && forest.get(nx).get(ny)!=0){
                        visited[nx][ny]=true;
                        queue.add(new int[]{nx,ny,steps+1});
                    }
                }
            }
        }
        return -1;
    }
}
