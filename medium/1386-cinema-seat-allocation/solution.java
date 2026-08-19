class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rows = new HashMap<>();
        for(int[] seat: reservedSeats){
            int row = seat[0];
            int col = seat[1];
            if(col >= 2 && col <= 9){
                int current = rows.getOrDefault(row, 0);
                if(col >= 2 && col <= 5) current |= 1;
                if(col >=4 && col <=7) current |= 2;
                if(col >=6 && col <= 9) current |=4; 
                rows.put(row, current);
            }
        }
        int maxGroups  = (n-rows.size())* 2;
        for(int val: rows.values()){
            if((val & 5) == 0) maxGroups+=2;
            else if ((val & 1) == 0 || (val & 2) == 0 || (val & 4) == 0) {
                maxGroups += 1;
            }
        }
        return maxGroups;
    }
}