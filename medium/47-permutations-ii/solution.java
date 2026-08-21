class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean used[] = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        return perm(nums, used, new ArrayList<>(), res);
    }
    private List<List<Integer>> perm(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return res;
        }
        for(int i = 0; i < nums.length; i++){
            if (used[i]) continue;
            
            // 3. Skip duplicates: if the item matches the prior item, and the prior item 
            // has not been processed in this exact path branch, skip it to avoid cloning paths.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            
            // Backtracking steps
            used[i] = true;
            curr.add(nums[i]);
            
            perm(nums, used, curr, res);
            
            // Undo for the next branch evaluation
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
        return res;
    }
}