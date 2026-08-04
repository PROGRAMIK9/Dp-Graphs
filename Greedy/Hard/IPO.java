class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for(int i = 0; i < n; i++){
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, (a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int ptr = 0;
        for(int i = 0; i < k; i++){
            while(ptr < n && projects[ptr][0]<=w){
                pq.add(projects[ptr][1]);
                ptr++;
            }
            if(pq.isEmpty()) break;
            w+=pq.poll();
        }
        return w;
    }
}
