class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target) return 0;
        if(stations == null || stations.length == 0) return -1;
        int n = stations.length;
        // Arrays.sort(stations, (a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int stops = 0;
        int p = 0;
        for(int i = 0; i < n; i++){
            while(p < n && startFuel>=stations[p][0]){
                pq.add(stations[p][1]);
                p++;
            }
            if(pq.isEmpty()) return -1;
            startFuel += pq.poll();
            stops++;
            if(startFuel >= target) return stops;
        }
        return startFuel < target? -1 : stops;
    }
}
