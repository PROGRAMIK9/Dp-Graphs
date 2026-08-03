class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right;
        int[] freq = new int[26];
        int n =  s.length();
        int maxfreq = 0;
        int maxlength = 0;
        for(right = 0; right < n; right++){
            int index = s.charAt(right)-'A';
            freq[index]++;
            maxfreq = Math.max(maxfreq,freq[index]);
            while((right-left+1)-maxfreq > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxlength = Math.max(maxlength, (right-left+1));
        }
        return maxlength;
    }
}
