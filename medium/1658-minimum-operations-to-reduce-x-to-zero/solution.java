class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int res = -x;
        for(int num : nums){
            res += num; 
        } 

        if( res < 0 ) return -1;
        if( res == 0 ) return n;

        int best = -1, i = 0, s = 0;
        for(int j = 0; j < n; j++){
            s += nums[j];
            while( s > res ){
                s -= nums[ i++ ];
            }
            if(s == res) best = Math.max( best, j - i + 1 );
        }
        return best < 0 ? -1 : n - best;
    }
}