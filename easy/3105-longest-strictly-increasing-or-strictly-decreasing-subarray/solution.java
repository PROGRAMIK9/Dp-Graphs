class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int min_length = 1;
        int up = 1, down =1;
        for(int i = 1; i < nums.length; i++){
            up = nums[i-1] < nums[i] ? up+1 : 1;
            down = nums[i] < nums[i-1] ? down+1: 1;
            min_length = Math.max(min_length, Math.max(up, down));
        }
        return min_length;
    }
}