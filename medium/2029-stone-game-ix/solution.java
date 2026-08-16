class Solution {
    public boolean stoneGameIX(int[] stones) {
        int n = stones.length;
        int cz = 0, co = 0, ct = 0;
        for(int stone: stones){
            if(stone%3 == 0) cz++;
            else if(stone%3 == 1) co++;
            else ct++;
        }
        if(cz%2 == 0){
            return co > 0 && ct > 0;
        }else{
            return Math.abs(co-ct) > 2;
        }
    }
}