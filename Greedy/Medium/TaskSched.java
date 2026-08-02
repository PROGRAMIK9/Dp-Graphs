class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];

        for(char c: tasks){
            freq[c-'A']++;
        }
        int maxval = Integer.MIN_VALUE;
        for(int val:freq){
            maxval = Math.max(maxval, val);
        }
        int count = 0;
        for(int val:freq){
            if(val==maxval) count++;
        }
        return Math.max(tasks.length, ((maxval-1)*(n+1)+(count)));
    }
}
