class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = nums1[0], odd = 0;
        for(int num: nums1){
            min = Math.min(min, num);
            odd |= num & 1;
        }
        return (min & 1) == odd;
    }
}