class Solution {
    public int countSpecialIntegers(int[] nums) {

        HashMap<Integer, int[]> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (!map.containsKey(num)) {
                map.put(num, new int[]{1, i, -1, 1});
            } else {
                int[] a = map.get(num);

                int gap = i - a[1];

                if (a[2] == -1) {
                    a[2] = gap;
                } else if (a[2] != gap) {
                    a[3] = 0;
                }

                a[1] = i;
                a[0]++;
            }
        }

        int ans = 0;

        for (int[] a : map.values()) {
            if (a[0] >= 3 && a[3] == 1) {
                ans++;
            }
        }

        return ans;
    }
}