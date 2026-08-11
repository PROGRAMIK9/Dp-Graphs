class Solution {
    public int missingInteger(int[] nums) {
        int max_sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]+1) max_sum += nums[i];
            else break;
            // max_sum = Math.max(sum, max_sum);
        }
        Set set = new HashSet<>();
        for(int num: nums) set.add(num);
        while(set.contains(max_sum)) max_sum++;
        return max_sum;
    }
}