class Solution {
    public int[] resultArray(int[] nums) {
         List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        boolean first = arr1.get(0)>arr2.get(0)? true: false;
        int a = 0, b = 0;
        for(int i = 2; i < nums.length; i++){
            if(first){
                arr1.add(nums[i]);
            }else{
                arr2.add(nums[i]);
            }
            first = arr1.get(arr1.size()-1)>arr2.get(arr2.size()-1)?true:false;
        }
        int i = 0;
        int[] res = new int[nums.length];
        for(int x: arr1) res[i++] = x; 
        for(int x: arr2) res[i++] = x;
        return res;
    }
}