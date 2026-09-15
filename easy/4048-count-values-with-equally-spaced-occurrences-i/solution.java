class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        HashSet<Integer> set =  new HashSet<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 3){
                set.add(entry.getKey());
            }
            System.out.println(entry.getKey());
        }
        int prev = -1, curr = -1, diff = 0, ans = 0;
        for(int num: set){
            for(int i = 0; i < nums.length; i++){
                if(num == nums[i])
                {
                    prev = curr;
                    curr = i;
                    if(diff == curr-prev) ans++;
                    if(prev!=-1)diff = curr-prev;
                    System.out.println(prev+" "+curr+" "+diff);
                }
            }
            prev = -1; curr = -1; diff = 0;
        }
        return ans;
    }
}