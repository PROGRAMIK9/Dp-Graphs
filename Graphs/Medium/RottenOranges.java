class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int rotten = 0;
        int total = 0;
        int days = 0;
        Queue<int[]> rottenq = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j  = 0; j < n; j++){
                if(grid[i][j] != 0) total++;
                if(grid[i][j] == 2) rottenq.offer(new int[]{i,j});
            }
        }
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        while(!rottenq.isEmpty()){
            int k = rottenq.size();
            rotten += k;
            for(int i = 0; i < k; i++){
                int[] loc = rottenq.poll();
                int r = loc[0];
                int c = loc[1];
                for(int j = 0; j < 4; j++){
                    int nx = r + dx[j];
                    int ny = c + dy[j];
                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 1) continue;
                    grid[nx][ny] = 2;
                    rottenq.add(new int[]{nx,ny});
                }  
            }
            if(!rottenq.isEmpty()) days++;
        }
        return total == rotten? days : -1;
    }
}
