class Solution {
    public int longestSubsequence(int[] nums) {
        int val  = 0;
        int n = nums.length;
        boolean nonZero = false;
        for(int num:nums){
            nonZero |= num>0;
        }
    }
            val ^= num;
        if(!nonZero) return 0;
        return val == 0? n-1 : n;
}
