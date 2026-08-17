class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n =  nums.length;
        int i = 0, j = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(j < n){
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            while(map.get(nums[j])>k){
                int val = map.get(nums[i])-1;
                map.put(nums[i], val);
                i++;
            }
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }
        return maxLen;
    }
}