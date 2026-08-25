class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int val = 1;
        while(set.contains(val*k)){
            val++;
        }
        return k*val;
    }
}