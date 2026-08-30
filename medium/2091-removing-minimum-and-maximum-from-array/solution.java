class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max =  Integer. MIN_VALUE;
        int max_dist = 0;
        int min_dist = 0;
        int n = nums.length;
        boolean start = false;
        for(int i = 0; i < n; i++){
            if(nums[i] > max ){
                max = nums[i];
                max_dist = i;
            }
            if(nums[i] < min){
                min=nums[i];
                min_dist = i;
            }
        }
        max = Math.max(min_dist, max_dist);
        min = Math.min(min_dist, max_dist);
        System.out.println(max+" "+min);
        int distance = Math.min(
            max+1,
            Math.min(
                n - min,
                (min+1)+(n-max)
            )
        );
        return distance;
    }
}